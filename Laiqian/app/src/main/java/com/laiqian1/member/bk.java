package com.laiqian.member;

import android.text.TextUtils;
import android.util.Log;
import com.laiqian.basic.RootApplication;
import com.laiqian.i.d;
import com.laiqian.pos.industry.a;
import com.laiqian.ui.listview.FormListView;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.bh;
import java.util.ArrayList;
import java.util.HashMap;

class bk implements FormListView.c {
  bk(MemberListActivity paramMemberListActivity) {}
  
  public void getListData(int paramInt) {
    ArrayList arrayList2 = new ArrayList();
    null = RootApplication.getLaiqianPreferenceManager();
    if (MemberListActivity.c(this.bvu).Qz().equals(" CAST(ifnull(month ,'0') AS SIGNED integer) ,CAST(ifnull(day ,'0') AS SIGNED integer),_id "))
      MemberListActivity.c(this.bvu).fD("DATE_FORMAT(CAST(`sSpareField1` AS DATE),'%m'),DATE_FORMAT(CAST(`sSpareField1` AS DATE),'%d'),`_id`"); 
    if (MemberListActivity.c(this.bvu).Qz().equals("CAST(ifnull(month ,'0') AS SIGNED integer) desc,CAST(ifnull(day ,'0') AS SIGNED integer)  desc,_id desc"))
      MemberListActivity.c(this.bvu).fD("DATE_FORMAT(CAST(`sSpareField1` AS DATE),'%m') desc,DATE_FORMAT(CAST(`sSpareField1` AS DATE),'%d') DESC,`_id` desc"); 
    null = null.Tx();
    String str1 = RootApplication.getLaiqianPreferenceManager().Ea();
    String str2 = RootApplication.getLaiqianPreferenceManager().atr();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(RootApplication.getLaiqianPreferenceManager().avm());
    stringBuilder1.append("");
    String str3 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    null = d.ac(new cc(null, str1, str2, "0", "1", str3, stringBuilder2.toString(), MemberListActivity.c(this.bvu).Qz(), MemberListActivity.c(this.bvu).Qy(), "0"));
    str1 = bh.bt(a.cqt, null);
    ArrayList arrayList1 = arrayList2;
    if (!TextUtils.isEmpty(str1)) {
      HashMap hashMap = au.qB(str1);
      arrayList1 = arrayList2;
      if (hashMap.containsKey("result")) {
        arrayList1 = arrayList2;
        if ("TRUE".equals(String.valueOf(hashMap.get("result")))) {
          arrayList1 = au.aW(hashMap.get("message"));
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(arrayList1.size());
          stringBuilder.append("");
          Log.e("arrList", stringBuilder.toString());
        } 
      } 
    } 
    this.bvu.buS.loadListDataAfter(arrayList1, paramInt);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */