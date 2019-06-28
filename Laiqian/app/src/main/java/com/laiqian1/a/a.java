package com.laiqian.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.f;
import com.laiqian.entity.a;
import com.laiqian.wallet.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
public final class a extends BaseQuickAdapter<a, f> {
  public a(@NotNull Context paramContext, @Nullable List<a> paramList) { super(R.layout.binding_item, paramList); }
  
  protected void a(@NotNull f paramf, @NotNull a parama) {
    f.m(paramf, "helper");
    f.m(parama, "item");
    paramf.a(R.id.tv_text1, (CharSequence)parama.Er());
    paramf.a(R.id.tv_text2, (CharSequence)parama.Es());
    paramf.a(R.id.tv_text3, (CharSequence)parama.Et());
    View view = paramf.dp(R.id.tv_text3);
    f.l(view, "helper.getView<TextView>(R.id.tv_text3)");
    ((TextView)view).setActivated(parama.Eu());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */