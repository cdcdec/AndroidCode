package com.laiqian.pos.settings;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.DocumentsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.d.a.b.f.a;
import com.laiqian.entity.av;
import com.laiqian.models.h;
import com.laiqian.pos.industry.weiorder.fp;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.util.ae;
import com.laiqian.util.am;
import com.laiqian.util.aq;
import com.laiqian.util.az;
import com.laiqian.util.bb;
import io.reactivex.g.a;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.b.d;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
public final class ShopMoreInfoSettingsFragment extends Fragment implements df {
  public static final a cBT = new a(null);
  
  private r aCz;
  
  private cs cAo;
  
  private HashMap cAq;
  
  private c cBQ;
  
  private b cBR;
  
  private Map<String, File> cBS = (Map)new HashMap();
  
  private final int cgS = 11;
  
  private final int cgT = 12;
  
  private boolean chY;
  
  private String chZ = "";
  
  private boolean chl;
  
  private w<?> chs;
  
  private String chv = "";
  
  @NotNull
  private Handler chw;
  
  private String cwb = "0";
  
  private a cwc;
  
  public ShopMoreInfoSettingsFragment() {
    if (Build.VERSION.SDK_INT >= 19) {
      bool = true;
    } else {
      bool = false;
    } 
    this.chl = bool;
    this.chw = (Handler)new dk(this);
  }
  
  private final void ZU() {
    Intent intent = new Intent();
    intent.setClass((Context)getActivity(), com.laiqian.ui.cropper.CropImageActivity.class);
    Object object = this.cBS.get(this.cwb);
    if (object == null)
      f.aQI(); 
    intent.putExtra("PHOTO_CROP_SAVEPATH", ((File)object).getAbsolutePath());
    intent.putExtra("ASPECT_RATIO_X", 12);
    intent.putExtra("ASPECT_RATIO_Y", 5);
    startActivityForResult(intent, 13);
  }
  
  private final boolean c(Uri paramUri) {
    String str1;
    String str2 = (String)null;
    if (this.chl && DocumentsContract.isDocumentUri((Context)getActivity(), paramUri)) {
      str1 = am.b((Context)getActivity(), paramUri);
    } else {
      str1 = am.c((Context)getActivity(), str1);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("filename_uri->");
    if (str1 == null)
      f.aQI(); 
    stringBuilder.append(str1);
    bb.e("filename", stringBuilder.toString());
    if ((new File(str1)).exists()) {
      Object object = this.cBS.get(this.cwb);
      if (object == null)
        f.aQI(); 
      return am.B(str1, ((File)object).getAbsolutePath());
    } 
    return false;
  }
  
  private final void n(Intent paramIntent) {
    az.info("setPicToView");
    if (paramIntent.getAction() != null || paramIntent.getExtras() != null) {
      if (!paramIntent.getBooleanExtra("PHOTO_CROP_RESULT", false)) {
        Toast.makeText((Context)getActivity(), (CharSequence)getString(2131626616), 0).show();
        return;
      } 
      b b1 = this.cBR;
      if (b1 == null)
        f.ut("container"); 
      b1.aea().setVisibility(0);
      b1 = this.cBR;
      if (b1 == null)
        f.ut("container"); 
      b1.adZ().setVisibility(8);
      b1 = this.cBR;
      if (b1 == null)
        f.ut("container"); 
      b1.aeb().setVisibility(8);
      a.aKh().r((Runnable)new di(this));
    } 
  }
  
  private final void s(String paramString, boolean paramBoolean) {
    b b1;
    c c1 = this.cBQ;
    if (c1 == null)
      f.ut("uploadCoverFigureLayLsn"); 
    c1.fr(paramBoolean);
    c1 = this.cBQ;
    if (c1 == null)
      f.ut("uploadCoverFigureLayLsn"); 
    c1.jU(paramString);
    fp fp = fp.aX((Context)getActivity());
    f.l(fp, "manager");
    av av = fp.abW();
    f.l(av, "settings");
    av.dO(paramString);
    fp.b(av);
    if (paramString == null || f.r("", paramString)) {
      b1 = this.cBR;
      if (b1 == null)
        f.ut("container"); 
      b1.aea().setVisibility(8);
      b1 = this.cBR;
      if (b1 == null)
        f.ut("container"); 
      b1.adZ().setVisibility(8);
      b1 = this.cBR;
      if (b1 == null)
        f.ut("container"); 
      b1.aeb().setVisibility(0);
      return;
    } 
    if (getActivity() != null) {
      b b2 = this.cBR;
      if (b2 == null)
        f.ut("container"); 
      ImageView imageView = b2.adZ();
      a a1 = this.cwc;
      if (a1 == null)
        f.ut("animateFirstListener"); 
      aq.a(b1, imageView, a1, ae.b((Context)getActivity(), 4.0F));
    } 
  }
  
  private final void setListeners() {
    this.cwc = (a)new dh(this);
    this.cBQ = new c(this, this.chY, this.chZ);
    b b1 = this.cBR;
    if (b1 == null)
      f.ut("container"); 
    View view = b1.adY();
    c c1 = this.cBQ;
    if (c1 == null)
      f.ut("uploadCoverFigureLayLsn"); 
    view.setOnClickListener((View.OnClickListener)c1);
  }
  
  public final void abS() {
    dj dj = new dj(this);
    if (this.aCz == null) {
      this.aCz = new r((Context)getActivity(), true, (r.a)dj);
      r r2 = this.aCz;
      if (r2 == null)
        f.aQI(); 
      r2.setTitle(getString(2131625963));
      r2 = this.aCz;
      if (r2 == null)
        f.aQI(); 
      r2.s((CharSequence)getString(2131627033));
      r2 = this.aCz;
      if (r2 == null)
        f.aQI(); 
      r2.t((CharSequence)getString(2131625538));
      r2 = this.aCz;
      if (r2 == null)
        f.aQI(); 
      r2.oZ(getString(2131628275));
    } 
    r r1 = this.aCz;
    if (r1 == null)
      f.aQI(); 
    r1.show();
  }
  
  @NotNull
  public final Handler adW() { return this.chw; }
  
  public void ado() {
    if (this.cAq != null)
      this.cAq.clear(); 
  }
  
  public void b(@Nullable h.c paramc) {}
  
  public void d(@Nullable h.a parama) {}
  
  public void d(@Nullable h.e parame) {}
  
  public void dK(@Nullable String paramString) {}
  
  public void hr(int paramInt) {}
  
  public void jR(@Nullable String paramString) {}
  
  public void jT(@NotNull String paramString) {
    boolean bool;
    f.m(paramString, "coverFigureUrl");
    this.chZ = paramString;
    if (this.chZ != null && !f.r("", this.chZ)) {
      bool = true;
    } else {
      bool = false;
    } 
    this.chY = bool;
    s(this.chZ, this.chY);
  }
  
  public void kH(@Nullable String paramString) {}
  
  public void kI(@Nullable String paramString) {}
  
  public void kJ(@Nullable String paramString) {}
  
  public void kK(@Nullable String paramString) {}
  
  public void kL(@Nullable String paramString) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1 && (paramIntent == null || paramInt2 == 0))
      return; 
    if (paramInt1 == this.cgS) {
      if (paramIntent == null)
        f.aQI(); 
      if (c(paramIntent.getData())) {
        ZU();
        return;
      } 
    } else {
      if (paramInt1 == this.cgT) {
        ZU();
        return;
      } 
      if (paramInt1 == 13) {
        if (paramIntent == null)
          f.aQI(); 
        n(paramIntent);
      } 
    } 
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    f.m(paramLayoutInflater, "inflater");
    return paramLayoutInflater.inflate(2131427609, paramViewGroup, false);
  }
  
  public void onViewCreated(@Nullable View paramView, @Nullable Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    if (paramView == null)
      f.aQI(); 
    this.cBR = new b(paramView);
    setListeners();
    this.cAo = new cs((Context)getActivity());
    cs cs1 = this.cAo;
    if (cs1 == null)
      f.ut("presenter"); 
    cs1.b((df)this);
  }
  
  public final void save() {
    Toast.makeText((Context)getActivity(), 2131629499, 0).show();
    getActivity().finish();
  }
  
  @Metadata
  public static final class a {
    private a() {}
    
    @JvmStatic
    @NotNull
    public final ShopMoreInfoSettingsFragment adX() { return new ShopMoreInfoSettingsFragment(); }
  }
  
  @Metadata
  public static final class b {
    @NotNull
    private View cBU;
    
    @NotNull
    private ImageView cwk;
    
    @NotNull
    private ProgressBarCircularIndeterminate cwl;
    
    @NotNull
    private ImageView cwm;
    
    public b(@NotNull View param1View) {
      View view = param1View.findViewById(2131297539);
      f.l(view, "view.findViewById(R.id.layout_cover_figure)");
      this.cBU = view;
      view = param1View.findViewById(2131297367);
      f.l(view, "view.findViewById(R.id.iv_cover_figure)");
      this.cwk = (ImageView)view;
      view = param1View.findViewById(2131297382);
      f.l(view, "view.findViewById(R.id.iv_loading)");
      this.cwl = (ProgressBarCircularIndeterminate)view;
      param1View = param1View.findViewById(2131297360);
      f.l(param1View, "view.findViewById(R.id.iv_add_icon)");
      this.cwm = (ImageView)param1View;
    }
    
    @NotNull
    public final View adY() { return this.cBU; }
    
    @NotNull
    public final ImageView adZ() { return this.cwk; }
    
    @NotNull
    public final ProgressBarCircularIndeterminate aea() { return this.cwl; }
    
    @NotNull
    public final ImageView aeb() { return this.cwm; }
  }
  
  @Metadata
  public final class c implements View.OnClickListener {
    private boolean chY;
    
    @NotNull
    private String chZ;
    
    public c(ShopMoreInfoSettingsFragment this$0, boolean param1Boolean, @NotNull String param1String) {
      this.chY = param1Boolean;
      this.chZ = param1String;
    }
    
    @NotNull
    public final String aec() { return this.chZ; }
    
    public final void fr(boolean param1Boolean) { this.chY = param1Boolean; }
    
    public final void jU(@NotNull String param1String) {
      f.m(param1String, "sImgUrl");
      this.chZ = param1String;
    }
    
    public void onClick(@NotNull View param1View) {
      f.m(param1View, "v");
      if (ShopMoreInfoSettingsFragment.a(this.cBV) == null) {
        ShopMoreInfoSettingsFragment.a(this.cBV, new w((Context)this.cBV.getActivity()));
        w w1 = ShopMoreInfoSettingsFragment.a(this.cBV);
        if (w1 == null)
          f.aQI(); 
        w1.setTitle(this.cBV.getString(2131630489));
      } 
      if (this.chY) {
        w w1 = ShopMoreInfoSettingsFragment.a(this.cBV);
        if (w1 == null)
          f.aQI(); 
        w1.C(new String[] { this.cBV.getString(2131630488), this.cBV.getString(2131630487), this.cBV.getString(2131630486), this.cBV.getString(2131630483) });
      } else {
        w w1 = ShopMoreInfoSettingsFragment.a(this.cBV);
        if (w1 == null)
          f.aQI(); 
        w1.C(new String[] { this.cBV.getString(2131630488), this.cBV.getString(2131630487) });
      } 
      w w = ShopMoreInfoSettingsFragment.a(this.cBV);
      if (w == null)
        f.aQI(); 
      w.a((w.a)new dg(this));
      w = ShopMoreInfoSettingsFragment.a(this.cBV);
      if (w == null)
        f.aQI(); 
      w.show();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\ShopMoreInfoSettingsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */