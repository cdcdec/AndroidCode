package com.laiqian.opentable.common.b;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;
import com.laiqian.opentable.R;
import com.laiqian.ui.a.r;

public class c extends r {
  public c(Context paramContext, Class<? extends Activity> paramClass) {
    super(paramContext, null);
    arm().setOnClickListener(new d(this, paramContext, paramClass));
    arn().setOnClickListener(new e(this, paramContext));
    SpannableStringBuilder spannableStringBuilder = (new SpannableStringBuilder()).append(paramContext.getString(R.string.pos_wifi_setting));
    spannableStringBuilder.setSpan(new ForegroundColorSpan(RootApplication.zw().getColor(R.color.pos_text_red)), 0, spannableStringBuilder.length(), 33);
    Spanned spanned = Html.fromHtml(paramContext.getString(R.string.open_table_network_is_error));
    setTitle(paramContext.getString(R.string.important_reminder));
    s(spanned);
    t(spannableStringBuilder.toString());
    oZ(paramContext.getString(R.string.switch_net_mode));
    aro().setVisibility(8);
    arm().setVisibility(0);
    arn().setVisibility(0);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */