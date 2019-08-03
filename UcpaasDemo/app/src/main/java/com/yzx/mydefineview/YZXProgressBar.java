package com.yzx.mydefineview;

import com.yzx.im_demo.R;
import com.yzx.tools.DensityUtil;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * 自定义进度条
 * 
 * @author zhuqian
 * 
 */
public class YZXProgressBar extends View {

	private int width;
	private int height;
	private Context mContext;

	private int process;
	// 圆环底颜色
	private int firstColor;
	// 圆环上面那层颜色
	private int secondColor;
	// 圆环宽度
	private int circleWidth;
	
	private int textSize;

	private Paint mPaint;
	
	private TextPaint textPaint;

	public YZXProgressBar(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public YZXProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.mContext = context;

		initAttrs(context, attrs, defStyleAttr);

		mPaint = new Paint();
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setAntiAlias(true);
		mPaint.setStrokeWidth(circleWidth);
		
		textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
		textPaint.setTextSize(textSize);
		textPaint.setColor(secondColor);
		textPaint.setFakeBoldText(false);
		textPaint.density = context.getResources().getDisplayMetrics().density;
	}

	// 获得属性
	private void initAttrs(Context context, AttributeSet attrs, int defStyleAttr) {
		TypedArray tArray = context.getTheme().obtainStyledAttributes(attrs,
				R.styleable.YZXProgressBar, defStyleAttr, 0);

		for (int i = 0; i < tArray.getIndexCount(); i++) {
			int attr = tArray.getIndex(i);
			switch (attr) {
			case R.styleable.YZXProgressBar_firstColor:
				firstColor = tArray.getColor(attr, Color.GRAY);
				break;
			case R.styleable.YZXProgressBar_secondColor:
				secondColor = tArray.getColor(attr, Color.GREEN);
				break;
			case R.styleable.YZXProgressBar_circleWidth:
				circleWidth = tArray.getDimensionPixelSize(attr,
						(int) TypedValue.applyDimension(
								TypedValue.COMPLEX_UNIT_DIP, 5, getResources()
										.getDisplayMetrics()));
				break;
			case R.styleable.YZXProgressBar_textSize:
				textSize = tArray.getDimensionPixelSize(attr,
						(int) TypedValue.applyDimension(
								TypedValue.COMPLEX_UNIT_SP, 19, getResources()
										.getDisplayMetrics()));
				break;
			default:
				break;
			}
		}

		tArray.recycle();
	}

	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int specMode = MeasureSpec.getMode(widthMeasureSpec);
		int specSize = MeasureSpec.getSize(widthMeasureSpec);

		if (specMode == MeasureSpec.EXACTLY) {
			width = specSize;
		} else {
			// 默认72dp
			width = DensityUtil.dip2px(mContext, 72);
		}

		specMode = MeasureSpec.getMode(heightMeasureSpec);
		specSize = MeasureSpec.getSize(heightMeasureSpec);
		if (specMode == MeasureSpec.EXACTLY) {
			height = specSize;
		} else {
			// 默认72dp
			height = DensityUtil.dip2px(mContext, 72);
		}

		setMeasuredDimension(width, height);
	}

	// 设置进度
	public void setProcess(int process) {
		if (process > 100) {
			this.process = 100;
		}
		if (process < 0) {
			this.process = 0;
		}
		if(this.process != process && process > 0){
			this.process = process;
			postInvalidate();
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		int center = getWidth() / 2;
		int radius = center - circleWidth / 2;

		// draw circle
		mPaint.setColor(firstColor);
		canvas.drawCircle(center, center, radius, mPaint);

		// draw arc
		RectF r = new RectF(center - radius, center - radius, center + radius,
				center + radius);
		mPaint.setColor(secondColor);
		canvas.drawArc(r, -90, ((float)process / 100) * 360, false, mPaint);
		
		String text = process+"%";
		int textX = (int)(center - textPaint.measureText(text, 0, text.length()) / 2);
		int textY = (int) ((canvas.getHeight() / 2) - ((textPaint.descent() + textPaint.ascent()) / 2));  
		canvas.drawText(text, textX, textY, textPaint);
		
	}
}
