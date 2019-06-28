package com.laiqian.ui.container;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import com.laiqian.ui.ActivityRoot;

public abstract class AbstractActivity extends ActivityRoot {
  public Handler mHandler = new Handler();
  
  private void a(TextView paramTextView, String paramString, float paramFloat) {
    paramTextView.setText(paramString);
    if (paramFloat != 0.0F)
      paramTextView.setTextSize(1, paramFloat); 
  }
  
  public static boolean aqS() { return Thread.currentThread().equals(Looper.getMainLooper().getThread()); }
  
  private void b(View paramView, Object paramObject, float paramFloat) {
    if (paramView != null) {
      String str1;
      Class clazz;
      if (paramObject == null) {
        str1 = "";
      } else {
        str1 = paramObject.toString();
      } 
      String str2 = str1;
      if (str1 == null)
        str2 = ""; 
      if (paramView instanceof Checkable) {
        if (paramObject instanceof Boolean) {
          ((Checkable)paramView).setChecked(((Boolean)paramObject).booleanValue());
          return;
        } 
        if (paramView instanceof TextView) {
          if (paramObject instanceof Spannable) {
            ((TextView)paramView).setText((Spannable)paramObject);
            return;
          } 
          a((TextView)paramView, str2, paramFloat);
          return;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramView.getClass().getName());
        stringBuilder.append(" should be bound to a Boolean, not a ");
        if (paramObject == null) {
          clazz = "<unknown type>";
        } else {
          clazz = paramObject.getClass();
        } 
        stringBuilder.append(clazz);
        throw new IllegalStateException(stringBuilder.toString());
      } 
      if (clazz instanceof TextView) {
        if (paramObject instanceof SpannableStringBuilder) {
          ((TextView)clazz).setText((SpannableStringBuilder)paramObject);
          return;
        } 
        a((TextView)clazz, str2, paramFloat);
        return;
      } 
      if (clazz instanceof ImageView) {
        if (paramObject instanceof Integer) {
          setViewImage((ImageView)clazz, ((Integer)paramObject).intValue());
          return;
        } 
        setViewImage((ImageView)clazz, str2);
        return;
      } 
      paramObject = new StringBuilder();
      paramObject.append(clazz.getClass().getName());
      paramObject.append(" is not a  view that can be bounds by this Activity");
      throw new IllegalStateException(paramObject.toString());
    } 
  }
  
  private void setViewImage(ImageView paramImageView, int paramInt) { paramImageView.setImageResource(paramInt); }
  
  private void setViewImage(ImageView paramImageView, String paramString) {
    try {
      paramImageView.setImageResource(Integer.parseInt(paramString));
      return;
    } catch (NumberFormatException numberFormatException) {
      paramImageView.setImageURI(Uri.parse(paramString));
      return;
    } 
  }
  
  public void a(View paramView, Object paramObject) { a(paramView, paramObject, 0.0F); }
  
  public void a(View paramView, Object paramObject, float paramFloat) {
    if (aqS()) {
      b(paramView, paramObject, paramFloat);
      return;
    } 
    this.mHandler.post(new a(this, paramView, paramObject, paramFloat));
  }
  
  public void a(ab<?> paramab, Object paramObject) { a(paramab.getView(), paramObject, 0.0F); }
  
  public void i(Runnable paramRunnable) {
    if (aqS()) {
      paramRunnable.run();
      return;
    } 
    this.mHandler.post(paramRunnable);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\AbstractActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */