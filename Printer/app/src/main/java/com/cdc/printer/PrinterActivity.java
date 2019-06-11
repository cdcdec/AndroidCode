package com.cdc.printer;

import android.content.*;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.gprinter.aidl.GpService;
import com.gprinter.command.EscCommand;
import com.gprinter.command.GpCom;
import com.gprinter.command.GpUtils;
import com.gprinter.command.LabelCommand;
import com.gprinter.io.GpDevice;
import com.gprinter.io.PortParameters;
import com.gprinter.save.PortParamDataBase;
import com.gprinter.service.GpPrintService;

import java.util.*;

public class PrinterActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = PrinterActivity.class.getSimpleName();
    private GpService mGpService;
    private PrinterServiceConnection conn = null;

    private static final int REQUEST_PRINT_RECEIPT = 0xfc;

    private Button btnSetUsb,btnOpenCashBox,btnPrintTest,btnPrintCustom,btnPrintReceipt;

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch(id) {
            case R.id.btnSetUsb:
                setUsb();
                break;
            case R.id.btnOpenCashBox:
                openCashBox();
                break;
            case R.id.btnPrintTest:
                printTestPage(mGpService);
                break;
            case R.id.btnPrintCustom:
                printTestPage(mGpService);
                break;
            case R.id.btnPrintReceipt:
                try {
                    int type = mGpService.getPrinterCommandType(0);
                    if (type == GpCom.ESC_COMMAND) {
                        mGpService.queryPrinterStatus(0, 1000, REQUEST_PRINT_RECEIPT);
                    } else {
                        Toast.makeText(this, "Printer is not receipt mode", Toast.LENGTH_SHORT).show();
                    }
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
                break;
        }
    }

    private void setUsb() {
        //List<String> listNames = Util.getUsbNames(this);
        List<String> listNames = new ArrayList<>();
        if(listNames.size()==0){
            Log.e(TAG, "没有usb设备");
            Toast.makeText(getApplicationContext(), "没有usb设备", Toast.LENGTH_SHORT).show();
        }else{
            try {
                String name = listNames.get(0);
                int rel = mGpService.openPort(0, PortParameters.USB, name, 0);
                GpCom.ERROR_CODE r = GpCom.ERROR_CODE.values()[rel];
                if (r == GpCom.ERROR_CODE.SUCCESS) {
                    Log.e(TAG, "usb打印机设置成功=" + GpCom.getErrorText(r));
                    Toast.makeText(getApplicationContext(), "usb打印机设置成功", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e(TAG, "usb打印机设置失败=" + GpCom.getErrorText(r));
                    Toast.makeText(getApplicationContext(), "usb打印机设置失败=" + GpCom.getErrorText(r), Toast.LENGTH_SHORT).show();
                }
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * 打开钱箱
     */
    private void openCashBox() {
        EscCommand esc = new EscCommand();
        // 开钱箱
        esc.addGeneratePlus(LabelCommand.FOOT.F5, (byte) 255, (byte) 255);
        Vector<Byte> dates = esc.getCommand(); // 发送数据
        byte[] bytes = GpUtils.ByteTo_byte(dates);
        String sss = android.util.Base64.encodeToString(bytes, Base64.DEFAULT);
        int rs;
        try {
            rs = mGpService.sendEscCommand(0, sss);
            GpCom.ERROR_CODE r = GpCom.ERROR_CODE.values()[rs];
            if (r == GpCom.ERROR_CODE.SUCCESS) {
                Log.e(TAG,"打开钱箱成功!"+r);
                Toast.makeText(getApplicationContext(), "打开钱箱成功!", Toast.LENGTH_SHORT).show();
            }else{
                Log.e(TAG,"打开钱箱失败!"+GpCom.getErrorText(r));
                Toast.makeText(getApplicationContext(), GpCom.getErrorText(r), Toast.LENGTH_SHORT).show();
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void printTestPage(GpService mGpService) {
        int re = 0;
        try {
            re = mGpService.printeTestPage(0);
            GpCom.ERROR_CODE r = GpCom.ERROR_CODE.values()[re];
            if (r == GpCom.ERROR_CODE.SUCCESS) {
                Log.e(TAG,"测试页打印成功!"+r);
                Toast.makeText(getApplicationContext(), "测试页打印成功!", Toast.LENGTH_SHORT).show();
            }else{
                Log.e(TAG,"测试页打印失败!"+GpCom.getErrorText(r));
                Toast.makeText(getApplicationContext(), "测试页打印失败="+GpCom.getErrorText(r), Toast.LENGTH_SHORT).show();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    class PrinterServiceConnection implements ServiceConnection {
        @Override
        public void onServiceDisconnected(ComponentName name) {

            Log.e(TAG, "onServiceDisconnected() called");
            mGpService = null;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mGpService = GpService.Stub.asInterface(service);
        }
    }

    private void connection() {
        conn = new PrinterServiceConnection();
        Log.e(TAG, "connection");
        Intent intent = new Intent(this, GpPrintService.class);
        bindService(intent, conn, Context.BIND_AUTO_CREATE); // bindService
    }

    private void initView(){
        btnSetUsb=findViewById(R.id.btnSetUsb);
        btnOpenCashBox=findViewById(R.id.btnOpenCashBox);
        btnPrintTest=findViewById(R.id.btnPrintTest);
        btnPrintCustom=findViewById(R.id.btnPrintCustom);
        btnPrintReceipt=findViewById(R.id.btnPrintReceipt);

        btnSetUsb.setOnClickListener(this);
        btnOpenCashBox.setOnClickListener(this);
        btnPrintTest.setOnClickListener(this);
        btnPrintCustom.setOnClickListener(this);
        btnPrintReceipt.setOnClickListener(this);






    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printer);
        initView();
        connection();

        // 注册实时状态查询广播
        registerReceiver(mBroadcastReceiver, new IntentFilter(GpCom.ACTION_DEVICE_REAL_STATUS));

        /**
         * 票据模式下，可注册该广播，在需要打印内容的最后加入addQueryPrinterStatus()，在打印完成后会接收到
         * action为GpCom.ACTION_DEVICE_STATUS的广播，特别用于连续打印，
         * 可参照该sample中的sendReceiptWithResponse方法与广播中的处理
         **/
        registerReceiver(mBroadcastReceiver, new IntentFilter(GpCom.ACTION_RECEIPT_RESPONSE));


    }


    int rel = 0;
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        Log.e(TAG, "onDestroy ");
        super.onDestroy();
        if (conn != null) {
            unbindService(conn); // unBindService
        }
        unregisterReceiver(mBroadcastReceiver);
    }

    private BroadcastReceiver mBroadcastReceiver=new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.e(TAG, "mBroadcastReceiver="+action);
            if(action.equals(GpCom.ACTION_DEVICE_REAL_STATUS)){
                // 业务逻辑的请求码，对应哪里查询做什么操作
                int requestCode = intent.getIntExtra(GpCom.EXTRA_PRINTER_REQUEST_CODE, -1);
                if (requestCode == REQUEST_PRINT_RECEIPT){
                    int status = intent.getIntExtra(GpCom.EXTRA_PRINTER_REAL_STATUS, 16);
                    if (status == GpCom.STATE_NO_ERR) {
                        sendReceipt();
                    } else {
                        Toast.makeText(PrinterActivity.this, "query printer status error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    };

    private void sendReceipt() {

        EscCommand esc = new EscCommand();
        esc.addInitializePrinter();
        esc.addPrintAndFeedLines((byte) 3);
        esc.addSelectJustification(EscCommand.JUSTIFICATION.CENTER);// 设置打印居中
        esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.ON, EscCommand.ENABLE.ON, EscCommand.ENABLE.OFF);// 设置为倍高倍宽
        esc.addText("票据打印Sample\n"); // 打印文字
        esc.addPrintAndLineFeed();

        /* 打印文字 */
        esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF);// 取消倍高倍宽
        esc.addSelectJustification(EscCommand.JUSTIFICATION.LEFT);// 设置打印左对齐
        esc.addText("打印文字\n"); // 打印文字
        esc.addText("酷软网络 小票机打印文字\n"); // 打印文字

        /* 打印繁体中文 需要打印机支持繁体字库 */
        String message = "繁體 佳酷軟網絡票據打印機\n";
        // esc.addText(message,"BIG5");
        esc.addText(message, "GB2312");
        esc.addPrintAndLineFeed();

        /* 绝对位置 具体详细信息请查看GP58编程手册 */
        esc.addText("绝对");
        esc.addSetHorAndVerMotionUnits((byte) 7, (byte) 0);
        esc.addSetAbsolutePrintPosition((short) 6);
        esc.addText("位置");
        esc.addSetAbsolutePrintPosition((short) 10);
        esc.addText("设备");
        esc.addPrintAndLineFeed();

        /* 打印图片 */
        esc.addText("打印图片!\n"); // 打印文字
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.gprinter);
        esc.addRastBitImage(b, 384, 0); // 打印图片

        /* 打印一维条码 */
//        esc.addText("Print code128\n"); // 打印文字
//        esc.addSelectPrintingPositionForHRICharacters(EscCommand.HRI_POSITION.BELOW);//
//        // 设置条码可识别字符位置在条码下方
//        esc.addSetBarcodeHeight((byte) 60); // 设置条码高度为60点
//        esc.addSetBarcodeWidth((byte) 1); // 设置条码单元宽度为1
//        esc.addCODE128(esc.genCodeB("SMARNET")); // 打印Code128码
//        esc.addPrintAndLineFeed();

        /*
         * QRCode命令打印 此命令只在支持QRCode命令打印的机型才能使用。 在不支持二维码指令打印的机型上，则需要发送二维条码图片
         */
        esc.addText("打印文字\n"); // 打印文字
        esc.addSelectErrorCorrectionLevelForQRCode((byte) 0x31); // 设置纠错等级
        esc.addSelectSizeOfModuleForQRCode((byte) 3);// 设置qrcode模块大小
        esc.addStoreQRCodeData("www.smarnet.cc");// 设置qrcode内容
        esc.addPrintQRCode();// 打印QRCode
        esc.addPrintAndLineFeed();

        /* 打印文字 */
        esc.addSelectJustification(EscCommand.JUSTIFICATION.CENTER);// 设置打印左对齐
        esc.addText("打印结束!\r\n"); // 打印结束
        // 开钱箱
        esc.addGeneratePlus(LabelCommand.FOOT.F5, (byte) 255, (byte) 255);
        esc.addPrintAndFeedLines((byte) 8);

        Vector<Byte> datas = esc.getCommand(); // 发送数据
        byte[] bytes = GpUtils.ByteTo_byte(datas);
        String sss = Base64.encodeToString(bytes, Base64.DEFAULT);
        int rs;
        try {
            rs = mGpService.sendEscCommand(0, sss);
            GpCom.ERROR_CODE r = GpCom.ERROR_CODE.values()[rs];
            if (r != GpCom.ERROR_CODE.SUCCESS) {
                Toast.makeText(getApplicationContext(), GpCom.getErrorText(r), Toast.LENGTH_SHORT).show();
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
