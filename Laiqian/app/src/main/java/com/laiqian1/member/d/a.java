package com.laiqian.member.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.member.report.al;
import com.laiqian.models.bh;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.m;
import com.laiqian.ui.a.p;
import com.laiqian.ui.a.w;
import com.laiqian.util.av;
import com.laiqian.util.e;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import com.orhanobut.logger.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a {
  List<Map<String, String>> aIG;
  
  private w aNu;
  
  long[] bqs;
  
  private ArrayList<HashMap<String, String>> bvM;
  
  protected final String bvN = "mail";
  
  protected Dialog bvO;
  
  private m bvS;
  
  private p bvT;
  
  private TextView bvi;
  
  private TextView bvj;
  
  private PopupWindow bvk;
  
  private TextView bvl;
  
  av bxR;
  
  al bxS;
  
  public String bxT;
  
  e.a<String> bxU = new h(this);
  
  Context context;
  
  public String userName;
  
  public a(Context paramContext) {
    this.context = paramContext;
    this.bxR = RootApplication.getLaiqianPreferenceManager();
    this.bvO = new bb(paramContext);
    try {
      this.bxS = new al(paramContext);
      return;
    } catch (Exception paramContext) {
      a.e(paramContext);
      return;
    } 
  }
  
  private void Qs() {
    HashMap hashMap = (HashMap)this.bvM.get(0);
    ArrayList arrayList = n.a((Activity)this.context, true);
    if (arrayList.isEmpty()) {
      hashMap.put("state", this.context.getString(R.string.pos_report_export_to_u_no));
      hashMap.put("address", null);
      return;
    } 
    hashMap.put("state", this.context.getString(R.string.pos_report_export_to_u_has));
    hashMap.put("address", arrayList.get(0));
  }
  
  private void fF(String paramString) {
    d.b("GeneralExcelFile", new Object[] { "GeneralExcelFile " });
    (new g(this, this.bxU, "", paramString)).asz();
  }
  
  private void fx(String paramString) {
    if (paramString == null) {
      if (!n.a((Activity)this.context, true).isEmpty()) {
        Qs();
        this.bvT.notifyDataSetChanged();
        paramString = (String)((HashMap)this.bvM.get(0)).get("address");
        if (paramString != null) {
          fx(paramString);
          return;
        } 
      } 
    } else {
      Rect rect;
      if (paramString == "mail") {
        if (this.bvk == null) {
          boolean bool;
          View view1 = View.inflate(this.context, R.layout.pos_export_mail, null);
          this.bvj = (TextView)view1.findViewById(R.id.address);
          this.bvi = (TextView)view1.findViewById(R.id.domain);
          if (!a.zR().Ad() && !a.zR().Ab()) {
            bool = true;
          } else {
            bool = false;
          } 
          if (bool) {
            int k;
            null = this.context.getResources();
            if (this.context.getResources().getBoolean(R.bool.is_ShowingIndustry)) {
              k = R.array.pos_mail_address;
            } else {
              k = R.array.pos_mail_address_foreign;
            } 
            String[] arrayOfString1 = null.getStringArray(k);
            String[] arrayOfString2 = RootApplication.getLaiqianPreferenceManager().auT();
            if (arrayOfString2 != null) {
              this.bvj.setText(arrayOfString2[0]);
              this.bvi.setText(arrayOfString2[1]);
              view1.requestFocus();
            } else {
              this.bvj.setText("");
              this.bvj.requestFocus();
              this.bvi.setText(arrayOfString1[0]);
              n.b(this.context, this.bvj);
            } 
            this.aNu = new w(this.context, arrayOfString1, new c(this, arrayOfString1));
            this.bvi.setOnClickListener(new d(this));
          } else {
            this.bvi.setVisibility(8);
          } 
          this.bvk = new PopupWindow(view1, -2, -2, true);
          this.bvk.setBackgroundDrawable(new ColorDrawable());
          this.bvk.setOutsideTouchable(true);
          this.bvl = (TextView)view1.findViewById(R.id.tvError);
          view1.findViewById(R.id.send).setOnClickListener(new e(this, bool));
          view1.findViewById(R.id.canal).setOnClickListener(new f(this));
        } 
        rect = new Rect();
        View view = this.bvS.ark();
        view.getGlobalVisibleRect(rect);
        int i = rect.right;
        int j = rect.top;
        this.bvl.setText(null);
        this.bvk.showAtLocation(view, 0, i, j);
        return;
      } 
      if (n.a((Activity)this.context, true).isEmpty()) {
        Qs();
        this.bvT.notifyDataSetChanged();
        return;
      } 
      fF(rect);
      this.bvO.show();
    } 
  }
  
  public void QK() {
    if (this.bvM == null) {
      this.bvM = new ArrayList();
      HashMap hashMap = new HashMap();
      hashMap.put("name", this.context.getString(R.string.pos_report_export_to_u));
      hashMap.put("state", null);
      hashMap.put("address", null);
      this.bvM.add(hashMap);
      hashMap = new HashMap();
      hashMap.put("name", this.context.getString(R.string.pos_report_export_to_mail));
      hashMap.put("state", null);
      hashMap.put("address", "mail");
      this.bvM.add(hashMap);
    } 
    Qs();
    if (this.bvS == null) {
      Context context1 = this.context;
      ArrayList arrayList = this.bvM;
      int i = R.layout.pos_choose_item;
      int j = R.id.spinner_text;
      int k = R.id.spinner_right;
      this.bvT = new p(context1, arrayList, i, new String[] { "name", "state" }, new int[] { j, k });
      this.bvS = new m((Activity)this.context, false);
      this.bvS.a(this.bvT);
      this.bvS.getListView().setOnItemClickListener(new b(this));
      this.bvS.setTitle(R.string.pos_report_export_to);
      DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
      this.bvS.setWidth(displayMetrics.widthPixels / 4);
    } 
    this.bvT.notifyDataSetChanged();
    this.bvS.show();
  }
  
  public void b(String paramString, File paramFile) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.context.getString(R.string.pos_report_export_foldername));
    stringBuilder.append("/");
    stringBuilder.append(paramFile.getName());
    if (!n.d(paramFile, new File(paramString, stringBuilder.toString())))
      this.context.getString(R.string.pos_report_export_u_fail); 
  }
  
  public void b(String paramString1, String paramString2, String[] paramArrayOfString) {
    String str1;
    String str2 = "";
    if (this.context.getResources().getBoolean(R.bool.is_ShowingIndustry)) {
      str1 = this.context.getString(R.string.pos_report_export_mail_body);
    } else {
      av av1 = new av(this.context);
      null = null;
      try {
        bh bh = new bh(this.context);
        null = bh;
      } catch (Exception exception) {
        a.e(exception);
      } 
      String str = null.iB(av1.atm());
      null.close();
      av1.close();
      str1 = String.format(this.context.getString(R.string.pos_report_export_mail_body_evako), new Object[] { str });
    } 
    if (!n.a(new String[] { paramString1 }, paramString2, str1, paramArrayOfString))
      str2 = this.context.getString(R.string.pos_report_export_mail_send_fail); 
    if (str2 == null)
      this.bxR.rr(paramString1); 
  }
  
  public void e(long[] paramArrayOfLong) { this.bqs = paramArrayOfLong; }
  
  public void u(List<Map<String, String>> paramList) { this.aIG = paramList; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */