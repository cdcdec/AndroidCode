package com.laiqian.report.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import com.laiqian.report.models.m;
import com.laiqian.report.models.u;
import com.laiqian.ui.a.ax;
import com.laiqian.ui.layout.SimultaneousRollingView;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;

public class PeriodProductReport extends ReportRoot {
  private SimultaneousRollingView dfe;
  
  private View[] dff;
  
  private TextView dfg;
  
  private TextView dfh;
  
  private ax dfi;
  
  private int dfj;
  
  private int dfk;
  
  private void AH() {
    an an = new an(this);
    ViewGroup viewGroup = (ViewGroup)findViewById(2131298817);
    byte b = 0;
    viewGroup.setVisibility(0);
    View view = View.inflate(this, 2131427993, null);
    view.findViewById(2131297758).setVisibility(0);
    view.setClickable(true);
    view.findViewById(2131298402).setBackgroundResource(2131099910);
    view.setOnTouchListener(an);
    viewGroup.addView(view);
    this.dfe = (SimultaneousRollingView)view.findViewById(2131298995);
    viewGroup = (ViewGroup)this.dfe.findViewById(2131299237);
    int i = viewGroup.getChildCount();
    this.dff = new View[i];
    while (b < i) {
      view = viewGroup.getChildAt(b);
      view.setTag(view.findViewById(2131299211));
      this.dff[b] = view;
      b++;
    } 
    this.bWY.setAdapter(new a(this, new ArrayList()));
    this.bWY.setEmptyView(findViewById(2131298220));
    this.bWY.setOnTouchListener(an);
  }
  
  private void aod() {
    ViewGroup viewGroup = (ViewGroup)findViewById(2131296820);
    byte b = 0;
    viewGroup.setVisibility(0);
    View view2 = View.inflate(this, 2131427992, null);
    viewGroup.addView(view2);
    this.dfj = getLaiqianPreferenceManager().avB();
    this.dfk = getLaiqianPreferenceManager().avC();
    String[] arrayOfString = new String[24];
    while (b < arrayOfString.length) {
      Integer integer;
      StringBuilder stringBuilder = new StringBuilder();
      if (b < 10) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("0");
        stringBuilder1.append(b);
        integer = stringBuilder1.toString();
      } else {
        integer = Integer.valueOf(b);
      } 
      stringBuilder.append(integer);
      stringBuilder.append(":00");
      arrayOfString[b] = stringBuilder.toString();
      b++;
    } 
    this.dfi = new ax(this, arrayOfString, new ak(this));
    View view1 = view2.findViewById(2131296661);
    this.dfg = (TextView)view1.findViewById(2131296660);
    this.dfg.setText(arrayOfString[this.dfj]);
    this.dfg.setTag(Integer.valueOf(this.dfj));
    view1.setOnClickListener(new al(this));
    view1 = view2.findViewById(2131296663);
    this.dfh = (TextView)view1.findViewById(2131296662);
    this.dfh.setText(arrayOfString[this.dfk]);
    this.dfh.setTag(Integer.valueOf(this.dfk));
    view1.setOnClickListener(new am(this));
  }
  
  @NonNull
  protected u AI() { return new m(this); }
  
  protected void AJ() {
    n.println("这里是showData()");
    aaQ();
    gE(true);
    (new ReportRoot.d(this, true)).start();
  }
  
  protected void a(u paramu) {
    super.a(paramu);
    int i = ((Number)this.dfg.getTag()).intValue();
    int j = ((Number)this.dfh.getTag()).intValue();
    ((m)paramu).bx(i, j);
  }
  
  protected void a(boolean paramBoolean, ArrayList<HashMap<String, String>> paramArrayList, int paramInt) {
    if (paramBoolean) {
      null = (m)this.dfV;
      if (null == null)
        return; 
      this.dfe.smoothScrollTo(0, 0);
      String[] arrayOfString = null.amJ();
      int i = this.dff.length;
      for (paramInt = 0; paramInt < i; paramInt++) {
        if (paramInt < arrayOfString.length) {
          this.dff[paramInt].setVisibility(0);
          ((TextView)this.dff[paramInt].getTag()).setText(arrayOfString[paramInt]);
        } else {
          this.dff[paramInt].setVisibility(8);
        } 
      } 
    } 
  }
  
  protected boolean anD() {
    if (aom() == 1) {
      setResult(-1);
      finish();
      return true;
    } 
    return super.anD();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setTitleTextViewHideRightView(2131627927);
    n(0, true);
    jY(0);
    AH();
    aod();
    a(getResources().getStringArray(2130903079), new int[] { 1, 2 }, 2);
    AJ();
  }
  
  protected void onDestroy() {
    int i = ((Number)this.dfg.getTag()).intValue();
    if (i != this.dfj)
      getLaiqianPreferenceManager().lZ(i); 
    i = ((Number)this.dfh.getTag()).intValue();
    if (i != this.dfk)
      getLaiqianPreferenceManager().ma(i); 
    super.onDestroy();
  }
  
  class a extends ReportRoot.i {
    a(PeriodProductReport this$0, ArrayList<HashMap<String, String>> param1ArrayList) { super(this$0, param1ArrayList, 2131427993, null, null); }
    
    public void a(ReportRoot.i.a param1a, View param1View, HashMap<String, String> param1HashMap, int param1Int) {
      boolean bool;
      if (param1Int % 2 != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      param1View.setEnabled(bool);
      param1a = (a)param1a;
      param1a.bjG.setText((CharSequence)param1HashMap.get(m.daN));
      int j = param1a.dfm.length;
      String[] arrayOfString = ((m)this.dfl.dfV).amJ();
      for (param1Int = 0; param1Int < j; param1Int++) {
        if (param1Int < arrayOfString.length) {
          String str = (String)param1HashMap.get(arrayOfString[param1Int]);
          param1a.dfm[param1Int].setVisibility(0);
          ((TextView)param1a.dfm[param1Int].getTag()).setText(str);
        } else {
          param1a.dfm[param1Int].setVisibility(8);
        } 
      } 
    }
    
    public ReportRoot.i.a bJ(View param1View) {
      TextView textView = (TextView)param1View.findViewById(2131298563).findViewById(2131299211);
      ViewGroup viewGroup = (ViewGroup)param1View.findViewById(2131299237);
      int j = viewGroup.getChildCount();
      View[] arrayOfView = new View[j];
      for (byte b = 0; b < j; b++) {
        View view = viewGroup.getChildAt(b);
        view.setTag(view.findViewById(2131299211));
        arrayOfView[b] = view;
      } 
      HorizontalScrollView horizontalScrollView = (HorizontalScrollView)param1View.findViewById(2131298995);
      PeriodProductReport.d(this.dfl).a(horizontalScrollView);
      return new a(this, textView, arrayOfView);
    }
    
    class a extends ReportRoot.i.a {
      TextView bjG;
      
      View[] dfm;
      
      a(PeriodProductReport.a this$0, TextView param2TextView, View[] param2ArrayOfView) {
        super(this$0);
        this.bjG = param2TextView;
        this.dfm = param2ArrayOfView;
      }
    }
  }
  
  class a extends ReportRoot.i.a {
    TextView bjG;
    
    View[] dfm;
    
    a(PeriodProductReport this$0, TextView param1TextView, View[] param1ArrayOfView) {
      super(this$0);
      this.bjG = param1TextView;
      this.dfm = param1ArrayOfView;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\PeriodProductReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */