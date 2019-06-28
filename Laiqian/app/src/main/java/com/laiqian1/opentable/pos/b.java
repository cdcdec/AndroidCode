package com.laiqian.opentable.pos;

import com.laiqian.main.bb;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import java.util.ArrayList;

public interface b {
  void a(TableEntity paramTableEntity, ArrayList<PendingFullOrderDetail> paramArrayList, boolean paramBoolean1, boolean paramBoolean2);
  
  void a(PendingFullOrderDetail paramPendingFullOrderDetail, TableEntity paramTableEntity, boolean paramBoolean1, boolean paramBoolean2);
  
  void a(PendingFullOrderDetail paramPendingFullOrderDetail, String paramString);
  
  void a(boolean paramBoolean1, int paramInt, a parama, TableEntity paramTableEntity, boolean paramBoolean2);
  
  void a(boolean paramBoolean1, bb parambb, boolean paramBoolean2, boolean paramBoolean3);
  
  void a(boolean paramBoolean1, TableEntity paramTableEntity, PendingFullOrderDetail.c paramc, PendingFullOrderDetail paramPendingFullOrderDetail, boolean paramBoolean2);
  
  void a(boolean paramBoolean1, a parama, TableEntity paramTableEntity1, TableEntity paramTableEntity2, int paramInt, boolean paramBoolean2);
  
  void dl(boolean paramBoolean);
  
  void fa(String paramString);
  
  void u(ArrayList<a> paramArrayList);
  
  void v(ArrayList<TableEntity> paramArrayList);
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\opentable\pos\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */