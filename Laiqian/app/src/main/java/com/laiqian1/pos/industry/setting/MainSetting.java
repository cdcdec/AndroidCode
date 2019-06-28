package com.laiqian.pos.industry.setting;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.auth.ModifyUserPasswordDialog;
import com.laiqian.auth.bn;
import com.laiqian.auth.cj;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.f.b;
import com.laiqian.k.a;
import com.laiqian.milestone.h;
import com.laiqian.models.bh;
import com.laiqian.pos.hardware.q;
import com.laiqian.setting.SettingAboutFragment;
import com.laiqian.setting.SettingAlipayFragment;
import com.laiqian.setting.SettingBackupAndDeleteDataFragment;
import com.laiqian.setting.SettingCashierFragment;
import com.laiqian.setting.SettingMallFragment;
import com.laiqian.setting.SettingMemberFragment;
import com.laiqian.setting.SettingOrderDishesFragment;
import com.laiqian.setting.SettingPrinterFragment;
import com.laiqian.setting.SettingProductFragment;
import com.laiqian.setting.SettingPurchaseFragment;
import com.laiqian.setting.SettingReportFragment;
import com.laiqian.setting.SettingTakeOutFoodFragment;
import com.laiqian.setting.SettingWechatsFragment;
import com.laiqian.sync.a.g;
import com.laiqian.takeaway.ay;
import com.laiqian.ui.FragmentActivityRoot;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.a.r;
import com.laiqian.util.an;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.bd;
import com.laiqian.wallet.WalletSettingFragment;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONObject;

public class MainSetting extends FragmentActivityRoot implements bn {
  public static final int ABOUT_CLOUD_POS = 90014;
  
  public static final int ALIPAY = 90003;
  
  public static final int BACKUP_AND_DELETE_DATA = 90013;
  
  public static final int CASHIER_SCREEN = 90009;
  
  public static final int MALL = 90011;
  
  public static final int MEMBER = 90006;
  
  public static final int ORDER_DISHES = 90008;
  
  public static final int PRINTER = 90005;
  
  public static final int PRODUCT = 90007;
  
  public static final int PURCHASE = 90012;
  
  public static final int REPORT = 90001;
  
  public static final int TAKE_OUT_FOOD = 90002;
  
  public static final int WALLET = 90010;
  
  public static final int WECHAT = 90004;
  
  public static boolean bIsDownloading = false;
  
  public static boolean bIsUploading = false;
  
  static HashMap<String, String> hmClickGroups = new HashMap();
  
  private static final String nGroupID = "nGroupID";
  
  private static final String nWindow = "nWindow";
  
  public static final String sChangePWDReceive = "sMainChangePWDReceive";
  
  private static final String sItemImage = "sItemImage";
  
  private static final String sItemText = "nItemText";
  
  BroadcastReceiver accountReceiver = new am(this);
  
  private boolean bBoss = true;
  
  private boolean bFragmentAdded = false;
  
  private boolean bHasShop;
  
  private Fragment fCurrentPage;
  
  private View.OnClickListener leftLLClickListener = new an(this);
  
  private ScrollView leftScrollView;
  
  private Fragment mAboutSetting;
  
  private Fragment mAlipay;
  
  private Fragment mBackupAndDeleteDataSetting;
  
  private Fragment mCashierScreenSetting;
  
  private Handler mHandler = new ao(this);
  
  private LayoutInflater mLayoutInflater;
  
  private Fragment mMall;
  
  private Fragment mMember;
  
  private ModifyUserPasswordDialog mModifyUserPasswordDialog;
  
  private Fragment mOrderDishes;
  
  private Fragment mPrinterSetting;
  
  private Fragment mPurchase;
  
  private Fragment mReportSetting;
  
  private Fragment mTake_Out_Food;
  
  private bb mWaitingDialog = null;
  
  private Fragment mWalletSetting;
  
  private Fragment mWechat;
  
  String nUserID;
  
  private HashMap<String, String> oldUserInfo;
  
  private PopupWindow permissionPopupWindow;
  
  private Fragment productFragment;
  
  private String sBossNewPassword;
  
  String sPositionTag_Setting_TwoLevel_Group = "sPositionTag_Setting_TwoLevel_Group";
  
  String sUserPassword;
  
  private View selectedView = null;
  
  private LinearLayout svMainSetting;
  
  private LinearLayout svMainSettingMenu;
  
  private g syncManager;
  
  Handler uploadHandler = new al(this);
  
  private void ShowProgress() {
    if (this.mWaitingDialog == null)
      this.mWaitingDialog = new bb(this); 
    this.mWaitingDialog.setCancelable(false);
    this.mWaitingDialog.show();
  }
  
  private void UpdateLocalPassWord(String paramString) {
    av av = new av(this);
    av.qL(paramString);
    av.close();
  }
  
  private void addFragment(Fragment paramFragment, boolean paramBoolean) {
    int i;
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    if (this.fCurrentPage != null)
      fragmentTransaction.remove(this.fCurrentPage); 
    this.fCurrentPage = paramFragment;
    if (paramBoolean) {
      i = 2131297051;
    } else {
      i = 2131297052;
    } 
    if (this.bFragmentAdded) {
      fragmentTransaction.replace(i, this.fCurrentPage);
    } else if (!paramFragment.isAdded()) {
      fragmentTransaction.add(i, this.fCurrentPage);
    } 
    fragmentTransaction.commitAllowingStateLoss();
    this.bFragmentAdded = true;
  }
  
  private boolean checkNetwork() {
    boolean bool = bd.bH(this);
    if (!bd.bH(this))
      (new bc(this)).show(); 
    return bool;
  }
  
  private void drawItemsByGroup(int paramInt) {
    String str2;
    String str3 = "";
    String str4 = "";
    switch (paramInt) {
      default:
        str1 = str3;
        str2 = str4;
        if (this.fCurrentPage != null) {
          try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(this.fCurrentPage);
            fragmentTransaction.commit();
            this.bFragmentAdded = false;
            String str = str3;
            str2 = str4;
          } catch (Exception str1) {
            a.e(str1);
            str2 = str4;
            str1 = str3;
          } 
          sendCustomEvent(this, str2, str1);
          return;
        } 
        break;
      case 90014:
        str1 = "SettingAboutFragment";
        str2 = "关于";
        if (this.mAboutSetting == null)
          this.mAboutSetting = new SettingAboutFragment(); 
        addFragment(this.mAboutSetting, false);
        break;
      case 90013:
        str1 = "SettingAboutFragment";
        str2 = "数据处理";
        if (this.mBackupAndDeleteDataSetting == null)
          this.mBackupAndDeleteDataSetting = new SettingBackupAndDeleteDataFragment(); 
        addFragment(this.mBackupAndDeleteDataSetting, false);
        break;
      case 90012:
        str1 = "SettingPurchaseFragment";
        str2 = "采购";
        if (this.mPurchase == null)
          this.mPurchase = new SettingPurchaseFragment(); 
        addFragment(this.mPurchase, false);
        break;
      case 90011:
        str1 = "SettingMallFragment";
        str2 = "商城";
        if (this.mMall == null)
          this.mMall = new SettingMallFragment(); 
        addFragment(this.mMall, false);
        break;
      case 90010:
        str1 = "WalletSettingFragment";
        str2 = "钱包";
        if (this.mWalletSetting == null)
          this.mWalletSetting = new WalletSettingFragment(); 
        addFragment(this.mWalletSetting, false);
        break;
      case 90009:
        str1 = "SettingCashierFragment";
        str2 = "收银设置";
        if (this.mCashierScreenSetting == null)
          this.mCashierScreenSetting = new SettingCashierFragment(); 
        addFragment(this.mCashierScreenSetting, false);
        break;
      case 90008:
        str1 = "SettingOrderDishesFragment";
        str2 = "点菜";
        if (this.mOrderDishes == null)
          this.mOrderDishes = new SettingOrderDishesFragment(); 
        addFragment(this.mOrderDishes, false);
        break;
      case 90007:
        str1 = "SettingProductFragment";
        str2 = "商品";
        if (this.productFragment == null)
          this.productFragment = new SettingProductFragment(); 
        addFragment(this.productFragment, false);
        break;
      case 90006:
        str1 = "SettingMemberFragment";
        str2 = "会员";
        if (this.mMember == null)
          this.mMember = new SettingMemberFragment(); 
        addFragment(this.mMember, false);
        break;
      case 90005:
        str1 = "SettingPrinterFragment";
        str2 = "打印机与外设";
        if (this.mPrinterSetting == null)
          this.mPrinterSetting = new SettingPrinterFragment(); 
        addFragment(this.mPrinterSetting, false);
        break;
      case 90004:
        str1 = "SettingWechatsFragment";
        str2 = "微信";
        if (this.mWechat == null)
          this.mWechat = new SettingWechatsFragment(); 
        addFragment(this.mWechat, false);
        break;
      case 90003:
        str1 = "SettingAlipayFragment";
        str2 = "支付宝";
        if (this.mAlipay == null)
          this.mAlipay = new SettingAlipayFragment(); 
        addFragment(this.mAlipay, false);
        break;
      case 90002:
        str1 = "SettingTakeOutFoodFragment";
        str2 = "外卖";
        if (this.mTake_Out_Food == null)
          this.mTake_Out_Food = new SettingTakeOutFoodFragment(); 
        addFragment(this.mTake_Out_Food, false);
        break;
      case 90001:
        str1 = "SettingReportFragment";
        str2 = "报表";
        if (this.mReportSetting == null)
          this.mReportSetting = new SettingReportFragment(); 
        addFragment(this.mReportSetting, false);
        break;
    } 
    sendCustomEvent(this, str2, str1);
  }
  
  private void drawLeftLayout(ArrayList<HashMap<String, Object>> paramArrayList) {
    Iterator iterator = paramArrayList.iterator();
    String str = "";
    for (byte b = 0; iterator.hasNext(); b++) {
      HashMap hashMap = (HashMap)iterator.next();
      if (!b)
        str = (String)hashMap.get(this.sPositionTag_Setting_TwoLevel_Group); 
      String str2 = (String)hashMap.get(this.sPositionTag_Setting_TwoLevel_Group);
      if (str != null && !str.equals(str2)) {
        LinearLayout linearLayout1 = (LinearLayout)this.mLayoutInflater.inflate(2131427750, null);
        this.svMainSettingMenu.addView(linearLayout1);
      } 
      LinearLayout linearLayout = (LinearLayout)View.inflate(this, 2131427752, null);
      ImageView imageView = (ImageView)linearLayout.findViewById(2131297336);
      TextView textView2 = (TextView)linearLayout.findViewById(2131299324);
      imageView.setImageResource(((Integer)hashMap.get("sItemImage")).intValue());
      textView2.setText((String)hashMap.get("nItemText"));
      TextView textView1 = (TextView)linearLayout.findViewById(2131299456);
      textView2 = (TextView)linearLayout.findViewById(2131297123);
      RelativeLayout relativeLayout = (RelativeLayout)linearLayout.findViewById(2131297138);
      String str3 = (String)hashMap.get("nWindow");
      textView1.setText(str3);
      if (str3.length() > 0) {
        an.a(str3, new ae(textView2));
      } else {
        textView2.setVisibility(4);
      } 
      int i = ((Integer)hashMap.get("nGroupID")).intValue();
      if (i == 90002 && RootApplication.getLaiqianPreferenceManager().awf())
        relativeLayout.setVisibility(0); 
      linearLayout.setTag(Integer.valueOf(i));
      linearLayout.setOnClickListener(this.leftLLClickListener);
      this.svMainSettingMenu.addView(linearLayout);
      String str1 = (String)hashMap.get(this.sPositionTag_Setting_TwoLevel_Group);
    } 
  }
  
  public static boolean getDownloadStatus() { return bIsDownloading; }
  
  private HashMap<String, Object> getLeftItemMap(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3) {
    HashMap hashMap = new HashMap();
    hashMap.put("nItemText", paramString1);
    hashMap.put("sItemImage", Integer.valueOf(paramInt2));
    hashMap.put(this.sPositionTag_Setting_TwoLevel_Group, paramString2);
    hashMap.put("nGroupID", Integer.valueOf(paramInt1));
    hashMap.put("nWindow", paramString3);
    return hashMap;
  }
  
  private PopupWindow getPermissionPopupWindow() {
    if (this.permissionPopupWindow == null) {
      View view1 = View.inflate(this, 2131428033, null);
      View view2 = view1.findViewById(2131298963);
      if (this.bBoss && this.bHasShop) {
        view2.setVisibility(0);
        view2.setOnClickListener(new aq(this, this, com.laiqian.pos.settings.ShopInfoSettingsActivity.class));
      } else {
        view2.setVisibility(8);
      } 
      view2 = view1.findViewById(2131299931);
      if (this.bBoss) {
        view2.setVisibility(0);
        view2.setOnClickListener(new ar(this, this, com.laiqian.auth.UserManagement.class));
      } else {
        view2.setVisibility(8);
      } 
      view1.findViewById(2131296754).setOnClickListener(new as(this));
      view1.findViewById(2131299127).setOnClickListener(new at(this));
      this.permissionPopupWindow = new PopupWindow(view1, -2, -2, true);
      this.permissionPopupWindow.setBackgroundDrawable(new ColorDrawable());
      this.permissionPopupWindow.setOutsideTouchable(true);
    } 
    return this.permissionPopupWindow;
  }
  
  private void getView() {
    this.leftScrollView = (ScrollView)findViewById(2131297736);
    this.leftScrollView.setVerticalScrollBarEnabled(false);
    this.svMainSetting = (LinearLayout)findViewById(2131299108);
    this.svMainSettingMenu = (LinearLayout)findViewById(2131299109);
    findViewById(2131297868).setOnClickListener(new ap(this));
  }
  
  private void hideProgress() {
    if (this.mWaitingDialog != null) {
      this.mWaitingDialog.dismiss();
      this.mWaitingDialog = null;
    } 
    if (this.mModifyUserPasswordDialog != null && this.mModifyUserPasswordDialog.isShowing()) {
      if (this.sBossNewPassword != null) {
        UpdateLocalPassWord(this.sBossNewPassword);
        this.sUserPassword = this.sBossNewPassword;
      } 
      this.mModifyUserPasswordDialog.dismiss();
    } 
  }
  
  public static void initClickGroups() {
    Iterator iterator = hmClickGroups.keySet().iterator();
    while (iterator.hasNext()) {
      String str;
      hmClickGroups.put((str = (String)iterator.next()).valueOf(str), "0");
    } 
  }
  
  @SuppressLint({"NewApi"})
  private void initialData() {
    this.syncManager = new g(this);
    this.syncManager.a(new ag(this));
    av av = new av(this);
    null = av.atp();
    if (this.nUserID == null)
      this.nUserID = av.atm(); 
    this.bBoss = "150001".equals(null);
    null = new h(this);
    this.bHasShop = null.TW();
    null.close();
    LinkedHashMap linkedHashMap = new LinkedHashMap();
    linkedHashMap.put(Integer.valueOf(90001), getLeftItemMap(90001, getString(2131626954), 2131231821, "1", "100002"));
    linkedHashMap.put(Integer.valueOf(90002), getLeftItemMap(90002, getString(2131626960), 2131231822, "2", "100003"));
    if (!a.zR().Ab() && !a.zR().Ad()) {
      linkedHashMap.put(Integer.valueOf(90004), getLeftItemMap(90004, getString(2131627237), 2131231824, "2", "100004"));
      linkedHashMap.put(Integer.valueOf(90003), getLeftItemMap(90003, getString(2131627231), 2131231811, "2", "100005"));
    } 
    linkedHashMap.put(Integer.valueOf(90008), getLeftItemMap(90008, getString(2131626934), 2131231818, "3", "100006"));
    linkedHashMap.put(Integer.valueOf(90006), getLeftItemMap(90006, getString(2131626944), 2131231817, "3", "100007"));
    linkedHashMap.put(Integer.valueOf(90007), getLeftItemMap(90007, getString(2131626958), 2131231972, "3", "100008"));
    linkedHashMap.put(Integer.valueOf(90005), getLeftItemMap(90005, getString(2131625596), 2131231698, "4", "100009"));
    linkedHashMap.put(Integer.valueOf(90009), getLeftItemMap(90009, getString(2131626919), 2131230950, "4", "100010"));
    if (this.bBoss && a.zR().zS())
      linkedHashMap.put(Integer.valueOf(90010), getLeftItemMap(90010, getString(2131628535), 2131231686, "4", "100011")); 
    if (bd.bH(this) && !av.auZ() && a.zR().zU() && !a.zR().Ad()) {
      linkedHashMap.put(Integer.valueOf(90012), getLeftItemMap(90012, getString(2131627723), 2131231816, "5", "100012"));
    } else if (getResources().getBoolean(2131034125) && getResources().getBoolean(2131034132)) {
      av.auZ();
    } 
    linkedHashMap.put(Integer.valueOf(90013), getLeftItemMap(90013, getString(2131626912), 2131230996, "5", "100013"));
    linkedHashMap.put(Integer.valueOf(90014), getLeftItemMap(90014, getString(2131626908), 2131230809, "5", "100014"));
    cj cj = new cj(this);
    ArrayList arrayList = new ArrayList();
    Iterator iterator = linkedHashMap.keySet().iterator();
    label43: while (true) {
      int i;
      boolean bool;
      while (true) {
        boolean bool1 = iterator.hasNext();
        byte b = 0;
        if (bool1) {
          i = ((Integer)iterator.next()).intValue();
          if (!this.bBoss && i == 90001) {
            null = new StringBuilder();
            null.append(this.nUserID);
            null.append("");
            String str = cj.bz(null.toString());
            byte b1 = b;
            if (str != null) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(i);
              stringBuilder1.append("");
              if (!str.contains(stringBuilder1.toString())) {
                b1 = b;
                break;
              } 
            } else {
              break;
            } 
          } 
          bool = true;
          break;
        } 
        break label43;
      } 
      if (bool && linkedHashMap.containsKey(Integer.valueOf(i)))
        arrayList.add(linkedHashMap.get(Integer.valueOf(i))); 
    } 
    cj.close();
    av.close();
    drawLeftLayout(arrayList);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("list=");
    stringBuilder.append(arrayList);
    bb.ao(stringBuilder.toString());
    if (this.svMainSettingMenu.getChildCount() > 0)
      this.svMainSettingMenu.getChildAt(0).performClick(); 
    this.mHandler.sendEmptyMessageDelayed(0, 200L);
  }
  
  private void promptBeforeQuit() {
    r r = new r(this, new au(this));
    r.setTitle(getString(2131625532));
    r.s(getString(2131628259));
    r.arm().setText(getString(2131625529));
    r.arn().setText(getString(2131625538));
    r.show();
  }
  
  public static void sendCustomEvent(Context paramContext, String paramString1, String paramString2) {
    initClickGroups();
    hmClickGroups.put(paramString1, paramString2);
    a.b(paramContext, hmClickGroups, "pos_setting_click");
  }
  
  public static void setDownloadStatus(boolean paramBoolean) { bIsDownloading = paramBoolean; }
  
  private void setUserName() {
    av av = new av(this);
    if (this.nUserID == null)
      this.nUserID = av.atm(); 
    this.sUserPassword = av.atr();
    String str1 = av.Ea();
    bh bh = new bh(this);
    String str2 = bh.iB(this.nUserID);
    bh.close();
    av.close();
    if (!TextUtils.isEmpty(str2))
      str1 = str2; 
    str2 = av.atp();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(cj.aGx);
    stringBuilder.append("");
    if (str2.equals(stringBuilder.toString())) {
      ((TextView)findViewById(2131299453)).setText(getString(2131630513));
      return;
    } 
    ((TextView)findViewById(2131299453)).setText(str1);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 9) {
      setRequestedOrientation(6);
    } else {
      setRequestedOrientation(0);
    } 
    requestWindowFeature(1);
    setContentView(2131427744);
    this.mLayoutInflater = LayoutInflater.from(this);
    getView();
    initialData();
    int i = getIntent().getIntExtra("windowId", -1);
    if (i != -1) {
      View view = this.svMainSettingMenu.findViewWithTag(Integer.valueOf(i));
      if (view != null)
        view.performClick(); 
    } 
    registerReceiver(this.accountReceiver, new IntentFilter("pos_change_account"));
    registerReceiver(this.accountReceiver, new IntentFilter("pos_shut_down"));
  }
  
  public void onDestroy() {
    if (this.syncManager != null) {
      this.syncManager.close();
      this.syncManager = null;
    } 
    WalletSettingFragment.dLd = null;
    unregisterReceiver(this.accountReceiver);
    super.onDestroy();
  }
  
  protected void onPause() {
    MobclickAgent.onPause(this);
    super.onPause();
  }
  
  protected void onResume() {
    MobclickAgent.onResume(this);
    setUserName();
    super.onResume();
  }
  
  protected void onStop() {
    if (this.selectedView != null) {
      TextView textView = (TextView)this.selectedView.findViewById(2131297123);
      String str = ((TextView)this.selectedView.findViewById(2131299456)).getText().toString();
      if (str.length() > 0) {
        an.a(str, new af(textView));
      } else {
        textView.setVisibility(4);
      } 
    } 
    super.onStop();
  }
  
  public boolean save(String paramString, HashMap<String, String> paramHashMap) {
    if (!bd.bH(this)) {
      Toast.makeText(this, getString(2131628423), 0).show();
      return false;
    } 
    ShowProgress();
    av av = new av(this);
    HashMap hashMap = new HashMap();
    jSONObject = new JSONObject();
    try {
      jSONObject.put("password", av.atr());
      jSONObject.put("new_password", paramHashMap.get("sUserPassword"));
      jSONObject.put("user_name", av.Ea());
      jSONObject.put("auth_type", "0");
      jSONObject.put("shop_id", av.Tx());
      jSONObject.put("version", "1");
      hashMap.put("laiqian_encrypt", b.encode(jSONObject.toString()));
    } catch (Exception jSONObject) {
      a.e(jSONObject);
    } 
    av.close();
    (new ay(hashMap, new ak(this, paramString, paramHashMap))).execute(new String[] { q.cmI });
    return true;
  }
  
  public void showError(String paramString) { Toast.makeText(this, paramString, 0).show(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\pos\industry\setting\MainSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */