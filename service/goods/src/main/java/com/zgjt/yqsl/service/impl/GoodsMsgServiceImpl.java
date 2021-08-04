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
import java.util.List;

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

        //goodsMsgMapper.findAttributesByGoodsId(1);

        return page;
    }

    /**
     * 新增
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveGoodsMsg(GoodsMsg goodsMsg) {

        List<GoodsMsgValue> values = new ArrayList<>();
        List<GoodsMsgKey> attributeList = goodsMsg.getAttributes();
        for(GoodsMsgKey key : attributeList){
            key.setGoodsMsgId(goodsMsg.getId());
            values.addAll( key.getValueList() );
        }

        int keyNum = goodsMsgValueMapper.insertGoodsMsgValue( values );
        log.info("insert goodsKey {} ！", keyNum);
        int valueNum = goodsMsgKeyMapper.insertGoodsMsgKey( attributeList );
        log.info("insert goodsValue {} !", valueNum);
        goodsMsgMapper.insert(goodsMsg);
        log.info("goods insert successful !");

        return true;
    }
}
