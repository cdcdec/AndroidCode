package com.laiqian.member.setting.marketing;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.member.setting.sms.g;
import com.laiqian.member.setting.sms.i;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.recycleview.LineGridViewPadding;
import com.laiqian.util.bd;
import com.laiqian.util.bg;
import com.laiqian.vip.R;
import io.reactivex.android.b.a;
import io.reactivex.g.a;
import io.reactivex.h;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SMSDetailStaticsActivity extends ActivityRoot {
  private List<g> bEY;
  
  private LineGridViewPadding bFa;
  
  private void a(c paramc) {
    if (!bd.bH(this)) {
      (new bc(this)).show();
      return;
    } 
    h.a(new aa(this)).d(a.aKh()).c(a.aJo()).b(new z(this, paramc));
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.bEY = new ArrayList();
    setContentViewSetCustomTitle(R.layout.activity_sms_statics_detail);
    setTitleTextViewHideRightView(getString(R.string.vip_sms_statics_detail_title));
    this.bFa = (LineGridViewPadding)findViewById(R.id.lv_sms_static_detail);
    c c = new c(this);
    this.bFa.setAdapter(c);
    LayoutInflater.from(this).inflate(R.layout.item_sms_detail_foot, null);
    LayoutInflater.from(this).inflate(R.layout.item_sms_detail_head, null);
    getWindow().getDecorView().post(new x(this, c));
    this.bFa.setOnScrollListener(new y(this, c));
  }
  
  public List<g> z(List<g> paramList) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    null = new i(this);
    int i = this.bEZ;
    this.bEZ = i + 1;
    str = null.a(this, i, 20);
    if (TextUtils.isEmpty(str))
      return paramList; 
    try {
      JSONObject jSONObject = new JSONObject(str);
      if (jSONObject.optBoolean("result")) {
        JSONArray jSONArray = jSONObject.optJSONArray("message");
        for (i = 0; i < jSONArray.length(); i++) {
          jSONObject = jSONArray.optJSONObject(i);
          jSONObject.optString("sReceivePhone");
          jSONObject.optString("nStatus");
          String str3 = jSONObject.optString("nDateTime");
          String str4 = jSONObject.optString("sSmsType");
          String str2 = jSONObject.optString("nServerReturnCount");
          String str5 = jSONObject.optString("sEventType");
          String str6 = jSONObject.optString("sMeeeageContent");
          String str7 = simpleDateFormat.format(new Date(Long.valueOf(str3).longValue()));
          String str1 = str2;
          if (bg.equals(str2, "0"))
            str1 = "发送中"; 
          g g = new g(str7, str5, str4, str6, str1);
          g.gj(str3);
          paramList.add(g);
        } 
      } 
    } catch (JSONException str) {
      a.e(str);
    } 
    return paramList;
  }
  
  class a {
    TextView bFd;
    
    TextView bFe;
    
    TextView bFf;
    
    TextView bFg;
    
    TextView bFh;
    
    View buG;
    
    a(SMSDetailStaticsActivity this$0) {}
  }
  
  class b {
    TextView bFd;
    
    TextView bFe;
    
    TextView bFf;
    
    TextView bFg;
    
    TextView bFh;
    
    View buG;
    
    b(SMSDetailStaticsActivity this$0) {}
  }
  
  class c extends BaseAdapter {
    c(SMSDetailStaticsActivity this$0) {}
    
    public g fT(int param1Int) { return (g)SMSDetailStaticsActivity.a(this.bFc).get(param1Int - 1); }
    
    public int getCount() { return (SMSDetailStaticsActivity.a(this.bFc) == null) ? 0 : (SMSDetailStaticsActivity.a(this.bFc).size() + 1); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public int getItemViewType(int param1Int) { return (param1Int == 0) ? 0 : 1; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      g g;
      SMSDetailStaticsActivity.a a;
      int i = getItemViewType(param1Int);
      SMSDetailStaticsActivity.b b = null;
      Object object = null;
      if (param1View != null) {
        switch (i) {
          default:
            param1ViewGroup = null;
            break;
          case 1:
            a = (SMSDetailStaticsActivity.a)param1View.getTag();
            b = object;
            break;
          case 0:
            b = (SMSDetailStaticsActivity.b)param1View.getTag();
            a = null;
            break;
        } 
      } else {
        switch (i) {
          default:
          
          case 1:
            a = new SMSDetailStaticsActivity.a(this.bFc);
            param1View = LayoutInflater.from(this.bFc).inflate(R.layout.item_sms_detail, null);
            a.buG = param1View.findViewById(R.id.ll_item_sms_datail_bg);
            a.bFd = (TextView)param1View.findViewById(R.id.send_time);
            a.bFe = (TextView)param1View.findViewById(R.id.event_type);
            a.bFf = (TextView)param1View.findViewById(R.id.sms_type);
            a.bFg = (TextView)param1View.findViewById(R.id.sms_content);
            a.bFh = (TextView)param1View.findViewById(R.id.send_amount);
            param1View.setTag(a);
            break;
          case 0:
            b = new SMSDetailStaticsActivity.b(this.bFc);
            param1View = LayoutInflater.from(this.bFc).inflate(R.layout.item_sms_detail_head, null);
            b.buG = param1View.findViewById(R.id.ll_item_sms_datail_bg);
            b.bFd = (TextView)param1View.findViewById(R.id.send_time);
            b.bFe = (TextView)param1View.findViewById(R.id.event_type);
            b.bFf = (TextView)param1View.findViewById(R.id.sms_type);
            b.bFg = (TextView)param1View.findViewById(R.id.sms_content);
            b.bFh = (TextView)param1View.findViewById(R.id.send_amount);
            param1View.setTag(b);
            a = null;
            break;
        } 
      } 
      switch (i) {
        default:
          return param1View;
        case 1:
          if (param1Int % 2 == 0) {
            a.buG.setBackgroundColor(this.bFc.getResources().getColor(R.color.form_color_bg));
          } else {
            a.buG.setBackgroundColor(-1);
          } 
          g = fT(param1Int);
          a.bFd.setText(g.SP());
          a.bFe.setText(g.SN());
          a.bFf.setText(g.SM());
          a.bFg.setText(g.SQ());
          a.bFg.setGravity(19);
          a.bFh.setText(g.SR());
          return param1View;
        case 0:
          break;
      } 
      g.buG.setBackgroundColor(this.bFc.getResources().getColor(R.color.form_color_bg));
      g.bFd.setText(R.string.send_time);
      g.bFe.setText(R.string.event_type);
      g.bFf.setText(R.string.sms_type);
      g.bFg.setText(R.string.sms_content);
      g.bFg.setGravity(17);
      g.bFh.setText(R.string.send_amount);
      return param1View;
    }
    
    public int getViewTypeCount() { return 2; }
    
    public void notifyDataSetChanged() {
      Collections.sort(SMSDetailStaticsActivity.a(this.bFc), new ab(this));
      super.notifyDataSetChanged();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\marketing\SMSDetailStaticsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */