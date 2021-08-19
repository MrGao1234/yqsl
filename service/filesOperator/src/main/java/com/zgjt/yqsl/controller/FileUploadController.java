package com.zgjt.yqsl.controller;

import com.zgjt.yqsl.config.ContentConfig;
import com.zgjt.yqsl.execption.MyExecption;
import com.zgjt.yqsl.response.ResponseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fileOperate")
public class FileUploadController {

    @Autowired
    private ContentConfig contentConfig;

    @GetMapping("/test")
    public String test(){
        return "测试是是是";
    }

    @PostMapping("/fileUpload")
    public ResponseApi fileUpload(MultipartFile file) {
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
        fileName = getFileName(fileName);

        String filePath = getUploadPath();


        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(filePath + File.separator + fileName)));
            out.write(file.getBytes());
            out.flush();
        } catch (FileNotFoundException e) {
            throw new MyExecption(20001,"上传文件失败 文件找不到");
        } catch (IOException e) {
            throw new MyExecption(20001,"上传文件失败");
        }

        return ResponseApi.sucess().data("imageUrl", contentConfig.getContentPath() + '/' + fileName);
    }

    private String getFileName(String fileName) {
        int index = fileName.lastIndexOf(".");
        fileName = fileName.substring(0, index) + "_" + System.currentTimeMillis() + fileName.substring(index);
        return fileName;
    }

    //获取路径
    public static String getUploadPath(){
        File file = new File("");
        File upload = new File(file.getAbsolutePath(), "/upload/");
        if( !upload.exists() && !upload.isDirectory() ){
            upload.mkdirs();
        }
        return upload.getAbsolutePath();
    }

}
