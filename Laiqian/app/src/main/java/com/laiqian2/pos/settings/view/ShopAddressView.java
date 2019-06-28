package com.laiqian.pos.settings.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.laiqian.models.h;

public class ShopAddressView extends FrameLayout {
  public View cBX;
  
  public View cBY;
  
  public TextView cBZ;
  
  public TextView cCa;
  
  public TextView cCb;
  
  public EditText cCc;
  
  public ShopAddressView(@NonNull Context paramContext) { this(paramContext, null); }
  
  public ShopAddressView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  public ShopAddressView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131427706, this);
    init();
  }
  
  public void b(h.c paramc) {
    if (paramc == null) {
      this.cCb.setTextColor(getContext().getResources().getColor(2131099872));
      this.cCb.setText(getContext().getString(2131625093));
      return;
    } 
    this.cCb.setTextColor(getContext().getResources().getColor(2131099709));
    this.cCb.setText(paramc.getName());
  }
  
  public void d(h.a parama) {
    if (parama == null) {
      this.cCa.setTextColor(getContext().getResources().getColor(2131099872));
      this.cCa.setText(getContext().getString(2131624828));
      return;
    } 
    this.cCa.setTextColor(getContext().getResources().getColor(2131099709));
    this.cCa.setText(parama.getName());
  }
  
  public void d(h.e parame) {
    if (parame == null) {
      this.cBZ.setTextColor(getContext().getResources().getColor(2131099872));
      if (getContext().getResources().getBoolean(2131034124)) {
        this.cBZ.setText(getContext().getString(2131629055));
        return;
      } 
      this.cBZ.setText(getContext().getString(2131629054));
      return;
    } 
    this.cBZ.setTextColor(getContext().getResources().getColor(2131099709));
    this.cBZ.setText(parame.getName());
  }
  
  public void init() {
    this.cBX = getRootView().findViewById(2131297501);
    this.cBX.setBackgroundResource(2131231854);
    this.cCa = (TextView)this.cBX.findViewById(2131299507);
    this.cBZ = (TextView)this.cBX.findViewById(2131299662);
    this.cCb = (TextView)this.cBX.findViewById(2131299531);
    this.cBY = getRootView().findViewById(2131297552);
    this.cBY.setBackgroundResource(2131231846);
    this.cCc = (EditText)this.cBY.findViewById(2131297307);
  }
  
  public void jR(String paramString) { this.cCc.setText(paramString); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\view\ShopAddressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */