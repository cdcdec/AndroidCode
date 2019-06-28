package com.laiqian.pos.industry.weiorder;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.DocumentsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.a.a.b;
import com.d.a.b.f.a;
import com.google.a.a.a.a.a.a;
import com.laiqian.entity.av;
import com.laiqian.pos.settings.be;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.h;
import com.laiqian.ui.container.l;
import com.laiqian.ui.s;
import com.laiqian.util.ae;
import com.laiqian.util.am;
import com.laiqian.util.aq;
import com.laiqian.util.az;
import com.laiqian.util.bb;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import io.reactivex.g.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class WeshopInfoFragment extends FragmentRoot implements fl, g {
  String Ze;
  
  r aCz;
  
  private final int cgS = 11;
  
  private final int cgT = 12;
  
  boolean chY;
  
  String chZ;
  
  private HashMap<String, File> chk;
  
  boolean chl;
  
  w chs;
  
  String chv = "";
  
  Handler chw;
  
  fj cvS;
  
  a cvZ;
  
  private TimePickerDialog cwa = null;
  
  String cwb = "0";
  
  a cwc;
  
  b cwd;
  
  aa titleBar;
  
  public WeshopInfoFragment() {
    if (Build.VERSION.SDK_INT >= 19) {
      bool = true;
    } else {
      bool = false;
    } 
    this.chl = bool;
    this.Ze = "hh:mm";
    this.chw = new fg(this);
  }
  
  private void ZU() {
    Intent intent = new Intent();
    intent.setClass(getActivity(), com.laiqian.ui.cropper.CropImageActivity.class);
    intent.putExtra("PHOTO_CROP_SAVEPATH", ((File)this.chk.get(this.cwb)).getAbsolutePath());
    intent.putExtra("ASPECT_RATIO_X", 12);
    intent.putExtra("ASPECT_RATIO_Y", 5);
    startActivityForResult(intent, 13);
  }
  
  private boolean c(Uri paramUri) {
    String str;
    if (this.chl && DocumentsContract.isDocumentUri(getActivity(), paramUri)) {
      str = am.b(getActivity(), paramUri);
    } else {
      str = am.c(getActivity(), paramUri);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("filename_uri->");
    stringBuilder.append(str);
    bb.e("filename", stringBuilder.toString());
    if (str != null && (new File(str)).exists())
      return am.B(str, ((File)this.chk.get(this.cwb)).getAbsolutePath()); 
    if (str == null)
      try {
        return am.a(getActivity().getContentResolver().openInputStream(paramUri), ((File)this.chk.get(this.cwb)).getAbsolutePath());
      } catch (FileNotFoundException paramUri) {
        a.e(paramUri);
      }  
    return false;
  }
  
  private void n(Intent paramIntent) {
    az.info("setPicToView");
    if (paramIntent.getAction() != null || paramIntent.getExtras() != null) {
      if (!paramIntent.getBooleanExtra("PHOTO_CROP_RESULT", false)) {
        Toast.makeText(getActivity(), getString(2131626616), 0).show();
        return;
      } 
      this.cvZ.cwl.setVisibility(0);
      this.cvZ.cwk.setVisibility(8);
      this.cvZ.cwm.setVisibility(8);
      a.aKh().r(new ey(this));
    } 
  }
  
  private void s(String paramString, boolean paramBoolean) {
    this.cwd.fr(paramBoolean);
    this.cwd.jU(paramString);
    fp fp = fp.aX(getActivity());
    av av = fp.abW();
    av.dO(paramString);
    fp.b(av);
    if (paramString == null || "".equals(paramString)) {
      this.cvZ.cwl.setVisibility(8);
      this.cvZ.cwk.setVisibility(8);
      this.cvZ.cwm.setVisibility(0);
      return;
    } 
    if (getActivity() != null)
      aq.a(paramString, this.cvZ.cwk, this.cwc, ae.b(getActivity(), 4.0F)); 
  }
  
  private void setListeners() {
    this.cvZ.aQL.setOnClickListener(new ez(this));
    ((CheckBox)this.cvZ.cwh.dwV.getView()).setOnCheckedChangeListener(new fa(this));
    ((EditText)this.cvZ.cvV.dwQ.getView()).addTextChangedListener(new fb(this));
    ((EditText)this.cvZ.cvX.dwQ.getView()).addTextChangedListener(new fc(this));
    if (!getActivity().getResources().getBoolean(2131034123))
      ((EditText)this.cvZ.cwg.dwQ.getView()).addTextChangedListener(new fd(this)); 
    ((EditText)this.cvZ.cvW.dwQ.getView()).addTextChangedListener(new fe(this));
    this.cwd = new b(this, this.chY, this.chZ);
    this.cvZ.cwj.setOnClickListener(this.cwd);
    this.cwc = new ff(this);
  }
  
  private void setupViews() {
    ((TextView)this.cvZ.cvV.cAO.getView()).setText(getString(2131628245));
    ((TextView)this.cvZ.cvX.cAO.getView()).setText(getString(2131628239));
    if (!getActivity().getResources().getBoolean(2131034123)) {
      ((ViewGroup)this.cvZ.cwg.getView()).setVisibility(0);
      ((TextView)this.cvZ.cwg.cAO.getView()).setText(getString(2131628246));
      ((ViewGroup)this.cvZ.cwg.getView()).setBackgroundResource(2130772035);
    } else {
      ((ViewGroup)this.cvZ.cwg.getView()).setVisibility(8);
    } 
    ((TextView)this.cvZ.cvW.cAO.getView()).setText(getString(2131628240));
    ((TextView)this.cvZ.cwh.cAO.getView()).setText(getString(2131628254));
    ((ViewGroup)this.cvZ.cvV.getView()).setBackgroundResource(2130772057);
    ((ViewGroup)this.cvZ.cvW.getView()).setBackgroundResource(2130772055);
    ((ViewGroup)this.cvZ.cvX.getView()).setBackgroundResource(2130772051);
    ((ViewGroup)this.cvZ.cwh.getView()).setBackgroundResource(2130772057);
    ((ViewGroup)this.cvZ.cwi.getView()).setBackgroundResource(2130772051);
  }
  
  public boolean Az() { return (this.cvS != null) ? this.cvS.Az() : 0; }
  
  public void Em() {
    this.cvZ.aNv.setVisibility(0);
    this.cvZ.aQL.setVisibility(8);
    this.cvZ.bxr.setVisibility(8);
  }
  
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
    this.cvZ.aQL.setVisibility(0);
    this.cvZ.bxr.setVisibility(8);
    this.cvZ.aNv.setVisibility(8);
  }
  
  public void a(aa paramaa) {
    this.titleBar = paramaa;
    if (!bd.bH(getActivity())) {
      Toast.makeText(getActivity(), getString(2131626280), 0).show();
      return;
    } 
    if (!this.cvS.jV(((EditText)this.cvZ.cvV.dwQ.getView()).getText().toString())) {
      Toast.makeText(getActivity(), 2131629656, 0).show();
      return;
    } 
    if (!this.cvS.jW(((EditText)this.cvZ.cvX.dwQ.getView()).getText().toString())) {
      Toast.makeText(getActivity(), 2131629647, 0).show();
      return;
    } 
    if (!getActivity().getResources().getBoolean(2131034123) && !this.cvS.jX(((EditText)this.cvZ.cwg.dwQ.getView()).getText().toString())) {
      Toast.makeText(getActivity(), 2131629648, 0).show();
      return;
    } 
    if (!this.cvS.ka(((EditText)this.cvZ.cvW.dwQ.getView()).getText().toString())) {
      Toast.makeText(getActivity(), 2131629646, 0).show();
      return;
    } 
    this.cvS.jY(this.cvZ.cwi.Cc());
    if (!this.cvS.abU())
      return; 
    this.cvS.save();
  }
  
  public void abS() {
    fh fh = new fh(this);
    if (this.aCz == null) {
      this.aCz = new r(getActivity(), true, fh);
      this.aCz.setTitle(getString(2131625963));
      this.aCz.s(getString(2131627033));
      this.aCz.t(getString(2131625538));
      this.aCz.oZ(getString(2131628275));
    } 
    this.aCz.show();
  }
  
  public void cZ(boolean paramBoolean) { ((CheckBox)this.cvZ.cwh.dwV.getView()).setChecked(paramBoolean); }
  
  public void cc(String paramString) { this.cvZ.cwi.cc(paramString); }
  
  public void dK(String paramString) { ((EditText)this.cvZ.cvV.dwQ.getView()).setText(paramString); }
  
  public void dN(String paramString) { ((EditText)this.cvZ.cwg.dwQ.getView()).setText(paramString); }
  
  public void hideProgress() {
    this.cvZ.aNv.setVisibility(8);
    this.cvZ.aQL.setVisibility(8);
    this.cvZ.bxr.setVisibility(0);
  }
  
  public void jR(String paramString) { ((EditText)this.cvZ.cvX.dwQ.getView()).setText(paramString); }
  
  public void jS(String paramString) { ((EditText)this.cvZ.cvW.dwQ.getView()).setText(paramString); }
  
  public void jT(String paramString) {
    this.chZ = paramString;
    if (this.chZ == null || "".equals(this.chZ)) {
      this.chY = false;
    } else {
      this.chY = true;
    } 
    s(this.chZ, this.chY);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1 && (paramIntent == null || paramInt2 == 0))
      return; 
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
    if (c(paramIntent.getData()))
      ZU(); 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.cvS = new fj(getActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.cvZ = a.o(this);
    setupViews();
    setListeners();
    this.cvS.b(this);
    return this.cvZ.getView();
  }
  
  public void save() {
    if (!bd.bH(getActivity())) {
      Toast.makeText(getActivity(), getString(2131626280), 0).show();
      return;
    } 
    if (!this.cvS.jV(((EditText)this.cvZ.cvV.dwQ.getView()).getText().toString())) {
      Toast.makeText(getActivity(), 2131629656, 0).show();
      return;
    } 
    if (!this.cvS.jW(((EditText)this.cvZ.cvX.dwQ.getView()).getText().toString())) {
      Toast.makeText(getActivity(), 2131629647, 0).show();
      return;
    } 
    if (!getActivity().getResources().getBoolean(2131034123) && !this.cvS.jW(((EditText)this.cvZ.cwg.dwQ.getView()).getText().toString())) {
      Toast.makeText(getActivity(), 2131629648, 0).show();
      return;
    } 
    if (!this.cvS.ka(((EditText)this.cvZ.cvW.dwQ.getView()).getText().toString())) {
      Toast.makeText(getActivity(), 2131629646, 0).show();
      return;
    } 
    this.cvS.jY(this.cvZ.cwi.Cc());
    if (!this.cvS.abU())
      return; 
    this.cvS.save();
  }
  
  public void showError(String paramString) { n.o(paramString); }
  
  public void zO() {
    this.cvZ.bxr.setVisibility(0);
    this.cvZ.aQL.setVisibility(8);
    this.cvZ.aNv.setVisibility(8);
  }
  
  public boolean zP() { return isAdded(); }
  
  public static class a extends ab<ViewGroup> {
    public ProgressBarCircularIndeterminate aNv;
    
    public ViewGroup aQL;
    
    public ViewGroup bDV;
    
    public ScrollView bxr;
    
    public h cvV = new h(2131297677);
    
    public h cvW = new h(2131297534);
    
    public h cvX = new h(2131297500);
    
    public h cwg = new h(2131297674);
    
    public l cwh = new l(2131297614);
    
    public be cwi = new be(2131297701);
    
    public ViewGroup cwj;
    
    public ImageView cwk;
    
    public ProgressBarCircularIndeterminate cwl;
    
    public ImageView cwm;
    
    public a(int param1Int, View param1View) {
      super(param1Int);
      this.aQL = (ViewGroup)s.z(param1View, 2131297982);
      this.bxr = (ScrollView)s.z(param1View, 2131298899);
      this.cwj = (ViewGroup)s.z(param1View, 2131297539);
      this.aNv = (ProgressBarCircularIndeterminate)s.z(param1View, 2131297346);
      this.cwk = (ImageView)s.z(param1View, 2131297367);
      this.cwl = (ProgressBarCircularIndeterminate)s.z(param1View, 2131297382);
      this.cwm = (ImageView)s.z(param1View, 2131297360);
      this.bDV = (ViewGroup)s.z(param1View, 2131297905);
    }
    
    public static a o(Fragment param1Fragment) {
      View view = LayoutInflater.from(param1Fragment.getActivity()).inflate(2131427625, null);
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
  
  class b implements View.OnClickListener {
    boolean chY;
    
    String chZ;
    
    public b(WeshopInfoFragment this$0, boolean param1Boolean, String param1String) {
      this.chY = param1Boolean;
      this.chZ = param1String;
    }
    
    public void fr(boolean param1Boolean) { this.chY = param1Boolean; }
    
    public void jU(String param1String) { this.chZ = param1String; }
    
    public void onClick(View param1View) {
      if (this.cwf.chs == null) {
        this.cwf.chs = new w(this.cwf.getActivity());
        this.cwf.chs.setTitle(this.cwf.getString(2131630489));
      } 
      if (this.chY) {
        this.cwf.chs.C(new String[] { this.cwf.getString(2131630488), this.cwf.getString(2131630487), this.cwf.getString(2131630486), this.cwf.getString(2131630483) });
      } else {
        this.cwf.chs.C(new String[] { this.cwf.getString(2131630488), this.cwf.getString(2131630487) });
      } 
      this.cwf.chs.a(new fi(this));
      this.cwf.chs.show();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\WeshopInfoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */