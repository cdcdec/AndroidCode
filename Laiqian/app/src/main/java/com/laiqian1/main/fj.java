package com.laiqian.main;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.laiqian.d.a;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.product.models.h;
import java.util.Calendar;
import java.util.Date;
import org.jetbrains.annotations.NotNull;

public class fj {
  public double a(Date paramDate, long paramLong) {
    double d1;
    StringBuilder stringBuilder1 = h(paramDate);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("bindView hour=");
    stringBuilder2.append(stringBuilder1.first);
    stringBuilder2.append("-min=");
    stringBuilder2.append(stringBuilder1.second);
    Log.i("@emery", stringBuilder2.toString());
    if (paramLong == 0L) {
      if (((Integer)stringBuilder1.second).intValue() >= 1) {
        d1 = (((Integer)stringBuilder1.first).intValue() + 1);
      } else {
        double d;
        d1 = ((Integer)stringBuilder1.first).intValue();
      } 
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("bindView rule 1 qty=");
      stringBuilder1.append(d1);
      Log.i("@emery", stringBuilder1.toString());
    } else {
      if (((Integer)stringBuilder1.second).intValue() <= 30) {
        d1 = ((Integer)stringBuilder1.first).intValue() + 0.5D;
      } else {
        d1 = (((Integer)stringBuilder1.first).intValue() + 1);
      } 
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("bindView rule 2 qty=");
      stringBuilder1.append(d1);
      Log.i("@emery", stringBuilder1.toString());
    } 
    double d2 = d1;
    if (d1 == 0.0D)
      d2 = 1.0D; 
    return d2;
  }
  
  public h a(@NotNull Context paramContext, @NotNull TableEntity paramTableEntity) {
    long l;
    String str = paramContext.getString(2131630119);
    double d = Integer.parseInt(paramTableEntity.Yg().Yk());
    if (a.AZ().Cw()) {
      l = 0L;
    } else {
      l = 1L;
    } 
    h h = new h(6L, str, "", d, 1000.0D, 600001, l, "", Integer.parseInt(paramTableEntity.Yg().Yk()), "", Integer.parseInt(paramTableEntity.Yg().Yk()));
    h.az(System.currentTimeMillis());
    return h;
  }
  
  public Pair<Integer, Integer> h(Date paramDate) {
    if (paramDate == null)
      return new Pair(Integer.valueOf(0), Integer.valueOf(0)); 
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(paramDate);
    long l = calendar.getTimeInMillis();
    l = System.currentTimeMillis() - l;
    int j = (int)Math.floor(l * 1.0D / 3600000);
    int k = (int)Math.ceil(((int)Math.ceil((l - (3600000 * j)) * 1.0D / '') % 60));
    calendar.clear();
    int i = j;
    if (j == 0) {
      i = j;
      if (k == 0) {
        i = j;
        if (l != 0L)
          i = 1; 
      } 
    } 
    return new Pair(Integer.valueOf(i), Integer.valueOf(k));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\fj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */