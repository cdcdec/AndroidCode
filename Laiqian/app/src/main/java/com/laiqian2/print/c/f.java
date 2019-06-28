package com.laiqian.print.c;

import android.app.Activity;
import android.content.Context;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.print.model.s;
import com.laiqian.ui.a.d;
import com.laiqian.util.ae;
import com.laiqian.util.bd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class f extends d {
  private ListView bLC;
  
  private c cIX;
  
  private Button cIY;
  
  private a cIZ = null;
  
  private ArrayList<a> cJa = null;
  
  private Toast cJb;
  
  private Context mContext;
  
  private TextView tvTitle;
  
  public f(Activity paramActivity) {
    super(paramActivity, 2131427554);
    this.mContext = paramActivity;
    this.cIX = d.bg(this.mContext);
    this.cJb = Toast.makeText(this.mContext, "", 0);
    aeF();
    this.tvTitle.setText(this.mContext.getString(2131625437));
    this.cIY.setText(this.mContext.getString(2131625433));
    this.cIY.setOnClickListener(new g(this));
    getWindow().setLayout(ae.b(getContext(), 600.0F), -2);
  }
  
  private void aeF() {
    this.tvTitle = (TextView)findViewById(2131299802);
    this.bLC = (ListView)findViewById(2131298066);
    this.cIY = (Button)findViewById(2131296619);
  }
  
  private void in(int paramInt) {
    this.cIX.bq(paramInt, 2);
    this.cIZ.notifyDataSetChanged();
  }
  
  private void io(int paramInt) {
    a a1 = (a)this.cJa.get(paramInt);
    g g = g.cGS;
    s s = a1.aew();
    if (s.getType() == 2) {
      if (!bd.bH(getContext()) || !g.cGS.agC()) {
        this.cJb.setText(this.mContext.getString(2131625438));
        this.cJb.show();
        return;
      } 
    } else if (s.getType() == 1) {
      if (!g.cGS.agB()) {
        this.cJb.setText(this.mContext.getString(2131629005));
        this.cJb.show();
        return;
      } 
      if (!g.isConnected(s)) {
        this.cJb.setText(this.mContext.getString(2131625444));
        this.cJb.show();
        g.g(s);
        return;
      } 
    } 
    e e = g.cGS.f(a1.aew()).D(a1.ahh());
    this.cIX.bq(paramInt, 3);
    this.cIZ.notifyDataSetChanged();
    e.a(new h(this, paramInt));
    g.print(e);
  }
  
  private void q(Collection<a> paramCollection) {
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext())
      ((a)iterator.next()).setStatus(0); 
  }
  
  public void dismiss() {
    this.cIX.ahj();
    super.dismiss();
  }
  
  public void show() {
    this.cJa = this.cIX.ahi();
    q(this.cJa);
    this.cIZ = new a(this, this.mContext, this.cJa);
    this.bLC.setAdapter(this.cIZ);
    super.show();
  }
  
  private class a extends BaseAdapter {
    private List<a> cJf;
    
    private Context context;
    
    public a(f this$0, Context param1Context, List<a> param1List) {
      this.context = param1Context;
      this.cJf = param1List;
    }
    
    private void a(a param1a, a param1a1) {
      param1a1.ccm.setText(param1a.getName());
      if (param1a.getNumber() != null) {
        param1a1.cJh.setVisibility(0);
        param1a1.cJh.setText(param1a.getNumber());
      } else {
        param1a1.cJh.setVisibility(8);
      } 
      Time time = new Time();
      time.set(param1a.ahg());
      param1a1.bqW.setText(time.format("%H:%M:%S"));
      switch (param1a.getStatus()) {
        default:
          return;
        case 3:
          param1a1.cJi.setDisplayedChild(1);
          param1a1.cJj.setText(f.b(this.cJc).getString(2131625436));
          return;
        case 2:
          param1a1.cJi.setDisplayedChild(1);
          param1a1.cJj.setText(f.b(this.cJc).getString(2131625432));
          return;
        case 1:
          param1a1.cJi.setDisplayedChild(1);
          param1a1.cJj.setText(f.b(this.cJc).getString(2131625435));
          return;
        case 0:
          break;
      } 
      param1a1.cJi.setDisplayedChild(0);
    }
    
    public int getCount() { return this.cJf.size(); }
    
    public Object getItem(int param1Int) { return this.cJf.get(param1Int); }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a1;
      if (param1View == null) {
        param1View = LayoutInflater.from(this.context).inflate(2131427649, null);
        a1 = new a(this, param1View);
        param1View.setTag(a1);
      } else {
        a1 = (a)param1View.getTag();
      } 
      a1.byK.setOnClickListener(new j(this, param1Int));
      a1.bqY.setOnClickListener(new k(this, param1Int));
      a((a)this.cJf.get(param1Int), a1);
      return param1View;
    }
    
    private class a {
      TextView bqW;
      
      Button bqY;
      
      Button byK;
      
      TextView cJh;
      
      ViewSwitcher cJi;
      
      TextView cJj;
      
      TextView ccm;
      
      public a(f.a this$0, View param2View) {
        this.cJh = (TextView)param2View.findViewById(2131299614);
        this.bqW = (TextView)param2View.findViewById(2131299800);
        this.ccm = (TextView)param2View.findViewById(2131299605);
        this.cJi = (ViewSwitcher)param2View.findViewById(2131299121);
        this.cJj = (TextView)this.cJi.findViewById(2131299706);
        this.byK = (Button)this.cJi.findViewById(2131296614);
        this.bqY = (Button)this.cJi.findViewById(2131296644);
      }
    }
  }
  
  private class a {
    TextView bqW;
    
    Button bqY;
    
    Button byK;
    
    TextView cJh;
    
    ViewSwitcher cJi;
    
    TextView cJj;
    
    TextView ccm;
    
    public a(f this$0, View param1View) {
      this.cJh = (TextView)param1View.findViewById(2131299614);
      this.bqW = (TextView)param1View.findViewById(2131299800);
      this.ccm = (TextView)param1View.findViewById(2131299605);
      this.cJi = (ViewSwitcher)param1View.findViewById(2131299121);
      this.cJj = (TextView)this.cJi.findViewById(2131299706);
      this.byK = (Button)this.cJi.findViewById(2131296614);
      this.bqY = (Button)this.cJi.findViewById(2131296644);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */