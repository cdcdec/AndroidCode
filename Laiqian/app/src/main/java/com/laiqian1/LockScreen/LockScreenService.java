package com.laiqian.LockScreen;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.util.av;
import com.laiqian.util.bb;

public class LockScreenService extends Service {
  TextView aAa;
  
  Button aAb;
  
  Button aAc;
  
  Button aAd;
  
  Button aAe;
  
  Button aAf = null;
  
  Button aAg = null;
  
  Button aAh = null;
  
  Button aAi = null;
  
  Button aAj = null;
  
  Button aAk = null;
  
  Button aAl = null;
  
  Button aAm = null;
  
  Button aAn = null;
  
  Button aAo = null;
  
  LinearLayout azS;
  
  LinearLayout azT;
  
  LinearLayout azU;
  
  WindowManager.LayoutParams azV;
  
  EditText azW;
  
  EditText azX;
  
  EditText azY;
  
  TextView azZ;
  
  WindowManager mWindowManager;
  
  private void xc() {
    this.azV = new WindowManager.LayoutParams();
    Application application = getApplication();
    getApplication();
    this.mWindowManager = (WindowManager)application.getSystemService("window");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mWindowManager--->");
    stringBuilder.append(this.mWindowManager);
    bb.f("FxService", stringBuilder.toString());
    this.azV.type = 2002;
    this.azV.format = 1;
    this.azV.flags = 524288;
    this.azV.gravity = 17;
    this.azV.x = 0;
    this.azV.y = 0;
    this.azV.width = -1;
    this.azV.height = -1;
    this.azS = (LinearLayout)LayoutInflater.from(getApplication()).inflate(2131427738, null);
    this.mWindowManager.addView(this.azS, this.azV);
    this.azW = (EditText)this.azS.findViewById(2131298063);
    this.azZ = (TextView)this.azS.findViewById(2131298065);
    this.aAb = (Button)this.azS.findViewById(2131296557);
    this.aAc = (Button)this.azS.findViewById(2131296559);
    this.aAd = (Button)this.azS.findViewById(2131297059);
    this.aAe = (Button)this.azS.findViewById(2131297060);
    this.aAa = (TextView)this.azS.findViewById(2131298064);
    this.azT = (LinearLayout)this.azS.findViewById(2131298975);
    this.azU = (LinearLayout)this.azS.findViewById(2131298981);
    av av = new av(this);
    this.azX = (EditText)this.azS.findViewById(2131297062);
    this.azY = (EditText)this.azS.findViewById(2131297061);
    this.azX.setText(av.Ea());
    av.close();
    this.aAa.setOnClickListener(new d(this));
    this.aAd.setOnClickListener(new e(this));
    this.aAe.setOnClickListener(new f(this));
    g g = new g(this);
    this.aAf = (Button)this.azS.findViewById(2131296583);
    this.aAf.setTag("7");
    this.aAg = (Button)this.azS.findViewById(2131296584);
    this.aAg.setTag("8");
    this.aAh = (Button)this.azS.findViewById(2131296585);
    this.aAh.setTag("9");
    this.aAi = (Button)this.azS.findViewById(2131296579);
    this.aAi.setTag("4");
    this.aAj = (Button)this.azS.findViewById(2131296580);
    this.aAj.setTag("5");
    this.aAk = (Button)this.azS.findViewById(2131296582);
    this.aAk.setTag("6");
    this.aAl = (Button)this.azS.findViewById(2131296573);
    this.aAl.setTag("1");
    this.aAm = (Button)this.azS.findViewById(2131296576);
    this.aAm.setTag("2");
    this.aAn = (Button)this.azS.findViewById(2131296578);
    this.aAn.setTag("3");
    this.aAo = (Button)this.azS.findViewById(2131296572);
    this.aAo.setTag("0");
    this.aAh.setOnClickListener(g);
    this.aAg.setOnClickListener(g);
    this.aAf.setOnClickListener(g);
    this.aAk.setOnClickListener(g);
    this.aAj.setOnClickListener(g);
    this.aAi.setOnClickListener(g);
    this.aAn.setOnClickListener(g);
    this.aAm.setOnClickListener(g);
    this.aAl.setOnClickListener(g);
    this.aAo.setOnClickListener(g);
    this.aAc.setOnClickListener(new h(this));
    this.aAb.setOnClickListener(new i(this));
    this.azW.addTextChangedListener(new j(this));
    this.azS.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  public IBinder onBind(Intent paramIntent) { return null; }
  
  public void onCreate() {
    super.onCreate();
    bb.f("FxService", "oncreat");
    xc();
  }
  
  public void onDestroy() {
    super.onDestroy();
    if (this.azS != null)
      this.mWindowManager.removeView(this.azS); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\LockScreen\LockScreenService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */