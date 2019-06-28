package com.laiqian.pos.industry.weiorder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.bumptech.glide.g;
import com.google.a.a.a.a.a.a;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.entity.aw;
import com.laiqian.pos.dw;
import com.laiqian.pos.industry.weiorder.auth.a;
import com.laiqian.pos.model.orders.WeiOrderDetail;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.usage.receipt.model.ReceiptPrintSettings;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.bk;
import com.laiqian.util.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class df {
  Context context;
  
  dh cvn;
  
  aw cvo;
  
  ReceiptPrintSettings cvp;
  
  a cvq;
  
  a cvr;
  
  public df(Context paramContext, dh paramdh) {
    this.context = paramContext;
    this.cvn = paramdh;
  }
  
  private void a(ReceiptPrintSettings paramReceiptPrintSettings, boolean paramBoolean) {
    if (paramReceiptPrintSettings.aiw() == 1 && !paramBoolean) {
      paramReceiptPrintSettings.iQ(0);
      return;
    } 
    if (paramBoolean)
      paramReceiptPrintSettings.iQ(1); 
  }
  
  private boolean a(ReceiptPrintSettings paramReceiptPrintSettings) { return (paramReceiptPrintSettings.aiw() == 1); }
  
  private void abL() {
    this.cvn.a(this.cvq);
    if (TextUtils.isEmpty(this.cvq.cxU)) {
      this.cvn.hf(this.cvo.Jr());
    } else if (this.cvq.cxU != null) {
      g.F(this.context).aF(this.cvq.cxU).qO().aJ(256, 256).a(new dg(this));
    } 
    this.cvn.abA();
  }
  
  private void ax(String paramString1, String paramString2) { (new b(this, null)).execute(new String[] { paramString1, paramString2 }); }
  
  @Nullable
  private Bitmap getBitmap(String paramString) {
    if (paramString == null)
      return null; 
    file = new File(paramString);
    if (!file.exists())
      return null; 
    try {
      Throwable throwable;
      fileInputStream = new FileInputStream(file);
      try {
        return BitmapFactory.decodeStream(fileInputStream);
      } catch (Throwable null) {
        try {
          throw throwable;
        } finally {}
      } finally {
        file = null;
      } 
      if (fileInputStream != null)
        if (throwable != null) {
          try {
            fileInputStream.close();
          } catch (Throwable fileInputStream) {
            a.a(throwable, fileInputStream);
          } 
        } else {
          fileInputStream.close();
        }  
      throw file;
    } catch (IOException file) {
      return null;
    } 
  }
  
  private void hg(int paramInt) {
    String str2;
    String str1;
    this.cvn.eH(this.cvo.Jr());
    switch (paramInt) {
      default:
        return;
      case 2:
        if (n.bL(this.context) && (a.zR().Ae() || a.zR().zX() || a.zR().Au() || a.zR().At())) {
          abI();
          return;
        } 
        str2 = this.cvo.getUrl();
        str1 = str2;
        if (!CrashApplication.zv().getResources().getBoolean(2131034123)) {
          paramInt = str2.lastIndexOf("/");
          str1 = str2;
          if (paramInt != -1)
            str1 = str2.substring(paramInt + 1); 
        } 
        ax(str1, dw.aR(this.context));
        this.cvn.setUrl(str1);
        this.cvn.abB();
        return;
      case 1:
        break;
    } 
    if (TextUtils.isEmpty(this.cvo.getUrl())) {
      (new c(this, null)).execute(new Void[0]);
    } else {
      ax(this.cvo.getUrl(), dw.aR(this.context));
    } 
    this.cvn.abA();
  }
  
  private void initView() {
    hg(this.cvo.Jr());
    fm(a(this.cvp));
  }
  
  public boolean Az() { return !fp.aX(this.context).abV().equals(this.cvo) ? true : ((this.cvq != null && this.cvr != null && !this.cvq.equals(this.cvr)) ? true : ((a.bo(this.context).aiL().aiw() != this.cvp.aiw()))); }
  
  public int Jr() { return (this.cvo == null) ? 0 : this.cvo.Jr(); }
  
  public void abI() { (new a(this)).execute(new Void[0]); }
  
  public void abJ() {
    switch (this.cvo.Jr()) {
      default:
        return;
      case 2:
        this.cvn.abz();
        return;
      case 1:
        break;
    } 
    (new c(this, null)).execute(new Void[0]);
  }
  
  @Nullable
  public Bitmap abK() { return getBitmap(dw.aR(this.context)); }
  
  public void eH(int paramInt) {
    if (this.cvo.Jr() != paramInt)
      this.cvo.setUrl(""); 
    this.cvo.eH(paramInt);
    hg(paramInt);
  }
  
  public void fm(boolean paramBoolean) {
    a(this.cvp, paramBoolean);
    this.cvn.fm(paramBoolean);
    PrintContent printContent = a.bo(this.context).a(WeiOrderDetail.cyX, this.cvp);
    dh dh1 = this.cvn;
    if (printContent != null && printContent.size() > 0) {
      PrintContent printContent1 = (PrintContent)printContent.get(0);
    } else {
      printContent = new PrintContent();
    } 
    dh1.a(printContent, 58);
  }
  
  public void fn(boolean paramBoolean) { this.cvq.cxY = Boolean.valueOf(paramBoolean); }
  
  public void fo(boolean paramBoolean) { this.cvq.cxV = Boolean.valueOf(paramBoolean); }
  
  public void fp(boolean paramBoolean) { this.cvq.cxW = Boolean.valueOf(paramBoolean); }
  
  public void fq(boolean paramBoolean) { this.cvq.cxX = Boolean.valueOf(paramBoolean); }
  
  public void init() {
    this.cvo = fp.aX(this.context).abV();
    this.cvp = a.bo(this.context).aiL();
    if (!n.bL(this.context)) {
      this.cvo.eH(2);
    } else if (!a.zR().Ae() && !a.zR().zX() && !a.zR().Au() && !a.zR().At()) {
      this.cvo.eH(1);
    } 
    if (this.cvo.Jr() == 1 && TextUtils.isEmpty(this.cvo.getUrl()))
      eH(2); 
    initView();
  }
  
  public void jQ(String paramString) { (new d(this, null)).execute(new String[] { paramString }); }
  
  public boolean save() {
    this.cvn.Rz();
    if (TextUtils.isEmpty(this.cvo.getUrl())) {
      if (this.cvo.Jr() == 1) {
        this.cvn.jL(this.context.getString(2131630576));
        this.cvn.RA();
        return false;
      } 
      if (this.cvo.Jr() == 2 && a(this.cvp)) {
        this.cvn.jL(this.context.getString(2131630576));
        this.cvn.RA();
        return false;
      } 
    } 
    if (!fp.aX(this.context).b(this.cvo)) {
      this.cvn.jL(this.context.getString(2131630559));
      this.cvn.RA();
      return false;
    } 
    if (TextUtils.isEmpty(this.cvo.getUrl()))
      dw.aS(this.context); 
    a a1 = a.bo(this.context);
    ReceiptPrintSettings receiptPrintSettings = a1.aiL();
    if (receiptPrintSettings.aiw() == 1 && !a(this.cvp)) {
      receiptPrintSettings.iQ(0);
    } else if (a(this.cvp)) {
      receiptPrintSettings.iQ(1);
    } 
    a1.a(receiptPrintSettings);
    long l = System.currentTimeMillis();
    bd.a(this.context, l - 2592000000L, l, "t_shop,");
    if (this.cvo.Jr() == 2 && n.bL(this.context) && (a.zR().Ae() || a.zR().Au() || a.zR().zX())) {
      (new e(this)).execute(new Void[0]);
    } else if (!bd.bH(this.context)) {
      Toast.makeText(this.context, this.context.getString(2131626280), 0).show();
    } else {
      Toast.makeText(this.context, this.context.getString(2131630560), 0).show();
    } 
    this.cvn.RA();
    return true;
  }
  
  public class a extends AsyncTask<Void, Void, Boolean> {
    boolean bBY = false;
    
    public a(df this$0) {}
    
    private boolean SI() {
      if (!bd.bH(this.cvs.context)) {
        Toast.makeText(this.cvs.context, this.cvs.context.getString(2131626280), 0).show();
        return false;
      } 
      return true;
    }
    
    protected void b(Boolean param1Boolean) {
      if (this.cvs.context != null) {
        if (!this.cvs.cvn.zP())
          return; 
        this.cvs.cvn.hideProgress();
        if (!param1Boolean.booleanValue())
          this.cvs.cvq = new a(); 
        try {
          this.cvs.cvr = this.cvs.cvq.acM();
        } catch (CloneNotSupportedException param1Boolean) {
          a.e(param1Boolean);
        } 
        df.a(this.cvs);
        return;
      } 
    }
    
    protected Boolean g(Void... param1VarArgs) {
      if (this.bBY) {
        fp fp = fp.aX(this.cvs.context);
        this.cvs.cvq = fp.abY();
        return (this.cvs.cvq == null) ? Boolean.valueOf(false) : Boolean.valueOf(true);
      } 
      return Boolean.valueOf(false);
    }
    
    protected void onPreExecute() {
      this.cvs.cvn.Em();
      this.bBY = SI();
    }
  }
  
  private class b extends AsyncTask<String, Void, Boolean> {
    private b(df this$0) {}
    
    protected void b(Boolean param1Boolean) {
      if (this.cvs.context != null) {
        if (!this.cvs.cvn.zP())
          return; 
        this.cvs.cvn.zO();
        if (param1Boolean.booleanValue()) {
          switch (this.cvs.cvo.Jr()) {
            default:
              return;
            case 2:
              this.cvs.cvn.q(new BitmapDrawable(this.cvs.context.getResources(), df.a(this.cvs, dw.aR(this.cvs.context))));
              return;
            case 1:
              break;
          } 
          this.cvs.cvn.q(new BitmapDrawable(this.cvs.context.getResources(), df.a(this.cvs, dw.aR(this.cvs.context))));
          return;
        } 
        this.cvs.cvn.hf(this.cvs.cvo.Jr());
        return;
      } 
    }
    
    protected Boolean e(String... param1VarArgs) {
      String str2 = param1VarArgs[0];
      String str1 = param1VarArgs[1];
      return TextUtils.isEmpty(str2) ? Boolean.valueOf(false) : Boolean.valueOf(dw.h(this.cvs.context, str2, str1));
    }
    
    protected void onPreExecute() {
      this.cvs.cvn.q(null);
      this.cvs.cvn.q(null);
    }
  }
  
  private class c extends AsyncTask<Void, Void, Boolean> {
    boolean cvl = false;
    
    private c(df this$0) {}
    
    private String abH() {
      av av = new av(this.cvs.context);
      String str = av.rs(av.Tx());
      av.close();
      return str;
    }
    
    protected void b(Boolean param1Boolean) {
      if (this.cvs.context != null) {
        if (!this.cvs.cvn.zP())
          return; 
        if (param1Boolean.booleanValue()) {
          this.cvs.cvn.zO();
          this.cvs.cvn.abw();
          df.a(this.cvs, this.cvs.cvo.getUrl(), dw.aR(this.cvs.context));
          return;
        } 
        Log.e("fail", "QueryLqkBindedUrlTask");
        this.cvs.cvn.Sl();
        this.cvs.cvn.abx();
        return;
      } 
    }
    
    protected Boolean g(Void... param1VarArgs) {
      if (!this.cvl) {
        if (this.cvs.cvo.Jr() == 1) {
          null = new av(this.cvs.context);
          String str2 = null.Tx();
          null.close();
          String str1 = fp.aX(this.cvs.context).kb(str2);
          if (str1 != null) {
            this.cvs.cvo.setUrl(str1);
            return Boolean.valueOf(true);
          } 
          return Boolean.valueOf(false);
        } 
        return Boolean.valueOf(false);
      } 
      return Boolean.valueOf(true);
    }
    
    protected void onPreExecute() {
      String str = abH();
      if (!TextUtils.isEmpty(str)) {
        this.cvl = true;
        this.cvs.cvo.setUrl(str);
        return;
      } 
      this.cvl = false;
    }
  }
  
  private class d extends AsyncTask<String, Void, Boolean> {
    private d(df this$0) {}
    
    protected void b(Boolean param1Boolean) {
      if (this.cvs.context != null) {
        if (!this.cvs.cvn.zP())
          return; 
        if (param1Boolean.booleanValue()) {
          this.cvs.cvn.q(new BitmapDrawable(this.cvs.context.getResources(), df.a(this.cvs, dw.aR(this.cvs.context))));
          return;
        } 
        this.cvs.cvn.aby();
        return;
      } 
    }
    
    protected Boolean e(String... param1VarArgs) {
      boolean bool = false;
      null = param1VarArgs[0];
      null = df.a(this.cvs, null);
      if (null == null)
        return Boolean.valueOf(false); 
      String str = bk.v(null);
      if (!TextUtils.isEmpty(str)) {
        bool = dw.h(this.cvs.context, str, dw.aR(this.cvs.context));
        this.cvs.cvo.setUrl(str);
      } 
      return Boolean.valueOf(bool);
    }
  }
  
  public class e extends AsyncTask<Void, Void, Boolean> {
    boolean bBY = false;
    
    public e(df this$0) {}
    
    private boolean SI() {
      if (!bd.bH(this.cvs.context)) {
        Toast.makeText(this.cvs.context, this.cvs.context.getString(2131626280), 0).show();
        return false;
      } 
      if (this.cvs.cvq == null || TextUtils.isEmpty(this.cvs.cvq.cxT)) {
        Toast.makeText(this.cvs.context, this.cvs.context.getString(2131630497), 0).show();
        return false;
      } 
      return true;
    }
    
    protected void b(Boolean param1Boolean) {
      if (this.cvs.context != null) {
        if (!this.cvs.cvn.zP())
          return; 
        try {
          this.cvs.cvn.RA();
        } catch (Exception exception) {}
        if (!this.bBY)
          return; 
        if (param1Boolean.booleanValue()) {
          try {
            this.cvs.cvr = this.cvs.cvq.acM();
          } catch (CloneNotSupportedException param1Boolean) {
            a.e(param1Boolean);
          } 
          this.cvs.cvn.jL(this.cvs.context.getString(2131630560));
          return;
        } 
        this.cvs.cvn.jL(this.cvs.context.getString(2131630559));
        return;
      } 
    }
    
    protected Boolean g(Void... param1VarArgs) {
      if (this.bBY) {
        fp fp = fp.aX(this.cvs.context);
        gp gp = fp.abX();
        if (gp == null)
          return Boolean.valueOf(false); 
        gp.ft(true);
        boolean bool1 = fp.a(gp);
        boolean bool2 = fp.b(this.cvs.cvq).booleanValue();
        return (bool1 && bool2 && !a.zR().Ab()) ? Boolean.valueOf(true) : ((bool1 && a.zR().Ab()) ? Boolean.valueOf(true) : Boolean.valueOf(false));
      } 
      return Boolean.valueOf(false);
    }
    
    protected void onPreExecute() {
      this.cvs.cvn.Rz();
      this.bBY = SI();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */