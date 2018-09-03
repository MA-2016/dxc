package com.mobileai.dxc.util;

/**
 * 图片地址处理工具类
 * 
 * 
 */


public class PathUtil{
    private static String seperator = System.getProperty("file.separator");

    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath = "D:/dxc/picture/";
        }else{
            basePath = "/home/dxc_pic/image";
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }
}