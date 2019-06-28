package com.laiqian.setting;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.models.at;
import com.laiqian.models.bf;
import com.laiqian.network.o;
import com.laiqian.pos.industry.weiorder.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.ab;
import com.laiqian.util.av;
import com.laiqian.util.bg;
import com.laiqian.util.n;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;

public class UnitWeightActivity extends ActivityRoot {
  private static final String TAG = "UnitWeightActivity";
  
  TextView ciq;
  
  private a.a cst = new cv(this);
  
  GridView cvG;
  
  List<bf> dnx;
  
  a dny;
  
  static  {
  
  }
  
  private boolean a(bf parambf, double paramDouble, String paramString) {
    Iterator iterator = this.dnx.iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      bf bf1 = (bf)iterator.next();
      if (bf1.Ww() == parambf.Ww())
        continue; 
      if (bf1.Wx() == paramDouble) {
        Toast.makeText(this, 2131625053, 0).show();
        return true;
      } 
      if (bg.equals(bf1.Wy(), paramString)) {
        Toast.makeText(this, 2131625048, 0).show();
        bool = true;
      } 
    } 
    return bool;
  }
  
  private boolean c(double paramDouble, String paramString) {
    Iterator iterator = this.dnx.iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      bf bf = (bf)iterator.next();
      if (bf.Wx() == paramDouble) {
        Toast.makeText(this, 2131625053, 0).show();
        return true;
      } 
      if (bg.equals(bf.Wy(), paramString)) {
        Toast.makeText(this, 2131625048, 0).show();
        bool = true;
      } 
    } 
    return bool;
  }
  
  private void initData() { getWindow().getDecorView().post(new cs(this)); }
  
  private void initView() {
    this.cvG = (GridView)findViewById(2131299901);
    this.ciq = (TextView)findViewById(2131299533);
    this.cvG.setEmptyView(this.ciq);
    this.dnx = new ArrayList();
    this.dny = new a(this, this, this.dnx);
    this.cvG.setAdapter(this.dny);
    this.dny.notifyDataSetChanged();
  }
  
  public void a(bf parambf) {
    a a1 = new a(this, parambf, this.dnx.size());
    a1.a(this.cst);
    a1.show();
  }
  
  public void onBackPressed() { super.onBackPressed(); }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131427435);
    setTitleTextViewHideRightView(getString(2131630324));
    initView();
    initData();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    try {
      o.WQ().a(new FutureTask(new cw(this), null));
      return;
    } catch (InterruptedException interruptedException) {
      a.e(interruptedException);
      return;
    } 
  }
  
  public class a extends BaseAdapter {
    Context context;
    
    List<bf> cvK;
    
    public a(UnitWeightActivity this$0, Context param1Context, List<bf> param1List) {
      this.context = param1Context;
      this.cvK = param1List;
      if (param1List == null)
        throw new InvalidParameterException(); 
    }
    
    public bf eV(int param1Int) { return (param1Int == this.cvK.size()) ? null : (bf)this.cvK.get(param1Int); }
    
    public int getCount() { return this.cvK.size() + 1; }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a1;
      if (param1View == null) {
        param1View = LayoutInflater.from(this.context).inflate(2131427703, null);
        a1 = new a(this, param1View);
        param1View.setTag(a1);
      } else {
        a1 = (a)param1View.getTag();
      } 
      if (param1Int == this.cvK.size()) {
        a1.abP();
        a1.aQG.setOnClickListener(new cx(this));
        return param1View;
      } 
      a1.b(eV(param1Int));
      a1.aQG.setOnClickListener(new cy(this, param1Int));
      return param1View;
    }
    
    public void notifyDataSetChanged() {
      Collections.sort(this.cvK, new cz(this));
      super.notifyDataSetChanged();
    }
    
    public class a {
      public View aQG;
      
      public TextView cvM;
      
      public ViewGroup cvN;
      
      public TextView cvO;
      
      public a(UnitWeightActivity.a this$0, View param2View) {
        this.aQG = param2View;
        this.cvM = (TextView)param2View.findViewById(2131299807);
        this.cvN = (ViewGroup)param2View.findViewById(2131297922);
        this.cvO = (TextView)param2View.findViewById(2131299808);
      }
      
      public void abP() {
        this.cvM.setText("+");
        this.cvM.setTextSize(54.0F);
        this.cvO.setText(2131625050);
      }
      
      public void b(bf param2bf) {
        if (TextUtils.isEmpty(param2bf.Wy())) {
          this.cvM.setTextSize(20.0F);
          TextView textView1 = this.cvM;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(n.ph(String.valueOf(param2bf.Wx())));
          stringBuilder1.append(this.dnB.dnz.getString(2131625055));
          textView1.setText(stringBuilder1.toString());
          this.cvO.setText("");
          return;
        } 
        this.cvM.setTextSize(20.0F);
        this.cvM.setText(param2bf.Wy());
        TextView textView = this.cvO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n.ph(String.valueOf(param2bf.Wx())));
        stringBuilder.append(this.dnB.dnz.getString(2131625055));
        textView.setText(stringBuilder.toString());
      }
    }
  }
  
  public class a {
    public View aQG;
    
    public TextView cvM;
    
    public ViewGroup cvN;
    
    public TextView cvO;
    
    public a(UnitWeightActivity this$0, View param1View) {
      this.aQG = param1View;
      this.cvM = (TextView)param1View.findViewById(2131299807);
      this.cvN = (ViewGroup)param1View.findViewById(2131297922);
      this.cvO = (TextView)param1View.findViewById(2131299808);
    }
    
    public void abP() {
      this.cvM.setText("+");
      this.cvM.setTextSize(54.0F);
      this.cvO.setText(2131625050);
    }
    
    public void b(bf param1bf) {
      if (TextUtils.isEmpty(param1bf.Wy())) {
        this.cvM.setTextSize(20.0F);
        TextView textView1 = this.cvM;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(n.ph(String.valueOf(param1bf.Wx())));
        stringBuilder1.append(this.dnB.dnz.getString(2131625055));
        textView1.setText(stringBuilder1.toString());
        this.cvO.setText("");
        return;
      } 
      this.cvM.setTextSize(20.0F);
      this.cvM.setText(param1bf.Wy());
      TextView textView = this.cvO;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(n.ph(String.valueOf(param1bf.Wx())));
      stringBuilder.append(this.dnB.dnz.getString(2131625055));
      textView.setText(stringBuilder.toString());
    }
  }
  
  private class b extends AsyncTask<Void, Void, Boolean> {
    boolean bBY = false;
    
    private Dialog cvP;
    
    bf dnC;
    
    private String dnD;
    
    private double dnE;
    
    b(UnitWeightActivity this$0, Dialog param1Dialog, bf param1bf, String param1String, double param1Double) {
      this.cvP = param1Dialog;
      this.dnC = param1bf;
      this.dnD = param1String;
      this.dnE = param1Double;
    }
    
    protected void b(Boolean param1Boolean) {
      ab.P(this.dnz);
      if (!this.bBY) {
        if (param1Boolean.booleanValue()) {
          Toast.makeText(this.dnz, this.dnz.getString(2131630530), 0).show();
          this.dnz.dnx.add(this.dnC);
          this.dnz.dny.notifyDataSetChanged();
          this.cvP.dismiss();
          return;
        } 
        Toast.makeText(this.dnz, this.dnz.getString(2131630529), 0).show();
      } 
    }
    
    protected Boolean g(Void... param1VarArgs) {
      if (!this.bBY) {
        at at = new at(this.dnz);
        this.dnC = new bf(this.dnE, this.dnD, System.currentTimeMillis());
        String str = (new av(this.dnz)).Tx();
        return Boolean.valueOf(at.a(this.dnC.Wy(), this.dnC.Wx(), this.dnC.Ww(), str));
      } 
      return Boolean.valueOf(false);
    }
    
    protected void onPreExecute() {
      ab.N(this.dnz);
      this.bBY = UnitWeightActivity.a(this.dnz, this.dnE, this.dnD);
    }
  }
  
  private class c extends AsyncTask<Void, Void, Boolean> {
    bf css;
    
    private Dialog cvP;
    
    c(UnitWeightActivity this$0, Dialog param1Dialog, bf param1bf) {
      this.cvP = param1Dialog;
      this.css = param1bf;
    }
    
    protected void b(Boolean param1Boolean) {
      ab.P(this.dnz);
      if (param1Boolean.booleanValue()) {
        Toast.makeText(this.dnz, this.dnz.getString(2131630563), 0).show();
        this.dnz.dnx.remove(this.css);
        this.dnz.dny.notifyDataSetChanged();
        this.cvP.dismiss();
        return;
      } 
      Toast.makeText(this.dnz, this.dnz.getString(2131630562), 0).show();
    }
    
    protected Boolean g(Void... param1VarArgs) { return Boolean.valueOf((new at(this.dnz)).bK(this.css.Ww())); }
    
    protected void onPreExecute() { ab.N(this.dnz); }
  }
  
  private class d extends AsyncTask<Void, Void, Boolean> {
    boolean bBY = false;
    
    bf css;
    
    private Dialog cvP;
    
    private String dnF;
    
    private double dnG;
    
    d(UnitWeightActivity this$0, Dialog param1Dialog, bf param1bf, String param1String, double param1Double) {
      this.cvP = param1Dialog;
      this.css = param1bf;
      this.dnF = param1String;
      this.dnG = param1Double;
    }
    
    protected void b(Boolean param1Boolean) {
      ab.P(this.dnz);
      if (!this.bBY) {
        if (param1Boolean.booleanValue()) {
          Toast.makeText(this.dnz, this.dnz.getString(2131630575), 0).show();
          this.css.iz(this.dnF);
          this.css.aw(this.dnG);
          this.dnz.dny.notifyDataSetChanged();
          this.cvP.dismiss();
          return;
        } 
        Toast.makeText(this.dnz, this.dnz.getString(2131630574), 0).show();
      } 
    }
    
    protected Boolean g(Void... param1VarArgs) { return !this.bBY ? Boolean.valueOf((new at(this.dnz)).b(this.dnF, this.dnG, this.css.Ww(), (new av(this.dnz)).Tx())) : Boolean.valueOf(false); }
    
    protected void onPreExecute() {
      ab.N(this.dnz);
      if (this.css.Wx() != this.dnG || !bg.equals(this.css.Wy(), this.dnF))
        this.bBY = UnitWeightActivity.a(this.dnz, this.css, this.dnG, this.dnF); 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\UnitWeightActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */