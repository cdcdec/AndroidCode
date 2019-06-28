package com.laiqian.pos.industry.weiorder.advertisement;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.google.zxing.WriterException;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.s;
import com.laiqian.util.al;
import com.laiqian.util.by;
import com.laiqian.util.l;
import com.laiqian.util.n;

public class AdvertisementRegisteredShopFragment extends FragmentRoot implements w {
  private View aZQ;
  
  private View.OnClickListener clickKeyboardNumber = new o(this);
  
  private TextView cxA;
  
  private TextView cxB;
  
  private TextView cxC;
  
  private View cxD;
  
  private View cxE;
  
  private View cxF;
  
  private View cxG;
  
  private View cxH;
  
  private View cxI;
  
  private View cxJ;
  
  private View cxK;
  
  private ImageView cxL;
  
  private AutoCompleteTextView cxM;
  
  private v cxN;
  
  private TextView cxv;
  
  private TextView cxw;
  
  private TextView cxx;
  
  private TextView cxy;
  
  private TextView cxz;
  
  private void Oq() {
    ViewGroup viewGroup = (ViewGroup)this.cxJ.findViewById(2131297424);
    int i = viewGroup.getChildCount();
    for (byte b = 0; b < i; b++) {
      ViewGroup viewGroup1 = (ViewGroup)viewGroup.getChildAt(b);
      for (byte b1 = 0; b1 < viewGroup1.getChildCount(); b1++) {
        View view = viewGroup1.getChildAt(b1);
        if (view.getTag() != null)
          view.setOnClickListener(this.clickKeyboardNumber); 
      } 
    } 
  }
  
  private void aaM() {
    this.cxI.setSelected(true);
    this.cxH.setOnClickListener(new p(this));
    this.cxM.addTextChangedListener(new q(this));
  }
  
  private void aaN() {
    l.a(getActivity().getWindow(), this.cxM);
    this.cxM.requestFocus();
  }
  
  private void cC(View paramView) {
    this.cxH = s.z(paramView, 2131297442);
    this.cxI = s.z(paramView, 2131299414);
    this.aZQ = s.z(paramView, 2131297346);
    this.cxK = s.z(paramView, 2131297339);
    this.cxv = (TextView)s.z(paramView, 2131299415);
    this.cxM = (AutoCompleteTextView)s.z(paramView, 2131297450);
    this.cxD = s.z(paramView, 2131299271);
    this.cxw = (TextView)s.z(paramView, 2131299432);
    this.cxx = (TextView)s.z(paramView, 2131299433);
    this.cxy = (TextView)s.z(paramView, 2131299434);
    this.cxE = s.z(paramView, 2131299078);
    this.cxF = s.z(paramView, 2131299079);
    this.cxG = s.z(paramView, 2131299080);
    this.cxz = (TextView)s.z(paramView, 2131299332);
    this.cxA = (TextView)s.z(paramView, 2131299333);
    this.cxB = (TextView)s.z(paramView, 2131299707);
    this.cxC = (TextView)s.z(paramView, 2131299708);
    this.cxL = (ImageView)s.z(paramView, 2131298429);
    this.cxJ = s.z(paramView, 2131299944);
  }
  
  public void acF() {
    this.cxH.setClickable(false);
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setDuration(500L);
    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0F, 1.5F, 1.0F, 1.5F, (this.cxI.getWidth() / 2), (this.cxI.getHeight() / 2));
    scaleAnimation.setDuration(500L);
    AnimationSet animationSet = new AnimationSet(false);
    animationSet.addAnimation(scaleAnimation);
    animationSet.addAnimation(alphaAnimation);
    this.cxI.startAnimation(animationSet);
    this.cxI.setVisibility(8);
    this.aZQ.setVisibility(0);
  }
  
  public void acG() {
    this.cxI.clearAnimation();
    this.aZQ.setVisibility(8);
    this.cxv.setVisibility(8);
    this.cxI.setVisibility(0);
    this.cxH.setClickable(true);
  }
  
  public void acH() {
    this.cxy.setEnabled(false);
    this.cxx.setEnabled(false);
    this.cxz.setEnabled(false);
    this.cxA.setEnabled(false);
    this.cxE.setVisibility(0);
    this.cxF.setVisibility(8);
    this.cxG.setVisibility(8);
  }
  
  public void acI() {
    this.cxB.setText(Html.fromHtml(getString(2131629533)));
    this.cxC.setText(Html.fromHtml(getString(2131629283)));
    this.cxx.setEnabled(true);
    this.cxz.setEnabled(true);
    this.cxy.setEnabled(false);
    this.cxA.setEnabled(false);
    this.cxE.setVisibility(8);
    this.cxF.setVisibility(0);
    this.cxG.setVisibility(8);
  }
  
  public void acJ() {
    this.cxx.setEnabled(true);
    this.cxz.setEnabled(true);
    this.cxy.setEnabled(true);
    this.cxA.setEnabled(true);
    this.cxE.setVisibility(8);
    this.cxF.setVisibility(8);
    this.cxG.setVisibility(0);
    try {
      Bitmap bitmap = al.B(u.cxS.acL(), 250);
      this.cxL.setImageDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
      return;
    } catch (WriterException writerException) {
      a.e(writerException);
      return;
    } 
  }
  
  public void acK() {
    this.cxK.setVisibility(8);
    this.cxD.setVisibility(0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = LayoutInflater.from(getActivity()).inflate(2131427457, null);
    this.cxN = new b(this);
    this.cxN.fv(false);
    cC(view);
    aaM();
    Oq();
    aaN();
    return view;
  }
  
  public void onDestroy() {
    this.cxN.acy();
    super.onDestroy();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\advertisement\AdvertisementRegisteredShopFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */