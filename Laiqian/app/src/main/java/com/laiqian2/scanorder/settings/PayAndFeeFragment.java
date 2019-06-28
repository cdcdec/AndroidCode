package com.laiqian.scanorder.settings;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.network.o;
import com.laiqian.pos.settings.aa;
import com.laiqian.scan_order_module.R;
import com.laiqian.sync.a.g;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.ab;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.m;
import com.laiqian.ui.s;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PayAndFeeFragment extends FragmentRoot implements aa, al {
  private r bCE;
  
  private r bCF;
  
  ArrayList<n> diB;
  
  private f.a diE = new u(this);
  
  c djg;
  
  ag djh;
  
  a dji;
  
  private Handler mHandler = new s(this);
  
  private bb mWaitingDialog;
  
  aa titleBar;
  
  private void RD() {
    this.mHandler.obtainMessage(3).sendToTarget();
    try {
      g g = new g(getActivity());
      o.WQ().a(new FutureTask(new ac(this, g), null));
      return;
    } catch (InterruptedException interruptedException) {
      a.e(interruptedException);
      return;
    } 
  }
  
  private JSONArray aB(ArrayList<n> paramArrayList) {
    JSONArray jSONArray = new JSONArray();
    if (paramArrayList == null)
      return new JSONArray(); 
    for (n n : paramArrayList) {
      try {
        JSONObject jSONObject = n.xy();
        if (jSONObject != null)
          jSONArray.put(jSONObject); 
      } catch (JSONException n) {
        a.e(n);
      } 
    } 
    return jSONArray;
  }
  
  private boolean abd() { return true; }
  
  private void setListeners() {
    this.bCE.a(new r(this));
    ((ViewGroup)this.djg.csU.getView()).setOnClickListener(new v(this));
    ((ViewGroup)this.djg.csV.getView()).setOnClickListener(new w(this));
    ((CheckBox)this.djg.csU.dwV.getView()).setOnCheckedChangeListener(new x(this));
    ((CheckBox)this.djg.csV.dwV.getView()).setOnCheckedChangeListener(new y(this));
    ((CheckBox)this.djg.csW.dwV.getView()).setOnCheckedChangeListener(new z(this));
    ((ViewGroup)this.djg.csW.getView()).setOnClickListener(new aa(this));
    this.bCF.a(new ab(this));
  }
  
  private void setupViews() {
    this.mWaitingDialog = new bb(getActivity());
    this.mWaitingDialog.setCancelable(false);
    this.bCE = new r(getActivity(), true, null);
    this.bCE.oZ("取消");
    this.bCE.t("开启");
    this.bCE.setTitle(getString(R.string.pos_dialog_title_prompt));
    this.bCE.s(getString(R.string.open_vip_pay_message));
    this.bCF = new r(getActivity(), true, null);
    this.bCF.oZ("取消");
    this.bCF.t("重试");
    this.bCF.setTitle(getString(R.string.pos_dialog_title_prompt));
    this.bCF.s("上传数据失败,请检查网络");
    ((ViewGroup)this.djg.csV.getView()).setVisibility(0);
    ((ViewGroup)this.djg.csU.getView()).setVisibility(0);
    ((TextView)this.djg.csW.cAO.getView()).setText(getString(R.string.vip_card));
    ((TextView)this.djg.csU.cAO.getView()).setText(getString(R.string.pos_paytype_alipay));
    ((TextView)this.djg.csV.cAO.getView()).setText(getString(R.string.pos_paytype_wechat));
    ((ViewGroup)this.djg.csU.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
    ((ViewGroup)this.djg.csV.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown);
    ((ViewGroup)this.djg.csW.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_down_click);
    if (a.zR().Ad()) {
      ((ViewGroup)this.djg.csU.getView()).setVisibility(8);
      ((ViewGroup)this.djg.csV.getView()).setVisibility(8);
      ((ViewGroup)this.djg.csW.getView()).setVisibility(8);
      this.djg.djm.setVisibility(8);
    } 
  }
  
  public boolean Az() { return (this.djh != null) ? this.djh.Az() : 0; }
  
  public void Em() {
    this.djg.aNv.setVisibility(0);
    this.djg.bDV.setVisibility(8);
  }
  
  public void RA() {
    if (this.titleBar != null) {
      this.titleBar.brk.setVisibility(0);
      this.titleBar.aNv.setVisibility(8);
    } 
  }
  
  public void Rz() {
    if (this.titleBar != null) {
      this.titleBar.brk.setVisibility(8);
      this.titleBar.aNv.setVisibility(0);
    } 
  }
  
  public void a(n paramn) {
    f f = new f(getContext(), paramn);
    f.a(this.diE);
    f.show();
  }
  
  public void a(aa paramaa) {
    this.titleBar = paramaa;
    if (abd())
      this.djh.save(); 
  }
  
  public void cE(boolean paramBoolean) { ((CheckBox)this.djg.csW.dwV.getView()).setChecked(paramBoolean); }
  
  public void eZ(boolean paramBoolean) { ((CheckBox)this.djg.csU.dwV.getView()).setChecked(paramBoolean); }
  
  public void fa(boolean paramBoolean) { ((CheckBox)this.djg.csV.dwV.getView()).setChecked(paramBoolean); }
  
  public void hideProgress() {
    this.djg.aNv.setVisibility(8);
    this.djg.bDV.setVisibility(0);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.djh = new ag(getActivity(), this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.djg = c.r(this);
    this.djh.init();
    setupViews();
    setListeners();
    return this.djg.getView();
  }
  
  public void p(double paramDouble) {}
  
  public void q(String paramString, boolean paramBoolean) {}
  
  public void r(String paramString, boolean paramBoolean) {}
  
  public void save() {
    if (abd())
      this.djh.save(); 
  }
  
  public void showError(String paramString) {
    if (getActivity() != null)
      Toast.makeText(getActivity(), paramString, 0).show(); 
  }
  
  public class a extends BaseAdapter {
    Context context;
    
    List<n> diG;
    
    public int getCount() { return this.diG.size() + 1; }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a1;
      if (param1View == null) {
        param1View = LayoutInflater.from(this.context).inflate(R.layout.item_layout_additional_fees, null);
        a1 = new a(this, param1View);
        param1View.setTag(a1);
      } else {
        a1 = (a)param1View.getTag();
      } 
      if (param1Int == this.diG.size()) {
        a1.abP();
        a1.aQG.setOnClickListener(new ad(this));
        return param1View;
      } 
      a1.b(ka(param1Int));
      a1.aQG.setOnClickListener(new ae(this, param1Int));
      return param1View;
    }
    
    public n ka(int param1Int) { return (param1Int == this.diG.size()) ? null : (n)this.diG.get(param1Int); }
    
    public void notifyDataSetChanged() {
      Collections.sort(this.diG, new af(this));
      super.notifyDataSetChanged();
    }
    
    public class a {
      public View aQG;
      
      public TextView ccm;
      
      public TextView cvM;
      
      public ViewGroup cvN;
      
      public TextView cvO;
      
      public a(PayAndFeeFragment.a this$0, View param2View) {
        this.aQG = param2View;
        this.cvM = (TextView)param2View.findViewById(R.id.tv_add);
        this.cvN = (ViewGroup)param2View.findViewById(R.id.layout_content);
        this.cvO = (TextView)param2View.findViewById(R.id.tv_value);
        this.ccm = (TextView)param2View.findViewById(R.id.tv_name);
      }
      
      public void abP() {
        this.cvM.setVisibility(0);
        this.cvN.setVisibility(8);
      }
      
      public void b(n param2n) {
        this.cvM.setVisibility(8);
        this.cvN.setVisibility(0);
        if (param2n.getType() == 1) {
          TextView textView = this.cvO;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(String.format(this.djl.djj.getString(R.string.fees), new Object[] { n.b(this.djl.djj.getContext(), Double.valueOf(param2n.AO()), true, false) }));
          stringBuilder.append(this.djl.djj.getString(R.string.unit));
          textView.setText(stringBuilder.toString());
        } else if (param2n.getType() == 0) {
          this.cvO.setText(String.format(this.djl.djj.getString(R.string.fees), new Object[] { n.b(this.djl.djj.getContext(), Double.valueOf(param2n.AO()), true, false) }));
        } 
        this.ccm.setText(param2n.getName());
      }
    }
  }
  
  public class a {
    public View aQG;
    
    public TextView ccm;
    
    public TextView cvM;
    
    public ViewGroup cvN;
    
    public TextView cvO;
    
    public a(PayAndFeeFragment this$0, View param1View) {
      this.aQG = param1View;
      this.cvM = (TextView)param1View.findViewById(R.id.tv_add);
      this.cvN = (ViewGroup)param1View.findViewById(R.id.layout_content);
      this.cvO = (TextView)param1View.findViewById(R.id.tv_value);
      this.ccm = (TextView)param1View.findViewById(R.id.tv_name);
    }
    
    public void abP() {
      this.cvM.setVisibility(0);
      this.cvN.setVisibility(8);
    }
    
    public void b(n param1n) {
      this.cvM.setVisibility(8);
      this.cvN.setVisibility(0);
      if (param1n.getType() == 1) {
        TextView textView = this.cvO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(this.djl.djj.getString(R.string.fees), new Object[] { n.b(this.djl.djj.getContext(), Double.valueOf(param1n.AO()), true, false) }));
        stringBuilder.append(this.djl.djj.getString(R.string.unit));
        textView.setText(stringBuilder.toString());
      } else if (param1n.getType() == 0) {
        this.cvO.setText(String.format(this.djl.djj.getString(R.string.fees), new Object[] { n.b(this.djl.djj.getContext(), Double.valueOf(param1n.AO()), true, false) }));
      } 
      this.ccm.setText(param1n.getName());
    }
  }
  
  private class b extends AsyncTask<Void, Void, Boolean> {
    double aJW;
    
    boolean bBY = false;
    
    private Dialog cvP;
    
    String name;
    
    int type;
    
    b(PayAndFeeFragment this$0, Dialog param1Dialog, String param1String, double param1Double, int param1Int) {
      this.cvP = param1Dialog;
      this.name = param1String;
      this.type = param1Int;
      this.aJW = param1Double;
    }
    
    private boolean SI() { // Byte code:
      //   0: aload_0
      //   1: getfield djj : Lcom/laiqian/scanorder/settings/PayAndFeeFragment;
      //   4: getfield diB : Ljava/util/ArrayList;
      //   7: invokevirtual iterator : ()Ljava/util/Iterator;
      //   10: astore_2
      //   11: aload_2
      //   12: invokeinterface hasNext : ()Z
      //   17: ifeq -> 47
      //   20: aload_2
      //   21: invokeinterface next : ()Ljava/lang/Object;
      //   26: checkcast com/laiqian/scanorder/settings/n
      //   29: invokevirtual getName : ()Ljava/lang/String;
      //   32: aload_0
      //   33: getfield name : Ljava/lang/String;
      //   36: invokevirtual equals : (Ljava/lang/Object;)Z
      //   39: ifeq -> 11
      //   42: iconst_1
      //   43: istore_1
      //   44: goto -> 49
      //   47: iconst_0
      //   48: istore_1
      //   49: iload_1
      //   50: ifeq -> 61
      //   53: getstatic com/laiqian/scan_order_module/R$string.duplicate_name : I
      //   56: invokestatic eP : (I)V
      //   59: iconst_0
      //   60: ireturn
      //   61: aload_0
      //   62: getfield djj : Lcom/laiqian/scanorder/settings/PayAndFeeFragment;
      //   65: invokevirtual getContext : ()Landroid/content/Context;
      //   68: invokestatic bH : (Landroid/content/Context;)Z
      //   71: ifne -> 82
      //   74: getstatic com/laiqian/scan_order_module/R$string.please_check_network : I
      //   77: invokestatic eP : (I)V
      //   80: iconst_0
      //   81: ireturn
      //   82: iconst_1
      //   83: ireturn }
    
    protected void b(Boolean param1Boolean) {
      ab.P(this.djj.getActivity());
      if (this.bBY) {
        if (param1Boolean.booleanValue()) {
          n.eP(R.string.add_success);
          this.djj.diB.add(new n(this.type, this.name, this.aJW));
          this.djj.dji.notifyDataSetChanged();
          this.cvP.dismiss();
          return;
        } 
        a.AZ().cd(PayAndFeeFragment.a(this.djj, this.djj.diB).toString());
        n.eP(R.string.add_failed);
      } 
    }
    
    protected Boolean g(Void... param1VarArgs) {
      if (this.bBY) {
        ArrayList arrayList = (ArrayList)this.djj.diB.clone();
        arrayList.add(new n(this.type, this.name, this.aJW));
        a.AZ().cd(PayAndFeeFragment.a(this.djj, arrayList).toString());
        return Boolean.valueOf(a.AZ().Cj());
      } 
      return Boolean.valueOf(false);
    }
    
    protected void onPreExecute() {
      ab.N(this.djj.getActivity());
      this.bBY = SI();
    }
  }
  
  public static class c extends ab<ViewGroup> {
    public static final int aCt = R.layout.fragment_pay_and_fee;
    
    public ProgressBarCircularIndeterminate aNv;
    
    public ViewGroup bDV;
    
    public m csU = new m(R.id.layout_online_alipay_cb);
    
    public m csV = new m(R.id.layout_online_wechat_pay_cb);
    
    public m csW = new m(R.id.layout_vip_pay_cb);
    
    public ViewGroup djm;
    
    public c(int param1Int, View param1View) {
      super(param1Int);
      this.aNv = (ProgressBarCircularIndeterminate)s.z(param1View, R.id.ivProgress);
      this.bDV = (ViewGroup)s.z(param1View, R.id.ll_content);
      this.djm = (ViewGroup)s.z(param1View, R.id.ll_additional_fees);
    }
    
    public static c r(Fragment param1Fragment) {
      View view = LayoutInflater.from(param1Fragment.getActivity()).inflate(aCt, null);
      if (view == null)
        throw new IllegalStateException("view cannot be null, inflate error"); 
      c c1 = new c(16908290, view);
      c1.S(view);
      return c1;
    }
  }
  
  private class d extends AsyncTask<Void, Void, Boolean> {
    boolean bBY = false;
    
    private Dialog cvP;
    
    n diI;
    
    d(PayAndFeeFragment this$0, Dialog param1Dialog, n param1n) {
      this.cvP = param1Dialog;
      this.diI = param1n;
    }
    
    private boolean SI() {
      if (!bd.bH(this.djj.getContext())) {
        n.eP(R.string.please_check_network);
        return false;
      } 
      return true;
    }
    
    protected void b(Boolean param1Boolean) {
      if (this.bBY) {
        ab.P(this.djj.getActivity());
        if (param1Boolean.booleanValue()) {
          n.eP(R.string.delete_success);
          this.djj.diB.remove(this.diI);
          this.djj.dji.notifyDataSetChanged();
          this.cvP.dismiss();
          return;
        } 
        a.AZ().cd(PayAndFeeFragment.a(this.djj, this.djj.diB).toString());
        n.eP(R.string.delete_failed);
      } 
    }
    
    protected Boolean g(Void... param1VarArgs) {
      if (this.bBY) {
        n n1;
        ArrayList arrayList = (ArrayList)this.djj.diB.clone();
        Iterator iterator = arrayList.iterator();
        param1VarArgs = null;
        while (iterator.hasNext()) {
          n n2 = (n)iterator.next();
          if (n2.equals(this.diI))
            n1 = n2; 
        } 
        if (n1 != null) {
          arrayList.remove(n1);
          a.AZ().cd(PayAndFeeFragment.a(this.djj, arrayList).toString());
          return Boolean.valueOf(a.AZ().Cj());
        } 
        return null;
      } 
      return null;
    }
    
    protected void onPreExecute() {
      this.bBY = SI();
      if (this.bBY)
        ab.N(this.djj.getActivity()); 
    }
  }
  
  private class e extends AsyncTask<Void, Void, Boolean> {
    double aJW;
    
    boolean bBY = false;
    
    private Dialog cvP;
    
    n diI;
    
    String name;
    
    int type;
    
    e(PayAndFeeFragment this$0, Dialog param1Dialog, n param1n, String param1String, double param1Double, int param1Int) {
      this.cvP = param1Dialog;
      this.diI = param1n;
      this.name = param1String;
      this.aJW = param1Double;
      this.type = param1Int;
    }
    
    private boolean SI() { // Byte code:
      //   0: aload_0
      //   1: getfield djj : Lcom/laiqian/scanorder/settings/PayAndFeeFragment;
      //   4: getfield diB : Ljava/util/ArrayList;
      //   7: invokevirtual iterator : ()Ljava/util/Iterator;
      //   10: astore_2
      //   11: aload_2
      //   12: invokeinterface hasNext : ()Z
      //   17: ifeq -> 60
      //   20: aload_2
      //   21: invokeinterface next : ()Ljava/lang/Object;
      //   26: checkcast com/laiqian/scanorder/settings/n
      //   29: astore_3
      //   30: aload_3
      //   31: aload_0
      //   32: getfield diI : Lcom/laiqian/scanorder/settings/n;
      //   35: if_acmpne -> 41
      //   38: goto -> 11
      //   41: aload_3
      //   42: invokevirtual getName : ()Ljava/lang/String;
      //   45: aload_0
      //   46: getfield name : Ljava/lang/String;
      //   49: invokevirtual equals : (Ljava/lang/Object;)Z
      //   52: ifeq -> 11
      //   55: iconst_1
      //   56: istore_1
      //   57: goto -> 62
      //   60: iconst_0
      //   61: istore_1
      //   62: iload_1
      //   63: ifeq -> 74
      //   66: getstatic com/laiqian/scan_order_module/R$string.duplicate_name : I
      //   69: invokestatic eP : (I)V
      //   72: iconst_0
      //   73: ireturn
      //   74: aload_0
      //   75: getfield djj : Lcom/laiqian/scanorder/settings/PayAndFeeFragment;
      //   78: invokevirtual getContext : ()Landroid/content/Context;
      //   81: invokestatic bH : (Landroid/content/Context;)Z
      //   84: ifne -> 95
      //   87: getstatic com/laiqian/scan_order_module/R$string.please_check_network : I
      //   90: invokestatic eP : (I)V
      //   93: iconst_0
      //   94: ireturn
      //   95: iconst_1
      //   96: ireturn }
    
    protected void b(Boolean param1Boolean) {
      ab.P(this.djj.getActivity());
      if (this.bBY) {
        if (param1Boolean.booleanValue()) {
          n.eP(R.string.upload_success);
          this.diI.aG(this.aJW);
          this.diI.setName(this.name);
          this.diI.setType(this.type);
          this.djj.dji.notifyDataSetChanged();
          this.cvP.dismiss();
          return;
        } 
        a.AZ().cd(PayAndFeeFragment.a(this.djj, this.djj.diB).toString());
        n.eP(R.string.upload_failed);
      } 
    }
    
    protected Boolean g(Void... param1VarArgs) {
      if (this.bBY) {
        n n1;
        ArrayList arrayList = (ArrayList)this.djj.diB.clone();
        Iterator iterator = arrayList.iterator();
        param1VarArgs = null;
        while (iterator.hasNext()) {
          n n2 = (n)iterator.next();
          if (this.diI.equals(n2))
            n1 = n2; 
        } 
        if (n1 != null) {
          n1.setName(this.name);
          n1.aG(this.aJW);
          n1.setType(this.type);
          a.AZ().cd(PayAndFeeFragment.a(this.djj, arrayList).toString());
          return Boolean.valueOf(a.AZ().Cj());
        } 
        return null;
      } 
      return null;
    }
    
    protected void onPreExecute() {
      ab.N(this.djj.getActivity());
      this.bBY = SI();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\PayAndFeeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */