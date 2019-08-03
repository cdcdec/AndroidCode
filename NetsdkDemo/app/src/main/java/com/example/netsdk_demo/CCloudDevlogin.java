package com.example.netsdk_demo;


import java.util.Timer;
import java.util.TimerTask;


import com.sdk.AlarmCallBack_PF;
import com.sdk.ExceptionCallBack_PF;
import com.sdk.NETDEV_CLOUD_DEV_BASE_INFO_S;
import com.sdk.NETDEV_CLOUD_DEV_INFO_S;
import com.sdk.NETDEV_CLOUD_DEV_LOGIN_S;
import com.sdk.NETDEV_CLOUD_LIMIT_INFO_S;
import com.sdk.NETDEV_CLOUD_MOBILE_INFO_S;
import com.sdk.NETDEV_CLOUD_NOACCOUNT_INFO_S;
import com.sdk.NETDEV_DEVICE_INFO_S;
import com.sdk.NETDEV_LOGIN_INFO_S;
import com.sdk.NetDEVSDK;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
/*cloud device login */
public class CCloudDevlogin extends Activity {

    private ActionBar m_oActionBar;
    private EditText m_oRegCodeTxt;
    private EditText m_DevUsername;
    private EditText m_DevPassword;
	static ArrayList<String> cloudDevNameList = new ArrayList<String>();
	static ArrayList<Integer> cloudLpUserIDList = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cloud_dev_login);

        m_oActionBar = super.getActionBar();
        initActionBar();

        final NetDEVSDK oNetSDKDemo = new NetDEVSDK();
        oNetSDKDemo.NETDEV_Init();
		NetDEVSDK.NETDEV_SetT2UPayLoad(800);
        Button oDevLoginBtn = (Button) findViewById(R.id.devlogin);
        final Intent oIntent = new Intent(this, CMainMenu.class);
        Button oGetDevListBtn = (Button) findViewById(R.id.get_dev_list);

        Button oAddDeviveBtn = (Button) findViewById(R.id.addDeviceBtn);
        Button oDelDeviveBtn = (Button) findViewById(R.id.delDeviveBtn);
        m_oRegCodeTxt = (EditText) findViewById(R.id.registerCodeEdit);
        m_DevUsername = (EditText) findViewById(R.id.userNameEdit);
        m_DevPassword = (EditText) findViewById(R.id.passWordEdit);
        Button ologinByRegisterCodeBtn = (Button) findViewById(R.id.loginByRegisterCodeBtn);

        /*
         * cloud device login
         * if password is not exist, we call NETDEV_LoginByDynamic
         * if password is exist, we call NETDEV_LoginCloudDev
         * start live interface if login successfully
         *
         * Get Dev list: get all device information of cloud
         * */
        ologinByRegisterCodeBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                String strRegCodeTxt = m_oRegCodeTxt.getText().toString();
                String strUsername = m_DevUsername.getText().toString();
                String strDevPassword = m_DevPassword.getText().toString();

                if (strRegCodeTxt.isEmpty() || strUsername.isEmpty() || strDevPassword.isEmpty()) {
                    AlertDialog.Builder oBuilder = new Builder(CCloudDevlogin.this);
                    oBuilder.setMessage("Username is empty  !");
                    oBuilder.setTitle("");
                    oBuilder.setPositiveButton("OK", null);
                    oBuilder.show();
                } else {
                    {
                        NETDEV_LOGIN_INFO_S stLoginInfo = new NETDEV_LOGIN_INFO_S();
                        stLoginInfo.dwConnectMode = 2;
                        stLoginInfo.LoginType = 4;
                        stLoginInfo.dwT2UTimeout = 15;
                        stLoginInfo.szRegisterCode = strRegCodeTxt;
                        stLoginInfo.szDeviceName = "";
                        stLoginInfo.mUserName = strUsername;
                        stLoginInfo.mPassword = strDevPassword;
                        NetDEVSDK.lpUserID = NetDEVSDK.NETDEV_LoginV2(NetDEVSDK.glpcloudID, stLoginInfo);
                        if (0 == NetDEVSDK.lpUserID) {
                            stLoginInfo.dwConnectMode = 3;
                            NetDEVSDK.lpUserID = NetDEVSDK.NETDEV_LoginV2(NetDEVSDK.glpcloudID, stLoginInfo);
                        }
                        if (0 != NetDEVSDK.lpUserID) {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    AlarmCallBack_PF pfAlarmCallBack = new AlarmCallBack_PF();
                                    NetDEVSDK.NETDEV_Android_SetAlarmCallBack(NetDEVSDK.lpUserID, pfAlarmCallBack, 0);
                                    ExceptionCallBack_PF pfExceptionCallBack = new ExceptionCallBack_PF();
                                    NetDEVSDK.NETDEV_Android_SetExceptionCallBack(pfExceptionCallBack, 0);
                                }
                            }).start();
                            if (!cloudDevNameList.contains(stLoginInfo.szDeviceSN)){
                                cloudLpUserIDList.add(NetDEVSDK.lpUserID);
                                cloudDevNameList.add(stLoginInfo.szDeviceSN);
                            }

                            NETDEV_CLOUD_NOACCOUNT_INFO_S stCloudNoAccountInfo = new NETDEV_CLOUD_NOACCOUNT_INFO_S();
                            stCloudNoAccountInfo.szDeviceName = "testDevice";
                            stCloudNoAccountInfo.szDeviceSN = stLoginInfo.szDeviceSN;
                            int iRet = NetDEVSDK.NETDEV_NoAccountBinding(NetDEVSDK.glpcloudID,stCloudNoAccountInfo);
                            if(0 == iRet)
                            {
                                AlertDialog.Builder oBuilder = new Builder(CCloudDevlogin.this);
                                oBuilder.setMessage("NETDEV_NoAccountBinding fail  !");
                                oBuilder.setTitle("");
                                oBuilder.setPositiveButton("OK", null);
                                oBuilder.show();
                            }

                            oIntent.putIntegerArrayListExtra("cloudLpUserID",cloudLpUserIDList);
                            oIntent.putStringArrayListExtra("szDevName",cloudDevNameList);
                            oIntent.putExtra("bLocalDevFlag",false);
                            oIntent.putExtra("bNoAccountDevFlag",true);
                            oIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);//���ò�Ҫˢ�½�Ҫ�����Ľ���
                            oIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//�����Թص���Ҫ���Ľ����м��activity
                            startActivity(oIntent);
                            finish();
                        }
                        else{
                            AlertDialog.Builder oBuilder = new Builder(CCloudDevlogin.this);
                            oBuilder.setMessage("login fail");
                            oBuilder.setTitle("");
                            oBuilder.setPositiveButton("OK", null);
                            oBuilder.show();
                        }
                    }
                }
            }

        });

        /*
         * cloud device login
         * if password is not exist, we call NETDEV_LoginByDynamic
         * if password is exist, we call NETDEV_LoginCloudDev
         * start live interface if login successfully
         *
         * Get Dev list: get all device information of cloud
         * */
        oDevLoginBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                NETDEV_CLOUD_DEV_LOGIN_S stCloudDevInfo = new NETDEV_CLOUD_DEV_LOGIN_S();
                NETDEV_DEVICE_INFO_S stDeviceInfo = new NETDEV_DEVICE_INFO_S();
                stCloudDevInfo.szDeviceName = NetDEVSDK.strDevName;
                stCloudDevInfo.szDevicePassword = "";
                stCloudDevInfo.dwT2UTimeout = 10;

                if (null == stCloudDevInfo.szDeviceName) {
                    AlertDialog.Builder oBuilder = new Builder(CCloudDevlogin.this);
                    oBuilder.setMessage("Username is empty  !");
                    oBuilder.setTitle("");
                    oBuilder.setPositiveButton("OK", null);
                    oBuilder.show();
                } else {
                    if (stCloudDevInfo.szDevicePassword.isEmpty()) {
                        //NetDEVSDK.lpUserID = NetDEVSDK.NETDEV_LoginByDynamic(NetDEVSDK.glpcloudID, stCloudDevInfo, stDeviceInfo);
                        NETDEV_LOGIN_INFO_S stLoginInfo = new NETDEV_LOGIN_INFO_S();
                        stLoginInfo.dwConnectMode = 2;
                        stLoginInfo.LoginType = 1;
                        stLoginInfo.dwT2UTimeout = 15;
                        stLoginInfo.szDeviceName = stCloudDevInfo.szDeviceName;
                        stLoginInfo.mPassword = "";
                        Log.i("wbtest", "NETDEV_LoginV2 start");
                        NetDEVSDK.lpUserID = NetDEVSDK.NETDEV_LoginV2(NetDEVSDK.glpcloudID, stLoginInfo);
                        Log.i("wbtest", "NETDEV_LoginV2 end");
                        if (0 == NetDEVSDK.lpUserID) {
                            stLoginInfo.dwConnectMode = 3;
                            Log.i("wbtest", "NETDEV_LoginV2 dwConnectMode = 3; start");
                            NetDEVSDK.lpUserID = NetDEVSDK.NETDEV_LoginV2(NetDEVSDK.glpcloudID, stLoginInfo);
                            Log.i("wbtest", "NETDEV_LoginV2 dwConnectMode = 3; end");
                        }
                        if (0 != NetDEVSDK.lpUserID) {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    AlarmCallBack_PF pfAlarmCallBack = new AlarmCallBack_PF();
                                    NetDEVSDK.NETDEV_Android_SetAlarmCallBack(NetDEVSDK.lpUserID, pfAlarmCallBack, 0);
                                    ExceptionCallBack_PF pfExceptionCallBack = new ExceptionCallBack_PF();
                                    NetDEVSDK.NETDEV_Android_SetExceptionCallBack(pfExceptionCallBack, 0);
                                }
                            }).start();
                            Log.i("wbtest", "startActivity");
                            if (!cloudDevNameList.contains(stCloudDevInfo.szDeviceName)){
                                cloudLpUserIDList.add(NetDEVSDK.lpUserID);
                                cloudDevNameList.add(stCloudDevInfo.szDeviceName);
                            }
                            oIntent.putIntegerArrayListExtra("cloudLpUserID",cloudLpUserIDList);
						    oIntent.putStringArrayListExtra("szDevName",cloudDevNameList);
						    oIntent.putExtra("bLocalDevFlag",false);
                            oIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);//���ò�Ҫˢ�½�Ҫ�����Ľ���
                            oIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//�����Թص���Ҫ���Ľ����м��activity
                            startActivity(oIntent);
                            finish();
                        }
                    } else {
                        //NetDEVSDK.glpUserID = NetDEVSDK.NETDEV_LoginCloudDev(NetDEVSDK.glpcloudID,oCloudDevInfo,oDeviceInfo);
						AlertDialog.Builder oBuilder = new Builder(CCloudDevlogin.this);
						oBuilder.setMessage("login was failed  !");
						oBuilder.setTitle("");
						oBuilder.setPositiveButton("OK", null);
						oBuilder.show();
                    }
                }
            }

        });


        /*Get the device list
         * The list of acquired devices is output to dialog for choosing
         * */
        oGetDevListBtn.setOnClickListener(new OnClickListener() {
            String strTag = "FindCloudDevList";
            String[] szDevList = new String[10];
            String strUserName = "";

            @Override
            public void onClick(View v) {
                int dwFileHandle = NetDEVSDK.NETDEV_FindCloudDevList(NetDEVSDK.glpcloudID);
                if (0 == dwFileHandle) {
                    Log.i(strTag, "Query cloud device list failed.");
                } else {
                    AlertDialog.Builder oBuilder = new Builder(CCloudDevlogin.this);
                    oBuilder.setTitle("Device List");
                    int dwCount = 0;

                    NETDEV_CLOUD_DEV_INFO_S stclouddeviceinfo = new NETDEV_CLOUD_DEV_INFO_S();
                    for (int i = 0; i < 10; i++) {
                        String strMeg = "";
                        String strOut = "";
                        int iRet = NetDEVSDK.NETDEV_FindNextCloudDevInfo(dwFileHandle, stclouddeviceinfo);
                        if (0 == iRet) {
                            break;
                        } else {
                            strMeg = "IP:" + stclouddeviceinfo.szIPAddr + "\n";
                            strOut += strMeg;
                            strMeg = "User Name:" + stclouddeviceinfo.szDevUserName + "\n";
                            strOut += strMeg;
                            strMeg = "Serial Num:" + stclouddeviceinfo.szDevSerialNum + "\n";
                            strOut += strMeg;
                            strMeg = "Dev Name:" + stclouddeviceinfo.szDevName + "\n";
                            strOut += strMeg;
                            strMeg = "Dev Model:" + stclouddeviceinfo.szDevModel + "\n";
                            strOut += strMeg;
                            strMeg = "Dev Port:" + String.valueOf(stclouddeviceinfo.dwDevPort) + "";
                            strOut += strMeg;

                            szDevList[dwCount++] = strOut;
                        }
                        Log.i(strTag, strOut);
                    }

                    String[] szDevListArr = new String[dwCount];
                    System.arraycopy(szDevList, 0, szDevListArr, 0, dwCount);
                    oBuilder.setSingleChoiceItems(szDevListArr, 0, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int witch) {
                            String str = szDevList[witch];
                            strUserName = str.substring(str.indexOf("User Name:") + 10, str.indexOf("Serial Num:"));
                            NetDEVSDK.strDevName = strUserName;
                        }
                    });
                    oBuilder.setPositiveButton("Select", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                            //EditText mDev = (EditText) findViewById(R.id.Devname);
                            //mDev.setText(username);
                            dialog.dismiss();

                            int dwFileHandle = NetDEVSDK.NETDEV_FindCloseCloudDevList(NetDEVSDK.glpcloudID);
                            if (0 == dwFileHandle) {
                                Log.i(strTag, "Find Close cloud device list failed.");
                            }

                        }
                    });
                    oBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                            strUserName = "";
                            dialog.dismiss();

                            int dwFileHandle = NetDEVSDK.NETDEV_FindCloseCloudDevList(NetDEVSDK.glpcloudID);
                            if (0 == dwFileHandle) {
                                Log.i(strTag, "Find Close cloud device list failed.");
                            }

                        }
                    });
                    oBuilder.show();
                }

            }

        });

        oAddDeviveBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String strRegisterCode = m_oRegCodeTxt.getText().toString();
                if (strRegisterCode.isEmpty()) {
                    AlertDialog.Builder builder  = new Builder(CCloudDevlogin.this);
                    builder.setMessage("strRegisterCode is empty" ) ;
                    builder.setTitle("");
                    builder.setPositiveButton("OK" ,  null );
                    builder.show();
                } else {
                    NETDEV_CLOUD_DEV_BASE_INFO_S stDevBase = new NETDEV_CLOUD_DEV_BASE_INFO_S();
                    int iRet = NetDEVSDK.NETDEV_AddCloudDevice(NetDEVSDK.glpcloudID, strRegisterCode, "device", stDevBase);
                    if (0 == iRet) {
                        AlertDialog.Builder oBuilder = new Builder(CCloudDevlogin.this);
                        oBuilder.setMessage("add device fail  !");
                        oBuilder.setTitle("");
                        oBuilder.setPositiveButton("OK", null);
                        oBuilder.show();
                    } else {
                        AlertDialog.Builder oBuilder = new Builder(CCloudDevlogin.this);
                        oBuilder.setMessage("add device success  !");
                        oBuilder.setTitle("");
                        oBuilder.setPositiveButton("OK", null);
                        oBuilder.show();
                    }
                }
            }

        });

        oDelDeviveBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                if (null == NetDEVSDK.strDevName) {
                    AlertDialog.Builder oBuilder = new Builder(CCloudDevlogin.this);
                    oBuilder.setMessage("Username is empty  !");
                    oBuilder.setTitle("");
                    oBuilder.setPositiveButton("OK", null);
                    oBuilder.show();
                } else {
                    int iRet = NetDEVSDK.NETDEV_DeleteCloudDevice(NetDEVSDK.glpcloudID, NetDEVSDK.strDevName);
                    if (0 == iRet) {
                        AlertDialog.Builder oBuilder = new Builder(CCloudDevlogin.this);
                        oBuilder.setMessage("del device fail  !");
                        oBuilder.setTitle("");
                        oBuilder.setPositiveButton("OK", null);
                        oBuilder.show();
                    } else {
                        AlertDialog.Builder oBuilder = new Builder(CCloudDevlogin.this);
                        oBuilder.setMessage("del device success  !");
                        oBuilder.setTitle("");
                        oBuilder.setPositiveButton("OK", null);
                        oBuilder.show();
                    }
                }
            }

        });
    }

    private void initActionBar() {
        m_oActionBar.setDisplayShowHomeEnabled(false);
        m_oActionBar.setDisplayShowTitleEnabled(false);
        m_oActionBar.setDisplayHomeAsUpEnabled(true);
        m_oActionBar.setDisplayUseLogoEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cloud_device_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                final Intent intent = new Intent(this, CCloudLogin.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /*** return key */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {  // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (cloudDevNameList.isEmpty()){
                exitBy2Click(); //exit application after double click
            }else {
                if(keyCode == KeyEvent.KEYCODE_BACK){
                    CCloudDevlogin.this.finish();
                }
                return super.onKeyDown(keyCode, event);
            }
        }
        return false;
    }

    /**
     * function of exit after 2 click
     */
    private static Boolean isExit = false;

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true;
            // prepare exiting
            Toast.makeText(this, "Press again to exit the app", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // cancel exit
                }
            }, 2000); // If the return key is not pressed for 2 seconds, the timer is started to cancel the task that was just executed
        } else {
            finish();

            System.exit(0);
        }
    }

}
