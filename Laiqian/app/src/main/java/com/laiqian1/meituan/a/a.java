package com.laiqian.meituan.a;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.meituan.R;
import com.laiqian.meituan.ai;
import com.laiqian.meituan.s;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import java.util.ArrayList;
import java.util.HashMap;

public class a extends BaseAdapter {
  ArrayList<ai> aQU;
  
  private b brs;
  
  Context context;
  
  private LayoutInflater mInflater;
  
  public a(ArrayList<ai> paramArrayList, Context paramContext) {
    this.aQU = paramArrayList;
    this.context = paramContext;
    this.mInflater = (LayoutInflater)paramContext.getSystemService("layout_inflater");
  }
  
  public void g(ArrayList<ai> paramArrayList) { this.aQU = paramArrayList; }
  
  public int getCount() { return this.aQU.size(); }
  
  public Object getItem(int paramInt) { return this.aQU.get(paramInt); }
  
  public long getItemId(int paramInt) { return 0L; }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      this.brs = new b(this, null);
      paramView = this.mInflater.inflate(R.layout.listview_item_meituan_shop_setting, null);
      this.brs.aRf = (TextView)paramView.findViewById(R.id.tv_offline_label);
      this.brs.aRj = (ImageView)paramView.findViewById(R.id.tv_open_lable);
      this.brs.aRk = (ImageView)paramView.findViewById(R.id.tv_close_lable);
      this.brs.aRl = (TextView)paramView.findViewById(R.id.tv_name);
      this.brs.aRg = (LinearLayout)paramView.findViewById(R.id.ll_item);
      this.brs.aRm = (ProgressBarCircularIndeterminate)paramView.findViewById(R.id.iv_open_progress);
      this.brs.aRn = (ProgressBarCircularIndeterminate)paramView.findViewById(R.id.iv_close_progress);
      this.brs.aRh = (RelativeLayout)paramView.findViewById(R.id.rl_open);
      this.brs.aRi = (RelativeLayout)paramView.findViewById(R.id.rl_close);
      paramView.setTag(this.brs);
    } else {
      this.brs = (b)paramView.getTag();
    } 
    if (paramInt == 0) {
      this.brs.aRg.setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown);
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.brs.aRg.getLayoutParams();
      layoutParams.setMargins(0, 0, 0, -1);
      this.brs.aRg.setLayoutParams(layoutParams);
    } else if (paramInt == getCount() - 1) {
      this.brs.aRg.setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown);
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.brs.aRg.getLayoutParams();
      layoutParams.setMargins(0, 0, 0, -1);
      this.brs.aRg.setLayoutParams(layoutParams);
    } else {
      this.brs.aRg.setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown);
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.brs.aRg.getLayoutParams();
      layoutParams.setMargins(0, 0, 0, -1);
      this.brs.aRg.setLayoutParams(layoutParams);
    } 
    this.brs.aRl.setText(((ai)this.aQU.get(paramInt)).name);
    if (((ai)this.aQU.get(paramInt)).brh == 1) {
      if (((ai)this.aQU.get(paramInt)).aQZ == 1) {
        this.brs.aRh.setVisibility(8);
        this.brs.aRi.setVisibility(0);
        this.brs.aRf.setVisibility(8);
        this.brs.aRn.setVisibility(8);
        this.brs.aRk.setVisibility(0);
      } else if (((ai)this.aQU.get(paramInt)).aQZ == 3) {
        this.brs.aRh.setVisibility(0);
        this.brs.aRi.setVisibility(8);
        this.brs.aRf.setVisibility(8);
        this.brs.aRm.setVisibility(8);
        this.brs.aRj.setVisibility(0);
      } 
    } else if (((ai)this.aQU.get(paramInt)).brh == 0) {
      this.brs.aRh.setVisibility(8);
      this.brs.aRi.setVisibility(8);
      this.brs.aRf.setVisibility(0);
    } 
    this.brs.aRi.setOnClickListener(new b(this));
    this.brs.aRh.setOnClickListener(new c(this));
    return paramView;
  }
  
  class a extends AsyncTask<String, String, HashMap<String, Object>> {
    String bru;
    
    boolean isOpen;
    
    a(a this$0) {}
    
    protected HashMap<String, Object> j(String... param1VarArgs) {
      this.bru = param1VarArgs[0];
      this.isOpen = Boolean.valueOf(param1VarArgs[1]).booleanValue();
      return s.a(param1VarArgs[0], Boolean.valueOf(param1VarArgs[1]).booleanValue(), this.brt.context);
    }
    
    protected void j(HashMap<String, Object> param1HashMap) {
      super.onPostExecute(param1HashMap);
      byte b = 0;
      if (param1HashMap != null && param1HashMap.containsKey("data") && "ok".equals(String.valueOf(param1HashMap.get("data")))) {
        while (b < this.brt.aQU.size()) {
          byte b1;
          ai ai = (ai)this.brt.aQU.get(b);
          if (this.isOpen) {
            b1 = 1;
          } else {
            b1 = 3;
          } 
          ai.aQZ = b1;
          b++;
        } 
        this.brt.notifyDataSetChanged();
        return;
      } 
      this.brt.notifyDataSetChanged();
      Toast.makeText(this.brt.context, "修改失败", 0).show();
    }
    
    protected void onPreExecute() { super.onPreExecute(); }
  }
  
  private class b {
    TextView aRf;
    
    LinearLayout aRg;
    
    RelativeLayout aRh;
    
    RelativeLayout aRi;
    
    ImageView aRj;
    
    ImageView aRk;
    
    TextView aRl;
    
    ProgressBarCircularIndeterminate aRm;
    
    ProgressBarCircularIndeterminate aRn;
    
    private b(a this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */