package com.laiqian.pos;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.entity.v;
import com.laiqian.models.f;
import com.laiqian.setting.bf;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.util.n;
import com.laiqian.wallet.k;
import io.reactivex.android.b.a;
import io.reactivex.g.a;
import io.reactivex.n;
import java.util.ArrayList;
import java.util.Iterator;

public class PayTypeSettingActivity extends ActivityRoot {
  private boolean aFB;
  
  private boolean aTj;
  
  private f accountTableModel;
  
  private boolean byz;
  
  private TextView ceP;
  
  private final int ceQ = 1;
  
  private TextView cfF;
  
  private final int cfG = 2;
  
  private a cfH;
  
  private View cfI;
  
  private ab cfJ;
  
  private boolean cfK;
  
  private boolean cfL = false;
  
  private boolean Az() {
    Iterator iterator = this.cfH.zJ().iterator();
    while (iterator.hasNext()) {
      if (((v)iterator.next()).xB())
        return true; 
    } 
    if (this.byz) {
      int i = a.AZ().Bo();
      if (((Integer)this.ceP.getTag()).intValue() != i)
        return true; 
    } 
    if (this.cfK) {
      int i = a.AZ().Bq();
      if (((Integer)this.cfF.getTag()).intValue() != i)
        return true; 
    } 
    return false;
  }
  
  private void ZB() {
    if (this.byz) {
      Zm();
    } else {
      findViewById(2131296344).setVisibility(8);
    } 
    if (this.cfK) {
      ZC();
      return;
    } 
    findViewById(2131300019).setVisibility(8);
  }
  
  private void ZC() {
    null = findViewById(2131300018);
    boolean bool = TextUtils.isEmpty(getLaiqianPreferenceManager().FD());
    if (!a.zR().Ak() && !a.zR().At()) {
      Class clazz;
      if (bool ^ true) {
        clazz = com.laiqian.binding.BindingWechatCodeHelp.class;
      } else {
        clazz = com.laiqian.binding.BindingWechatSelectActivity.class;
      } 
      null.setOnClickListener(new bf(this, clazz, this.aFB));
    } 
    TextView textView = (TextView)null.findViewById(2131300017);
    String str = getLaiqianPreferenceManager().FD();
    if (TextUtils.isEmpty(str)) {
      textView.setText(2131627324);
    } else {
      textView.setText(str);
    } 
    View view = findViewById(2131300025);
    view.setOnClickListener(new ap(this));
    this.cfF = (TextView)view.findViewById(2131300024);
    bd(2131300023, -16727543);
    gJ(a.AZ().Bq());
  }
  
  private void Zm() {
    null = findViewById(2131296343);
    boolean bool = "5".equals(String.valueOf(a.AZ().Bp()));
    if (!a.zR().Ak() && !a.zR().At()) {
      Class clazz;
      if (bool) {
        clazz = com.laiqian.binding.BindingAlipayHelp.class;
      } else {
        clazz = com.laiqian.binding.BindingAlipaySelectActivity.class;
      } 
      null.setOnClickListener(new bf(this, clazz, this.aFB));
    } 
    TextView textView = (TextView)null.findViewById(2131296342);
    String str = getLaiqianPreferenceManager().FC();
    if (TextUtils.isEmpty(str)) {
      textView.setText(2131627324);
    } else {
      textView.setText(str);
    } 
    View view = findViewById(2131296347);
    view.setOnClickListener(new ao(this));
    this.ceP = (TextView)view.findViewById(2131296346);
    bd(2131296345, -16733710);
    gF(a.AZ().Bo());
  }
  
  private void bd(int paramInt1, int paramInt2) {
    Drawable drawable = findViewById(paramInt1).getBackground();
    if (drawable != null && drawable instanceof GradientDrawable)
      ((GradientDrawable)drawable).setColor(paramInt2); 
  }
  
  private void gF(int paramInt) {
    String str;
    int i = paramInt;
    if (getLaiqianPreferenceManager().awj()) {
      i = paramInt;
      if (paramInt == 2) {
        this.cfL = true;
        i = 1;
      } 
    } 
    switch (i) {
      default:
        str = "";
        break;
      case 2:
        str = getString(2131627310);
        break;
      case 1:
        str = getString(2131628757);
        break;
      case 0:
        str = getString(2131628757);
        break;
    } 
    this.ceP.setText(str);
    this.ceP.setTag(Integer.valueOf(i));
  }
  
  private void gJ(int paramInt) {
    String str;
    int i = paramInt;
    if (getLaiqianPreferenceManager().awk()) {
      i = paramInt;
      if (paramInt == 7) {
        this.cfL = true;
        i = 5;
      } 
    } 
    if (i != 5) {
      switch (i) {
        default:
          str = "";
          break;
        case 8:
          str = getString(2131628757);
          break;
        case 7:
          str = getString(2131627367);
          break;
      } 
    } else {
      str = getString(2131628757);
    } 
    this.cfF.setText(str);
    this.cfF.setTag(Integer.valueOf(i));
  }
  
  private void save() {
    ArrayList arrayList = new ArrayList();
    Iterator iterator = this.cfH.zJ().iterator();
    byte b2 = 0;
    while (iterator.hasNext()) {
      v v = (v)iterator.next();
      if (v.xB()) {
        if (v.FQ()) {
          arrayList.add(v);
        } else {
          v.Ga();
        } 
        b2 = 1;
      } 
    } 
    if (!arrayList.isEmpty())
      this.accountTableModel.L(arrayList); 
    byte b1 = b2;
    if (this.byz) {
      int i = ((Integer)this.ceP.getTag()).intValue();
      b1 = b2;
      if (i != a.AZ().Bo()) {
        a.AZ().dW(i);
        b1 = 1;
      } 
    } 
    b2 = b1;
    if (this.cfK) {
      int i = ((Integer)this.cfF.getTag()).intValue();
      b2 = b1;
      if (i != a.AZ().Bq()) {
        a.AZ().dX(i);
        b2 = 1;
      } 
    } 
    if (b2 != 0)
      sendBroadcast(new Intent("pos_activity_change_data_paytype")); 
  }
  
  private void yf() {
    bd(2131298334, -412590);
    ListView listView = (ListView)findViewById(2131298362);
    this.accountTableModel = new f(this);
    this.cfI = findViewById(2131296330);
    this.cfH = new a(this, null);
    this.cfJ = new ab(this);
    this.cfJ.a(new aq(this));
    this.cfI.setOnClickListener(new ar(this));
    listView.setAdapter(this.cfH);
  }
  
  public void finish() {
    if (Az() && !this.cfL) {
      r r = new r(this, true, new as(this));
      r.setTitle(getString(2131627735));
      r.s(getString(2131627733));
      r.t(getString(2131627734));
      r.oZ(getString(2131627732));
      r.show();
      return;
    } 
    super.finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
      return; 
    switch (paramInt1) {
      default:
        return;
      case 2:
        paramInt1 = paramIntent.getIntExtra("code", 7);
        this.cfL = paramIntent.getBooleanExtra("changed", this.cfL);
        gJ(paramInt1);
        return;
      case 1:
        break;
    } 
    paramInt1 = paramIntent.getIntExtra("code", 2);
    this.cfL = paramIntent.getBooleanExtra("changed", this.cfL);
    gF(paramInt1);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131427928);
    setTitleTextView(2131627364);
    setTitleTextViewRight(2131624290, new an(this));
    this.byz = getResources().getBoolean(2131034129);
    this.cfK = getResources().getBoolean(2131034136);
    this.aTj = getResources().getBoolean(2131034133);
    this.aFB = "150001".equals(CrashApplication.getLaiqianPreferenceManager().atp());
    setTitleTextViewRightRefresh(getText(2131627745), true, new ak(this));
    ZB();
    yf();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (this.accountTableModel != null)
      this.accountTableModel.close(); 
  }
  
  private class a extends BaseAdapter {
    private ArrayList<v> bjv;
    
    private ArrayList<v> cfO = new ArrayList();
    
    private boolean cfP;
    
    private a(PayTypeSettingActivity this$0) {
      if (PayTypeSettingActivity.j(this$0)) {
        this.cfO.add(v.FS());
        this.cfO.add(v.FT());
      } 
      this.cfO.add(v.FU());
      YQ();
    }
    
    private void YQ() {
      if (this.bjv != null)
        this.bjv.clear(); 
      this.bjv = PayTypeSettingActivity.k(this.cfN).o(false, false);
      this.cfP = this.bjv.isEmpty() ^ true;
      if (this.bjv.size() >= 20) {
        PayTypeSettingActivity.l(this.cfN).setVisibility(8);
      } else {
        PayTypeSettingActivity.l(this.cfN).setVisibility(0);
      } 
      this.bjv.addAll(0, this.cfO);
      notifyDataSetChanged();
    }
    
    public v gK(int param1Int) { return (v)this.bjv.get(param1Int); }
    
    public int getCount() { return this.bjv.size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a2;
      a a1;
      if (param1View == null) {
        a2 = View.inflate(this.cfN, 2131427930, null);
        param1View = a2.findViewById(2131298932);
        TextView textView = (TextView)a2.findViewById(2131298198);
        View view = a2.findViewById(2131299903);
        a2.setOnClickListener(new at(this));
        a1 = new a(this, param1View, textView, view);
        view.setTag(a1);
        view.setOnClickListener(new au(this));
        a2.setTag(a1);
      } else {
        a a3 = (a)a1.getTag();
        a2 = a1;
        a1 = a3;
      } 
      v v = gK(param1Int);
      a1.cfS = v;
      a1.cfR.setSelected(v.aSZ);
      a1.aKu.setText(v.name);
      if (v.FQ()) {
        a1.cdo.setVisibility(0);
        return a2;
      } 
      a1.cdo.setVisibility(8);
      return a2;
    }
    
    public ArrayList<v> zJ() { return this.bjv; }
    
    class a {
      TextView aKu;
      
      View cdo;
      
      View cfR;
      
      v cfS;
      
      public a(PayTypeSettingActivity.a this$0, View param2View1, TextView param2TextView, View param2View2) {
        this.cfR = param2View1;
        this.aKu = param2TextView;
        this.cdo = param2View2;
      }
    }
  }
  
  class a {
    TextView aKu;
    
    View cdo;
    
    View cfR;
    
    v cfS;
    
    public a(PayTypeSettingActivity this$0, View param1View1, TextView param1TextView, View param1View2) {
      this.cfR = param1View1;
      this.aKu = param1TextView;
      this.cdo = param1View2;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\PayTypeSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */