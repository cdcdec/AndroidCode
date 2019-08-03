package com.yzx.im_demo;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.yzx.mydefineview.YzxTopBar;
import com.yzx.tools.AddressTools;
import com.yzx.tools.RestTools;
import com.yzxtcp.tools.CustomLog;

/**
 * 配置服务器地址界面
 *
 * @author zhuqian
 */
public class AddressConfigActivity extends Activity implements OnClickListener,
        CompoundButton.OnCheckedChangeListener {

    private YzxTopBar topBar;
    private EditText as_address;
    private EditText as_port;
    private EditText tcp_address;
    private EditText tcp_port;
    private EditText cps_address;
    private EditText cps_port;
    private EditText rtpp_address;
    private EditText rtpp_port;
    private Button address_ok;
    private Button address_reset;
    private CheckBox mChkDebug;
    private EditText et_recall_time;
    private Button btn_recall_time;
    private CheckBox chkRecall;
    private CheckBox chkPreviewImg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_config);

        initViews();
        initSpinner();
    }

    private int mCheckPosition = 0;//当前选中海外测试账户id
    private Spinner encryptionSpinner;


    private void initViews() {
        topBar = (YzxTopBar) findViewById(R.id.actionBar_addressConfig);
        topBar.setTitle("服务器地址配置");
        topBar.setBackBtnOnclickListener(this);
        as_address = (EditText) findViewById(R.id.as_address);
        as_port = (EditText) findViewById(R.id.as_port);
        tcp_address = (EditText) findViewById(R.id.tcp_address);
        tcp_port = (EditText) findViewById(R.id.tcp_port);
        address_ok = (Button) findViewById(R.id.address_ok);
        address_reset = (Button) findViewById(R.id.address_reset);
        cps_address = (EditText) findViewById(R.id.cps_address);
        cps_port = (EditText) findViewById(R.id.cps_port);
        rtpp_address = (EditText) findViewById(R.id.rtpp_address);
        rtpp_port = (EditText) findViewById(R.id.rtpp_port);
        mChkDebug = (CheckBox) findViewById(R.id.id_checkbox_debug);
        chkRecall = (CheckBox) findViewById(R.id.id_checkbox_recall);
        chkPreviewImg = (CheckBox) findViewById(R.id.id_checkbox_previewImg);
        et_recall_time = (EditText) findViewById(R.id.et_recall_time);
        btn_recall_time = (Button) findViewById(R.id.btn_recall_time);

        String asAddressAndPort = getSharedPreferences("YZX_DEMO_DEFAULT", 0).getString("YZX_ASADDRESS", "");
//		asAddressAndPort = "113.31.89.149:8830";
        String tcpAddressAndPort = getSharedPreferences("YZX_DEMO_DEFAULT", 0).getString("YZX_CSADDRESS", "");
//		tcpAddressAndPort = "113.31.130.125:81";
        String cpsAddressAndPort = getSharedPreferences("YZX_DEMO_DEFAULT", 0).getString("YZX_CPSADDRESS", "");
//		cpsAddressAndPort = "113.31.89.144:9997";
        String rtppAddressAndPort = getSharedPreferences("YZX_DEMO_DEFAULT", 0).getString("YZX_RTPPADDRESS", "");
        boolean avDebug = getSharedPreferences("YZX_DEMO_DEFAULT", 0).getBoolean("YZX_AVDEBUG", false);
        mChkDebug.setChecked(avDebug);
        boolean avRecall = getSharedPreferences("YZX_DEMO_DEFAULT", 0).getBoolean("YZX_AVDRECALL", true);
        chkRecall.setChecked(avRecall);
        boolean avPreviewImg = getSharedPreferences("YZX_DEMO_DEFAULT", 0).getBoolean("YZX_PREVIEW_IMG", false);
        chkPreviewImg.setChecked(avPreviewImg);

        if (!TextUtils.isEmpty(asAddressAndPort)) {
            if (asAddressAndPort.split(":").length == 2) {
                as_address.setText(asAddressAndPort.split(":")[0]);
                as_port.setText(asAddressAndPort.split(":")[1]);
            }
        } else {
            as_port.setText("");
            as_address.setText("");
        }
        as_address.setSelection(as_address.getText().toString().length());
        if (!TextUtils.isEmpty(tcpAddressAndPort)) {
            if (tcpAddressAndPort.split(":").length == 2) {
                tcp_address.setText(tcpAddressAndPort.split(":")[0]);
                tcp_port.setText(tcpAddressAndPort.split(":")[1]);
            }
        } else {
            tcp_address.setText("");
            tcp_port.setText("");
        }
        if (!TextUtils.isEmpty(cpsAddressAndPort)) {
            if (cpsAddressAndPort.split(":").length == 2) {
                cps_address.setText(cpsAddressAndPort.split(":")[0]);
                cps_port.setText(cpsAddressAndPort.split(":")[1]);
            }
        } else {
            cps_address.setText("");
            cps_port.setText("");
        }
        if (!TextUtils.isEmpty(rtppAddressAndPort)) {
            if (rtppAddressAndPort.split(":").length == 2) {
                rtpp_address.setText(rtppAddressAndPort.split(":")[0]);
                rtpp_port.setText(rtppAddressAndPort.split(":")[1]);
            }
        } else {
            rtpp_address.setText("");
            rtpp_port.setText("");
        }
        address_ok.setOnClickListener(this);
        address_reset.setOnClickListener(this);
        mChkDebug.setOnCheckedChangeListener(this);
        chkRecall.setOnCheckedChangeListener(this);
        btn_recall_time.setOnClickListener(this);
        chkPreviewImg.setOnCheckedChangeListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (encryptionSpinner != null) {
            encryptionSpinner.setSelection(0);
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imbtn_back:
                //返回
                finish();
                break;
            case R.id.address_ok:
                //save
                String asAddress = as_address.getText().toString();
                String asPort = as_port.getText().toString();
                String tcpAddress = tcp_address.getText().toString();
                String tcpPort = tcp_port.getText().toString();
                String cpsAddress = cps_address.getText().toString();
                String cpsPort = cps_port.getText().toString();
                String rtppAddress = rtpp_address.getText().toString();
                String rtppPort = rtpp_port.getText().toString();

                if (!checkIPSetIsValid(asAddress, asPort) ||
                        !checkIPSetIsValid(tcpAddress, tcpPort) ||
                        !checkIPSetIsValid(cpsAddress, cpsPort) ||
                        !checkIPSetIsValid(rtppAddress, rtppPort)
                        ) {
                    Toast.makeText(this, "地址或者端口不能为空或不合法", Toast.LENGTH_SHORT).show();
                    return;
                }

			/*if(!AddressTools.isPort(asPort) || !AddressTools.isPort(tcpPort) || !AddressTools.isPort(cpsPort)){
                Toast.makeText(this, "您输入的端口不合法", Toast.LENGTH_SHORT).show();
				return;
			}
			if(!AddressTools.isNetAddress(asAddress) || !AddressTools.isNetAddress(tcpAddress)
					|| !AddressTools.isNetAddress(cpsAddress)){
				Toast.makeText(this, "您输入的地址不合法", Toast.LENGTH_SHORT).show();
				return;
			}*/
                if (TextUtils.isEmpty(asAddress) && TextUtils.isEmpty(asPort)) {
                    getSharedPreferences("YZX_DEMO_DEFAULT", 0).edit().putString("YZX_ASADDRESS", "").commit();
                } else {
                    getSharedPreferences("YZX_DEMO_DEFAULT", 0).edit().putString("YZX_ASADDRESS", asAddress + ":" + asPort).commit();
                }

                if (TextUtils.isEmpty(tcpAddress) && TextUtils.isEmpty(tcpPort)) {
                    getSharedPreferences("YZX_DEMO_DEFAULT", 0).edit().putString("YZX_CSADDRESS", "").commit();
                } else {
                    getSharedPreferences("YZX_DEMO_DEFAULT", 0).edit().putString("YZX_CSADDRESS", tcpAddress + ":" + tcpPort).commit();
                }

                if (TextUtils.isEmpty(cpsAddress) && TextUtils.isEmpty(cpsPort)) {
                    getSharedPreferences("YZX_DEMO_DEFAULT", 0).edit().putString("YZX_CPSADDRESS", "").commit();
                } else {
                    getSharedPreferences("YZX_DEMO_DEFAULT", 0).edit().putString("YZX_CPSADDRESS", cpsAddress + ":" + cpsPort).commit();
                }

                if (TextUtils.isEmpty(rtppAddress) && TextUtils.isEmpty(rtppPort)) {
                    getSharedPreferences("YZX_DEMO_DEFAULT", 0).edit().putString("YZX_RTPPADDRESS", "").commit();
                } else {
                    getSharedPreferences("YZX_DEMO_DEFAULT", 0).edit().putString("YZX_RTPPADDRESS", rtppAddress + ":" + rtppPort).commit();
                }

                Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
                RestTools.initUrl(AddressConfigActivity.this);
                break;
            case R.id.address_reset:
                //reset
                getSharedPreferences("YZX_DEMO_DEFAULT", 0).edit().clear().commit();
                Toast.makeText(this, "清除成功", Toast.LENGTH_SHORT).show();
                as_address.setText("");
                as_port.setText("");
                tcp_port.setText("");
                tcp_address.setText("");
                cps_address.setText("");
                cps_port.setText("");
                rtpp_address.setText("");
                rtpp_port.setText("");
                et_recall_time.setText("");
                break;
            case R.id.btn_recall_time: // 保存重呼超时时间
                if (!TextUtils.isEmpty(et_recall_time.getText().toString())) {
                    getSharedPreferences("YZX_DEMO_DEFAULT", 0).edit().putString("recall_timer", et_recall_time.getText().toString()).commit();
                    Toast.makeText(AddressConfigActivity.this, "设置成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddressConfigActivity.this, "不能为空，默认重呼超时时间为60秒", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    /**
     * 初始化海外测试账户选择器
     */
    private void initSpinner() {

        encryptionSpinner = (Spinner) findViewById(R.id.encryption_mode);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.encryption_mode_values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        encryptionSpinner.setAdapter(adapter);

        encryptionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mCheckPosition = position;
                if (mCheckPosition == 0) {
                    getSharedPreferences("YZX_DEMO", 1).edit()
                            .putString("YZX_ACCOUNT_OVERSEA", "").commit();
                } else {
                    getSharedPreferences("YZX_DEMO", 1).edit()
                            .putString("YZX_ACCOUNT_OVERSEA", encryptionSpinner.getSelectedItem().toString()).commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        encryptionSpinner.setSelection(mCheckPosition);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == R.id.id_checkbox_debug) {
            getSharedPreferences("YZX_DEMO_DEFAULT", 0).edit().putBoolean("YZX_AVDEBUG", isChecked).commit();
            CustomLog.d("debug isChecked:" + isChecked);
        } else if (buttonView.getId() == R.id.id_checkbox_recall) {
            getSharedPreferences("YZX_DEMO_DEFAULT", 0).edit().putBoolean("YZX_AVDRECALL", isChecked).commit();
            CustomLog.d("recall isChecked:" + isChecked);
        } else if (buttonView.getId() == R.id.id_checkbox_previewImg) {
            getSharedPreferences("YZX_DEMO_DEFAULT", 0).edit().putBoolean("YZX_PREVIEW_IMG", isChecked).commit();
            CustomLog.d("preview img isChecked:" + isChecked);
        }
    }

    /**
     * @param ip
     * @param port
     * @return
     * @author zhangbin
     * @2016-3-15
     * @descript:判断输入的IP是否合法 同时为NULL或都有值为TRUE
     */
    private boolean checkIPSetIsValid(String ip, String port) {
        if (TextUtils.isEmpty(ip) && TextUtils.isEmpty(port)) {
            System.out.println("zz 444444");
            return true;
        } else if (!TextUtils.isEmpty(ip) && !TextUtils.isEmpty(ip)) {
            System.out.println("zz 111111");
            if (AddressTools.isNetAddress(ip) && AddressTools.isPort(port)) {
                System.out.println("zz 222222");
                return true;
            } else {
                System.out.println("zz 333333");
                return false;
            }
        } else {
            System.out.println("zz 555555");
            return false;
        }
    }
}
