package com.cdc.myprinter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.RemoteException;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;
import com.gprinter.aidl.GpService;
import com.gprinter.command.EscCommand;
import com.gprinter.command.GpCom;
import com.gprinter.command.GpUtils;
import com.gprinter.command.LabelCommand;

import java.util.*;

public class Utils {

    private final static String TAG= Utils.class.getSimpleName();

    public static List<String> getUsbNames(Context context){
        List<String> listNames=new ArrayList<>();
        UsbManager manager = (UsbManager) context.getSystemService(Context.USB_SERVICE);
        HashMap<String, UsbDevice> devices = manager.getDeviceList();
        Iterator<UsbDevice> deviceIterator = devices.values().iterator();
        int count = devices.size();
        Log.e(TAG, "usb device count " + count);
        if (count > 0) {
            while (deviceIterator.hasNext()) {
                UsbDevice device = deviceIterator.next();
                String deviceName = device.getDeviceName();
                Log.e(TAG, "usb device name1 " + deviceName);
                if (checkUsbDevicePidVid(device)) {
                    Log.e(TAG, "usb device name2 " + deviceName);
                    listNames.add(deviceName);
                }
            }
        }
        return listNames;
    }
    private static boolean checkUsbDevicePidVid(UsbDevice dev) {
        int pid = dev.getProductId();
        int vid = dev.getVendorId();
        boolean rel = false;
        if ((vid == 34918 && pid == 256) || (vid == 1137 && pid == 85) || (vid == 6790 && pid == 30084)
                || (vid == 26728 && pid == 256) || (vid == 26728 && pid == 512) || (vid == 26728 && pid == 256)
                || (vid == 26728 && pid == 768) || (vid == 26728 && pid == 1024) || (vid == 26728 && pid == 1280)
                || (vid == 26728 && pid == 1536) || (vid == 7358 && pid == 2)) {
            rel = true;
        }
        return rel;
    }

    public static String getTag(Class<?> clz){
        return clz.getSimpleName();
    }



    public static void  labelCommand(GpService mGpService,Context context){
        LabelCommand tsc = new LabelCommand();
        tsc.addSize(60, 60); // 设置标签尺寸，按照实际尺寸设置
        tsc.addGap(0); // 设置标签间隙，按照实际尺寸设置，如果为无间隙纸则设置为0
        tsc.addDirection(LabelCommand.DIRECTION.BACKWARD, LabelCommand.MIRROR.NORMAL);// 设置打印方向
        tsc.addReference(0, 0);// 设置原点坐标
        tsc.addTear(EscCommand.ENABLE.ON); // 撕纸模式开启
        tsc.addCls();// 清除打印缓冲区
        // 绘制简体中文
        tsc.addText(20, 20, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0, LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1,
                "Welcome to use SMARNET printer!");
        // 绘制图片
        Bitmap b = BitmapFactory.decodeResource(context.getResources(), R.drawable.gprinter);
        tsc.addBitmap(20, 50, LabelCommand.BITMAP_MODE.OVERWRITE, b.getWidth(), b);

        tsc.addQRCode(250, 80, LabelCommand.EEC.LEVEL_L, 5, LabelCommand.ROTATION.ROTATION_0, " www.smarnet.cc");
        // 绘制一维条码
        tsc.add1DBarcode(20, 250, LabelCommand.BARCODETYPE.CODE128, 100, LabelCommand.READABEL.EANBEL, LabelCommand.ROTATION.ROTATION_0, "SMARNET");
        tsc.addPrint(1, 1); // 打印标签
        tsc.addSound(2, 100); // 打印标签后 蜂鸣器响
        //tsc.addCashdrwer(LabelCommand.FOOT.F5, 255, 255);  开钱箱


        Vector<Byte> datas = tsc.getCommand(); // 发送数据
        byte[] bytes = GpUtils.ByteTo_byte(datas);
        String str = android.util.Base64.encodeToString(bytes, Base64.DEFAULT);
        int rel;
        try {
            rel = mGpService.sendLabelCommand(0, str);
            GpCom.ERROR_CODE r = GpCom.ERROR_CODE.values()[rel];
            if (r != GpCom.ERROR_CODE.SUCCESS) {
                Toast.makeText(context.getApplicationContext(), GpCom.getErrorText(r), Toast.LENGTH_SHORT).show();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


}
