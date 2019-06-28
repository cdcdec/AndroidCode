package com.laiqian.version.b;

import android.content.Intent;
import android.view.View;

class c implements View.OnClickListener {
  c(b paramb) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(b.a(this.dJf), com.laiqian.version.view.ReplyActivity.class);
    intent.putExtra("version_id", b.b(this.dJf));
    b.a(this.dJf).startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */