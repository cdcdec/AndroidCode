package com.laiqian.pos;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.pos.model.orders.b;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.h;
import com.laiqian.ui.container.w;
import com.laiqian.ui.s;
import com.laiqian.util.av;
import java.text.SimpleDateFormat;

public class dd extends Dialog {
  private static final SimpleDateFormat ciK = new SimpleDateFormat("MM/dd/yyyy");
  
  a ciL;
  
  b ciM;
  
  dc ciN;
  
  public dd(Context paramContext, @NonNull b paramb) {
    super(paramContext, 2131690280);
    if (paramb.orderNo == null) {
      Toast.makeText(getContext(), "ERROR: orderNo cannot be null", 0).show();
      dismiss();
      return;
    } 
    this.ciM = paramb;
    av av = new av(getContext());
    this.ciN = av.rB(paramb.orderNo);
    av.close();
    if (this.ciN == null)
      this.ciN = new dc(); 
    requestWindowFeature(1);
    this.ciL = a.d(getWindow());
    setupViews();
    setListeners();
    aaa();
  }
  
  private void aaa() {
    ((TextView)this.ciL.ciQ.cAP.getView()).setText(ciK.format(this.ciM.bkf));
    ((TextView)this.ciL.ciR.cAP.getView()).setText(bm.ax(this.ciM.cyO.doubleValue()));
    if (!TextUtils.isEmpty(this.ciN.ciI))
      ((EditText)this.ciL.ciS.dwQ.getView()).setText(this.ciN.ciI); 
    if (!TextUtils.isEmpty(this.ciN.address))
      ((EditText)this.ciL.ciT.dwQ.getView()).setText(this.ciN.address); 
    if (!TextUtils.isEmpty(this.ciN.ciJ))
      ((EditText)this.ciL.ciU.dwQ.getView()).setText(this.ciN.ciJ); 
  }
  
  private void aab() {
    a a1 = a.bo(getContext());
    a1.am(a1.a(this.ciM));
    av av = new av(getContext());
    int i = av.bp(this.ciM.orderNo, "T_PRODUCTDOC");
    av.g(this.ciM.orderNo, "T_PRODUCTDOC", i + 1);
    av.close();
  }
  
  private void aac() {
    this.ciM.ciN = this.ciN;
    av av = new av(getContext());
    av.a(this.ciM.orderNo, this.ciN);
    av.close();
  }
  
  private void setListeners() {
    this.ciL.ciV.setOnClickListener(new de(this));
    this.ciL.byK.setOnClickListener(new df(this));
    ((EditText)this.ciL.ciS.dwQ.getView()).addTextChangedListener(new dg(this));
    ((EditText)this.ciL.ciT.dwQ.getView()).addTextChangedListener(new dh(this));
    ((EditText)this.ciL.ciU.dwQ.getView()).addTextChangedListener(new di(this));
  }
  
  private void setupViews() {
    this.ciL.tvTitle.setText(getContext().getString(2131629317));
    ((TextView)this.ciL.ciP.cAO.getView()).setText(getContext().getString(2131625400));
    ((TextView)this.ciL.ciQ.cAO.getView()).setText(getContext().getString(2131624956));
    ((TextView)this.ciL.ciR.cAO.getView()).setText(getContext().getString(2131624209));
    ((TextView)this.ciL.ciS.cAO.getView()).setText(getContext().getString(2131624844));
    ((TextView)this.ciL.ciT.cAO.getView()).setText(getContext().getString(2131624172));
    ((TextView)this.ciL.ciU.cAO.getView()).setText(getContext().getString(2131624490));
    ((ViewGroup)this.ciL.ciP.getView()).setVisibility(8);
    getWindow().setLayout(-2, -2);
  }
  
  private static class a {
    public View aQG;
    
    public Button byK;
    
    public w ciP = new w(2131297652);
    
    public w ciQ = new w(2131297543);
    
    public w ciR = new w(2131297510);
    
    public h ciS = new h(2131297532);
    
    public h ciT = new h(2131297500);
    
    public h ciU = new h(2131297527);
    
    public TextView ciV;
    
    public TextView tvTitle;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.tvTitle = (TextView)s.z(param1View, 2131299802);
      a(this.ciP);
      a(this.ciQ);
      a(this.ciR);
      a(this.ciS);
      a(this.ciT);
      a(this.ciU);
      this.byK = (Button)s.z(param1View, 2131296614);
      this.ciV = (TextView)s.z(param1View, 2131296644);
    }
    
    private void a(ab param1ab) { param1ab.S(this.aQG.findViewById(param1ab.getId())); }
    
    public static a d(Window param1Window) { return new a(View.inflate(param1Window.getContext(), 2131427561, s.p(param1Window))); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */