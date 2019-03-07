package com.cdc.androidcode.ui.toolbar;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import com.cdc.androidcode.R;

import static androidx.appcompat.R.styleable;

public class TitleToolBar extends Toolbar implements View.OnClickListener{

    private LinearLayoutCompat mTitleLayout;
    private TextView mTitleTextView;
    private CharSequence mTitleText;
    private boolean mTitleVisible;

    private TextView mSubtitleTextView;
    private CharSequence mSubTitleText;
    private boolean mSubTitleVisible;

    private TextView mCloseTextView;
    private CharSequence mCloseText;
    private boolean mCloseVisible;

    private TextView mBackTextView;
    private CharSequence mBackText;
    private boolean mBackVisible;


    OnOptionItemClickListener mOnOptionItemClickListener;

    private static final int DEFAULT_BACK_MARGIN_RIGHT = 8;
    public TitleToolBar(Context context) {
        this(context, null);
    }

    public TitleToolBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initCustomView(context, attrs, defStyleAttr);
    }




    public boolean isChild(View view) {
        return view != null && view.getParent() == this;
    }

    public boolean isChild(View view, ViewParent parent) {
        return view != null && view.getParent() == parent;
    }

    public void setOnOptionItemClickListener(OnOptionItemClickListener listener) {
        mOnOptionItemClickListener = listener;
    }

    public interface OnOptionItemClickListener {
        void onOptionItemClick(View v);
    }

    public int dp2px(float dp) {
        return Math.round(dp * getResources().getDisplayMetrics().density);
    }
    private void initCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleToolbar);
        if (!isChild(mTitleLayout)){
            mTitleLayout = new LinearLayoutCompat(context);
            mTitleLayout.setOrientation(LinearLayoutCompat.VERTICAL);
            mTitleLayout.setGravity(typedArray.getInt(
                    R.styleable.TitleToolbar_title_gravity, Gravity.CENTER_VERTICAL));
            addView(mTitleLayout, new LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, Gravity.CENTER));
        }
        if (!isChild(mTitleTextView, mTitleLayout)) {
            mTitleTextView = new TextView(context);
            mTitleTextView.setSingleLine();
            mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
            mTitleTextView.setGravity(Gravity.CENTER);

            int titleTextAppearance = typedArray.getResourceId(styleable.Toolbar_titleTextAppearance, 0);
            if (titleTextAppearance != 0) {
                mTitleTextView.setTextAppearance(context, titleTextAppearance);
            }

            if (typedArray.hasValue(styleable.Toolbar_titleTextColor)) {
                int titleColor =typedArray.getColor(styleable.Toolbar_titleTextColor, Color.WHITE);
                mTitleTextView.setTextColor(titleColor);
            }

            if (typedArray.hasValue(R.styleable.TitleToolbar_titleTextSize)) {
                mTitleTextView.setTextSize(
                        typedArray.getDimensionPixelSize(R.styleable.TitleToolbar_backTextSize, 0));
            }

            setTitle(typedArray.getText(styleable.Toolbar_title));
            setTitleVisible(typedArray.getBoolean(R.styleable.TitleToolbar_titleVisible, true));

            mTitleLayout.addView(mTitleTextView,
                    new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        }

        if (!isChild(mSubtitleTextView, mTitleLayout)) {
            mSubtitleTextView = new TextView(context);
            mSubtitleTextView.setSingleLine();
            mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
            mSubtitleTextView.setGravity(Gravity.CENTER);

            int subTextAppearance = typedArray.getResourceId(styleable.Toolbar_subtitleTextAppearance, 0);
            if (subTextAppearance != 0) {
                mSubtitleTextView.setTextAppearance(context, subTextAppearance);
            }

            if (typedArray.hasValue(styleable.Toolbar_subtitleTextColor)) {
                int subTitleColor = typedArray.getColor(styleable.Toolbar_subtitleTextColor, Color.WHITE);
                mSubtitleTextView.setTextColor(subTitleColor);
            }

            if (typedArray.hasValue(R.styleable.TitleToolbar_subtitleTextSize)) {
                mSubtitleTextView.setTextSize(
                        typedArray.getDimensionPixelSize(
                                R.styleable.TitleToolbar_subtitleTextSize, 0));
            }

            setSubtitle(typedArray.getText(styleable.Toolbar_subtitle));
            setSubtitleVisible(
                    typedArray.getBoolean(R.styleable.TitleToolbar_subtitleVisible, false));

            mTitleLayout.addView(mSubtitleTextView,
                    new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        }

        if (!isChild(mBackTextView)) {
            mBackTextView = new TextView(context);
            mBackTextView.setId(R.id.back);
            mBackTextView.setSingleLine();
            mBackTextView.setEllipsize(TextUtils.TruncateAt.END);
            mBackTextView.setGravity(Gravity.CENTER_VERTICAL);

            int backTextAppearance =
                    typedArray.getResourceId(R.styleable.TitleToolbar_backTextAppearance, 0);
            if (backTextAppearance != 0) {
                mBackTextView.setTextAppearance(context, backTextAppearance);
            }

            if (typedArray.hasValue(R.styleable.TitleToolbar_backTextColor)) {
                int backTextColor =
                        typedArray.getColor(R.styleable.TitleToolbar_backTextColor, Color.WHITE);
                mBackTextView.setTextColor(backTextColor);
            }

            if (typedArray.hasValue(R.styleable.TitleToolbar_backTextSize)) {
                mBackTextView.setTextSize(
                        typedArray.getDimensionPixelSize(R.styleable.TitleToolbar_backTextSize, 0));
            }

            Drawable drawable = typedArray.getDrawable(R.styleable.TitleToolbar_backIcon);
            if (drawable != null) {
                mBackTextView.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
            }

            setBackText(typedArray.getText(R.styleable.TitleToolbar_backText));
            setBackVisible(typedArray.getBoolean(R.styleable.TitleToolbar_backVisible, false));

            mBackTextView.setClickable(true);
            mBackTextView.setOnClickListener(this);

            LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.MATCH_PARENT, Gravity.LEFT | Gravity.CENTER_VERTICAL);

            layoutParams.rightMargin = typedArray.getDimensionPixelSize(
                    R.styleable.TitleToolbar_backMarginRight, dp2px(DEFAULT_BACK_MARGIN_RIGHT));

            addView(mBackTextView, layoutParams);
        }

        if (!isChild(mCloseTextView)) {
            mCloseTextView = new TextView(context);
            mCloseTextView.setId(R.id.close);
            mCloseTextView.setSingleLine();
            mCloseTextView.setEllipsize(TextUtils.TruncateAt.END);
            mCloseTextView.setGravity(Gravity.CENTER_VERTICAL);

            int closeTextAppearance =
                    typedArray.getResourceId(R.styleable.TitleToolbar_closeTextAppearance, 0);

            if (closeTextAppearance != 0) {
                mCloseTextView.setTextAppearance(context, closeTextAppearance);
            }

            if (typedArray.hasValue(R.styleable.TitleToolbar_closeTextColor)) {
                int closeTextColor =
                        typedArray.getColor(R.styleable.TitleToolbar_closeTextColor, Color.WHITE);
                mCloseTextView.setTextColor(closeTextColor);
            }

            if (typedArray.hasValue(R.styleable.TitleToolbar_closeTextSize)) {
                mCloseTextView.setTextSize(
                        typedArray.getDimensionPixelSize(
                                R.styleable.TitleToolbar_closeTextSize, 0));
            }

            setCloseText(typedArray.getText(R.styleable.TitleToolbar_closeText));
            setCloseVisible(typedArray.getBoolean(R.styleable.TitleToolbar_closeVisible, false));

            mCloseTextView.setClickable(true);
            mCloseTextView.setOnClickListener(this);

            addView(mCloseTextView, new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.MATCH_PARENT, Gravity.LEFT | Gravity.CENTER_VERTICAL));
        }

        typedArray.recycle();
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitleText = title;
        if (mTitleTextView != null) {
            mTitleTextView.setText(title);
        }
    }

    @Override
    public CharSequence getTitle() {
        return mTitleText;
    }

    @Override
    public void setTitleTextAppearance(Context context, int resId) {
        if (mTitleTextView != null) {
            mTitleTextView.setTextAppearance(context, resId);
        }
    }

    @Override
    public void setTitleTextColor(int color) {
        if (mTitleTextView != null) {
            mTitleTextView.setTextColor(color);
        }
    }

    public void setTitleVisible(boolean visible) {
        mTitleVisible = visible;
        mTitleTextView.setVisibility(mTitleVisible ? VISIBLE : GONE);
    }

    public boolean getTitleVisible() {
        return mTitleVisible;
    }

    @Override
    public void setSubtitle(CharSequence subtitle) {
        mSubTitleText = subtitle;
        if (mSubtitleTextView != null) {
            mSubtitleTextView.setText(subtitle);
        }
    }

    @Override
    public CharSequence getSubtitle() {
        return mSubTitleText;
    }

    @Override
    public void setSubtitleTextAppearance(Context context, int resId) {
        if (mSubtitleTextView != null) {
            mSubtitleTextView.setTextAppearance(context, resId);
        }
    }

    @Override
    public void setSubtitleTextColor(int color) {
        if (mSubtitleTextView != null) {
            mSubtitleTextView.setTextColor(color);
        }
    }

    public void setSubtitleVisible(boolean visible) {
        mSubTitleVisible = visible;
        mSubtitleTextView.setVisibility(visible ? VISIBLE : GONE);
    }

    public boolean getSubtitleVisible() {
        return mSubTitleVisible;
    }

    public void setCloseText(int resId) {
        setCloseText(getContext().getText(resId));
    }

    public void setCloseText(CharSequence closeText) {
        mCloseText = closeText;
        if (mCloseTextView != null) {
            mCloseTextView.setText(closeText);
        }
    }

    public CharSequence getCloseText() {
        return mCloseText;
    }

    public void setCloseTextColor(int color) {
        mCloseTextView.setTextColor(color);
    }

    public void setCloseVisible(boolean visible) {
        mCloseVisible = visible;
        mCloseTextView.setVisibility(mCloseVisible ? VISIBLE : GONE);
    }

    public boolean isCloseVisible() {
        return mCloseVisible;
    }

    public void setBackText(int resId) {
        setBackText(getContext().getText(resId));
    }

    public void setBackText(CharSequence backText) {
        mBackText = backText;
        if (mBackTextView != null) {
            mBackTextView.setText(backText);
        }
    }

    public CharSequence getBackText() {
        return mBackText;
    }

    public void setBackTextColor(int color) {
        mBackTextView.setTextColor(color);
    }

    public void setBackVisible(boolean visible) {
        mBackVisible = visible;
        mBackTextView.setVisibility(mBackVisible ? VISIBLE : GONE);
    }

    public boolean isBackVisible() {
        return mBackVisible;
    }

    @Override
    public void onClick(View v) {
        if (mOnOptionItemClickListener != null) {
            mOnOptionItemClickListener.onOptionItemClick(v);
        }
    }
}
