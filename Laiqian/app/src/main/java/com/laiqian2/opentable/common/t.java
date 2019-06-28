package com.laiqian.opentable.common;

import com.laiqian.network.i;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import java.util.ArrayList;
import org.json.JSONException;

public interface t {
  public static interface a {
    void d(i param1i) throws JSONException, m;
  }
  
  public static interface b {
    void a(PendingFullOrderDetail.c param1c, boolean param1Boolean);
  }
  
  public static interface c {
    void a(ArrayList<PendingFullOrderDetail> param1ArrayList, TableEntity param1TableEntity, boolean param1Boolean);
  }
  
  public static interface d {
    void T(ArrayList<a> param1ArrayList);
  }
  
  public static interface e {
    void d(boolean param1Boolean, String param1String) throws m;
  }
  
  public static interface f {
    void dp(boolean param1Boolean) throws m;
  }
  
  public static interface g {
    void a(PendingFullOrderDetail param1PendingFullOrderDetail, String param1String, int param1Int);
  }
  
  public static interface h {
    void a(ArrayList<PendingFullOrderDetail> param1ArrayList, String param1String, int param1Int);
  }
  
  public static interface i {
    void g(TableEntity param1TableEntity) throws m;
  }
  
  public static interface j {
    void U(ArrayList<TableEntity> param1ArrayList);
  }
  
  public static interface k {
    void a(boolean param1Boolean, TableEntity param1TableEntity1, TableEntity param1TableEntity2, int param1Int);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */