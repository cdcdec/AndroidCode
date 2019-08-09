package com.yzx.im_demo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.yzx.db.UserInfoDBManager;
import com.yzx.db.domain.UserInfo;
import com.yzx.im_demo.userdata.LoginHandler;
import com.yzx.mydefineview.MyToast;
import com.yzx.tools.NetWorkTools;
import com.yzx.tools.RestTools;
import com.yzx.tools.StringUtils;
import com.yzxtcp.UCSManager;
import com.yzxtcp.data.UcsReason;
import com.yzxtcp.listener.ILoginListener;
import com.yzxtcp.tools.CustomLog;
import com.yzxtcp.tools.tcp.packet.PacketSerialize;

import java.util.HashMap;
import java.util.List;

public class IMLoginV2Activity extends Activity {

    private static final String TAG = "IMLoginV2Activity";
    private EditText edt_account;
    private EditText edt_veri_code;
    private Button btn_login;
    private Button btn_obtain_vericode;
    private ImageView address_setting;
    private Handler mHandler;
    private String mAccount;
    //是否主动退出
    private boolean isBack;

    private UserInfo user;

    private static int VERI_CODE_SPAN = 60;// 获取短信验证码间隔时间，单位为秒
    private int countbackTime;// 短信验证码间隔倒数时间，单位为秒


    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "IMLoginV2Activity onNewIntent()");
        isBack = false;
        initView(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "IMLoginV2Activity onCreate()");
        setContentView(R.layout.activity_login_v2);
        RestTools.initUrl(IMLoginV2Activity.this);//初始化AS地址
        initView(this);

        initData(this);
        isBack = false;
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    @SuppressLint("HandlerLeak")
    private void initData(IMLoginV2Activity imLoginActivity) {

        btn_login.setOnClickListener(new OnClickListener() {

            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {

               /* if (NetWorkTools.isNetWorkConnect(IMLoginV2Activity.this) == false) {
                    MyToast.showLoginToast(IMLoginV2Activity.this,
                            "网络连接不可用，请重试");
                    return;
                }

                String overseaAccount = getSharedPreferences("YZX_DEMO", 1).getString("YZX_ACCOUNT_OVERSEA", "");
                if (!TextUtils.isEmpty(overseaAccount)) {
                    MyToast.showLoginToast(IMLoginV2Activity.this,
                            "当前选择的海外节点：" + overseaAccount);
                    RestTools.loginByToken(overseaAccount, mHandler, demoTestToken.get(overseaAccount));
                    return;
                }

                mAccount = edt_account.getText().toString();
                if (StringUtils.isEmpty(mAccount)) {
                    MyToast.showLoginToast(IMLoginV2Activity.this, "手机号不能为空");
                    return;
                }

                if (mAccount.length() != 11 || !StringUtils.isPhoneNumber(mAccount)) {
                    MyToast.showLoginToast(IMLoginV2Activity.this, "请输入正确的手机号码");
                    return;
                }

                //检查验证码是否存在
                String veriCode = null;
                List<UserInfo> userList = UserInfoDBManager.getInstance().getAll();
                for (int i = 0; i < userList.size(); i++) {
                    if (mAccount.equals(userList.get(i).getAccount())) {
                        veriCode = userList.get(i).getVeriCode();
                        break;
                    }
                }

                if (veriCode == null || veriCode.length() == 0) {
                    veriCode = edt_veri_code.getText().toString();
                }
                if (veriCode == null || veriCode.length() == 0) {
                    MyToast.showLoginToast(IMLoginV2Activity.this, "请先输入验证码");
                    return;
                }

                mHandler.sendEmptyMessage(RestTools.LOGIN_REST_STARTGETTOKEN);
//				RestTools.getToken(mAccount, mHandler);
                btn_login.setClickable(false);
                getSharedPreferences("YZX_DEMO", 1).edit()
                        .putString("YZX_ACCOUNT_INDEX", mAccount).commit();
                final String veriCodeTmp = veriCode;
                enableVeriCodeBtn(true);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        //RestTools.getToken(IMLoginV2Activity.this,mAccount, mHandler);
                        //使用验证码登录认证
                        RestTools.getToken(IMLoginV2Activity.this, mAccount, veriCodeTmp, mHandler);
                    }
                }, 100);
*/

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        //RestTools.getToken(IMLoginV2Activity.this,mAccount, mHandler);
                        //使用验证码登录认证
                        //RestTools.getToken(IMLoginV2Activity.this, mAccount, veriCodeTmp, mHandler);
                        RestTools.loginByToken("smt0209",mHandler,"eyJBbGciOiJIUzI1NiIsIkFjY2lkIjoiMWM2NGE2MzMwZTRhNDRlMWI4ODQwN2UzYmM5OGRmNDEiLCJBcHBpZCI6IjgxNTBiMDQ4ZWQ3OTRmM2U4NzQzOWViZmMxY2I2N2QwIiwiVXNlcmlkIjoiMTEwMDA3MzYifQ==.JmDnMo8vZtbPhEN1zjIf18ctVMVYRl/PL2ihEc400dA=");
                    }
                }, 100);


//                UCSManager.connect("eyJBbGciOiJIUzI1NiIsIkFjY2lkIjoiMWM2NGE2MzMwZTRhNDRlMWI4ODQwN2UzYmM5OGRmNDEiLCJBcHBpZCI6IjgxNTBiMDQ4ZWQ3OTRmM2U4NzQzOWViZmMxY2I2N2QwIiwiVXNlcmlkIjoiMTEwMDA3MzYifQ==.JmDnMo8vZtbPhEN1zjIf18ctVMVYRl/PL2ihEc400dA=", new ILoginListener() {
//                    @Override
//                    public void onLogin(UcsReason ucsReason) {
//                        //移出登录监听回调
//                        UCSManager.removeLoginListener(this);
//
//                        Intent intent = new Intent(IMLoginV2Activity.this, VideoConverseActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
////					intent.putExtra("userName",conversationinfo.getConversationTitle());
////					intent.putExtra("userId", conversationinfo.getTargetId());
////					intent.putExtra("call_phone", conversationinfo.getTargetId());
////					intent.putExtra("call_position", "");
//
//
//                        intent.putExtra("userName","smt0209");
//                        intent.putExtra("userId", "smt0209");
//                        intent.putExtra("call_phone", "smt0209");
//                        IMLoginV2Activity.this.startActivity(intent);






            }
        });

        //获取验证码
        btn_obtain_vericode.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                enableVeriCodeBtn(false);
                startCountback();

                //隐藏软键盘
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(edt_account.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(edt_veri_code.getWindowToken(), 0);

                if (NetWorkTools.isNetWorkConnect(IMLoginV2Activity.this) == false) {
                    MyToast.showLoginToast(IMLoginV2Activity.this,
                            "网络连接不可用，请重试");
                    enableVeriCodeBtn(true);
                    return;
                }
                mAccount = edt_account.getText().toString();

                if (StringUtils.isEmpty(mAccount)) {
                    MyToast.showLoginToast(IMLoginV2Activity.this, "手机号不能为空");
                    enableVeriCodeBtn(true);
                    return;
                }
                if (mAccount.length() != 11 || !StringUtils.isPhoneNumber(mAccount)) {
                    MyToast.showLoginToast(IMLoginV2Activity.this, "请输入正确的手机号码");
                    enableVeriCodeBtn(true);
                    return;
                }

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        RestTools.getVeriCode(IMLoginV2Activity.this, mAccount, mHandler);
                    }
                }, 100);
            }

        });

        mHandler = new LoginHandler(this) {
            @Override
            public void handleMessage(Message msg) {
                // TODO Auto-generated method stub
                switch (msg.what) {
                    case RestTools.LOGIN_STATUS_FAIL:
//				case RestTools.LOGIN_REST_UNREGISTER:
                        this.closeProgressDialog();
                        btn_login.setClickable(true);
                        break;
                    case RestTools.LOGIN_REST_STARTGETTOKEN:
                        this.showProgressDialog();
                        this.startLoginTimer();
                        break;
                    case RestTools.LOGIN_REST_UNREGISTER:
                        this.closeProgressDialog();
                        stopLoginTimer();
                        btn_login.setClickable(true);
                        Intent intent = new Intent(IMLoginV2Activity.this, IMRegisterV2Activity.class);
                        intent.putExtra("phoneNum", mAccount);
                        startActivity(intent);
                        break;
                    case RestTools.LOGIN_REST_FINISH:
//					IMLoginV2Activity.this.finish();
                        edt_veri_code.setText("");
                        break;
                    case RestTools.LOGIN_STATUS_TIMEOUT:
                        btn_login.setClickable(true);
                        break;
                    case RestTools.OBTAIN_VERI_CODE: {
                        if (msg.arg1 == 0) {
                            String strTime = msg.getData().getString("expireTime", "0");
                            int expireTime = Integer.valueOf(strTime);
                            MyToast.showLoginToast(IMLoginV2Activity.this, "验证码已成功发送，请注意查收");
                            CustomLog.v("获取验证码成功 expireTime = " + expireTime);
                            if (expireTime <= 0) {
                                enableVeriCodeBtn(true);
                                MyToast.showLoginToast(IMLoginV2Activity.this, "验证码已过期, expireTime：" + expireTime);
                            }

                        } else {
                            enableVeriCodeBtn(true);
                            MyToast.showLoginToast(IMLoginV2Activity.this, "获取验证码失败，请重试");
                            CustomLog.v("获取验证码失败, 错误码：" + msg.arg1);
                        }
                        break;
                    }
                }
                super.handleMessage(msg);
            }
        };


    }

    private void initView(Context context) {
        //清空登录用户
        UserInfo oldUser = UserInfoDBManager.getInstance().getCurrentLoginUser();
        if (oldUser != null) {
            oldUser.setLoginStatus(0);
            UserInfoDBManager.getInstance().update(oldUser);
        }
        user = UserInfoDBManager.getInstance().getDefaultLoginUser(false);
        edt_account = (EditText) findViewById(R.id.edt_account);
        edt_veri_code = (EditText) findViewById(R.id.edt_veri_code);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_obtain_vericode = (Button) findViewById(R.id.btn_obtain_veri_code);
        edt_account.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() < 11) {
                    btn_obtain_vericode.setClickable(false);
                    btn_obtain_vericode.setTextColor(getResources().getColor(R.color.login_btn_normal));
                    btn_obtain_vericode.setBackgroundResource(R.drawable.btnstyle_normal);
                } else {
                    btn_obtain_vericode.setClickable(true);
                    btn_obtain_vericode.setTextColor(getResources().getColor(R.color.btn_press_color));
                    btn_obtain_vericode.setBackgroundResource(R.drawable.buttonstyle);
                }
            }
        });
        btn_obtain_vericode.setClickable(true);
        address_setting = (ImageView) findViewById(R.id.address_setting);
        btn_login.setClickable(true);
        if (user != null) {
            mAccount = user.getAccount();
        } else {
            mAccount = "";
        }
        if (mAccount != null) {
            edt_account.setText(mAccount);
            edt_account.setSelection(mAccount.length());
        }
        address_setting.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IMLoginV2Activity.this, AddressConfigActivity.class);
                //启动配置页面
                startActivity(intent);
            }
        });
    }

    /**
     * @param bEnable 是否使能
     * @return void    返回类型
     * @Description 设置获取验证码按钮使能状态
     * @date 2015年12月27日 下午3:53:27
     * @author zhj
     */
    void enableVeriCodeBtn(boolean bEnable) {
        if (bEnable) {
            if (veriHandler != null) {
                veriHandler.removeCallbacks(VerRunnable);
            }
            btn_obtain_vericode.setText(IMLoginV2Activity.this.getString(R.string.obtain_veri_code));
            btn_obtain_vericode.setClickable(true);
            btn_obtain_vericode.setBackgroundResource(R.drawable.buttonstyle);
            btn_obtain_vericode.setTextColor(getResources().getColor(R.color.btn_press_color));
        } else {
            btn_obtain_vericode.setClickable(false);
            btn_obtain_vericode.setBackgroundResource(R.drawable.buttonstyle_disable);
            btn_obtain_vericode.setTextColor(getResources().getColor(R.color.text_gray));
        }
    }

    Handler veriHandler = null;
    Runnable VerRunnable = null;

    /**
     * @return void    返回类型
     * @Description 启动验证码失效倒计时
     * @date 2015年12月17日 上午10:05:21
     * @author zhj
     */
    private void startCountback() {
        enableVeriCodeBtn(false);
        countbackTime = VERI_CODE_SPAN;
        veriHandler = new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what > 0) {
                    btn_obtain_vericode.setText(countbackTime + "s");
                } else {
                    this.removeCallbacks(VerRunnable); //结束循环
                    enableVeriCodeBtn(true);
                }
            }
        };

        VerRunnable = new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                //要做的事情
                veriHandler.postDelayed(this, 1000);
                veriHandler.sendEmptyMessage(--countbackTime);

            }
        };

        veriHandler.postDelayed(VerRunnable, 1000); //启动循环

    }

    public static final HashMap<Integer, String> loginErrorCode = new HashMap<Integer, String>();
    public static final HashMap<String, String> demoTestToken = new HashMap<String, String>();

    static {
        loginErrorCode.put(2001, "验证码过期");
        loginErrorCode.put(2002, "验证码不正确");
        loginErrorCode.put(2003, "手机号码为空");
        loginErrorCode.put(2004, "验证码为空");
        loginErrorCode.put(2005, "昵称为空");
        loginErrorCode.put(2006, "查无数据");
        loginErrorCode.put(2007, "发送短信验证码失败");
        loginErrorCode.put(2008, "创建用户失败");
        loginErrorCode.put(2009, "参数不正确");
        loginErrorCode.put(2011, "手机号码未注册");
        loginErrorCode.put(2012, "手机号码不正确");
        loginErrorCode.put(2013, "加入群组失败");
        loginErrorCode.put(2099, "其他错误");
        loginErrorCode.put(-1, "其他错误");
    }

    static {
        demoTestToken.put("", "");
        demoTestToken.put("demotest1", "eyJBbGciOiJIUzI1NiIsIkFjY2lkIjoiZjY3YjNiODFkZmM5OWY3NDA2OGMwYTU2NTA1M2IxMWUiLCJBcHBpZCI6ImUyMjQ4ODdiOTE4NDQ1OTBiMmI3ZWE1Mzc0M2YzOTFjIiwiVXNlcmlkIjoiZGVtb3Rlc3QxIn0=.fm5VEBUa4uugjVrUwYtOyZ1uVwgcBBnI9cM3y1pICEg=");
        demoTestToken.put("demotest2", "eyJBbGciOiJIUzI1NiIsIkFjY2lkIjoiZjY3YjNiODFkZmM5OWY3NDA2OGMwYTU2NTA1M2IxMWUiLCJBcHBpZCI6ImUyMjQ4ODdiOTE4NDQ1OTBiMmI3ZWE1Mzc0M2YzOTFjIiwiVXNlcmlkIjoiZGVtb3Rlc3QyIn0=.11sMVJjhKNYAlI9Jlw3tqvYbzEV4Hg+Lr6x3QD/tZJM=");
        demoTestToken.put("demotest3", "eyJBbGciOiJIUzI1NiIsIkFjY2lkIjoiZjY3YjNiODFkZmM5OWY3NDA2OGMwYTU2NTA1M2IxMWUiLCJBcHBpZCI6ImUyMjQ4ODdiOTE4NDQ1OTBiMmI3ZWE1Mzc0M2YzOTFjIiwiVXNlcmlkIjoiZGVtb3Rlc3QzIn0=.F508z2sY1XThUSfiVZqyGc+2cdcLsOntvno61mzRYCc=");
        demoTestToken.put("demotest4", "eyJBbGciOiJIUzI1NiIsIkFjY2lkIjoiZjY3YjNiODFkZmM5OWY3NDA2OGMwYTU2NTA1M2IxMWUiLCJBcHBpZCI6ImUyMjQ4ODdiOTE4NDQ1OTBiMmI3ZWE1Mzc0M2YzOTFjIiwiVXNlcmlkIjoiZGVtb3Rlc3Q0In0=.xT0PheQz3rTUh/aNigrLcpbyhWxsbRpcofS6OB3otA0=");
        demoTestToken.put("demotest5", "eyJBbGciOiJIUzI1NiIsIkFjY2lkIjoiZjY3YjNiODFkZmM5OWY3NDA2OGMwYTU2NTA1M2IxMWUiLCJBcHBpZCI6ImUyMjQ4ODdiOTE4NDQ1OTBiMmI3ZWE1Mzc0M2YzOTFjIiwiVXNlcmlkIjoiZGVtb3Rlc3Q1In0=.JgyKeGbogbIFfNYqCLCjg2SXjZFbyY3p0I8BoNhpmF4=");
        demoTestToken.put("demotest6", "eyJBbGciOiJIUzI1NiIsIkFjY2lkIjoiZjY3YjNiODFkZmM5OWY3NDA2OGMwYTU2NTA1M2IxMWUiLCJBcHBpZCI6ImUyMjQ4ODdiOTE4NDQ1OTBiMmI3ZWE1Mzc0M2YzOTFjIiwiVXNlcmlkIjoiZGVtb3Rlc3Q2In0=.e0HZzVs4lp6a4cEHzkF/tMdaFB5oenZwK55J29Uav3U=");
        demoTestToken.put("demotest7", "eyJBbGciOiJIUzI1NiIsIkFjY2lkIjoiZjY3YjNiODFkZmM5OWY3NDA2OGMwYTU2NTA1M2IxMWUiLCJBcHBpZCI6ImUyMjQ4ODdiOTE4NDQ1OTBiMmI3ZWE1Mzc0M2YzOTFjIiwiVXNlcmlkIjoiZGVtb3Rlc3Q3In0=.ZN7oH9sr/HefL5WQe4R9mXkYkPwTG4LkkB0m7JW90+0=");
        demoTestToken.put("demotest8", "eyJBbGciOiJIUzI1NiIsIkFjY2lkIjoiZjY3YjNiODFkZmM5OWY3NDA2OGMwYTU2NTA1M2IxMWUiLCJBcHBpZCI6ImUyMjQ4ODdiOTE4NDQ1OTBiMmI3ZWE1Mzc0M2YzOTFjIiwiVXNlcmlkIjoiZGVtb3Rlc3Q4In0=.vfwtNK99ejqZ8m+7s3gXwYGUTIqaf5xyUhORy/ZDdkg=");
        demoTestToken.put("demotest9", "eyJBbGciOiJIUzI1NiIsIkFjY2lkIjoiZjY3YjNiODFkZmM5OWY3NDA2OGMwYTU2NTA1M2IxMWUiLCJBcHBpZCI6ImUyMjQ4ODdiOTE4NDQ1OTBiMmI3ZWE1Mzc0M2YzOTFjIiwiVXNlcmlkIjoiZGVtb3Rlc3Q5In0=.WjLDE9H0A16YUY0ceEKfvy9YJvgai1RmgKEIPCpozXY=");
        demoTestToken.put("demotest10", "eyJBbGciOiJIUzI1NiIsIkFjY2lkIjoiZjY3YjNiODFkZmM5OWY3NDA2OGMwYTU2NTA1M2IxMWUiLCJBcHBpZCI6ImUyMjQ4ODdiOTE4NDQ1OTBiMmI3ZWE1Mzc0M2YzOTFjIiwiVXNlcmlkIjoiZGVtb3Rlc3QxMCJ9.OQ43ZoYdpq1YyNCYk6quVPFxxq8TTPvEWkRo3eHqQAk=");


    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }
}
