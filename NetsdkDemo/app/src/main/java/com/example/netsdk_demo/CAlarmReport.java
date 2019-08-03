package com.example.netsdk_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.example.netsdk_demo.R;
import com.sdk.AlarmCallBack_PF;
import com.sdk.NETDEV_DEVICE_INFO_S;
import com.sdk.NetDEVSDK;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class CAlarmReport extends Activity {
	private ActionBar m_oActionBar; 
	private ListView m_oAlarmInfoListView; 
	
    static private ArrayAdapter<String> m_oAdapter;
    int m_dwNextPage = 0;						
    private int m_dwNumber = 10;					
    private int m_dwMaxPage = 5;					
    private boolean m_bLoadFinish = true; 		
    private Handler m_Handler;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		m_oActionBar = super.getActionBar();     
		setContentView(R.layout.alarm_report); 
		//Show home      
		m_oActionBar.setDisplayShowTitleEnabled(false);        
		m_oActionBar.setHomeButtonEnabled(false);  
		m_oActionBar.setDisplayUseLogoEnabled(false);
		m_oActionBar.setDisplayHomeAsUpEnabled(false); 
		m_oActionBar.setDisplayShowHomeEnabled(false);         
		m_oActionBar.setDisplayHomeAsUpEnabled(true);     	//Show Back Button      	
		
		m_oAlarmInfoListView = (ListView) super.findViewById(R.id.alarm_info);

        m_oAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, AlarmCallBack_PF.mAlarmlist);       
        m_oAlarmInfoListView.setAdapter(m_oAdapter);
        m_oAlarmInfoListView.setOnScrollListener(new OnScrollListener() 
        {
            public void onScrollStateChanged(AbsListView view, int scrollState) 
            {
                // TODO Auto-generated method stub
            }
            
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,int visibleItemCount, final int dwTotalItemCount)
            {
                int dwLastItemId = m_oAlarmInfoListView.getLastVisiblePosition();
                if((dwLastItemId + 1) == dwTotalItemCount)
                {
                    int dwCurrentPage = dwTotalItemCount % m_dwNumber ;
                    if(0 == dwCurrentPage)
                    {
                        dwCurrentPage = dwTotalItemCount / m_dwNumber ;
                    }
                    else
                    {
                        dwCurrentPage = (int)(dwTotalItemCount / m_dwNumber) + 1;
                    }
                    
                    m_dwNextPage = dwCurrentPage + 1; 
           
                    if(0 < dwTotalItemCount)
                    {
                        if((m_dwNextPage <= m_dwMaxPage) && (true == m_bLoadFinish))
                        {
                            m_bLoadFinish = false;
                        }
                    }
                }              
            }
        });
        
        m_Handler = new Handler()
        {
            @SuppressLint("HandlerLeak")
            public void handleMessage(Message msg)
            {
                if(0 == msg.what)
                {
                    m_oAdapter.notifyDataSetChanged();
                    m_bLoadFinish = true;
                }
                super.handleMessage(msg);
                if(m_oAlarmInfoListView.getFooterViewsCount()!=0)
                {

                }
            }
        };

        Button refreshButton = (Button) findViewById(R.id.refresh);
        refreshButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				m_oAdapter.notifyDataSetChanged();
				}
		});

      timer =new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(1);
            }
        },100,100);

	}
    Timer timer;
	Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what){
                case 1:
                    Log.e("ycf___","notifyDataSetChanged");
                    m_oAdapter.notifyDataSetChanged();
                    break;

            }
            return false;

        }
    });


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alarm_report, menu);
		return true;
	}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer!=null){
            timer.cancel();
            timer=null;
        }
        if (handler!=null){
        handler.removeCallbacksAndMessages(null);
        handler=null;}
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch ( id ) {
		case android.R.id.home:
			super.onBackPressed();
			finish();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/*** 菜单、返回键响应  */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{  // TODO Auto-generated method stub  
		if(keyCode == KeyEvent.KEYCODE_BACK) 
		{   
			super.onBackPressed();
			finish();
		}
			return false; 
	} 

	public static void updateAlarmInfoPage()
    {
        if(m_oAdapter != null) {
            m_oAdapter.notifyDataSetChanged();
        }
    }

}
