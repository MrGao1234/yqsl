package com.zgjt.yqsl.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zgjt.yqsl.entity.GoodsMsg;
import com.zgjt.yqsl.entity.GoodsMsgKey;
import com.zgjt.yqsl.entity.GoodsMsgValue;
import com.zgjt.yqsl.mapper.GoodsMsgKeyMapper;
import com.zgjt.yqsl.mapper.GoodsMsgMapper;
import com.zgjt.yqsl.mapper.GoodsMsgValueMapper;
import com.zgjt.yqsl.mapper.GoodsTypeMapper;
import com.zgjt.yqsl.service.GoodsMsgService;
import com.zgjt.yqsl.vo.PageVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author admin
 */
@Service
@Slf4j
public class GoodsMsgServiceImpl extends ServiceImpl<GoodsMsgMapper,GoodsMsg> implements GoodsMsgService {

    @Autowired
    private GoodsMsgMapper goodsMsgMapper;

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    @Autowired
    private GoodsMsgKeyMapper goodsMsgKeyMapper;

    @Autowired
    private GoodsMsgValueMapper goodsMsgValueMapper;

    /**
     * 查询商品列表
     */
    @Override
    public IPage<GoodsMsg> findGoodsMsg(@RequestBody PageVo pageVo){

        IPage<GoodsMsg> page = new Page<>(pageVo.getPageNumber(),pageVo.getPageSize());
        page.setRecords(goodsMsgMapper.findGoods(pageVo,page));

        return page;
    }


    /**
     * 根据商品 id 查询商品属性
     * */
    @Override
    public List<GoodsMsgKey> findGoodsAttributes(int goodsId) {
        return goodsMsgMapper.findAttributesByGoodsId(goodsId);
    }


    /**
     * 新增
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveGoodsMsg(GoodsMsg goodsMsg) {

        goodsMsgMapper.insert(goodsMsg);
        log.info("goods insert successful !");

        List<GoodsMsgValue> values = new ArrayList<>();
        List<GoodsMsgKey> attributeList = goodsMsg.getAttributes();
        for(GoodsMsgKey key : attributeList){

            String keyId = UUID.randomUUID().toString().replace("-","");
            key.setId(keyId);
            key.setGoodsMsgId(goodsMsg.getId());
            Date date = new Date();
            key.setCreateTime( date );
            key.setUpdateTime( date );

            List<GoodsMsgValue> valueList = key.getValueList();
            for( GoodsMsgValue value : valueList ){
                value.setId(UUID.randomUUID().toString().replace("-",""));
                value.setGoodsMsgKeyId(keyId);
                value.setCreateTime( date );
                value.setUpdateTime( date );
            }
            values.addAll( key.getValueList() );
        }

        int valueNum = goodsMsgKeyMapper.insertGoodsMsgKey( attributeList );
        log.info("insert goodsValue {} !", valueNum);

        int keyNum = goodsMsgValueMapper.insertGoodsMsgValue( values );
        log.info("insert goodsKey {} ！", keyNum);

        return true;
    }
}
