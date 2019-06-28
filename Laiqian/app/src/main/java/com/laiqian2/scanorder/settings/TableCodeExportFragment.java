package com.laiqian.scanorder.settings;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.c.a;
import com.laiqian.models.an;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.n;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.pos.settings.aa;
import com.laiqian.scan_order_module.R;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.a.ab;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.aa;
import com.laiqian.util.al;
import com.laiqian.util.n;
import io.reactivex.g.a;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class TableCodeExportFragment extends FragmentRoot implements aa {
  private String aGA;
  
  private ArrayList<String> aGI;
  
  private String aGK;
  
  private ImageView azs;
  
  private int bHq = 0;
  
  w.a btm = new be(this);
  
  private View cjC;
  
  private TextView cjF;
  
  private String cjG;
  
  private Bitmap cjH;
  
  private int cjI = 0;
  
  private TextView cjJ;
  
  private View cjK;
  
  private View cjL;
  
  private View cjM;
  
  w cjN;
  
  private View.OnClickListener cjO = new bb(this);
  
  private ArrayList<TableEntity> djE;
  
  private View djF;
  
  private RelativeLayout djG;
  
  private TextView djH;
  
  Handler handler = new bc(this);
  
  private Context mContext;
  
  private void Qr() {
    if (getActivity() == null)
      return; 
    FragmentActivity fragmentActivity = getActivity();
    String str1 = getString(R.string.pos_report_export_to_u);
    String str2 = getString(R.string.pos_report_export_to_mail);
    bf bf = new bf(this);
    this.cjN = new w(fragmentActivity, new String[] { str1, str2 }, bf, false);
    this.cjN.show();
  }
  
  private void Tb() {
    if (getActivity() == null)
      return; 
    this.aGI = new ArrayList();
    this.aGI = n.a(getActivity(), true);
    int i = this.aGI.size();
    byte b = 0;
    if (i == 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((String)this.aGI.get(0));
      stringBuilder.append("/");
      stringBuilder.append(getString(R.string.scanorder_table_code));
      this.aGK = stringBuilder.toString();
      gU(1);
      return;
    } 
    if (i >= 1) {
      String[] arrayOfString = new String[i];
      while (b < this.aGI.size()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)this.aGI.get(b));
        stringBuilder.append("/");
        stringBuilder.append(getString(R.string.scanorder_table_code));
        arrayOfString[b] = stringBuilder.toString();
        b++;
      } 
      w w1 = new w(this.mContext, arrayOfString, this.btm);
      w1.setWidth(500);
      w1.gn(this.bHq);
      w1.setOnCancelListener(new bd(this));
      w1.show();
      return;
    } 
    gU(0);
  }
  
  private void a(String paramString, Bitmap paramBitmap, TableEntity paramTableEntity) throws Exception {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("/");
    stringBuilder.append(paramTableEntity.XX());
    stringBuilder.append(paramTableEntity.Vz());
    stringBuilder.append(".jpg");
    FileOutputStream fileOutputStream = new FileOutputStream(new File(stringBuilder.toString()));
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
    fileOutputStream.close();
  }
  
  private void aah() { this.cjK.setOnClickListener(this.cjO); }
  
  private void aai() {
    r r = new r(getActivity(), new bm(this));
    r.setTitle(getString(R.string.pos_quit_save_hint_dialog_title));
    r.s(getString(R.string.pos_export_tip));
    r.t(getString(R.string.pos_pay_print_no_title));
    r.oZ(getString(R.string.pos_pay_print_yes_title));
    r.show();
  }
  
  private void abt() {
    String[] arrayOfString1;
    if (getActivity() == null)
      return; 
    View view1 = View.inflate(getActivity(), R.layout.pos_export_mail, null);
    TextView textView1 = (TextView)view1.findViewById(R.id.address);
    TextView textView2 = (TextView)view1.findViewById(R.id.domain);
    if (a.zR().Ad()) {
      arrayOfString1 = new String[5];
      arrayOfString1[0] = "@yahoo.com";
      arrayOfString1[1] = "@hotmail.com";
      arrayOfString1[2] = "@gmail.com";
      arrayOfString1[3] = "@icloud.com";
      arrayOfString1[4] = "@163.com";
    } else {
      arrayOfString1 = new String[11];
      arrayOfString1[0] = "@qq.com";
      arrayOfString1[1] = "@163.com";
      arrayOfString1[2] = "@aliyun.com";
      arrayOfString1[3] = "@sina.com";
      arrayOfString1[4] = "@sina.cn";
      arrayOfString1[5] = "@139.com";
      arrayOfString1[6] = "@sohu.com";
      arrayOfString1[7] = "@189.cn";
      arrayOfString1[8] = "@126.com";
      arrayOfString1[9] = "@tom.com";
      arrayOfString1[10] = "@foxmail.com";
    } 
    String[] arrayOfString2 = getLaiqianPreferenceManager().auT();
    if (arrayOfString2 != null) {
      textView1.setText(arrayOfString2[0]);
      textView2.setText(arrayOfString2[1]);
      view1.requestFocus();
    } else {
      textView1.setText("");
      textView1.requestFocus();
      textView2.setText(arrayOfString1[0]);
      n.b(getActivity(), textView1);
    } 
    textView2.setOnClickListener(new bj(this, new w(getActivity(), arrayOfString1, new bi(this, textView2, arrayOfString1))));
    PopupWindow popupWindow = new PopupWindow(view1, -2, -2, true);
    popupWindow.setBackgroundDrawable(new ColorDrawable());
    popupWindow.setOutsideTouchable(true);
    TextView textView3 = (TextView)view1.findViewById(R.id.tvError);
    view1.findViewById(R.id.send).setOnClickListener(new bk(this, textView1, textView3, textView2));
    view1.findViewById(R.id.canal).setOnClickListener(new bl(this, popupWindow));
    Rect rect = new Rect();
    View view2 = this.cjN.ark();
    view2.getGlobalVisibleRect(rect);
    int i = rect.right;
    int j = rect.top;
    textView3.setText(null);
    popupWindow.showAtLocation(view2, 0, i, j);
  }
  
  private void aoT() {
    int i;
    if (getActivity() == null)
      return; 
    this.aGI = n.a(getActivity(), true);
    ArrayList arrayList = this.aGI;
    int j = 0;
    if (arrayList == null) {
      i = 0;
    } else {
      i = this.aGI.size();
    } 
    if (i == 1) {
      null = new StringBuilder();
      null.append((String)this.aGI.get(0));
      null.append("/");
      null.append(getString(R.string.scanorder_table_code));
      this.aGK = null.toString();
      File file = new File(this.aGK);
      if (!file.exists())
        file.mkdirs(); 
      nH(this.aGK);
      return;
    } 
    if (i > 1) {
      String[] arrayOfString = new String[i];
      for (i = j; i < this.aGI.size(); i++)
        arrayOfString[i] = (String)this.aGI.get(i); 
      w w1 = new w(this.mContext, arrayOfString, new bg(this, arrayOfString));
      w1.setWidth(500);
      w1.gn(this.bHq);
      w1.setOnCancelListener(new bh(this));
      w1.show();
    } 
  }
  
  private View findViewById(int paramInt) { return this.cjC.findViewById(paramInt); }
  
  private void gU(int paramInt) {
    StringBuilder stringBuilder;
    TextView textView;
    this.cjI = paramInt;
    switch (this.cjI) {
      default:
        return;
      case 1:
        textView = this.cjJ;
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.mContext.getString(R.string.pos_udisk_path));
        stringBuilder.append(this.aGK);
        textView.setText(stringBuilder.toString());
        this.cjF.setText(getString(R.string.pos_batch_export_table_code));
        this.cjM.setVisibility(8);
        return;
      case 0:
        break;
    } 
    this.bHq = 0;
    this.aGK = "";
    this.cjJ.setText(this.aGK);
    this.cjF.setText(getString(R.string.pos_batch_export_table_code));
    this.cjM.setVisibility(0);
  }
  
  private void initData() {
    this.mContext = getActivity();
    this.cjH = BitmapFactory.decodeStream(getResources().openRawResource(R.raw.scan_order_qrcode_backgroud));
    an.c c = (new an(this.mContext)).Vu();
    this.cjG = c.aVs;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(c.bSo);
    stringBuilder.append("");
    this.aGA = stringBuilder.toString();
    Tb();
    (new b(this, null)).execute(new Void[0]);
  }
  
  private void nH(String paramString) {
    this.cjL.setVisibility(0);
    this.cjF.setVisibility(8);
    a.aKh().r(new ba(this, paramString));
  }
  
  private Bitmap w(TableEntity paramTableEntity) {
    str2 = RootUrlParameter.clp;
    String str3 = this.aGA;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramTableEntity.getID());
    stringBuilder2.append("");
    str3 = String.format(str2, new Object[] { str3, stringBuilder2.toString() });
    str2 = str3;
    if (a.zR().Ad()) {
      null = new StringBuilder();
      null.append(str3);
      null.append("&en=1");
      str2 = null.toString();
    } 
    Bitmap bitmap = Bitmap.createBitmap(this.cjH.getWidth(), this.cjH.getHeight(), this.cjH.getConfig());
    Canvas canvas = new Canvas(bitmap);
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setDither(true);
    canvas.drawBitmap(this.cjH, 0.0F, 0.0F, paint);
    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
    try {
      Bitmap bitmap1 = al.C(str2, 268);
    } catch (Exception str2) {
      a.e(str2);
      str2 = null;
    } 
    canvas.drawBitmap(str2, 380.0F, 230.0F, paint);
    int i = this.cjH.getWidth();
    int j = i / 50;
    paint.setColor(-1);
    paint.setTextSize(56.0F);
    paint.setTypeface(Typeface.DEFAULT_BOLD);
    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramTableEntity.XX());
    stringBuilder1.append(paramTableEntity.Vz());
    String str1 = stringBuilder1.toString();
    Paint.FontMetrics fontMetrics = paint.getFontMetrics();
    float f1 = 81;
    float f2 = fontMetrics.descent;
    float f3 = i / 2.0F;
    paint.setTextAlign(Paint.Align.CENTER);
    canvas.drawText(str1, f3, f1 - f2, paint);
    return bitmap;
  }
  
  private void xT() {
    this.cjL = findViewById(R.id.ivExportProgress);
    this.cjK = findViewById(R.id.rlExport);
    this.cjM = findViewById(R.id.arrow);
    this.cjF = (TextView)findViewById(R.id.btnExport);
    this.cjJ = (TextView)findViewById(R.id.tv_path);
    this.azs = (ImageView)findViewById(R.id.iv_qrcode);
    this.djF = findViewById(R.id.ivLoadProgress);
    this.djG = (RelativeLayout)findViewById(R.id.rlContent);
    this.djH = (TextView)findViewById(R.id.tvNoTable);
  }
  
  public boolean Az() {
    View view = this.cjL;
    boolean bool = false;
    if (view != null) {
      if (this.cjL.getVisibility() == 0)
        bool = true; 
      return bool;
    } 
    return false;
  }
  
  public void a(aa paramaa) {}
  
  public void onCreate(Bundle paramBundle) { super.onCreate(paramBundle); }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.cjC = paramLayoutInflater.inflate(R.layout.fragment_export_table_qrcode, paramViewGroup, false);
    xT();
    aah();
    initData();
    return this.cjC;
  }
  
  public void save() {}
  
  private class a extends Thread {
    private String bvY;
    
    private a(TableCodeExportFragment this$0, String param1String) { this.bvY = param1String; }
    
    public void run() {
      try {
        file = this.djJ.getActivity().getExternalCacheDir();
        if (file == null)
          return; 
        arrayList = new ArrayList();
        i = (int)Math.ceil(TableCodeExportFragment.a(this.djJ).size() * 1.0D / 30);
        bool = false;
      } finally {
        ab.P(this.djJ.getActivity());
      } 
    }
  }
  
  private class b extends AsyncTask<Void, Void, ArrayList<TableEntity>> {
    private b(TableCodeExportFragment this$0) {}
    
    protected void au(ArrayList<TableEntity> param1ArrayList) {
      TableCodeExportFragment.a(this.djJ, param1ArrayList);
      if (TableCodeExportFragment.a(this.djJ) == null || TableCodeExportFragment.a(this.djJ).size() == 0) {
        TableCodeExportFragment.n(this.djJ).setVisibility(0);
        TableCodeExportFragment.l(this.djJ).setVisibility(8);
        return;
      } 
      TableCodeExportFragment.l(this.djJ).setVisibility(8);
      TableCodeExportFragment.m(this.djJ).setVisibility(0);
      TableCodeExportFragment.o(this.djJ).setImageBitmap(TableCodeExportFragment.a(this.djJ, (TableEntity)TableCodeExportFragment.a(this.djJ).get(0)));
    }
    
    protected ArrayList<TableEntity> i(Void... param1VarArgs) {
      ArrayList arrayList = new ArrayList();
      for (a a : n.Xo()) {
        Log.e("areaEntity", a.XX());
        for (TableEntity tableEntity : n.jg(String.valueOf(a.getId()))) {
          tableEntity.jl(a.XX());
          Log.e("tableEntity", tableEntity.Vz());
          arrayList.add(tableEntity);
        } 
      } 
      return arrayList;
    }
    
    protected void onPreExecute() {
      TableCodeExportFragment.l(this.djJ).setVisibility(0);
      TableCodeExportFragment.m(this.djJ).setVisibility(8);
      TableCodeExportFragment.n(this.djJ).setVisibility(8);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\TableCodeExportFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */