package com.cdc.printer;

import android.content.*;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.gprinter.aidl.GpService;
import com.gprinter.command.GpCom;
import com.gprinter.io.GpDevice;
import com.gprinter.io.PortParameters;
import com.gprinter.save.PortParamDataBase;
import com.gprinter.service.GpPrintService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PrinterActivity extends AppCompatActivity {

    private final static String TAG = PrinterActivity.class.getSimpleName();

    private ArrayList<String> usbDevices = new ArrayList<>();

    //private PortParameters mPortParam = new PortParameters();

    private GpService mGpService;
    private PrinterServiceConnection conn = null;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printer);
        registerBroadcast();
        connection();
       // initPortParam();
      //  getUsbDeviceList();
        initUsbView();
    }

    private void initPortParam() {
      //  PortParamDataBase database = new PortParamDataBase(this);
      //  mPortParam = database.queryPortParamDataBase("" + 0);
       // mPortParam.setPortOpenState(false);
        //database.insertPortParam(0, mPortParam);
    }

    int rel = 0;
    private void initUsbView() {
        //String name = usbDevices.get(0);
        String name = "/dev/bus/usb/001/007";
      //  mPortParam.setUsbDeviceName(name);
       // mPortParam.setPortType(PortParameters.USB);
        TextView usbNameTv = findViewById(R.id.usbNameTv);
        usbNameTv.setText("Usb Printer");

        TextView usbUseTv = findViewById(R.id.usbUseTv);

        usbUseTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mGpService.closePort(0);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

                try {

                    rel = mGpService.openPort(0, PortParameters.USB,
                            "/dev/bus/usb/001/007", 0);

                    Log.e(TAG, "rel="+rel);

                    GpCom.ERROR_CODE r = GpCom.ERROR_CODE.values()[rel];


                    Log.e(TAG, "result :" + String.valueOf(r));

                    mGpService.printeTestPage(0);
//                    if (r != GpCom.ERROR_CODE.SUCCESS) {
//                        if (r == GpCom.ERROR_CODE.DEVICE_ALREADY_OPEN) {
//                           // mPortParam.setPortOpenState(true);
//                            mGpService.printeTestPage(0);
//                        } else {
//                            messageBox(GpCom.getErrorText(r));
//                        }
//                    }
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
             /*   boolean bl = mPortParam.getPortOpenState();
                if (!bl) {
                    if (checkPortParamters(mPortParam)) {
                        try {

                            rel = mGpService.openPort(0, PortParameters.USB,
                                    "/dev/bus/usb/001/007", 0);

                            Log.e(TAG, "rel="+rel);

                            GpCom.ERROR_CODE r = GpCom.ERROR_CODE.values()[rel];
                            Log.e(TAG, "result :" + String.valueOf(r));
                            if (r != GpCom.ERROR_CODE.SUCCESS) {
                                if (r == GpCom.ERROR_CODE.DEVICE_ALREADY_OPEN) {
                                    mPortParam.setPortOpenState(true);
                                    mGpService.printeTestPage(0);
                                } else {
                                    messageBox(GpCom.getErrorText(r));
                                }
                            }
                        } catch (RemoteException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }*/
            }
        });
    }



    private void getUsbDeviceList() {
        UsbManager manager = (UsbManager) getSystemService(Context.USB_SERVICE);
        // Get the list of attached devices
        HashMap<String, UsbDevice> devices = manager.getDeviceList();
        Iterator<UsbDevice> deviceIterator = devices.values().iterator();
        int count = devices.size();
        Log.e(TAG, "count " + count);
        if (count > 0) {
            while (deviceIterator.hasNext()) {
                UsbDevice device = deviceIterator.next();
                String deviceName = device.getDeviceName();
                Log.e(TAG, "deviceName1 " + deviceName);
                if (checkUsbDevicePidVid(device)) {
                    Log.e(TAG, "deviceName2 " + deviceName);
                    usbDevices.add(deviceName);
                }
            }
        } else {
            String noDevices = getResources().getText(R.string.none_usb_device).toString();
            Log.e(TAG, "noDevices " + noDevices);
            usbDevices.add(noDevices);
        }
    }

    boolean checkUsbDevicePidVid(UsbDevice dev) {
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


    Boolean checkPortParamters(PortParameters param) {
        boolean rel = false;
        int type = param.getPortType();
        if (type == PortParameters.BLUETOOTH) {
            if (!param.getBluetoothAddr().equals("")) {
                rel = true;
            }
        } else if (type == PortParameters.ETHERNET) {
            if ((!param.getIpAddr().equals("")) && (param.getPortNumber() != 0)) {
                rel = true;
            }
        } else if (type == PortParameters.USB) {
            if (!param.getUsbDeviceName().equals("")) {
                rel = true;
            }
        }
        return rel;
    }
    private void registerBroadcast() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(GpCom.ACTION_CONNECT_STATUS);
        this.registerReceiver(PrinterStatusBroadcastReceiver, filter);
    }
    private BroadcastReceiver PrinterStatusBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (GpCom.ACTION_CONNECT_STATUS.equals(intent.getAction())) {
                int type = intent.getIntExtra(GpPrintService.CONNECT_STATUS, 0);
                int id = intent.getIntExtra(GpPrintService.PRINTER_ID, 0);
                Log.e(TAG, "connect status " + type);
                if (type == GpDevice.STATE_CONNECTING) {
                    setProgressBarIndeterminateVisibility(true);
                    //mPortParam[id].setPortOpenState(false);

                } else if (type == GpDevice.STATE_NONE) {
                    setProgressBarIndeterminateVisibility(false);
                    //mPortParam[id].setPortOpenState(false);
                } else if (type == GpDevice.STATE_VALID_PRINTER) {
                    setProgressBarIndeterminateVisibility(false);
                   // mPortParam[id].setPortOpenState(true);
                } else if (type == GpDevice.STATE_INVALID_PRINTER) {

                    messageBox("Please use Gprinter!");
                }
            }
        }
    };

    private void messageBox(String err) {
        Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        Log.e(TAG, "onDestroy ");
        super.onDestroy();
        this.unregisterReceiver(PrinterStatusBroadcastReceiver);
        if (conn != null) {
            unbindService(conn); // unBindService
        }
    }


}
