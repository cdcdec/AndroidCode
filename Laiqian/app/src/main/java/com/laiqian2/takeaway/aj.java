package com.laiqian.takeaway;

import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.laiqian.entity.TakeOrderEntity;
import com.laiqian.entity.ap;
import com.laiqian.pos.model.a;
import com.laiqian.ui.a.r;
import com.laiqian.ui.k;
import com.laiqian.util.av;
import java.util.ArrayList;

class aj implements AdapterView.OnItemClickListener {
  aj(y paramy, TakeOrderEntity paramTakeOrderEntity, k paramk, ArrayList paramArrayList) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    a a = new a(y.b(this.dsf));
    String str;
    if (a.e((str = (new av(y.b(this.dsf))).Tx()).valueOf(((ap)y.g(this.dsf).get(paramInt)).getID()), str, false).Gm() || y.h(this.dsf)) {
      r r = new r(y.b(this.dsf), new ak(this, paramInt));
      r.setTitle(y.b(this.dsf).getString(R.string.new_pos_confirm_title));
      r.s(Html.fromHtml(y.b(this.dsf).getString(R.string.takeout_deliver_hint, new Object[] { this.dsk.get(paramInt) })));
      r.t(y.b(this.dsf).getString(R.string.pos_confirm));
      r.oZ(y.b(this.dsf).getString(R.string.pos_quit_save_hint_dialog_cancel));
      r.show();
      return;
    } 
    Toast.makeText(y.b(this.dsf), R.string.pos_no_permission, 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */