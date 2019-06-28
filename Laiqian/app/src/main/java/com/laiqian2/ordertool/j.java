package com.laiqian.ordertool;

import android.database.Cursor;
import android.view.View;
import com.laiqian.pos.model.a;

class j implements View.OnClickListener {
  j(ServerTest paramServerTest) {}
  
  public void onClick(View paramView) {
    a a = new a(this.cdO);
    String str = ServerGet.getTableNoForTest();
    Cursor cursor = a.kq(str);
    StringBuffer stringBuffer = new StringBuffer();
    while (cursor.moveToNext()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("桌号:");
      stringBuilder.append(cursor.getString(cursor.getColumnIndex("nPhysicalInventoryID")));
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(",订单号:");
      stringBuilder.append(cursor.getString(cursor.getColumnIndex("sOrderNo")));
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(",商品ID:");
      stringBuilder.append(cursor.getString(cursor.getColumnIndex("nProductID")));
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(",商品名:");
      stringBuilder.append(cursor.getString(cursor.getColumnIndex("sProductName")));
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(",数量:");
      stringBuilder.append(cursor.getString(cursor.getColumnIndex("nProductQty")));
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(",价格:");
      stringBuilder.append(cursor.getString(cursor.getColumnIndex("fPrice")));
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(",金额:");
      stringBuilder.append(cursor.getString(cursor.getColumnIndex("fAmount")));
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(",sIsActive:");
      stringBuilder.append(cursor.getString(cursor.getColumnIndex("sIsActive")));
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(",nShopID:");
      stringBuilder.append(cursor.getString(cursor.getColumnIndex("nShopID")));
      stringBuffer.append(stringBuilder.toString());
      stringBuffer.append("\n");
    } 
    cursor.close();
    a.close();
    if (stringBuffer == null || stringBuffer.equals("")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("未查询到桌号为");
      stringBuilder.append(str);
      stringBuilder.append(" 的订单");
      stringBuffer.append(stringBuilder.toString());
    } 
    this.cdO.cdH.setText(stringBuffer.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */