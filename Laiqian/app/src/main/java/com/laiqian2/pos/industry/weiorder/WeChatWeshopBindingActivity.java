package com.laiqian.pos.industry.weiorder;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.pos.dw;
import com.laiqian.pos.industry.weiorder.auth.a;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.util.e;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.ab;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.s;
import com.laiqian.util.am;
import com.laiqian.util.by;
import com.laiqian.util.n;
import hugo.weaving.DebugLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class WeChatWeshopBindingActivity extends ActivityRoot implements dh, g {
  int aXa = 0;
  
  w cjN = null;
  
  df ctZ;
  
  a cua;
  
  boolean cub = true;
  
  boolean cuc = true;
  
  View.OnClickListener cud = new ca(this);
  
  a cue = null;
  
  aa titleBar;
  
  private void abC() {
    ActivityRoot activityRoot = getActivity();
    String str1 = getString(2131630488);
    String str2 = getString(2131630487);
    ci ci = new ci(this);
    (new w(activityRoot, new String[] { str1, str2 }, ci)).show();
  }
  
  private void abD() {
    if (Build.VERSION.SDK_INT >= 19)
      try {
        Intent intent1 = new Intent("android.intent.action.GET_CONTENT");
        intent1.addCategory("android.intent.category.OPENABLE");
        intent1.setType("image/*");
        startActivityForResult(intent1, 2);
        return;
      } catch (Exception exception) {
        return;
      }  
    Intent intent = new Intent("android.intent.action.PICK");
    intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
    startActivityForResult(intent, 2);
  }
  
  private void abs() {
    ActivityRoot activityRoot = getActivity();
    String str1 = getString(2131627875);
    String str2 = getString(2131627874);
    cb cb = new cb(this);
    this.cjN = new w(activityRoot, new String[] { str1, str2 }, cb, false);
    this.cjN.show();
  }
  
  private void abt() {
    View view1 = View.inflate(getActivity(), 2131427863, null);
    TextView textView1 = (TextView)view1.findViewById(2131296334);
    TextView textView2 = (TextView)view1.findViewById(2131296893);
    null = getResources();
    if (getResources().getBoolean(2131034123)) {
      i = 2130903069;
    } else {
      i = 2130903070;
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
    textView2.setOnClickListener(new ce(this, new w(getActivity(), arrayOfString1, new cc(this, textView2, arrayOfString1))));
    PopupWindow popupWindow = new PopupWindow(view1, -2, -2, true);
    popupWindow.setBackgroundDrawable(new ColorDrawable());
    popupWindow.setOutsideTouchable(true);
    TextView textView3 = (TextView)view1.findViewById(2131299317);
    view1.findViewById(2131298939).setOnClickListener(new cf(this, textView1, textView3, textView2));
    view1.findViewById(2131296671).setOnClickListener(new cg(this, popupWindow));
    Rect rect = new Rect();
    View view2 = this.cjN.ark();
    view2.getGlobalVisibleRect(rect);
    int i = rect.right;
    int j = rect.top;
    textView3.setText(null);
    popupWindow.showAtLocation(view2, 0, i, j);
  }
  
  private boolean abu() {
    null = n.a(getActivity(), true);
    if (null.size() == 0)
      return false; 
    String str = (String)null.get(0);
    bitmap = this.ctZ.abK();
    if (bitmap == null)
      return false; 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(File.separator);
      stringBuilder.append(getString(2131626759));
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
  
  private void abv() {
    ActivityRoot activityRoot = getActivity();
    String str1 = getString(2131628612);
    String str2 = getString(2131628611);
    ch ch = new ch(this);
    (new w(activityRoot, new String[] { str1, str2 }, ch)).show();
  }
  
  private void fk(boolean paramBoolean) {
    this.ctZ.fn(paramBoolean);
    if (paramBoolean) {
      this.cua.cuw.setVisibility(0);
      this.cua.cuz.setVisibility(0);
      this.cua.cuA.setVisibility(8);
      return;
    } 
    this.cua.cuw.setVisibility(8);
    this.cua.cuz.setVisibility(8);
    this.cua.cuA.setVisibility(8);
  }
  
  private void jM(String paramString) {
    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
    intent.putExtra("output", Uri.fromFile(new File(paramString)));
    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
      startActivityForResult(intent, 1);
      return;
    } 
    Toast.makeText(getActivity(), "没有找到拍照app", 0).show();
  }
  
  private void jN(String paramString) {
    Intent intent = new Intent();
    intent.setClass(getActivity(), com.laiqian.ui.cropper.CropImageActivity.class);
    intent.putExtra("PHOTO_CROP_SAVEPATH", paramString);
    startActivityForResult(intent, 13);
  }
  
  private void setListeners() {
    this.titleBar.bri.setOnClickListener(new bs(this));
    this.titleBar.brk.setOnClickListener(new cd(this));
    this.cua.cuh.setOnClickListener(new cj(this));
    this.cua.cum.setOnCheckedChangeListener(new ck(this));
    this.cua.cuB.setOnCheckedChangeListener(new cl(this));
    this.cua.cuC.setOnCheckedChangeListener(new cn(this));
    this.cua.cuD.setOnCheckedChangeListener(new co(this));
    this.cua.cuE.setOnCheckedChangeListener(new cp(this));
    this.cua.cul.setOnClickListener(new cq(this));
    this.cua.cut.setOnClickListener(new bt(this));
    this.cua.cuu.setOnClickListener(new bu(this));
    this.cua.bac.setOnClickListener(new bv(this));
    this.cua.cun.setOnClickListener(new bw(this));
    this.cua.cuy.setOnClickListener(new bx(this));
    this.cua.cup.setOnClickListener(new by(this));
    this.cua.aQL.setOnClickListener(new bz(this));
    if (!"0".equals(CrashApplication.getLaiqianPreferenceManager().avt())) {
      this.cua.cuq.setVisibility(8);
      this.cua.cuh.setOnClickListener(this.cud);
      this.cua.cuu.setOnClickListener(this.cud);
    } 
    if (CrashApplication.getLaiqianPreferenceManager().QV() == 1) {
      this.cua.cuh.setOnClickListener(this.cud);
      this.cua.cuu.setOnClickListener(this.cud);
      this.cua.cuA.setOnClickListener(this.cud);
      this.cua.aQL.setOnClickListener(this.cud);
      this.cua.cux.setOnClickListener(this.cud);
      this.cua.cuz.setOnClickListener(this.cud);
      this.cua.cux.setVisibility(8);
      this.cua.cuB.setEnabled(false);
      this.cua.cut.setOnClickListener(this.cud);
    } 
  }
  
  private void setupViews() {
    if (!n.bL(getActivity()) || a.zR().Ad() || a.zR().Ab()) {
      this.cua.cuh.setVisibility(8);
    } else {
      this.cua.cuh.setVisibility(0);
    } 
    this.cua.cup.setText(getString(2131626772));
    if (getLaiqianPreferenceManager().QV() == 0)
      this.cua.cuA.setVisibility(8); 
    this.titleBar.tvTitle.setText(getString(2131630528));
    this.titleBar.brj.setVisibility(8);
    this.titleBar.brk.setText(getString(2131629495));
    this.titleBar.brk.setVisibility(0);
  }
  
  public boolean Az() { return (this.ctZ != null) ? this.ctZ.Az() : 0; }
  
  public void Em() { ab.N(getActivity()); }
  
  public void RA() {
    if (this.titleBar != null) {
      this.titleBar.brk.setVisibility(0);
      this.titleBar.aNv.setVisibility(8);
    } 
  }
  
  public void Rz() {
    if (this.titleBar != null) {
      this.titleBar.brk.setVisibility(8);
      this.titleBar.aNv.setVisibility(0);
    } 
  }
  
  public void Sl() {
    this.cua.bxr.setVisibility(8);
    this.cua.aQL.setVisibility(0);
  }
  
  public void a(a parama) {
    this.cue = parama;
    this.cuc = false;
    this.cua.bxr.setVisibility(0);
    if (TextUtils.isEmpty(parama.cxT) || TextUtils.isEmpty(parama.cxT)) {
      this.cua.cuq.setVisibility(0);
      this.cua.cuu.setVisibility(8);
      this.cua.cuv.setVisibility(8);
      this.cua.cux.setVisibility(8);
      this.cua.cuw.setVisibility(8);
      this.cua.cuz.setVisibility(8);
      this.cua.cuA.setVisibility(8);
    } else {
      if (CrashApplication.getLaiqianPreferenceManager().QV() != 1)
        this.cua.cux.setVisibility(0); 
      this.cua.cuq.setVisibility(8);
      this.cua.cuu.setVisibility(0);
      this.cua.cuv.setVisibility(0);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(parama.cxT);
      stringBuilder1.append('|');
      stringBuilder1.append(parama.accountType);
      String str = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append('|');
      stringBuilder2.append(parama.accountType);
      SpannableString spannableString = by.b(str, stringBuilder2.toString(), 20, getResources().getColor(2131099937));
      this.cua.aFx.setText(spannableString);
      this.cua.cuB.setChecked(parama.cxY.booleanValue());
      if (parama.cxY.booleanValue()) {
        this.cua.cuw.setVisibility(0);
        this.cua.cuz.setVisibility(0);
        this.cua.cuA.setVisibility(8);
      } else {
        this.cua.cuw.setVisibility(8);
        this.cua.cuz.setVisibility(8);
        this.cua.cuA.setVisibility(8);
      } 
      this.cua.cuC.setChecked(parama.cxV.booleanValue());
      this.cua.cuD.setChecked(parama.cxW.booleanValue());
      this.cua.cuE.setChecked(parama.cxX.booleanValue());
    } 
    this.cuc = true;
  }
  
  public void a(PrintContent paramPrintContent, int paramInt) {}
  
  public void a(aa paramaa) {
    this.titleBar = paramaa;
    this.ctZ.save();
  }
  
  public void abA() {}
  
  public void abB() {}
  
  public void abw() {
    if (getActivity() != null) {
      this.cua.cuo.setText(getString(2131628614));
      this.cua.cun.setClickable(false);
    } 
  }
  
  public void abx() {
    if (getActivity() != null) {
      this.cua.cuo.setText(getString(2131630568));
      this.cua.cun.setClickable(true);
    } 
  }
  
  public void aby() {
    if (getActivity() != null) {
      this.cua.aZa.setImageResource(2131231999);
      Toast.makeText(getActivity(), getString(2131630569), 0).show();
    } 
  }
  
  public void abz() { abC(); }
  
  public void eH(int paramInt) {
    this.aXa = paramInt;
    switch (this.aXa) {
      default:
        return;
      case 2:
        this.cua.cuj.setText(getString(2131628611));
        if (n.bL(getActivity())) {
          this.cua.cus.setVisibility(0);
        } else {
          this.cua.cus.setVisibility(8);
        } 
        if (this.cub) {
          fl(true);
          return;
        } 
        fl(false);
        return;
      case 1:
        break;
    } 
    this.cua.cuj.setText(getString(2131628612));
    this.cua.cuv.setVisibility(0);
    this.cua.cus.setVisibility(8);
    this.cua.cuu.setVisibility(8);
    this.cua.cuq.setVisibility(8);
    fl(true);
    this.cua.cuo.setVisibility(8);
  }
  
  public void fl(boolean paramBoolean) {
    if (paramBoolean) {
      switch (this.aXa) {
        default:
          return;
        case 2:
          this.cua.cun.setVisibility(0);
          this.cua.cuo.setVisibility(8);
          this.cua.cup.setVisibility(0);
          return;
        case 1:
          break;
      } 
      this.cua.cun.setVisibility(0);
      this.cua.cuo.setVisibility(8);
      this.cua.cup.setVisibility(0);
      return;
    } 
    this.cua.cun.setVisibility(8);
    this.cua.cuo.setVisibility(8);
    this.cua.cup.setVisibility(8);
  }
  
  public void fm(boolean paramBoolean) {
    this.cub = paramBoolean;
    this.cua.cum.setChecked(paramBoolean);
    if (!paramBoolean && this.aXa == 2) {
      fl(false);
      return;
    } 
    fl(true);
  }
  
  public void hf(int paramInt) {
    this.cua.cun.setClickable(true);
    switch (paramInt) {
      default:
        return;
      case 2:
        this.cua.cuo.setText(getString(2131630568));
        return;
      case 1:
        break;
    } 
    this.cua.cuo.setText(getString(2131630568));
  }
  
  public void hideProgress() { ab.P(getActivity()); }
  
  public void jL(String paramString) {
    if (getActivity() != null)
      Toast.makeText(getActivity(), paramString, 0).show(); 
  }
  
  @DebugLog
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1 && (paramIntent == null || paramInt2 == 0))
      return; 
    if (paramInt1 != 13) {
      switch (paramInt1) {
        default:
          return;
        case 2:
          try {
            if (am.a(getActivity().getContentResolver(), paramIntent.getData(), dw.aT(getActivity()))) {
              jN(dw.aT(getActivity()));
              return;
            } 
          } catch (FileNotFoundException paramIntent) {
            a.e(paramIntent);
            return;
          } 
          return;
        case 1:
          break;
      } 
      jN(dw.aT(getActivity()));
      return;
    } 
    if (paramIntent != null && paramIntent.getBooleanExtra("PHOTO_CROP_RESULT", false))
      this.ctZ.jQ(dw.aT(getActivity())); 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.cua = a.z(this);
    this.titleBar = aa.M(this);
    this.ctZ = new df(getApplication(), this);
    this.ctZ.init();
    setupViews();
    setListeners();
  }
  
  public void onResume() {
    super.onResume();
    if (this.ctZ.Jr() == 2 && n.bL(getActivity()) && (a.zR().Ae() || a.zR().Au() || a.zR().zX()))
      this.ctZ.abI(); 
  }
  
  public void q(Drawable paramDrawable) { this.cua.aZa.setImageDrawable(paramDrawable); }
  
  public void save() { this.ctZ.save(); }
  
  public void setUrl(String paramString) {}
  
  public void zO() {
    this.cua.bxr.setVisibility(0);
    this.cua.aQL.setVisibility(8);
  }
  
  public boolean zP() { return true; }
  
  private static class a {
    public TextView aFx;
    
    public View aQG;
    
    public ViewGroup aQL;
    
    public ImageView aZa;
    
    public TextView bac;
    
    public ScrollView bxr;
    
    public ViewGroup cuA;
    
    public CheckBox cuB;
    
    public CheckBox cuC;
    
    public CheckBox cuD;
    
    public CheckBox cuE;
    
    public ViewGroup cuh;
    
    public TextView cui;
    
    public TextView cuj;
    
    public TextView cuk;
    
    public ViewGroup cul;
    
    public CheckBox cum;
    
    public ViewGroup cun;
    
    public TextView cuo;
    
    public Button cup;
    
    public ViewGroup cuq;
    
    public TextView cur;
    
    public ViewGroup cus;
    
    public Button cut;
    
    public ViewGroup cuu;
    
    public ViewGroup cuv;
    
    public ViewGroup cuw;
    
    public ViewGroup cux;
    
    public ViewGroup cuy;
    
    public ViewGroup cuz;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.aQL = (ViewGroup)s.z(param1View, 2131297982);
      this.bxr = (ScrollView)s.z(param1View, 2131298899);
      this.cuh = (ViewGroup)s.z(param1View, 2131297724);
      this.cui = (TextView)s.z(param1View, 2131299819);
      this.cuj = (TextView)s.z(param1View, 2131299818);
      this.cuk = (TextView)s.z(param1View, 2131299475);
      this.cul = (ViewGroup)s.z(param1View, 2131297511);
      this.cum = (CheckBox)s.z(param1View, 2131296704);
      this.cuv = (ViewGroup)s.z(param1View, 2131297649);
      this.cun = (ViewGroup)s.z(param1View, 2131297650);
      this.aZa = (ImageView)s.z(param1View, 2131297399);
      this.cuo = (TextView)s.z(param1View, 2131299665);
      this.cup = (Button)s.z(param1View, 2131296624);
      this.cuq = (ViewGroup)s.z(param1View, 2131297519);
      this.cur = (TextView)s.z(param1View, 2131299487);
      this.cus = (ViewGroup)s.z(param1View, 2131297518);
      this.cut = (Button)s.z(param1View, 2131296612);
      this.bac = (TextView)s.z(param1View, 2131299672);
      this.aFx = (TextView)s.z(param1View, 2131299460);
      this.cuu = (ViewGroup)s.z(param1View, 2131297723);
      this.cuy = (ViewGroup)s.z(param1View, 2131297729);
      this.cuB = (CheckBox)s.z(param1View, 2131296708);
      this.cuw = (ViewGroup)s.z(param1View, 2131298012);
      this.cuz = (ViewGroup)s.z(param1View, 2131298049);
      this.cuA = (ViewGroup)s.z(param1View, 2131297997);
      this.cux = (ViewGroup)s.z(param1View, 2131297878);
      this.cuC = (CheckBox)s.z(param1View, 2131296716);
      this.cuD = (CheckBox)s.z(param1View, 2131296719);
      this.cuE = (CheckBox)s.z(param1View, 2131296712);
    }
    
    public static a z(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(2131427448, null);
      param1Activity.setContentView(view);
      return new a(view);
    }
  }
  
  private class b extends Thread {
    private String bvY;
    
    private b(WeChatWeshopBindingActivity this$0, String param1String) { this.bvY = param1String; }
    
    public void run() {
      if (this.cuf.getActivity() == null)
        return; 
      String str1 = dw.aR(this.cuf.getActivity());
      boolean bool = true;
      String str2 = this.bvY;
      String str3 = this.cuf.getString(2131626760);
      String str4 = this.cuf.getString(2131626758);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.cuf.getString(2131626759));
      stringBuilder.append(".jpg");
      String str5 = stringBuilder.toString();
      if (n.a(new String[] { str2 }, str3, str4, new String[] { str1 }, new String[] { str5 })) {
        this.cuf.getLaiqianPreferenceManager().rr(this.bvY);
      } else {
        bool = false;
      } 
      e.i(new cr(this, bool));
      if (this.cuf.getActivity() == null)
        return; 
      ab.P(this.cuf.getActivity());
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\WeChatWeshopBindingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */