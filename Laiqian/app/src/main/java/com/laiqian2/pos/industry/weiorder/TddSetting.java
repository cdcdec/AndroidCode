package com.laiqian.pos.industry.weiorder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.f.b;
import com.laiqian.takeaway.aq;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.listview.PosAutoListView;
import com.laiqian.ui.listview.l;
import com.laiqian.ui.webview.PosWebViewLinearLayout;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.bd;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;

@SuppressLint({"NewApi"})
public class TddSetting extends ActivityRoot {
  private Button aGS;
  
  private PosWebViewLinearLayout aQH;
  
  View.OnClickListener azO = new bk(this);
  
  private TextView bLV;
  
  private HashMap<String, String> ctJ = null;
  
  private Button ctK;
  
  private TextView ctL;
  
  LinearLayout ctM;
  
  LinearLayout ctN;
  
  private final String ctO = "https://oauth.taobao.com/authorize?response_type=token&client_id=23130093&view=tmall";
  
  private final String ctP = "http://mai.dd.taobao.com";
  
  private final String ctQ = "taobao_user_nick";
  
  private PosAutoListView ctR;
  
  private boolean ctS = false;
  
  View.OnClickListener ctT = new bl(this);
  
  Handler mHandler;
  
  public static ArrayList<HashMap<String, Object>> aW(Context paramContext) {
    Iterator iterator1;
    hashMap = null;
    iterator2 = null;
    try {
      HashMap hashMap1 = aq.bz(paramContext);
      exception = hashMap;
      if (hashMap1 != null) {
        Iterator iterator;
        exception = hashMap;
        if (hashMap1.containsKey("sLqkUserTddShops")) {
          exception = au.aV((String)hashMap1.get("sLqkUserTddShops"));
          if (exception == null)
            return null; 
          try {
            iterator1 = new av(paramContext);
            for (HashMap hashMap : exception)
              hashMap.put("bChecked", Boolean.valueOf(iterator1.qN(hashMap.get("shopid").toString()))); 
            iterator1.close();
            return exception;
          } catch (Exception iterator2) {
            iterator1 = exception;
            exception = iterator2;
          } 
        } else {
          return exception;
        } 
      } else {
        return exception;
      } 
    } catch (Exception exception) {
      iterator1 = iterator2;
    } 
    a.e(exception);
    return iterator1;
  }
  
  private void abp() {
    if (this.ctJ.containsKey("sLqkUserTddShops")) {
      ArrayList arrayList = aW(this);
      if (arrayList == null)
        return; 
      l l = new l(this, arrayList, 2131428148, new String[] { "name", "bChecked" }, new int[] { 2131299330, 2131296702 }, false, false);
      this.ctR.setResultSize(arrayList.size());
      this.ctR.setAdapter(l);
      bo bo = new bo(this, arrayList, l);
      this.ctR.setOnItemClickListener(bo);
    } 
  }
  
  private void abq() {
    if (this.ctJ == null)
      return; 
    new JSONArray();
    if (this.ctJ.containsKey("sLqkUserTddShops"))
      abp(); 
    if (this.mHandler == null)
      this.mHandler = new bp(this); 
    try {
      Log.e("sTDDSessionKey", (String)this.ctJ.get("access_token"));
      Handler handler = this.mHandler;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(aq.dtB);
      stringBuilder.append(URLEncoder.encode(b.encode((String)this.ctJ.get("access_token")), "UTF-8"));
      bd.b(handler, stringBuilder.toString());
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  private void abr() {
    this.aQH.setVisibility(8);
    this.ctN.setVisibility(0);
    if (this.ctJ.containsKey("taobao_user_nick"))
      try {
        this.ctL.setText(URLDecoder.decode((String)this.ctJ.get("taobao_user_nick"), "UTF-8"));
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        a.e(unsupportedEncodingException);
      }  
    abq();
  }
  
  private void initData() {
    this.ctJ = aq.bz(this);
    if (this.ctJ == null) {
      jK("https://oauth.taobao.com/authorize?response_type=token&client_id=23130093&view=tmall");
      return;
    } 
    abr();
  }
  
  private void jJ(String paramString) {
    String[] arrayOfString = (String[])paramString.split("#").clone()[1].split("&");
    int i = arrayOfString.length;
    byte b = 0;
    while (true) {
      if (b < i) {
        str = arrayOfString[b];
        try {
          String[] arrayOfString1 = str.split("=");
          if (arrayOfString1.length > 1) {
            if (this.ctJ == null)
              this.ctJ = new HashMap(); 
            this.ctJ.put(arrayOfString1[0], arrayOfString1[1]);
          } 
          aq.b(this, this.ctJ);
        } catch (Exception str) {}
        b++;
        continue;
      } 
      return;
    } 
  }
  
  private void jK(String paramString) {
    this.aQH.setVisibility(0);
    this.aQH.pf(paramString);
    this.ctN.setVisibility(8);
    bb.e("跳转url", paramString);
  }
  
  private void yP() {
    this.ctM.setOnClickListener(this.ctT);
    this.ctK.setOnClickListener(new bm(this));
    this.aQH.setWebViewClient(new bn(this));
  }
  
  private void yR() {
    this.ctL = (TextView)findViewById(2131299193);
    this.bLV = (TextView)findViewById(2131299889);
    this.ctN = (LinearLayout)findViewById(2131298986);
    this.aQH = (PosWebViewLinearLayout)findViewById(2131298991);
    this.ctR = (PosAutoListView)findViewById(2131298966);
    this.ctM = (LinearLayout)findViewById(2131299194);
    this.ctK = (Button)findViewById(2131299192);
    this.aGS = (Button)findViewById(2131299879);
    this.aGS.setVisibility(8);
    this.bLV.setText(getString(2131630017));
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131428147);
    getWindow().setFeatureInt(7, 2131428168);
    yR();
    yP();
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.aQH.onDestroy();
  }
  
  public void onResume() {
    super.onResume();
    try {
      this.ctS = getIntent().getBooleanExtra("sLoginTDD", false);
      if (this.ctS)
        aq.by(this); 
    } catch (Exception exception) {}
    initData();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\TddSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */