package com.yzx.mydefineview;

import com.yzx.im_demo.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
/**
 * @Title IMLocationInfoView
 * @Description 位置信息View
 * @Company yunzhixun
 * @author zhuqian
 * @date 2015-12-10 上午10:54:11
 */
public class IMLocationInfoView extends View {

	private static final String TAG = "IMLocationInfoView";
	private int circleWidth;// 圆角宽度
	private int trangleH;// 底部三角形高度
	private int nameTextSize;// 位置名称文字Size
	private int addressTextSize;// 地址文字Size;
	private int textPadding;// 文字间距

	private int bkg;// 背景颜色
	private int textColor;// 文字颜色

	private String nameText;// 位置名称
	private String addressText;// 地址

	private int width;
	private int height;

	private Paint mPaint;
	private TextPaint mTextPaint;
	
	private final int maxWidth;//控件最大宽度
	
	private int curTextLine;//当前文字行数

	public IMLocationInfoView(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
		//最大宽度为屏幕宽度的3/4
		maxWidth = getResources().getDisplayMetrics().widthPixels * 3 / 4;

		initAttrs(context, attrs, defStyleAttr);

		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setColor(bkg);
		//设置透明度
		mPaint.setAlpha(180);
		
		mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
		mTextPaint.setFakeBoldText(false);
		mTextPaint.density = context.getResources().getDisplayMetrics().density;
		mTextPaint.setTextSize(nameTextSize);
		mTextPaint.setColor(textColor);
	}

	private void initAttrs(Context context, AttributeSet attrs, int defStyleAttr) {
		TypedArray tArray = context.getTheme().obtainStyledAttributes(attrs,
				R.styleable.IMLocationInfoView, defStyleAttr, 0);

		for (int i = 0; i < tArray.getIndexCount(); i++) {
			int attr = tArray.getIndex(i);
			switch (attr) {
			case R.styleable.IMLocationInfoView_circleDismen:
				circleWidth = tArray.getDimensionPixelSize(attr,
						(int) TypedValue.applyDimension(
								TypedValue.COMPLEX_UNIT_DIP, 8, getResources()
										.getDisplayMetrics()));
				break;
			case R.styleable.IMLocationInfoView_addressTextSize:
				addressTextSize = tArray.getDimensionPixelSize(attr,
						(int) TypedValue.applyDimension(
								TypedValue.COMPLEX_UNIT_SP, 15, getResources()
										.getDisplayMetrics()));
				break;
			case R.styleable.IMLocationInfoView_bkg:
				bkg =  tArray.getColor(attr, 0);
				break;
			case R.styleable.IMLocationInfoView_nameTextSize:
				nameTextSize = tArray.getDimensionPixelSize(attr,
						(int) TypedValue.applyDimension(
								TypedValue.COMPLEX_UNIT_SP, 19, getResources()
										.getDisplayMetrics()));
				break;
			case R.styleable.IMLocationInfoView_textColor:
				textColor =  tArray.getColor(attr, 0);
				break;
			case R.styleable.IMLocationInfoView_textPadding:
				textPadding = tArray.getDimensionPixelSize(attr,
						(int) TypedValue.applyDimension(
								TypedValue.COMPLEX_UNIT_DIP, 8, getResources()
										.getDisplayMetrics()));
				break;
			case R.styleable.IMLocationInfoView_trangleH:
				trangleH = tArray.getDimensionPixelSize(attr,
						(int) TypedValue.applyDimension(
								TypedValue.COMPLEX_UNIT_DIP, 8, getResources()
										.getDisplayMetrics()));
				break;
			default:
				break;
			}
		}
	}

	public IMLocationInfoView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		calcWh();
		setMeasuredDimension(width, height);
	}
	@Override
	protected void onDraw(Canvas canvas) {
		drawPath(canvas);
		drawText(canvas);
	}
	//画路径
	private void drawPath(Canvas canvas) {
		Path path = new Path();
		path.moveTo(0, circleWidth);
		RectF oval = new RectF(0, 0, 2*circleWidth, 2*circleWidth);
		path.addArc(oval, 180, 90);
		path.lineTo(width - circleWidth, 0);
		oval = new RectF(width - 2 * circleWidth, 0, width, 2*circleWidth);
		path.addArc(oval, 270, 90);
		path.lineTo(width, height - circleWidth - trangleH);
		oval = new RectF(width - 2 * circleWidth, height - trangleH - 2*circleWidth, width, height-trangleH);
		path.addArc(oval, 0, 90);
		path.lineTo((width+trangleH)/2, height-trangleH);
		path.lineTo(width/2, height);
		path.lineTo((width-trangleH)/2, height-trangleH);
		path.lineTo(circleWidth, height-trangleH);
		oval = new RectF(0, height-trangleH-2*circleWidth, 2* circleWidth, height-trangleH);
		path.addArc(oval, 90, 90);
		path.lineTo(0, circleWidth);
		
		canvas.drawPath(path, mPaint);
	}
	private void drawText(Canvas canvas){
		curTextLine = 0;
		mTextPaint.setTextSize(addressTextSize);
		drawText(canvas,nameText,true);
		mTextPaint.setTextSize(nameTextSize);
		drawText(canvas,addressText,true);
	}
	
	private void drawText(Canvas canvas,String srcText,boolean isDraw){
		String subStr = srcText;
		String oldStr = "";
		while(true){
			curTextLine++;
			oldStr = subStr;
			//截取结果。画在画板上
			int subIndex = subText(subStr);
			String text = subStr.substring(0, subIndex);
			Log.i(TAG, "截取之后的字符串："+text);
			//从最左边开始
			if(isDraw){
				int textX = width - textPadding;
				int textHeight = (int) (mTextPaint.descent() - mTextPaint.ascent());
				int textY =  (int)(textPadding+ (curTextLine - 1) * textHeight + (mTextPaint.descent() + mTextPaint.ascent()) / 2);
				canvas.drawText(text, textX, textY, mTextPaint);
			}
			if(TextUtils.equals(text, oldStr)){
				break;
			}
			subStr = subStr.substring(subIndex+1, subStr.length());
			Log.i(TAG, "剩余字符串："+subStr);
		}
	}
	//计算宽高
	private void calcWh() {
		//名称最大宽度
		int nameMaxLen = (int) mTextPaint.measureText(nameText, 0, nameText.length());
		//地址最大宽度
		int addressMaxLen = (int) mTextPaint.measureText(addressText, 0, addressText.length());
		if(nameMaxLen > maxWidth || addressMaxLen > maxWidth){
			width = maxWidth;
		}else{
			width = nameMaxLen > addressMaxLen ? nameMaxLen : addressMaxLen;
		}
		height = 0;
		//计算文字行数
		mTextPaint.setTextSize(addressTextSize);
		int nameTextHeight = (int) (mTextPaint.descent() - mTextPaint.ascent());
		drawText(null,nameText,false);
		height += curTextLine * nameTextHeight + textPadding;
		mTextPaint.setTextSize(nameTextSize);
		int addressTextHeight = (int) (mTextPaint.descent() - mTextPaint.ascent());
		drawText(null,addressText,false);
		height += curTextLine * addressTextHeight + textPadding;
		
		height += textPadding + trangleH;
		
		Log.i(TAG, "width = "+width+"，height = "+height);
	}
	private int subText(String text){
		int textLen = 0;
		int len = text.length();
		do{
			textLen = (int) mTextPaint.measureText(text, 0, len);
		}while(textLen > (width - 2 * textPadding) && --len > 0);
		return len;
	}
	/**
	* @Description 设置文本内容，刷新界面
	* @param nameText 名称文本
	* @param addressText	地址文本
	* @date 2015-12-10 上午11:29:39 
	* @author zhuqian  
	* @return void
	 */
	public void setText(String nameText,String addressText){
		this.nameText = nameText;
		this.addressText = addressText;
		//刷新界面
		postInvalidate();
	}
}
