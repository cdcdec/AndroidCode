package com.yzx.mydefineview;

import com.yzx.im_demo.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

/**
 * 复制删除popView
 * @author zhuqian
 *
 */
public class MessagePopView extends View {
	//默认的操作类型
	private int operateStyle;
	
	private Paint mPaint;
	private TextPaint mTextPaint;
	private int textColor;
	private int normalColor;
	private int focusColor;
	private int textSize;
	private int paddingL;
	private int trangleH;
	//分隔线宽度
	private int devideWidth;
	//分隔线颜色
	private int devideColor;
	
	private int width;
	private int height;
	
	private static final String COPYTEXT = "复制";
	private static final String DELETETEXT = "删除";
	private static final String COPYT_ANDDELE_TEEXT = "复制删除";

	private static final String TAG = "MessagePopView";
	
	private PathEffect mEffect = new CornerPathEffect(15);// 路径效果
	private Paint devidePaint;
	//控件是否获取到焦点
	private boolean actionFoucs;
	
	private OnMessageHandler messageHandler;
	private Context context;

	public void setMessageHandler(OnMessageHandler messageHandler) {
		this.messageHandler = messageHandler;
	}

	public MessagePopView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.context = context;
		initAttrs(context, attrs, defStyleAttr);
		
		initPaint(context);
	}
	
	private void initPaint(Context context){
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setPathEffect(mEffect);
		mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
		mTextPaint.setFakeBoldText(false);
		mTextPaint.density = context.getResources().getDisplayMetrics().density;
		mTextPaint.setTextSize(textSize);
		mTextPaint.setColor(textColor);
		if(operateStyle >= 2){
			devidePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
			devidePaint.setStyle(Paint.Style.STROKE);
			devidePaint.setStrokeWidth(devideWidth);
			devidePaint.setColor(devideColor);
		}
	}

	private void initAttrs(Context context, AttributeSet attrs, int defStyleAttr) {
		TypedArray tArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MessagePopView, defStyleAttr, 0);
		
		for(int i=0;i<tArray.getIndexCount();i++){
			int attr = tArray.getIndex(i);
			switch (attr) {
			case R.styleable.MessagePopView_focusColor:
				focusColor = tArray.getColor(attr, 0);
				break;
			case R.styleable.MessagePopView_normalColor:
				normalColor = tArray.getColor(attr, 0);
				break;
			case R.styleable.MessagePopView_textColor:
				textColor = tArray.getColor(attr, 0);
				break;
			case R.styleable.MessagePopView_devideColor:
				devideColor = tArray.getColor(attr, 0);
				break;
			case R.styleable.MessagePopView_textSize:
				textSize = tArray.getDimensionPixelSize(attr,
						(int) TypedValue.applyDimension(
								TypedValue.COMPLEX_UNIT_SP, 14, getResources()
										.getDisplayMetrics()));
				break;
			case R.styleable.MessagePopView_operateStyle:
				operateStyle = tArray.getInt(attr, 0);
				break;
			case R.styleable.MessagePopView_trangleH:
				trangleH = tArray.getDimensionPixelSize(attr,
						(int) TypedValue.applyDimension(
								TypedValue.COMPLEX_UNIT_DIP, 5, getResources()
										.getDisplayMetrics()));
				break;
			case R.styleable.MessagePopView_paddingL:
				paddingL = tArray.getDimensionPixelSize(attr,
						(int) TypedValue.applyDimension(
								TypedValue.COMPLEX_UNIT_DIP, 10, getResources()
										.getDisplayMetrics()));
				break;
			case R.styleable.MessagePopView_devideWidth:
				devideWidth = tArray.getDimensionPixelSize(attr,
						(int) TypedValue.applyDimension(
								TypedValue.COMPLEX_UNIT_DIP, 1, getResources()
										.getDisplayMetrics()));
				break;
			default:
				break;
			}
		}
		tArray.recycle();
	}

	public MessagePopView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		
		caculateWh();
		setMeasuredDimension(width, height);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		//先画背景
		drawPath(canvas);
		
		drawText(canvas);
	}
	private void drawText(Canvas canvas) {
		int textX = 0;
		int textY = (int) ((height - trangleH) / 2 - ((mTextPaint.descent() + mTextPaint.ascent()) / 2));
		if(operateStyle == 0){
			textX = paddingL;
			canvas.drawText(COPYTEXT, textX, textY, mTextPaint);
		}else if(operateStyle == 1){
			textX = paddingL;
			canvas.drawText(DELETETEXT, textX, textY, mTextPaint);
		}else{
			textX = paddingL;
			canvas.drawText(COPYTEXT, textX, textY, mTextPaint);
			textX = (int)(width - paddingL - (int) mTextPaint.measureText(DELETETEXT, 0, DELETETEXT.length()));
			canvas.drawText(DELETETEXT, textX, textY, mTextPaint);
		}
	}

	private void drawPath(Canvas canvas) {
		Path path = new Path();
		path.moveTo(0, 0);
		path.lineTo(width, 0);
		path.lineTo(width, height - trangleH);
		path.lineTo((width + trangleH) / 2, height - trangleH);
		path.lineTo(width / 2, height);
		path.lineTo((width - trangleH) / 2, height - trangleH);
		path.lineTo(0, height - trangleH);
		path.lineTo(0, 0);
		path.lineTo(width, 0);
		mPaint.setColor(normalColor);
		canvas.drawPath(path, mPaint);
		if(actionFoucs){
			if(operateStyle >= 2){
				Path focusPath = new Path();
				mPaint.setColor(focusColor);
				if(x >= width / 2){
					focusPath.moveTo(width / 2, 0);
					focusPath.lineTo(width, 0);
					focusPath.lineTo(width, height - trangleH);
					focusPath.lineTo((width + trangleH) / 2, height - trangleH);
					focusPath.lineTo(width / 2, height);
					focusPath.lineTo(width / 2, 0);
					focusPath.lineTo(width, 0);
				}else{
					focusPath.moveTo(0, 0);
					focusPath.lineTo(width / 2, 0);
					focusPath.lineTo(width / 2, height);
					focusPath.lineTo((width - trangleH) / 2, height - trangleH);
					focusPath.lineTo(0, height - trangleH);
					focusPath.lineTo(0, 0);
					focusPath.lineTo(width / 2, 0);
				}
				canvas.drawPath(focusPath, mPaint);
			}else{
				mPaint.setColor(focusColor);
				canvas.drawPath(path, mPaint);
			}
		}
		if(operateStyle >= 2){
			Path devidePath = new Path();
			devidePath.moveTo(width / 2, 0);
			devidePath.lineTo(width / 2, height - 6);
			canvas.drawPath(devidePath, devidePaint);
		}
	}

	public void setOperateStyle(int operateStyle) {
		if(this.operateStyle != operateStyle){
			postInvalidate();
		}
		this.operateStyle = operateStyle;
	}

	/**
	 * 计算宽高
	 */
	private void caculateWh() {
		int textWidth = 0;
		if(operateStyle == 0){
			textWidth = (int) mTextPaint.measureText(COPYTEXT, 0, COPYTEXT.length());
			width = textWidth + paddingL * 2 + devideWidth;
		}else if(operateStyle == 1){
			textWidth = (int) mTextPaint.measureText(DELETETEXT, 0, DELETETEXT.length());
			width = textWidth + paddingL * 2 + devideWidth;
		}else{
			textWidth = (int) mTextPaint.measureText(COPYT_ANDDELE_TEEXT, 0, COPYT_ANDDELE_TEEXT.length());
			width = textWidth + paddingL * 4 + devideWidth;
		}
		Rect bounds = new Rect();
		mTextPaint.getTextBounds(COPYT_ANDDELE_TEEXT, 0, COPYT_ANDDELE_TEEXT.length(), bounds);
		int textHeight = 0;
		textHeight = bounds.height();
		height = textHeight + paddingL * 2 + trangleH;
	}
	private int x;
	private int y;
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			if(!actionFoucs){
				actionFoucs = true;
				x = (int) event.getX();
				y = (int) event.getY();
				postInvalidate();
			}
			break;
		case MotionEvent.ACTION_MOVE:
			x = (int) event.getX();
			y = (int) event.getY();
			if(x < 0 || y <0){
				Log.d(TAG, "out offset side");
				actionFoucs = false;
				postInvalidate();
			}
			break;
		case MotionEvent.ACTION_CANCEL:
		case MotionEvent.ACTION_UP:
			actionFoucs = false;
			postInvalidate();
			if(x >= 0 && y >= 0){
				if(messageHandler != null){
					if(operateStyle == 0){
						messageHandler.onHandleMessage(0);
					}else if(operateStyle == 1){
						messageHandler.onHandleMessage(1);
					}else{
						if(x > width / 2){
							messageHandler.onHandleMessage(1);
						}else{
							messageHandler.onHandleMessage(0);
						}
					}
				}
			}
			break;
		default:
			break;
		}
		return true;
	}
	
	public int[] getWidthAndHeight(){
		caculateWh();
		int[] wh = new int[2];
		wh[0] = width;
		wh[1] = height;
		return wh;
	}
	public interface OnMessageHandler{
		void onHandleMessage(int type);
	}
}
