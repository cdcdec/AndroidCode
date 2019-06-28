package com.laiqian.ui.container;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.models.h;

public class b extends ab<LinearLayout> {
  public static final int aCt = R.layout.layout_address_selector;
  
  public ab<TextView> dwH = new ab(R.id.tv_province);
  
  public ab<TextView> dwI = new ab(R.id.tv_city);
  
  public ab<TextView> dwJ = new ab(R.id.tv_district);
  
  public b(int paramInt) { super(paramInt); }
  
  public void b(h.c paramc) {
    if (paramc == null) {
      ((TextView)this.dwJ.getView()).setTextColor(getContext().getResources().getColor(R.color.pos_text_grey));
      ((TextView)this.dwJ.getView()).setText(getContext().getString(R.string.district));
      return;
    } 
    ((TextView)this.dwJ.getView()).setTextColor(getContext().getResources().getColor(R.color.brown_black_color));
    ((TextView)this.dwJ.getView()).setText(paramc.getName());
  }
  
  public void d(h.a parama) {
    if (parama == null) {
      ((TextView)this.dwI.getView()).setTextColor(getContext().getResources().getColor(R.color.pos_text_grey));
      ((TextView)this.dwI.getView()).setText(getContext().getString(R.string.city));
      return;
    } 
    ((TextView)this.dwI.getView()).setTextColor(getContext().getResources().getColor(R.color.brown_black_color));
    ((TextView)this.dwI.getView()).setText(parama.getName());
  }
  
  public void d(h.e parame) {
    if (parame == null) {
      ((TextView)this.dwH.getView()).setTextColor(getContext().getResources().getColor(R.color.pos_text_grey));
      if (getContext().getResources().getBoolean(R.bool.is_evako)) {
        ((TextView)this.dwH.getView()).setText(getContext().getString(R.string.province_default));
        return;
      } 
      ((TextView)this.dwH.getView()).setText(getContext().getString(R.string.province));
      return;
    } 
    ((TextView)this.dwH.getView()).setTextColor(getContext().getResources().getColor(R.color.brown_black_color));
    ((TextView)this.dwH.getView()).setText(parame.getName());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */