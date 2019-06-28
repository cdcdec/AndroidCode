package com.laiqian.ui.recycleview.pagerecyclerview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Interpolator;
import com.google.a.a.a.a.a.a;
import com.laiqian.util.bb;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class PageRecyclerView extends RecyclerView {
  private static final Interpolator mInterpolator = new a();
  
  private DecimalFormat ZA;
  
  private int dCZ = 3000;
  
  private int dDa;
  
  private int dDb;
  
  private Method dDc = null;
  
  private Field dDd = null;
  
  private int dDe;
  
  private int dDf;
  
  private int dDg;
  
  private boolean dDh;
  
  private boolean dDi;
  
  private boolean mFirstLayout = true;
  
  private List<a> mOnPageChangeListeners;
  
  private int mOrientation;
  
  private int mScrollState;
  
  public PageRecyclerView(Context paramContext) { this(paramContext, null); }
  
  public PageRecyclerView(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  public PageRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private boolean a(@NonNull RecyclerView.g paramg, int paramInt1, int paramInt2) {
    if (paramg.getItemCount() == 0)
      return false; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("snapFromFling,mScrollState:");
    stringBuilder.append(this.mScrollState);
    stringBuilder.append(",velocityX:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(",velocityY:");
    stringBuilder.append(paramInt2);
    bb.f("PageRecyclerView", stringBuilder.toString());
    if (1 == this.mScrollState) {
      if (this.mOrientation == 0) {
        paramInt2 = bA(this.dDe, this.dDa);
        stringBuilder = new StringBuilder();
        stringBuilder.append("snapFromFling: deltaX:");
        stringBuilder.append(paramInt2);
        stringBuilder.append(",mCurrentPage:");
        stringBuilder.append(this.dDg);
        bb.e("PageRecyclerView", stringBuilder.toString());
        if (Math.abs(paramInt2) != 0 && Math.abs(paramInt2) != this.dDa) {
          d(paramInt2, 0, bB(paramInt1, paramInt2));
          return true;
        } 
      } else {
        paramInt1 = bA(this.dDe, this.dDb);
        stringBuilder = new StringBuilder();
        stringBuilder.append("snapFromFling: deltaY:");
        stringBuilder.append(paramInt1);
        stringBuilder.append(",mCurrentPage:");
        stringBuilder.append(this.dDg);
        bb.e("PageRecyclerView", stringBuilder.toString());
        if (Math.abs(paramInt1) != 0 && Math.abs(paramInt1) != this.dDb)
          d(0, paramInt1, bC(paramInt2, paramInt1)); 
      } 
      return true;
    } 
    return false;
  }
  
  private void asd() {
    try {
      this.dDd = Class.forName("android.support.v7.widget.RecyclerView").getDeclaredField("mViewFlinger");
      this.dDd.setAccessible(true);
      this.dDc = Class.forName(this.dDd.getType().getName()).getDeclaredMethod("smoothScrollBy", new Class[] { int.class, int.class, int.class, Interpolator.class });
      this.dDc.setAccessible(true);
      return;
    } catch (ClassNotFoundException classNotFoundException) {
      a.e(classNotFoundException);
      return;
    } catch (NoSuchFieldException noSuchFieldException) {
      a.e(noSuchFieldException);
      return;
    } catch (NoSuchMethodException noSuchMethodException) {
      a.e(noSuchMethodException);
      return;
    } 
  }
  
  private int bA(int paramInt1, int paramInt2) { return this.dDi ? ((paramInt1 / paramInt2 + 1) * paramInt2 - paramInt1) : (paramInt1 / paramInt2 * paramInt2 - paramInt1); }
  
  private int bB(int paramInt1, int paramInt2) {
    int i = this.dDa;
    int j = i / 2;
    float f2 = Math.abs(paramInt2);
    float f1 = i;
    float f3 = Math.min(1.0F, f2 * 1.0F / f1);
    f2 = j;
    f3 = distanceInfluenceForSnapDuration(f3);
    i = Math.abs(paramInt1);
    if (i > 0) {
      paramInt1 = Math.round(Math.abs((f2 + f3 * f2) / i) * 1000.0F) * 4;
    } else {
      paramInt1 = (int)((Math.abs(paramInt2) / f1 * 1.0F + 1.0F) * 100.0F);
    } 
    paramInt1 = Math.min(paramInt1, 800);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("calculateTimeForHorizontalScrolling() called with: velocity = [");
    stringBuilder.append(i);
    stringBuilder.append("], dx = [");
    stringBuilder.append(paramInt2);
    stringBuilder.append("] , duration = [");
    stringBuilder.append(paramInt1);
    stringBuilder.append("]");
    Log.d("PageRecyclerView", stringBuilder.toString());
    return paramInt1;
  }
  
  private int bC(int paramInt1, int paramInt2) {
    int i = this.dDb;
    int j = i / 2;
    float f2 = Math.abs(paramInt2);
    float f1 = i;
    float f3 = Math.min(1.0F, f2 * 1.0F / f1);
    f2 = j;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt1 = Math.abs(paramInt1);
    if (paramInt1 > 0) {
      paramInt1 = Math.round(Math.abs((f2 + f3 * f2) / paramInt1) * 1000.0F) * 4;
    } else {
      paramInt1 = (int)((Math.abs(paramInt2) / f1 * 1.0F + 1.0F) * 100.0F);
    } 
    return Math.min(paramInt1, 800);
  }
  
  private void d(int paramInt1, int paramInt2, int paramInt3) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("smoothScrollBy,dx:");
      stringBuilder.append(paramInt1);
      stringBuilder.append(",dy:");
      stringBuilder.append(paramInt2);
      stringBuilder.append(",duration");
      stringBuilder.append(paramInt3);
      bb.e("PageRecyclerView", stringBuilder.toString());
      this.dDc.invoke(this.dDd.get(this), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), mInterpolator });
      return;
    } catch (IllegalAccessException illegalAccessException) {
      a.e(illegalAccessException);
      return;
    } catch (InvocationTargetException invocationTargetException) {
      a.e(invocationTargetException);
      return;
    } 
  }
  
  private void dispatchOnPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("dispatchOnPageScrolled() called with: position = [");
    stringBuilder.append(paramInt1);
    stringBuilder.append("], offset = [");
    stringBuilder.append(paramFloat);
    stringBuilder.append("], offsetPixels = [");
    stringBuilder.append(paramInt2);
    stringBuilder.append("]");
    Log.d("PageRecyclerView", stringBuilder.toString());
    if (this.mOnPageChangeListeners != null) {
      byte b = 0;
      int i = this.mOnPageChangeListeners.size();
      while (b < i) {
        a a = (a)this.mOnPageChangeListeners.get(b);
        if (a != null)
          a.onPageScrolled(paramInt1, paramFloat, paramInt2); 
        b++;
      } 
    } 
  }
  
  private void dispatchOnPageSelected(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("dispatchOnPageSelected() called with: position = [");
    stringBuilder.append(paramInt);
    stringBuilder.append("]");
    Log.d("PageRecyclerView", stringBuilder.toString());
    if (this.mOnPageChangeListeners != null) {
      byte b = 0;
      int i = this.mOnPageChangeListeners.size();
      while (b < i) {
        a a = (a)this.mOnPageChangeListeners.get(b);
        if (a != null)
          a.onPageSelected(paramInt); 
        b++;
      } 
    } 
  }
  
  private void dispatchOnScrollStateChanged(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("dispatchOnScrollStateChanged() called with: state = [");
    stringBuilder.append(paramInt);
    stringBuilder.append("]");
    Log.d("PageRecyclerView", stringBuilder.toString());
    if (this.mOnPageChangeListeners != null) {
      byte b = 0;
      int i = this.mOnPageChangeListeners.size();
      while (b < i) {
        a a = (a)this.mOnPageChangeListeners.get(b);
        if (a != null)
          a.onPageScrollStateChanged(paramInt); 
        b++;
      } 
    } 
  }
  
  private float distanceInfluenceForSnapDuration(float paramFloat) { return (float)Math.sin((float)((paramFloat - 0.5F) * 0.4712389167638204D)); }
  
  private void init() {
    this.ZA = new DecimalFormat("0.00");
    this.ZA.setRoundingMode(RoundingMode.HALF_UP);
    asd();
    a(new b(this, null));
    addOnLayoutChangeListener(new b(this));
  }
  
  private void lm(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("move,deltaX:");
    stringBuilder.append(paramInt);
    stringBuilder.append(",mCurrentPage:");
    stringBuilder.append(this.dDg);
    bb.f("PageRecyclerView", stringBuilder.toString());
    if (Math.abs(paramInt) != 0) {
      if (Math.abs(paramInt) == this.dDa)
        return; 
      int i = this.dDa / 2;
      if (paramInt >= i) {
        paramInt = this.dDa - paramInt;
        stringBuilder = new StringBuilder();
        stringBuilder.append("move,deltaX:");
        stringBuilder.append(paramInt);
        stringBuilder.append(",mCurrentPage");
        stringBuilder.append(this.dDg);
        bb.f("PageRecyclerView", stringBuilder.toString());
        d(paramInt, 0, bB(this.dCZ, Math.abs(paramInt)));
        return;
      } 
      if (paramInt <= -i) {
        paramInt = -(this.dDa + paramInt);
        stringBuilder = new StringBuilder();
        stringBuilder.append("move,deltaX:");
        stringBuilder.append(paramInt);
        stringBuilder.append(",mCurrentPage");
        stringBuilder.append(this.dDg);
        bb.f("PageRecyclerView", stringBuilder.toString());
        d(paramInt, 0, bB(this.dCZ, Math.abs(paramInt)));
        return;
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("move,deltaX:");
      stringBuilder.append(paramInt);
      bb.f("PageRecyclerView", stringBuilder.toString());
      d(-paramInt, 0, bB(this.dCZ, Math.abs(paramInt)));
      return;
    } 
  }
  
  private void ln(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("move,deltaY:");
    stringBuilder.append(paramInt);
    stringBuilder.append(",mCurrentPage:");
    stringBuilder.append(this.dDg);
    bb.f("PageRecyclerView", stringBuilder.toString());
    if (Math.abs(paramInt) != 0) {
      if (Math.abs(paramInt) == this.dDb)
        return; 
      int i = this.dDb / 2;
      if (paramInt >= i) {
        paramInt = this.dDb - paramInt;
        stringBuilder = new StringBuilder();
        stringBuilder.append("move,deltaY:");
        stringBuilder.append(paramInt);
        bb.f("PageRecyclerView", stringBuilder.toString());
        d(0, paramInt, bC(this.dCZ, Math.abs(paramInt)));
        return;
      } 
      if (paramInt <= -i) {
        paramInt = -(this.dDb + paramInt);
        stringBuilder = new StringBuilder();
        stringBuilder.append("move,deltaY:");
        stringBuilder.append(paramInt);
        bb.f("PageRecyclerView", stringBuilder.toString());
        d(0, paramInt, bC(this.dCZ, Math.abs(paramInt)));
        return;
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("move,deltaY:");
      stringBuilder.append(paramInt);
      bb.f("PageRecyclerView", stringBuilder.toString());
      d(0, -paramInt, bC(this.dCZ, Math.abs(paramInt)));
      return;
    } 
  }
  
  public void ai(int paramInt1, int paramInt2) {
    int i = this.mOrientation;
    byte b2 = 0;
    byte b1 = 0;
    if (i == 0) {
      this.dDe += paramInt1;
      if (this.mScrollState == 1)
        this.dDf += paramInt1; 
      if (paramInt1 >= 0)
        b1 = 1; 
      this.dDi = b1;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("onScrolled: mScrollOffset:");
      stringBuilder1.append(this.dDe);
      stringBuilder1.append(",mCurrentPage:");
      stringBuilder1.append(this.dDg);
      stringBuilder1.append(",mDragOffset:");
      stringBuilder1.append(this.dDf);
      stringBuilder1.append(",forwardDirection:");
      stringBuilder1.append(this.dDi);
      stringBuilder1.append(",mScrollWidth：");
      stringBuilder1.append(this.dDa);
      bb.f("PageRecyclerView", stringBuilder1.toString());
      if (this.dDa == 0)
        return; 
      paramInt2 = this.dDg;
      if (this.dDe % this.dDa == 0) {
        this.dDg = this.dDe / this.dDa;
      } else if (paramInt1 < 0) {
        this.dDg = Math.min(this.dDe / this.dDa + 1, this.dDg);
      } else {
        this.dDg = Math.max(this.dDe / this.dDa, this.dDg);
      } 
      paramInt1 = this.dDe;
      i = this.dDa;
      float f = Float.parseFloat(this.ZA.format((this.dDe % this.dDa) / this.dDa));
      dispatchOnPageScrolled(this.dDg, f, paramInt1 % i);
      if (paramInt2 - this.dDg != 0)
        dispatchOnPageSelected(this.dDg); 
    } else {
      this.dDe += paramInt2;
      if (this.mScrollState == 1)
        this.dDf += paramInt2; 
      b1 = b2;
      if (paramInt2 >= 0)
        b1 = 1; 
      this.dDi = b1;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("onScrolled: mScrollOffset:");
      stringBuilder1.append(this.dDe);
      stringBuilder1.append(",mCurrentPage:");
      stringBuilder1.append(this.dDg);
      stringBuilder1.append(",mDragOffset:");
      stringBuilder1.append(this.dDf);
      stringBuilder1.append(",forwardDirection:");
      stringBuilder1.append(this.dDi);
      stringBuilder1.append(",mScrollHeight：");
      stringBuilder1.append(this.dDb);
      bb.f("PageRecyclerView", stringBuilder1.toString());
      if (this.dDb == 0)
        return; 
      paramInt1 = this.dDg;
      if (this.dDe % this.dDb == 0)
        this.dDg = this.dDe / this.dDb; 
      if (paramInt2 < 0) {
        this.dDg = Math.min(this.dDe / this.dDb + 1, this.dDg);
      } else {
        this.dDg = Math.max(this.dDe / this.dDb, this.dDg);
      } 
      paramInt2 = this.dDe;
      i = this.dDb;
      float f = Float.parseFloat(this.ZA.format((this.dDe % this.dDb) / this.dDb));
      dispatchOnPageScrolled(this.dDg, f, paramInt2 % i);
      if (paramInt1 - this.dDg != 0)
        dispatchOnPageSelected(this.dDg); 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onScrolled,mCurrentPage:");
    stringBuilder.append(this.dDg);
    bb.f("PageRecyclerView", stringBuilder.toString());
  }
  
  public void bJ(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onScrollStateChanged,mScrollState:");
    stringBuilder.append(paramInt);
    bb.f("PageRecyclerView", stringBuilder.toString());
    this.mScrollState = paramInt;
    dispatchOnScrollStateChanged(paramInt);
    switch (paramInt) {
      default:
        return;
      case 2:
        this.dDh = true;
        return;
      case 0:
        if (this.mOrientation == 0) {
          if (this.dDa != 0)
            if (this.dDh) {
              paramInt = this.dDe / this.dDa;
              int i = this.dDe - paramInt * this.dDa;
              paramInt = i;
              if (!this.dDi)
                paramInt = i - this.dDa; 
              stringBuilder = new StringBuilder();
              stringBuilder.append("isSliding=true,deltaX:");
              stringBuilder.append(paramInt);
              stringBuilder.append(",mScrollOffset:");
              stringBuilder.append(this.dDe);
              bb.f("PageRecyclerView", stringBuilder.toString());
              lm(paramInt);
            } else {
              stringBuilder = new StringBuilder();
              stringBuilder.append("isSliding=false,mDragOffset:");
              stringBuilder.append(this.dDf);
              bb.f("PageRecyclerView", stringBuilder.toString());
              lm(this.dDf);
            }  
        } else if (this.dDb != 0) {
          if (this.dDh) {
            paramInt = this.dDe / this.dDb;
            int i = this.dDe - paramInt * this.dDb;
            paramInt = i;
            if (!this.dDi)
              paramInt = i - this.dDb; 
            stringBuilder = new StringBuilder();
            stringBuilder.append("isSliding=true,deltaY:");
            stringBuilder.append(paramInt);
            stringBuilder.append(",mScrollOffset:");
            stringBuilder.append(this.dDe);
            bb.f("PageRecyclerView", stringBuilder.toString());
            ln(paramInt);
          } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("isSliding=false,mDragOffset:");
            stringBuilder.append(this.dDf);
            bb.f("PageRecyclerView", stringBuilder.toString());
            ln(this.dDf);
          } 
        } 
        this.dDf = 0;
        this.dDh = false;
        break;
      case 1:
        break;
    } 
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration) { super.onConfigurationChanged(paramConfiguration); }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    Bundle bundle = (Bundle)paramParcelable;
    this.dDe = bundle.getInt("mScrollOffset", 0);
    this.dDg = bundle.getInt("mCurrentPage", 0);
    this.dDa = bundle.getInt("mScrollWidth", 0);
    this.dDb = bundle.getInt("mScrollHeight", 0);
    Parcelable parcelable = bundle.getParcelable("super");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onRestoreInstanceState: mOrientation:");
    stringBuilder.append(this.mOrientation);
    stringBuilder.append(",mScrollOffset:");
    stringBuilder.append(this.dDe);
    stringBuilder.append(",mScrollWidth:");
    stringBuilder.append(this.dDa);
    stringBuilder.append(",mScrollHeight:");
    stringBuilder.append(this.dDb);
    stringBuilder.append(",mCurrentPage:");
    stringBuilder.append(this.dDg);
    bb.f("PageRecyclerView", stringBuilder.toString());
    super.onRestoreInstanceState(parcelable);
  }
  
  protected Parcelable onSaveInstanceState() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onSaveInstanceState: mOrientation:");
    stringBuilder.append(this.mOrientation);
    stringBuilder.append(",mScrollOffset:");
    stringBuilder.append(this.dDe);
    stringBuilder.append(",mScrollWidth:");
    stringBuilder.append(this.dDa);
    stringBuilder.append(",mScrollHeight:");
    stringBuilder.append(this.dDb);
    stringBuilder.append(",mCurrentPage:");
    stringBuilder.append(this.dDg);
    bb.f("PageRecyclerView", stringBuilder.toString());
    Bundle bundle = new Bundle();
    bundle.putInt("mScrollOffset", this.dDe);
    bundle.putInt("mCurrentPage", this.dDg);
    bundle.putInt("mScrollWidth", this.dDa);
    bundle.putInt("mScrollHeight", this.dDb);
    bundle.putParcelable("super", super.onSaveInstanceState());
    return bundle;
  }
  
  public static interface a {
    void onPageScrollStateChanged(int param1Int);
    
    void onPageScrolled(int param1Int1, float param1Float, int param1Int2);
    
    void onPageSelected(int param1Int);
  }
  
  private class b extends RecyclerView.i {
    private b(PageRecyclerView this$0) {}
    
    public boolean au(int param1Int1, int param1Int2) { // Byte code:
      //   0: aload_0
      //   1: getfield dDj : Lcom/laiqian/ui/recycleview/pagerecyclerview/PageRecyclerView;
      //   4: invokevirtual jT : ()Landroid/support/v7/widget/RecyclerView$g;
      //   7: astore #6
      //   9: iconst_0
      //   10: istore #5
      //   12: aload #6
      //   14: ifnonnull -> 19
      //   17: iconst_0
      //   18: ireturn
      //   19: aload_0
      //   20: getfield dDj : Lcom/laiqian/ui/recycleview/pagerecyclerview/PageRecyclerView;
      //   23: invokevirtual jS : ()Landroid/support/v7/widget/RecyclerView$a;
      //   26: ifnonnull -> 31
      //   29: iconst_0
      //   30: ireturn
      //   31: aload_0
      //   32: getfield dDj : Lcom/laiqian/ui/recycleview/pagerecyclerview/PageRecyclerView;
      //   35: invokevirtual ka : ()I
      //   38: istore_3
      //   39: iload_2
      //   40: invokestatic abs : (I)I
      //   43: iload_3
      //   44: if_icmpgt -> 59
      //   47: iload #5
      //   49: istore #4
      //   51: iload_1
      //   52: invokestatic abs : (I)I
      //   55: iload_3
      //   56: if_icmple -> 80
      //   59: iload #5
      //   61: istore #4
      //   63: aload_0
      //   64: getfield dDj : Lcom/laiqian/ui/recycleview/pagerecyclerview/PageRecyclerView;
      //   67: aload #6
      //   69: iload_1
      //   70: iload_2
      //   71: invokestatic a : (Lcom/laiqian/ui/recycleview/pagerecyclerview/PageRecyclerView;Landroid/support/v7/widget/RecyclerView$g;II)Z
      //   74: ifeq -> 80
      //   77: iconst_1
      //   78: istore #4
      //   80: iload #4
      //   82: ireturn }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\recycleview\pagerecyclerview\PageRecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */