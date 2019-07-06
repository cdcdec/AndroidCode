package com.cdc.keyboard.ui.linearlayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.cdc.keyboard.R;

public class TvIvLinearLayout extends LinearLayout {

    private ImageView ivLeft;
    private ImageView ivRight;
    private TextView tvLeft;
    private TextView tvLeft2;
    private TextView tvLeft3;
    private RelativeLayout relRight;
    private Context context;

    /**
     * 在java代码里new的时候会用到
     *
     * @param context
     */
    public TvIvLinearLayout(Context context) {
        super(context);
        this.context = context;
        initView(context);

    }

    /**
     * 在xml布局文件中使用时自动调用
     *
     * @param context
     */
    public TvIvLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView(context);
        initAttrs(context, attrs);
    }

    /**
     * 不会自动调用，如果有默认style时，在第二个构造函数中调用
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public TvIvLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView(context);
        initAttrs(context, attrs);
    }

    /**
     * 只有在API版本>21时才会用到
     * 不会自动调用，如果有默认style时，在第二个构造函数中调用
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TvIvLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        initView(context);
        initAttrs(context, attrs);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.mainsetting_left_item, this, true);
        ivLeft = findViewById(R.id.ivLeft);
        ivRight = findViewById(R.id.ivRight);
        tvLeft = findViewById(R.id.tvLeft);
        tvLeft2 = findViewById(R.id.tvLeft2);
        tvLeft3 = findViewById(R.id.tvLeft3);
        relRight = findViewById(R.id.relRight);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.ivTvLin);
        //获取ivLeftSrc属性
        Drawable ivLeftDrawable=mTypedArray.getDrawable(R.styleable.ivTvLin_ivLeftSrc);
        ivLeft.setImageDrawable(ivLeftDrawable);

        //获取ivRightSrc属性
        Drawable ivRightDrawable = mTypedArray.getDrawable(R.styleable.ivTvLin_ivRightSrc);
        ivRight.setImageDrawable(ivRightDrawable);
        String tvLeftStr = mTypedArray.getString(R.styleable.ivTvLin_tvLeft);
        if (!TextUtils.isEmpty(tvLeftStr)) {
            tvLeft.setText(tvLeftStr);
        }
        mTypedArray.recycle();
    }


}
