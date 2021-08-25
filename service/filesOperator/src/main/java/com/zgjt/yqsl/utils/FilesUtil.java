package com.zgjt.yqsl.utils;

import java.io.File;

/**
 * 文件操作工具类
 *
 * @author admin
 * */
public class FilesUtil {

    public static String getFileName(String fileName) {
        int index = fileName.lastIndexOf(".");
        fileName = fileName.substring(0, index) + "_" + System.currentTimeMillis() + fileName.substring(index);
        return fileName;
    }

    //获取路径
    public static String getUploadPath(String directory){
        System.out.println(File.separator);

        File file = new File("");
        String path;
        if(directory == null || directory.equals("")){
            path = "upload";
        }else{
            path = "upload" + File.separator + directory;
        }
        File upload = new File(file.getAbsolutePath(), path);
        if( !upload.exists() && !upload.isDirectory() ){
            upload.mkdirs();
        }
        return upload.getAbsolutePath() + File.separator;
    }
}
