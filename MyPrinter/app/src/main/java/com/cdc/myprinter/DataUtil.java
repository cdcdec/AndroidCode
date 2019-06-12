package com.cdc.myprinter;

import android.util.Log;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DataUtil {

    public static GoodsListInfo getGoodListInfo() {
        GoodsListInfo goodsListInfo = new GoodsListInfo();
        List<GoodInfo> goodInfoList=new ArrayList<>();
        GoodInfo goodInfo1 = new GoodInfo();
        goodInfo1.setName("娃哈哈营养快线椰子味350ml*15瓶");
        goodInfo1.setPrice(36.06f);
        goodInfo1.setNum(8);
        goodInfo1.setAmount(getFloatString(goodInfo1.getPrice()*goodInfo1.getNum()));
        goodInfo1.setUnit("箱");
        goodInfoList.add(goodInfo1);





        GoodInfo goodInfo2 = new GoodInfo();
        goodInfo2.setName("娃哈哈营养快线450ml*15瓶");
        goodInfo2.setPrice(45.08f);
        goodInfo2.setNum(13);
        goodInfo2.setAmount(getFloatString(goodInfo2.getPrice()*goodInfo2.getNum()));
        goodInfo2.setUnit("箱");
        goodInfoList.add(goodInfo2);


        GoodInfo goodInfo3 = new GoodInfo();
        goodInfo3.setName("康师傅新经典香辣牛肉桶面108克*12桶");
        goodInfo3.setPrice(36.60f);
        goodInfo3.setNum(11);
        goodInfo3.setAmount(getFloatString(goodInfo3.getPrice()*goodInfo3.getNum()));
        Log.e("123",(goodInfo3.getPrice()*goodInfo3.getNum())+"");
        goodInfo3.setUnit("箱");
        goodInfoList.add(goodInfo3);








        goodsListInfo.setListGoodInfo(goodInfoList);




        goodsListInfo.setSubsidy("10.00");

        float sumAmount=0.0f;

        for(int j=0;j<goodInfoList.size();j++){
            sumAmount=sumAmount+Float.parseFloat(goodInfoList.get(j).getAmount());
        }
        goodsListInfo.setAmount(sumAmount+"");
        goodsListInfo.setOrderAmount((sumAmount-Float.parseFloat(goodsListInfo.getSubsidy()))+"");
        return goodsListInfo;
    }

    private static String getFloatString(float fl){
        DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
        String p=decimalFormat.format(fl);//format 返回的是字符串
        return  p;
    }
}
