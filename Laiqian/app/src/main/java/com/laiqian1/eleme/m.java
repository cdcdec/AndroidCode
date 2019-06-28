package com.laiqian.eleme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.laiqian.ui.ImageCheckBox;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import java.util.ArrayList;

public class m extends BaseAdapter {
  ArrayList<j> aQU;
  
  private b aRb;
  
  a aRc;
  
  Context context;
  
  private LayoutInflater mInflater;
  
  public m(ArrayList<j> paramArrayList, Context paramContext, a parama) {
    this.aQU = paramArrayList;
    this.context = paramContext;
    this.aRc = parama;
    this.mInflater = (LayoutInflater)paramContext.getSystemService("layout_inflater");
  }
  
  public void g(ArrayList<j> paramArrayList) { this.aQU = paramArrayList; }
  
  public int getCount() { return this.aQU.size(); }
  
  public Object getItem(int paramInt) { return this.aQU.get(paramInt); }
  
  public long getItemId(int paramInt) { return 0L; }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      this.aRb = new b(this, null);
      paramView = this.mInflater.inflate(R.layout.listview_item_eleme_shop_setting, null);
      this.aRb.aRf = (TextView)paramView.findViewById(R.id.tv_offline_label);
      this.aRb.aRj = (ImageView)paramView.findViewById(R.id.tv_open_lable);
      this.aRb.aRk = (ImageView)paramView.findViewById(R.id.tv_close_lable);
      this.aRb.aRl = (TextView)paramView.findViewById(R.id.tv_name);
      this.aRb.aRg = (LinearLayout)paramView.findViewById(R.id.ll_item);
      this.aRb.aRm = (ProgressBarCircularIndeterminate)paramView.findViewById(R.id.iv_open_progress);
      this.aRb.aRn = (ProgressBarCircularIndeterminate)paramView.findViewById(R.id.iv_close_progress);
      this.aRb.aRh = (RelativeLayout)paramView.findViewById(R.id.rl_open);
      this.aRb.aRi = (RelativeLayout)paramView.findViewById(R.id.rl_close);
      this.aRb.aRe = (ImageCheckBox)paramView.findViewById(R.id.cb_push);
      paramView.setTag(this.aRb);
    } else {
      this.aRb = (b)paramView.getTag();
    } 
    if (paramInt == 0) {
      this.aRb.aRg.setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown);
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.aRb.aRg.getLayoutParams();
      layoutParams.setMargins(0, 0, 0, -1);
      this.aRb.aRg.setLayoutParams(layoutParams);
    } else if (paramInt == getCount() - 1) {
      this.aRb.aRg.setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown);
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.aRb.aRg.getLayoutParams();
      layoutParams.setMargins(0, 0, 0, -1);
      this.aRb.aRg.setLayoutParams(layoutParams);
    } else {
      this.aRb.aRg.setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown);
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.aRb.aRg.getLayoutParams();
      layoutParams.setMargins(0, 0, 0, -1);
      this.aRb.aRg.setLayoutParams(layoutParams);
    } 
    this.aRb.aRl.setText(((j)this.aQU.get(paramInt)).name);
    if (((j)this.aQU.get(paramInt)).aQZ == 1) {
      this.aRb.aRh.setVisibility(0);
      this.aRb.aRi.setVisibility(8);
      this.aRb.aRn.setVisibility(8);
      this.aRb.aRk.setVisibility(0);
    } else if (((j)this.aQU.get(paramInt)).aQZ == 0) {
      this.aRb.aRh.setVisibility(8);
      this.aRb.aRi.setVisibility(0);
      this.aRb.aRm.setVisibility(8);
      this.aRb.aRj.setVisibility(0);
    } 
    this.aRb.aRe.setChecked(((j)this.aQU.get(paramInt)).aRa);
    this.aRb.aRe.setOnClickListener(new n(this));
    this.aRb.aRe.a(new o(this, paramInt));
    return paramView;
  }
  
  static interface a {
    void l(int param1Int, boolean param1Boolean);
  }
  
  private class b {
    ImageCheckBox aRe;
    
    TextView aRf;
    
    LinearLayout aRg;
    
    RelativeLayout aRh;
    
    RelativeLayout aRi;
    
    ImageView aRj;
    
    ImageView aRk;
    
    TextView aRl;
    
    ProgressBarCircularIndeterminate aRm;
    
    ProgressBarCircularIndeterminate aRn;
    
    private b(m this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\eleme\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */