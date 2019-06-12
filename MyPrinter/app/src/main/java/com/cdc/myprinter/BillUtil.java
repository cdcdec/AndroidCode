package com.cdc.myprinter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;
import com.gprinter.aidl.GpService;
import com.gprinter.command.EscCommand;
import com.gprinter.command.GpCom;
import com.gprinter.command.GpUtils;
import java.util.Vector;
/**
 * https://blog.csdn.net/haha223545/article/details/80569597
 */
public class BillUtil {
    private static final String PRINT_LINE = "--------------------------------\n";

    public static final short PRINT_UNIT2 = 7;
    public static final short PRINT_POSITION2_1 = 6;
    public static final short PRINT_POSITION2_2 = 9;
    public static final short PRINT_POSITION2_3 = 13;

    public static void createBill(GpService mGpService, Context context,GoodsListInfo goodsInfo){
        EscCommand esc = new EscCommand();
        esc.addInitializePrinter();
        // 顶部图片
      esc.addSelectJustification(EscCommand.JUSTIFICATION.CENTER);
        Bitmap b = BitmapFactory.decodeResource(context.getResources(), R.drawable.gprinter);
        esc.addRastBitImage(b, 384, 0); // 打印图片
        esc.addPrintAndLineFeed();
        esc.addText(PRINT_LINE);

        // 商品头信息
        esc.addSetHorAndVerMotionUnits((byte) PRINT_UNIT2, (byte) 0);// 设置单位距离
        esc.addText("商品名");

        esc.addSetAbsolutePrintPosition(PRINT_POSITION2_1);// 移动的距离（距离 = 单位 * position设定值)
        esc.addText("单价");

        esc.addSetAbsolutePrintPosition(PRINT_POSITION2_2);
        esc.addText("数量");

        esc.addSetAbsolutePrintPosition(PRINT_POSITION2_3);
        esc.addText("金额");
        esc.addPrintAndLineFeed();
        // 商品信息
        if(goodsInfo.getListGoodInfo()!=null && goodsInfo.getListGoodInfo().size()>0){
            //esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.ON, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF);
            for(int i=0;i<goodsInfo.getListGoodInfo().size();i++){
                GoodInfo goodInfo=goodsInfo.getListGoodInfo().get(i);
                String[] goodsNames = SubByteString.getSubedStrings(goodInfo.getName(), 10);
                for(int ij=0;ij<goodsNames.length;ij++){
                    System.out.println(goodsNames[ij]);
                }
                esc.addSelectJustification(EscCommand.JUSTIFICATION.LEFT);
                // 商品名称
                if (goodsNames != null && goodsNames.length > 0) {
                    esc.addText((i + 1) + "." + goodsNames[0]);
                } else {
                    esc.addText((i + 1) + "." + goodInfo.getName());
                }

                esc.addSetHorAndVerMotionUnits((byte) PRINT_UNIT2, (byte) 0);
                // 单价
                esc.addSelectJustification(EscCommand.JUSTIFICATION.CENTER);
                esc.addSetAbsolutePrintPosition(PRINT_POSITION2_1);
                esc.addText(goodInfo.getPrice()+"");      // 单价还未获取
                // 数量
                esc.addSetAbsolutePrintPosition(PRINT_POSITION2_2);
                esc.addText(goodInfo.getNum() + goodInfo.getUnit());
                // 金额
                esc.addSelectJustification(EscCommand.JUSTIFICATION.RIGHT);
                esc.addSetAbsolutePrintPosition((short) (PRINT_POSITION2_3-1));
                esc.addText(goodInfo.getAmount()+"");

                esc.addSelectJustification(EscCommand.JUSTIFICATION.LEFT);
                if (goodsNames == null || goodsNames.length == 0) {
                    //esc.addPrintAndLineFeed();
                } else if (goodsNames != null && goodsNames.length > 1) {
                    for (int j = 1; j < goodsNames.length; j++) {
                        esc.addText("" + goodsNames[j]);
                        Log.e("123","" + goodsNames[j]);
                        esc.addPrintAndLineFeed();
                    }
                }
            }
            //esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF);
            esc.addText(PRINT_LINE);
        }
        esc.addPrintAndLineFeed();
             // 总计信息
        esc.addSelectJustification(EscCommand.JUSTIFICATION.RIGHT);// 设置打印居右

        if (!TextUtils.isEmpty(goodsInfo.getSubsidy())) {
            esc.addText("优惠补贴：" + goodsInfo.getSubsidy() + "元\n");
        }

        if (!TextUtils.isEmpty(goodsInfo.getAmount())) {
            esc.addText("金额总计：" + goodsInfo.getAmount() + "元\n");
        }

        if (!TextUtils.isEmpty(goodsInfo.getOrderAmount())) {
            esc.addText("还需支付：" + goodsInfo.getOrderAmount() + "元\n");
        }
        esc.addText(PRINT_LINE);
//        打印二维码
        if (!TextUtils.isEmpty("酷软网络科技")) {
            esc.addPrintAndLineFeed();
            esc.addSelectJustification(EscCommand.JUSTIFICATION.CENTER);// 设置打印居中
            esc.addText("请打开微信，扫码付款\n");
            esc.addPrintAndLineFeed();
            // 48  49  50  51
            esc.addSelectErrorCorrectionLevelForQRCode((byte) 0x31); // 设置纠错等级
            esc.addSelectSizeOfModuleForQRCode((byte) 7);// 设置qrcode模块大小
            esc.addStoreQRCodeData("酷软网络科技");// 设置qrcode内容
            esc.addPrintQRCode();// 打印QRCode
            esc.addPrintAndLineFeed();
            esc.addText("请将二维码放平整后再扫码\n");
            esc.addPrintAndLineFeed();
            esc.addText(PRINT_LINE);
        }
        // 加入查询打印机状态，打印完成后，此时会接收到GpCom.ACTION_DEVICE_STATUS广播
        esc.addQueryPrinterStatus();

        // 最终数据
        Vector<Byte> datas = esc.getCommand();
        byte[] bytes = GpUtils.ByteTo_byte(datas);
        String result = Base64.encodeToString(bytes, Base64.DEFAULT);
        int rs;
        try {
            rs = mGpService.sendEscCommand(0, result);
            GpCom.ERROR_CODE r = GpCom.ERROR_CODE.values()[rs];
            if (r != GpCom.ERROR_CODE.SUCCESS) {
                Toast.makeText(context, GpCom.getErrorText(r), Toast.LENGTH_SHORT).show();
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void createBill32(GpService mGpService, Context context){

        short unit=7;

        short position1=6;
        short position2=9;
        short position3=13;

        EscCommand esc = new EscCommand();
        esc.addInitializePrinter();
        esc.addText(PRINT_LINE);

        // 商品头信息
        esc.addSetHorAndVerMotionUnits((byte) unit, (byte) 0);// 设置单位距离
        //esc.addSelectJustification(EscCommand.JUSTIFICATION.LEFT);// 设置打印居中
        esc.addText("商品名");

        esc.addSetAbsolutePrintPosition(position1);// 移动的距离（距离 = 单位 * position设定值)
        //esc.addSelectJustification(EscCommand.JUSTIFICATION.CENTER);
        esc.addText("单价");

        esc.addSetAbsolutePrintPosition(position2);
        //esc.addSelectJustification(EscCommand.JUSTIFICATION.CENTER);
        esc.addText("数量");

        //esc.addSelectJustification(EscCommand.JUSTIFICATION.RIGHT);// 设置打印居中
        esc.addSetAbsolutePrintPosition(position3);
        esc.addText("金额");
        esc.addPrintAndLineFeed();
        //esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF);
        //esc.addSelectJustification(EscCommand.JUSTIFICATION.CENTER);// 设置打印居中
        esc.addText(PRINT_LINE);
        //esc.addPrintAndFeedLines((byte) 3);
        esc.addPrintAndLineFeed();




        // 加入查询打印机状态，打印完成后，此时会接收到GpCom.ACTION_DEVICE_STATUS广播
        esc.addQueryPrinterStatus();

        // 最终数据
        Vector<Byte> datas = esc.getCommand();
        byte[] bytes = GpUtils.ByteTo_byte(datas);
        String result = Base64.encodeToString(bytes, Base64.DEFAULT);
        int rs;
        try {
            rs = mGpService.sendEscCommand(0, result);
            GpCom.ERROR_CODE r = GpCom.ERROR_CODE.values()[rs];
            if (r != GpCom.ERROR_CODE.SUCCESS) {
                Toast.makeText(context, GpCom.getErrorText(r), Toast.LENGTH_SHORT).show();
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



}
