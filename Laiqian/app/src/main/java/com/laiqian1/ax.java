package com.laiqian;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.google.zxing.WriterException;
import com.laiqian.d.a;
import com.laiqian.entity.n;
import com.laiqian.payment.R;
import com.laiqian.pos.PayTypeSpecific;
import com.laiqian.pos.industry.a;
import com.laiqian.ui.a.bc;
import com.laiqian.util.al;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.util.Date;
import java.util.HashMap;

public class ax extends o {
  private TextView aBA;
  
  private RelativeLayout aBB;
  
  private RelativeLayout aBC;
  
  private RelativeLayout aBD;
  
  private TextView aBE;
  
  private View aBF;
  
  View.OnClickListener aBo;
  
  private View aBx;
  
  private TextView aBy;
  
  private View aBz;
  
  public ax(Activity paramActivity, n paramn, o.a parama) { super(paramActivity, R.layout.dialog_online_fubei_pay, paramn, parama); }
  
  private void dH(int paramInt) {
    if (paramInt == R.id.rl_wechat_qrcode) {
      this.aAD = new bs(this.aAA, this, this.onlinePayEntity);
      this.aAK = a.cqM;
      this.aAL = a.cqP;
      this.aAZ = false;
      return;
    } 
    if (paramInt == R.id.rl_ali_qrcode) {
      this.aAD = new a(this.aAA, this, this.onlinePayEntity);
      this.aAK = a.cqE;
      this.aAL = a.cqG;
      this.aAZ = true;
    } 
  }
  
  private boolean xv() { return ((this.aBx.getVisibility() == 0 && this.onlinePayEntity.Fo() == 0L) || (this.aBA.getVisibility() == 0 && this.onlinePayEntity.Fo() == 8L)); }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("showResult | ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" | ");
    stringBuilder.append(this.onlinePayEntity.Fo());
    Log.d("OnlinePayDialog", stringBuilder.toString());
    if (!dG(paramInt2)) {
      Log.d("OnlinePayDialog", "不处理");
      return;
    } 
    this.aAt.setVisibility(8);
    this.aAv.setVisibility(8);
    this.aAu.setVisibility(8);
    this.azq.setVisibility(8);
    this.azr.setVisibility(0);
    this.azr.findViewById(R.id.tv_qrcode_warning).setVisibility(8);
    if (paramInt1 != -1) {
      if (paramInt1 != 4) {
        if (paramInt1 != 6) {
          if (paramInt1 != 10000) {
            if (paramInt1 != 20001) {
              if (paramInt1 != 40004) {
                switch (paramInt1) {
                  default:
                    switch (paramInt1) {
                      default:
                        return;
                      case 90001:
                        if (xv()) {
                          ((ImageView)this.azr.findViewById(R.id.v_result_icon)).setBackgroundResource(R.drawable.icon_error);
                          ((TextView)this.azr.findViewById(R.id.tv_result)).setText(R.string.create_qrcode_fail);
                          this.aAw.setOnClickListener(this.aAV);
                          this.aAw.setVisibility(0);
                          this.aAw.setText(R.string.lqj_cancel);
                          this.aAx.setVisibility(8);
                          this.aAI = System.currentTimeMillis();
                          return;
                        } 
                        this.aAD.stop();
                        xo();
                        return;
                      case 90000:
                        break;
                    } 
                    if (xv()) {
                      try {
                        this.aAO = al.B(paramString1, 250);
                        this.aAP.o(this.aAO);
                        if (!this.onlinePayEntity.Fk() && this.aAO != null && this.aAN != null && this.aAN.size() > 0)
                          e(this.aAN); 
                      } catch (WriterException paramString1) {
                        a.e(paramString1);
                      } 
                      ((TextView)this.azr.findViewById(R.id.tv_qrcode_warning)).setVisibility(0);
                      ((TextView)this.azr.findViewById(R.id.tv_qrcode_warning)).setText(String.format(this.aAA.getString(R.string.online_pay_warning), new Object[] { getContext().getResources().getString(PayTypeSpecific.cn(this.onlinePayEntity.Fo())) }));
                      ((ImageView)this.azr.findViewById(R.id.v_result_icon)).setBackground(new BitmapDrawable(this.aAO));
                      ((TextView)this.azr.findViewById(R.id.tv_result)).setText(this.aAM);
                      this.aAw.setText(R.string.lqj_cancel);
                      this.aAw.setOnClickListener(this.aAV);
                      this.aAw.setVisibility(0);
                      this.aAx.setText(R.string.pos_main_pay_finish_printqrcode);
                      this.aAx.setOnClickListener(this.aAX);
                      this.aAx.setVisibility(0);
                      this.aAI = System.currentTimeMillis();
                      return;
                    } 
                    this.aAD.stop();
                    xo();
                    return;
                  case 40001:
                  case 40002:
                    break;
                } 
                ((ImageView)this.azr.findViewById(R.id.v_result_icon)).setBackgroundResource(R.drawable.icon_warning);
                ((TextView)this.azr.findViewById(R.id.tv_result)).setText(paramString1);
                this.aAw.setOnClickListener(this.aAU);
                this.aAw.setText(R.string.money_did_not_receive);
                this.aAw.setVisibility(0);
                this.aAx.setVisibility(0);
                this.aAx.setOnClickListener(new bd(this, paramInt2));
                this.aAx.setText(R.string.money_has_been_received);
                this.aAx.setTextColor(this.aAA.getResources().getColor(R.color.red_color_10500));
                return;
              } 
              ((ImageView)this.azr.findViewById(R.id.v_result_icon)).setBackgroundResource(R.drawable.icon_error);
              ((TextView)this.azr.findViewById(R.id.tv_result)).setText(R.string.pos_alipay_pay_fails);
              this.aAw.setVisibility(8);
              this.aAx.setVisibility(0);
              this.aAx.setOnClickListener(this.aAU);
              this.aAx.setText(R.string.pay_retry);
              this.aAx.setTextColor(this.aAA.getResources().getColor(R.color.red_color_10500));
              return;
            } 
            ((ImageView)this.azr.findViewById(R.id.v_result_icon)).setBackgroundResource(R.drawable.icon_warning);
            ((TextView)this.azr.findViewById(R.id.tv_result)).setText(paramString1);
            this.aAw.setText(R.string.online_pay_auth);
            this.aAw.setOnClickListener(this.aAW);
            this.aAw.setVisibility(0);
            this.aAx.setVisibility(8);
            return;
          } 
          ((ImageView)this.azr.findViewById(R.id.v_result_icon)).setBackgroundResource(R.drawable.icon_success);
          ((TextView)this.azr.findViewById(R.id.tv_result)).setText(R.string.pos_alipay_pay_complete);
          this.aAw.setText(R.string.pos_product_dialog_sure);
          this.aAw.setOnClickListener(new bc(this, paramString2));
          this.aAx.setVisibility(8);
          confirm(paramString2);
          return;
        } 
        ((ImageView)this.azr.findViewById(R.id.v_result_icon)).setBackgroundResource(R.drawable.icon_warning);
        ((TextView)this.azr.findViewById(R.id.tv_result)).setText(R.string.pos_alipay_is_paid);
        this.aAw.setOnClickListener(this.aAU);
        this.aAw.setText(R.string.money_did_not_receive);
        this.aAw.setVisibility(0);
        this.aAx.setVisibility(0);
        this.aAx.setOnClickListener(new bb(this, paramInt2));
        this.aAx.setText(R.string.money_has_been_received);
        this.aAx.setTextColor(this.aAA.getResources().getColor(R.color.red_color_10500));
        n.o("我自定义的消息");
        return;
      } 
      ((ImageView)this.azr.findViewById(R.id.v_result_icon)).setBackgroundResource(R.drawable.icon_warning);
      ((TextView)this.azr.findViewById(R.id.tv_result)).setText(R.string.pos_alipay_is_paid);
      this.aAw.setOnClickListener(this.aAU);
      this.aAw.setText(R.string.money_did_not_receive);
      this.aAw.setVisibility(0);
      this.aAx.setVisibility(0);
      this.aAx.setOnClickListener(new ba(this, paramInt2));
      this.aAx.setText(R.string.money_has_been_received);
      this.aAx.setTextColor(this.aAA.getResources().getColor(R.color.red_color_10500));
      return;
    } 
    (new bc(this.aAA)).show();
    ((ImageView)this.azr.findViewById(R.id.v_result_icon)).setBackgroundResource(R.drawable.icon_warning);
    ((TextView)this.azr.findViewById(R.id.tv_result)).setText(R.string.pos_alipay_is_paid);
    this.aAw.setOnClickListener(this.aAU);
    this.aAw.setText(R.string.money_did_not_receive);
    this.aAw.setVisibility(0);
    this.aAx.setVisibility(0);
    this.aAx.setOnClickListener(new az(this, paramInt2));
    this.aAx.setText(R.string.money_has_been_received);
    this.aAx.setTextColor(this.aAA.getResources().getColor(R.color.red_color_10500));
  }
  
  public void confirm(String paramString) {
    xk();
    if (this.aAD != null)
      this.aAD.stop(); 
    if (!this.aAR && bi(paramString)) {
      this.aAR = true;
      Message message = new Message();
      message.what = 1;
      message.obj = paramString;
      message.arg1 = (int)this.onlinePayEntity.Fo();
      this.onlinePayEntity.getHandler().sendMessage(message);
    } 
  }
  
  public void show() {
    super.show();
    xg();
  }
  
  protected void xe() {
    this.aBB.setOnClickListener(xs());
    this.aBC.setOnClickListener(xs());
    this.aBD.setOnClickListener(xs());
  }
  
  protected void xf() {
    this.aBB = (RelativeLayout)this.mView.findViewById(R.id.rl_ali_qrcode);
    this.aBC = (RelativeLayout)this.mView.findViewById(R.id.rl_wechat_qrcode);
    this.aBD = (RelativeLayout)this.mView.findViewById(R.id.rl_fubei_barcode);
    this.aBE = (TextView)this.mView.findViewById(R.id.tv_fubei_barcode_title);
    this.aBF = this.mView.findViewById(R.id.tv_fubei_barcode_bottom);
    this.aBx = this.mView.findViewById(R.id.tv_ali_qrcode_bottom);
    this.aBy = (TextView)this.mView.findViewById(R.id.tv_ali_qrcode_title);
    this.aBz = this.mView.findViewById(R.id.tv_wechat_qrcode_bottom);
    this.aBA = (TextView)this.mView.findViewById(R.id.tv_wechat_qrcode_title);
  }
  
  protected void xg() {
    int i;
    Activity activity = new StringBuilder();
    activity.append(this.onlinePayEntity.Fo());
    activity.append("");
    Log.e("支付类型：", activity.toString());
    this.aAR = false;
    if (this.onlinePayEntity.Fo() == 5L || this.onlinePayEntity.Fo() == 8L) {
      this.aAD = new bs(this.aAA, this, this.onlinePayEntity);
      this.aAK = a.cqM;
      this.aAL = a.cqP;
      this.aAZ = false;
    } else if (this.onlinePayEntity.Fo() == 1L || this.onlinePayEntity.Fo() == 0L) {
      this.aAD = new a(this.aAA, this, this.onlinePayEntity);
      this.aAK = a.cqE;
      this.aAL = a.cqG;
      this.aAZ = true;
    } else {
      xk();
    } 
    xh();
    TextView textView = this.aAY;
    if (this.aAZ) {
      Activity activity1 = this.aAA;
      i = R.string.pos_pay_Alipay;
    } else {
      activity = this.aAA;
      i = R.string.version_title_comprehensive;
    } 
    Resources resources2 = activity.getString(i);
    textView.setText(resources2);
    if (this.aAZ) {
      Resources resources = this.aAA.getResources();
      i = R.drawable.icon_alipay;
    } else {
      resources2 = this.aAA.getResources();
      i = R.drawable.fubei_title_online_pay;
    } 
    Drawable drawable2 = resources2.getDrawable(i);
    drawable2.setBounds(0, 0, 24, 24);
    this.aAY.setCompoundDrawables(drawable2, null, null, null);
    this.aAY.setCompoundDrawablePadding(8);
    Resources resources1 = new HashMap();
    resources1.put("out_trade_no", this.onlinePayEntity.xq());
    resources1.put("total_amount", this.onlinePayEntity.Fl());
    av av = new av(this.aAA);
    resources1.put("shop_id", av.Tx());
    resources1.put("pay_type", "bar_code");
    f.e(resources1);
    av.close();
    View view = this.aAy;
    if (this.aAZ) {
      Resources resources = this.aAA.getResources();
      i = R.drawable.icon_account_alipay_pay;
    } else {
      resources1 = this.aAA.getResources();
      i = R.drawable.icon_account_wechat_pay;
    } 
    Drawable drawable1 = resources1.getDrawable(i);
    view.setBackground(drawable1);
    this.aAQ = new k(this.aAA, this.onlinePayEntity.getHandler());
    this.aAM = by.b(String.format(this.aAA.getString(R.string.pay_amount), new Object[] { this.onlinePayEntity.Fl() }), this.onlinePayEntity.Fl(), 18, this.aAA.getResources().getColor(R.color.red_color_10500));
    this.aAs.setText(this.aAM);
    this.aAz.setText(this.aAM);
  }
  
  protected void xh() {
    if (this.onlinePayEntity.Fo() == 5L || this.onlinePayEntity.Fo() == 1L) {
      this.aBD.performClick();
      return;
    } 
    if (this.onlinePayEntity.Fo() == 8L || this.onlinePayEntity.Fo() == 0L) {
      this.aBD.performClick();
      return;
    } 
  }
  
  public View.OnClickListener xs() {
    if (this.aBo != null)
      return this.aBo; 
    ay ay = new ay(this);
    this.aBo = ay;
    return ay;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */