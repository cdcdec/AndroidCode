package com.laiqian.meituan;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.util.av;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ah {
  ArrayList<ai> bpN = new ArrayList();
  
  String bpO;
  
  String bpP;
  
  String brb;
  
  b brc;
  
  ai brd;
  
  public int bre;
  
  Context context;
  
  public ah(Context paramContext, b paramb, int paramInt) {
    this.brc = paramb;
    this.context = paramContext;
    this.bre = paramInt;
  }
  
  public void PC() {
    this.brd = new ai();
    this.brd.name = a.AZ().BH();
    ArrayList arrayList = new ArrayList();
    arrayList.add(this.brd);
    this.brc.B(arrayList);
  }
  
  public void PD() { (new a(this)).execute(new String[0]); }
  
  public void fj(String paramString) { (new c(this)).execute(new String[] { paramString }); }
  
  public void init() { (new b(this)).execute(new Void[0]); }
  
  class a extends AsyncTask<String, String, HashMap<String, Object>> {
    a(ah this$0) {}
    
    protected HashMap<String, Object> j(String... param1VarArgs) { return g.aA(this.brf.context); }
    
    protected void j(HashMap<String, Object> param1HashMap) {
      super.onPostExecute(param1HashMap);
      this.brf.brc.Pt();
      byte b = 0;
      if (param1HashMap != null && param1HashMap.containsKey("msg_no") && "10000".equals(String.valueOf(param1HashMap.get("msg_no"))))
        try {
          JSONArray jSONArray = new JSONArray((new JSONObject(String.valueOf(param1HashMap.get("message")))).optString("phoneNumber"));
          av av = RootApplication.getLaiqianPreferenceManager();
          int i = b;
          if (jSONArray != null) {
            i = b;
            if (jSONArray.length() > 0)
              i = 1; 
          } 
          av.hX(i);
          if (jSONArray != null && !"[]".equals(jSONArray.toString())) {
            Log.e("newMeituanPhoneOrderErrorOrders", jSONArray.toString());
            RootApplication.getLaiqianPreferenceManager().rI(jSONArray.toString());
            this.brf.brc.KU();
            if (jSONArray.length() > 0)
              return; 
            n.eP(R.string.no_phone_number_error);
            return;
          } 
          return;
        } catch (Exception param1HashMap) {
          return;
        }  
      Toast.makeText(this.brf.context, "获取失败", 0).show();
    }
    
    protected void onPreExecute() {
      super.onPreExecute();
      this.brf.brc.Ps();
    }
  }
  
  class b extends AsyncTask<Void, Void, HashMap<String, Object>> {
    b(ah this$0) {}
    
    protected HashMap<String, Object> d(Void... param1VarArgs) { return s.aB(this.brf.context); }
    
    protected void j(HashMap<String, Object> param1HashMap) {
      this.brf.brc.hideProgress();
      if (param1HashMap == null) {
        this.brf.brc.El();
        return;
      } 
      if (!param1HashMap.containsKey("result") || !"true".equals(String.valueOf(param1HashMap.get("result")))) {
        this.brf.brc.Pq();
        return;
      } 
      JSONObject jSONObject = null;
      try {
        JSONObject jSONObject1 = new JSONObject(String.valueOf(param1HashMap.get("bind_type")));
        jSONObject = jSONObject1;
      } catch (JSONException jSONException) {
        this.brf.brc.Pq();
      } 
      if (jSONObject != null && jSONObject.optBoolean("takeaway", false) && this.brf.bre == 2) {
        if (!TextUtils.isEmpty(this.brf.bpP)) {
          this.brf.bpO = this.brf.bpP;
          RootApplication.getLaiqianPreferenceManager().rv(this.brf.bpO);
          a.AZ().bW(this.brf.bpO);
        } else {
          this.brf.bpO = String.valueOf(param1HashMap.get("token"));
          RootApplication.getLaiqianPreferenceManager().rv(this.brf.bpO);
          a.AZ().bW(this.brf.bpO);
          RootApplication.getLaiqianPreferenceManager().hH(true);
        } 
        this.brf.fj(this.brf.bpO);
        return;
      } 
      if (jSONObject != null && jSONObject.optBoolean("tuangou", false) && this.brf.bre == 1) {
        if (!TextUtils.isEmpty(this.brf.bpP)) {
          this.brf.bpO = this.brf.bpP;
          RootApplication.getLaiqianPreferenceManager().rv(this.brf.bpO);
          a.AZ().bW(this.brf.bpO);
        } else {
          this.brf.bpO = String.valueOf(param1HashMap.get("token"));
          RootApplication.getLaiqianPreferenceManager().rv(this.brf.bpO);
          a.AZ().bW(this.brf.bpO);
          RootApplication.getLaiqianPreferenceManager().hI(true);
          a.AZ().bV(true);
        } 
        this.brf.PC();
        return;
      } 
      if (jSONObject != null && !jSONObject.optBoolean("tuangou", false) && this.brf.bre == 1 && !TextUtils.isEmpty(a.AZ().BI())) {
        this.brf.brc.Pq();
        return;
      } 
      this.brf.brc.Pq();
    }
    
    protected void onPreExecute() {
      super.onPreExecute();
      this.brf.brc.Em();
    }
  }
  
  class c extends AsyncTask<String, String, Integer> {
    c(ah this$0) {}
    
    protected void e(Integer param1Integer) {
      this.brf.brc.dE(true);
      switch (param1Integer.intValue()) {
        default:
          return;
        case 2:
          this.brf.brc.Pr();
          n.o(this.brf.brb);
          return;
        case 1:
          break;
      } 
      this.brf.brc.B(this.brf.bpN);
    }
    
    protected Integer i(String... param1VarArgs) {
      str = s.b(param1VarArgs[0], this.brf.context);
      if (TextUtils.isEmpty(str))
        return Integer.valueOf(2); 
      try {
        JSONObject jSONObject2 = new JSONObject(str);
        JSONObject jSONObject1 = jSONObject2;
        if (jSONObject2.has("error")) {
          jSONObject1 = jSONObject2.getJSONObject("error");
          this.brf.brb = jSONObject1.optString("message");
        } 
        if (jSONObject1.has("data")) {
          Log.e("data", jSONObject1.getJSONArray("data").toString());
          JSONArray jSONArray = jSONObject1.optJSONArray("data");
          this.brf.bpN = new ArrayList();
          for (byte b = 0; b < jSONArray.length(); b++) {
            ai ai = (new ai()).f(jSONArray.getJSONObject(b));
            this.brf.bpN.add(ai);
          } 
          this.brf.brd = new ai();
          this.brf.brd.f(jSONArray.getJSONObject(0));
          return Integer.valueOf(1);
        } 
        return Integer.valueOf(2);
      } catch (JSONException str) {
        a.e(str);
        return Integer.valueOf(2);
      } 
    }
    
    protected void onPreExecute() {
      super.onPreExecute();
      this.brf.brc.dE(false);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */