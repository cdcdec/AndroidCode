package com.laiqian.main.module.hardware.weight;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.models.at;
import com.laiqian.models.bf;
import com.laiqian.ui.a.d;
import com.laiqian.ui.recycleview.LineGridView;
import com.laiqian.util.av;
import java.util.ArrayList;
import java.util.List;

public class h extends d {
  private static final String TAG = "h";
  
  private a bgA;
  
  private List<bf> bgB;
  
  private b bgy;
  
  private TextView bgz;
  
  private final Context mContext;
  
  static  {
  
  }
  
  public h(Context paramContext) {
    super(paramContext, 2131427572, 2131690280);
    this.mContext = paramContext;
    initView();
    initData();
  }
  
  private void initData() {
    List list = (new at(this.mContext)).ir((new av(this.mContext)).Tx());
    this.bgB.addAll(list);
    this.bgy.notifyDataSetChanged();
  }
  
  private void initView() {
    LineGridView lineGridView = (LineGridView)this.mView.findViewById(2131296875);
    this.bgz = (TextView)this.mView.findViewById(2131296876);
    this.bgB = new ArrayList();
    this.bgy = new b(this, this.bgB);
    lineGridView.setAdapter(this.bgy);
    this.bgy.notifyDataSetChanged();
  }
  
  public double MN() { return (this.bgB.size() == 1) ? ((bf)this.bgB.get(0)).Wx() : -1.0D; }
  
  public void a(a parama) { this.bgA = parama; }
  
  public void cm(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      if (this.bgB.isEmpty())
        return; 
      this.bgz.setText(paramString);
      show();
      return;
    } 
  }
  
  public static interface a {
    void ad(double param1Double);
  }
  
  private class b extends BaseAdapter {
    private List<bf> bgC;
    
    public b(h this$0, List<bf> param1List) { this.bgC = param1List; }
    
    public bf eV(int param1Int) { return (bf)this.bgC.get(param1Int); }
    
    public int getCount() { return (this.bgC == null) ? 0 : this.bgC.size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a;
      if (param1View != null) {
        a = (a)param1View.getTag();
      } else {
        a = new a(this);
        param1View = LayoutInflater.from(h.a(this.bgD)).inflate(2131427577, null);
        a.bgG = (TextView)param1View.findViewById(2131299807);
        a.bgH = (TextView)param1View.findViewById(2131299808);
        a.bgF = (LinearLayout)param1View.findViewById(2131297922);
        param1View.setTag(a);
      } 
      a.bgF.setOnClickListener(new i(this, param1Int));
      bf bf = eV(param1Int);
      a.bgG.setText(bf.Wy());
      TextView textView = a.bgH;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(bf.Wx());
      stringBuilder.append(h.a(this.bgD).getString(2131625055));
      textView.setText(String.valueOf(stringBuilder.toString()));
      return param1View;
    }
    
    class a {
      LinearLayout bgF;
      
      TextView bgG;
      
      TextView bgH;
      
      a(h.b this$0) {}
    }
  }
  
  class a {
    LinearLayout bgF;
    
    TextView bgG;
    
    TextView bgH;
    
    a(h this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\hardware\weight\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */