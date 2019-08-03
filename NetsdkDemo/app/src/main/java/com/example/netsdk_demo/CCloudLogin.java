package com.example.netsdk_demo;
/*            cloud device login process
 * 1.NetDEVSDK.NETDEV_LoginCloud(), return value is glpcloudID;
 * 2.glpcloudID为入参获取设备登录ID即glpUserID，获取时根据oCloudDevInfo.szDevicePassword有无调用不同的函数即NETDEV_LoginByDynamic和NETDEV_LoginCloudDev。
 * 3.if glpUserID is not equal to 0, enter live interface of NagvigationActivity;
 * */


import java.util.Timer;
import java.util.TimerTask;

import com.example.netsdk_demo.R;
import com.sdk.NETDEV_CLOUD_LIMIT_INFO_S;
import com.sdk.NETDEV_CLOUD_MOBILE_INFO_S;
import com.sdk.NetDEVSDK;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*cloud account login*/
public class CCloudLogin extends Activity {
	private ActionBar m_oActionBar; 
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cloud_login);
		m_oActionBar = super.getActionBar();         
		initActionBar(); 
		
		final NetDEVSDK oNetSDKDemo = new NetDEVSDK();
		oNetSDKDemo.NETDEV_Init();
		NetDEVSDK.NETDEV_SetT2UPayLoad(800);
		Button oCloudLoginBtn = (Button) findViewById(R.id.cloud_account_login);
		final Intent oIntent = new Intent(this, CCloudDevlogin.class);
		
		final EditText oCloudUsername = (EditText) findViewById(R.id.cloud_username);
		final EditText oCloudPassword = (EditText) findViewById(R.id.cloud_password);
		final EditText oServerUrl = (EditText) findViewById(R.id.cloud_server_url);
	    
		/*cloud account login, if the login is successful, start the live interface*/
		oCloudLoginBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String strCloudUserName = oCloudUsername.getText().toString();
				if(strCloudUserName.length()==0){
					strCloudUserName="mnbv2223";
				}
				String strCloudPassword = oCloudPassword.getText().toString();
				if(strCloudPassword.length()==0){
					strCloudPassword="123456l";
				}
				String strCloudServerUrl = oServerUrl.getText().toString();
				int  iNoAccountFlag = 0;
				if ((0 == strCloudUserName.length()) && (0 == strCloudPassword.length()))
				{
					iNoAccountFlag = 1;
				}
				NetDEVSDK.glpcloudID = NetDEVSDK.NETDEV_LoginCloudEx(strCloudServerUrl, strCloudUserName, strCloudPassword, iNoAccountFlag);
				if(0 != NetDEVSDK.glpcloudID)
				{
					/* Client info as demo. Must be filled by real data while actual development */
					NetDEVSDK.NETDEV_SetClientID("1234567890987654321");          /* ClienID must be Unique! */
                    NETDEV_CLOUD_MOBILE_INFO_S stMobileInfo = new NETDEV_CLOUD_MOBILE_INFO_S();
                    NETDEV_CLOUD_LIMIT_INFO_S stLimitInfo = new NETDEV_CLOUD_LIMIT_INFO_S();
                    stMobileInfo.szMobileModule = "A2017";
                    stMobileInfo.szSystemType = "Andriod";
                    stMobileInfo.szSystemVersion = "7.0.0.1";
                    stMobileInfo.bDonotDisturb = 1;
                    stMobileInfo.bPushBuiltFlag = 0;
                    stMobileInfo.szAppName = "SdkDemo";
                    stMobileInfo.szAppLanguage = "zh-cn";
                    stMobileInfo.szAppVersion = "V0.0.0.1";
                    stMobileInfo.bIosEnvir = 1;
					stLimitInfo.udwMaxAppTimeS = 0;
					stLimitInfo.udwMaxDeviceNum = 0;
					stLimitInfo.udwMaxRTSNum = 0;
                    int iRet = NetDEVSDK.NETDEV_ReportMobileInfo(NetDEVSDK.glpcloudID, stMobileInfo, stLimitInfo);
                    if(0 == iRet)
                    {
                        AlertDialog.Builder oBuilder = new  AlertDialog.Builder(CCloudLogin.this);
                        oBuilder.setTitle("Fail" );
                        oBuilder.setMessage("Report Mobile Info Fail." );
                        oBuilder.setPositiveButton("OK" ,  null );
                        oBuilder.show();
                    }
					startActivity(oIntent);
					finish();
				}else {
					AlertDialog.Builder oBuilder =new  AlertDialog.Builder(CCloudLogin.this);
					oBuilder.setTitle("Fail" );
					oBuilder.setMessage("Login failed, please check if the input is correct." );
					oBuilder.setPositiveButton("OK" ,  null );
					oBuilder.show();
				}

			}
			
		});
	}
	
	private void initActionBar(){         
		//show home     
		m_oActionBar.setDisplayShowHomeEnabled(false);     
		m_oActionBar.setDisplayShowTitleEnabled(false);    
		//show back button
		m_oActionBar.setDisplayHomeAsUpEnabled(true);         
		    
		m_oActionBar.setDisplayUseLogoEnabled(false); 
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cloud_login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		int id = item.getItemId();
		switch ( id ) {
		case android.R.id.home:
			final Intent intent = new Intent(this, CLocalDevLogin.class);
			startActivity(intent);
			finish();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/* return key  */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{  // TODO Auto-generated method stub  
		if(keyCode == KeyEvent.KEYCODE_BACK) 
		{   
			exitBy2Click();  
		}
			return false; 
	} 
	/* function of exit after 2 click  */
	private static Boolean isExit = false;   
	private void exitBy2Click() 
	{  
		Timer tExit = null;  
		if (isExit == false) 
		{  
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
		}
		else 
		{  
			finish();  

			System.exit(0); 
		}
	} 
	
}
