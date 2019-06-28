package com.laiqian.auth;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.milestone.h;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.w;
import com.laiqian.util.bb;
import java.util.ArrayList;
import java.util.HashMap;

public class ShopInfo extends ActivityRoot {
  private TextView aFe;
  
  private EditText aFf;
  
  private TextView aFg;
  
  private TextView aFh;
  
  private EditText aFi;
  
  private TextView aFj;
  
  String[] aFk = null;
  
  private ArrayList<String> aFl = null;
  
  private View.OnClickListener aFm = new bg(this);
  
  View.OnClickListener aFn = new bh(this);
  
  String[] aFo = null;
  
  View.OnClickListener aFp = new bj(this);
  
  String[] aFq = null;
  
  View.OnClickListener aFr = new bl(this);
  
  private void a(String[] paramArrayOfString, w.a parama, String paramString) { // Byte code:
    //   0: iconst_0
    //   1: istore #4
    //   3: iload #4
    //   5: aload_1
    //   6: arraylength
    //   7: if_icmpge -> 33
    //   10: aload_3
    //   11: aload_1
    //   12: iload #4
    //   14: aaload
    //   15: invokevirtual equals : (Ljava/lang/Object;)Z
    //   18: ifeq -> 24
    //   21: goto -> 36
    //   24: iload #4
    //   26: iconst_1
    //   27: iadd
    //   28: istore #4
    //   30: goto -> 3
    //   33: iconst_m1
    //   34: istore #4
    //   36: new com/laiqian/ui/a/w
    //   39: dup
    //   40: aload_0
    //   41: aload_1
    //   42: aload_2
    //   43: invokespecial <init> : (Landroid/content/Context;[Ljava/lang/String;Lcom/laiqian/ui/a/w$a;)V
    //   46: astore_1
    //   47: aload_1
    //   48: iload #4
    //   50: invokevirtual gn : (I)V
    //   53: aload_1
    //   54: invokevirtual show : ()V
    //   57: return }
  
  private void getView() {
    ((TextView)findViewById(2131299889)).setText(2131628251);
    this.aFj = (TextView)findViewById(2131299879);
    this.aFj.setText(2131626317);
    this.aFj.setOnClickListener(this.aFm);
    findViewById(2131298755).setOnClickListener(this.aFn);
    findViewById(2131298759).setOnClickListener(this.aFp);
    findViewById(2131298760).setOnClickListener(this.aFr);
    this.aFe = (TextView)findViewById(2131299327);
    this.aFg = (TextView)findViewById(2131299426);
    this.aFh = (TextView)findViewById(2131299428);
    this.aFf = (EditText)findViewById(2131296952);
    this.aFi = (EditText)findViewById(2131296940);
  }
  
  private void initialData() {
    HashMap hashMap = new HashMap();
    h h = new h(this);
    Cursor cursor = h.TX();
    if (cursor != null) {
      if (cursor.moveToFirst())
        for (byte b = 0; b < cursor.getColumnCount(); b++)
          hashMap.put(cursor.getColumnName(b), cursor.getString(b));  
      cursor.close();
    } 
    h.close();
    String str2 = (String)hashMap.get("sShopTypeName");
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = getString(2131627155); 
    String str3 = (String)hashMap.get("nShopType");
    str2 = str3;
    if (TextUtils.isEmpty(str3))
      str2 = "0"; 
    this.aFe.setText(str1);
    this.aFe.setTag(str2);
    this.aFf.setText((CharSequence)hashMap.get("sShopName"));
    this.aFg.setText((CharSequence)hashMap.get("sShopDescription"));
    this.aFh.setText((CharSequence)hashMap.get("sText"));
    this.aFi.setText((CharSequence)hashMap.get("sShopAddress"));
  }
  
  private void save() {
    String str = getSharedPreferences("settings", 0).getString("shop_id", "1");
    HashMap hashMap = new HashMap();
    hashMap.put("nShopType", (String)this.aFe.getTag());
    hashMap.put("sShopName", this.aFf.getText().toString().trim());
    hashMap.put("sShopDescription", this.aFg.getText().toString().trim());
    hashMap.put("sText", this.aFh.getText().toString().trim());
    hashMap.put("sShopAddress", this.aFi.getText().toString().trim());
    h h = new h(getApplicationContext());
    h.b("t_shop", str, hashMap);
    h.close();
  }
  
  private String[] yD() {
    if (this.aFk == null) {
      h h = new h(this);
      Cursor cursor = h.TY();
      if (cursor != null) {
        this.aFk = new String[cursor.getCount()];
        this.aFl = new ArrayList();
        for (byte b = 0; cursor.moveToNext(); b++) {
          this.aFl.add(cursor.getString(0));
          this.aFk[b] = cursor.getString(1);
        } 
        cursor.close();
      } else {
        this.aFk = new String[0];
      } 
      h.close();
    } 
    return this.aFk;
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131428116);
    getWindow().setFeatureInt(7, 2131428168);
    getView();
    initialData();
  }
  
  protected void onPause() {
    super.onPause();
    bb.ao("onPause");
  }
  
  protected void onStop() {
    super.onStop();
    bb.ao("onStop");
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\ShopInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */