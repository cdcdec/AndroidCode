package com.laiqian.pos.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ProductItemLayout extends RelativeLayout {
  private TextView cjj;
  
  private TextView cjk;
  
  private TextView cjl;
  
  private TextView cjm;
  
  private TextView cjn;
  
  public ProductItemLayout(Context paramContext) { super(paramContext); }
  
  public ProductItemLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    View.inflate(paramContext, 2131427876, this);
    this.cjj = (TextView)findViewById(2131299435);
    this.cjk = (TextView)findViewById(2131299406);
    this.cjl = (TextView)findViewById(2131299405);
    this.cjm = (TextView)findViewById(2131299404);
    this.cjn = (TextView)findViewById(2131299293);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\adapter\ProductItemLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */