package com.laiqian.intro.appintro;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import java.util.List;
import java.util.Vector;

public abstract class AppIntro extends FragmentActivity {
  private j aXh;
  
  private ViewPager aXi;
  
  private List<Fragment> aXj = new Vector();
  
  private int aXk;
  
  private Vibrator aXl;
  
  private i aXm;
  
  private boolean aXn = false;
  
  private int aXo = 20;
  
  private boolean aXp = true;
  
  private boolean aXq = true;
  
  private void Jt() {
    if (this.aXm == null)
      this.aXm = new h(); 
    ((FrameLayout)findViewById(R.id.indicator_container)).addView(this.aXm.ai(this));
    this.aXm.initialize(this.aXk);
  }
  
  public abstract void Ju();
  
  public abstract void Jv();
  
  public abstract void g(@Nullable Bundle paramBundle);
  
  protected final void onCreate(Bundle paramBundle) {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    setContentView(R.layout.intro_layout);
    TextView textView1 = (TextView)findViewById(R.id.skip);
    ImageView imageView = (ImageView)findViewById(R.id.next);
    TextView textView2 = (TextView)findViewById(R.id.done);
    this.aXl = (Vibrator)getSystemService("vibrator");
    textView1.setOnClickListener(new a(this));
    imageView.setOnClickListener(new b(this));
    textView2.setOnClickListener(new c(this));
    this.aXh = new j(getSupportFragmentManager(), this.aXj);
    this.aXi = (ViewPager)findViewById(R.id.view_pager);
    this.aXi.setAdapter(this.aXh);
    this.aXi.setOnPageChangeListener(new d(this, textView1, imageView, textView2));
    g(paramBundle);
    this.aXk = this.aXj.size();
    if (this.aXk == 1) {
      imageView.setVisibility(8);
      textView2.setVisibility(0);
      return;
    } 
    Jt();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    ViewPager viewPager;
    if (paramInt == 66 || paramInt == 96) {
      viewPager = (ViewPager)findViewById(R.id.view_pager);
      if (viewPager.getCurrentItem() == viewPager.getAdapter().getCount() - 1) {
        Jv();
      } else {
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
      } 
      return false;
    } 
    return super.onKeyDown(paramInt, viewPager);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\intro\appintro\AppIntro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */