package com.laiqian.print;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.print.model.s;
import com.laiqian.print.usage.kitchen.a.a;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.print.usage.tag.a.a;
import com.laiqian.ui.s;
import com.laiqian.util.ae;
import hugo.weaving.DebugLog;
import java.util.ArrayList;

public class s extends Dialog {
  private b cCI;
  
  private a cCJ;
  
  private final ArrayList<ac> cCK = new ArrayList();
  
  private BroadcastReceiver receiver = new aa(this);
  
  public s(Context paramContext, ArrayList<ac> paramArrayList) {
    super(paramContext);
    requestWindowFeature(1);
    this.cCI = b.g(getWindow());
    this.cCK.addAll(paramArrayList);
    setupViews();
    init();
  }
  
  private void a(ac paramac) {
    ArrayList arrayList;
    switch (ab.bgg[((bm)paramac.aex().iterator().next()).ordinal()]) {
      default:
        arrayList = null;
        break;
      case 3:
        arrayList = a.bq(getContext()).aiB();
        break;
      case 2:
        arrayList = a.bo(getContext()).aiB();
        break;
      case 1:
        arrayList = a.bm(getContext()).aiB();
        break;
    } 
    if (arrayList != null && arrayList.size() > 0) {
      e e = g.cGS.f(paramac.aew()).D(arrayList);
      e.a(new w(this, paramac));
      g.cGS.print(e);
    } 
  }
  
  @DebugLog
  private void b(@Nullable ac paramac) {
    if (paramac == null) {
      this.cCI.csA.setText("");
      return;
    } 
    if (paramac.aew().getType() == 1) {
      this.cCI.csA.setText(Html.fromHtml(getContext().getString(2131628899)), TextView.BufferType.SPANNABLE);
    } else if (paramac.aew().getType() == 2) {
      this.cCI.csA.setText(Html.fromHtml(getContext().getString(2131628897)));
    } 
    g.cGS.g(paramac.aew());
  }
  
  private void b(s params) {
    e e = new e(params);
    e.a(new y(this, params));
    g.cGS.c(e);
  }
  
  private void hz(int paramInt) { b(this.cCJ.hA(paramInt).aew()); }
  
  private void init() {
    this.cCJ = new a(getContext());
    for (ac ac : this.cCK) {
      if (ac.aew().getType() == 1 || ac.aew().getType() == 2)
        this.cCJ.c(ac); 
    } 
    this.cCI.cCT.setAdapter(this.cCJ);
    if (this.cCJ.getCount() != 0) {
      this.cCI.cCT.performItemClick(this.cCJ.getView(0, null, this.cCI.cCT), 0, this.cCJ.getItemId(0));
      this.cCI.cCT.setItemChecked(0, true);
    } 
  }
  
  private void setupViews() {
    getWindow().setLayout(ae.b(getContext(), 750.0F), -2);
    this.cCI.tvTitle.setText(2131628896);
    this.cCI.ciV.setText(2131628898);
    this.cCI.cCU.setText(2131628895);
    this.cCI.cCU.setOnClickListener(new t(this));
    this.cCI.ciV.setOnClickListener(new u(this));
    this.cCI.cCT.setOnItemClickListener(new v(this));
    if (a.zR().Aa()) {
      this.cCI.aZa.setVisibility(0);
      if (CrashApplication.getLaiqianPreferenceManager().avF().equals("2")) {
        this.cCI.aZa.setImageResource(2131230994);
        return;
      } 
      this.cCI.aZa.setImageResource(2131230993);
      return;
    } 
    this.cCI.aZa.setVisibility(8);
  }
  
  protected void onStart() {
    super.onStart();
    IntentFilter intentFilter = new IntentFilter("permission");
    getContext().registerReceiver(this.receiver, intentFilter);
  }
  
  protected void onStop() {
    try {
      getContext().unregisterReceiver(this.receiver);
    } catch (Exception exception) {
      a.e(exception);
    } 
    super.onStop();
  }
  
  private static class a extends BaseAdapter {
    private int bAC = -1;
    
    private final ArrayList<ac> cCK = new ArrayList();
    
    private Context context;
    
    a(Context param1Context) { this.context = param1Context; }
    
    private void a(ac param1ac, a param1a) {
      s s = param1ac.aew();
      if (s.getType() == 1) {
        param1a.cCS.setVisibility(8);
        param1a.cCR.setText(s.getName());
      } else {
        param1a.cCS.setVisibility(0);
        param1a.cCS.setText(s.getName());
        switch (s.getType()) {
          case 4:
            param1a.cCR.setText(2131628961);
            break;
          case 3:
            param1a.cCR.setText(2131628959);
            break;
          case 2:
            param1a.cCR.setText(2131628960);
            break;
          case 1:
            param1a.cCR.setText(2131628963);
            break;
        } 
      } 
      if (s.isConnected()) {
        param1a.cCQ.setImageResource(2131231842);
        return;
      } 
      param1a.cCQ.setImageResource(2131231843);
    }
    
    public int aaL() { return this.bAC; }
    
    public void c(ac param1ac) { this.cCK.add(param1ac); }
    
    public void fw(int param1Int) { this.bAC = param1Int; }
    
    public int getCount() { return this.cCK.size(); }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a1;
      if (param1View == null) {
        a1 = a.g(LayoutInflater.from(this.context));
        a1.aQG.setTag(a1);
      } else {
        a1 = (a)a1.getTag();
      } 
      a(hA(param1Int), a1);
      return a1.aQG;
    }
    
    public ac hA(int param1Int) { return (ac)this.cCK.get(param1Int); }
    
    private static class a {
      View aQG;
      
      ImageView cCQ;
      
      TextView cCR;
      
      TextView cCS;
      
      a(View param2View) {
        this.aQG = param2View;
        this.cCQ = (ImageView)s.z(param2View, 2131297408);
        this.cCR = (TextView)s.z(param2View, 2131299581);
        this.cCS = (TextView)s.z(param2View, 2131299710);
      }
      
      static a g(LayoutInflater param2LayoutInflater) { return new a(param2LayoutInflater.inflate(2131427690, null)); }
    }
  }
  
  private static class a {
    View aQG;
    
    ImageView cCQ;
    
    TextView cCR;
    
    TextView cCS;
    
    a(View param1View) {
      this.aQG = param1View;
      this.cCQ = (ImageView)s.z(param1View, 2131297408);
      this.cCR = (TextView)s.z(param1View, 2131299581);
      this.cCS = (TextView)s.z(param1View, 2131299710);
    }
    
    static a g(LayoutInflater param1LayoutInflater) { return new a(param1LayoutInflater.inflate(2131427690, null)); }
  }
  
  private static class b {
    View aQG;
    
    ImageView aZa;
    
    ListView cCT;
    
    TextView cCU;
    
    TextView ciV;
    
    TextView csA;
    
    TextView tvTitle;
    
    b(View param1View) {
      this.aQG = param1View;
      this.tvTitle = (TextView)s.z(param1View, 2131299802);
      this.cCT = (ListView)s.z(param1View, 2131298088);
      this.csA = (TextView)s.z(param1View, 2131299525);
      this.cCU = (TextView)s.z(param1View, 2131296619);
      this.ciV = (TextView)s.z(param1View, 2131296644);
      this.aZa = (ImageView)s.z(param1View, 2131297399);
    }
    
    static b g(Window param1Window) {
      View view = View.inflate(param1Window.getContext(), 2131427555, null);
      param1Window.setContentView(view);
      return new b(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */