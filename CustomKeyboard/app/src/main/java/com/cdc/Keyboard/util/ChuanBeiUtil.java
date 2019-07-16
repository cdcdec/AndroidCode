package com.cdc.keyboard.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ChuanBeiUtil {
    //加密密码
    public static String change(String paramString){
        StringBuilder stringBuilder = new StringBuilder();
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(paramString.getBytes());
        byte[] arrayOfByte = messageDigest.digest();
        for (byte b = 0; b < arrayOfByte.length; b++) {
            if ((arrayOfByte[b] & 0xFF) < 16)
                stringBuilder.append("0");
            stringBuilder.append(Long.toString((arrayOfByte[b] & 0xFF), 16));
        }
        return stringBuilder.toString();
    }


}
