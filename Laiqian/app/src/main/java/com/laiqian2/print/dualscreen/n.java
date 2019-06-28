package com.laiqian.print.dualscreen;

import android.content.Context;
import android.widget.ImageView;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.a.d;
import com.laiqian.ui.s;
import com.squareup.a.ab;
import java.io.File;

public class n extends d {
  private ImageView csz = (ImageView)s.a(getWindow(), R.id.iv);
  
  public n(Context paramContext, File paramFile) {
    super(paramContext, R.layout.dialog_image);
    ab.cx(getContext()).K(paramFile).c(this.csz);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\dualscreen\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */