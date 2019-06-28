package com.laiqian.opentable.b;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.opentable.R;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.tablelist.TableList;
import com.laiqian.ordertool.c.a;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.util.m;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Iterator;

public class r extends d implements a {
  private r aCU;
  
  private String bYw;
  
  private boolean caB;
  
  private String caC;
  
  private ViewGroup caD;
  
  private ArrayList<View> caE;
  
  private View caF;
  
  private EditText caG;
  
  private View caH;
  
  private TextView caI;
  
  private View caJ;
  
  private String[] caL;
  
  private String[] caM;
  
  private w caN;
  
  private int caO;
  
  private View ccQ;
  
  private EditText ccR;
  
  private View ccS;
  
  private a ccT;
  
  private View ccU;
  
  private b ccV;
  
  public r(FragmentActivity paramFragmentActivity, a parama, Class<? extends TableList> paramClass) {
    super(paramFragmentActivity, R.layout.pos_table_main_dialog);
    setPositionTop();
    this.ccV = new b(this.mActivity, this, parama);
    View view = this.mView.findViewById(R.id.parameter);
    this.tvTitle = (TextView)view.findViewById(R.id.title);
    this.caD = (ViewGroup)view.findViewById(R.id.product_info);
    this.caE = new ArrayList();
    this.ccQ = this.caD.findViewById(R.id.table_name_l);
    this.ccR = (EditText)this.ccQ.findViewById(R.id.name);
    this.ccQ.setOnClickListener(new m.b(this.mActivity, this.ccR));
    this.caE.add(this.ccQ);
    this.caF = this.caD.findViewById(R.id.table_max_person_l);
    this.caG = (EditText)this.caF.findViewById(R.id.max_person);
    this.caF.setOnClickListener(new m.b(this.mActivity, this.caG));
    this.caE.add(this.caF);
    this.caH = this.caD.findViewById(R.id.aera_l);
    this.caI = (TextView)this.caH.findViewById(R.id.tv_area);
    this.caH.setOnClickListener(new m.b(this.mActivity, this.caI));
    this.caI.setOnClickListener(new s(this, paramClass));
    this.caE.add(this.caH);
    this.ccS = this.mView.findViewById(R.id.table_create_bottom);
    this.mView.findViewById(R.id.table_create_canal).setOnClickListener(new u(this));
    this.mView.findViewById(R.id.table_create_save).setOnClickListener(new v(this));
    this.mView.findViewById(R.id.table_create_save_new).setOnClickListener(new w(this));
    this.caJ = this.mView.findViewById(R.id.table_update_bottom);
    this.mView.findViewById(R.id.canal).setOnClickListener(new x(this));
    this.mView.findViewById(R.id.sure).setOnClickListener(new y(this));
    this.ccU = this.caJ.findViewById(R.id.delete);
    this.ccU.setOnClickListener(new z(this));
  }
  
  private void X(ArrayList<View> paramArrayList) {
    Iterator iterator = this.caE.iterator();
    byte b1 = 0;
    while (iterator.hasNext()) {
      boolean bool;
      View view = (View)iterator.next();
      ViewParent viewParent = view.getParent();
      if (viewParent != null) {
        bool = true;
      } else {
        bool = false;
      } 
      boolean bool1 = paramArrayList.contains(view);
      if (bool && bool1) {
        b1++;
        continue;
      } 
      if (bool) {
        ((ViewGroup)viewParent).removeView(view);
        continue;
      } 
      if (bool1) {
        this.caD.addView(view, b1);
        b1++;
      } 
    } 
  }
  
  private void Xp() { this.mActivity.sendBroadcast(new Intent("pos_activity_change_data_area")); }
  
  private void YE() {
    av av = new av(this.mActivity);
    av.lP(this.caO);
    av.close();
  }
  
  private r xJ() {
    if (this.aCU == null) {
      this.aCU = new r(this.mActivity, new aa(this));
      this.aCU.s(this.mActivity.getString(R.string.pos_open_table_dialog_before_delete_table_text));
    } 
    return this.aCU;
  }
  
  public void YF() { xJ().show(); }
  
  public void YG() {
    long l1 = Long.parseLong(this.caC);
    long l2 = Long.parseLong(this.bYw);
    this.ccV.u(l2, l1);
  }
  
  public String[] Yv() {
    Object object;
    String str = this.ccR.getText().toString().trim();
    if (str.length() == 0 || str.contains("'")) {
      if (str.length() == 0) {
        n.w(this.mActivity, R.string.pos_open_table_table_name_not_null);
      } else {
        n.w(this.mActivity, R.string.pos_product_name_error);
      } 
      this.ccR.requestFocus();
      n.b(this.mActivity, this.ccR);
      return null;
    } 
    if (this.bYw == null || this.bYw.length() == 0) {
      n.w(this.mActivity, R.string.pos_open_table_area_please_select);
      return null;
    } 
    if (this.caG.getParent() != null) {
      String str1 = this.caG.getText().toString().trim();
      if (str1.contains("'")) {
        n.eP(R.string.pos_product_name_error);
        this.caG.requestFocus();
        n.b(this.mActivity, this.ccR);
        return null;
      } 
      if (!by.isNull(str1)) {
        object = str1;
        if (by.parseDouble(str1) == 0.0D) {
          n.eP(R.string.pos_opentable_max_person);
          this.caG.requestFocus();
          n.b(this.mActivity, this.ccR);
          return null;
        } 
      } else {
        n.eP(R.string.pos_opentable_max_person);
        this.caG.requestFocus();
        n.b(this.mActivity, this.ccR);
        return null;
      } 
    } else {
      object = null;
    } 
    return new String[] { str, object };
  }
  
  public void Yw() {
    String[] arrayOfString = Yv();
    if (arrayOfString != null)
      this.ccV.o(new TableEntity(Long.valueOf(this.caC).longValue(), Long.valueOf(this.bYw).longValue(), arrayOfString[0], by.parseInt(arrayOfString[1]))); 
  }
  
  public void a(a parama) { this.ccT = parama; }
  
  public void a(TableEntity paramTableEntity, a parama, boolean paramBoolean1, ArrayList<a> paramArrayList, boolean paramBoolean2) {
    String str1;
    this.caB = paramBoolean2;
    ArrayList arrayList = new ArrayList();
    arrayList.add(this.ccQ);
    arrayList.add(this.caH);
    String str2 = new av(this.mActivity);
    this.caO = str2.auC();
    str2.close();
    String str4 = null;
    if (paramTableEntity == null) {
      str2 = null;
    } else {
      null = new StringBuilder();
      null.append(paramTableEntity.getID());
      null.append("");
      str2 = null.toString();
    } 
    this.caC = str2;
    EditText editText2 = this.ccR;
    if (paramTableEntity == null) {
      str3 = null;
    } else {
      String str;
      str3 = paramTableEntity.Vz();
    } 
    editText2.setText(str3);
    if (str2 == null) {
      this.tvTitle.setText(R.string.pos_open_table_title_add);
      this.ccS.setVisibility(0);
      this.caJ.setVisibility(8);
      this.ccR.requestFocus();
    } else {
      this.tvTitle.setText(R.string.pos_open_table_title_update);
      this.ccS.setVisibility(8);
      this.caJ.setVisibility(0);
      View view = getCurrentFocus();
      if (view != null)
        view.clearFocus(); 
      this.tvTitle.setFocusable(true);
      this.tvTitle.setFocusableInTouchMode(true);
    } 
    String str3 = str4;
    if (parama.getId() > 0L) {
      null = new StringBuilder();
      null.append(parama.getId());
      null.append("");
      str3 = null.toString();
    } 
    this.bYw = str3;
    if (this.bYw == null) {
      this.caI.setText(R.string.pos_product_please_select);
    } else {
      this.caI.setText(parama.XX());
    } 
    this.caO = -1;
    if (paramArrayList != null && paramBoolean1) {
      int i = paramArrayList.size();
      this.caL = new String[i];
      this.caM = new String[i];
      for (i = 0; i < paramArrayList.size(); i++) {
        a a1 = (a)paramArrayList.get(i);
        if (a1 != null) {
          this.caL[i] = a1.XX();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(a1.getId());
          stringBuilder.append("");
          String str = stringBuilder.toString();
          this.caM[i] = str;
          stringBuilder = new StringBuilder();
          stringBuilder.append(parama.getId());
          stringBuilder.append("");
          if (str.equals(stringBuilder.toString()))
            this.caO = i; 
        } 
      } 
    } 
    if (str2 != null) {
      this.ccU.setVisibility(0);
    } else {
      this.ccU.setVisibility(8);
    } 
    arrayList.add(this.caF);
    EditText editText1 = this.caG;
    if (paramTableEntity == null) {
      str1 = "";
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1.XZ());
      stringBuilder.append("");
      str1 = stringBuilder.toString();
    } 
    editText1.setText(str1);
    X(arrayList);
    super.show();
  }
  
  public void a(a parama, boolean paramBoolean1, ArrayList<a> paramArrayList, boolean paramBoolean2) { a(null, parama, paramBoolean1, paramArrayList, paramBoolean2); }
  
  public void a(boolean paramBoolean1, TableEntity paramTableEntity, boolean paramBoolean2) {
    if (paramBoolean1) {
      if (this.ccT != null)
        this.ccT.a(paramBoolean1, paramTableEntity); 
      Xp();
      n.w(this.mActivity, R.string.pos_product_created);
      YE();
      if (paramBoolean2) {
        this.ccR.setText("");
        this.caG.setText("");
        this.ccR.requestFocus();
        n.b(this.mActivity, this.ccR);
        return;
      } 
      cancel();
      return;
    } 
    EditText editText = this.ccR;
    n.j(editText);
    n.b(this.mActivity, editText);
  }
  
  public void eL(boolean paramBoolean) {
    if (paramBoolean) {
      if (this.ccT != null)
        this.ccT.b(paramBoolean, new TableEntity(by.parseLong(this.caC), by.parseLong(this.bYw), this.ccR.getText().toString(), by.parseInt(this.caG.getText().toString().trim()))); 
      Xp();
      YE();
      cancel();
      n.w(this.mActivity, R.string.pos_product_updated);
      return;
    } 
    EditText editText = this.ccR;
    n.j(editText);
    n.b(this.mActivity, editText);
  }
  
  public void eM(boolean paramBoolean) {
    if (paramBoolean) {
      YE();
      this.aCU.cancel();
      Xp();
      cancel();
      n.w(this.mActivity, R.string.pos_product_deleted);
      if (this.ccT != null) {
        this.ccT.c(paramBoolean, new TableEntity(by.parseLong(this.caC), by.parseLong(this.bYw), this.ccR.getText().toString(), by.parseInt(this.caG.getText().toString().trim())));
        return;
      } 
    } else {
      n.eP(R.string.diagnose_state_failed);
    } 
  }
  
  public void eN(boolean paramBoolean) {
    String[] arrayOfString = Yv();
    if (arrayOfString != null) {
      String str = arrayOfString[0];
      long l = System.currentTimeMillis();
      this.ccV.a(new TableEntity(l, Long.valueOf(this.bYw).longValue(), str, by.parseInt(arrayOfString[1])), paramBoolean);
    } 
  }
  
  public void fa(String paramString) { n.o(paramString); }
  
  @Deprecated
  public void show() { super.show(); }
  
  public static interface a {
    void a(boolean param1Boolean, TableEntity param1TableEntity);
    
    void b(boolean param1Boolean, TableEntity param1TableEntity);
    
    void c(boolean param1Boolean, TableEntity param1TableEntity);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\b\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */