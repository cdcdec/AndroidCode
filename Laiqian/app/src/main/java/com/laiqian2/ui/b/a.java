package com.laiqian.ui.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.edittext.EditText;
import com.laiqian.util.ae;

public class a {
  private PopupWindow cWm;
  
  boolean cgE = true;
  
  boolean cgF = false;
  
  private EditText dDl;
  
  private String dDm = "";
  
  private View dDn;
  
  private View dDo;
  
  private EditText dDp;
  
  private View dDq;
  
  View.OnKeyListener dDr = new d(this);
  
  View.OnClickListener dDs = new e(this);
  
  boolean dDt = true;
  
  View.OnClickListener dDu = new g(this);
  
  private Handler handler;
  
  private Context mContext;
  
  public a(Context paramContext, EditText paramEditText, View paramView) {
    this.dDl = paramEditText;
    this.mContext = paramContext;
    this.dDn = paramView;
  }
  
  private void ZM() {
    if (this.dDl.hasSelection())
      init(); 
  }
  
  protected void ase() {
    this.dDm = this.dDl.getText().toString();
    if (this.dDq == null)
      this.dDq = View.inflate(this.mContext, R.layout.lq_keyboard_calculator, null); 
    this.cWm = new PopupWindow(this.dDq, -1, -2);
    this.cWm.setBackgroundDrawable(new BitmapDrawable());
    this.cWm.setFocusable(true);
    this.cWm.setOutsideTouchable(true);
    this.cWm.showAtLocation(this.dDl.getRootView(), 80, 0, 0);
    this.cWm.setOnDismissListener(new f(this));
    ((Button)this.dDq.findViewById(R.id.bt_zero)).setOnClickListener(this.dDu);
    ((Button)this.dDq.findViewById(R.id.bt_one)).setOnClickListener(this.dDu);
    ((Button)this.dDq.findViewById(R.id.bt_two)).setOnClickListener(this.dDu);
    ((Button)this.dDq.findViewById(R.id.bt_three)).setOnClickListener(this.dDu);
    ((Button)this.dDq.findViewById(R.id.bt_four)).setOnClickListener(this.dDu);
    ((Button)this.dDq.findViewById(R.id.bt_five)).setOnClickListener(this.dDu);
    ((Button)this.dDq.findViewById(R.id.bt_six)).setOnClickListener(this.dDu);
    ((Button)this.dDq.findViewById(R.id.bt_seven)).setOnClickListener(this.dDu);
    ((Button)this.dDq.findViewById(R.id.bt_eight)).setOnClickListener(this.dDu);
    ((Button)this.dDq.findViewById(R.id.bt_nine)).setOnClickListener(this.dDu);
    ((Button)this.dDq.findViewById(R.id.bt_dot)).setOnClickListener(this.dDu);
    ((Button)this.dDq.findViewById(R.id.bt_delete)).setOnClickListener(this.dDu);
    ((Button)this.dDq.findViewById(R.id.bt_clear)).setOnClickListener(this.dDu);
    ((Button)this.dDq.findViewById(R.id.bt_ok)).setOnClickListener(this.dDu);
    ((Button)this.dDq.findViewById(R.id.bt_add)).setOnClickListener(this.dDu);
    ((Button)this.dDq.findViewById(R.id.bt_plus)).setOnClickListener(this.dDu);
    ((Button)this.dDq.findViewById(R.id.bt_divide)).setOnClickListener(this.dDu);
    ((Button)this.dDq.findViewById(R.id.bt_ride)).setOnClickListener(this.dDu);
    ((Button)this.dDq.findViewById(R.id.bt_equal)).setOnClickListener(this.dDu);
    this.dDp = (EditText)this.dDq.findViewById(R.id.et_calc);
    this.dDp.setInputType(0);
    this.dDp.setText(this.dDm);
    this.dDt = true;
    if (!"".equals(this.dDm) && 0.0D != Double.parseDouble(this.dDm))
      this.dDt = false; 
  }
  
  public void dismiss() {
    if (this.cWm != null) {
      this.cWm.dismiss();
      if (this.dDn.getVisibility() == 0)
        this.dDn.setVisibility(8); 
      this.cWm = null;
    } 
  }
  
  public void init() {
    this.cgE = true;
    this.cgF = false;
  }
  
  public boolean isShow() { return (this.cWm != null) ? this.cWm.isShowing() : 0; }
  
  public void setHandler(Handler paramHandler) { this.handler = paramHandler; }
  
  public void show() {
    if (this.cWm != null && this.cWm.isShowing())
      return; 
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((Activity)this.mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    int i = displayMetrics.heightPixels;
    if (this.dDo == null)
      this.dDo = View.inflate(this.mContext, R.layout.normal_qwerty, null); 
    if (this.cWm == null) {
      this.cWm = new PopupWindow(this.dDo, -1, ae.b(this.mContext, (i / 3)));
      this.cWm.setBackgroundDrawable(new BitmapDrawable());
      this.cWm.setOutsideTouchable(false);
      this.cWm.setFocusable(false);
    } 
    this.cWm.setOnDismissListener(new b(this));
    ViewGroup.LayoutParams layoutParams = this.dDn.getLayoutParams();
    layoutParams.height = ae.b(this.mContext, (i / 3));
    layoutParams.width = this.dDo.getWidth();
    this.dDn.setLayoutParams(layoutParams);
    this.dDn.setVisibility(0);
    this.cWm.showAtLocation(this.dDl.getRootView(), 80, 0, 0);
    if (this.dDl.getText().length() > 0)
      this.dDl.selectAll(); 
    ((LinearLayout)this.dDo.findViewById(R.id.llRoot)).setOnKeyListener(this.dDr);
    ((Button)this.dDo.findViewById(R.id.one)).setOnClickListener(this.dDs);
    ((Button)this.dDo.findViewById(R.id.two)).setOnClickListener(this.dDs);
    ((Button)this.dDo.findViewById(R.id.three)).setOnClickListener(this.dDs);
    ((Button)this.dDo.findViewById(R.id.four)).setOnClickListener(this.dDs);
    ((Button)this.dDo.findViewById(R.id.five)).setOnClickListener(this.dDs);
    ((Button)this.dDo.findViewById(R.id.six)).setOnClickListener(this.dDs);
    ((Button)this.dDo.findViewById(R.id.seven)).setOnClickListener(this.dDs);
    ((Button)this.dDo.findViewById(R.id.eight)).setOnClickListener(this.dDs);
    ((Button)this.dDo.findViewById(R.id.nine)).setOnClickListener(this.dDs);
    ((Button)this.dDo.findViewById(R.id.zero)).setOnClickListener(this.dDs);
    ((Button)this.dDo.findViewById(R.id.dot)).setOnClickListener(this.dDs);
    ((Button)this.dDo.findViewById(R.id.calc)).setOnClickListener(this.dDs);
    ((Button)this.dDo.findViewById(R.id.ok)).setOnClickListener(this.dDs);
    ImageButton imageButton = (ImageButton)this.dDo.findViewById(R.id.delete);
    imageButton.setOnClickListener(this.dDs);
    imageButton.setOnLongClickListener(new c(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */