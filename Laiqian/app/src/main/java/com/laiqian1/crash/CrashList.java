package com.laiqian.crash;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.util.z;
import com.laiqian.warehouse.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CrashList extends Activity {
  private ListView aMB;
  
  private List<HashMap<String, String>> aMC = new ArrayList();
  
  private a aMD;
  
  View.OnClickListener aME = new c(this);
  
  private View azH;
  
  private Button azI;
  
  private TextView azJ;
  
  View.OnClickListener azO = new b(this);
  
  private void CE() {
    this.azJ.setText(getResources().getString(2131625585));
    SQLiteDatabase sQLiteDatabase = openOrCreateDatabase("crash.db", 0, null);
    try {
      Cursor cursor1 = sQLiteDatabase.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = 'crashlist'", null);
      if (cursor1 != null) {
        if (cursor1.getCount() == 0) {
          cursor1.close();
          Toast.makeText(this, "暂无异常", 0).show();
          return;
        } 
        cursor1.close();
      } 
    } catch (Exception exception) {}
    Cursor cursor = sQLiteDatabase.query("crashlist", null, null, null, null, null, "_id desc");
    if (cursor.getCount() > 0) {
      while (cursor.moveToNext()) {
        HashMap hashMap = new HashMap();
        a a1 = new a(this);
        String str = a1.dI(Long.parseLong(cursor.getString(3)));
        a1.close();
        hashMap.put("e_shopid", str);
        hashMap.put("e_crashtime", cursor.getString(5));
        hashMap.put("e_isupload", cursor.getString(4));
        hashMap.put("e_savepath", cursor.getString(2));
        hashMap.put("e_id", cursor.getString(0));
        hashMap.put("e_userphone", cursor.getString(1));
        this.aMC.add(hashMap);
      } 
      CF();
    } else {
      Toast.makeText(this, "暂无异常", 0).show();
    } 
    cursor.close();
    sQLiteDatabase.close();
  }
  
  private void CF() {
    this.aMB = (ListView)findViewById(2131298196);
    this.aMD = new a(this, this, this.aMC);
    this.aMB.setAdapter(this.aMD);
    this.aMD.notifyDataSetChanged();
  }
  
  private void wZ() {
    this.azH = findViewById(2131299878);
    this.azH.setFocusableInTouchMode(true);
    this.azJ = (TextView)findViewById(2131299889);
    this.azI = (Button)findViewById(2131299879);
    this.azI.setVisibility(8);
  }
  
  private void xa() {
    this.azH.setOnClickListener(this.azO);
    this.azI.setOnClickListener(this.aME);
  }
  
  private void xb() { CE(); }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427505);
    getWindow().setFeatureInt(7, 2131428168);
    wZ();
    xa();
    xb();
  }
  
  public class a extends BaseAdapter {
    private List<HashMap<String, String>> aMG;
    
    private Context context;
    
    public a(CrashList this$0, Context param1Context, List<HashMap<String, String>> param1List) {
      this.context = param1Context;
      this.aMG = param1List;
    }
    
    public int getCount() { return this.aMG.size(); }
    
    public Object getItem(int param1Int) { return null; }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      String str;
      a a1 = new a(this);
      if (param1View == null) {
        param1View = LayoutInflater.from(this.context).inflate(2131427506, null);
        a1.aML = (TextView)param1View.findViewById(2131296916);
        a1.aMM = (TextView)param1View.findViewById(2131296903);
        a1.aMN = (TextView)param1View.findViewById(2131296906);
        a1.aMO = (TextView)param1View.findViewById(2131296914);
        a1.aMP = (TextView)param1View.findViewById(2131296920);
        a1.aMR = (LinearLayout)param1View.findViewById(2131296907);
        a1.aMQ = (TextView)param1View.findViewById(2131296919);
        param1View.setTag(a1);
      } else {
        a1 = (a)param1View.getTag();
      } 
      TextView textView2 = a1.aMQ;
      a1.aML.setText((CharSequence)((HashMap)this.aMG.get(param1Int)).get("e_shopid"));
      a1.aMM.setText(z.pB((String)((HashMap)this.aMG.get(param1Int)).get("e_crashtime")));
      if (((String)((HashMap)this.aMG.get(param1Int)).get("e_isupload")).equals("1")) {
        str = this.context.getResources().getString(2131624891);
        a1.aMQ.setVisibility(8);
      } else {
        str = this.context.getResources().getString(2131624890);
        a1.aMQ.setVisibility(0);
        a1.aMQ.setOnClickListener(new d(this, textView2, param1Int));
      } 
      a1.aMN.setText(str);
      TextView textView1 = a1.aMO;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("错误日志");
      stringBuilder.append((String)((HashMap)this.aMG.get(param1Int)).get("e_id"));
      textView1.setText(stringBuilder.toString());
      a1.aMP.setText((CharSequence)((HashMap)this.aMG.get(param1Int)).get("e_userphone"));
      return param1View;
    }
    
    public class a {
      TextView aML;
      
      TextView aMM;
      
      TextView aMN;
      
      TextView aMO;
      
      TextView aMP;
      
      TextView aMQ;
      
      LinearLayout aMR;
      
      public a(CrashList.a this$0) {}
    }
  }
  
  public class a {
    TextView aML;
    
    TextView aMM;
    
    TextView aMN;
    
    TextView aMO;
    
    TextView aMP;
    
    TextView aMQ;
    
    LinearLayout aMR;
    
    public a(CrashList this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\crash\CrashList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */