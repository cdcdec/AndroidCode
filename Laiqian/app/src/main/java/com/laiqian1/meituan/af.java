package com.laiqian.meituan;

import android.text.TextUtils;
import android.util.Log;
import com.laiqian.basic.RootApplication;
import com.laiqian.i.d;
import com.laiqian.member.a;
import com.laiqian.pos.industry.a;
import com.laiqian.ui.listview.FormListView;
import com.laiqian.util.au;
import com.laiqian.util.bh;
import java.util.ArrayList;
import java.util.HashMap;

class af implements FormListView.c {
  af(MeituanPhoneNumberErrorsDocActivity paramMeituanPhoneNumberErrorsDocActivity) {}
  
  public void getListData(int paramInt) {
    ArrayList arrayList2 = new ArrayList();
    null = RootApplication.getLaiqianPreferenceManager().Tx();
    String str1 = RootApplication.getLaiqianPreferenceManager().Ea();
    String str2 = RootApplication.getLaiqianPreferenceManager().atr();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootApplication.getLaiqianPreferenceManager().avm());
    stringBuilder.append("");
    null = d.ac(new a(null, str1, str2, "0", "1", stringBuilder.toString(), MeituanPhoneNumberErrorsDocActivity.m(this.bqT), MeituanPhoneNumberErrorsDocActivity.n(this.bqT)));
    str1 = bh.bt(a.cqZ, null);
    ArrayList arrayList1 = arrayList2;
    if (!TextUtils.isEmpty(str1)) {
      HashMap hashMap = au.qB(str1);
      arrayList1 = arrayList2;
      if (hashMap.containsKey("result")) {
        arrayList1 = arrayList2;
        if ("TRUE".equals(String.valueOf(hashMap.get("result")))) {
          arrayList1 = au.aW(hashMap.get("message"));
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(arrayList1.size());
          stringBuilder1.append("");
          Log.e("arrList", stringBuilder1.toString());
        } 
      } 
    } 
    MeituanPhoneNumberErrorsDocActivity.d(this.bqT).loadListDataAfter(arrayList1, paramInt);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */