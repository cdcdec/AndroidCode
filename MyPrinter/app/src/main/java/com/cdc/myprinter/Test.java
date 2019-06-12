package com.cdc.myprinter;

public class Test {
    public static void main(String [] strings){
        String[] goodsNames = SubByteString.getSubedStrings("娃哈哈营养快线椰子味350ml", 10);
        for(int i=0;i<goodsNames.length;i++){
            System.out.println(goodsNames[i]);
        }
    }
}
