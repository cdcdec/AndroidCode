package com.shape;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class ShapeLinearLayout extends LinearLayout{

    private ShapeBuilder shapeBuilder = new ShapeBuilder();
    public ShapeLinearLayout(Context context) {
        super(context);
        init(context, null);
    }

    public ShapeLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ShapeLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context,AttributeSet attrs) {
        shapeBuilder =new  AttributeSetHelper().initShapeBuilderFromAttributeSet(context, attrs);
        shapeBuilder.into(this);

    }
}
