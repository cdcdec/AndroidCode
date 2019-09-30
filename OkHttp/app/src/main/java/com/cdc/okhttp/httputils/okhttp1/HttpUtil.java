package com.cdc.okhttp.httputils.okhttp1;

import android.util.Base64;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class HttpUtil{
    private String iv = "zzwbkj68";//虚拟的 iv (需更改)
    private IvParameterSpec ivspec;
    private SecretKeySpec keyspec;
    private Cipher cipher;

    public HttpUtil() {
        ivspec = new IvParameterSpec(iv.getBytes());
    }

    /**
     * 加密
     *
     * @param map 需要加密的map
     * @param key 加密用的key
     * @return
     */
    public String encrypt(Map map, String key) {
        keyspec = new SecretKeySpec(key.getBytes(), "BLOWFISH");
        Gson gson = new Gson();
        byte[] b = null;
        try {
            b = encrypt(gson.toJson(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return base64Encode(b);
    }

    private byte[] encrypt(String text) throws Exception {
        if (text == null || text.length() == 0)
            throw new Exception("Empty string");

        byte[] encrypted = null;

        try {
            cipher = Cipher.getInstance("BLOWFISH/CBC/PKCS5Padding");//填充
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);

            encrypted = cipher.doFinal(padString(text).getBytes());
        } catch (Exception e) {
            throw new Exception("[encrypt] " + e.getMessage());
        }

        return encrypted;
    }

    private static String padString(String source) {
        char paddingChar = ' ';
        int size = 16;
        int x = source.length() % size;
        int padLength = size - x;

        for (int i = 0; i < padLength; i++) {
            source += paddingChar;
        }
        return source;
    }

    /**
     * 解密
     *
     * @param info 需要解密的文本
     * @param key  解密所需的key
     * @return
     * @throws Exception
     */
    public String decrypt(String info, String key) throws Exception {
        keyspec = new SecretKeySpec(key.getBytes(), "BLOWFISH");
        byte[] bb = base64Decode(info);
        return new String(decrypt(bb));
    }


    private byte[] decrypt(byte[] code) throws Exception {
        byte[] decrypted = null;
        try {
            cipher = Cipher.getInstance("BLOWFISH/CBC/NOPadding");//不填充，输入只能是8bytes的位数
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            decrypted = cipher.doFinal(code);
        } catch (Exception e) {
            throw new Exception("[decrypt] " + e.getMessage());
        }
        return decrypted;
    }



    //编码
    private  String base64Encode(byte[] content){
        return Base64.encodeToString(content, Base64.DEFAULT);//NO_WRAP 不换行
    }
    //解码
    private  byte[] base64Decode(String base) throws UnsupportedEncodingException {
        byte[] decodeStringBytes = Base64.decode(base.getBytes(), Base64.DEFAULT);
        return  decodeStringBytes;
    }



    /**
     * 将Map集合转到Param数组中
     * @param params
     * @return
     */
    public Param[] mapToParams(Map<String, String> params) {
        if (params == null)
            return new Param[0];
        int size = params.size();
        Param[] res = new Param[size];
        Set<Map.Entry<String, String>> entries = params.entrySet();
        int i = 0;
        for (Map.Entry<String, String> entry : entries) {
            res[i++] = new Param(entry.getKey(), entry.getValue());
        }
        return res;
    }

}
