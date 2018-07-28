package com.mobileai.dxc.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    /**
     * 
     * 使用MD5算法对密码进行加密
     * 
     */

    public static String md5(String initpassword) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(initpassword.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        String secretpassword = new BigInteger(1,secretBytes).toString(16);
        for(int i=0;i<32-secretpassword.length();i++){
            secretpassword = "0"+secretpassword;
        }

        return secretpassword;
    }
}