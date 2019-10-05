package com.shape;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.View;

import androidx.core.view.ViewCompat;

public class ShapeBuilder{
    private static final int RECTANGLE = 0;
    private static final int OVAL = 1;
    private static final int LINE = 2;
    private static final int RING = 3;
    private static final int TOP_BOTTOM = 0;
    private static final int TR_BL = 1;
    private static final int RIGHT_LEFT = 2;
    private static final int BR_TL = 3;
    private static final int BOTTOM_TOP = 4;
    private static final int BL_TR = 5;
    private static final int LEFT_RIGHT = 6;
    private static final int TL_BR = 7;
    private static final int LINEAR = 0;
    private static final int RADIAL = 1;
    private static final int SWEEP = 2;


    /**
     * android:shape=["rectangle" | "oval" | "line" | "ring"]
     */
    private int shapeType = -1;

    /**
     * <solid android:color="color"></solid>
     */
    private int solidColor = -1;

    /**
     * <stroke android:width="integer" android:color="color" android:dashWidth="integer" android:dashGap="integer"></stroke>
     */
    private int strokeWidth = -1;
    private int strokeColor = -1;
    private float strokeDashWidth = 0.0f;
    private float strokeDashGap = 0.0f;

    /**
     * <corners android:radius="integer" android:topLeftRadius="integer" android:topRightRadius="integer" android:bottomLeftRadius="integer" android:bottomRightRadius="integer"></corners>
     */
    private float cornersRadius = 0.0f;
    private float cornersTopLeftRadius = 0.0f;
    private float cornersTopRightRadius = 0.0f;
    private float cornersBottomLeftRadius = 0.0f;
    private float cornersBottomRightRadius = 0.0f;

    private int gradientAngle = -1;
    private int gradientCenterX= 0;
    private int gradientCenterY= 0;
    private int gradientGradientRadius = 0;

    private int gradientStartColor = -1;
    private int gradientCenterColor = -1;
    private int gradientEndColor = -1;

    private int gradientType = 0;

    private boolean  gradientUseLevel = false;

    /**
     * <size android:width="integer" android:height="integer"></size>
     */
    private int sizeWidth = -1;
    private int sizeHeight = -1;

    /**
     * <selector xmlns:android="http://schemas.android.com/apk/res/android" android:constantSize=["true" |></selector> "false"]
     * android:dither=["true" | "false"]
     * android:variablePadding=["true" | "false"] >
     * <item android:drawable="@[package:]drawable/drawable_resource" android:state_pressed=["true" |></item> "false"]
     * android:state_focused=["true" | "false"]
     * android:state_hovered=["true" | "false"]
     * android:state_selected=["true" | "false"]
     * android:state_checkable=["true" | "false"]
     * android:state_checked=["true" | "false"]
     * android:state_enabled=["true" | "false"]
     * android:state_activated=["true" | "false"]
     * android:state_window_focused=["true" | "false"] />
     *
     */
    private int selectorPressedColor = 0;
    private int selectorDisableColor= 0;
    private int selectorNormalColor= 0;

    private boolean useSelector = false;

    public ShapeBuilder setShapeType(int shapeType){
        this.shapeType=shapeType;
        return this;
    }


    public ShapeBuilder setShapeSolidColor(int color){
        this.solidColor=color;
        return this;
    }

    public ShapeBuilder setShapeCornersRadius(float radius){
        this.cornersRadius=radius;
        return this;
    }

    public ShapeBuilder setShapeCornersTopLeftRadius(float radius){
        this.cornersTopLeftRadius=radius;
        return this;
    }

    public ShapeBuilder setShapeCornersTopRightRadius(float radius){
        this.cornersTopRightRadius=radius;
        return this;
    }

    public ShapeBuilder setShapeCornersBottomRightRadius(float radius){
        this.cornersBottomRightRadius=radius;
        return this;
    }



    public ShapeBuilder setShapeCornersBottomLeftRadius(float radius){
        this.cornersBottomLeftRadius = radius;
        return this;
    }

    public ShapeBuilder setShapeStrokeWidth(int strokeWidth){
        this.strokeWidth = strokeWidth;
        return this;
    }

    public  ShapeBuilder setShapeStrokeColor(int strokeColor){
        this.strokeColor = strokeColor;
        return this;
    }

    public  ShapeBuilder setShapeStrokeDashWidth(float strokeDashWidth){
        this.strokeDashWidth = strokeDashWidth;
        return this;
    }

    public  ShapeBuilder setShapeStrokeDashGap(float strokeDashGap){
        this.strokeDashGap = strokeDashGap;
        return this;
    }

