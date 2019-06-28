package com.laiqian.main.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.google.a.a.a.a.a.a;
import com.laiqian.auth.au;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.aq;
import com.laiqian.entity.c;
import com.laiqian.i.d;
import com.laiqian.models.at;
import com.laiqian.pos.AliPayPreorderDetail;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.util.av;
import com.laiqian.util.m;
import java.io.IOException;
import java.util.ArrayList;

public class d {
  private a.a bpv;
  
  private au bpw;
  
  private boolean isDelivery = false;
  
  public View paidOfSecond;
  
  private c telephoneEntity;
  
  public d(a.a parama) { this.bpv = parama; }
  
  public void Pn() {
    String str1 = (new av(RootApplication.zv())).atm();
    at at = new at(RootApplication.zv());
    str2 = at.iq(str1);
    try {
      this.bpw = (au)d.b(str2, au.class);
    } catch (IOException str2) {
      a.e(str2);
    } 
    if (this.bpw == null) {
      this.bpw = new au(false, true, false, 0.0D);
      at.ao(str1, d.ac(this.bpw));
    } 
  }
  
  public au Po() { return this.bpw; }
  
  public boolean Pp() { return (this.telephoneEntity != null); }
  
  public ArrayList<PrintContent> a(Bitmap paramBitmap, AliPayPreorderDetail paramAliPayPreorderDetail) {
    a a1 = a.bo(RootApplication.zv());
    paramAliPayPreorderDetail.ceY = Bitmap.createScaledBitmap(paramBitmap, 360, 360, true);
    return a1.b(paramAliPayPreorderDetail);
  }
  
  public boolean c(b paramb) {
    byte b1 = 0;
    int i = b1;
    if (paramb != null) {
      if (!paramb.bpr) {
        i = b1;
        return paramb.bpq ? true : i;
      } 
    } else {
      return i;
    } 
    return true;
  }
  
  public void cr(View paramView) { this.paidOfSecond = paramView; }
  
  public void dD(boolean paramBoolean) { this.isDelivery = paramBoolean; }
  
  public void fi(String paramString) { this.bpv.showAfterDiscountChanged(paramString); }
  
  public boolean isDeliveryOrder() { return this.isDelivery; }
  
  public void j(aq paramaq) { this.bpv.showAfterVipSelected(paramaq); }
  
  public void m(int paramInt, boolean paramBoolean) {
    if (paramInt == 10001) {
      this.bpv.setPayTypeCash();
      return;
    } 
    this.bpv.setPayTypeNotCash(paramInt, paramBoolean);
  }
  
  public class a extends m.a {
    private CheckBox bpx;
    
    private Context context;
    
    public a(d this$0, Context param1Context, CheckBox param1CheckBox) {
      super(param1Context, param1CheckBox);
      this.bpx = param1CheckBox;
      this.context = param1Context;
    }
    
    protected void a(CompoundButton param1CompoundButton) {
      super.a(param1CompoundButton);
      if (param1CompoundButton.getId() == 2131296864 && this.bpy.Pp()) {
        this.bpy.dD(true);
        return;
      } 
      this.bpy.dD(false);
    }
    
    public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
      if (!param1CompoundButton.isPressed())
        return; 
      if (this.bpx.isChecked()) {
        param1CompoundButton.setChecked(false);
        return;
      } 
      a(param1CompoundButton);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */