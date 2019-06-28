package com.laiqian.auth;

import android.content.Intent;
import android.view.View;
import java.util.HashMap;

class br implements View.OnClickListener {
  br(UserManagement paramUserManagement) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(this.aGm, PrivilegeLimitActivity.class);
    long l = Long.parseLong((String)((HashMap)UserManagement.j(this.aGm).getTag()).get("_id"));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(l);
    intent.putExtra("staff_user_id", stringBuilder.toString());
    this.aGm.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */