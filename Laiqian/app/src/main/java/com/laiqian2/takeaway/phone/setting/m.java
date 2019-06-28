package com.laiqian.takeaway.phone.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.laiqian.entity.y;
import com.laiqian.util.bd;
import java.util.Map;

class m implements AdapterView.OnItemClickListener {
  m(PhoneListActivity paramPhoneListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    if (!bd.bH(this.duU))
      return; 
    if (this.duU.duR.getList().size() >= paramInt) {
      Intent intent = new Intent(this.duU, PhoneChangeActivity.class);
      Bundle bundle = new Bundle();
      Map map = (Map)this.duU.duR.getList().get(paramInt - this.duU.duR.getHeaderViewsCount());
      bundle.putSerializable("TELEPHONE_ENTITY", new y(Long.valueOf((String)map.get("_id")).longValue(), (String)map.get("sName"), (String)map.get("sContactMobilePhone"), Integer.valueOf(((String)map.get("nSpareField5")).toString()).intValue(), (String)map.get("sField2"), (String)map.get("sAddress"), (String)map.get("sField3"), (String)map.get("sNumber"), (String)map.get("sBPartnerTypeName"), (String)map.get("sSpareField1"), (String)map.get("fAmount")));
      intent.putExtras(bundle);
      this.duU.startActivity(intent);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\phone\setting\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */