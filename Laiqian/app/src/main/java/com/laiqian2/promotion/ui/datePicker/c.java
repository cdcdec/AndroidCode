package com.laiqian.promotion.ui.datePicker;

class c implements CheckTextView.a {
  c(a parama) {}
  
  public void a(CheckTextView paramCheckTextView, boolean paramBoolean) {
    char c1;
    a a1 = this.cXj;
    int i = ((Integer)paramCheckTextView.getTag()).intValue();
    if (paramBoolean) {
      c1 = '1';
    } else {
      c1 = '0';
    } 
    a.b(a1, i, c1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\datePicker\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */