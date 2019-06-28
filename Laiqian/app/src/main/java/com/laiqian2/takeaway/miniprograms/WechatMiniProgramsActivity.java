package com.laiqian.takeaway.miniprograms;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bumptech.glide.g;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.print.util.e;
import com.laiqian.takeaway.R;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.ab;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.m;
import com.laiqian.ui.container.x;
import com.laiqian.ui.s;
import com.laiqian.util.n;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class WechatMiniProgramsActivity extends ActivityRoot implements o {
  w cjN = null;
  
  a dud;
  
  n due;
  
  aa titleBar;
  
  private void kw(int paramInt) {
    View view1 = View.inflate(getActivity(), R.layout.pos_export_mail, null);
    TextView textView1 = (TextView)view1.findViewById(R.id.address);
    TextView textView2 = (TextView)view1.findViewById(R.id.domain);
    null = getResources();
    if (getResources().getBoolean(R.bool.is_ShowingIndustry)) {
      i = R.array.pos_mail_address;
    } else {
      i = R.array.pos_mail_address_foreign;
    } 
    String[] arrayOfString1 = null.getStringArray(i);
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
    textView2.setOnClickListener(new j(this, new w(getActivity(), arrayOfString1, new i(this, textView2, arrayOfString1))));
    PopupWindow popupWindow = new PopupWindow(view1, -2, -2, true);
    popupWindow.setBackgroundDrawable(new ColorDrawable());
    popupWindow.setOutsideTouchable(true);
    TextView textView3 = (TextView)view1.findViewById(R.id.tvError);
    view1.findViewById(R.id.send).setOnClickListener(new k(this, textView1, textView3, textView2, paramInt));
    view1.findViewById(R.id.canal).setOnClickListener(new l(this, popupWindow));
    Rect rect = new Rect();
    View view2 = this.cjN.ark();
    view2.getGlobalVisibleRect(rect);
    paramInt = rect.right;
    int i = rect.top;
    textView3.setText(null);
    popupWindow.showAtLocation(view2, 0, paramInt, i);
  }
  
  private boolean ky(int paramInt) {
    null = n.a(getActivity(), true);
    if (null.size() == 0)
      return false; 
    String str = (String)null.get(0);
    bitmap = kx(paramInt);
    if (bitmap == null)
      return false; 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(File.separator);
      n n1 = this.due;
      if (n.duv == paramInt) {
        paramInt = R.string.pos_export_takeaway_wxacode_filename;
      } else {
        paramInt = R.string.pos_export_scanorder_wxacode_filename;
      } 
      String str1 = getString(paramInt);
      stringBuilder.append(str1);
      stringBuilder.append(".jpg");
      FileOutputStream fileOutputStream = new FileOutputStream(stringBuilder.toString());
      boolean bool = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
      fileOutputStream.flush();
      fileOutputStream.close();
      return bool;
    } catch (IOException bitmap) {
      a.e(bitmap);
      return false;
    } 
  }
  
  private void setListeners() {
    ((ViewGroup)this.dud.duo.getView()).setOnClickListener(new d(this));
    ((CheckBox)this.dud.duo.dwV.getView()).setOnCheckedChangeListener(new e(this));
    this.dud.bqN.setOnClickListener(new f(this));
    this.dud.dul.setOnClickListener(new g(this));
  }
  
  private void setupViews() {
    this.titleBar.tvTitle.setText(getString(R.string.open_mini_programs));
    Button button = this.titleBar.brj;
    byte b = 0;
    button.setVisibility(0);
    this.titleBar.brj.setText(R.string.tutorial);
    this.titleBar.brj.setOnClickListener(new a(this));
    ((TextView)this.dud.duo.cAO.getView()).setText(getString(R.string.open_mini_programs));
    ((TextView)this.dud.dui.cAO.getView()).setText(R.string.mini_programs_warning);
    ((TextView)this.dud.dun.cAO.getView()).setText(R.string.takeaway_mini_programs);
    ((TextView)this.dud.dun.cAP.getView()).setText(R.string.takeaway_mini_programs_title);
    ((TextView)this.dud.dum.cAO.getView()).setText(R.string.scanorder_mini_programs);
    ((TextView)this.dud.dum.dwP.getView()).setText(R.string.applicable_to_opentable);
    ((TextView)this.dud.dum.cAP.getView()).setText(R.string.scanorder_mini_programs_title);
    ((ViewGroup)this.dud.dui.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
    ((ViewGroup)this.dud.dun.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown_click);
    ((ViewGroup)this.dud.dum.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown_click);
    this.dud.dur.setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown_click);
    this.dud.duq.setBackgroundResource(R.drawable.shape_rounded_rectangle_down_click);
    ((ViewGroup)this.dud.duo.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
    ((CheckBox)this.dud.duo.dwV.getView()).setChecked(a.AZ().CA());
    ViewGroup viewGroup = this.dud.dup;
    if (!a.AZ().CA())
      b = 8; 
    viewGroup.setVisibility(b);
    if (a.AZ().CA())
      this.due.aqF(); 
  }
  
  public void Em() { ab.N(getActivity()); }
  
  public void a(int paramInt, Bitmap paramBitmap) {
    n n1 = this.due;
    if (paramInt == n.duv) {
      this.dud.duj.setImageBitmap(paramBitmap);
      return;
    } 
    n1 = this.due;
    if (paramInt == n.duw)
      this.dud.duk.setImageBitmap(paramBitmap); 
  }
  
  public void aqD() {
    this.dud.bxr.setVisibility(0);
    this.dud.bqN.setVisibility(8);
  }
  
  public void aqE() {
    this.dud.bxr.setVisibility(0);
    this.dud.bqN.setVisibility(0);
  }
  
  public void hideProgress() { ab.P(getActivity()); }
  
  public Bitmap kx(int paramInt) {
    n n1 = this.due;
    if (paramInt == n.duv)
      return ((BitmapDrawable)this.dud.duj.getDrawable()).getBitmap(); 
    n1 = this.due;
    return (paramInt == n.duw) ? ((BitmapDrawable)this.dud.duk.getDrawable()).getBitmap() : null;
  }
  
  protected void onCreate(Bundle paramBundle) {
    requestWindowFeature(7);
    this.dud = a.K(this);
    this.titleBar = aa.M(this);
    super.onCreate(paramBundle);
    this.due = new n(getApplication(), this);
    setupViews();
    setListeners();
  }
  
  public void t(int paramInt, String paramString) {
    n n1 = this.due;
    if (paramInt == n.duv) {
      g.F(this.dud.duj.getContext()).aF(paramString).qO().a(new b(this, paramInt));
      return;
    } 
    n1 = this.due;
    if (paramInt == n.duw)
      g.F(this.dud.duj.getContext()).aF(paramString).qO().a(new c(this, paramInt)); 
  }
  
  private static class a extends ab<ViewGroup> {
    public static final int aCt = R.layout.activity_wechat_mini_programs;
    
    public ProgressBarCircularIndeterminate aNv;
    
    public View aQG;
    
    public ViewGroup bqN;
    
    public ScrollView bxr;
    
    public x dui = new x(R.id.layout_mini_programs_takeaway_title);
    
    public ImageView duj;
    
    public ImageView duk;
    
    public Button dul;
    
    public x dum = new x(R.id.layout_mini_programs_scanorder);
    
    public x dun = new x(R.id.layout_mini_programs_takeaway);
    
    public m duo = new m(R.id.layout_open_mini_programs_switch);
    
    public ViewGroup dup;
    
    public ViewGroup duq;
    
    public ViewGroup dur;
    
    public a(int param1Int, View param1View) {
      super(param1Int);
      this.aQG = param1View;
      this.duj = (ImageView)s.z(param1View, R.id.iv_takeaway_wxacode);
      this.duk = (ImageView)s.z(param1View, R.id.iv_scanorder_wxacode);
      this.dul = (Button)s.z(param1View, R.id.btn_takeaway_export);
      this.duq = (ViewGroup)s.z(param1View, R.id.ll_scanorder_wxacode);
      this.dur = (ViewGroup)s.z(param1View, R.id.ll_takeaway_wxacode);
      this.dup = (ViewGroup)s.z(param1View, R.id.layout_mini_programs_setting);
      this.bxr = (ScrollView)s.z(param1View, R.id.scrollview);
      this.aNv = (ProgressBarCircularIndeterminate)s.z(param1View, R.id.ivProgress);
      this.bqN = (ViewGroup)s.z(param1View, R.id.llRefresh);
    }
    
    public static a K(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(aCt, null);
      param1Activity.setContentView(view);
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
  
  private class b extends Thread {
    private String bvY;
    
    private int dus;
    
    private b(WechatMiniProgramsActivity this$0, String param1String, int param1Int) {
      this.bvY = param1String;
      this.dus = param1Int;
    }
    
    public void run() {
      WechatMiniProgramsActivity wechatMiniProgramsActivity2;
      int i;
      if (this.duf.getActivity() == null)
        return; 
      WechatMiniProgramsActivity wechatMiniProgramsActivity1;
      String str2 = (wechatMiniProgramsActivity1 = this.duf.due).v(RootApplication.zv(), this.dus);
      boolean bool = true;
      String str3 = this.bvY;
      wechatMiniProgramsActivity1 = this.duf.due;
      if (n.duv == this.dus) {
        WechatMiniProgramsActivity wechatMiniProgramsActivity = this.duf;
        i = R.string.pos_export_takeaway_wxacode_subject;
      } else {
        WechatMiniProgramsActivity wechatMiniProgramsActivity1;
        wechatMiniProgramsActivity1 = this.duf;
        i = R.string.pos_export_scanorder_wxacode_subject;
      } 
      String str4 = wechatMiniProgramsActivity1.getString(i);
      String str5 = this.duf.getString(R.string.pos_export_takeaway_wxacode_content);
      StringBuilder stringBuilder = this.duf.due;
      if (n.duv == this.dus) {
        StringBuilder stringBuilder1 = new StringBuilder();
        wechatMiniProgramsActivity2 = this.duf;
        i = R.string.pos_export_takeaway_wxacode_filename;
      } else {
        stringBuilder = new StringBuilder();
        wechatMiniProgramsActivity2 = this.duf;
        i = R.string.pos_export_scanorder_wxacode_filename;
      } 
      stringBuilder.append(wechatMiniProgramsActivity2.getString(i));
      stringBuilder.append(".jpg");
      String str1 = stringBuilder.toString();
      if (n.a(new String[] { str3 }, str4, str5, new String[] { str2 }, new String[] { str1 })) {
        this.duf.getLaiqianPreferenceManager().rr(this.bvY);
      } else {
        bool = false;
      } 
      e.i(new m(this, bool));
      if (this.duf.getActivity() == null)
        return; 
      ab.P(this.duf.getActivity());
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\miniprograms\WechatMiniProgramsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */