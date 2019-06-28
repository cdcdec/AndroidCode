package com.laiqian.scanorder.settings;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.a.a.a.a.a.a;
import com.google.zxing.WriterException;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.n;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.pos.settings.aa;
import com.laiqian.scan_order_module.R;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.a.ab;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.s;
import com.laiqian.util.al;
import com.laiqian.util.n;
import java.util.ArrayList;

public class MenuStyleFragment extends FragmentRoot implements aa {
  private Bitmap cjH;
  
  a diP;
  
  int diQ;
  
  int diR;
  
  long diS;
  
  private long aoR() {
    ArrayList arrayList = new ArrayList();
    for (a a1 : n.Xo()) {
      Log.e("areaEntity", a1.XX());
      for (TableEntity tableEntity : n.jg(String.valueOf(a1.getId()))) {
        tableEntity.jl(a1.XX());
        Log.e("tableEntity", tableEntity.Vz());
        arrayList.add(tableEntity);
      } 
    } 
    return (arrayList.size() > 0) ? ((TableEntity)arrayList.get(0)).getID() : 0L;
  }
  
  private Bitmap gT(int paramInt) {
    Canvas canvas = new Canvas(Bitmap.createBitmap(this.cjH.getWidth(), this.cjH.getHeight(), this.cjH.getConfig()));
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setDither(true);
    canvas.drawBitmap(this.cjH, 0.0F, 0.0F, paint);
    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
    str1 = RootUrlParameter.clq;
    String str2 = RootApplication.getLaiqianPreferenceManager().Tx();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.diS);
    stringBuilder.append("");
    str2 = String.format(str1, new Object[] { str2, stringBuilder.toString(), Integer.valueOf(paramInt) });
    str1 = str2;
    if (a.zR().Ad()) {
      null = new StringBuilder();
      null.append(str2);
      null.append("&en=1");
      str1 = null.toString();
    } 
    try {
      Bitmap bitmap = al.D(str1, 150);
    } catch (WriterException str1) {
      a.e(str1);
      str1 = null;
    } 
    canvas.drawBitmap(str1, 30.0F, 30.0F, paint);
    return str1;
  }
  
  private void kb(int paramInt) {
    this.diQ = paramInt;
    switch (paramInt) {
      default:
        return;
      case 2:
        this.diP.diX.setVisibility(8);
        this.diP.diU.setBackgroundResource(R.drawable.menu_style_waterfall_unselected);
        this.diP.djd.setBackgroundResource(R.drawable.shape_with_white_stroke);
        this.diP.diY.setVisibility(0);
        this.diP.diV.setBackgroundResource(R.drawable.menu_style_hot_selected);
        this.diP.dje.setBackgroundResource(R.drawable.shape_with_red_stroke);
        this.diP.diZ.setVisibility(8);
        this.diP.diW.setBackgroundResource(R.drawable.menu_style_normal_unselected);
        this.diP.djf.setBackgroundResource(R.drawable.shape_with_white_stroke);
        return;
      case 1:
        this.diP.diX.setVisibility(0);
        this.diP.diU.setBackgroundResource(R.drawable.menu_style_waterfall_selected);
        this.diP.djd.setBackgroundResource(R.drawable.shape_with_red_stroke);
        this.diP.diY.setVisibility(8);
        this.diP.diV.setBackgroundResource(R.drawable.menu_style_hot_unselected);
        this.diP.dje.setBackgroundResource(R.drawable.shape_with_white_stroke);
        this.diP.diZ.setVisibility(8);
        this.diP.diW.setBackgroundResource(R.drawable.menu_style_normal_unselected);
        this.diP.djf.setBackgroundResource(R.drawable.shape_with_white_stroke);
        return;
      case 0:
        break;
    } 
    this.diP.diX.setVisibility(8);
    this.diP.diU.setBackgroundResource(R.drawable.menu_style_waterfall_unselected);
    this.diP.djd.setBackgroundResource(R.drawable.shape_with_white_stroke);
    this.diP.diY.setVisibility(8);
    this.diP.diV.setBackgroundResource(R.drawable.menu_style_hot_unselected);
    this.diP.dje.setBackgroundResource(R.drawable.shape_with_white_stroke);
    this.diP.diZ.setVisibility(0);
    this.diP.diW.setBackgroundResource(R.drawable.menu_style_normal_selected);
    this.diP.djf.setBackgroundResource(R.drawable.shape_with_red_stroke);
  }
  
  private void setListeners() {
    this.diP.djd.setOnClickListener(new o(this));
    this.diP.dje.setOnClickListener(new p(this));
    this.diP.djf.setOnClickListener(new q(this));
  }
  
  private void setupViews() {
    this.diP.dja.setImageBitmap(gT(1));
    this.diP.djc.setImageBitmap(gT(0));
    this.diP.djb.setImageBitmap(gT(2));
  }
  
  public boolean Az() { return (this.diQ != this.diR); }
  
  public void a(aa paramaa) { (new b(this, null)).execute(new Void[0]); }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.diP = a.q(this);
    int i = a.AZ().Cy();
    this.diQ = i;
    this.diR = i;
    this.diS = aoR();
    this.cjH = BitmapFactory.decodeStream(getResources().openRawResource(R.raw.menu_style_qrcode_bg));
    kb(this.diQ);
    setupViews();
    setListeners();
    return this.diP.getView();
  }
  
  public void save() { (new b(this, null)).execute(new Void[0]); }
  
  public static class a extends ab<ViewGroup> {
    public static final int aCt = R.layout.fragment_menu_style;
    
    ImageView diU;
    
    ImageView diV;
    
    ImageView diW;
    
    ImageView diX;
    
    ImageView diY;
    
    ImageView diZ;
    
    ImageView dja;
    
    ImageView djb;
    
    ImageView djc;
    
    ViewGroup djd;
    
    ViewGroup dje;
    
    ViewGroup djf;
    
    public a(int param1Int, View param1View) {
      super(param1Int);
      this.djd = (ViewGroup)s.z(param1View, R.id.rl_waterfall);
      this.dje = (ViewGroup)s.z(param1View, R.id.rl_hot);
      this.djf = (ViewGroup)s.z(param1View, R.id.rl_normal);
      this.diU = (ImageView)s.z(param1View, R.id.iv_first);
      this.diV = (ImageView)s.z(param1View, R.id.iv_second);
      this.diW = (ImageView)s.z(param1View, R.id.iv_three);
      this.diX = (ImageView)s.z(param1View, R.id.iv_selected_first);
      this.diY = (ImageView)s.z(param1View, R.id.iv_selected_second);
      this.diZ = (ImageView)s.z(param1View, R.id.iv_selected_three);
      this.dja = (ImageView)s.z(param1View, R.id.iv_waterfall_qrcode);
      this.djb = (ImageView)s.z(param1View, R.id.iv_hot_product_qrcode);
      this.djc = (ImageView)s.z(param1View, R.id.iv_normal_qrcode);
    }
    
    public static a q(Fragment param1Fragment) {
      View view = LayoutInflater.from(param1Fragment.getActivity()).inflate(aCt, null);
      if (view == null)
        throw new IllegalStateException("view cannot be null, inflate error"); 
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
  
  private class b extends AsyncTask<Void, Void, Boolean> {
    private b(MenuStyleFragment this$0) {}
    
    protected void b(Boolean param1Boolean) {
      ab.P(this.diT.getActivity());
      if (param1Boolean.booleanValue()) {
        this.diT.diR = this.diT.diQ;
        a.AZ().ec(this.diT.diQ);
        n.eP(R.string.save_success);
        return;
      } 
      this.diT.diQ = this.diT.diR;
      MenuStyleFragment.a(this.diT, this.diT.diQ);
      a.AZ().ec(this.diT.diQ);
      n.eP(R.string.save_settings_failed);
    }
    
    protected Boolean g(Void... param1VarArgs) { return Boolean.valueOf(a.AZ().Cj()); }
    
    protected void onPreExecute() {
      a.AZ().ec(this.diT.diQ);
      ab.N(this.diT.getActivity());
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\MenuStyleFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */