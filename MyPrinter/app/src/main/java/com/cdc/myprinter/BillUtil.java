package com.cdc.myprinter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.RemoteException;
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
    private static final String PRINT_LINE = "------------------------------------------------\n";
    public static final short PRINT_UNIT = 43;
    public static final short PRINT_POSITION_1 = 26 * 3;
    public static final short PRINT_POSITION_2 = 32 * 3;
    public static final short PRINT_POSITION_3 = 42 * 3;
    public static void createBill(GpService mGpService, Context context){

        Log.e("123","===1=2====");
        EscCommand esc = new EscCommand();
        esc.addInitializePrinter();

        // 顶部图片
        esc.addSelectJustification(EscCommand.JUSTIFICATION.CENTER);
        Bitmap b = BitmapFactory.decodeResource(context.getResources(), R.drawable.gprinter);
        esc.addRastBitImage(b, 200, 0); // 打印图片

        esc.addPrintAndLineFeed();

        esc.addText(PRINT_LINE);

        esc.addSelectJustification(EscCommand.JUSTIFICATION.LEFT);
        esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.ON,EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF);
        esc.addText("最前面" + "\n"); // 打印文字

        esc.addSelectJustification(EscCommand.JUSTIFICATION.LEFT);
        esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF);

        // 头部信息
        esc.addText("打印编号：" + "1234567890");
        esc.addPrintAndLineFeed();
        esc.addText("操作时间：" +"2019-06-11 18:09");
        esc.addPrintAndLineFeed();
        esc.addText("操作员：" + "某某某");
        esc.addPrintAndLineFeed();


        esc.addText(PRINT_LINE);

        // 商品头信息
        esc.addSetHorAndVerMotionUnits((byte) PRINT_UNIT, (byte) 0);
        esc.addText("商品名");

        esc.addSetAbsolutePrintPosition(PRINT_POSITION_1);
        esc.addText("单价");

        esc.addSetAbsolutePrintPosition(PRINT_POSITION_2);
        esc.addText("数量");

        esc.addSetAbsolutePrintPosition(PRINT_POSITION_3);
        esc.addText("金额");

        esc.addPrintAndLineFeed();

        // 商品信息
            esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.ON, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF);
            for (int i = 0; i < 2; i++) {
                // 商品名称
                esc.addText((i + 1) + ".商品名称");
                esc.addSetHorAndVerMotionUnits((byte) PRINT_UNIT, (byte) 0);
                // 单价
                short priceLength = 5;
                short pricePosition = (short) (PRINT_POSITION_1 + 12 - priceLength * 3);
                esc.addSetAbsolutePrintPosition(pricePosition);
                esc.addText("360.00");      // 单价还未获取

                // 数量
                short numLength = 14;
                short numPosition = (short) (PRINT_POSITION_2 + 14 - numLength * 3);
                esc.addSetAbsolutePrintPosition(numPosition);
                esc.addText("14箱");

                // 金额
                short amountLength = 6;
                short amountPosition = (short) (PRINT_POSITION_3 + 11 - amountLength * 3);
                esc.addSetAbsolutePrintPosition(amountPosition);
                esc.addText("585.00");
                esc.addPrintAndLineFeed();

            }

            esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF);
            esc.addText(PRINT_LINE);


        // 总计信息
        esc.addSelectJustification(EscCommand.JUSTIFICATION.RIGHT);// 设置打印居右


        esc.addText("优惠补贴：15.00"  + "元\n");

        esc.addText("金额总计：4500" + "元\n");

        esc.addText("还需支付：" + (4500-15) + "元\n");

        esc.addText(PRINT_LINE);

//        打印二维码
            esc.addPrintAndLineFeed();
            esc.addSelectJustification(EscCommand.JUSTIFICATION.CENTER);// 设置打印居中
            esc.addText("请打开微信，扫码付款\n");
            esc.addPrintAndLineFeed();
            // 48  49  50  51
            esc.addSelectErrorCorrectionLevelForQRCode((byte) 0x31); // 设置纠错等级
            esc.addSelectSizeOfModuleForQRCode((byte) 7);// 设置qrcode模块大小
            esc.addStoreQRCodeData("二维码");// 设置qrcode内容

            esc.addPrintQRCode();// 打印QRCode

            esc.addPrintAndLineFeed();
            esc.addText("请将二维码放平整后再扫码\n");

        esc.addPrintAndFeedLines((byte) 3);

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
