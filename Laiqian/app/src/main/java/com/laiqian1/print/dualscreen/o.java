package com.laiqian.print.dualscreen;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.entity.aq;
import com.laiqian.infrastructure.R;
import com.laiqian.models.an;
import com.laiqian.util.av;
import com.laiqian.util.bi;
import com.laiqian.util.ca;
import com.laiqian.util.n;
import io.reactivex.a.a;
import java.lang.ref.WeakReference;

@TargetApi(17)
public class o extends Presentation {
  @Nullable
  private static WeakReference<o> cFH;
  
  private a bfQ = new a();
  
  public final a cFI;
  
  private final b cFJ;
  
  static  {
  
  }
  
  @TargetApi(17)
  public o(Context paramContext, Display paramDisplay) {
    super(paramContext, paramDisplay);
    cFH = new WeakReference(this);
    this.cFI = a.k(LayoutInflater.from(getContext()));
    if ("S21".equals(ca.get("persist.sys.model", "unknown"))) {
      setContentView(this.cFI.aQG, new ViewGroup.LayoutParams('Ǡ', 'Đ'));
    } else {
      setContentView(this.cFI.aQG);
    } 
    this.cFJ = new b(getContext(), this.cFI);
    setupViews();
  }
  
  @Nullable
  public static o afM() { return (cFH == null) ? null : (o)cFH.get(); }
  
  @TargetApi(17)
  private void setupViews() {
    this.cFI.cFO.setText("");
    ((TextView)this.cFI.cFL.cAO.getView()).setText(getContext().getString(R.string.print_content_discount));
    ((TextView)this.cFI.cFM.cAO.getView()).setText(getContext().getString(R.string.print_content_point_deduction));
    ((TextView)this.cFI.cFM.cAP.getView()).setTextColor(getResources().getColor(R.color.text_main_black));
    ((TextView)this.cFI.cFL.cAP.getView()).setTextColor(getResources().getColor(R.color.text_main_black));
  }
  
  public void aF(double paramDouble) {
    paramDouble = Math.abs(paramDouble);
    a a1 = this.cFI;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootApplication.zA());
    stringBuilder.append(bi.ax(paramDouble));
    a1.lh(stringBuilder.toString());
    if (n.bc(paramDouble)) {
      this.cFI.fK(false);
      return;
    } 
    this.cFI.fK(true);
  }
  
  public void aG(double paramDouble) {
    paramDouble = Math.abs(paramDouble);
    a a1 = this.cFI;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootApplication.zA());
    stringBuilder.append(bi.ax(paramDouble));
    a1.fh(stringBuilder.toString());
  }
  
  public void aH(double paramDouble) {
    paramDouble = Math.abs(paramDouble);
    a a1 = this.cFI;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootApplication.zA());
    stringBuilder.append(bi.ax(paramDouble));
    a1.lg(stringBuilder.toString());
    if (n.bc(paramDouble)) {
      this.cFI.fJ(false);
      return;
    } 
    this.cFI.fJ(true);
  }
  
  public void ae(double paramDouble) {
    if (n.bc(paramDouble)) {
      this.cFI.fL(false);
      return;
    } 
    this.cFI.fL(true);
    a a1 = this.cFI;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getContext().getString(R.string.print_content_cash_change));
    stringBuilder.append(" ");
    stringBuilder.append(RootApplication.zA());
    stringBuilder.append(bi.ax(paramDouble));
    a1.li(stringBuilder.toString());
  }
  
  public void afN() {
    an an = new an(RootApplication.zv());
    an.c c = an.Vu();
    if (c != null && !TextUtils.isEmpty(c.aVs)) {
      this.cFI.cGg.setText(c.aVs);
    } else {
      this.cFI.cGg.setText(R.string.app_name);
    } 
    an.close();
  }
  
  public void afO() {
    av av = new av(RootApplication.zv());
    String str = av.Tx();
    if (!TextUtils.isEmpty(str)) {
      str = a.lb(str).afB();
      if (!TextUtils.isEmpty(str)) {
        this.cFI.cGh.setImageURI(Uri.parse(str));
      } else {
        this.cFI.cGh.setImageResource(R.drawable.pos_logo);
      } 
    } 
    av.close();
  }
  
  public b afP() { return this.cFJ; }
  
  public void b(aq paramaq, Double paramDouble) {
    if (paramaq != null && RootApplication.getLaiqianPreferenceManager().avG()) {
      this.cFI.b(paramaq, paramDouble);
      this.cFI.fI(true);
      return;
    } 
    this.cFI.fI(false);
  }
  
  public void fA(boolean paramBoolean) {
    if (paramBoolean && RootApplication.getLaiqianPreferenceManager().avz()) {
      this.cFI.fA(paramBoolean);
      return;
    } 
    this.cFI.fA(false);
  }
  
  public void fB(boolean paramBoolean) {
    if (paramBoolean && RootApplication.getLaiqianPreferenceManager().avG()) {
      this.cFI.fI(paramBoolean);
      return;
    } 
    this.cFI.fI(false);
  }
  
  public void fC(boolean paramBoolean) {
    byte b1;
    View view = this.cFI.cFQ;
    if (paramBoolean) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    view.setVisibility(b1);
  }
  
  protected void onStop() {
    super.onStop();
    this.bfQ.clear();
  }
  
  public void p(double paramDouble) {
    paramDouble = Math.abs(paramDouble);
    if (a.zR().Ab()) {
      this.cFI.gc(getContext().getString(R.string.print_content_discount));
      return;
    } 
    a a1 = this.cFI;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getContext().getString(R.string.print_content_discount));
    stringBuilder.append((int)Math.round(paramDouble));
    stringBuilder.append("%");
    a1.gc(stringBuilder.toString());
  }
  
  class o {}
  
  class o {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\print\dualscreen\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */