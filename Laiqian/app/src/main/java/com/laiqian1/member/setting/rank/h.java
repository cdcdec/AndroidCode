package com.laiqian.member.setting.rank;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.entity.g;
import com.laiqian.member.setting.bc;
import com.laiqian.models.l;
import com.laiqian.vip.R;
import java.util.ArrayList;
import java.util.Iterator;

public class h implements a.a {
  private a.b bFV;
  
  private ArrayList<g> bFW;
  
  private ArrayList<g> bFX;
  
  private boolean isDiscountConvertion;
  
  private Context mContext;
  
  private int mIndex;
  
  public h(Context paramContext, a.b paramb) {
    this.mContext = paramContext;
    this.bFV = paramb;
    this.isDiscountConvertion = paramContext.getResources().getBoolean(R.bool.is_DiscountConvertion);
  }
  
  private boolean Rq() {
    if (!this.bFV.Rq())
      return false; 
    ((g)this.bFW.get(this.mIndex)).EV();
    double d1 = ((g)this.bFW.get(this.mIndex)).EU();
    double d2 = ((g)this.bFW.get(this.mIndex)).ET();
    if (d1 <= 0.0D || d1 > 100.0D) {
      fU(this.mContext.getString(R.string.invalid_discount));
      return false;
    } 
    a.b b1 = null;
    int i = 0;
    while (i < this.bFW.size()) {
      a.b b2 = (g)this.bFW.get(i);
      if (b1 != null) {
        Context context;
        if (b1.EV().equals(b2.EV())) {
          this.bFV.fU(this.mContext.getString(R.string.member_rank_name_not_fit));
          return false;
        } 
        if (b1.EU() < b2.EU())
          b2.k(d1); 
        if (b1.EU() < b2.EU()) {
          d1 = b1.EU();
          if (this.isDiscountConvertion) {
            b1 = this.bFV;
            Context context1 = this.mContext;
            i = R.string.member_discount_not_max_fit;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(100.0D - d1);
            stringBuilder1.append("%");
            b1.fU(context1.getString(i, new Object[] { stringBuilder1.toString() }));
            return false;
          } 
          b1 = this.bFV;
          context = this.mContext;
          i = R.string.member_discount_not_fit;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(d1);
          stringBuilder.append("%");
          b1.fU(context.getString(i, new Object[] { stringBuilder.toString() }));
          return false;
        } 
        if (b1.ET() > context.ET())
          context.j(d2); 
        if (b1.ET() > context.ET()) {
          b2 = this.bFV;
          Context context1 = this.mContext;
          i = R.string.member_amount_not_fit;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(b1.ET());
          stringBuilder.append("");
          b2.fU(context1.getString(i, new Object[] { stringBuilder.toString() }));
          return false;
        } 
      } 
      i++;
      b1 = b2;
    } 
    return true;
  }
  
  public void back() {
    byte b1 = 0;
    boolean bool = false;
    while (b1 < this.bFW.size()) {
      bool = ((g)this.bFW.get(b1)).equals(this.bFX.get(b1));
      if (!bool)
        break; 
      b1++;
    } 
    if (bool) {
      this.bFV.back();
      return;
    } 
    this.bFV.H(this.bFW);
  }
  
  public void c(int paramInt, ArrayList<g> paramArrayList) {
    this.mIndex = paramInt;
    this.bFW = paramArrayList;
    this.bFX = new ArrayList(this.bFW.size());
    try {
      Iterator iterator = this.bFW.iterator();
      while (iterator.hasNext())
        this.bFX.add(((g)iterator.next()).EO()); 
    } catch (CloneNotSupportedException paramArrayList) {
      a.e(paramArrayList);
    } 
  }
  
  public void cW(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    paramString = paramString.trim();
    this.bFV.ge(paramString);
    ((g)this.bFW.get(this.mIndex)).cW(paramString);
  }
  
  public void fU(String paramString) { Toast.makeText(this.mContext, paramString, 0).show(); }
  
  public void gc(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    double d2 = Double.valueOf(paramString.trim()).doubleValue();
    double d1 = d2;
    if (this.isDiscountConvertion)
      d1 = 100.0D - d2; 
    this.bFV.at(d1);
    ((g)this.bFW.get(this.mIndex)).k(d1);
  }
  
  public void gd(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    paramString = paramString.trim();
    this.bFV.au(Double.valueOf(paramString).doubleValue());
    ((g)this.bFW.get(this.mIndex)).j(Double.valueOf(paramString).doubleValue());
  }
  
  public void save() {
    if (Rq()) {
      bc.RH().x(this.bFW);
      try {
        exception = new l(this.mContext);
      } catch (Exception exception) {
        a.e(exception);
        exception = null;
      } 
      exception.m(((g)this.bFW.get(this.mIndex)).getId(), ((g)this.bFW.get(this.mIndex)).EV());
      exception.close();
      fU(this.mContext.getString(R.string.save_success));
      this.bFV.G(this.bFW);
      (new a(this, null)).execute(new Void[0]);
    } 
  }
  
  private class a extends AsyncTask<Void, Void, Boolean> {
    private a(h this$0) {}
    
    protected void b(Boolean param1Boolean) {}
    
    protected Boolean g(Void... param1VarArgs) { return Boolean.valueOf(bc.RH().a(h.a(this.bFY), h.b(this.bFY))); }
    
    protected void onPreExecute() {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\rank\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */