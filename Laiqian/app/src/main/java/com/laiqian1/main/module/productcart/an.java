package com.laiqian.main.module.productcart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.d.a;
import com.laiqian.entity.aa;
import com.laiqian.main.dl;
import com.laiqian.main.fj;
import com.laiqian.rx.b.a;
import com.laiqian.util.n;
import io.reactivex.a.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

final class an extends Object implements a.c<am.a> {
  fj bkd = null;
  
  an(Context paramContext) {}
  
  @Nullable
  public b a(a<am.a> parama, int paramInt, @NonNull View paramView1, View paramView2) {
    StringBuilder stringBuilder;
    String str = (am.a)parama.getItem(paramInt);
    if (str instanceof am.a.a) {
      boolean bool;
      double d1;
      am.b b = new am.b(paramView1);
      aa aa = ((am.a.a)str).bjo;
      null = b.bkg.aQx;
      if (!aa.GN() && !aa.akO()) {
        bool = true;
      } else {
        bool = false;
      } 
      null.setEnabled(bool);
      null = aa.cUM;
      null = null;
      if (aa.Gp()) {
        StringBuilder stringBuilder1;
        null = context.getString(2131626345);
        if (null.indexOf("|-") >= 0) {
          null = null.replace("|-", "");
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("[");
          stringBuilder2.append(null);
          stringBuilder2.append("]");
          stringBuilder2.append(null);
          null = stringBuilder2.toString();
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("|-");
          stringBuilder1.append(null);
          null = stringBuilder1.toString();
        } else {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("[");
          stringBuilder2.append(null);
          stringBuilder2.append("]");
          stringBuilder2.append(stringBuilder1);
          null = stringBuilder2.toString();
        } 
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("bindView productName-->");
      stringBuilder.append(null);
      stringBuilder.append("--position-->");
      stringBuilder.append(paramInt);
      Log.i("@emery", stringBuilder.toString());
      b.bkg.bjG.setText(null);
      if (aa.GM().toString().length() == 0) {
        b.bkg.bkh.setVisibility(8);
      } else {
        b.bkg.bkh.setVisibility(0);
        b.bkg.bkh.setText(aa.GM().toString());
      } 
      int i = ((Integer)this.bke.bdS.getValue()).intValue();
      if (i == 1 || i == 2 || i == 5) {
        b.bkg.bkj.setText(aa.GG());
      } else {
        b.bkg.bkj.setText(n.po(aa.GG()));
      } 
      if (paramInt == 1 && 6L == aa.aSW) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(" calculation rule ");
        stringBuilder2.append(aa.AL());
        Log.i("@emery", stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("startTime=");
        stringBuilder2.append(aa.Ly());
        Log.i("@emery", stringBuilder2.toString());
        d1 = this.bkd.a(new Date(aa.Ly()), aa.AL());
        TextView textView = b.bkg.bkj;
        stringBuilder = new StringBuilder();
        stringBuilder.append(n.d(Double.valueOf(aa.akI())));
        stringBuilder.append(context.getString(2131629923));
        textView.setText(stringBuilder.toString());
        textView = b.bkg.bki;
        stringBuilder = new StringBuilder();
        stringBuilder.append("x");
        stringBuilder.append(d1);
        textView.setText(stringBuilder.toString());
        aa.q(d1);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("bindView qty=");
        stringBuilder1.append(d1);
        Log.i("@emery", stringBuilder1.toString());
        aa.GD();
        List list = this.bke.bea.beN.aoL();
        this.bke.bea.beN.r(list);
        return null;
      } 
      try {
        d1 = Double.parseDouble(aa.Gx());
      } catch (Exception null) {
        a.e(null);
        d1 = 0.0D;
      } 
      double d2 = d1;
      if (d1 < 0.0D) {
        d2 = -d1;
        b.bkg.bkj.setText(context.getString(2131628116));
      } 
      null = new StringBuilder();
      null.append("x");
      null.append(d2);
      str = null.toString();
      b.bkg.bki.setText(str);
      return null;
    } 
    if (str instanceof am.a.b) {
      am.c c1 = new am.c(stringBuilder);
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(context.getString(2131627409));
      Date date = ((am.a.b)str).bkf;
      c1.bkk.setText(simpleDateFormat.format(date));
      if (paramInt == 0) {
        c1.bkl.setVisibility(8);
        this.bkd = new fj();
        if (a.AZ().Bk() && a.AZ().Cv()) {
          Pair pair = this.bkd.h(date);
          c1.bkm.setText(context.getString(2131630121, new Object[] { pair.first, pair.second }));
          return null;
        } 
      } else {
        c1.bkl.setVisibility(8);
        c1.bkm.setVisibility(8);
      } 
    } 
    return null;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productcart\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */