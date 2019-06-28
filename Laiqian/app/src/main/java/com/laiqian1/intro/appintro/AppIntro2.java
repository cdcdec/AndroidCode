package com.laiqian.intro.appintro;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.ActivityRoot;
import java.util.List;
import java.util.Vector;

public abstract class AppIntro2 extends ActivityRoot {
  private j aXh;
  
  private ViewPager aXi;
  
  private List<Fragment> aXj = new Vector();
  
  private int aXk;
  
  private Vibrator aXl;
  
  private i aXm;
  
  private boolean aXn = false;
  
  private int aXo = 20;
  
  private boolean aXq = true;
  
  private void Jt() {
    if (this.aXm == null)
      this.aXm = new h(); 
    ((FrameLayout)findViewById(R.id.indicator_container)).addView(this.aXm.ai(this));
    this.aXm.initialize(this.aXk);
  }
  
  public abstract void Jv();
  
  public void b(@NonNull Fragment paramFragment) {
    this.aXj.add(paramFragment);
    this.aXh.notifyDataSetChanged();
  }
  
  public abstract void g(@Nullable Bundle paramBundle);
  
  protected final void onCreate(Bundle paramBundle) {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setContentView(R.layout.intro_layout2);
    ImageView imageView = (ImageView)findViewById(R.id.next);
    Button button = (Button)findViewById(R.id.done);
    this.aXl = (Vibrator)getSystemService("vibrator");
    imageView.setOnClickListener(new e(this));
    button.setOnClickListener(new f(this));
    this.aXh = new j(getSupportFragmentManager(), this.aXj);
    this.aXi = (ViewPager)findViewById(R.id.view_pager);
    this.aXi.setAdapter(this.aXh);
    this.aXi.setOnPageChangeListener(new g(this, imageView, button));
    g(paramBundle);
    this.aXk = this.aXj.size();
    if (this.aXk == 1) {
      imageView.setVisibility(8);
      button.setVisibility(0);
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


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\intro\appintro\AppIntro2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */