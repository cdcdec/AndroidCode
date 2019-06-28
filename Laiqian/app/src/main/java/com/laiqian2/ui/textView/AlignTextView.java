package com.laiqian.ui.textView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import java.util.ArrayList;
import java.util.List;

public class AlignTextView extends TextView {
  private a align = a.dDY;
  
  private boolean firstCalc = true;
  
  private float lineSpacingAdd = 0.0F;
  
  private float lineSpacingMultiplier = 1.0F;
  
  private List<String> lines = new ArrayList();
  
  private int originalHeight = 0;
  
  private int originalLineCount = 0;
  
  private int originalPaddingBottom = 0;
  
  private boolean setPaddingFromMe = false;
  
  private List<Integer> tailLines = new ArrayList();
  
  private float textHeight;
  
  private float textLineSpaceExtra = 0.0F;
  
  private int width;
  
  public AlignTextView(Context paramContext) {
    super(paramContext);
    setTextIsSelectable(false);
  }
  
  public AlignTextView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    setTextIsSelectable(false);
    this.lineSpacingMultiplier = paramAttributeSet.getAttributeFloatValue("http://schemas.android.com/apk/res/android", "lineSpacingMultiplier", 1.0F);
    this.lineSpacingAdd = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16843287 }).getDimensionPixelSize(0, 0);
    this.originalPaddingBottom = getPaddingBottom();
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AlignTextView);
    switch (typedArray.getInt(R.styleable.AlignTextView_align, 0)) {
      default:
        this.align = a.dDY;
        break;
      case 2:
        this.align = a.dEa;
        break;
      case 1:
        this.align = a.dDZ;
        break;
    } 
    typedArray.recycle();
  }
  
  private void calc(Paint paramPaint, String paramString) {
    StringBuilder stringBuilder2;
    if (paramString.length() == 0) {
      this.lines.add("\n");
      return;
    } 
    float f = paramPaint.measureText("中");
    int k = (int)(this.width / f);
    int i = Math.min(k, paramString.length());
    int j = 0;
    StringBuilder stringBuilder1 = new StringBuilder(paramString.substring(0, i));
    i = k;
    while (true) {
      stringBuilder2 = stringBuilder1;
      if (i < paramString.length()) {
        int m;
        if (paramPaint.measureText(paramString.substring(j, i + 1)) > this.width) {
          this.lines.add(stringBuilder1.toString());
          stringBuilder2 = new StringBuilder();
          if (paramString.length() - i > k) {
            j = i + k;
            stringBuilder2.append(paramString.substring(i, j));
            m = j - 1;
            stringBuilder1 = stringBuilder2;
            j = i;
          } else {
            this.lines.add(paramString.substring(i));
            break;
          } 
        } else {
          stringBuilder1.append(paramString.charAt(i));
          m = i;
        } 
        i = m + 1;
        continue;
      } 
      break;
    } 
    if (stringBuilder2.length() > 0)
      this.lines.add(stringBuilder2.toString()); 
    this.tailLines.add(Integer.valueOf(this.lines.size() - 1));
  }
  
  private void measureTextViewHeight(String paramString, float paramFloat, int paramInt) {
    TextView textView = new TextView(getContext());
    textView.setText(paramString);
    textView.setTextSize(0, paramFloat);
    textView.measure(View.MeasureSpec.makeMeasureSpec(paramInt, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.originalLineCount = textView.getLineCount();
    this.originalHeight = textView.getMeasuredHeight();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    TextPaint textPaint = getPaint();
    textPaint.setColor(getCurrentTextColor());
    textPaint.drawableState = getDrawableState();
    this.width = getMeasuredWidth();
    Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
    float f1 = getTextSize() - fontMetrics.bottom - fontMetrics.descent + fontMetrics.ascent - fontMetrics.top;
    float f2 = f1;
    if ((getGravity() & 0x1000) == 0)
      f2 = f1 + (this.textHeight - f1) / 2.0F; 
    int j = getPaddingTop();
    int k = getPaddingLeft();
    int i = getPaddingRight();
    this.width = this.width - k - i;
    for (i = 0; i < this.lines.size(); i++) {
      float f5 = i;
      float f6 = this.textHeight;
      String str = (String)this.lines.get(i);
      float f4 = k;
      float f7 = this.width - textPaint.measureText(str);
      float f3 = f7 / (str.length() - 1);
      f1 = f4;
      if (this.tailLines.contains(Integer.valueOf(i))) {
        float f = 0.0F;
        if (this.align == a.dDZ) {
          f1 = f4 + f7 / 2.0F;
          f3 = f;
        } else {
          f1 = f4;
          f3 = f;
          if (this.align == a.dEa) {
            f1 = f4 + f7;
            f3 = f;
          } 
        } 
      } 
      byte b;
      for (b = 0; b < str.length(); b = b1) {
        float f = textPaint.measureText(str.substring(0, b));
        f4 = b;
        byte b1 = b + 1;
        paramCanvas.drawText(str.substring(b, b1), f + f4 * f3 + f1, j + f6 * f5 + f2 + this.textLineSpaceExtra * f5, textPaint);
      } 
    } 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) { // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: iload_3
    //   4: iload #4
    //   6: iload #5
    //   8: invokespecial onLayout : (ZIIII)V
    //   11: aload_0
    //   12: getfield firstCalc : Z
    //   15: ifeq -> 220
    //   18: aload_0
    //   19: aload_0
    //   20: invokevirtual getMeasuredWidth : ()I
    //   23: putfield width : I
    //   26: aload_0
    //   27: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   30: invokeinterface toString : ()Ljava/lang/String;
    //   35: astore #6
    //   37: aload_0
    //   38: invokevirtual getPaint : ()Landroid/text/TextPaint;
    //   41: astore #7
    //   43: aload_0
    //   44: getfield lines : Ljava/util/List;
    //   47: invokeinterface clear : ()V
    //   52: aload_0
    //   53: getfield tailLines : Ljava/util/List;
    //   56: invokeinterface clear : ()V
    //   61: aload #6
    //   63: ldc_w '\n'
    //   66: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   69: astore #8
    //   71: aload #8
    //   73: arraylength
    //   74: istore_3
    //   75: iconst_0
    //   76: istore_2
    //   77: iload_2
    //   78: iload_3
    //   79: if_icmpge -> 99
    //   82: aload_0
    //   83: aload #7
    //   85: aload #8
    //   87: iload_2
    //   88: aaload
    //   89: invokespecial calc : (Landroid/graphics/Paint;Ljava/lang/String;)V
    //   92: iload_2
    //   93: iconst_1
    //   94: iadd
    //   95: istore_2
    //   96: goto -> 77
    //   99: aload_0
    //   100: aload #6
    //   102: aload #7
    //   104: invokevirtual getTextSize : ()F
    //   107: aload_0
    //   108: invokevirtual getMeasuredWidth : ()I
    //   111: aload_0
    //   112: invokevirtual getPaddingLeft : ()I
    //   115: isub
    //   116: aload_0
    //   117: invokevirtual getPaddingRight : ()I
    //   120: isub
    //   121: invokespecial measureTextViewHeight : (Ljava/lang/String;FI)V
    //   124: aload_0
    //   125: aload_0
    //   126: getfield originalHeight : I
    //   129: i2f
    //   130: fconst_1
    //   131: fmul
    //   132: aload_0
    //   133: getfield originalLineCount : I
    //   136: i2f
    //   137: fdiv
    //   138: putfield textHeight : F
    //   141: aload_0
    //   142: aload_0
    //   143: getfield textHeight : F
    //   146: aload_0
    //   147: getfield lineSpacingMultiplier : F
    //   150: fconst_1
    //   151: fsub
    //   152: fmul
    //   153: aload_0
    //   154: getfield lineSpacingAdd : F
    //   157: fadd
    //   158: putfield textLineSpaceExtra : F
    //   161: aload_0
    //   162: getfield textLineSpaceExtra : F
    //   165: aload_0
    //   166: getfield textHeight : F
    //   169: fadd
    //   170: aload_0
    //   171: getfield lines : Ljava/util/List;
    //   174: invokeinterface size : ()I
    //   179: aload_0
    //   180: getfield originalLineCount : I
    //   183: isub
    //   184: i2f
    //   185: fmul
    //   186: f2i
    //   187: istore_2
    //   188: aload_0
    //   189: iconst_1
    //   190: putfield setPaddingFromMe : Z
    //   193: aload_0
    //   194: aload_0
    //   195: invokevirtual getPaddingLeft : ()I
    //   198: aload_0
    //   199: invokevirtual getPaddingTop : ()I
    //   202: aload_0
    //   203: invokevirtual getPaddingRight : ()I
    //   206: aload_0
    //   207: getfield originalPaddingBottom : I
    //   210: iload_2
    //   211: iadd
    //   212: invokevirtual setPadding : (IIII)V
    //   215: aload_0
    //   216: iconst_0
    //   217: putfield firstCalc : Z
    //   220: return }
  
  public String replacePunctuation(String paramString) { return paramString.replace('，', ',').replace('。', '.').replace('【', '[').replace('】', ']').replace('？', '?').replace('！', '!').replace('（', '(').replace('）', ')').replace('“', '"').replace('”', '"'); }
  
  public void setAlign(a parama) {
    this.align = parama;
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!this.setPaddingFromMe)
      this.originalPaddingBottom = paramInt4; 
    this.setPaddingFromMe = false;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType) {
    this.firstCalc = true;
    super.setText(replacePunctuation(paramCharSequence.toString()), paramBufferType);
    requestLayout();
  }
  
  public enum a {
    dDY, dDZ, dEa;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\textView\AlignTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */