package com.laiqian.news;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.d.a;
import com.laiqian.entity.aa;
import com.laiqian.models.ab;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.m;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.print.j;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.product.a.a;
import com.laiqian.product.models.h;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.r;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class NewsActivity extends ActivityRoot implements u {
  LinearLayout bWA;
  
  private final int bWa = -1;
  
  private int bWb = -1;
  
  private Button[] bWc;
  
  private RecyclerView bWd;
  
  private ImageView bWe;
  
  Button bWf;
  
  Button bWg;
  
  private q bWh;
  
  private o bWi;
  
  private x bWj;
  
  private ListView bWk;
  
  private LinearLayout bWl;
  
  private LinearLayout bWm;
  
  private LinearLayout bWn;
  
  private LinearLayout bWo;
  
  private LinearLayout bWp;
  
  private LinearLayout bWq;
  
  String bWr = "";
  
  RelativeLayout bWs;
  
  TextView bWt;
  
  TextView bWu;
  
  TextView bWv;
  
  RelativeLayout bWw;
  
  ImageView bWx;
  
  TextView bWy;
  
  TextView bWz;
  
  BroadcastReceiver blv = new c(this);
  
  private bb waitingDialog;
  
  private String a(PendingFullOrderDetail paramPendingFullOrderDetail, int paramInt) {
    Iterator iterator2 = paramPendingFullOrderDetail.coy.iterator();
    double d1 = 0.0D;
    while (iterator2.hasNext()) {
      PendingFullOrderDetail.d d3 = (PendingFullOrderDetail.d)iterator2.next();
      double d = d1;
      if (d3.aTU == 0) {
        d = d1;
        if (paramInt == 0)
          d = d1 + d3.cpo * d3.cpn; 
      } 
      d1 = d;
      if (d3.aTU == 1)
        d1 = d + d3.cpo * d3.cpn; 
    } 
    Iterator iterator1 = paramPendingFullOrderDetail.coz.iterator();
    double d2 = d1;
    label30: while (iterator1.hasNext()) {
      iterator2 = ((PendingFullOrderDetail.c)iterator1.next()).cpg.iterator();
      d1 = d2;
      while (true) {
        d2 = d1;
        if (iterator2.hasNext()) {
          PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)iterator2.next();
          d2 = d1;
          if (d.aTU == 0) {
            d2 = d1;
            if (paramInt == 0)
              d2 = d1 + d.cpo * d.cpn; 
          } 
          d1 = d2;
          if (d.aTU == 1)
            d1 = d2 + d.cpo * d.cpn; 
          continue;
        } 
        continue label30;
      } 
    } 
    return n.b(null, Double.valueOf(d2), true, true);
  }
  
  private aa convert(PendingFullOrderDetail.d paramd) {
    aa aa = new aa(new h(paramd.id, paramd.name, paramd.cpm, paramd.cpn, 0.0D, 600001, paramd.cpq, "", paramd.cpu, "", (int)paramd.cpx, 0.0D), new a(a.AZ().Cp()));
    if (paramd.cpl != null)
      aa.aq(paramd.cpl.longValue()); 
    aa.az(paramd.bbX);
    aa.ar(paramd.aTO);
    aa.cS(paramd.aTP);
    aa.q(paramd.cpo);
    aa.cV(true);
    aa.cW(false);
    aa.GD();
    aa.as(paramd.cpz);
    return aa;
  }
  
  private void gm(int paramInt) {
    pendingFullOrderDetail = this.bWi.WU();
    pendingFullOrderDetail.bXb.cpb = paramInt;
    if (pendingFullOrderDetail != null)
      try {
        List list = j.cCx.a(pendingFullOrderDetail, new String[] { "dish" });
        Iterator iterator = list.iterator();
        while (iterator.hasNext())
          ((e)iterator.next()).a(new m(this)); 
        g.cGS.o(list);
        return;
      } catch (Exception pendingFullOrderDetail) {
        a.e(pendingFullOrderDetail);
      }  
  }
  
  private void gn(int paramInt) {
    int i = paramInt;
    if (paramInt == -1)
      i = 0; 
    if (this.bWb == i)
      return; 
    this.bWb = i;
    go(i);
    gp(i);
  }
  
  private void go(int paramInt) {
    for (byte b = 0; b < this.bWc.length; b++) {
      boolean bool;
      if (paramInt == b) {
        bool = true;
      } else {
        bool = false;
      } 
      this.bWc[b].setSelected(bool ^ true);
      if (bool) {
        this.bWc[b].setTextColor(getResources().getColor(2131099898));
      } else {
        this.bWc[b].setTextColor(getResources().getColor(2131099936));
      } 
    } 
  }
  
  private void gp(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 1:
        this.bWh.gr(1);
        return;
      case 0:
        break;
    } 
    this.bWh.gr(0);
  }
  
  private void k(Collection<h> paramCollection) { this.bWj.a(paramCollection, false); }
  
  private void wR() {
    this.bWf = (Button)findViewById(2131296642);
    this.bWg = (Button)findViewById(2131296611);
    this.bWc = new Button[] { this.bWf, this.bWg };
    this.bWd = (RecyclerView)findViewById(2131298087);
    this.bWd.c(new LinearLayoutManager(this));
    this.bWe = (ImageView)findViewById(2131298706);
    this.bWk = (ListView)findViewById(2131298082);
    this.bWn = (LinearLayout)findViewById(2131297974);
    this.bWo = (LinearLayout)findViewById(2131297996);
    this.bWp = (LinearLayout)findViewById(2131297959);
    this.bWq = (LinearLayout)findViewById(2131297875);
    this.bWl = (LinearLayout)findViewById(2131297902);
    this.bWm = (LinearLayout)findViewById(2131297983);
    this.bWs = (RelativeLayout)LayoutInflater.from(this).inflate(2131428104, null);
    this.bWw = (RelativeLayout)this.bWs.findViewById(2131298778);
    this.bWt = (TextView)this.bWs.findViewById(2131299517);
    this.bWu = (TextView)this.bWs.findViewById(2131299633);
    this.bWv = (TextView)this.bWs.findViewById(2131299634);
    this.bWx = (ImageView)this.bWs.findViewById(2131297372);
    this.bWy = (TextView)this.bWs.findViewById(2131299542);
    this.bWk.addHeaderView(this.bWs);
    this.bWz = (TextView)findViewById(2131299611);
    this.bWA = (LinearLayout)findViewById(2131297905);
  }
  
  private void yP() { // Byte code:
    //   0: aload_0
    //   1: getfield bWc : [Landroid/widget/Button;
    //   4: astore_3
    //   5: aload_3
    //   6: arraylength
    //   7: istore_2
    //   8: iconst_0
    //   9: istore_1
    //   10: iload_1
    //   11: iload_2
    //   12: if_icmpge -> 36
    //   15: aload_3
    //   16: iload_1
    //   17: aaload
    //   18: new com/laiqian/news/NewsActivity$a
    //   21: dup
    //   22: aload_0
    //   23: invokespecial <init> : (Lcom/laiqian/news/NewsActivity;)V
    //   26: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   29: iload_1
    //   30: iconst_1
    //   31: iadd
    //   32: istore_1
    //   33: goto -> 10
    //   36: aload_0
    //   37: getfield bWe : Landroid/widget/ImageView;
    //   40: new com/laiqian/news/e
    //   43: dup
    //   44: aload_0
    //   45: invokespecial <init> : (Lcom/laiqian/news/NewsActivity;)V
    //   48: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   51: aload_0
    //   52: getfield bWq : Landroid/widget/LinearLayout;
    //   55: new com/laiqian/news/f
    //   58: dup
    //   59: aload_0
    //   60: invokespecial <init> : (Lcom/laiqian/news/NewsActivity;)V
    //   63: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   66: aload_0
    //   67: getfield bWl : Landroid/widget/LinearLayout;
    //   70: new com/laiqian/news/g
    //   73: dup
    //   74: aload_0
    //   75: invokespecial <init> : (Lcom/laiqian/news/NewsActivity;)V
    //   78: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   81: aload_0
    //   82: getfield bWm : Landroid/widget/LinearLayout;
    //   85: new com/laiqian/news/h
    //   88: dup
    //   89: aload_0
    //   90: invokespecial <init> : (Lcom/laiqian/news/NewsActivity;)V
    //   93: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   96: aload_0
    //   97: getfield bWn : Landroid/widget/LinearLayout;
    //   100: new com/laiqian/news/i
    //   103: dup
    //   104: aload_0
    //   105: invokespecial <init> : (Lcom/laiqian/news/NewsActivity;)V
    //   108: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   111: aload_0
    //   112: getfield bWo : Landroid/widget/LinearLayout;
    //   115: new com/laiqian/news/j
    //   118: dup
    //   119: aload_0
    //   120: invokespecial <init> : (Lcom/laiqian/news/NewsActivity;)V
    //   123: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   126: return }
  
  public void N(ArrayList<PendingFullOrderDetail> paramArrayList) {
    byte b1;
    String str;
    LinearLayout linearLayout = this.bWo;
    byte b2 = 8;
    linearLayout.setVisibility(8);
    this.bWp.setVisibility(8);
    this.bWq.setVisibility(8);
    this.bWw.setVisibility(8);
    linearLayout = this.bWA;
    if (paramArrayList != null && paramArrayList.size() > 0) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    linearLayout.setVisibility(b1);
    TextView textView = this.bWz;
    if (paramArrayList != null && paramArrayList.size() > 0) {
      b1 = b2;
    } else {
      b1 = 0;
    } 
    textView.setVisibility(b1);
    if (this.bWi == null) {
      this.bWi = new o(this, paramArrayList, this.bWd);
      this.bWi.gq(this.bWb);
      this.bWi.a(new a(this, paramArrayList));
      this.bWd.a(this.bWi);
      this.bWd.ko().q(0L);
      this.bWd.postDelayed(new d(this), 50L);
    } else {
      this.bWi.O(paramArrayList);
      this.bWi.gq(this.bWb);
      this.bWi.notifyDataSetChanged();
      if (this.bWj != null)
        this.bWj.WZ(); 
      if (this.bWi.getItemCount() > 0) {
        if (this.bWi.getPosition() != 0)
          this.bWi.bK(this.bWi.getPosition()); 
        this.bWi.setPosition(0);
        this.bWi.c(0, Integer.valueOf(1));
      } 
    } 
    switch (this.bWb) {
      default:
        return;
      case 1:
        button = this.bWg;
        stringBuilder = new StringBuilder();
        stringBuilder.append(getString(2131625094));
        if (this.bWi.getItemCount() > 0) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("(");
          stringBuilder1.append(this.bWi.getItemCount());
          stringBuilder1.append(")");
          str = stringBuilder1.toString();
        } else {
          str = "";
        } 
        stringBuilder.append(str);
        button.setText(stringBuilder.toString());
        return;
      case 0:
        break;
    } 
    Button button = this.bWf;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getString(2131626244));
    if (this.bWi.getItemCount() > 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("(");
      stringBuilder1.append(this.bWi.getItemCount());
      stringBuilder1.append(")");
      String str1 = stringBuilder1.toString();
    } else {
      str = "";
    } 
    stringBuilder.append(str);
    button.setText(stringBuilder.toString());
  }
  
  public void WT() {
    this.bWr = "";
    ArrayList arrayList = this.bWj.Xa();
    ab ab = new ab(this);
    String str1 = "";
    stringBuilder1 = "";
    for (byte b = 0; b < arrayList.size(); b++) {
      if (((aa)arrayList.get(b)).akM() != 4) {
        StringBuilder stringBuilder1;
        String str;
        StringBuilder stringBuilder2;
        Cursor cursor = ab.bp(((aa)arrayList.get(b)).aSW);
        if (cursor.moveToFirst()) {
          stringBuilder2 = stringBuilder1;
          str = str1;
          if (cursor.getInt(cursor.getColumnIndex("nProductStatus")) == 600002) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder1);
            stringBuilder.append(((aa)arrayList.get(b)).name);
            stringBuilder.append(",");
            String str4 = stringBuilder.toString();
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append(this.bWr);
            stringBuilder1.append(((aa)arrayList.get(b)).GS());
            stringBuilder1.append(",");
            this.bWr = stringBuilder1.toString();
            str = str1;
          } 
        } else {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(str1);
          stringBuilder2.append(((aa)arrayList.get(b)).name);
          stringBuilder2.append(",");
          str = stringBuilder2.toString();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.bWr);
          stringBuilder.append(((aa)arrayList.get(b)).GS());
          stringBuilder.append(",");
          this.bWr = stringBuilder.toString();
          stringBuilder2 = stringBuilder1;
        } 
        cursor.close();
        str1 = str;
        stringBuilder1 = stringBuilder2;
      } 
    } 
    String str3 = stringBuilder1;
    if (!TextUtils.isEmpty(stringBuilder1)) {
      String str;
      str3 = (str = stringBuilder1.substring(0, stringBuilder1.length() - 1)).format(getString(2131629037), new Object[] { str });
    } 
    String str2 = str1;
    if (!TextUtils.isEmpty(str1))
      str2 = (str1 = str1.substring(0, str1.length() - 1)).format(getString(2131629032), new Object[] { str1 }); 
    if (!TextUtils.isEmpty(this.bWr)) {
      this.bWr = this.bWr.substring(0, this.bWr.length() - 1);
      StringBuilder stringBuilder = new StringBuilder();
      if (TextUtils.isEmpty(str3)) {
        str1 = "";
      } else {
        String str4;
        null = new StringBuilder();
        null.append(str3);
        null.append(",");
        str = null.toString();
      } 
      stringBuilder.append(str);
      if (TextUtils.isEmpty(str2)) {
        str = "";
      } else {
        null = new StringBuilder();
        null.append(str2);
        null.append(",");
        str = null.toString();
      } 
      stringBuilder.append(str);
      stringBuilder.append(getString(2131624323));
      String str = stringBuilder.toString();
      r r = new r(this, new b(this));
      r.oZ(getString(2131629548));
      r.s(str);
      r.setTitle(2131626722);
      r.show();
      return;
    } 
    eu(false);
  }
  
  public void es(boolean paramBoolean) {
    this.bWl.setClickable(paramBoolean);
    this.bWl.setEnabled(paramBoolean);
  }
  
  public void et(boolean paramBoolean) {
    this.bWm.setClickable(paramBoolean);
    this.bWm.setEnabled(paramBoolean);
  }
  
  public void eu(boolean paramBoolean) {
    HashMap hashMap = new HashMap();
    hashMap.put("action", Integer.valueOf(1));
    hashMap.put("datetimes", this.bWh.a(this.bWj.WY()));
    hashMap.put("table_id", (this.bWj.WV()).coJ);
    hashMap.put("releated_id", Long.valueOf((this.bWj.WV()).bZP));
    if (!TextUtils.isEmpty(this.bWr) && paramBoolean)
      hashMap.put("refuse_ids", this.bWr); 
    this.bWh.a(hashMap, paramBoolean);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427396);
    getWindow().setFeatureInt(7, 2131428157);
    this.bWh = new q(this, this, this);
    wR();
    yP();
    registerReceiver(this.blv, new IntentFilter(aa.bXp));
    this.bWf.performClick();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (this.blv != null)
      unregisterReceiver(this.blv); 
  }
  
  public void q(int paramInt, boolean paramBoolean) {
    PendingFullOrderDetail pendingFullOrderDetail = this.bWi.WU();
    if (pendingFullOrderDetail != null) {
      pendingFullOrderDetail.bXb.cpb = paramInt;
      if (b.XB() && paramBoolean && paramInt == 1) {
        for (PendingFullOrderDetail.d d : pendingFullOrderDetail.coy) {
          if (d.aTU == 0 && this.bWr.contains(String.valueOf(d.cpz)))
            d.aTU = 2; 
        } 
        Iterator iterator = pendingFullOrderDetail.coz.iterator();
        while (iterator.hasNext()) {
          for (PendingFullOrderDetail.d d : ((PendingFullOrderDetail.c)iterator.next()).cpg) {
            if (d.aTU == 0 && this.bWr.contains(String.valueOf(d.cpz)))
              d.aTU = 2; 
          } 
        } 
      } 
      m.a(this, pendingFullOrderDetail, true);
    } 
  }
  
  public void zL() {
    if (this.waitingDialog == null) {
      this.waitingDialog = new bb(getActivity());
      this.waitingDialog.setCancelable(false);
    } 
    if (!isFinishing() && this.waitingDialog != null)
      this.waitingDialog.show(); 
  }
  
  public void zM() {
    if (!isFinishing() && this.waitingDialog != null)
      this.waitingDialog.dismiss(); 
  }
  
  class a implements View.OnClickListener {
    a(NewsActivity this$0) {}
    
    public void onClick(View param1View) {
      int i = param1View.getId();
      if (i != 2131296611) {
        if (i != 2131296642)
          return; 
        NewsActivity.b(this.bWC, 0);
        return;
      } 
      NewsActivity.b(this.bWC, 1);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\news\NewsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */