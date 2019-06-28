package com.laiqian.opentable.pos;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.d.a;
import com.laiqian.opentable.R;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.opentable.tablelist.TableList;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.w;
import com.laiqian.util.by;
import com.laiqian.util.m;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Iterator;

public class c extends d {
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
  
  private a caK;
  
  private String[] caL;
  
  private String[] caM;
  
  private w caN;
  
  private int caO;
  
  private FragmentActivity caP;
  
  private TableEntity caQ;
  
  private a caR;
  
  private c caS;
  
  private final EditText caT;
  
  private final View caU;
  
  public c(FragmentActivity paramFragmentActivity, Class<? extends TableList> paramClass) {
    super(paramFragmentActivity, R.layout.pos_open_table_main_dialog);
    setPositionTop();
    this.caP = paramFragmentActivity;
    View view = this.mView.findViewById(R.id.parameter);
    this.tvTitle = (TextView)view.findViewById(R.id.title);
    this.caD = (ViewGroup)view.findViewById(R.id.product_info);
    this.caE = new ArrayList();
    this.caF = this.caD.findViewById(R.id.table_max_person_l);
    this.caG = (EditText)this.caF.findViewById(R.id.max_person);
    this.caF.setOnClickListener(new m.b(this.mActivity, this.caG));
    this.caE.add(this.caF);
    this.caH = this.caD.findViewById(R.id.aera_l);
    this.caI = (TextView)this.caH.findViewById(R.id.tv_area);
    this.caH.setOnClickListener(new m.b(this.mActivity, this.caI));
    this.caI.setOnClickListener(new d(this, paramClass));
    this.caE.add(this.caH);
    this.caJ = this.mView.findViewById(R.id.table_update_bottom);
    this.mView.findViewById(R.id.canal).setOnClickListener(new f(this));
    this.mView.findViewById(R.id.sure).setOnClickListener(new g(this));
    this.caU = findViewById(R.id.ll_table_cost);
    this.caT = (EditText)this.caU.findViewById(R.id.et_table_cost);
    n.a(this.caT, 9, 2);
  }
  
  private void X(ArrayList<View> paramArrayList) {
    Iterator iterator = this.caE.iterator();
    byte b = 0;
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
        b++;
        continue;
      } 
      if (bool) {
        ((ViewGroup)viewParent).removeView(view);
        continue;
      } 
      if (bool1) {
        this.caD.addView(view, b);
        b++;
      } 
    } 
  }
  
  private void a(View paramView, TableEntity paramTableEntity) { // Byte code:
    //   0: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   3: invokevirtual Cv : ()Z
    //   6: ifeq -> 66
    //   9: invokestatic XD : ()Z
    //   12: ifeq -> 66
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual setVisibility : (I)V
    //   20: aload_2
    //   21: ifnull -> 72
    //   24: aload_2
    //   25: invokevirtual Yg : ()Lcom/laiqian/opentable/common/entity/c;
    //   28: invokevirtual Yk : ()Ljava/lang/String;
    //   31: astore_2
    //   32: aload_0
    //   33: getfield caT : Landroid/widget/EditText;
    //   36: astore_3
    //   37: aload_2
    //   38: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   41: ifne -> 53
    //   44: aload_2
    //   45: astore_1
    //   46: aload_2
    //   47: invokestatic parseInt : (Ljava/lang/String;)I
    //   50: ifne -> 60
    //   53: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   56: invokevirtual Cx : ()Ljava/lang/String;
    //   59: astore_1
    //   60: aload_3
    //   61: aload_1
    //   62: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   65: return
    //   66: aload_1
    //   67: bipush #8
    //   69: invokevirtual setVisibility : (I)V
    //   72: return }
  
  private boolean e(c paramc) {
    if (this.caT.getVisibility() == 0) {
      String str1;
      String str2 = this.caT.getText().toString().trim();
      if (TextUtils.isEmpty(str2)) {
        Toast.makeText(this.mActivity, this.mActivity.getString(R.string.table_cost_con_not_empty), 0).show();
        return true;
      } 
      if (TextUtils.isEmpty(str2)) {
        str1 = "0";
      } else {
        str1 = str2;
      } 
      paramc.jm(str1);
      a.AZ().cf(str2);
    } 
    return false;
  }
  
  public String[] Yv() {
    Object object;
    if (this.bYw == null || this.bYw.length() == 0) {
      n.w(this.mActivity, R.string.pos_open_table_area_please_select);
      return null;
    } 
    if (this.caG.getParent() != null) {
      String str = this.caG.getText().toString().trim();
      object = str;
      if (str.contains("'")) {
        n.eP(R.string.pos_product_name_error);
        this.caG.requestFocus();
        return null;
      } 
    } else {
      object = null;
    } 
    return new String[] { object };
  }
  
  public void Yw() {
    String[] arrayOfString = Yv();
    if (arrayOfString != null) {
      String str = arrayOfString[0];
      if (TextUtils.isEmpty(str)) {
        n.eP(R.string.pos_opentable_max_person);
        return;
      } 
      if (!str.matches("\\d{1,9}") || Integer.parseInt(str) <= 0) {
        n.eP(R.string.pos_reserve_persons_value_valid);
        return;
      } 
    } 
    if (arrayOfString != null) {
      if (this.caS != null) {
        this.caS.gy(by.parseInt(arrayOfString[0]));
        if (e(this.caS))
          return; 
      } else {
        this.caQ.Yg().gy(by.parseInt(arrayOfString[0]));
        if (e(this.caQ.Yg()))
          return; 
      } 
      this.caK.a(this.caR, this.caQ, this.caS);
      cancel();
    } 
  }
  
  public void a(TableEntity paramTableEntity, a parama, boolean paramBoolean1, ArrayList<a> paramArrayList, boolean paramBoolean2, @Nullable c paramc) {
    a(this.caU, paramTableEntity);
    EditText editText = this.caG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity.XZ());
    stringBuilder.append("");
    editText.setText(stringBuilder.toString());
    b(paramTableEntity, parama, paramBoolean1, paramArrayList, paramBoolean2, paramc);
    this.caI.setClickable(false);
    super.show();
  }
  
  public void a(a parama) { this.caK = parama; }
  
  public void b(TableEntity paramTableEntity, a parama, boolean paramBoolean1, ArrayList<a> paramArrayList, boolean paramBoolean2, @Nullable c paramc) {
    this.caB = paramBoolean2;
    this.caQ = paramTableEntity;
    this.caR = parama;
    c c1 = null;
    if (paramc != null) {
      this.caS = paramc;
    } else {
      this.caS = null;
    } 
    ArrayList arrayList = new ArrayList();
    arrayList.add(this.caH);
    if (paramTableEntity == null) {
      paramc = c1;
    } else {
      String str;
      null = new StringBuilder();
      null.append(paramTableEntity.getID());
      null.append("");
      str = null.toString();
    } 
    this.caC = str;
    int i = 0;
    if (str == null) {
      this.tvTitle.setText(R.string.pos_open_table_title_add);
      this.caJ.setVisibility(8);
    } else {
      this.tvTitle.setText(R.string.pos_opentable_title);
      this.caJ.setVisibility(0);
      View view = getCurrentFocus();
      if (view != null)
        view.clearFocus(); 
      this.tvTitle.setFocusable(true);
      this.tvTitle.setFocusableInTouchMode(true);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(parama.getId());
    stringBuilder.append("");
    this.bYw = stringBuilder.toString();
    if (this.bYw == null) {
      this.caI.setText(R.string.pos_product_please_select);
    } else {
      int j;
      if (this.caS == null) {
        j = paramTableEntity.Yg().Yl();
      } else {
        j = this.caS.Yl();
      } 
      if (this.caS == null && j == 0) {
        TextView textView = this.caI;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(parama.XX());
        stringBuilder1.append(paramTableEntity.Vz());
        textView.setText(stringBuilder1.toString());
      } else {
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.caP.getResources().getString(R.string.pos_product_dialog_number));
        stringBuilder.append(j);
        String str = stringBuilder.toString();
        TextView textView = this.caI;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(parama.XX());
        stringBuilder1.append(paramTableEntity.Vz());
        stringBuilder1.append(".");
        stringBuilder1.append(str);
        textView.setText(stringBuilder1.toString());
      } 
    } 
    this.caO = -1;
    if (paramArrayList != null && paramBoolean1) {
      int j = paramArrayList.size();
      this.caL = new String[j];
      this.caM = new String[j];
      for (j = i; j < paramArrayList.size(); j++) {
        a a1 = (a)paramArrayList.get(j);
        if (a1 != null) {
          this.caL[j] = a1.XX();
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(a1.getId());
          stringBuilder1.append("");
          String str = stringBuilder1.toString();
          this.caM[j] = str;
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(parama.getId());
          stringBuilder1.append("");
          if (str.equals(stringBuilder1.toString()))
            this.caO = j; 
        } 
      } 
    } 
    if (paramTableEntity.getState() != 0) {
      int j;
      if (this.caS != null) {
        j = paramTableEntity.XZ();
      } else {
        j = paramTableEntity.Yg().Ym();
      } 
      EditText editText = this.caG;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(j);
      stringBuilder1.append("");
      editText.setText(stringBuilder1.toString());
      n.j(this.caG);
    } else {
      this.caG.postDelayed(new h(this), 100L);
    } 
    arrayList.add(this.caF);
    X(arrayList);
  }
  
  @Deprecated
  public void show() { super.show(); }
  
  public static interface a {
    void NB();
    
    void a(a param1a, TableEntity param1TableEntity, c param1c);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\pos\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */