package com.yzx.mydefineview;

import com.rockerhieu.emojicon.EmojiconHandler;
import com.yzx.im_demo.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.EditText;
/**
* @Title YZXCustomMsgEditText 
* @Description 自定义消息文本编辑控件
* @Company yunzhixun
* @author zhuqian
* @date 2015-12-22 上午11:06:58 
*/
public class YZXCustomMsgEditText extends EditText {
	private static final String TAG = YZXCustomMsgEditText.class.getSimpleName();
	private TextPaint mTextPaint;
	private int textSize;
	private int textColor;
	private CharSequence text;//当前文本内容
	private int width;
	private int height;
	
	private OnTextChangeListener onTextChangeListener;
	
	public void setOnTextChangeListener(OnTextChangeListener onTextChangeListener) {
		this.onTextChangeListener = onTextChangeListener;
	}

	private int paddingBottom;//底部边距
	private int maxLines;//最多显示行数
	public YZXCustomMsgEditText(Context context) {
		super(context);
	}

	public YZXCustomMsgEditText(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public YZXCustomMsgEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		initAttrs(context,attrs,0);
		mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
		mTextPaint.setFakeBoldText(false);
		mTextPaint.density = context.getResources().getDisplayMetrics().density;
		mTextPaint.setTextSize(textSize);
		mTextPaint.setColor(textColor);
		paddingBottom = getPaddingBottom();
	}
	
	private void initAttrs(Context context, AttributeSet attrs, int defStyleAttr) {
		TypedArray tArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.YZXCustomMsgEditText, defStyleAttr, 0);
		
		for(int i=0;i<tArray.getIndexCount();i++){
			int attr = tArray.getIndex(i);
			switch (attr) {
			case R.styleable.YZXCustomMsgEditText_textSize:
				textSize = tArray.getDimensionPixelSize(attr,
						(int) TypedValue.applyDimension(
								TypedValue.COMPLEX_UNIT_SP, 14, getResources()
										.getDisplayMetrics()));
				break;
			case R.styleable.YZXCustomMsgEditText_textColor:
				textColor = tArray.getColor(attr, 0);
				break;
			default:
				break;
			}
		}
		tArray.recycle();
	}
	@Override
	protected void onTextChanged(CharSequence text, int start,
			int lengthBefore, int lengthAfter) {
		//消息文本发生变化
		this.text = text;
		
		Log.i(TAG, "text = "+text.toString());
		
		EmojiconHandler.addEmojis(getContext(), getText(), (int)getTextSize()+5);
		
		if(onTextChangeListener != null){
			onTextChangeListener.onTextChange(text, start, lengthBefore, lengthAfter);
		}
	}
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		this.width = w;
		this.height = h;
		this.maxLines = (h - getPaddingTop() - getPaddingBottom()) / getLineHeight();
		Log.i(TAG, "最多显示 = "+this.maxLines+"行");
	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		//画提示文本(10/200)
		drawText(canvas);
	}

	private void drawText(Canvas canvas) {
		int textSize = text.length();
		if(textSize > 200){
			textSize = 200;
		}
		String drawText = "("+textSize+"/200)";
		//文本宽度
		int textWidth = (int) mTextPaint.measureText(drawText, 0, drawText.length());
		int textX = width - textWidth - getPaddingLeft();
		int textY = (int) (height - ((mTextPaint.descent() + mTextPaint.ascent()) / 2) - paddingBottom);
		if(getLineCount() > maxLines){
			//如果当前文本行数超过最大文本行数，textY要+=超过的行数*每行文本高度
			textY += (getLineCount() - maxLines) * getLineHeight() + ((mTextPaint.descent() + mTextPaint.ascent()) / 2);
		}
		canvas.drawText(drawText, textX, textY, mTextPaint);
	}
	
	public interface OnTextChangeListener{
		void onTextChange(CharSequence text, int start,
				int lengthBefore, int lengthAfter);
	}
}
