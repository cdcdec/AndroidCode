package com.cdc.java_test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class CreateFile {

    private static String path1="./app/src/main/res/values/testXml.xml";
    private static String path2="./app/src/main/res/values/testTxt.txt";
    private static String xmlTop="<?xml version=\"1.0\" encoding=\"utf-8\"?>";

    /**
     * 文件不存在时  会自动创建文件
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public static void createFile1() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(path1, "UTF-8");
        writer.println(xmlTop);
        writer.close();
    }

    public static void createFile2() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(path2, "UTF-8");
        writer.println("The first line");
        writer.println("The second line");
        writer.close();
    }

    public static void main(String[] strings) throws FileNotFoundException, UnsupportedEncodingException {
        createFile1();
        createFile2();
    }

}
