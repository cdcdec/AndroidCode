package com.laiqian.backup;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.laiqian.notification.PushService;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class BackUpSetting extends ActivityRoot {
  r.a aCA = new u(this);
  
  r aCz;
  
  View.OnClickListener aDd = new t(this);
  
  private LinearLayout aHC;
  
  private LinearLayout aHD;
  
  private LinearLayout aHE;
  
  private LinearLayout aHF;
  
  private LinearLayout aHG;
  
  private LinearLayout aHH;
  
  private CheckBox aHI;
  
  private CheckBox aHJ;
  
  private TextView aHK;
  
  private TextView aHL;
  
  private TextView aHM;
  
  private int aHN = 18;
  
  private int aHO = 0;
  
  private Spinner aHP;
  
  private Spinner aHQ;
  
  private a aHR;
  
  private int[] aHS = { 1, 2, 7, 15, 30, 90, 180, 365 };
  
  private String[] aHT = { "1", "2", "3", "5", "10", "15", "20" };
  
  String[] aHU;
  
  String aHV;
  
  View.OnClickListener aHW = new v(this);
  
  View.OnClickListener aHX = new w(this);
  
  View.OnClickListener aHY = new x(this);
  
  View.OnClickListener aHZ = new y(this);
  
  View.OnClickListener aIa = new q(this);
  
  View.OnClickListener azO = new s(this);
  
  private SimpleAdapter a(String[] paramArrayOfString, String paramString) {
    ArrayList arrayList = new ArrayList();
    for (byte b = 0; b < paramArrayOfString.length; b++) {
      HashMap hashMap = new HashMap();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramArrayOfString[b].toString());
      stringBuilder.append(paramString);
      hashMap.put("name", stringBuilder.toString());
      arrayList.add(hashMap);
    } 
    SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, 2131427762, new String[] { "name" }, new int[] { 2131298191 });
    simpleAdapter.setDropDownViewResource(2131427764);
    return simpleAdapter;
  }
  
  private void initData() {
    if ((new av(this)).atw()) {
      this.aHJ.setChecked(true);
      return;
    } 
    this.aHJ.setChecked(false);
  }
  
  private void promptBeforeQuit() {
    boolean bool = this.aHJ.isChecked();
    av av = new av(this);
    if (bool != av.atw()) {
      if (this.aCz == null) {
        this.aCz = new r(this, 2, this.aCA);
        this.aCz.setTitle(getString(2131628165));
        this.aCz.oZ(getString(2131628162));
        this.aCz.t(getString(2131628163));
        this.aCz.arm().setTextColor(getResources().getColor(2131099813));
        this.aCz.arn().setTextColor(getResources().getColor(2131099898));
        this.aCz.s(getString(2131628164));
      } 
      this.aCz.show();
    } else {
      finish();
    } 
    av.close();
  }
  
  private void yP() {
    this.aHC.setOnClickListener(this.aHW);
    this.aHE.setOnClickListener(this.aHX);
    this.aHF.setOnClickListener(this.aIa);
    this.aHH.setOnClickListener(this.aHZ);
    this.aHD.setOnClickListener(this.aHY);
    this.aHP.setAdapter(a(this.aHU, ""));
    this.aHP.setOnItemSelectedListener(new p(this));
    this.aHQ.setAdapter(a(this.aHT, this.aHV));
    this.aHQ.setOnItemSelectedListener(new r(this));
  }
  
  private void yR() {
    this.aHG = (LinearLayout)findViewById(2131298976);
    this.aHC = (LinearLayout)findViewById(2131296419);
    this.aHD = (LinearLayout)findViewById(2131296422);
    this.aHE = (LinearLayout)findViewById(2131296421);
    this.aHF = (LinearLayout)findViewById(2131296423);
    this.aHI = (CheckBox)findViewById(2131296418);
    this.aHJ = (CheckBox)findViewById(2131296417);
    this.aHH = (LinearLayout)findViewById(2131296420);
    this.aHK = (TextView)findViewById(2131296424);
    this.aHP = (Spinner)findViewById(2131296258);
    this.aHQ = (Spinner)findViewById(2131296260);
    this.aHL = (TextView)findViewById(2131296261);
    this.aHM = (TextView)findViewById(2131296259);
  }
  
  private void yU() {
    calendar = Calendar.getInstance();
    long l2 = calendar.get(11);
    long l3 = calendar.get(12);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
    long l1 = System.currentTimeMillis();
    try {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(calendar.get(1));
      stringBuilder1.append("-");
      stringBuilder1.append(calendar.get(2) + 1);
      stringBuilder1.append("-");
      stringBuilder1.append(calendar.get(5));
      stringBuilder1.append("-");
      stringBuilder1.append(this.aHK.getText().toString());
      long l = simpleDateFormat.parse(stringBuilder1.toString()).getTime();
      l1 = l;
    } catch (Exception calendar) {
      bb.e("ccc", calendar.toString());
    } 
    if (this.aHN <= l2 && (this.aHN != l2 || this.aHO <= l3))
      l1 += 86400000L; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(l1);
    stringBuilder.append("s");
    bb.e("BackUpAutoStamp", stringBuilder.toString());
    av av = new av(this);
    av.dq(l1);
    if (av.atw())
      PushService.r(this, 2); 
    av.close();
  }
  
  private void yV() {
    av av = new av(this);
    boolean bool = this.aHJ.isChecked();
    av.hm(bool);
    av.close();
    if (bool)
      PushService.r(this, 2); 
    Toast.makeText(getBaseContext(), 2131628397, 0).show();
    finish();
  }
  
  private void yW() {
    Integer integer;
    TextView textView = this.aHK;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.aHN);
    stringBuilder.append(":");
    if (this.aHO < 10) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("0");
      stringBuilder1.append(this.aHO);
      integer = stringBuilder1.toString();
    } else {
      integer = Integer.valueOf(this.aHO);
    } 
    stringBuilder.append(integer);
    textView.setText(stringBuilder);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427476);
    getWindow().setFeatureInt(7, 2131428168);
    findViewById(2131299878).setOnClickListener(this.azO);
    Button button = (Button)findViewById(2131299879);
    button.setVisibility(0);
    button.setOnClickListener(this.aDd);
    button.setText(2131629495);
    ((TextView)findViewById(2131299889)).setText(2131624342);
    this.aHU = getResources().getStringArray(2130903054);
    this.aHV = getString(2131624341);
    yR();
    initData();
    yP();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getRepeatCount() > 0)
      return false; 
    if (paramInt == 4 && paramKeyEvent.getRepeatCount() == 0) {
      promptBeforeQuit();
      return false;
    } 
    return false;
  }
  
  protected void onResume() {
    initData();
    super.onResume();
  }
  
  private class a implements TimePickerDialog.OnTimeSetListener {
    private a(BackUpSetting this$0) {}
    
    public void onTimeSet(TimePicker param1TimePicker, int param1Int1, int param1Int2) {
      BackUpSetting.a(this.aIb, param1Int1);
      BackUpSetting.b(this.aIb, param1Int2);
      BackUpSetting.o(this.aIb);
      BackUpSetting.c(this.aIb);
      av av = new av(this.aIb);
      av.lA(param1Int1);
      av.lB(param1Int2);
      av.close();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\BackUpSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */