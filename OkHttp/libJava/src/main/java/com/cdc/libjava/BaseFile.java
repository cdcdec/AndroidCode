package com.cdc.libjava;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class BaseFile {
    public static void main(String[] args) {
        try {
            createDimens();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createDimens() throws IOException {
        File file=new File("E:/dimens_350.xml");
        if(!file.exists()){
            file.createNewFile();
        }
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        out.write("<resources>");
        out.write("\r\n");
        Double scale=Double.parseDouble("350.000000")/Double.parseDouble("350.000000");

        System.out.println(scale);
        float ii=0f;
        for(int i=1;i<=350;i++){
            out.write("<dimen name=\"dp"+i+"\">");

            //out.write(i*scale+"dp");
            out.write(i+"dp");
            out.write("</dimen>");
            out.write("\r\n");
        }

        for(int j=1;j<=350;j++){
            out.write("<dimen name=\"sp"+j+"\">");

            out.write(j+"dp");
            out.write("</dimen>");
            out.write("\r\n");
        }



        out.write("</resources>");
        out.close();
        System.out.println("file create success");
    }
}
