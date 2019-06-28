package com.laiqian.promotion.g;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.promotion.R;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.e;
import com.laiqian.ui.container.h;
import com.laiqian.ui.container.i;
import com.laiqian.ui.container.w;
import com.laiqian.ui.s;

public class d extends ab<ViewGroup> {
  public static final int aCt = R.layout.activity_promotion_create;
  
  public w cXA = new w(R.id.layoutFitProduct);
  
  public w cXB = new w(R.id.layoutFitType);
  
  public View cXC;
  
  public h cXD = new h(R.id.layoutMinBuyAmount);
  
  public h cXE = new h(R.id.layoutMinBuyNum);
  
  public h cXF = new h(R.id.layoutReduceAmount);
  
  public h cXG = new h(R.id.layoutReChargeAmount);
  
  public h cXH = new h(R.id.layoutGiftAmount);
  
  public w cXI = new w(R.id.layoutGiftProduct);
  
  public h cXJ = new h(R.id.layoutProductBuyNum);
  
  public h cXK = new h(R.id.layoutEveryTimeGiftProductNum);
  
  public h cXL = new h(R.id.layoutGiftProductTotalNum);
  
  public h cXM = new h(R.id.layoutAddAmount);
  
  public i cXN = new i(R.id.layoutProductDiscountLeft);
  
  public View cXr;
  
  public ab<TextView> cXs = new ab(R.id.item_layout_discount_left);
  
  public ab<EditText> cXt = new ab(R.id.item_layout_et_discount);
  
  public ab<TextView> cXu = new ab(R.id.item_layout_discount_symbol);
  
  public ab<RecyclerView> cXv = new ab(R.id.rv_promotion_list);
  
  public TextView cXw;
  
  public h cXx = new h(R.id.layoutPromotionName);
  
  public e cXy = new e(R.id.layoutDate);
  
  public w cXz = new w(R.id.layoutFitPeople);
  
  public d(int paramInt, View paramView) {
    super(paramInt);
    this.cXC = s.z(paramView, R.id.layoutProductDiscount);
    this.cXw = (TextView)s.z(paramView, R.id.tv_noData);
    this.cXr = s.z(paramView, R.id.activity_promotion_create);
  }
  
  public static d I(Activity paramActivity) {
    View view = LayoutInflater.from(paramActivity).inflate(aCt, null);
    paramActivity.setContentView(view);
    d d1 = new d(16908290, view);
    d1.S(view);
    return d1;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotion\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */