package com.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;

import com.cdc.okhttp.R;

public class AttributeSetHelper{
    private int defaultColor = 0x20000000;
    private int defaultSelectorColor = 0x20000000;

    public ShapeBuilder initShapeBuilderFromAttributeSet(Context context, AttributeSet attrs){
        if (attrs == null) return new ShapeBuilder();
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.ShapeView);

        int shapeType=typedArray.getInt(R.styleable.ShapeView_shapeType, GradientDrawable.RECTANGLE);

        int solidColor = typedArray.getColor(R.styleable.ShapeView_shapeSolidColor, defaultColor);

        int selectorPressedColor = typedArray.getColor(R.styleable.ShapeView_shapeSelectorPressedColor, defaultSelectorColor);

        int selectorDisableColor = typedArray.getColor(R.styleable.ShapeView_shapeSelectorDisableColor, defaultSelectorColor);

        int selectorNormalColor = typedArray.getColor(R.styleable.ShapeView_shapeSelectorNormalColor, defaultSelectorColor);

        float cornersRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeCornersRadius, 0);

        float cornersTopLeftRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeCornersTopLeftRadius, 0);


        float cornersTopRightRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeCornersTopRightRadius, 0);

        float cornersBottomLeftRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeCornersBottomLeftRadius, 0);

        float cornersBottomRightRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeCornersBottomRightRadius, 0);

        int strokeWidth = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeStrokeWidth, 0);

        float strokeDashWidth = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeStrokeDashWidth, 0);
        float strokeDashGap = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeStrokeDashGap, 0);

        int strokeColor = typedArray.getColor(R.styleable.ShapeView_shapeStrokeColor, defaultColor);

        int sizeWidth = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeSizeWidth, 0);
        int sizeHeight = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeSizeHeight, dip2px(context, 48f));

        int gradientAngle = (int) typedArray.getFloat(R.styleable.ShapeView_shapeGradientAngle, -1f);
        int gradientCenterX = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeGradientCenterX, 0);
        int gradientCenterY = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeGradientCenterY, 0);
        int gradientGradientRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeGradientGradientRadius, 0);

        int gradientStartColor = typedArray.getColor(R.styleable.ShapeView_shapeGradientStartColor, -1);
        int gradientCenterColor = typedArray.getColor(R.styleable.ShapeView_shapeGradientCenterColor, -1);
        int gradientEndColor = typedArray.getColor(R.styleable.ShapeView_shapeGradientEndColor, -1);

        int gradientType = typedArray.getInt(R.styleable.ShapeView_shapeGradientType, 0);
        boolean gradientUseLevel = typedArray.getBoolean(R.styleable.ShapeView_shapeGradientUseLevel, false);

        boolean useSelector = typedArray.getBoolean(R.styleable.ShapeView_shapeUseSelector, false);

        typedArray.recycle();

        ShapeBuilder shapeBuilder =new  ShapeBuilder();
        shapeBuilder
                .setShapeType(shapeType)
                .setShapeCornersRadius(cornersRadius)
                .setShapeCornersTopLeftRadius(cornersTopLeftRadius)
                .setShapeCornersTopRightRadius(cornersTopRightRadius)
                .setShapeCornersBottomRightRadius(cornersBottomRightRadius)
                .setShapeCornersBottomLeftRadius(cornersBottomLeftRadius)
                .setShapeSolidColor(solidColor)
                .setShapeStrokeColor(strokeColor)
                .setShapeStrokeWidth(strokeWidth)
                .setShapeStrokeDashWidth(strokeDashWidth)
                .setShapeStrokeDashGap(strokeDashGap)
                .setShapeUseSelector(useSelector)
                .setShapeSelectorNormalColor(selectorNormalColor)
                .setShapeSelectorPressedColor(selectorPressedColor)
                .setShapeSelectorDisableColor(selectorDisableColor)
                .setShapeSizeWidth(sizeWidth)
                .setShapeSizeHeight(sizeHeight)
                .setShapeGradientType(gradientType)
                .setShapeGradientAngle(gradientAngle)
                .setShapeGradientGradientRadius(gradientGradientRadius)
                .setShapeGradientUseLevel(gradientUseLevel)
                .setShapeGradientCenterX(gradientCenterX)
                .setShapeGradientCenterY(gradientCenterY)
                .setShapeGradientStartColor(gradientStartColor)
                .setShapeGradientCenterColor(gradientCenterColor)
                .setShapeGradientEndColor(gradientEndColor);

        return shapeBuilder;
    }

    /**
     * 单位转换工具类
     *
     * @param context  上下文对象
     * @param dipValue 值
     * @return 返回值
     */
    private int dip2px(Context context, float dipValue){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


}