    public  ShapeBuilder setShapeUseSelector(boolean useSelector){
        this.useSelector = useSelector;
        return this;
    }

    public  ShapeBuilder setShapeSelectorPressedColor(int color){
        this.selectorPressedColor = color;
        return this;
    }

    public  ShapeBuilder setShapeSelectorNormalColor(int color){
        this.selectorNormalColor = color;
        return this;
    }

    public  ShapeBuilder setShapeSelectorDisableColor(int color){
        this.selectorDisableColor = color;
        return this;
    }

    public  ShapeBuilder setShapeSizeWidth(int sizeWidth){
        this.sizeWidth = sizeWidth;
        return this;
    }

    public  ShapeBuilder setShapeSizeHeight(int sizeHeight){
        this.sizeHeight = sizeHeight;
        return this;
    }

    public  ShapeBuilder setShapeGradientAngle(int gradientAngle){
        this.gradientAngle = gradientAngle;
        return this;
    }

    public  ShapeBuilder setShapeGradientCenterX(int gradientCenterX){
        this.gradientCenterX = gradientCenterX;
        return this;
    }

    public  ShapeBuilder setShapeGradientCenterY(int gradientCenterY){
        this.gradientCenterY = gradientCenterY;
        return this;
    }

    public  ShapeBuilder setShapeGradientGradientRadius(int gradientGradientRadius){
        this.gradientGradientRadius = gradientGradientRadius;
        return this;
    }

    public  ShapeBuilder setShapeGradientStartColor(int gradientStartColor){
        this.gradientStartColor = gradientStartColor;
        return this;
    }

    public  ShapeBuilder setShapeGradientCenterColor(int gradientCenterColor){
        this.gradientCenterColor = gradientCenterColor;
        return this;
    }

    public  ShapeBuilder setShapeGradientEndColor(int gradientEndColor){
        this.gradientEndColor = gradientEndColor;
        return this;
    }

    public  ShapeBuilder setShapeGradientType(int gradientType){
        this.gradientType = gradientType;
        return this;
    }

    public  ShapeBuilder setShapeGradientUseLevel(boolean gradientUseLevel){
        this.gradientUseLevel = gradientUseLevel;
        return this;
    }


    private  void setShapeType(GradientDrawable gradientDrawable) {
        if (shapeType != -1) {
            if(shapeType==RECTANGLE){
                gradientDrawable.setShape(GradientDrawable.RECTANGLE);
            }else if(shapeType==OVAL){
                gradientDrawable.setShape(GradientDrawable.OVAL);
            }else if(shapeType==LINE){
                gradientDrawable.setShape(GradientDrawable.LINE);
            }else if(shapeType==RING){
                gradientDrawable.setShape(GradientDrawable.RING);
            }
        }
    }


    private void  setSize(GradientDrawable gradientDrawable) {
        if (sizeWidth > 0 || sizeHeight > 0) {
            gradientDrawable.setSize(sizeWidth, sizeHeight);
        }
    }

    /**
     * 设置边框  宽度  颜色  虚线  间隙
     */
    private void setBorder(GradientDrawable gradientDrawable) {
        if (strokeWidth >= 0) {
            gradientDrawable.setStroke(strokeWidth, strokeColor, strokeDashWidth, strokeDashGap);
        }
    }

    /**
     * 只有类型是矩形的时候设置圆角半径才有效
     */
    private void setRadius(GradientDrawable gradientDrawable) {
        if (shapeType == RECTANGLE) {
            if (cornersRadius != 0f) {
                gradientDrawable.setCornerRadius(cornersRadius);
            } else {
                if (cornersTopLeftRadius != 0f || cornersTopRightRadius != 0f || cornersBottomRightRadius != 0f || cornersBottomLeftRadius != 0f) {
                    //1、2两个参数表示左上角，3、4表示右上角，5、6表示右下角，7、8表示左下角
                    gradientDrawable.setCornerRadii(new float[]{cornersTopLeftRadius, cornersTopLeftRadius, cornersTopRightRadius, cornersTopRightRadius, cornersBottomRightRadius, cornersBottomRightRadius, cornersBottomLeftRadius, cornersBottomLeftRadius});
                }
            }
        }
    }


    private void  setSolidColor(GradientDrawable gradientDrawable) {
        if (solidColor != -1 && gradientStartColor == -1 && gradientEndColor == -1) {
            gradientDrawable.setColor(solidColor);
        }
    }


    /**
     * 设置Selector的不同状态的颜色
     *
     * @param state 按钮状态
     */
    private void  setSelectorColor(GradientDrawable gradientDrawable, int state) {
        if (useSelector && state != 0) {
            if(state==android.R.attr.state_pressed){
                gradientDrawable.setColor(selectorPressedColor);
            }else if(state==-android.R.attr.state_enabled){
                gradientDrawable.setColor(selectorDisableColor);
            }else if(state==android.R.attr.state_enabled){
                gradientDrawable.setColor(selectorNormalColor);
            }
        }
    }


    /**
     * 设置背景颜色
     * 如果设定的有Orientation 就默认为是渐变色的Button，否则就是纯色的Button
     */
    private void  setGradient(GradientDrawable gradientDrawable) {
        if (gradientStartColor != -1 || gradientEndColor != -1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                if (gradientCenterColor == -1) {
                    gradientDrawable.setColors(new int[]{gradientStartColor, gradientEndColor});
                } else {
                    gradientDrawable.setColors(new int[]{gradientStartColor, gradientCenterColor, gradientEndColor});
                }
                if(gradientType==LINEAR){
                    gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                    if(gradientAngle != -1){
                        gradientDrawable.setOrientation(getGradientOrientationByAngle(gradientAngle));
                    }
                }
                switch(gradientType){
                    case LINEAR:
                        gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                        break;
                    case RADIAL:
                        gradientDrawable.setGradientType(GradientDrawable.RADIAL_GRADIENT);
                        gradientDrawable.setGradientRadius(gradientGradientRadius);
                        break;
                    case SWEEP:
                        gradientDrawable.setGradientType(GradientDrawable.SWEEP_GRADIENT);
                        break;
                }
                if (gradientCenterX != 0 || gradientCenterY != 0) {
                    gradientDrawable.setGradientCenter(gradientCenterX, gradientCenterY);
                }
                gradientDrawable.setUseLevel(gradientUseLevel);
            }
        }
    }


    /**
     * 设置颜色渐变类型
     *
     * @param gradientAngle gradientAngle
     * @return Orientation
     */
    private GradientDrawable.Orientation getGradientOrientationByAngle(int gradientAngle){
       GradientDrawable.Orientation orientation = null;
       switch (gradientAngle){
           case 0:
               orientation = GradientDrawable.Orientation.LEFT_RIGHT;
               break;
           case 45:
               orientation = GradientDrawable.Orientation.BL_TR;
               break;
           case 90:
               orientation = GradientDrawable.Orientation.BOTTOM_TOP;
               break;
           case 135:
               orientation = GradientDrawable.Orientation.BR_TL;
               break;
           case 180:
               orientation = GradientDrawable.Orientation.RIGHT_LEFT;
               break;
           case 225:
               orientation = GradientDrawable.Orientation.TR_BL;
               break;
           case 270:
               orientation = GradientDrawable.Orientation.TOP_BOTTOM;
               break;
           case 315:
               orientation = GradientDrawable.Orientation.TL_BR;
               break;

       }
        return orientation;
    }

    /**
     * 获取设置之后的Selector
     * 注意该处的顺序，只要有一个状态与之相配，背景就会被换掉 所以不要把大范围放在前面了，
     * 如果sd.addState(new[]{},normal)放在第一个的话，就没有什么效果了
     * @return stateListDrawable
     */
    private StateListDrawable selectorDrawable;

    public StateListDrawable getSelectorDrawable(){
        StateListDrawable stateListDrawable=new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled},getDrawable(android.R.attr.state_pressed));

        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled},getDrawable(-android.R.attr.state_enabled));
        stateListDrawable.addState(new int[]{}, getDrawable(android.R.attr.state_enabled));
        return stateListDrawable;

    }

    private GradientDrawable getDrawable(int state){
        GradientDrawable gradientDrawable =new  GradientDrawable();
        setShapeType(gradientDrawable);
        setGradient(gradientDrawable);
        setSolidColor(gradientDrawable);
        setBorder(gradientDrawable);
        setRadius(gradientDrawable);
        setSize(gradientDrawable);
        setSelectorColor(gradientDrawable, state);
        return gradientDrawable;
    }

    public void  into(View view){
        if(useSelector){
            ViewCompat.setBackground(view,getSelectorDrawable());
        }else{
            ViewCompat.setBackground(view,getDrawable(0));
        }
    }

    /**
     * 单位转换工具类
     *
     * @param context  上下文对象
     * @param dipValue 值
     * @return 返回值
     */
    private int dip2px(Context context,  float dipValue){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


}
