package com.zgjt.yqsl.controller;

import com.zgjt.yqsl.config.ContentConfig;
import com.zgjt.yqsl.config.IpConfiguration;
import com.zgjt.yqsl.execption.MyExecption;
import com.zgjt.yqsl.response.ResponseApi;
import com.zgjt.yqsl.utils.FilesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fileOperate")
public class FileUploadController {

    @Autowired
    private IpConfiguration ip;

    @Autowired
    private ContentConfig contentConfig;

    @PostMapping("/fileUpload")
    public ResponseApi fileUpload(MultipartFile file) throws UnknownHostException {
        if (file == null || file.isEmpty()) {
            throw new MyExecption(20001, "上传文件为空！");
        }
        String contentType = file.getContentType();
        List<String> types = new ArrayList<String>();
        types.add("image/jpeg");
        types.add("image/png");
        types.add("image/gif");
        if (!types.contains(contentType)) {
            throw new MyExecption(20001, "上传失败！不允许上传此类型的文件！");
        }
        String fileName = file.getOriginalFilename();
        fileName = FilesUtil.getFileName(fileName);

        String directory = "fileUpload";
        String filePath = FilesUtil.getUploadPath(directory);

        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File( File.separator + filePath + File.separator + fileName)));
            out.write(file.getBytes());
            out.flush();
        } catch (FileNotFoundException e) {
            throw new MyExecption(20001,"上传文件失败 文件找不到");
        } catch (IOException e) {
            throw new MyExecption(20001,"上传文件失败");
        }

        return ResponseApi.sucess().data("imageUrl","http://" + InetAddress.getLocalHost().getHostAddress() + ":" + ip.getPort() + File.separator + contentConfig.getContentPath() + File.separator + directory + File.separator + fileName);
    }



}
