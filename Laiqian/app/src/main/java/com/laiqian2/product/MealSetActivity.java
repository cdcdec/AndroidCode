package com.laiqian.product;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.laiqian.d.a;
import com.laiqian.product.models.a;
import com.laiqian.product.models.g;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.m;
import com.laiqian.util.n;
import java.util.ArrayList;

public class MealSetActivity extends ActivityRoot {
  private k cOJ;
  
  private a cOK;
  
  private View cOL;
  
  private View cOM;
  
  private ListView cON;
  
  private TextView cOO;
  
  private TextView cOP;
  
  private TextView cOQ;
  
  private View cOR;
  
  private View cOS;
  
  private final int cOT = 1;
  
  private final String cOU = "productItemIndex";
  
  private View cOV;
  
  private ViewGroup cOW;
  
  private ArrayList<View> cOX;
  
  View.OnClickListener cOY = new h(this);
  
  View.OnClickListener cOZ = new i(this);
  
  private final int cgU = 2;
  
  private void a(View paramView, a.a parama) {
    b b;
    if (parama == null)
      return; 
    long[] arrayOfLong = parama.cPh;
    String[] arrayOfString = parama.cPi;
    int i = parama.cUu;
    if (arrayOfString == null || arrayOfLong == null || arrayOfLong.length == 0 || arrayOfString.length == 0) {
      if (paramView != null)
        cI(paramView); 
      return;
    } 
    if (paramView == null) {
      paramView = ajl();
      if (paramView == null) {
        n.println("添加商品的时候，创建了一个item");
        View view1 = View.inflate(this, 2131427950, null);
        null = (TextView)view1.findViewById(2131298607);
        TextView textView = (TextView)view1.findViewById(2131298649);
        EditText editText = (EditText)view1.findViewById(2131298651);
        View view3 = view1.findViewById(2131298300);
        View view2 = view3.findViewById(2131296858);
        view3 = view3.findViewById(2131299903);
        b = new b(this, view1, null, textView, editText, view2, view3);
        view1.setOnClickListener(this.cOZ);
        view2.setOnClickListener(this.cOY);
        view3.setOnClickListener(this.cOZ);
        view1.setTag(b);
        this.cOW.addView(view1);
      } else {
        n.println("添加商品的时候，从内容中拿一个item");
        b = (b)b.getTag();
      } 
    } else {
      b = (b)b.getTag();
    } 
    b.bjG.setText(arrayOfString[0]);
    for (byte b1 = 1; b1 < arrayOfString.length; b1++) {
      TextView textView = b.bjG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(", ");
      stringBuilder.append(arrayOfString[b1]);
      textView.append(stringBuilder.toString());
    } 
    b.bki.setText(String.valueOf(arrayOfString.length));
    b.cPf.setText(String.valueOf(i));
    b.cPh = arrayOfLong;
    b.cPi = arrayOfString;
  }
  
  private void ajj() {
    View view1 = findViewById(2131298737);
    View view2 = view1.findViewById(2131298742);
    this.cOO = (TextView)view2.findViewById(2131298202).findViewById(2131298198);
    this.cOP = (TextView)view2.findViewById(2131298478).findViewById(2131298473);
    view2 = view2.findViewById(2131298482);
    this.cOQ = (TextView)view2.findViewById(2131298481);
    if (a.AZ().Bx()) {
      view2.setVisibility(8);
    } else {
      view2.setVisibility(0);
    } 
    Intent intent = new Intent(this, ProductList.class);
    intent.putExtra("productIDs", new long[0]);
    m.c c = new m.c(this, intent, true);
    this.cOR = view1.findViewById(2131296331);
    this.cOR.setOnClickListener(c);
    this.cOS = view1.findViewById(2131296332);
    this.cOS.setOnClickListener(c);
    this.cOV = view1.findViewById(2131298934);
    this.cOW = (ViewGroup)this.cOV.findViewById(2131298933);
    this.cOX = new ArrayList();
  }
  
  private void ajk() {
    if (a.b(this.cOK)) {
      n.eP(2131628397);
      n.R(this);
    } 
  }
  
  private View ajl() {
    if (this.cOX.isEmpty())
      return null; 
    View view = (View)this.cOX.remove(0);
    this.cOW.addView(view);
    return view;
  }
  
  private void ajm() {
    while (this.cOW.getChildCount() > 0) {
      this.cOX.add(this.cOW.getChildAt(0));
      this.cOW.removeViewAt(0);
    } 
  }
  
  private void ajn() {
    if (this.cOW.getChildCount() == 0) {
      this.cOR.setVisibility(0);
      this.cOS.setVisibility(8);
      this.cOV.setVisibility(8);
      return;
    } 
    this.cOR.setVisibility(8);
    this.cOS.setVisibility(0);
    this.cOV.setVisibility(0);
    for (byte b = 0; b < this.cOW.getChildCount(); b++) {
      boolean bool;
      View view = this.cOW.getChildAt(b);
      if (b % 2 == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      view.setSelected(bool);
    } 
  }
  
  private void cI(View paramView) {
    this.cOW.removeView(paramView);
    this.cOX.add(paramView);
  }
  
  private b cJ(View paramView) {
    Object object = paramView.getTag();
    if (object != null && object instanceof b)
      return (b)object; 
    ViewParent viewParent = paramView.getParent();
    return (viewParent instanceof View) ? cJ((View)viewParent) : null;
  }
  
  private void d(a parama) {
    if (parama == null)
      return; 
    ajm();
    this.cOO.setText(parama.name);
    this.cOP.setText(String.valueOf(parama.akI()));
    this.cOQ.setText(String.valueOf(parama.akK()));
    for (byte b = 0; b < parama.akr(); b++)
      a(null, parama.jt(b)); 
    ajn();
  }
  
  private void ji(int paramInt) {
    if (paramInt >= this.cOK.getCount())
      return; 
    boolean bool = this.cON.isSoundEffectsEnabled();
    if (bool)
      this.cON.setSoundEffectsEnabled(false); 
    this.cON.performItemClick(null, this.cON.getHeaderViewsCount() + paramInt, 0L);
    this.cON.setSoundEffectsEnabled(bool);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
      return; 
    if (paramInt1 == 1 || paramInt1 == 2) {
      long[] arrayOfLong = paramIntent.getLongArrayExtra("IDs");
      String[] arrayOfString = paramIntent.getStringArrayExtra("names");
      switch (paramInt1) {
        case 2:
          paramInt1 = paramIntent.getIntExtra("productItemIndex", -1);
          if (paramInt1 == -1) {
            n.o("修改商品失败");
            break;
          } 
          a(this.cOW.getChildAt(paramInt1), new a.a(arrayOfLong, arrayOfString, true));
          break;
        case 1:
          if (arrayOfLong != null && arrayOfString != null)
            for (paramInt1 = 0; paramInt1 < arrayOfLong.length; paramInt1++) {
              long l = arrayOfLong[paramInt1];
              String str = arrayOfString[paramInt1];
              a(null, new a.a(new long[] { l }, new String[] { str }, true));
            }  
          break;
      } 
      ajn();
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetNoTitle(2131427947);
    d d = new d(this);
    View view2 = findViewById(2131299250);
    this.cOL = view2.findViewById(2131299246);
    this.cOL.setOnClickListener(d);
    this.cOM = view2.findViewById(2131299263);
    this.cOM.setOnClickListener(new e(this));
    this.cOJ = new k(this, new f(this));
    view2 = findViewById(2131298222);
    view2.findViewById(2131298221).setOnClickListener(d);
    this.cON = (ListView)findViewById(2131297776);
    this.cON.setEmptyView(view2);
    View view1 = View.inflate(this, 2131427731, null);
    view1.setClickable(true);
    this.cON.addHeaderView(view1);
    this.cOK = new a(this, null);
    this.cON.setAdapter(this.cOK);
    this.cON.setOnItemClickListener(new g(this));
    ajj();
    if (this.cOK.getCount() > 0)
      ji(0); 
  }
  
  private class a extends BaseAdapter {
    ArrayList<a> bjv;
    
    g cPb;
    
    View.OnClickListener cdm = new j(this);
    
    private a(MealSetActivity this$0) {
      this.cPb = new g(this$0);
      YQ();
    }
    
    private void YQ() {
      this.bjv = this.cPb.gr(false);
      if (this.bjv.isEmpty()) {
        MealSetActivity.e(this.cPa).setVisibility(8);
        MealSetActivity.f(this.cPa).setVisibility(8);
      } else {
        MealSetActivity.e(this.cPa).setVisibility(0);
        MealSetActivity.f(this.cPa).setVisibility(0);
      } 
      notifyDataSetChanged();
    }
    
    private boolean ajo() {
      a a1 = (a)MealSetActivity.g(this.cPa).getItemAtPosition(MealSetActivity.g(this.cPa).getCheckedItemPosition());
      if (a1 == null) {
        n.eP(2131628396);
        return false;
      } 
      int i = MealSetActivity.d(this.cPa).getChildCount();
      a1.aks();
      for (byte b = 0; b < i; b++) {
        MealSetActivity.b b1 = (MealSetActivity.b)MealSetActivity.d(this.cPa).getChildAt(b).getTag();
        String str1 = b1.cPf.getText().toString();
        if (str1.length() == 0) {
          n.eP(2131627542);
          return false;
        } 
        int j = n.parseInt(str1, 1);
        if (j <= 0) {
          n.eP(2131627548);
          return false;
        } 
        if (!a1.a(new a.a(b1.cPh, b1.cPi, j))) {
          n.eP(2131627536);
          return false;
        } 
      } 
      String str = a1.akt();
      boolean bool = this.cPb.o(a1.aSW, str);
      if (bool) {
        a1.aku();
        this.cPa.sendBroadcast(new Intent("pos_activity_change_data_producttype"));
        return bool;
      } 
      n.o("保存数据库时，失败");
      return bool;
    }
    
    private int cD(long param1Long) {
      for (byte b = 0; b < getCount(); b++) {
        if ((jj(b)).aSW == param1Long)
          return b; 
      } 
      return 0;
    }
    
    public int getCount() { return this.bjv.size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a2;
      a a1;
      if (param1View == null) {
        a2 = View.inflate(this.cPa, 2131427949, null);
        null = (TextView)a2.findViewById(2131298198);
        View view = a2.findViewById(2131299903);
        view.setOnClickListener(this.cdm);
        a1 = new a(this, null, view);
        a2.setTag(a1);
      } else {
        a a4 = (a)a1.getTag();
        a2 = a1;
        a1 = a4;
      } 
      a a3 = jj(param1Int);
      a1.ccm.setText(a3.name);
      a1.cPd.setTag(Integer.valueOf(param1Int));
      return a2;
    }
    
    public a jj(int param1Int) { return (a)this.bjv.get(param1Int); }
    
    class a {
      View cPd;
      
      TextView ccm;
      
      public a(MealSetActivity.a this$0, TextView param2TextView, View param2View) {
        this.ccm = param2TextView;
        this.cPd = param2View;
      }
    }
  }
  
  class a {
    View cPd;
    
    TextView ccm;
    
    public a(MealSetActivity this$0, TextView param1TextView, View param1View) {
      this.ccm = param1TextView;
      this.cPd = param1View;
    }
  }
  
  private class b {
    View bjA;
    
    TextView bjG;
    
    TextView bki;
    
    View cPe;
    
    EditText cPf;
    
    View cPg;
    
    long[] cPh;
    
    String[] cPi;
    
    public b(MealSetActivity this$0, View param1View1, TextView param1TextView1, TextView param1TextView2, EditText param1EditText, View param1View2, View param1View3) {
      this.cPe = param1View1;
      this.bjG = param1TextView1;
      this.bki = param1TextView2;
      this.cPf = param1EditText;
      this.cPg = param1View2;
      this.bjA = param1View3;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\MealSetActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */