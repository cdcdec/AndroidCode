package com.laiqian.ui.container;

import android.content.Context;
import android.view.View;
import java.lang.reflect.Field;

public class ab<V extends View> extends Object {
  protected final int mId;
  
  protected V mView;
  
  public ab(int paramInt) { this.mId = paramInt; }
  
  public void S(View paramView) {
    this.mView = paramView;
    Field[] arrayOfField = getClass().getFields();
    int i = arrayOfField.length;
    byte b = 0;
    while (true) {
      if (b < i) {
        field = arrayOfField[b];
        try {
          Object object = field.get(this);
        } catch (IllegalAccessException field) {
          field = null;
        } 
        if (field != null && field instanceof ab) {
          ab ab1 = (ab)field;
          ab1.S(this.mView.findViewById(ab1.getId()));
        } 
        b++;
        continue;
      } 
      return;
    } 
  }
  
  public Context getContext() { return this.mView.getContext(); }
  
  public int getId() { return this.mId; }
  
  public V getView() { return (V)this.mView; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */