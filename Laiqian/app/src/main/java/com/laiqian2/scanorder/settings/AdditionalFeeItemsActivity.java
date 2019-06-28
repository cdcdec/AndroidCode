package com.laiqian.scanorder.settings;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.d.a;
import com.laiqian.scan_order_module.R;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.ab;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdditionalFeeItemsActivity extends ActivityRoot {
  ArrayList<n> diB;
  
  a diC;
  
  public AutoGridView diD;
  
  private f.a diE = new b(this);
  
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
  
  private ArrayList<n> aoP() {
    ArrayList arrayList = new ArrayList();
    try {
      if (a.AZ().Cn() == null)
        return new ArrayList(); 
      jSONException = new JSONArray(a.AZ().Cn());
      if (jSONException == null)
        return new ArrayList(); 
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return arrayList;
    } 
    byte b;
    for (b = 0; b < jSONException.length(); b++)
      arrayList.add(n.s(new JSONObject(String.valueOf(jSONException.get(b))))); 
    return arrayList;
  }
  
  private void setupViews() {
    this.diD = (AutoGridView)findViewById(R.id.gridview);
    this.diB = aoP();
    this.diC = new a(this, this, this.diB);
    this.diD.setAdapter(this.diC);
    this.diC.notifyDataSetChanged();
  }
  
  public void a(n paramn) {
    f f = new f(this, paramn);
    f.a(this.diE);
    f.show();
  }
  
  public void onBackPressed() {
    setResult(-1, new Intent());
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(R.layout.activity_additional_fee_items);
    setTitleTextViewHideRightView(getString(R.string.additional_fees));
    findViewById(R.id.title_back).setOnClickListener(new a(this));
    setupViews();
  }
  
  public class a extends BaseAdapter {
    Context context;
    
    List<n> diG;
    
    public a(AdditionalFeeItemsActivity this$0, Context param1Context, List<n> param1List) {
      this.context = param1Context;
      this.diG = param1List;
      if (param1List == null)
        throw new InvalidParameterException(); 
    }
    
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
        a1.aQG.setOnClickListener(new c(this));
        return param1View;
      } 
      a1.b(ka(param1Int));
      a1.aQG.setOnClickListener(new d(this, param1Int));
      return param1View;
    }
    
    public n ka(int param1Int) { return (param1Int == this.diG.size()) ? null : (n)this.diG.get(param1Int); }
    
    public void notifyDataSetChanged() {
      Collections.sort(this.diG, new e(this));
      super.notifyDataSetChanged();
    }
    
    public class a {
      public View aQG;
      
      public TextView ccm;
      
      public TextView cvM;
      
      public ViewGroup cvN;
      
      public TextView cvO;
      
      public a(AdditionalFeeItemsActivity.a this$0, View param2View) {
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
          stringBuilder.append(String.format(this.diH.diF.getString(R.string.fees), new Object[] { n.b(this.diH.diF, Double.valueOf(param2n.AO()), true, false) }));
          stringBuilder.append(this.diH.diF.getString(R.string.unit));
          textView.setText(stringBuilder.toString());
        } else if (param2n.getType() == 0) {
          this.cvO.setText(String.format(this.diH.diF.getString(R.string.fees), new Object[] { n.b(this.diH.diF, Double.valueOf(param2n.AO()), true, false) }));
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
    
    public a(AdditionalFeeItemsActivity this$0, View param1View) {
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
        stringBuilder.append(String.format(this.diH.diF.getString(R.string.fees), new Object[] { n.b(this.diH.diF, Double.valueOf(param1n.AO()), true, false) }));
        stringBuilder.append(this.diH.diF.getString(R.string.unit));
        textView.setText(stringBuilder.toString());
      } else if (param1n.getType() == 0) {
        this.cvO.setText(String.format(this.diH.diF.getString(R.string.fees), new Object[] { n.b(this.diH.diF, Double.valueOf(param1n.AO()), true, false) }));
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
    
    b(AdditionalFeeItemsActivity this$0, Dialog param1Dialog, String param1String, double param1Double, int param1Int) {
      this.cvP = param1Dialog;
      this.name = param1String;
      this.type = param1Int;
      this.aJW = param1Double;
    }
    
    private boolean SI() { // Byte code:
      //   0: aload_0
      //   1: getfield diF : Lcom/laiqian/scanorder/settings/AdditionalFeeItemsActivity;
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
      //   62: getfield diF : Lcom/laiqian/scanorder/settings/AdditionalFeeItemsActivity;
      //   65: invokestatic bH : (Landroid/content/Context;)Z
      //   68: ifne -> 79
      //   71: getstatic com/laiqian/scan_order_module/R$string.please_check_network : I
      //   74: invokestatic eP : (I)V
      //   77: iconst_0
      //   78: ireturn
      //   79: iconst_1
      //   80: ireturn }
    
    protected void b(Boolean param1Boolean) {
      ab.P(this.diF.getActivity());
      if (this.bBY) {
        if (param1Boolean.booleanValue()) {
          n.eP(R.string.add_success);
          this.diF.diB.add(new n(this.type, this.name, this.aJW));
          this.diF.diC.notifyDataSetChanged();
          this.cvP.dismiss();
          return;
        } 
        a.AZ().cd(AdditionalFeeItemsActivity.a(this.diF, this.diF.diB).toString());
        n.eP(R.string.add_failed);
      } 
    }
    
    protected Boolean g(Void... param1VarArgs) {
      if (this.bBY) {
        ArrayList arrayList = (ArrayList)this.diF.diB.clone();
        arrayList.add(new n(this.type, this.name, this.aJW));
        a.AZ().cd(AdditionalFeeItemsActivity.a(this.diF, arrayList).toString());
        return Boolean.valueOf(a.AZ().Cj());
      } 
      return Boolean.valueOf(false);
    }
    
    protected void onPreExecute() {
      ab.N(this.diF.getActivity());
      this.bBY = SI();
    }
  }
  
  private class c extends AsyncTask<Void, Void, Boolean> {
    boolean bBY = false;
    
    private Dialog cvP;
    
    n diI;
    
    c(AdditionalFeeItemsActivity this$0, Dialog param1Dialog, n param1n) {
      this.cvP = param1Dialog;
      this.diI = param1n;
    }
    
    private boolean SI() {
      if (!bd.bH(this.diF)) {
        n.eP(R.string.please_check_network);
        return false;
      } 
      return true;
    }
    
    protected void b(Boolean param1Boolean) {
      if (this.bBY) {
        ab.P(this.diF.getActivity());
        if (param1Boolean.booleanValue()) {
          n.eP(R.string.delete_success);
          this.diF.diB.remove(this.diI);
          this.diF.diC.notifyDataSetChanged();
          this.cvP.dismiss();
          return;
        } 
        a.AZ().cd(AdditionalFeeItemsActivity.a(this.diF, this.diF.diB).toString());
        n.eP(R.string.delete_failed);
      } 
    }
    
    protected Boolean g(Void... param1VarArgs) {
      if (this.bBY) {
        n n1;
        ArrayList arrayList = (ArrayList)this.diF.diB.clone();
        Iterator iterator = arrayList.iterator();
        param1VarArgs = null;
        while (iterator.hasNext()) {
          n n2 = (n)iterator.next();
          if (n2.equals(this.diI))
            n1 = n2; 
        } 
        if (n1 != null) {
          arrayList.remove(n1);
          a.AZ().cd(AdditionalFeeItemsActivity.a(this.diF, arrayList).toString());
          return Boolean.valueOf(a.AZ().Cj());
        } 
        return null;
      } 
      return null;
    }
    
    protected void onPreExecute() {
      this.bBY = SI();
      if (this.bBY)
        ab.N(this.diF.getActivity()); 
    }
  }
  
  private class d extends AsyncTask<Void, Void, Boolean> {
    double aJW;
    
    boolean bBY = false;
    
    private Dialog cvP;
    
    n diI;
    
    String name;
    
    int type;
    
    d(AdditionalFeeItemsActivity this$0, Dialog param1Dialog, n param1n, String param1String, double param1Double, int param1Int) {
      this.cvP = param1Dialog;
      this.diI = param1n;
      this.name = param1String;
      this.aJW = param1Double;
      this.type = param1Int;
    }
    
    private boolean SI() { // Byte code:
      //   0: aload_0
      //   1: getfield diF : Lcom/laiqian/scanorder/settings/AdditionalFeeItemsActivity;
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
      //   75: getfield diF : Lcom/laiqian/scanorder/settings/AdditionalFeeItemsActivity;
      //   78: invokestatic bH : (Landroid/content/Context;)Z
      //   81: ifne -> 92
      //   84: getstatic com/laiqian/scan_order_module/R$string.please_check_network : I
      //   87: invokestatic eP : (I)V
      //   90: iconst_0
      //   91: ireturn
      //   92: iconst_1
      //   93: ireturn }
    
    protected void b(Boolean param1Boolean) {
      ab.P(this.diF.getActivity());
      if (this.bBY) {
        if (param1Boolean.booleanValue()) {
          n.eP(R.string.upload_success);
          this.diI.aG(this.aJW);
          this.diI.setName(this.name);
          this.diI.setType(this.type);
          this.diF.diC.notifyDataSetChanged();
          this.cvP.dismiss();
          return;
        } 
        a.AZ().cd(AdditionalFeeItemsActivity.a(this.diF, this.diF.diB).toString());
        n.eP(R.string.upload_failed);
      } 
    }
    
    protected Boolean g(Void... param1VarArgs) {
      if (this.bBY) {
        n n1;
        ArrayList arrayList = (ArrayList)this.diF.diB.clone();
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
          a.AZ().cd(AdditionalFeeItemsActivity.a(this.diF, arrayList).toString());
          return Boolean.valueOf(a.AZ().Cj());
        } 
        return null;
      } 
      return null;
    }
    
    protected void onPreExecute() {
      ab.N(this.diF.getActivity());
      this.bBY = SI();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\AdditionalFeeItemsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */