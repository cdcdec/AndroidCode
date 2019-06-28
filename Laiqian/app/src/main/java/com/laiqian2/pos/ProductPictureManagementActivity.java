package com.laiqian.pos;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.DocumentsContract;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.a.a.b;
import com.google.a.a.a.a.a.a;
import com.laiqian.infrastructure.R;
import com.laiqian.models.ac;
import com.laiqian.models.x;
import com.laiqian.product.fa;
import com.laiqian.product.models.g;
import com.laiqian.sync.a.g;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.w;
import com.laiqian.util.ae;
import com.laiqian.util.am;
import com.laiqian.util.az;
import com.laiqian.util.bb;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import io.reactivex.g.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductPictureManagementActivity extends ActivityRoot {
  public static ArrayList<HashMap<String, String>> chq;
  
  private final int cgS = 11;
  
  private final int cgT = 12;
  
  private final int cgU = 2;
  
  private boolean cgV;
  
  private View cgW;
  
  private EditText cgX;
  
  private a cgY;
  
  private b cgZ;
  
  private String cha;
  
  private String chb;
  
  private String chc;
  
  private HashMap<String, String> chd;
  
  private String che;
  
  private String chf;
  
  private ListView chg;
  
  private View chh;
  
  private final String chi = "0";
  
  private final String chj = "1";
  
  private HashMap<String, File> chk;
  
  boolean chl;
  
  boolean chm;
  
  boolean chn;
  
  private fa cho;
  
  private int chp;
  
  w chr;
  
  w chs;
  
  a.a cht;
  
  String chu;
  
  String chv;
  
  Handler chw;
  
  public ProductPictureManagementActivity() {
    if (Build.VERSION.SDK_INT >= 19) {
      bool = true;
    } else {
      bool = false;
    } 
    this.chl = bool;
    this.chm = false;
    this.chu = "0";
    this.chv = "";
    this.chw = new bw(this);
  }
  
  private void D(HashMap<String, String> paramHashMap) {
    boolean bool;
    if (paramHashMap == null) {
      this.cho.a(null, null, null, false, "92");
      return;
    } 
    fa fa1 = this.cho;
    String str1 = (String)paramHashMap.get("id");
    String str2 = (String)paramHashMap.get("name");
    String str3 = (String)paramHashMap.get("name2");
    if (n.parseInt((String)paramHashMap.get("isUpper")) == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    fa1.a(str1, str2, str3, bool, (String)paramHashMap.get("type"), n.parseInt((String)paramHashMap.get("hotSaleType")));
  }
  
  private void ZQ() {
    findViewById(R.id.back).setOnClickListener(new bx(this));
    findViewById(R.id.type_add_small).setOnClickListener(new by(this));
    View view = findViewById(R.id.type_body_l);
    this.cho = new fa(this);
    this.cho.a(new bz(this));
    this.chg = (ListView)view.findViewById(R.id.type_body);
    this.cgZ = new b(this, this.chg);
    this.chg.setAdapter(this.cgZ);
    this.chg.setChoiceMode(1);
    this.chg.setOnItemClickListener(new ca(this));
    this.chg.setItemChecked(1, true);
    findViewById(R.id.back).setOnClickListener(new cb(this));
  }
  
  private boolean ZS() { return (this.cgW.getVisibility() == 0); }
  
  private void ZT() {
    this.chm = true;
    if (!TextUtils.isEmpty(this.chb) && this.chb.equals(String.valueOf(91L))) {
      gM(n.parseInt(this.chc));
    } else if (!TextUtils.isEmpty(this.chb) && this.chb.equals(String.valueOf(92L))) {
      ArrayList arrayList;
      g g = new g(this);
      if (TextUtils.isEmpty(this.chf)) {
        arrayList = new ArrayList();
      } else {
        arrayList = g.v(this.chf, false);
      } 
      chq = arrayList;
      g.close();
    } else {
      g g = new g(this);
      chq = g.aN(this.cha, this.cgX.getText().toString());
      g.close();
    } 
    this.cgY.notifyDataSetChanged();
  }
  
  private void ZU() {
    Intent intent = new Intent();
    intent.setClass(this, com.laiqian.ui.cropper.CropImageActivity.class);
    intent.putExtra("PHOTO_CROP_SAVEPATH", ((File)this.chk.get(this.chu)).getAbsolutePath());
    intent.putExtra("MAX_WIDTH", ae.b(this, 600.0F));
    intent.putExtra("MAX_HEIGHT", ae.b(this, 600.0F));
    startActivityForResult(intent, 13);
  }
  
  @RequiresApi
  private boolean c(Uri paramUri) {
    String str;
    if (this.chl && DocumentsContract.isDocumentUri(this, paramUri)) {
      str = am.b(this, paramUri);
    } else {
      str = am.c(this, paramUri);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("filename_uri->");
    stringBuilder.append(str);
    bb.e("filename", stringBuilder.toString());
    if (this.chk == null)
      return false; 
    if (str != null && (new File(str)).exists())
      return am.B(str, ((File)this.chk.get(this.chu)).getAbsolutePath()); 
    if (str == null)
      try {
        return am.a(getContentResolver().openInputStream(paramUri), ((File)this.chk.get(this.chu)).getAbsolutePath());
      } catch (FileNotFoundException paramUri) {
        a.e(paramUri);
      }  
    return false;
  }
  
  private void gD(int paramInt) {
    if (paramInt > 0) {
      this.chg.getOnItemClickListener().onItemClick(this.chg, null, paramInt, 0L);
      this.chg.setItemChecked(paramInt, true);
    } 
  }
  
  private void gL(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("position:");
    stringBuilder.append(paramInt);
    Log.e("updateSelectedVaule", stringBuilder.toString());
    if (paramInt >= 0 && paramInt < this.cgZ.getCount()) {
      HashMap hashMap = this.cgZ.gN(paramInt);
    } else {
      stringBuilder = null;
    } 
    if (stringBuilder == null) {
      this.cha = null;
      this.che = null;
      this.chb = null;
      this.chc = null;
      this.chf = null;
      this.chd = null;
      return;
    } 
    this.chd = stringBuilder;
    this.cha = (String)stringBuilder.get("id");
    this.che = (String)stringBuilder.get("name");
    this.chb = (String)stringBuilder.get("type");
    if ((this.chf = (String)stringBuilder.get("productIds")).valueOf(91L).equals(this.chb))
      this.chc = (String)stringBuilder.get("hotSaleType"); 
  }
  
  private void gM(int paramInt) {
    g g;
    ArrayList arrayList;
    switch (paramInt) {
      default:
        return;
      case 2:
        g = new g(this);
        if (TextUtils.isEmpty(this.chf)) {
          arrayList = new ArrayList();
        } else {
          arrayList = g.v(this.chf, false);
        } 
        chq = arrayList;
        g.close();
        return;
      case 1:
        x = new x(this);
        chq = x.gg(1);
        x.close();
        return;
      case 0:
        break;
    } 
    x x = new x(this);
    chq = x.gg(0);
    x.close();
  }
  
  private void n(Intent paramIntent) {
    az.info("setPicToView");
    if (paramIntent.getAction() != null || paramIntent.getExtras() != null) {
      if (!paramIntent.getBooleanExtra("PHOTO_CROP_RESULT", false)) {
        Toast.makeText(this, getString(R.string.pos_crop_picture_fails), 0).show();
        return;
      } 
      this.cht.chK.setVisibility(0);
      this.cht.chI.setVisibility(8);
      this.cht.chJ.setVisibility(8);
      a.aKh().r(new br(this));
    } 
  }
  
  private void setProduct() {
    View view = findViewById(R.id.vClean);
    view.setOnClickListener(new cc(this));
    view.setVisibility(8);
    this.chh = findViewById(R.id.product_title_l).findViewById(R.id.product_query);
    this.cgW = findViewById(R.id.product_query_l);
    this.cgX = (EditText)this.cgW.findViewById(R.id.query_et);
    this.cgX.addTextChangedListener(new cd(this, view));
    ListView listView = (ListView)findViewById(R.id.product_body_l).findViewById(R.id.product_body);
    this.cgY = new a(this, listView);
    listView.setAdapter(this.cgY);
    this.cgX.addTextChangedListener(new ce(this));
  }
  
  public long[] ZR() {
    boolean bool = TextUtils.isEmpty(this.chf);
    byte b1 = 0;
    if (!bool) {
      String[] arrayOfString = this.chf.split(",");
      long[] arrayOfLong = new long[arrayOfString.length];
      while (b1 < arrayOfString.length) {
        arrayOfLong[b1] = n.parseLong(arrayOfString[b1]);
        b1++;
      } 
      return arrayOfLong;
    } 
    return new long[0];
  }
  
  @RequiresApi
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1 && (paramIntent == null || paramInt2 == 0))
      return; 
    if (paramInt1 != 2) {
      switch (paramInt1) {
        default:
          return;
        case 13:
          n(paramIntent);
          return;
        case 12:
          ZU();
          return;
        case 11:
          break;
      } 
      if (c(paramIntent.getData())) {
        ZU();
        return;
      } 
    } else {
      long[] arrayOfLong = paramIntent.getLongArrayExtra("IDs");
      StringBuffer stringBuffer = new StringBuffer();
      for (paramInt1 = 0; paramInt1 < arrayOfLong.length; paramInt1++) {
        if (paramInt1 == 0) {
          stringBuffer.append(arrayOfLong[paramInt1]);
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(",");
          stringBuilder.append(arrayOfLong[paramInt1]);
          stringBuffer.append(stringBuilder.toString());
        } 
      } 
      this.chf = stringBuffer.toString();
      (new ac(this)).p(n.parseLong(this.cha), this.chf);
      this.cgZ.YQ();
      gD(this.cgZ.jy(this.cha) + this.cgZ.YO() + 1);
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetNoTitle(R.layout.wechat_product_main);
    this.chn = getActivity().getResources().getBoolean(R.bool.is_ShowingIndustry);
    this.cgV = "1200".equals(getLaiqianPreferenceManager().atB());
    ZQ();
    setProduct();
  }
  
  public void onResume() {
    this.chm = false;
    super.onResume();
  }
  
  public void onStop() {
    if (this.chm) {
      bb.e("用户改变了商品数据", "正在上传");
      long l = System.currentTimeMillis();
      g g = new g(this);
      g.a(new bs(this));
      a.aKh().r(new bq(g, l - 2592000000L, l));
    } 
    super.onStop();
  }
  
  class a extends BaseAdapter {
    private ListView bWY;
    
    private View chB;
    
    private View chC;
    
    private View chD;
    
    private View chE;
    
    public a(ProductPictureManagementActivity this$0, ListView param1ListView) {
      this.bWY = param1ListView;
      this.chB = this$0.findViewById(R.id.product_add_small);
      this.chC = this$0.findViewById(R.id.product_add_l);
      this.chD = this$0.findViewById(R.id.addTypeText);
      this.chE = this$0.findViewById(R.id.product_no);
      if (param1ListView.getHeaderViewsCount() == 0)
        param1ListView.addHeaderView(View.inflate(this$0, R.layout.listview_headview_10500, null)); 
      if (param1ListView.getFooterViewsCount() == 0)
        param1ListView.addFooterView(View.inflate(this$0, R.layout.listview_headview_10500, null)); 
      this.chB.setOnClickListener(new cf(this, this$0));
      this.chC.setOnClickListener(new cg(this, this$0));
      YQ();
    }
    
    public void YQ() {
      n.println("查询了商品");
      if (!TextUtils.isEmpty(ProductPictureManagementActivity.i(this.chz)) && ProductPictureManagementActivity.i(this.chz).equals(String.valueOf(91L))) {
        ProductPictureManagementActivity.d(this.chz, n.parseInt(ProductPictureManagementActivity.j(this.chz)));
      } else if (!TextUtils.isEmpty(ProductPictureManagementActivity.i(this.chz)) && ProductPictureManagementActivity.i(this.chz).equals(String.valueOf(92L))) {
        ArrayList arrayList;
        g g = new g(this.chz);
        if (TextUtils.isEmpty(ProductPictureManagementActivity.k(this.chz))) {
          arrayList = new ArrayList();
        } else {
          arrayList = g.v(ProductPictureManagementActivity.k(this.chz), false);
        } 
        ProductPictureManagementActivity.chq = arrayList;
        g.close();
      } else {
        g g = new g(this.chz);
        ProductPictureManagementActivity.chq = g.aN(ProductPictureManagementActivity.h(this.chz), ProductPictureManagementActivity.f(this.chz).getText().toString());
        g.close();
      } 
      if (ProductPictureManagementActivity.chq.size() == 0) {
        ProductPictureManagementActivity.l(this.chz).setVisibility(4);
        if (ProductPictureManagementActivity.g(this.chz)) {
          this.chE.setVisibility(0);
          this.chC.setVisibility(8);
          this.chD.setVisibility(8);
        } else if (ProductPictureManagementActivity.a(this.chz).getCount() == 0) {
          this.chC.setVisibility(8);
          this.chB.setVisibility(8);
          this.chE.setVisibility(8);
        } else {
          if ((!TextUtils.isEmpty(ProductPictureManagementActivity.i(this.chz)) && ProductPictureManagementActivity.i(this.chz).equals(String.valueOf(91L)) && String.valueOf(2).equals(ProductPictureManagementActivity.j(this.chz))) || (!TextUtils.isEmpty(ProductPictureManagementActivity.i(this.chz)) && ProductPictureManagementActivity.i(this.chz).equals(String.valueOf(92L)))) {
            this.chB.setVisibility(0);
            this.chC.setVisibility(0);
          } else {
            this.chB.setVisibility(8);
            this.chC.setVisibility(8);
          } 
          this.chD.setVisibility(8);
          this.chE.setVisibility(8);
        } 
      } else {
        if ((!TextUtils.isEmpty(ProductPictureManagementActivity.i(this.chz)) && ProductPictureManagementActivity.i(this.chz).equals(String.valueOf(91L)) && String.valueOf(2).equals(ProductPictureManagementActivity.j(this.chz))) || (!TextUtils.isEmpty(ProductPictureManagementActivity.i(this.chz)) && ProductPictureManagementActivity.i(this.chz).equals(String.valueOf(92L)))) {
          this.chB.setVisibility(0);
          this.chC.setVisibility(0);
        } else {
          this.chB.setVisibility(8);
          this.chC.setVisibility(8);
        } 
        this.chE.setVisibility(8);
        this.chC.setVisibility(8);
        this.chD.setVisibility(8);
        ProductPictureManagementActivity.l(this.chz).setVisibility(4);
      } 
      notifyDataSetChanged();
      this.bWY.setSelection(0);
    }
    
    public HashMap<String, String> gN(int param1Int) { return (HashMap)ProductPictureManagementActivity.chq.get(param1Int); }
    
    public int getCount() { return ProductPictureManagementActivity.chq.size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) { // Byte code:
      //   0: aload_2
      //   1: ifnonnull -> 103
      //   4: aload_0
      //   5: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
      //   8: getstatic com/laiqian/infrastructure/R$layout.pos_wechat_main_product_item : I
      //   11: aconst_null
      //   12: invokestatic inflate : (Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
      //   15: astore_2
      //   16: new com/laiqian/pos/ProductPictureManagementActivity$a$a
      //   19: dup
      //   20: aload_0
      //   21: aload_2
      //   22: getstatic com/laiqian/infrastructure/R$id.product_name : I
      //   25: invokevirtual findViewById : (I)Landroid/view/View;
      //   28: checkcast android/widget/TextView
      //   31: aload_2
      //   32: getstatic com/laiqian/infrastructure/R$id.product_price : I
      //   35: invokevirtual findViewById : (I)Landroid/view/View;
      //   38: checkcast android/widget/TextView
      //   41: aload_2
      //   42: getstatic com/laiqian/infrastructure/R$id.product_img : I
      //   45: invokevirtual findViewById : (I)Landroid/view/View;
      //   48: checkcast android/widget/ImageView
      //   51: aload_2
      //   52: getstatic com/laiqian/infrastructure/R$id.product_left_lay : I
      //   55: invokevirtual findViewById : (I)Landroid/view/View;
      //   58: checkcast android/widget/LinearLayout
      //   61: aload_2
      //   62: getstatic com/laiqian/infrastructure/R$id.product_upload_lay : I
      //   65: invokevirtual findViewById : (I)Landroid/view/View;
      //   68: checkcast android/widget/LinearLayout
      //   71: aload_2
      //   72: getstatic com/laiqian/infrastructure/R$id.product_upload_txt : I
      //   75: invokevirtual findViewById : (I)Landroid/view/View;
      //   78: checkcast android/widget/TextView
      //   81: aload_2
      //   82: getstatic com/laiqian/infrastructure/R$id.product_loading : I
      //   85: invokevirtual findViewById : (I)Landroid/view/View;
      //   88: checkcast com/laiqian/ui/ProgressBarCircularIndeterminate
      //   91: invokespecial <init> : (Lcom/laiqian/pos/ProductPictureManagementActivity$a;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/ImageView;Landroid/widget/LinearLayout;Landroid/widget/LinearLayout;Landroid/widget/TextView;Lcom/laiqian/ui/ProgressBarCircularIndeterminate;)V
      //   94: astore_3
      //   95: aload_2
      //   96: aload_3
      //   97: invokevirtual setTag : (Ljava/lang/Object;)V
      //   100: goto -> 111
      //   103: aload_2
      //   104: invokevirtual getTag : ()Ljava/lang/Object;
      //   107: checkcast com/laiqian/pos/ProductPictureManagementActivity$a$a
      //   110: astore_3
      //   111: aload_0
      //   112: iload_1
      //   113: invokevirtual gN : (I)Ljava/util/HashMap;
      //   116: astore #10
      //   118: aload #10
      //   120: ldc_w 'name'
      //   123: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   126: checkcast java/lang/String
      //   129: astore #7
      //   131: aload #10
      //   133: ldc_w 'sProductDescription'
      //   136: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   139: checkcast java/lang/String
      //   142: astore #8
      //   144: aload_3
      //   145: getfield aKu : Landroid/widget/TextView;
      //   148: aload #7
      //   150: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   153: aload #10
      //   155: ldc_w 'price'
      //   158: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   161: checkcast java/lang/String
      //   164: astore #6
      //   166: aload #6
      //   168: ldc_w '.'
      //   171: invokevirtual indexOf : (Ljava/lang/String;)I
      //   174: istore_1
      //   175: iconst_0
      //   176: istore #4
      //   178: iload_1
      //   179: iconst_m1
      //   180: if_icmpne -> 193
      //   183: aload #6
      //   185: invokevirtual length : ()I
      //   188: bipush #100
      //   190: if_icmpgt -> 203
      //   193: aload #6
      //   195: astore #5
      //   197: iload_1
      //   198: bipush #100
      //   200: if_icmple -> 242
      //   203: new java/lang/StringBuilder
      //   206: dup
      //   207: invokespecial <init> : ()V
      //   210: astore #5
      //   212: aload #5
      //   214: aload #6
      //   216: iconst_0
      //   217: bipush #100
      //   219: invokevirtual substring : (II)Ljava/lang/String;
      //   222: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   225: pop
      //   226: aload #5
      //   228: ldc_w '…'
      //   231: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   234: pop
      //   235: aload #5
      //   237: invokevirtual toString : ()Ljava/lang/String;
      //   240: astore #5
      //   242: aload #10
      //   244: ldc_w 'id'
      //   247: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   250: checkcast java/lang/String
      //   253: astore #6
      //   255: new com/laiqian/product/models/g
      //   258: dup
      //   259: aload_0
      //   260: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
      //   263: invokespecial <init> : (Landroid/content/Context;)V
      //   266: astore #11
      //   268: aload #11
      //   270: aload #6
      //   272: invokevirtual mD : (Ljava/lang/String;)Ljava/lang/String;
      //   275: astore #9
      //   277: aload #11
      //   279: invokevirtual close : ()V
      //   282: aload #9
      //   284: invokestatic isNull : (Ljava/lang/String;)Z
      //   287: ifeq -> 310
      //   290: aload_3
      //   291: getfield chI : Landroid/widget/TextView;
      //   294: iconst_0
      //   295: invokevirtual setVisibility : (I)V
      //   298: aload_3
      //   299: getfield chJ : Landroid/widget/ImageView;
      //   302: bipush #8
      //   304: invokevirtual setVisibility : (I)V
      //   307: goto -> 397
      //   310: aload_3
      //   311: getfield chJ : Landroid/widget/ImageView;
      //   314: iconst_0
      //   315: invokevirtual setVisibility : (I)V
      //   318: aload_3
      //   319: getfield chI : Landroid/widget/TextView;
      //   322: bipush #8
      //   324: invokevirtual setVisibility : (I)V
      //   327: new com/laiqian/pos/ch
      //   330: dup
      //   331: aload_0
      //   332: aload_3
      //   333: invokespecial <init> : (Lcom/laiqian/pos/ProductPictureManagementActivity$a;Lcom/laiqian/pos/ProductPictureManagementActivity$a$a;)V
      //   336: pop
      //   337: aload_3
      //   338: getfield chK : Lcom/laiqian/ui/ProgressBarCircularIndeterminate;
      //   341: iconst_0
      //   342: invokevirtual setVisibility : (I)V
      //   345: aload_3
      //   346: getfield chI : Landroid/widget/TextView;
      //   349: bipush #8
      //   351: invokevirtual setVisibility : (I)V
      //   354: aload_3
      //   355: getfield chJ : Landroid/widget/ImageView;
      //   358: bipush #8
      //   360: invokevirtual setVisibility : (I)V
      //   363: aload_0
      //   364: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
      //   367: invokevirtual getActivity : ()Lcom/laiqian/ui/ActivityRoot;
      //   370: invokestatic cx : (Landroid/content/Context;)Lcom/squareup/a/ab;
      //   373: aload #9
      //   375: invokevirtual sW : (Ljava/lang/String;)Lcom/squareup/a/aj;
      //   378: aload_3
      //   379: getfield chJ : Landroid/widget/ImageView;
      //   382: new com/laiqian/pos/ci
      //   385: dup
      //   386: aload_0
      //   387: aload_3
      //   388: invokespecial <init> : (Lcom/laiqian/pos/ProductPictureManagementActivity$a;Lcom/laiqian/pos/ProductPictureManagementActivity$a$a;)V
      //   391: invokevirtual a : (Landroid/widget/ImageView;Lcom/squareup/a/l;)V
      //   394: iconst_1
      //   395: istore #4
      //   397: aload #10
      //   399: ldc_w 'nSpareField1'
      //   402: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   405: checkcast java/lang/String
      //   408: astore #10
      //   410: ldc_w '0'
      //   413: aload #10
      //   415: invokevirtual equals : (Ljava/lang/Object;)Z
      //   418: ifeq -> 486
      //   421: aload_3
      //   422: getfield bDt : Landroid/widget/TextView;
      //   425: astore #11
      //   427: new java/lang/StringBuilder
      //   430: dup
      //   431: invokespecial <init> : ()V
      //   434: astore #12
      //   436: aload #12
      //   438: invokestatic zA : ()Ljava/lang/String;
      //   441: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   444: pop
      //   445: aload #12
      //   447: aload #5
      //   449: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   452: pop
      //   453: aload #11
      //   455: aload #12
      //   457: invokevirtual toString : ()Ljava/lang/String;
      //   460: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   463: aload_3
      //   464: getfield bDt : Landroid/widget/TextView;
      //   467: aload_0
      //   468: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
      //   471: invokevirtual getResources : ()Landroid/content/res/Resources;
      //   474: getstatic com/laiqian/infrastructure/R$color.pos_text_red : I
      //   477: invokevirtual getColor : (I)I
      //   480: invokevirtual setTextColor : (I)V
      //   483: goto -> 582
      //   486: aload_3
      //   487: getfield bDt : Landroid/widget/TextView;
      //   490: astore #11
      //   492: new java/lang/StringBuilder
      //   495: dup
      //   496: invokespecial <init> : ()V
      //   499: astore #12
      //   501: aload #12
      //   503: invokestatic zA : ()Ljava/lang/String;
      //   506: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   509: pop
      //   510: aload #12
      //   512: aload #5
      //   514: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   517: pop
      //   518: aload #12
      //   520: ldc_w '   ('
      //   523: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   526: pop
      //   527: aload #12
      //   529: aload_0
      //   530: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
      //   533: getstatic com/laiqian/infrastructure/R$string.wechat_product_hide : I
      //   536: invokevirtual getString : (I)Ljava/lang/String;
      //   539: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   542: pop
      //   543: aload #12
      //   545: ldc_w ')'
      //   548: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   551: pop
      //   552: aload #11
      //   554: aload #12
      //   556: invokevirtual toString : ()Ljava/lang/String;
      //   559: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   562: aload_3
      //   563: getfield bDt : Landroid/widget/TextView;
      //   566: aload_0
      //   567: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
      //   570: invokevirtual getResources : ()Landroid/content/res/Resources;
      //   573: getstatic com/laiqian/infrastructure/R$color.pos_text_grey : I
      //   576: invokevirtual getColor : (I)I
      //   579: invokevirtual setTextColor : (I)V
      //   582: aload_3
      //   583: getfield chM : Landroid/widget/LinearLayout;
      //   586: new com/laiqian/pos/ProductPictureManagementActivity$d
      //   589: dup
      //   590: aload_0
      //   591: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
      //   594: aload_3
      //   595: aload #6
      //   597: iload #4
      //   599: aload #9
      //   601: invokespecial <init> : (Lcom/laiqian/pos/ProductPictureManagementActivity;Lcom/laiqian/pos/ProductPictureManagementActivity$a$a;Ljava/lang/String;ZLjava/lang/String;)V
      //   604: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   607: aload_3
      //   608: getfield chL : Landroid/widget/LinearLayout;
      //   611: new com/laiqian/pos/ProductPictureManagementActivity$c
      //   614: dup
      //   615: aload_0
      //   616: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
      //   619: aload #6
      //   621: aload #10
      //   623: aload #7
      //   625: aload #8
      //   627: invokespecial <init> : (Lcom/laiqian/pos/ProductPictureManagementActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   630: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   633: aload_2
      //   634: areturn }
    
    class a {
      TextView aKu;
      
      TextView bDt;
      
      TextView chI;
      
      ImageView chJ;
      
      ProgressBarCircularIndeterminate chK;
      
      LinearLayout chL;
      
      LinearLayout chM;
      
      public a(ProductPictureManagementActivity.a this$0, TextView param2TextView1, TextView param2TextView2, ImageView param2ImageView, LinearLayout param2LinearLayout1, LinearLayout param2LinearLayout2, TextView param2TextView3, ProgressBarCircularIndeterminate param2ProgressBarCircularIndeterminate) {
        this.aKu = param2TextView1;
        this.bDt = param2TextView2;
        this.chJ = param2ImageView;
        this.chL = param2LinearLayout1;
        this.chM = param2LinearLayout2;
        this.chI = param2TextView3;
        this.chK = param2ProgressBarCircularIndeterminate;
      }
    }
  }
  
  class a {
    TextView aKu;
    
    TextView bDt;
    
    TextView chI;
    
    ImageView chJ;
    
    ProgressBarCircularIndeterminate chK;
    
    LinearLayout chL;
    
    LinearLayout chM;
    
    public a(ProductPictureManagementActivity this$0, TextView param1TextView1, TextView param1TextView2, ImageView param1ImageView, LinearLayout param1LinearLayout1, LinearLayout param1LinearLayout2, TextView param1TextView3, ProgressBarCircularIndeterminate param1ProgressBarCircularIndeterminate) {
      this.aKu = param1TextView1;
      this.bDt = param1TextView2;
      this.chJ = param1ImageView;
      this.chL = param1LinearLayout1;
      this.chM = param1LinearLayout2;
      this.chI = param1TextView3;
      this.chK = param1ProgressBarCircularIndeterminate;
    }
  }
  
  class b extends BaseAdapter {
    private ListView bWY;
    
    private ArrayList<HashMap<String, String>> bjv;
    
    private View cdl;
    
    View.OnClickListener cdm = new ck(this);
    
    private ac chN;
    
    private View chO;
    
    public b(ProductPictureManagementActivity this$0, ListView param1ListView) {
      this.bWY = param1ListView;
      if (this.bWY.getHeaderViewsCount() == 0) {
        View view1;
        View view2 = (view1 = View.inflate(this$0, R.layout.listview_headview_10500, null)).inflate(this$0, R.layout.pos_product_main_type_item_head, null);
        this.bWY.addHeaderView(view1);
        this.bWY.addHeaderView(view2);
      } 
      this.cdl = View.inflate(this$0, R.layout.listview_headview_10500, null);
      this.chN = new ac(this$0);
      this.chO = this$0.findViewById(R.id.type_add_l);
      this.chO.setOnClickListener(new cj(this, this$0));
      YQ();
    }
    
    public int YO() { return this.bWY.getHeaderViewsCount() - 1; }
    
    public void YQ() {
      n.println("查询了商品类型");
      this.bjv = this.chN.p(true, true);
      if (this.bjv.size() == 0) {
        if (this.bWY.getFooterViewsCount() > 0)
          this.bWY.removeFooterView(this.cdl); 
      } else {
        if (this.bWY.getFooterViewsCount() == 0)
          this.bWY.addFooterView(this.cdl); 
        this.bWY.setSelection(0);
      } 
      notifyDataSetChanged();
    }
    
    public HashMap<String, String> gN(int param1Int) { return (HashMap)this.bjv.get(param1Int); }
    
    public int getCount() { return this.bjv.size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a;
      if (param1View == null) {
        param1View = View.inflate(this.chz, R.layout.pos_wechat_main_type_item, null);
        TextView textView1 = (TextView)param1View.findViewById(R.id.type_name);
        TextView textView2 = (TextView)param1View.findViewById(R.id.tv_lower);
        View view = param1View.findViewById(R.id.type_update);
        view.setOnClickListener(this.cdm);
        a = new a(this, textView1, view, textView2);
        param1View.setTag(a);
      } else {
        a = (a)param1View.getTag();
      } 
      HashMap hashMap = gN(param1Int);
      if (hashMap != null) {
        a.aKu.setText((CharSequence)hashMap.get("name"));
        a.cdo.setTag(hashMap);
        TextView textView = a.chQ;
        if (n.parseInt((String)hashMap.get("isUpper")) == 0) {
          param1Int = 8;
        } else {
          param1Int = 0;
        } 
        textView.setVisibility(param1Int);
      } 
      return param1View;
    }
    
    public int jy(String param1String) {
      for (byte b1 = 0; b1 < this.bjv.size(); b1++) {
        if (((String)((HashMap)this.bjv.get(b1)).get("id")).equals(param1String))
          return b1; 
      } 
      return -1;
    }
    
    class a {
      TextView aKu;
      
      View cdo;
      
      TextView chQ;
      
      public a(ProductPictureManagementActivity.b this$0, TextView param2TextView1, View param2View, TextView param2TextView2) {
        this.aKu = param2TextView1;
        this.cdo = param2View;
        this.chQ = param2TextView2;
      }
    }
  }
  
  class a {
    TextView aKu;
    
    View cdo;
    
    TextView chQ;
    
    public a(ProductPictureManagementActivity this$0, TextView param1TextView1, View param1View, TextView param1TextView2) {
      this.aKu = param1TextView1;
      this.cdo = param1View;
      this.chQ = param1TextView2;
    }
  }
  
  class c implements View.OnClickListener {
    String chR;
    
    String chS;
    
    String chT;
    
    String chU;
    
    public c(ProductPictureManagementActivity this$0, String param1String1, String param1String2, String param1String3, String param1String4) {
      this.chR = param1String2;
      this.chS = param1String1;
      this.chT = param1String3;
      this.chU = param1String4;
    }
    
    public void onClick(View param1View) {
      if (!String.valueOf(91L).equals(ProductPictureManagementActivity.i(this.chz))) {
        int i;
        ProductPictureManagementActivity productPictureManagementActivity;
        if (String.valueOf(92L).equals(ProductPictureManagementActivity.i(this.chz)))
          return; 
        if (this.chz.chr == null) {
          this.chz.chr = new w(this.chz);
          this.chz.chr.setTitle(this.chz.getString(R.string.wechat_product_statu_title));
        } 
        boolean bool = "0".equals(this.chR);
        w w = this.chz.chr;
        if (bool) {
          productPictureManagementActivity = this.chz;
          i = R.string.wechat_product_hide;
        } else {
          productPictureManagementActivity = this.chz;
          i = R.string.wechat_product_show;
        } 
        String str = productPictureManagementActivity.getString(i);
        w.C(new String[] { str, this.chz.getString(R.string.wechat_product_edit_details) });
        this.chz.chr.a(new cl(this, bool));
        this.chz.chr.show();
        return;
      } 
    }
  }
  
  class d implements View.OnClickListener {
    String chS;
    
    boolean chY;
    
    String chZ;
    
    ProductPictureManagementActivity.a.a cia;
    
    public d(ProductPictureManagementActivity this$0, ProductPictureManagementActivity.a.a param1a, String param1String1, boolean param1Boolean, String param1String2) {
      this.cia = param1a;
      this.chS = param1String1;
      this.chY = param1Boolean;
      this.chZ = param1String2;
    }
    
    public void onClick(View param1View) {
      if (this.chz.chs == null) {
        this.chz.chs = new w(this.chz);
        this.chz.chs.setTitle(this.chz.getString(R.string.wechat_product_photo_title));
      } 
      if (this.chY) {
        this.chz.chs.C(new String[] { this.chz.getString(R.string.wechat_product_photo_take), this.chz.getString(R.string.wechat_product_photo_sel), this.chz.getString(R.string.wechat_product_photo_preview), this.chz.getString(R.string.wechat_product_photo_del) });
      } else {
        this.chz.chs.C(new String[] { this.chz.getString(R.string.wechat_product_photo_take), this.chz.getString(R.string.wechat_product_photo_sel) });
      } 
      this.chz.chs.a(new cn(this));
      this.chz.chs.show();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\ProductPictureManagementActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */