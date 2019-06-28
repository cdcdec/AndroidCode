package com.laiqian.pos.industry.weiorder;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.ab;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class WeshopCouponsActivity extends ActivityRoot {
  TextView ciq;
  
  private ei.a cvE = new ep(this);
  
  GridView cvG;
  
  ArrayList<eh> cvH;
  
  a cvI;
  
  public void a(eh parameh) {
    ei ei = new ei(this, parameh);
    ei.a(this.cvE);
    ei.show();
  }
  
  public ArrayList<eh> abO() {
    ArrayList arrayList2 = (ArrayList)getIntent().getSerializableExtra("couponList");
    ArrayList arrayList1 = arrayList2;
    if (arrayList2 == null)
      arrayList1 = new ArrayList(); 
    return arrayList1;
  }
  
  public void onBackPressed() {
    save();
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131427449);
    setTitleTextViewHideRightView(getString(2131630538));
    findViewById(2131299247).setOnClickListener(new eo(this));
    this.cvG = (GridView)findViewById(2131297188);
    this.ciq = (TextView)findViewById(2131299533);
    this.cvG.setEmptyView(this.ciq);
    this.cvH = abO();
    this.cvI = new a(this, this, this.cvH);
    this.cvG.setAdapter(this.cvI);
    this.cvI.notifyDataSetChanged();
  }
  
  boolean save() {
    Intent intent = new Intent();
    intent.putExtra("couponList", this.cvH);
    setResult(-1, intent);
    return true;
  }
  
  public class a extends BaseAdapter {
    Context context;
    
    List<eh> cvK;
    
    public a(WeshopCouponsActivity this$0, Context param1Context, List<eh> param1List) {
      this.context = param1Context;
      this.cvK = param1List;
      if (param1List == null)
        throw new InvalidParameterException(); 
    }
    
    public int getCount() { return this.cvK.size() + 1; }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a1;
      if (param1View == null) {
        param1View = LayoutInflater.from(this.context).inflate(2131427659, null);
        a1 = new a(this, param1View);
        param1View.setTag(a1);
      } else {
        a1 = (a)param1View.getTag();
      } 
      if (param1Int == this.cvK.size()) {
        a1.abP();
        a1.aQG.setOnClickListener(new eq(this));
        return param1View;
      } 
      a1.b(hh(param1Int));
      a1.aQG.setOnClickListener(new er(this, param1Int));
      return param1View;
    }
    
    public eh hh(int param1Int) { return (param1Int == this.cvK.size()) ? null : (eh)this.cvK.get(param1Int); }
    
    public void notifyDataSetChanged() {
      Collections.sort(this.cvK, new es(this));
      super.notifyDataSetChanged();
    }
    
    public class a {
      public View aQG;
      
      public TextView cvM;
      
      public ViewGroup cvN;
      
      public TextView cvO;
      
      public a(WeshopCouponsActivity.a this$0, View param2View) {
        this.aQG = param2View;
        this.cvM = (TextView)param2View.findViewById(2131299466);
        this.cvN = (ViewGroup)param2View.findViewById(2131297536);
        this.cvO = (TextView)param2View.findViewById(2131299813);
      }
      
      public void abP() {
        this.cvM.setVisibility(0);
        this.cvN.setVisibility(8);
      }
      
      public void b(eh param2eh) {
        this.cvM.setVisibility(8);
        this.cvN.setVisibility(0);
        this.cvO.setText(String.format(this.cvL.cvJ.getString(2131630537), new Object[] { n.b(this.cvL.cvJ, Double.valueOf(param2eh.abM()), false, false), n.b(this.cvL.cvJ, Double.valueOf(param2eh.FI()), false, false) }));
      }
    }
  }
  
  public class a {
    public View aQG;
    
    public TextView cvM;
    
    public ViewGroup cvN;
    
    public TextView cvO;
    
    public a(WeshopCouponsActivity this$0, View param1View) {
      this.aQG = param1View;
      this.cvM = (TextView)param1View.findViewById(2131299466);
      this.cvN = (ViewGroup)param1View.findViewById(2131297536);
      this.cvO = (TextView)param1View.findViewById(2131299813);
    }
    
    public void abP() {
      this.cvM.setVisibility(0);
      this.cvN.setVisibility(8);
    }
    
    public void b(eh param1eh) {
      this.cvM.setVisibility(8);
      this.cvN.setVisibility(0);
      this.cvO.setText(String.format(this.cvL.cvJ.getString(2131630537), new Object[] { n.b(this.cvL.cvJ, Double.valueOf(param1eh.abM()), false, false), n.b(this.cvL.cvJ, Double.valueOf(param1eh.FI()), false, false) }));
    }
  }
  
  private class b extends AsyncTask<Void, Void, String> {
    boolean bBY = false;
    
    double cvC;
    
    private Dialog cvP;
    
    double discount;
    
    b(WeshopCouponsActivity this$0, Dialog param1Dialog, double param1Double1, double param1Double2) {
      this.cvP = param1Dialog;
      this.cvC = param1Double1;
      this.discount = param1Double2;
    }
    
    private boolean SI() { // Byte code:
      //   0: aload_0
      //   1: getfield discount : D
      //   4: aload_0
      //   5: getfield cvC : D
      //   8: dcmpl
      //   9: iflt -> 34
      //   12: aload_0
      //   13: getfield cvJ : Lcom/laiqian/pos/industry/weiorder/WeshopCouponsActivity;
      //   16: aload_0
      //   17: getfield cvJ : Lcom/laiqian/pos/industry/weiorder/WeshopCouponsActivity;
      //   20: ldc 2131630534
      //   22: invokevirtual getString : (I)Ljava/lang/String;
      //   25: iconst_0
      //   26: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
      //   29: invokevirtual show : ()V
      //   32: iconst_0
      //   33: ireturn
      //   34: aload_0
      //   35: getfield cvJ : Lcom/laiqian/pos/industry/weiorder/WeshopCouponsActivity;
      //   38: getfield cvH : Ljava/util/ArrayList;
      //   41: invokevirtual iterator : ()Ljava/util/Iterator;
      //   44: astore_2
      //   45: aload_2
      //   46: invokeinterface hasNext : ()Z
      //   51: ifeq -> 79
      //   54: aload_2
      //   55: invokeinterface next : ()Ljava/lang/Object;
      //   60: checkcast com/laiqian/pos/industry/weiorder/eh
      //   63: invokevirtual abM : ()D
      //   66: aload_0
      //   67: getfield cvC : D
      //   70: dcmpl
      //   71: ifne -> 45
      //   74: iconst_1
      //   75: istore_1
      //   76: goto -> 81
      //   79: iconst_0
      //   80: istore_1
      //   81: iload_1
      //   82: ifeq -> 107
      //   85: aload_0
      //   86: getfield cvJ : Lcom/laiqian/pos/industry/weiorder/WeshopCouponsActivity;
      //   89: aload_0
      //   90: getfield cvJ : Lcom/laiqian/pos/industry/weiorder/WeshopCouponsActivity;
      //   93: ldc 2131630533
      //   95: invokevirtual getString : (I)Ljava/lang/String;
      //   98: iconst_0
      //   99: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
      //   102: invokevirtual show : ()V
      //   105: iconst_0
      //   106: ireturn
      //   107: aload_0
      //   108: getfield cvJ : Lcom/laiqian/pos/industry/weiorder/WeshopCouponsActivity;
      //   111: invokestatic bH : (Landroid/content/Context;)Z
      //   114: ifne -> 139
      //   117: aload_0
      //   118: getfield cvJ : Lcom/laiqian/pos/industry/weiorder/WeshopCouponsActivity;
      //   121: aload_0
      //   122: getfield cvJ : Lcom/laiqian/pos/industry/weiorder/WeshopCouponsActivity;
      //   125: ldc 2131626280
      //   127: invokevirtual getString : (I)Ljava/lang/String;
      //   130: iconst_0
      //   131: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
      //   134: invokevirtual show : ()V
      //   137: iconst_0
      //   138: ireturn
      //   139: iconst_1
      //   140: ireturn }
    
    protected String b(Void... param1VarArgs) {
      if (this.bBY) {
        ArrayList arrayList = (ArrayList)this.cvJ.cvH.clone();
        arrayList.add(new eh(this.cvC, this.discount));
        return fp.aX(this.cvJ).ag(arrayList);
      } 
      return null;
    }
    
    protected void bf(String param1String) {
      ab.P(this.cvJ);
      if (this.bBY) {
        if ("success".equals(param1String)) {
          Toast.makeText(this.cvJ, this.cvJ.getString(2131630530), 0).show();
          this.cvJ.cvH.add(new eh(this.cvC, this.discount));
          this.cvJ.cvI.notifyDataSetChanged();
          this.cvP.dismiss();
          return;
        } 
        Toast.makeText(this.cvJ, this.cvJ.getString(2131630529), 0).show();
      } 
    }
    
    protected void onPreExecute() {
      ab.N(this.cvJ);
      this.bBY = SI();
    }
  }
  
  private class c extends AsyncTask<Void, Void, String> {
    boolean bBY = false;
    
    eh cvD;
    
    private Dialog cvP;
    
    c(WeshopCouponsActivity this$0, Dialog param1Dialog, eh param1eh) {
      this.cvP = param1Dialog;
      this.cvD = param1eh;
    }
    
    private boolean SI() {
      if (!bd.bH(this.cvJ)) {
        Toast.makeText(this.cvJ, this.cvJ.getString(2131626280), 0).show();
        return false;
      } 
      return true;
    }
    
    protected String b(Void... param1VarArgs) {
      if (this.bBY) {
        eh eh1;
        ArrayList arrayList = (ArrayList)this.cvJ.cvH.clone();
        Iterator iterator = arrayList.iterator();
        param1VarArgs = null;
        while (iterator.hasNext()) {
          eh eh2 = (eh)iterator.next();
          if (eh2.equals(this.cvD))
            eh1 = eh2; 
        } 
        if (eh1 != null) {
          arrayList.remove(eh1);
          return fp.aX(this.cvJ).ag(arrayList);
        } 
        return null;
      } 
      return null;
    }
    
    protected void bf(String param1String) {
      if (this.bBY) {
        ab.P(this.cvJ);
        if ("success".equals(param1String)) {
          Toast.makeText(this.cvJ, this.cvJ.getString(2131630563), 0).show();
          this.cvJ.cvH.remove(this.cvD);
          this.cvJ.cvI.notifyDataSetChanged();
          this.cvP.dismiss();
          return;
        } 
        Toast.makeText(this.cvJ, this.cvJ.getString(2131630562), 0).show();
      } 
    }
    
    protected void onPreExecute() {
      this.bBY = SI();
      if (this.bBY)
        ab.N(this.cvJ); 
    }
  }
  
  private class d extends AsyncTask<Void, Void, String> {
    boolean bBY = false;
    
    double cvC;
    
    eh cvD;
    
    private Dialog cvP;
    
    double discount;
    
    d(WeshopCouponsActivity this$0, Dialog param1Dialog, eh param1eh, double param1Double1, double param1Double2) {
      this.cvP = param1Dialog;
      this.cvD = param1eh;
      this.cvC = param1Double1;
      this.discount = param1Double2;
    }
    
    private boolean SI() { // Byte code:
      //   0: aload_0
      //   1: getfield discount : D
      //   4: aload_0
      //   5: getfield cvC : D
      //   8: dcmpl
      //   9: iflt -> 34
      //   12: aload_0
      //   13: getfield cvJ : Lcom/laiqian/pos/industry/weiorder/WeshopCouponsActivity;
      //   16: aload_0
      //   17: getfield cvJ : Lcom/laiqian/pos/industry/weiorder/WeshopCouponsActivity;
      //   20: ldc 2131630534
      //   22: invokevirtual getString : (I)Ljava/lang/String;
      //   25: iconst_0
      //   26: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
      //   29: invokevirtual show : ()V
      //   32: iconst_0
      //   33: ireturn
      //   34: aload_0
      //   35: getfield cvJ : Lcom/laiqian/pos/industry/weiorder/WeshopCouponsActivity;
      //   38: getfield cvH : Ljava/util/ArrayList;
      //   41: invokevirtual iterator : ()Ljava/util/Iterator;
      //   44: astore_2
      //   45: aload_2
      //   46: invokeinterface hasNext : ()Z
      //   51: ifeq -> 92
      //   54: aload_2
      //   55: invokeinterface next : ()Ljava/lang/Object;
      //   60: checkcast com/laiqian/pos/industry/weiorder/eh
      //   63: astore_3
      //   64: aload_3
      //   65: aload_0
      //   66: getfield cvD : Lcom/laiqian/pos/industry/weiorder/eh;
      //   69: if_acmpne -> 75
      //   72: goto -> 45
      //   75: aload_3
      //   76: invokevirtual abM : ()D
      //   79: aload_0
      //   80: getfield cvC : D
      //   83: dcmpl
      //   84: ifne -> 45
      //   87: iconst_1
      //   88: istore_1
      //   89: goto -> 94
      //   92: iconst_0
      //   93: istore_1
      //   94: iload_1
      //   95: ifeq -> 120
      //   98: aload_0
      //   99: getfield cvJ : Lcom/laiqian/pos/industry/weiorder/WeshopCouponsActivity;
      //   102: aload_0
      //   103: getfield cvJ : Lcom/laiqian/pos/industry/weiorder/WeshopCouponsActivity;
      //   106: ldc 2131630533
      //   108: invokevirtual getString : (I)Ljava/lang/String;
      //   111: iconst_0
      //   112: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
      //   115: invokevirtual show : ()V
      //   118: iconst_0
      //   119: ireturn
      //   120: aload_0
      //   121: getfield cvJ : Lcom/laiqian/pos/industry/weiorder/WeshopCouponsActivity;
      //   124: invokestatic bH : (Landroid/content/Context;)Z
      //   127: ifne -> 152
      //   130: aload_0
      //   131: getfield cvJ : Lcom/laiqian/pos/industry/weiorder/WeshopCouponsActivity;
      //   134: aload_0
      //   135: getfield cvJ : Lcom/laiqian/pos/industry/weiorder/WeshopCouponsActivity;
      //   138: ldc 2131626280
      //   140: invokevirtual getString : (I)Ljava/lang/String;
      //   143: iconst_0
      //   144: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
      //   147: invokevirtual show : ()V
      //   150: iconst_0
      //   151: ireturn
      //   152: iconst_1
      //   153: ireturn }
    
    protected String b(Void... param1VarArgs) {
      if (this.bBY) {
        eh eh1;
        Iterator iterator = ((ArrayList)this.cvJ.cvH.clone()).iterator();
        param1VarArgs = null;
        while (iterator.hasNext()) {
          eh eh2 = (eh)iterator.next();
          if (this.cvD.equals(eh2))
            eh1 = eh2; 
        } 
        if (eh1 != null) {
          eh1.aC(this.cvC);
          eh1.p(this.discount);
          return fp.aX(this.cvJ).ag(this.cvJ.cvH);
        } 
        return null;
      } 
      return null;
    }
    
    protected void bf(String param1String) {
      ab.P(this.cvJ);
      if (this.bBY) {
        if ("success".equals(param1String)) {
          Toast.makeText(this.cvJ, this.cvJ.getString(2131630575), 0).show();
          this.cvD.aC(this.cvC);
          this.cvD.p(this.discount);
          this.cvJ.cvI.notifyDataSetChanged();
          this.cvP.dismiss();
          return;
        } 
        Toast.makeText(this.cvJ, this.cvJ.getString(2131630574), 0).show();
      } 
    }
    
    protected void onPreExecute() {
      ab.N(this.cvJ);
      this.bBY = SI();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\WeshopCouponsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */