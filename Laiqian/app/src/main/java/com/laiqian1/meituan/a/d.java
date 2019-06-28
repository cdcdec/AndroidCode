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
import com.laiqian.meituan.g;
import com.laiqian.meituan.i;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import java.util.ArrayList;
import java.util.HashMap;

public class d extends BaseAdapter {
  ArrayList<i> aQU;
  
  private b brv;
  
  Context context;
  
  private LayoutInflater mInflater;
  
  public d(ArrayList<i> paramArrayList, Context paramContext) {
    this.aQU = paramArrayList;
    this.context = paramContext;
    this.mInflater = (LayoutInflater)paramContext.getSystemService("layout_inflater");
  }
  
  public void g(ArrayList<i> paramArrayList) { this.aQU = paramArrayList; }
  
  public int getCount() { return this.aQU.size(); }
  
  public Object getItem(int paramInt) { return this.aQU.get(paramInt); }
  
  public long getItemId(int paramInt) { return 0L; }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      this.brv = new b(this, null);
      paramView = this.mInflater.inflate(R.layout.listview_item_meituan_shop_setting, null);
      this.brv.brx = (TextView)paramView.findViewById(R.id.tv_shop_state);
      this.brv.aRf = (TextView)paramView.findViewById(R.id.tv_offline_label);
      this.brv.aRj = (ImageView)paramView.findViewById(R.id.tv_open_lable);
      this.brv.aRk = (ImageView)paramView.findViewById(R.id.tv_close_lable);
      this.brv.aRl = (TextView)paramView.findViewById(R.id.tv_name);
      this.brv.aRg = (LinearLayout)paramView.findViewById(R.id.ll_item);
      this.brv.aRm = (ProgressBarCircularIndeterminate)paramView.findViewById(R.id.iv_open_progress);
      this.brv.aRn = (ProgressBarCircularIndeterminate)paramView.findViewById(R.id.iv_close_progress);
      this.brv.aRh = (RelativeLayout)paramView.findViewById(R.id.rl_open);
      this.brv.aRi = (RelativeLayout)paramView.findViewById(R.id.rl_close);
      paramView.setTag(this.brv);
    } else {
      this.brv = (b)paramView.getTag();
    } 
    if (paramInt == 0) {
      this.brv.aRg.setBackgroundResource(R.drawable.shape_rounded_rectangle_up);
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.brv.aRg.getLayoutParams();
      layoutParams.setMargins(0, 0, 0, -1);
      this.brv.aRg.setLayoutParams(layoutParams);
    } else if (paramInt == getCount() - 1) {
      this.brv.aRg.setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown);
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.brv.aRg.getLayoutParams();
      layoutParams.setMargins(0, 0, 0, -1);
      this.brv.aRg.setLayoutParams(layoutParams);
    } else {
      this.brv.aRg.setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown);
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.brv.aRg.getLayoutParams();
      layoutParams.setMargins(0, 0, 0, -1);
      this.brv.aRg.setLayoutParams(layoutParams);
    } 
    this.brv.aRl.setText(((i)this.aQU.get(paramInt)).name);
    if (((i)this.aQU.get(paramInt)).bpT == 1) {
      if (((i)this.aQU.get(paramInt)).bpS == 1) {
        this.brv.aRh.setVisibility(8);
        this.brv.aRi.setVisibility(0);
        this.brv.brx.setVisibility(0);
        this.brv.brx.setText(this.context.getString(R.string.meituan_openning));
        this.brv.aRf.setVisibility(8);
        this.brv.aRn.setVisibility(8);
        this.brv.aRk.setVisibility(0);
      } else if (((i)this.aQU.get(paramInt)).bpS == 3) {
        this.brv.aRh.setVisibility(0);
        this.brv.aRi.setVisibility(8);
        this.brv.brx.setVisibility(0);
        this.brv.brx.setText(this.context.getString(R.string.meituan_closing));
        this.brv.aRf.setVisibility(8);
        this.brv.aRm.setVisibility(8);
        this.brv.aRj.setVisibility(0);
      } 
    } else if (((i)this.aQU.get(paramInt)).bpT == 0) {
      this.brv.aRh.setVisibility(8);
      this.brv.aRi.setVisibility(8);
      this.brv.brx.setVisibility(8);
      this.brv.aRf.setVisibility(0);
    } 
    this.brv.aRi.setOnClickListener(new e(this, paramInt));
    this.brv.aRh.setOnClickListener(new f(this, paramInt));
    return paramView;
  }
  
  class a extends AsyncTask<String, String, HashMap<String, Object>> {
    String bru;
    
    boolean isOpen;
    
    a(d this$0) {}
    
    protected HashMap<String, Object> j(String... param1VarArgs) {
      this.bru = param1VarArgs[0];
      this.isOpen = Boolean.valueOf(param1VarArgs[1]).booleanValue();
      return g.a(param1VarArgs[0], Boolean.valueOf(param1VarArgs[1]).booleanValue(), this.brw.context);
    }
    
    protected void j(HashMap<String, Object> param1HashMap) {
      super.onPostExecute(param1HashMap);
      byte b = 0;
      if (param1HashMap != null && param1HashMap.containsKey("data") && "ok".equals(String.valueOf(param1HashMap.get("data")))) {
        while (b < this.brw.aQU.size()) {
          if (((i)this.brw.aQU.get(b)).bpR.equals(this.bru)) {
            byte b1;
            i i = (i)this.brw.aQU.get(b);
            if (this.isOpen) {
              b1 = 1;
            } else {
              b1 = 3;
            } 
            i.bpS = b1;
          } 
          b++;
        } 
        this.brw.notifyDataSetChanged();
        return;
      } 
      this.brw.notifyDataSetChanged();
      Toast.makeText(this.brw.context, "修改失败", 0).show();
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
    
    TextView brx;
    
    private b(d this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */