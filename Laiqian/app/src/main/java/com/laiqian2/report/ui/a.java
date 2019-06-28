package com.laiqian.report.ui;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.a.a.a.b.f;
import com.google.a.a.a.a.a.a;
import com.laiqian.f.c;
import com.laiqian.milestone.h;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.w;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class a extends d {
  InputMethodManager bDy;
  
  TextView cQq;
  
  private w cQw;
  
  private String[] cRc;
  
  EditText ddC;
  
  ArrayList<f> ddD;
  
  f ddE = null;
  
  a ddF;
  
  Context mContext;
  
  public a(Context paramContext) {
    super(paramContext, 2131427847);
    this.mContext = paramContext;
    setPositionTop();
    this.tvTitle = (TextView)this.mView.findViewById(2131298345).findViewById(2131299242);
    this.ddC = (EditText)findViewById(2131297009);
    this.cQq = (TextView)findViewById(2131299826);
    this.cQq.setOnClickListener(new b(this));
    this.ddC.requestFocus();
    initData();
    this.bDy = (InputMethodManager)paramContext.getSystemService("input_method");
    this.cQw = new w(this.mActivity, this.cRc, new c(this));
    if (this.ddD != null && this.ddD.size() > 0) {
      this.cQw.gn(0);
      this.ddE = (f)this.ddD.get(0);
      this.cQq.setText(this.cRc[0]);
    } 
    View view = this.mView.findViewById(2131298738);
    view.findViewById(2131296671).setOnClickListener(new d(this));
    view.findViewById(2131299105).setOnClickListener(new e(this));
  }
  
  private void anL() {
    String str1;
    String str2 = this.ddC.getText().toString().trim();
    if (by.isNull(str2)) {
      String str = this.mContext.getResources().getString(2131625455);
      Context context = this.mContext;
      str1 = str;
      if (TextUtils.isEmpty(str))
        str1 = ""; 
      Toast.makeText(context, str1, 0).show();
    } 
    try {
      str1 = c.cI(str2);
    } catch (NoSuchAlgorithmException null) {
      a.e(null);
      str1 = str2;
    } 
    if (this.ddE != null) {
      if (str1.equals(this.ddE.qr())) {
        dismiss();
        if (this.ddF != null) {
          this.ddF.onSuccess();
          return;
        } 
      } else {
        n.j(this.ddC);
        n.eP(2131625464);
        if (this.ddF != null) {
          this.ddF.LC();
          return;
        } 
      } 
    } else {
      n.eP(2131625451);
    } 
  }
  
  private void initData() {
    Context context = this.mContext;
    byte b = 0;
    null = context.getSharedPreferences("settings", 0).getString("shop_id", "1");
    this.ddD = new ArrayList();
    h h = new h(this.mContext);
    Cursor cursor2 = h.aQ(Long.parseLong(null));
    if (cursor2 != null) {
      while (cursor2.moveToNext()) {
        f f1 = new f(cursor2.getString(0), cursor2.getString(1));
        f1.aC(cursor2.getString(2));
        this.ddD.add(f1);
      } 
      cursor2.close();
    } 
    h.close();
    Cursor cursor1 = h.gK(null);
    if (cursor1 != null && cursor1.getCount() > 0) {
      cursor1.moveToNext();
      f f1 = new f(cursor1.getString(0), cursor1.getString(1));
      f1.aC(cursor1.getString(2));
      this.ddD.add(0, f1);
      cursor1.close();
    } 
    h.close();
    this.cRc = new String[this.ddD.size()];
    while (b < this.ddD.size()) {
      this.cRc[b] = ((f)this.ddD.get(b)).getDisplayName();
      b++;
    } 
  }
  
  public void b(a parama) { this.ddF = parama; }
  
  public void cancel() { super.cancel(); }
  
  public void show() { super.show(); }
  
  public static interface a {
    void LC();
    
    void onSuccess();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */