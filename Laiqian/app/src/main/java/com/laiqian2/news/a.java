package com.laiqian.news;

import android.view.View;
import android.widget.TextView;
import com.laiqian.basic.RootApplication;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.util.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

class a implements o.b {
  a(NewsActivity paramNewsActivity, ArrayList paramArrayList) {}
  
  public void w(View paramView, int paramInt) {
    int j = ((PendingFullOrderDetail)this.bWB.get(paramInt)).bXb.cpd;
    int i = 0;
    if (j > 3) {
      this.bWC.bWw.setVisibility(0);
      TextView textView = this.bWC.bWt;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(((PendingFullOrderDetail)this.bWB.get(paramInt)).bXb.coE.getTime());
      stringBuilder.append("");
      textView.setText(z.e(stringBuilder.toString(), this.bWC));
      textView = this.bWC.bWu;
      stringBuilder = new StringBuilder();
      stringBuilder.append(RootApplication.zA());
      stringBuilder.append(NewsActivity.a(this.bWC, (PendingFullOrderDetail)this.bWB.get(paramInt), NewsActivity.a(this.bWC)));
      textView.setText(stringBuilder.toString());
      this.bWC.bWx.setImageResource(2131231113);
      this.bWC.bWy.setText(2131626130);
      this.bWC.bWy.setTextColor(this.bWC.getResources().getColor(2131099768));
    } else if ((((PendingFullOrderDetail)this.bWB.get(paramInt)).bXb.cpd == 2 || ((PendingFullOrderDetail)this.bWB.get(paramInt)).bXb.cpd == 3 || ((PendingFullOrderDetail)this.bWB.get(paramInt)).bXb.cpd == 1) && NewsActivity.a(this.bWC) == 1) {
      this.bWC.bWw.setVisibility(0);
      TextView textView = this.bWC.bWt;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(((PendingFullOrderDetail)this.bWB.get(paramInt)).bXb.coE.getTime());
      stringBuilder.append("");
      textView.setText(z.e(stringBuilder.toString(), this.bWC));
      textView = this.bWC.bWu;
      stringBuilder = new StringBuilder();
      stringBuilder.append(RootApplication.zA());
      stringBuilder.append(NewsActivity.a(this.bWC, (PendingFullOrderDetail)this.bWB.get(paramInt), NewsActivity.a(this.bWC)));
      textView.setText(stringBuilder.toString());
      this.bWC.bWx.setImageResource(2131231095);
      this.bWC.bWy.setText(2131629260);
      this.bWC.bWy.setTextColor(this.bWC.getResources().getColor(2131099768));
    } else {
      this.bWC.bWw.setVisibility(0);
      TextView textView = this.bWC.bWt;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(((PendingFullOrderDetail)this.bWB.get(paramInt)).bXb.coE.getTime());
      stringBuilder.append("");
      textView.setText(z.e(stringBuilder.toString(), this.bWC));
      textView = this.bWC.bWu;
      stringBuilder = new StringBuilder();
      stringBuilder.append(RootApplication.zA());
      stringBuilder.append(NewsActivity.a(this.bWC, (PendingFullOrderDetail)this.bWB.get(paramInt), NewsActivity.a(this.bWC)));
      textView.setText(stringBuilder.toString());
      this.bWC.bWx.setImageResource(2131231119);
      this.bWC.bWy.setText(2131629995);
      this.bWC.bWy.setTextColor(this.bWC.getResources().getColor(2131099898));
    } 
    if (((PendingFullOrderDetail)this.bWB.get(paramInt)).bXb.cpd == 5 && NewsActivity.a(this.bWC) == 0) {
      NewsActivity.b(this.bWC).setVisibility(8);
      NewsActivity.c(this.bWC).setVisibility(0);
      NewsActivity.d(this.bWC).setVisibility(8);
    } else if (NewsActivity.a(this.bWC) == 1) {
      NewsActivity.b(this.bWC).setVisibility(8);
      NewsActivity.c(this.bWC).setVisibility(8);
      NewsActivity.d(this.bWC).setVisibility(0);
    } else {
      NewsActivity.b(this.bWC).setVisibility(0);
      NewsActivity.c(this.bWC).setVisibility(8);
      NewsActivity.d(this.bWC).setVisibility(8);
    } 
    if (NewsActivity.e(this.bWC) == null)
      NewsActivity.a(this.bWC, new x(NewsActivity.f(this.bWC), this.bWC)); 
    NewsActivity.e(this.bWC).WZ();
    NewsActivity.e(this.bWC).c(((PendingFullOrderDetail)this.bWB.get(paramInt)).bXb);
    LinkedHashMap linkedHashMap = new LinkedHashMap();
    ArrayList arrayList1 = new ArrayList();
    ArrayList arrayList2 = new ArrayList();
    for (PendingFullOrderDetail.d d : ((PendingFullOrderDetail)this.bWB.get(paramInt)).coy) {
      if ((((PendingFullOrderDetail)this.bWB.get(paramInt)).bXb.cpd != 5 && d.aTU != 0 && NewsActivity.a(this.bWC) == 0) || (d.aTU == 0 && NewsActivity.a(this.bWC) == 1))
        continue; 
      if (!i)
        linkedHashMap.put(Integer.valueOf(i), Long.valueOf(d.bbX)); 
      if (d.cpx == 4L) {
        arrayList1.add(NewsActivity.a(this.bWC, d));
        continue;
      } 
      arrayList2.add(NewsActivity.a(this.bWC, d));
      i++;
    } 
    NewsActivity.a(this.bWC, arrayList2);
    arrayList2 = new ArrayList();
    label67: for (PendingFullOrderDetail.c null : ((PendingFullOrderDetail)this.bWB.get(paramInt)).coz) {
      linkedHashMap.put(Integer.valueOf(i), Long.valueOf(null.cpi.getTime()));
      Iterator iterator = null.cpg.iterator();
      j = i;
      while (true) {
        i = j;
        if (iterator.hasNext()) {
          PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)iterator.next();
          if (((PendingFullOrderDetail)this.bWB.get(paramInt)).bXb.cpd != 5 && d.aTU != 0 && NewsActivity.a(this.bWC) == 0)
            continue; 
          if (d.aTU == 0 && NewsActivity.a(this.bWC) == 1) {
            linkedHashMap.remove(Integer.valueOf(j));
            continue;
          } 
          if (d.cpx == 4L) {
            arrayList1.add(NewsActivity.a(this.bWC, d));
            continue;
          } 
          arrayList2.add(NewsActivity.a(this.bWC, d));
          j++;
          continue;
        } 
        continue label67;
      } 
    } 
    NewsActivity.a(this.bWC, arrayList2);
    if (arrayList1 != null)
      NewsActivity.a(this.bWC, arrayList1); 
    if (NewsActivity.e(this.bWC).WX())
      NewsActivity.e(this.bWC).c(linkedHashMap); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\news\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */