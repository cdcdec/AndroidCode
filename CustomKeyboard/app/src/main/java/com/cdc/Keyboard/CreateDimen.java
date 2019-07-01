package com.cdc.Keyboard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateDimen {
    private static void createDimens() throws IOException{
        File file=new File("E:/dimens_640.xml");
        if(!file.exists()){
            file.createNewFile();
        }
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        out.write("<resources>");
        out.write("\r\n");
        Double scale=Double.parseDouble("640.000000")/Double.parseDouble("960.000000");

        System.out.println(scale);
        float ii=0f;
        for(int i=1;i<=960;i++){
            out.write("<dimen name=\"dp"+i+"\">");

            out.write(i*scale+"dp");
            out.write("</dimen>");
            out.write("\r\n");
        }


        for(int i=1;i<=50;i++){
            out.write("<dimen name=\"sp"+i+"\">");

            out.write(i*scale+"sp");
            out.write("</dimen>");
            out.write("\r\n");
        }

        out.write("</resources>");
        out.close();
        //System.out.println("文件创建成功！");
    }

//    public static void main(String[] args)  {
//        try {
//            createDimens();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}

