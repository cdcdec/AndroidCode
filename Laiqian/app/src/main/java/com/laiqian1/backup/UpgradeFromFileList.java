package com.laiqian.backup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.util.am;
import com.laiqian.util.av;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UpgradeFromFileList extends Activity {
  private static String aHf;
  
  private static String[] aIE;
  
  View.OnClickListener aDd = new al(this);
  
  private SimpleAdapter aIF;
  
  private List<HashMap<String, Object>> aIG;
  
  private String aIH = "apk";
  
  private String aII;
  
  AdapterView.OnItemClickListener aIJ = new aj(this);
  
  View.OnClickListener azO = new ak(this);
  
  static  {
  
  }
  
  private boolean bB(String paramString) {
    aIE = am.bk(paramString, this.aIH);
    return !(aIE == null);
  }
  
  private List<HashMap<String, Object>> zc() {
    ArrayList arrayList = new ArrayList();
    for (byte b = 0; b < aIE.length; b++) {
      HashMap hashMap = new HashMap();
      hashMap.put("title", aIE[b]);
      hashMap.put("icon", Integer.valueOf(2131231736));
      arrayList.add(hashMap);
    } 
    return arrayList;
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427475);
    getWindow().setFeatureInt(7, 2131428168);
    ((Button)findViewById(2131299879)).setVisibility(8);
    av av = new av(this);
    this.aII = av.atZ();
    av.close();
    if (bB(this.aII)) {
      this.aIG = zc();
      this.aIF = new SimpleAdapter(this, this.aIG, 2131428122, new String[] { "title", "icon" }, new int[] { 2131299897, 2131299894 });
      ListView listView = (ListView)findViewById(2131296429);
      listView.setAdapter(this.aIF);
      listView.setOnItemClickListener(this.aIJ);
      findViewById(2131299878).setOnClickListener(this.azO);
      ((Button)findViewById(2131299879)).setOnClickListener(this.aDd);
      ((TextView)findViewById(2131299889)).setText(2131624359);
      ((LinearLayout)findViewById(2131296427)).setVisibility(0);
      return;
    } 
    Toast.makeText(this, getString(2131624393), 1).show();
    finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\UpgradeFromFileList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */