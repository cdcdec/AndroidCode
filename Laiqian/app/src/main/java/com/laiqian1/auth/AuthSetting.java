package com.laiqian.auth;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.ui.layout.CheckBoxLayout;
import com.laiqian.util.bb;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class AuthSetting extends ActivityRoot {
  private static byte aDy;
  
  private View.OnClickListener aDA = new p(this);
  
  private View.OnClickListener aDB = new q(this);
  
  private int aDC = 8;
  
  private View.OnClickListener aDD = new r(this);
  
  private a aDE;
  
  ArrayList<String> aDg;
  
  private CheckBoxLayout[] aDh;
  
  private LinearLayout aDi;
  
  private View aDj;
  
  private View aDk;
  
  private ScrollView aDl;
  
  private int aDm;
  
  private TextView aDn;
  
  private View aDo;
  
  private View.OnClickListener aDp = new i(this);
  
  private HashMap<String, String> aDq;
  
  private String aDr;
  
  private String aDs;
  
  private View aDt;
  
  private View.OnClickListener aDu = new m(this);
  
  private Boolean[] aDv;
  
  private View.OnClickListener aDw = new n(this);
  
  private r aDx;
  
  private View.OnClickListener aDz = new o(this);
  
  private Handler handler = new k(this);
  
  private void a(byte paramByte, View paramView) {
    if (this.aDx == null) {
      this.aDx = new r(this, null);
      this.aDx.setTitle(getString(2131626519));
      this.aDx.s(getString(2131626518));
      this.aDx.arn().setOnClickListener(this.aDz);
      this.aDx.arm().setText(getString(2131626471));
    } 
    if (paramByte == 2)
      this.aDx.arn().setTag(paramView); 
    aDy = paramByte;
    this.aDx.show();
  }
  
  private void a(String[] paramArrayOfString, boolean paramBoolean) {
    View view2 = View.inflate(this, 2131427846, null);
    view2.setTag(paramArrayOfString[0]);
    view2.setOnClickListener(this.aDu);
    ((TextView)view2.findViewById(2131299315)).setText(paramArrayOfString[1]);
    View view1 = view2.findViewById(2131298751);
    view1.setOnClickListener(this.aDD);
    view1.setTag(view2);
    this.aDi.addView(view2);
    if (this.aDi.getVisibility() == 8)
      this.aDi.setVisibility(0); 
    if (paramBoolean)
      this.handler.postDelayed(new l(this), 300L); 
  }
  
  private boolean a(Boolean[] paramArrayOfBoolean) {
    cj cj = new cj(this);
    null = new StringBuilder();
    null.append(System.currentTimeMillis());
    null.append("");
    String str = null.toString();
    boolean bool = cj.a(str, this.aDs, paramArrayOfBoolean, true);
    cj.close();
    if (bool) {
      this.aDr = str;
      this.aDt.setTag(str);
      this.aDk.setTag(str);
      this.aDq.put(str, this.aDs);
    } 
    return bool;
  }
  
  private boolean a(Boolean[] paramArrayOfBoolean, String paramString) {
    boolean bool = ((String)this.aDq.get(paramString)).equals(this.aDs);
    cj cj = new cj(this);
    bool = cj.b(paramString, this.aDs, paramArrayOfBoolean, bool ^ true);
    cj.close();
    return bool;
  }
  
  private void bH(View paramView) { // Byte code:
    //   0: aload_0
    //   1: getfield aDC : I
    //   4: ifne -> 14
    //   7: aload_0
    //   8: iconst_2
    //   9: aload_1
    //   10: invokespecial a : (BLandroid/view/View;)V
    //   13: return
    //   14: aload_0
    //   15: getfield aDt : Landroid/view/View;
    //   18: astore #5
    //   20: iconst_0
    //   21: istore_3
    //   22: aload #5
    //   24: ifnull -> 35
    //   27: aload_0
    //   28: getfield aDt : Landroid/view/View;
    //   31: iconst_0
    //   32: invokevirtual setActivated : (Z)V
    //   35: aload_0
    //   36: aload_1
    //   37: putfield aDt : Landroid/view/View;
    //   40: aload_0
    //   41: getfield aDt : Landroid/view/View;
    //   44: astore #5
    //   46: iconst_1
    //   47: istore #4
    //   49: aload #5
    //   51: iconst_1
    //   52: invokevirtual setActivated : (Z)V
    //   55: aload_1
    //   56: invokevirtual getTag : ()Ljava/lang/Object;
    //   59: checkcast java/lang/String
    //   62: astore_1
    //   63: ldc_w 'NOID'
    //   66: aload_1
    //   67: invokevirtual equals : (Ljava/lang/Object;)Z
    //   70: ifne -> 93
    //   73: aload_0
    //   74: aload_1
    //   75: invokespecial br : (Ljava/lang/String;)V
    //   78: aload_0
    //   79: aload_0
    //   80: getfield aDq : Ljava/util/HashMap;
    //   83: aload_1
    //   84: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   87: checkcast java/lang/String
    //   90: putfield aDs : Ljava/lang/String;
    //   93: aload_0
    //   94: aload_1
    //   95: putfield aDr : Ljava/lang/String;
    //   98: aload_0
    //   99: getfield aDn : Landroid/widget/TextView;
    //   102: aload_0
    //   103: getfield aDs : Ljava/lang/String;
    //   106: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   109: aload_0
    //   110: aload_1
    //   111: invokespecial bq : (Ljava/lang/String;)[Ljava/lang/Boolean;
    //   114: astore #5
    //   116: ldc_w '150001'
    //   119: aload_1
    //   120: invokevirtual equals : (Ljava/lang/Object;)Z
    //   123: ifne -> 138
    //   126: iload_3
    //   127: istore_2
    //   128: ldc_w '150003'
    //   131: aload_1
    //   132: invokevirtual equals : (Ljava/lang/Object;)Z
    //   135: ifeq -> 143
    //   138: iconst_0
    //   139: istore #4
    //   141: iload_3
    //   142: istore_2
    //   143: iload_2
    //   144: aload #5
    //   146: arraylength
    //   147: if_icmpge -> 184
    //   150: aload_0
    //   151: getfield aDh : [Lcom/laiqian/ui/layout/CheckBoxLayout;
    //   154: iload_2
    //   155: aaload
    //   156: aload #5
    //   158: iload_2
    //   159: aaload
    //   160: invokevirtual booleanValue : ()Z
    //   163: invokevirtual setChecked : (Z)V
    //   166: aload_0
    //   167: getfield aDh : [Lcom/laiqian/ui/layout/CheckBoxLayout;
    //   170: iload_2
    //   171: aaload
    //   172: iload #4
    //   174: invokevirtual setClickable : (Z)V
    //   177: iload_2
    //   178: iconst_1
    //   179: iadd
    //   180: istore_2
    //   181: goto -> 143
    //   184: aload_0
    //   185: getfield aDk : Landroid/view/View;
    //   188: aload_1
    //   189: invokevirtual setTag : (Ljava/lang/Object;)V
    //   192: return }
  
  private void back() {
    if (this.aDC == 0) {
      a((byte)1, null);
      return;
    } 
    finish();
  }
  
  private Boolean[] bq(String paramString) {
    cj cj = new cj(this);
    paramString = cj.bw(paramString);
    Boolean[] arrayOfBoolean = new Boolean[this.aDg.size()];
    for (byte b = 0; b < this.aDg.size(); b++)
      arrayOfBoolean[b] = Boolean.valueOf(paramString.contains((CharSequence)this.aDg.get(b))); 
    cj.close();
    return arrayOfBoolean;
  }
  
  private void br(String paramString) {
    cj cj = new cj(this);
    if (!cj.bv(paramString))
      cj.a(paramString, "", xN(), false); 
    cj.close();
  }
  
  private void getView() {
    this.aDl = (ScrollView)findViewById(2131299106);
    this.aDn = (TextView)findViewById(2131299423);
    this.aDj = findViewById(2131298747);
    View view = findViewById(2131298752);
    this.aDj.setOnClickListener(this.aDu);
    view.setOnClickListener(this.aDu);
    this.aDh = new CheckBoxLayout[10];
    this.aDh[0] = (CheckBoxLayout)findViewById(2131296738);
    this.aDh[1] = (CheckBoxLayout)findViewById(2131296724);
    this.aDh[2] = (CheckBoxLayout)findViewById(2131296742);
    this.aDh[3] = (CheckBoxLayout)findViewById(2131296735);
    this.aDh[4] = (CheckBoxLayout)findViewById(2131296736);
    this.aDh[5] = (CheckBoxLayout)findViewById(2131296731);
    this.aDh[6] = (CheckBoxLayout)findViewById(2131296740);
    this.aDh[7] = (CheckBoxLayout)findViewById(2131296723);
    this.aDh[8] = (CheckBoxLayout)findViewById(2131296725);
    this.aDh[9] = (CheckBoxLayout)findViewById(2131296722);
    this.aDi = (LinearLayout)findViewById(2131297809);
    this.aDk = findViewById(2131296505);
    this.aDo = findViewById(2131296416);
    this.aDo.setOnClickListener(this.aDw);
    findViewById(2131297329).setOnClickListener(this.aDA);
  }
  
  private void initialData() {
    xK();
    xL();
    performClick(this.aDj);
    this.aDm = (getResources().getDisplayMetrics()).heightPixels;
  }
  
  private void setListeners() { // Byte code:
    //   0: aload_0
    //   1: getfield aDk : Landroid/view/View;
    //   4: aload_0
    //   5: getfield aDB : Landroid/view/View$OnClickListener;
    //   8: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   11: aload_0
    //   12: getfield aDh : [Lcom/laiqian/ui/layout/CheckBoxLayout;
    //   15: astore_3
    //   16: aload_3
    //   17: arraylength
    //   18: istore_2
    //   19: iconst_0
    //   20: istore_1
    //   21: iload_1
    //   22: iload_2
    //   23: if_icmpge -> 43
    //   26: aload_3
    //   27: iload_1
    //   28: aaload
    //   29: aload_0
    //   30: getfield aDp : Landroid/view/View$OnClickListener;
    //   33: invokevirtual a : (Landroid/view/View$OnClickListener;)V
    //   36: iload_1
    //   37: iconst_1
    //   38: iadd
    //   39: istore_1
    //   40: goto -> 21
    //   43: return }
  
  private ArrayList<String> xK() {
    cj cj = new cj(this);
    Cursor cursor = cj.yM();
    this.aDg = new ArrayList();
    if (cursor != null) {
      while (cursor.moveToNext())
        this.aDg.add(cursor.getString(0)); 
      cursor.close();
    } 
    cj.close();
    return this.aDg;
  }
  
  private void xL() { // Byte code:
    //   0: aload_0
    //   1: invokespecial xM : ()[[Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: arraylength
    //   7: ifne -> 20
    //   10: aload_0
    //   11: getfield aDi : Landroid/widget/LinearLayout;
    //   14: bipush #8
    //   16: invokevirtual setVisibility : (I)V
    //   19: return
    //   20: aload_0
    //   21: getfield aDi : Landroid/widget/LinearLayout;
    //   24: iconst_0
    //   25: invokevirtual setVisibility : (I)V
    //   28: aload_3
    //   29: arraylength
    //   30: istore_2
    //   31: iconst_0
    //   32: istore_1
    //   33: iload_1
    //   34: iload_2
    //   35: if_icmpge -> 53
    //   38: aload_0
    //   39: aload_3
    //   40: iload_1
    //   41: aaload
    //   42: iconst_0
    //   43: invokespecial a : ([Ljava/lang/String;Z)V
    //   46: iload_1
    //   47: iconst_1
    //   48: iadd
    //   49: istore_1
    //   50: goto -> 33
    //   53: return }
  
  private String[][] xM() {
    cj cj = new cj(this);
    Cursor cursor = cj.yL();
    String[][] arrayOfString = (String[][])Array.newInstance(String.class, new int[] { cursor.getCount(), 2 });
    this.aDq = new HashMap();
    this.aDq.put("150001", getString(2131629361));
    this.aDq.put("150003", getString(2131629825));
    for (byte b = 0; cursor.moveToNext(); b++) {
      String str1 = cursor.getString(cursor.getColumnIndex("_id"));
      String str2 = cursor.getString(cursor.getColumnIndex("sRoleName"));
      this.aDq.put(str1, str2);
      arrayOfString[b][0] = str1;
      arrayOfString[b][1] = str2;
    } 
    cursor.close();
    cj.close();
    return arrayOfString;
  }
  
  private Boolean[] xN() {
    if (this.aDv == null)
      this.aDv = bq("150003"); 
    return this.aDv;
  }
  
  private void xO() {
    if (this.aDC == 0) {
      a((byte)3, null);
      return;
    } 
    xP();
  }
  
  private void xP() {
    bb.ao("showAddAuthDialog");
    if (this.aDE == null)
      xR(); 
    this.aDE.k(null, "", "");
  }
  
  private void xQ() {
    bb.ao("showEditAuth");
    if (this.aDE == null)
      xR(); 
    this.aDE.k(this.aDr, this.aDs, (String)this.aDq.get(this.aDr));
  }
  
  private void xR() {
    this.aDE = new a(this);
    this.aDE.a(new j(this));
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131427470);
    getView();
    setListeners();
    initialData();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4 && paramKeyEvent.getRepeatCount() == 0) {
      performClick(this.aDo);
      return false;
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\AuthSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */