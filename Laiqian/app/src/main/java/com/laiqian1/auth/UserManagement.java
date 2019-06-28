package com.laiqian.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.c.a;
import com.laiqian.milestone.h;
import com.laiqian.models.bh;
import com.laiqian.pos.hardware.q;
import com.laiqian.sync.a.g;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ImageCheckBox;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.ui.layout.CheckBoxLayout;
import com.laiqian.ui.listview.j;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.bh;
import com.laiqian.util.n;
import io.reactivex.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class UserManagement extends ActivityRoot implements bn {
  public static boolean bIsUploading = false;
  
  Handler aDL = new bu(this);
  
  View.OnClickListener aDd = new cc(this);
  
  ArrayList<HashMap<String, String>> aDg;
  
  private View aDt = null;
  
  private ImageCheckBox aFA;
  
  private boolean aFB;
  
  private View aFC;
  
  private View aFD;
  
  private View aFE;
  
  private View aFF;
  
  private View aFG;
  
  private View aFH;
  
  private long aFI;
  
  private float aFJ = 0.0F;
  
  private float aFK = 0.0F;
  
  private float aFL = 0.0F;
  
  private float aFM = 0.0F;
  
  private TextView aFN;
  
  private ImageView aFO;
  
  private ScrollView aFP;
  
  private final int aFQ = -1;
  
  private final int aFR = -2;
  
  private int aFS = -3;
  
  private ListView aFT;
  
  private e aFU;
  
  private ListView aFV;
  
  private c aFW;
  
  View aFX = null;
  
  ArrayList<HashMap<String, String>> aFY;
  
  HashMap<String, String> aFZ = null;
  
  private EditText aFf;
  
  private Button aFw;
  
  private TextView aFx;
  
  private TextView aFy;
  
  private TextView aFz;
  
  View.OnClickListener aGa = new bo(this);
  
  View.OnClickListener aGb = new bt(this);
  
  private w aGc;
  
  private r aGd;
  
  private w aGe;
  
  private String[] aGf;
  
  private ArrayList<Long> aGg;
  
  int aGh;
  
  View.OnClickListener aGi = new cd(this);
  
  private CreateEmployeeDialog aGj;
  
  View.OnClickListener aGk = new cf(this);
  
  r aGl;
  
  View.OnClickListener azO = new cb(this);
  
  private ModifyUserPasswordDialog mModifyUserPasswordDialog;
  
  private bb mWaitingDialog = null;
  
  private bc mWiFiDialog;
  
  private HashMap<String, String> oldUserInfo;
  
  private String sBossNewPassword;
  
  private g syncManager;
  
  Handler uploadHandler = new bq(this);
  
  static  {
  
  }
  
  private boolean b(Boolean[] paramArrayOfBoolean) {
    if (this.aDt != null) {
      String str = (String)((HashMap)this.aDt.getTag()).get("_id");
      cj cj = new cj(this);
      for (byte b = 0; b < this.aDg.size(); b++) {
        String str1;
        String str2 = (String)((HashMap)this.aDg.get(b)).get("id");
        if (paramArrayOfBoolean[b].booleanValue()) {
          str1 = "Y";
        } else {
          str1 = "N";
        } 
        if (!cj.l(str, str2, str1))
          return false; 
      } 
      cj.close();
      return true;
    } 
    return false;
  }
  
  private void bB(boolean paramBoolean) {
    if (!paramBoolean)
      return; 
    if (this.aFS >= 0) {
      this.aFU.getView(this.aFS, null, null).performClick();
      return;
    } 
    if (this.aFS == -1) {
      finish();
      return;
    } 
    if (this.aFS == -2)
      this.aFX.performClick(); 
  }
  
  private void bs(String paramString) {
    if (this.mWaitingDialog == null)
      this.mWaitingDialog = new bb(this); 
    this.mWaitingDialog.setCancelable(false);
    this.mWaitingDialog.show();
  }
  
  private void bt(String paramString) {
    xK();
    SharedPreferences sharedPreferences = getSharedPreferences("settings", 0);
    View view = sharedPreferences.getString("user_phone", "");
    null = sharedPreferences.getString("shop_id", "1");
    this.aFI = Long.parseLong(sharedPreferences.getString("user_id", "1"));
    this.aFY = new ArrayList();
    h h = new h(this);
    h.Ua();
    null = h.aO(Long.parseLong(null));
    if (null != null) {
      while (null.moveToNext()) {
        HashMap hashMap = new HashMap();
        int i = null.getColumnCount();
        for (byte b1 = 0; b1 < i; b1++)
          hashMap.put(null.getColumnName(b1), null.getString(b1)); 
        if (null.getLong(0) == this.aFI) {
          this.aFZ = hashMap;
          continue;
        } 
        this.aFY.add(hashMap);
      } 
      null.close();
    } 
    h.close();
    if (this.aFZ != null) {
      boolean bool;
      if (Long.parseLong((String)this.aFZ.get("nUserRole")) == 150001L) {
        bool = true;
      } else {
        bool = false;
      } 
      this.aFB = bool;
    } 
    if (!this.aFB) {
      this.aFC.setVisibility(8);
      this.aFN.setVisibility(0);
      this.aFA.setVisibility(8);
    } else {
      this.aFN.setVisibility(8);
      this.aFA.setVisibility(0);
    } 
    this.aFA.setClickable(this.aFB);
    this.aFf.setEnabled(this.aFB);
    ((TextView)findViewById(2131299452)).setText(view);
    ((TextView)findViewById(2131299422)).setText(g(this.aFZ));
    this.aFX = findViewById(2131297867);
    this.aFX.setTag(this.aFZ);
    yK();
    this.aFX.setOnClickListener(new f(this, -2));
    ((LinearLayout)findViewById(2131297831)).removeAllViews();
    this.aFU = new e(this, this.aFY, this);
    this.aFT.setChoiceMode(1);
    this.aFT.setAdapter(this.aFU);
    j.c(this.aFT);
    Iterator iterator = this.aFY.iterator();
    view = null;
    byte b = 0;
    while (iterator.hasNext()) {
      String str = ((String)((HashMap)iterator.next()).get("sUserPhone")).toString();
      View view1 = view;
      if (view == null) {
        view1 = view;
        if (paramString != null) {
          view1 = view;
          if (paramString.equals(str))
            view1 = this.aFU.getView(b, null, null); 
        } 
      } 
      b++;
      view = view1;
    } 
    if (view != null) {
      this.aFP.fullScroll(33);
      performClick(view);
      return;
    } 
    performClick(this.aFX);
  }
  
  private ArrayList<d> bu(String paramString) {
    Log.e("sUserID", paramString);
    cj cj = new cj(this);
    String str = cj.bz(paramString);
    ArrayList arrayList = new ArrayList();
    byte b2 = 0;
    byte b1;
    for (b1 = 0; b1 < this.aDg.size(); b1++) {
      d d = new d(this);
      d.id = Integer.parseInt((String)((HashMap)this.aDg.get(b1)).get("id"));
      d.name = (String)((HashMap)this.aDg.get(b1)).get("name");
      d.aGu = false;
      arrayList.add(d);
    } 
    if (str != null)
      for (b1 = b2; b1 < this.aDg.size(); b1++) {
        ((d)arrayList.get(b1)).id = Integer.parseInt((String)((HashMap)this.aDg.get(b1)).get("id"));
        ((d)arrayList.get(b1)).name = (String)((HashMap)this.aDg.get(b1)).get("name");
        ((d)arrayList.get(b1)).aGu = str.contains((CharSequence)((HashMap)this.aDg.get(b1)).get("id"));
      }  
    ((d)arrayList.get(1)).aGu = cj.bA(paramString);
    cj.close();
    Log.e("arrHaveWindowAccess", arrayList.toString());
    return arrayList;
  }
  
  private boolean checkNetwork() {
    boolean bool = bd.bH(this);
    if (!bool && this.aFB)
      Toast.makeText(this, getString(2131628414), 0).show(); 
    return bool;
  }
  
  private void dM(int paramInt) {
    if (this.aGc == null) {
      String str = getString(2131629777);
      bz bz = new bz(this);
      this.aGc = new w(this, new String[] { str }, bz);
    } 
    this.aGc.object = Integer.valueOf(paramInt);
    this.aGc.gn(-1);
    this.aGc.show();
  }
  
  private void dN(int paramInt) {
    try {
      if (this.aFS == -3 && yJ()) {
        dO(paramInt);
        return;
      } 
      View view = null;
      if (paramInt >= 0) {
        view = this.aFT.getAdapter().getView(paramInt, null, null);
      } else if (paramInt == -1) {
        view = this.aDt;
      } else if (paramInt == -2) {
        view = this.aFX;
      } 
      HashMap hashMap = (HashMap)view.getTag();
      yK();
      if (this.aDt != null)
        this.aDt.setActivated(false); 
      this.aDt = view;
      view = this.aDt;
      int i = 1;
      view.setActivated(true);
      this.aFT.setItemChecked(paramInt, true);
      this.aFx.setText((CharSequence)hashMap.get("sUserPhone"));
      this.aFy.setText((CharSequence)hashMap.get("sUserPassword"));
      this.aFf.setText((CharSequence)hashMap.get("sUserName"));
      this.aFz.setText(g(hashMap));
      this.aFN.setText((CharSequence)hashMap.get("sDeletionFlag"));
      String str = (String)hashMap.get("nUserRole");
      this.aFz.setTag(str);
      boolean bool = "170002".equals(hashMap.get("nDeletionFlag"));
      this.aFA.setChecked(bool);
      ArrayList arrayList = bu((String)hashMap.get("_id"));
      Log.e("permissionList", arrayList.toString());
      this.aFW = new c(this, arrayList, this);
      this.aFV.setAdapter(this.aFW);
      j.c(this.aFV);
      if (this.aFI == Long.parseLong((String)hashMap.get("_id"))) {
        paramInt = i;
      } else {
        paramInt = 0;
      } 
      if (paramInt != 0) {
        this.aFz.setEnabled(false);
      } else {
        this.aFz.setEnabled(this.aFB);
      } 
      if ("150001".equals(str) || paramInt != 0) {
        this.aFF.setVisibility(8);
        this.aFC.setVisibility(8);
        this.aFE.setVisibility(8);
        this.aFG.setVisibility(8);
      } else {
        this.aFF.setVisibility(0);
        this.aFC.setVisibility(0);
        this.aFE.setVisibility(0);
        if (!a.zR().Af())
          this.aFG.setVisibility(0); 
      } 
      this.aFV.setAdapter(this.aFW);
      this.aFH.setOnClickListener(new br(this));
      return;
    } catch (NumberFormatException numberFormatException) {
      a.e(numberFormatException);
      return;
    } 
  }
  
  private void dO(int paramInt) {
    this.aGl = new r(this, 2, new bs(this, paramInt));
    this.aGl.setTitle(getString(2131628165));
    this.aGl.oZ(getString(2131628162));
    this.aGl.t(getString(2131628163));
    this.aGl.arm().setTextColor(getResources().getColor(2131099813));
    this.aGl.arn().setTextColor(getResources().getColor(2131099898));
    this.aGl.s(getString(2131628164));
    this.aGl.show();
  }
  
  private String g(HashMap<String, String> paramHashMap) { return "150001".equals(paramHashMap.get("nUserRole")) ? getString(2131628150) : ("150003".equals(paramHashMap.get("nUserRole")) ? getString(2131628151) : (String)paramHashMap.get("sUserRole")); }
  
  private void getView() {
    ((TextView)findViewById(2131299889)).setText(2131625626);
    findViewById(2131299878).setOnClickListener(this.azO);
    this.aFw = (Button)findViewById(2131299879);
    this.aFw.setText(2131624290);
    this.aFw.setOnClickListener(this.aDd);
    this.aFx = (TextView)findViewById(2131299292);
    this.aFy = (TextView)findViewById(2131299372);
    this.aFz = (TextView)findViewById(2131299299);
    this.aFN = (TextView)findViewById(2131299457);
    this.aFf = (EditText)findViewById(2131296952);
    this.aFA = (ImageCheckBox)findViewById(2131296703);
    this.aFC = findViewById(2131297833);
    this.aFD = findViewById(2131297794);
    this.aFE = findViewById(2131297805);
    this.aFF = findViewById(2131298765);
    this.aFD.setVisibility(8);
    this.aFO = (ImageView)findViewById(2131297267);
    this.aFP = (ScrollView)findViewById(2131299107);
    this.aFT = (ListView)findViewById(2131299060);
    this.aFV = (ListView)findViewById(2131298403);
    this.aFG = findViewById(2131297789);
    this.aFH = findViewById(2131297850);
  }
  
  private void h(HashMap<String, String> paramHashMap) {
    HashMap hashMap = (HashMap)this.aDt.getTag();
    for (String str : hashMap.keySet()) {
      if (paramHashMap.containsKey(str))
        hashMap.put(str, paramHashMap.get(str)); 
    } 
    hashMap.put("sUserRole", this.aFz.getText().toString().trim());
    this.aDt.setTag(hashMap);
  }
  
  private void hideProgress() {
    if (this.mWaitingDialog != null) {
      this.mWaitingDialog.dismiss();
      this.mWaitingDialog = null;
    } 
  }
  
  private void initialData() {
    bt(null);
    this.syncManager = new g(this);
    this.syncManager.a(new bv(this));
  }
  
  private void promptBeforeQuit() {
    if (yJ()) {
      dO(-1);
      return;
    } 
    yK();
    finish();
  }
  
  private void setListeners() {
    this.aFO.setOnClickListener(this.aGb);
    this.aFA.setOnClickListener(this.aGa);
    this.aFf.setOnClickListener(this.aGa);
    this.aFD.setOnClickListener(this.aGi);
    this.aFC.setOnClickListener(this.aGk);
  }
  
  private ArrayList<HashMap<String, String>> xK() {
    this.aDg = new ArrayList();
    HashMap hashMap = new HashMap();
    hashMap.put("id", "90001");
    hashMap.put("name", getString(2131626954));
    this.aDg.add(hashMap);
    hashMap = new HashMap();
    hashMap.put("id", "90021");
    hashMap.put("name", getString(2131629640));
    this.aDg.add(hashMap);
    hashMap = new HashMap();
    hashMap.put("id", "90004");
    hashMap.put("name", getString(2131626953));
    this.aDg.add(hashMap);
    hashMap = new HashMap();
    hashMap.put("id", "90020");
    hashMap.put("name", getString(2131627173));
    this.aDg.add(hashMap);
    hashMap = new HashMap();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(cj.aGz);
    stringBuilder.append("");
    hashMap.put("id", stringBuilder.toString());
    hashMap.put("name", getString(2131626955));
    this.aDg.add(hashMap);
    if (a.zR().Ab()) {
      hashMap = new HashMap();
      hashMap.put("id", "90022");
      hashMap.put("name", getString(2131626681));
      this.aDg.add(hashMap);
      hashMap = new HashMap();
      hashMap.put("id", "90023");
      hashMap.put("name", getString(2131627389));
      this.aDg.add(hashMap);
      hashMap = new HashMap();
      hashMap.put("id", "90024");
      hashMap.put("name", getString(2131627207));
      this.aDg.add(hashMap);
    } 
    return this.aDg;
  }
  
  private void xY() {
    bs(getString(2131628425));
    bp bp = new bp(this);
    a.aKh().r(bp);
  }
  
  private void yE() {
    if (this.aFJ < 1.0F) {
      Rect rect = new Rect();
      this.aFf.getGlobalVisibleRect(rect);
      this.aFJ = rect.left;
      this.aFK = rect.right;
      this.aFL = rect.top;
      this.aFM = rect.bottom;
    } 
  }
  
  private void yF() {
    if (this.aGj == null) {
      this.aGj = new CreateEmployeeDialog(this);
      this.aGj.a(this.aDL);
    } 
    this.aGj.show();
  }
  
  @NonNull
  private HashMap<String, String> yG() {
    av av = new av(this);
    HashMap hashMap = new HashMap();
    hashMap.put("user_name", av.Ea());
    hashMap.put("password", av.atr());
    hashMap.put("auth_type", "0");
    hashMap.put("shop_id", av.Tx());
    hashMap.put("version", "1.1");
    av.close();
    return hashMap;
  }
  
  private void yH() {
    cj cj = new cj(this);
    Cursor cursor = cj.yL();
    if (cursor != null)
      cursor.getCount(); 
    this.aGf = new String[cursor.getCount() + 1];
    this.aGg = new ArrayList();
    this.aGg.add(Long.valueOf(150003L));
    this.aGf[0] = getString(2131629825);
    if (cursor != null) {
      for (byte b = 1; cursor.moveToNext(); b++) {
        long l = cursor.getLong(cursor.getColumnIndex("_id"));
        String str = cursor.getString(cursor.getColumnIndex("sRoleName"));
        this.aGg.add(Long.valueOf(l));
        this.aGf[b] = str;
      } 
      cursor.close();
    } 
    cj.close();
  }
  
  private void yI() {
    this.aFz.requestFocus();
    n.a(this, getCurrentFocus());
  }
  
  private boolean yJ() {
    try {
      HashMap hashMap = (HashMap)this.aDt.getTag();
      long l = Long.parseLong((String)hashMap.get("_id"));
      null = new StringBuilder();
      null.append(l);
      null.append("");
      ArrayList arrayList = bu(null.toString());
      for (byte b = 0;; b++) {
        if (b < this.aDg.size()) {
          if (((d)arrayList.get(b)).aGu != ((CheckBoxLayout)this.aFW.getView(b, null, null).findViewById(2131296764)).isChecked())
            return true; 
        } else {
          if (!((String)hashMap.get("sUserName")).toString().equals(this.aFf.getText().toString()))
            return true; 
          boolean bool1 = "170002".equals(hashMap.get("nDeletionFlag"));
          boolean bool2 = this.aFA.isChecked();
          return (bool1 != bool2);
        } 
      } 
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private void yK() { this.aFS = -3; }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    yE();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (f1 <= this.aFJ || f1 >= this.aFK || f2 <= this.aFL || f2 >= this.aFM)
      yI(); 
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void finish() {
    super.finish();
    if (this.aGl != null && this.aGl.isShowing())
      this.aGl.dismiss(); 
    yK();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131428173);
    getWindow().setFeatureInt(7, 2131428168);
    getView();
    setListeners();
    initialData();
  }
  
  public void onDestroy() {
    if (this.syncManager != null) {
      this.syncManager.close();
      this.syncManager = null;
    } 
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getRepeatCount() > 0)
      return false; 
    if (paramInt == 4 && paramKeyEvent.getRepeatCount() == 0) {
      promptBeforeQuit();
      return false;
    } 
    return false;
  }
  
  public boolean save(String paramString, HashMap<String, String> paramHashMap) {
    Boolean[] arrayOfBoolean = new Boolean[this.aDg.size()];
    byte b;
    for (b = 0; b < this.aDg.size(); b++)
      arrayOfBoolean[b] = Boolean.valueOf(((CheckBoxLayout)this.aFW.getView(b, null, null).findViewById(2131296764)).isChecked()); 
    b(arrayOfBoolean);
    if (this.syncManager.apy().apG()) {
      Toast.makeText(this, getString(2131629568), 0).show();
      return false;
    } 
    if (!bd.bH(this)) {
      Toast.makeText(this, getString(2131628423), 0).show();
      return false;
    } 
    this.oldUserInfo = new HashMap();
    bh bh = new bh(this);
    Cursor cursor = bh.iA(paramString);
    if (cursor != null) {
      if (cursor.moveToFirst()) {
        int i = cursor.getColumnCount();
        for (b = 0; b < i; b++)
          this.oldUserInfo.put(cursor.getColumnName(b), cursor.getString(b)); 
      } 
      cursor.close();
    } 
    bh.close();
    h h = new h(this);
    boolean bool = h.c(paramString, paramHashMap);
    h.close();
    h(paramHashMap);
    if (!bool) {
      Toast.makeText(this, getString(2131628422), 0).show();
      return false;
    } 
    this.sBossNewPassword = null;
    if (this.aDt != null && this.mModifyUserPasswordDialog != null && this.mModifyUserPasswordDialog.isShowing()) {
      HashMap hashMap = (HashMap)this.aDt.getTag();
      if (this.aFI == Long.parseLong((String)hashMap.get("_id")))
        this.sBossNewPassword = (String)paramHashMap.get("sUserPassword"); 
    } 
    xY();
    return true;
  }
  
  private class a extends AsyncTask<String, Void, Boolean> {
    boolean aGq = false;
    
    private String aGr = "";
    
    private a(UserManagement this$0) {}
    
    private boolean checkNetwork() {
      if (!bd.bH(this.aGm)) {
        if (UserManagement.g(this.aGm) == null) {
          UserManagement.a(this.aGm, new bc(this.aGm));
          UserManagement.g(this.aGm).setCancelable(false);
        } 
        UserManagement.g(this.aGm).show();
        return false;
      } 
      return true;
    }
    
    protected void b(Boolean param1Boolean) {
      if (param1Boolean.booleanValue()) {
        UserManagement.a(this.aGm, null);
        Toast.makeText(this.aGm, this.aGm.getString(2131629776), 0).show();
      } else if ("-1".equals(this.aGr)) {
        Toast.makeText(this.aGm, this.aGm.getString(2131629775), 0).show();
      } else if ("-2".equals(this.aGr)) {
        Toast.makeText(this.aGm, this.aGm.getString(2131629778), 0).show();
      } else if ("-3".equals(this.aGr)) {
        Toast.makeText(this.aGm, this.aGm.getString(2131624449), 0).show();
      } else {
        Toast.makeText(this.aGm, this.aGm.getString(2131629775), 0).show();
      } 
      UserManagement.h(this.aGm);
    }
    
    protected Boolean e(String... param1VarArgs) {
      if (this.aGq) {
        null = UserManagement.i(this.aGm);
        null.put("employee_phone", param1VarArgs[0]);
        String str = bh.a(q.ckB, this.aGm, null, 10000);
        if (!TextUtils.isEmpty(str))
          try {
            String str1 = new JSONObject(str);
            if ("TRUE".equals(str1.optString("result", "FALSE"))) {
              str1 = str1.getJSONObject("message").getString("new_employee_phone");
              bh bh = new bh(this.aGm);
              bh.ap(param1VarArgs[0], str1);
              bh.close();
              return Boolean.valueOf(true);
            } 
            this.aGr = str1.optString("msg_no", "");
            return Boolean.valueOf(false);
          } catch (JSONException param1VarArgs) {
            throw new RuntimeException(param1VarArgs);
          }  
      } 
      return Boolean.valueOf(false);
    }
    
    protected void onPreExecute() {
      this.aGq = checkNetwork();
      if (this.aGq)
        UserManagement.b(this.aGm, " "); 
    }
  }
  
  class b implements View.OnLongClickListener {
    private int position;
    
    public b(UserManagement this$0, int param1Int) { this.position = param1Int; }
    
    public boolean onLongClick(View param1View) {
      UserManagement.a(this.aGm, this.position);
      return true;
    }
  }
  
  class c extends BaseAdapter {
    private ArrayList<UserManagement.d> aGs;
    
    private Context mContext;
    
    c(UserManagement this$0, ArrayList<UserManagement.d> param1ArrayList, Context param1Context) {
      this.aGs = param1ArrayList;
      this.mContext = param1Context;
    }
    
    public int getCount() { return this.aGs.size(); }
    
    public Object getItem(int param1Int) { return this.aGs.get(param1Int); }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      if (param1View == null)
        param1View = View.inflate(this.mContext, 2131427701, null); 
      CheckBoxLayout checkBoxLayout = (CheckBoxLayout)param1View.findViewById(2131296764);
      checkBoxLayout.setChecked(((UserManagement.d)this.aGs.get(param1Int)).aGu);
      checkBoxLayout.setText(((UserManagement.d)this.aGs.get(param1Int)).name);
      checkBoxLayout.setTag(Integer.valueOf(((UserManagement.d)this.aGs.get(param1Int)).id));
      if (param1Int == 0) {
        checkBoxLayout.a(new cg(this, param1Int));
        return param1View;
      } 
      if (param1Int == 1) {
        checkBoxLayout.a(new ch(this, param1Int));
        return param1View;
      } 
      checkBoxLayout.a(new ci(this, param1Int));
      return param1View;
    }
  }
  
  class d {
    boolean aGu;
    
    int id;
    
    String name;
    
    d(UserManagement this$0) {}
  }
  
  class e extends BaseAdapter {
    private ArrayList<HashMap<String, String>> aGv;
    
    private Context mContext;
    
    e(UserManagement this$0, ArrayList<HashMap<String, String>> param1ArrayList, Context param1Context) {
      this.aGv = param1ArrayList;
      this.mContext = param1Context;
    }
    
    public int getCount() { return this.aGv.size(); }
    
    public Object getItem(int param1Int) { return this.aGv.get(param1Int); }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      if (param1View == null)
        param1View = View.inflate(this.mContext, 2131428174, null); 
      String str = ((String)((HashMap)this.aGv.get(param1Int)).get("sUserPhone")).toString();
      ((TextView)param1View.findViewById(2131299452)).setText(str);
      ((TextView)param1View.findViewById(2131299422)).setText(UserManagement.a(this.aGm, (HashMap)this.aGv.get(param1Int)));
      param1View.setTag(this.aGv.get(param1Int));
      param1View.setOnClickListener(new UserManagement.f(this.aGm, param1Int));
      param1View.setOnLongClickListener(new UserManagement.b(this.aGm, param1Int));
      return param1View;
    }
  }
  
  class f implements View.OnClickListener {
    private int aGw;
    
    public f(UserManagement this$0, int param1Int) { this.aGw = param1Int; }
    
    public void onClick(View param1View) {
      if (param1View == UserManagement.j(this.aGm))
        return; 
      UserManagement.b(this.aGm, this.aGw);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\UserManagement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */