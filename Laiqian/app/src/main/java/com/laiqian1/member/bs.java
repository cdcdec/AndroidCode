package com.laiqian.member;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.member.setting.bc;
import com.laiqian.member.transfer.p;
import com.laiqian.models.l;
import com.laiqian.pos.s;
import com.laiqian.sync.a.g;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.a.m;
import com.laiqian.ui.a.p;
import com.laiqian.util.bd;
import com.laiqian.util.by;
import com.laiqian.vip.R;
import io.reactivex.g.a;
import java.util.ArrayList;
import java.util.HashMap;

public class bs {
  private Activity azD;
  
  private by bvL;
  
  private ArrayList<HashMap<String, String>> bvM;
  
  protected final String bvN = "mail";
  
  public Dialog bvO;
  
  private final int bvP = 1234;
  
  private final int bvQ = 1;
  
  private final int bvR = 2;
  
  private m bvS;
  
  private p bvT;
  
  private p bvU;
  
  protected Handler handler = new bx(this);
  
  private bb mWaitingDialog = null;
  
  private bc mWiFiDialog;
  
  public bs(by paramby, Activity paramActivity) {
    this.bvL = paramby;
    this.azD = paramActivity;
  }
  
  private void Qs() {
    HashMap hashMap = (HashMap)this.bvM.get(0);
    ArrayList arrayList = this.bvL.Qh();
    if (arrayList.isEmpty()) {
      hashMap.put("state", this.azD.getString(R.string.pos_report_export_to_u_no));
      hashMap.put("address", null);
      return;
    } 
    hashMap.put("state", this.azD.getString(R.string.pos_report_export_to_u_has));
    hashMap.put("address", arrayList.get(0));
  }
  
  private void fB(String paramString) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield bvU : Lcom/laiqian/member/transfer/p;
    //   6: astore #5
    //   8: aload #5
    //   10: ifnonnull -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield bvU : Lcom/laiqian/member/transfer/p;
    //   20: invokevirtual Td : ()Ljava/lang/String;
    //   23: astore #5
    //   25: aload #5
    //   27: ifnull -> 50
    //   30: aload_0
    //   31: getfield handler : Landroid/os/Handler;
    //   34: sipush #1234
    //   37: iconst_0
    //   38: iconst_0
    //   39: aload #5
    //   41: invokevirtual obtainMessage : (IIILjava/lang/Object;)Landroid/os/Message;
    //   44: invokevirtual sendToTarget : ()V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: new java/io/File
    //   53: dup
    //   54: aload_0
    //   55: getfield bvU : Lcom/laiqian/member/transfer/p;
    //   58: invokevirtual Tf : ()Ljava/lang/String;
    //   61: invokespecial <init> : (Ljava/lang/String;)V
    //   64: astore #8
    //   66: aload_0
    //   67: getfield azD : Landroid/app/Activity;
    //   70: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   73: getstatic com/laiqian/vip/R$bool.is_ShowingIndustry : I
    //   76: invokevirtual getBoolean : (I)Z
    //   79: istore #4
    //   81: iconst_1
    //   82: istore_3
    //   83: iload #4
    //   85: ifeq -> 103
    //   88: aload_0
    //   89: getfield azD : Landroid/app/Activity;
    //   92: getstatic com/laiqian/vip/R$string.pos_vip_export_mail_body : I
    //   95: invokevirtual getString : (I)Ljava/lang/String;
    //   98: astore #6
    //   100: goto -> 192
    //   103: new com/laiqian/util/av
    //   106: dup
    //   107: aload_0
    //   108: getfield azD : Landroid/app/Activity;
    //   111: invokespecial <init> : (Landroid/content/Context;)V
    //   114: astore #9
    //   116: aconst_null
    //   117: astore #6
    //   119: new com/laiqian/models/bh
    //   122: dup
    //   123: aload_0
    //   124: getfield azD : Landroid/app/Activity;
    //   127: invokespecial <init> : (Landroid/content/Context;)V
    //   130: astore #7
    //   132: aload #7
    //   134: astore #6
    //   136: goto -> 146
    //   139: astore #7
    //   141: aload #7
    //   143: invokestatic e : (Ljava/lang/Throwable;)V
    //   146: aload #6
    //   148: aload #9
    //   150: invokevirtual atm : ()Ljava/lang/String;
    //   153: invokevirtual iB : (Ljava/lang/String;)Ljava/lang/String;
    //   156: astore #7
    //   158: aload #6
    //   160: invokevirtual close : ()V
    //   163: aload #9
    //   165: invokevirtual close : ()V
    //   168: aload_0
    //   169: getfield azD : Landroid/app/Activity;
    //   172: getstatic com/laiqian/vip/R$string.pos_report_export_mail_body_evako : I
    //   175: invokevirtual getString : (I)Ljava/lang/String;
    //   178: iconst_1
    //   179: anewarray java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload #7
    //   186: aastore
    //   187: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   190: astore #6
    //   192: aload_1
    //   193: ldc '@'
    //   195: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   198: ifeq -> 276
    //   201: aload_0
    //   202: getfield azD : Landroid/app/Activity;
    //   205: getstatic com/laiqian/vip/R$string.pos_member_list : I
    //   208: invokevirtual getString : (I)Ljava/lang/String;
    //   211: astore #7
    //   213: aload_0
    //   214: getfield bvU : Lcom/laiqian/member/transfer/p;
    //   217: invokevirtual Tf : ()Ljava/lang/String;
    //   220: astore #8
    //   222: iconst_1
    //   223: anewarray java/lang/String
    //   226: dup
    //   227: iconst_0
    //   228: aload_1
    //   229: aastore
    //   230: aload #7
    //   232: aload #6
    //   234: iconst_1
    //   235: anewarray java/lang/String
    //   238: dup
    //   239: iconst_0
    //   240: aload #8
    //   242: aastore
    //   243: invokestatic a : ([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z
    //   246: ifne -> 261
    //   249: aload_0
    //   250: getfield azD : Landroid/app/Activity;
    //   253: getstatic com/laiqian/vip/R$string.pos_report_export_mail_send_fail : I
    //   256: invokevirtual getString : (I)Ljava/lang/String;
    //   259: astore #5
    //   261: aload #5
    //   263: ifnonnull -> 338
    //   266: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   269: aload_1
    //   270: invokevirtual rr : (Ljava/lang/String;)V
    //   273: goto -> 338
    //   276: iload_3
    //   277: istore_2
    //   278: aload #8
    //   280: new java/io/File
    //   283: dup
    //   284: aload_1
    //   285: aload #8
    //   287: invokevirtual getName : ()Ljava/lang/String;
    //   290: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   293: invokestatic d : (Ljava/io/File;Ljava/io/File;)Z
    //   296: ifne -> 313
    //   299: aload_0
    //   300: getfield azD : Landroid/app/Activity;
    //   303: getstatic com/laiqian/vip/R$string.pos_report_export_u_fail : I
    //   306: invokevirtual getString : (I)Ljava/lang/String;
    //   309: astore #5
    //   311: iload_3
    //   312: istore_2
    //   313: aload_0
    //   314: getfield handler : Landroid/os/Handler;
    //   317: sipush #1234
    //   320: iload_2
    //   321: iconst_0
    //   322: aload #5
    //   324: invokevirtual obtainMessage : (IIILjava/lang/Object;)Landroid/os/Message;
    //   327: invokevirtual sendToTarget : ()V
    //   330: aload_0
    //   331: monitorexit
    //   332: return
    //   333: astore_1
    //   334: aload_0
    //   335: monitorexit
    //   336: aload_1
    //   337: athrow
    //   338: iconst_2
    //   339: istore_2
    //   340: goto -> 313
    // Exception table:
    //   from	to	target	type
    //   2	8	333	finally
    //   16	25	333	finally
    //   30	47	333	finally
    //   50	81	333	finally
    //   88	100	333	finally
    //   103	116	333	finally
    //   119	132	139	java/lang/Exception
    //   119	132	333	finally
    //   141	146	333	finally
    //   146	192	333	finally
    //   192	222	333	finally
    //   222	261	333	finally
    //   266	273	333	finally
    //   278	311	333	finally
    //   313	330	333	finally }
  
  private void fy(String paramString) {
    if (!RootApplication.getLaiqianPreferenceManager().Wq())
      this.bvO.show(); 
    (new a(this, paramString, null)).start();
  }
  
  private void fz(String paramString) {
    this.bvO.show();
    s s = new s(this.azD, 3);
    s.b(new bw(this, paramString));
    s.Zw();
  }
  
  public void Qp() {
    if (!RootApplication.getLaiqianPreferenceManager().Wq()) {
      a.aKh().r(new bt(this));
      return;
    } 
    if (RootApplication.getLaiqianPreferenceManager().Wq()) {
      a.aKh().r(new bu(this));
      return;
    } 
    int i = RootApplication.getLaiqianPreferenceManager().avL();
    if (i != 1 && i != 2)
      this.bvL.dF(false); 
  }
  
  public void Qq() { (new b(this, null)).execute(new Void[0]); }
  
  public void Qr() {
    if (this.bvM == null) {
      this.bvM = new ArrayList();
      HashMap hashMap = new HashMap();
      hashMap.put("name", this.azD.getString(R.string.pos_report_export_to_u));
      hashMap.put("state", null);
      hashMap.put("address", null);
      this.bvM.add(hashMap);
      hashMap = new HashMap();
      hashMap.put("name", this.azD.getString(R.string.pos_report_export_to_mail));
      hashMap.put("state", null);
      hashMap.put("address", "mail");
      this.bvM.add(hashMap);
    } 
    Qs();
    if (this.bvS == null) {
      Activity activity = this.azD;
      ArrayList arrayList = this.bvM;
      int i = R.layout.pos_choose_item;
      int j = R.id.spinner_text;
      int k = R.id.spinner_right;
      this.bvT = new p(activity, arrayList, i, new String[] { "name", "state" }, new int[] { j, k });
      this.bvS = this.bvL.Qn();
      this.bvS.a(this.bvT);
      this.bvS.getListView().setOnItemClickListener(new bv(this));
      this.bvS.setTitle(R.string.pos_report_export_to);
      DisplayMetrics displayMetrics = this.azD.getResources().getDisplayMetrics();
      this.bvS.setWidth(displayMetrics.widthPixels / 4);
      this.bvS.setTitle(this.azD.getString(R.string.export_vip));
    } 
    this.bvT.notifyDataSetChanged();
    this.bvS.show();
  }
  
  public Dialog Qt() { return this.bvO; }
  
  public void fA(String paramString) { (new a(this, paramString, null)).start(); }
  
  public void fx(String paramString) {
    if (paramString == null) {
      if (!this.bvL.Qh().isEmpty()) {
        Qs();
        this.bvT.notifyDataSetChanged();
        paramString = (String)((HashMap)this.bvM.get(0)).get("address");
        if (paramString != null) {
          fx(paramString);
          return;
        } 
      } 
    } else {
      Rect rect;
      if (paramString == "mail") {
        if (this.bvL.Qm() == null)
          this.bvL.Qj(); 
        rect = new Rect();
        View view = this.bvS.ark();
        view.getGlobalVisibleRect(rect);
        int i = rect.right;
        int j = rect.top;
        this.bvL.fw(null);
        this.bvL.Qm().showAtLocation(view, 0, i, j);
        return;
      } 
      if (this.bvL.Qh().isEmpty()) {
        Qs();
        this.bvT.notifyDataSetChanged();
        return;
      } 
      if (RootApplication.getLaiqianPreferenceManager().Wq()) {
        fz(rect);
        return;
      } 
      fy(rect);
    } 
  }
  
  public void init() {
    this.bvU = new p(this.azD);
    this.bvO = new bb(this.azD);
  }
  
  public class a extends Thread {
    private String bvY;
    
    private a(bs this$0, String param1String) { this.bvY = param1String; }
    
    public void run() {
      super.run();
      bs.b(this.bvW, this.bvY);
    }
  }
  
  private class b extends AsyncTask<Void, Void, Boolean> {
    boolean aGq = false;
    
    g aZY = null;
    
    private b(bs this$0) {}
    
    private boolean checkNetwork() {
      if (!bd.bH(bs.b(this.bvW))) {
        if (bs.c(this.bvW) == null) {
          bs.a(this.bvW, new bc(bs.b(this.bvW)));
          bs.c(this.bvW).setCancelable(false);
        } 
        bs.c(this.bvW).show();
        return false;
      } 
      return true;
    }
    
    protected void b(Boolean param1Boolean) {
      if (param1Boolean.booleanValue())
        bs.d(this.bvW).Pz(); 
      if (!bs.b(this.bvW).isFinishing() && bs.a(this.bvW) != null && bs.a(this.bvW).isShowing())
        bs.a(this.bvW).cancel(); 
    }
    
    protected Boolean g(Void... param1VarArgs) {
      if (this.aGq) {
        this.aZY.apy().gW(true);
        this.aZY.apy().ow("download_transaction");
        return Boolean.valueOf(this.aZY.c(true, "t_bpartner", 0L, System.currentTimeMillis()));
      } 
      return Boolean.valueOf(false);
    }
    
    protected void onPreExecute() {
      this.aGq = checkNetwork();
      if (this.aGq) {
        if (bs.a(this.bvW) == null) {
          bs.a(this.bvW, new bb(bs.b(this.bvW)));
          bs.a(this.bvW).setCancelable(false);
        } 
        bs.a(this.bvW).show();
        this.aZY = new g(bs.b(this.bvW));
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */