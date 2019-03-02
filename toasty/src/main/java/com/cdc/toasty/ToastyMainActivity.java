package com.cdc.toasty;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import toasty.Toasty;

import static android.graphics.Typeface.BOLD_ITALIC;

public class ToastyMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toasty_main);
        findViewById(R.id.button_error_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.error(ToastyMainActivity.this, R.string.error_message, Toasty.LENGTH_SHORT, true).show();
            }
        });
        findViewById(R.id.button_success_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.success(ToastyMainActivity.this, R.string.success_message, Toasty.LENGTH_SHORT, true).show();
            }
        });
        findViewById(R.id.button_info_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(ToastyMainActivity.this, R.string.info_message, Toasty.LENGTH_SHORT, true).show();
            }
        });
        findViewById(R.id.button_warning_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.warning(ToastyMainActivity.this, R.string.warning_message, Toasty.LENGTH_SHORT, true).show();
            }
        });
        findViewById(R.id.button_normal_toast_wo_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.normal(ToastyMainActivity.this, R.string.normal_message_without_icon).show();
            }
        });
        findViewById(R.id.button_normal_toast_w_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable icon = getResources().getDrawable(R.drawable.ic_pets_white_48dp);
                Toasty.normal(ToastyMainActivity.this, R.string.normal_message_with_icon, icon).show();
            }
        });
        findViewById(R.id.button_info_toast_with_formatting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(ToastyMainActivity.this, getFormattedMessage()).show();
            }
        });
        findViewById(R.id.button_custom_config).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.Config.getInstance()
                        //.setToastTypeface(Typeface.createFromAsset(getAssets(), "PCap Terminal.otf"))
                        .allowQueue(false)
                        .apply();
                Toasty.custom(ToastyMainActivity.this, R.string.custom_message, getResources().getDrawable(R.drawable.laptop512),
                        Color.BLACK, Color.GREEN, Toasty.LENGTH_SHORT, true, true).show();
                Toasty.Config.reset(); // Use this if you want to use the configuration above only once
            }
        });
    }

    private CharSequence getFormattedMessage() {
        final String prefix = "Formatted ";
        final String highlight = "bold italic";
        final String suffix = " text";
        SpannableStringBuilder ssb = new SpannableStringBuilder(prefix).append(highlight).append(suffix);
        int prefixLen = prefix.length();
        ssb.setSpan(new StyleSpan(BOLD_ITALIC),
                prefixLen, prefixLen + highlight.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }
}
