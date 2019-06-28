package com.laiqian.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.util.ae;
import java.util.ArrayList;

public class k {
  private ListView bWY;
  
  private PopupWindow bgL;
  
  private Context context;
  
  private ArrayList<String> daR;
  
  public k(Context paramContext, int paramInt1, int paramInt2) {
    this.context = paramContext;
    this.daR = new ArrayList(5);
    View view = LayoutInflater.from(paramContext).inflate(R.layout.popmenu, null);
    this.bWY = (ListView)view.findViewById(R.id.listView);
    this.bWY.setAdapter(new a(this, null));
    if (paramInt1 == -1 && paramInt2 == -1) {
      this.bgL = new PopupWindow(view, -2, -2);
    } else {
      this.bgL = new PopupWindow(view, ae.b(paramContext, paramInt1), ae.b(paramContext, paramInt2));
    } 
    this.bgL.setBackgroundDrawable(new BitmapDrawable());
  }
  
  public void B(String[] paramArrayOfString) {
    int i = paramArrayOfString.length;
    for (byte b = 0; b < i; b++) {
      String str = paramArrayOfString[b];
      this.daR.add(str);
    } 
  }
  
  public void aF(ArrayList<String> paramArrayList) { this.daR = paramArrayList; }
  
  public void dismiss() { this.bgL.dismiss(); }
  
  public void do(View paramView) {
    int i = this.bgL.getWidth();
    int j = this.bgL.getHeight();
    int m = paramView.getHeight();
    this.bgL.showAsDropDown(paramView, -(i + 10), -(j / 2 + m / 2));
    this.bgL.setFocusable(true);
    this.bgL.setOutsideTouchable(true);
    this.bgL.update();
  }
  
  public void dp(View paramView) {
    int i = this.bgL.getWidth();
    int j = this.bgL.getHeight();
    int m = paramView.getHeight();
    this.bgL.showAsDropDown(paramView, i / 2, -(j / 2 + m / 2));
    this.bgL.setFocusable(true);
    this.bgL.setOutsideTouchable(true);
    this.bgL.update();
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) { this.bWY.setOnItemClickListener(paramOnItemClickListener); }
  
  public void showAsDropDown(View paramView) {
    this.bgL.showAsDropDown(paramView, 0, this.context.getResources().getDimensionPixelSize(R.dimen.popmenu_yoff));
    this.bgL.setFocusable(true);
    this.bgL.setOutsideTouchable(true);
    this.bgL.update();
  }
  
  private final class a extends BaseAdapter {
    private a(k this$0) {}
    
    public int getCount() { return k.a(this.dwk).size(); }
    
    public Object getItem(int param1Int) { return k.a(this.dwk).get(param1Int); }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a1;
      if (param1View == null) {
        param1View = LayoutInflater.from(k.b(this.dwk)).inflate(R.layout.pomenu_item, null);
        a1 = new a(this, null);
        param1View.setTag(a1);
        a1.dwl = (TextView)param1View.findViewById(R.id.textView);
      } else {
        a1 = (a)param1View.getTag();
      } 
      a1.dwl.setText((CharSequence)k.a(this.dwk).get(param1Int));
      return param1View;
    }
    
    private final class a {
      TextView dwl;
      
      private a(k.a this$0) {}
    }
  }
  
  private final class a {
    TextView dwl;
    
    private a(k this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */