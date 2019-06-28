package com.laiqian.login.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.laiqian.util.ae;
import com.umeng.analytics.MobclickAgent;
import kotlin.Metadata;
import kotlin.b;
import kotlin.c;
import kotlin.c.e;
import kotlin.jvm.a.a;
import kotlin.jvm.b.d;
import kotlin.jvm.b.f;
import kotlin.jvm.b.j;
import kotlin.jvm.b.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.droidsonroids.gif.GifImageView;

@Metadata
public final class RegisterAccountActivity extends LoginActivity {
  private static final int bah = 5000;
  
  public static final a bai = new a(null);
  
  private final b bag = c.a((a)new aw(this));
  
  private final RegisterAccountActivityViewModel KA() {
    b b1 = this.bag;
    e e1 = baf[0];
    return (RegisterAccountActivityViewModel)b1.getValue();
  }
  
  private final void KB() { MobclickAgent.onEvent((Context)this, "login_click_register_account"); }
  
  private final void KC() {
    this.aZg.aZW.setOnClickListener((View.OnClickListener)new ar(this));
    this.aZg.aZL.setOnClickListener((View.OnClickListener)new as(this));
  }
  
  private final void KD() {
    TextView textView3 = this.aZg.aZR;
    f.l(textView3, "content.tvLoginLabel");
    textView3.setText((CharSequence)getString(2131625478));
    ImageView imageView2 = this.aZg.aZH.baa;
    f.l(imageView2, "content.titlebar.ivLogo");
    ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
    layoutParams.width = eJ(10);
    layoutParams.height = eJ(17);
    this.aZg.aZH.baa.requestLayout();
    this.aZg.aZH.baa.setImageResource(2131231234);
    TextView textView2 = this.aZg.aZH.tvTitle;
    f.l(textView2, "content.titlebar.tvTitle");
    textView2.setText((CharSequence)getString(2131625478));
    textView2 = this.aZg.aZH.bac;
    f.l(textView2, "content.titlebar.tvRegister");
    textView2.setVisibility(8);
    GifImageView gifImageView = this.aZg.aZH.bad;
    f.l(gifImageView, "content.titlebar.btnDownload");
    gifImageView.setVisibility(8);
    ImageView imageView1 = this.aZg.aZH.bab;
    f.l(imageView1, "content.titlebar.ivTopAuto");
    imageView1.setVisibility(8);
    imageView1 = this.aZg.aZH.bae;
    f.l(imageView1, "content.titlebar.btnHint");
    imageView1.setVisibility(8);
    TextView textView1 = this.aZg.aZV;
    f.l(textView1, "content.tvRegisterAccount");
    textView1.setVisibility(8);
    textView1 = this.aZg.aZU;
    f.l(textView1, "content.l_info");
    textView1.setVisibility(8);
    this.aZg.aZI.setText((CharSequence)"");
    View view = findViewById(2131299673);
    f.l(view, "findViewById<TextView>(R.id.tv_register_tips)");
    ((TextView)view).setVisibility(0);
  }
  
  protected boolean Kk() { return false; }
  
  public final int eJ(int paramInt) { return ae.b(getBaseContext(), paramInt); }
  
  protected void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    KD();
    KC();
    KB();
  }
  
  @Metadata
  public static final class a {
    private a() {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\RegisterAccountActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */