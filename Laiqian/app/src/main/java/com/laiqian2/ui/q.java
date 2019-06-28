package com.laiqian.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.ListPopupWindow;
import com.laiqian.infrastructure.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class q extends ListPopupWindow {
  private Context context;
  
  public q(Context paramContext, @NonNull Collection<? extends CharSequence> paramCollection, int paramInt1, int paramInt2) {
    super(paramContext);
    this.context = paramContext;
    setWidth(paramInt1);
    setHeight(paramInt2);
    setBackgroundDrawable(paramContext.getResources().getDrawable(R.drawable.bg_more));
    ArrayList arrayList = new ArrayList();
    arrayList.addAll(paramCollection);
    setAdapter(new ArrayAdapter(paramContext, R.layout.item_layout_simple_text, arrayList));
  }
  
  public q(Context paramContext, @NonNull String[] paramArrayOfString, int paramInt1, int paramInt2) { this(paramContext, Arrays.asList(paramArrayOfString), paramInt1, paramInt2); }
  
  public void show() {
    super.show();
    if (getListView() != null)
      getListView().setVerticalScrollBarEnabled(false); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */