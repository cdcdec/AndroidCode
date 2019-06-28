package com.laiqian.pos.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.laiqian.ui.ActivityRoot;
import kotlin.Metadata;
import kotlin.b;
import kotlin.c;
import kotlin.c.e;
import kotlin.jvm.a.a;
import kotlin.jvm.b.d;
import kotlin.jvm.b.j;
import kotlin.jvm.b.k;
import org.jetbrains.annotations.Nullable;

@Metadata
public final class ShopInfoSettingsActivity extends ActivityRoot {
  private static final int cBI = 0;
  
  private static final int cBJ = 1;
  
  private static final int cBK = 2;
  
  public static final a cBL = new a(null);
  
  private final b cBB = c.a((a)cu.cBM);
  
  private final b cBC = c.a((a)cw.cBO);
  
  private final b cBD = c.a((a)db.cBP);
  
  private final b cBE = c.a((a)new cv(this));
  
  private final b cBF = c.a((a)new cx(this));
  
  private final b cBG = c.a((a)new dc(this));
  
  private int cBH = cBL.adP();
  
  private final void abR() {
    int i = this.cBH;
    if (i == cBL.adP()) {
      adG().save();
      return;
    } 
    if (i == cBL.adQ()) {
      adH().save();
      return;
    } 
    if (i == cBL.adR())
      adI().save(); 
  }
  
  private final ShopBasicInfoFragment adG() {
    b b1 = this.cBB;
    e e1 = baf[0];
    return (ShopBasicInfoFragment)b1.getValue();
  }
  
  private final ShopDeviceModeSettingFragment adH() {
    b b1 = this.cBC;
    e e1 = baf[1];
    return (ShopDeviceModeSettingFragment)b1.getValue();
  }
  
  private final ShopMoreInfoSettingsFragment adI() {
    b b1 = this.cBD;
    e e1 = baf[2];
    return (ShopMoreInfoSettingsFragment)b1.getValue();
  }
  
  private final View adJ() {
    b b1 = this.cBE;
    e e1 = baf[3];
    return (View)b1.getValue();
  }
  
  private final View adK() {
    b b1 = this.cBF;
    e e1 = baf[4];
    return (View)b1.getValue();
  }
  
  private final View adL() {
    b b1 = this.cBG;
    e e1 = baf[5];
    return (View)b1.getValue();
  }
  
  private final void wR() {
    adJ().setOnClickListener((View.OnClickListener)new cy(this));
    adK().setOnClickListener((View.OnClickListener)new cz(this));
    adL().setOnClickListener((View.OnClickListener)new da(this));
    hw(cBL.adP());
  }
  
  public final void hw(int paramInt) {
    if (paramInt == cBL.adP()) {
      getSupportFragmentManager().beginTransaction().replace(2131297053, (Fragment)adG()).commit();
      adK().setSelected(false);
      adL().setSelected(false);
      adJ().setSelected(true);
      return;
    } 
    if (paramInt == cBL.adQ()) {
      getSupportFragmentManager().beginTransaction().replace(2131297053, (Fragment)adH()).commit();
      adK().setSelected(true);
      adL().setSelected(false);
      adJ().setSelected(false);
      return;
    } 
    if (paramInt == cBL.adR()) {
      getSupportFragmentManager().beginTransaction().replace(2131297053, (Fragment)adI()).commit();
      adK().setSelected(false);
      adL().setSelected(true);
      adJ().setSelected(false);
    } 
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    adI().onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131427423);
    setTitleTextView(2131629652);
    wR();
    setTitleTextViewRight(2131624290, (View.OnClickListener)new dd(this));
  }
  
  @Metadata
  public static final class a {
    private a() {}
    
    public final int adP() { return ShopInfoSettingsActivity.adM(); }
    
    public final int adQ() { return ShopInfoSettingsActivity.adN(); }
    
    public final int adR() { return ShopInfoSettingsActivity.adO(); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\ShopInfoSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */