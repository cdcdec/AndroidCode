package com.laiqian.pos;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.models.a;
import com.laiqian.models.f;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.r;
import com.laiqian.util.m;
import com.laiqian.util.n;

public class ab extends d {
  private View aCT;
  
  private r aCU;
  
  private EditText cft;
  
  private a cfu;
  
  private long id;
  
  public ab(ActivityRoot paramActivityRoot) {
    super(paramActivityRoot, 2131427927);
    setPositionTop();
    (getWindow().getAttributes()).width = (this.mView.findViewById(2131298345).getLayoutParams()).width + (this.mView.findViewById(2131298602).getLayoutParams()).width;
    this.tvTitle = (TextView)this.mView.findViewById(2131299242);
    this.cft = (EditText)this.mView.findViewById(2131298198);
    this.mView.findViewById(2131299841).setOnClickListener(new m.b(this.mActivity, this.cft));
    this.aCT = this.mView.findViewById(2131296858);
    this.mView.findViewById(2131296671).setOnClickListener(new ac(this));
    this.mView.findViewById(2131299105).setOnClickListener(new ad(this));
    this.aCT.setOnClickListener(new ae(this));
  }
  
  private r xJ() {
    if (this.aCU == null) {
      this.aCU = new r(this.mActivity, new af(this));
      this.aCU.s(this.mActivity.getString(2131627361));
    } 
    return this.aCU;
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean) {
    this.id = paramLong;
    this.cft.setText(paramString);
    if (paramLong == 0L) {
      this.tvTitle.setText(2131627356);
      this.aCT.setVisibility(8);
      this.cft.requestFocus();
    } else {
      this.tvTitle.setText(2131627362);
      this.aCT.setVisibility(0);
      n.j(this.cft);
    } 
    if (paramBoolean) {
      this.cft.setHint("");
    } else {
      this.cft.setHint(2131627360);
    } 
    super.show();
  }
  
  public void a(a parama) { this.cfu = parama; }
  
  protected boolean delete() {
    f f = new f(this.mActivity);
    boolean bool = f.bg(this.id);
    if (bool) {
      this.mActivity.sendBroadcast(new Intent("pos_activity_change_data_paytype"));
      n.w(this.mActivity, 2131627489);
      cancel();
    } else {
      n.a(this.mActivity, f.Vn());
    } 
    f.close();
    return bool;
  }
  
  protected boolean save() {
    boolean bool;
    null = this.cft.getText().toString().trim();
    String str = null;
    if (null.length() == 0)
      str = this.cft.getHint().toString(); 
    if (str.length() == 0 || str.contains("'")) {
      if (str.length() == 0) {
        n.w(this.mActivity, 2131627558);
      } else {
        n.w(this.mActivity, 2131627554);
      } 
      n.b(this.mActivity, getCurrentFocus());
      return false;
    } 
    a a1 = new a(this.mActivity);
    if (this.id == 0L) {
      bool = a1.g(System.currentTimeMillis(), str);
    } else {
      bool = a1.j(this.id, str);
    } 
    if (bool) {
      this.mActivity.sendBroadcast(new Intent("pos_activity_change_data_paytype"));
      if (this.id == 0L) {
        n.w(this.mActivity, 2131627484);
      } else {
        n.w(this.mActivity, 2131627647);
      } 
      cancel();
    } else {
      n.a(this.mActivity, a1.Vn());
      n.j(this.cft);
    } 
    a1.close();
    return bool;
  }
  
  @Deprecated
  public void show() { super.show(); }
  
  protected void xI() { xJ().show(); }
  
  public static interface a {
    void d(boolean param1Boolean, long param1Long, String param1String);
    
    void e(boolean param1Boolean, long param1Long, String param1String);
    
    void f(boolean param1Boolean, long param1Long, String param1String);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */