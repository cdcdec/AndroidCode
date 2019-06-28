package com.laiqian.pos.industry.weiorder;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.entity.aw;
import com.laiqian.models.an;
import com.laiqian.pos.dw;
import com.laiqian.pos.hardware.q;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.ui.a.ab;
import com.laiqian.util.am;
import com.laiqian.util.av;
import com.laiqian.util.ba;
import com.laiqian.util.bk;
import hugo.weaving.DebugLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class WeiOrderSettingFragment extends Fragment {
  public static final String cuH;
  
  private static final String cuI;
  
  public static final String cuJ;
  
  ba aNJ;
  
  private final int cgS;
  
  private final int cgT;
  
  private final boolean chl;
  
  a cuK;
  
  e cuL;
  
  String cuM;
  
  String cuN;
  
  ab cuO;
  
  static  {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckS);
    stringBuilder.append("introduction/introduction");
    cuH = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckS);
    stringBuilder.append("introduction/binding?shopid=");
    cuI = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckS);
    stringBuilder.append("introduction/apply");
    cuJ = stringBuilder.toString();
  }
  
  public WeiOrderSettingFragment() {
    if (Build.VERSION.SDK_INT >= 19) {
      bool = true;
    } else {
      bool = false;
    } 
    this.chl = bool;
    this.cgS = 21;
    this.cgT = 22;
    this.aNJ = new ba(true);
    this.cuO = null;
  }
  
  private void a(e parame) {
    if (parame.ctH.Jq()) {
      b(parame);
      return;
    } 
    abG();
  }
  
  private boolean a(Uri paramUri, String paramString) {
    String str;
    if (this.chl && DocumentsContract.isDocumentUri(getActivity(), paramUri)) {
      str = am.b(getActivity(), paramUri);
    } else {
      str = am.c(getActivity(), str);
    } 
    return (str != null && (new File(str)).exists()) ? am.B(str, paramString) : 0;
  }
  
  private void abD() {
    if (this.chl)
      try {
        Intent intent1 = new Intent("android.intent.action.GET_CONTENT");
        intent1.addCategory("android.intent.category.OPENABLE");
        intent1.setType("image/*");
        if (intent1.resolveActivity(getActivity().getPackageManager()) != null) {
          startActivityForResult(intent1, 21);
          return;
        } 
        Toast.makeText(getActivity(), "没有找到app", 0).show();
        return;
      } catch (Exception exception) {
        return;
      }  
    Intent intent = new Intent("android.intent.action.PICK");
    intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
      startActivityForResult(intent, 21);
      return;
    } 
    Toast.makeText(getActivity(), "没有找到app", 0).show();
  }
  
  private e abF() {
    aw aw = fp.aX(getActivity()).abV();
    an.c c = (new an(getActivity())).Vu();
    int i = a.bo(getActivity()).aiL().aiw();
    boolean bool = true;
    if (i != 1)
      bool = false; 
    return new e(aw, c, bool);
  }
  
  private void abG() {
    this.cuK.cuS.setChecked(false);
    this.cuK.cuV.setVisibility(0);
    this.cuK.cuU.setVisibility(8);
    this.cuK.cvk.setVisibility(0);
  }
  
  private void ax(String paramString1, String paramString2) { (new b(this, null)).execute(new String[] { paramString1, paramString2 }); }
  
  private void b(e parame) {
    this.cuK.cuS.setChecked(true);
    this.cuK.cuV.setVisibility(4);
    this.cuK.cuU.setVisibility(0);
    this.cuK.cvk.setVisibility(8);
    this.cuK.cuY.setText(parame.cvm.aVs);
    this.cuK.cuZ.setText(parame.cvm.aWU);
    this.cuK.cva.setText(parame.cvm.aWV);
    c(parame);
    this.cuK.cum.setChecked(parame.cub);
  }
  
  private void c(e parame) {
    switch (parame.ctH.Jr()) {
      default:
        return;
      case 2:
        this.cuK.cve.setVisibility(8);
        this.cuK.cvg.setVisibility(0);
        this.cuK.cvc.setText(getString(2131628611));
        ax(parame.ctH.getUrl(), dw.aR(getActivity()));
        return;
      case 1:
        break;
    } 
    this.cuK.cve.setVisibility(0);
    this.cuK.cvg.setVisibility(8);
    this.cuK.cvc.setText(getString(2131628612));
    if (TextUtils.isEmpty(this.cuL.ctH.getUrl())) {
      (new c(this, null)).execute(new Void[0]);
      return;
    } 
    ax(parame.ctH.getUrl(), dw.aR(getActivity()));
  }
  
  private Bitmap getBitmap(String paramString) {
    if (paramString == null)
      return null; 
    file = new File(paramString);
    if (!file.exists())
      return null; 
    try {
      Throwable throwable;
      fileInputStream = new FileInputStream(file);
      try {
        return BitmapFactory.decodeStream(fileInputStream);
      } catch (Throwable null) {
        try {
          throw throwable;
        } finally {}
      } finally {
        file = null;
      } 
      if (fileInputStream != null)
        if (throwable != null) {
          try {
            fileInputStream.close();
          } catch (Throwable fileInputStream) {
            a.a(throwable, fileInputStream);
          } 
        } else {
          fileInputStream.close();
        }  
      throw file;
    } catch (IOException file) {
      return null;
    } 
  }
  
  private void jM(String paramString) {
    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
    intent.putExtra("output", Uri.fromFile(new File(paramString)));
    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
      startActivityForResult(intent, 22);
      return;
    } 
    Toast.makeText(getActivity(), "没有找到拍照app", 0).show();
  }
  
  private void jN(String paramString) {
    Intent intent = new Intent();
    intent.setClass(getActivity(), com.laiqian.ui.cropper.CropImageActivity.class);
    intent.putExtra("PHOTO_CROP_SAVEPATH", paramString);
    startActivityForResult(intent, 13);
  }
  
  public static String jO(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(cuI);
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  private void jP(String paramString) { (new d(this, null)).execute(new String[] { paramString }); }
  
  private void setListeners() {
    this.cuK.cuW.setOnClickListener(new cs(this));
    this.cuK.cuS.setOnCheckedChangeListener(new cw(this));
    this.cuK.cuT.setOnClickListener(new cx(this));
    this.cuK.cvb.setOnClickListener(new cy(this));
    this.cuK.cvd.setOnClickListener(new da(this));
    this.cuK.cum.setOnCheckedChangeListener(new db(this));
    this.cuK.cvh.setOnClickListener(new dc(this));
    this.cuK.cuY.addTextChangedListener(new dd(this));
    this.cuK.cuZ.addTextChangedListener(new de(this));
    this.cuK.cva.addTextChangedListener(new ct(this));
    this.cuK.cvi.setOnClickListener(new cu(this));
  }
  
  void abE() {
    this.cuL = abF();
    a(this.cuL);
  }
  
  @DebugLog
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1 && (paramIntent == null || paramInt2 == 0))
      return; 
    if (paramInt1 != 13) {
      switch (paramInt1) {
        default:
          return;
        case 22:
          jN(this.cuN);
          return;
        case 21:
          break;
      } 
      if (a(paramIntent.getData(), this.cuN)) {
        jN(this.cuN);
        return;
      } 
    } else if (paramIntent != null && paramIntent.getBooleanExtra("PHOTO_CROP_RESULT", false)) {
      jP(this.cuN);
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(2131428208, null);
    this.cuK = new a(view);
    this.cuM = dw.aR(getActivity());
    this.cuN = dw.aT(getActivity());
    abE();
    setListeners();
    this.cuK.cvb.setClickable(false);
    return view;
  }
  
  public void onResume() { super.onResume(); }
  
  public static class a {
    public ImageView aZa;
    
    public CheckBox cuS;
    
    public ViewGroup cuT;
    
    public ViewGroup cuU;
    
    public ViewGroup cuV;
    
    public ViewGroup cuW;
    
    public TextView cuX;
    
    public EditText cuY;
    
    public EditText cuZ;
    
    public CheckBox cum;
    
    public EditText cva;
    
    public ViewGroup cvb;
    
    public TextView cvc;
    
    public ViewGroup cvd;
    
    public ViewGroup cve;
    
    public ImageView cvf;
    
    public ViewGroup cvg;
    
    public ViewGroup cvh;
    
    public ViewGroup cvi;
    
    public ImageView cvj;
    
    public ViewGroup cvk;
    
    public a(View param1View) {
      this.cuS = (CheckBox)param1View.findViewById(2131296721);
      this.cuV = (ViewGroup)param1View.findViewById(2131297710);
      this.cuT = (ViewGroup)param1View.findViewById(2131297733);
      this.cuU = (ViewGroup)param1View.findViewById(2131297732);
      this.cum = (CheckBox)param1View.findViewById(2131296704);
      this.cuW = (ViewGroup)param1View.findViewById(2131297650);
      this.aZa = (ImageView)param1View.findViewById(2131297399);
      this.cuX = (TextView)param1View.findViewById(2131299667);
      this.cuY = (EditText)param1View.findViewById(2131297017);
      this.cuZ = (EditText)param1View.findViewById(2131297016);
      this.cva = (EditText)param1View.findViewById(2131297015);
      this.cvb = (ViewGroup)param1View.findViewById(2131297724);
      this.cvc = (TextView)param1View.findViewById(2131299818);
      this.cvd = (ViewGroup)param1View.findViewById(2131297511);
      this.cve = (ViewGroup)param1View.findViewById(2131297649);
      this.cvf = (ImageView)param1View.findViewById(2131297416);
      this.cvg = (ViewGroup)param1View.findViewById(2131297518);
      this.cvh = (ViewGroup)param1View.findViewById(2131297519);
      this.cvi = (ViewGroup)param1View.findViewById(2131297714);
      this.cvj = (ImageView)param1View.findViewById(2131297416);
      this.cvk = (ViewGroup)param1View.findViewById(2131297731);
    }
  }
  
  private class b extends AsyncTask<String, Void, Boolean> {
    private b(WeiOrderSettingFragment this$0) {}
    
    protected void b(Boolean param1Boolean) {
      if (this.cuP.getActivity() == null)
        return; 
      if (param1Boolean.booleanValue()) {
        switch (this.cuP.cuL.ctH.Jr()) {
          default:
            return;
          case 2:
            this.cuP.cuK.cvf.setImageBitmap(WeiOrderSettingFragment.a(this.cuP, this.cuP.cuM));
            return;
          case 1:
            break;
        } 
        this.cuP.cuK.aZa.setImageBitmap(WeiOrderSettingFragment.a(this.cuP, this.cuP.cuM));
        return;
      } 
      this.cuP.cuK.aZa.setImageResource(2131231999);
      this.cuP.cuK.cvf.setImageResource(2131231999);
    }
    
    protected Boolean e(String... param1VarArgs) {
      String str2 = param1VarArgs[0];
      String str1 = param1VarArgs[1];
      return TextUtils.isEmpty(str2) ? Boolean.valueOf(false) : Boolean.valueOf(dw.h(CrashApplication.zv(), str2, str1));
    }
    
    protected void onPreExecute() {
      this.cuP.cuK.aZa.setImageResource(0);
      this.cuP.cuK.cvf.setImageResource(0);
    }
  }
  
  private class c extends AsyncTask<Void, Void, Boolean> {
    boolean cvl = false;
    
    private c(WeiOrderSettingFragment this$0) {}
    
    private String abH() {
      av av = new av(this.cuP.getActivity());
      String str = av.rs(av.Tx());
      av.close();
      return str;
    }
    
    protected void b(Boolean param1Boolean) {
      if (this.cuP.getActivity() == null)
        return; 
      if (param1Boolean.booleanValue()) {
        this.cuP.cuK.cuX.setText(this.cuP.getString(2131628614));
        WeiOrderSettingFragment.a(this.cuP, this.cuP.cuL.ctH.getUrl(), this.cuP.cuM);
        this.cuP.cuK.cuW.setClickable(false);
        return;
      } 
      this.cuP.cuK.cuX.setText(this.cuP.getString(2131630568));
      this.cuP.cuK.cuW.setClickable(true);
      Toast.makeText(this.cuP.getActivity(), this.cuP.getString(2131630567), 0).show();
    }
    
    protected Boolean g(Void... param1VarArgs) {
      if (!this.cvl) {
        if (this.cuP.cuL.ctH.Jr() == 1) {
          String str = CrashApplication.getLaiqianPreferenceManager().Tx();
          str = fp.aX(CrashApplication.zv()).kb(str);
          if (str != null) {
            this.cuP.cuL.ctH.setUrl(str);
            return Boolean.valueOf(true);
          } 
          return Boolean.valueOf(false);
        } 
        return Boolean.valueOf(false);
      } 
      return Boolean.valueOf(true);
    }
    
    protected void onPreExecute() {
      String str = abH();
      if (!TextUtils.isEmpty(str)) {
        this.cvl = true;
        this.cuP.cuL.ctH.setUrl(str);
        return;
      } 
      this.cvl = false;
    }
  }
  
  private class d extends AsyncTask<String, Void, Boolean> {
    private d(WeiOrderSettingFragment this$0) {}
    
    protected void b(Boolean param1Boolean) {
      if (this.cuP.getActivity() == null)
        return; 
      if (param1Boolean.booleanValue()) {
        this.cuP.cuK.cvf.setImageBitmap(WeiOrderSettingFragment.a(this.cuP, this.cuP.cuM));
        return;
      } 
      this.cuP.cuK.cvf.setImageResource(2131231999);
      Toast.makeText(this.cuP.getActivity(), this.cuP.getString(2131630569), 0).show();
    }
    
    protected Boolean e(String... param1VarArgs) {
      boolean bool = false;
      null = param1VarArgs[0];
      null = WeiOrderSettingFragment.a(this.cuP, null);
      if (null == null)
        return Boolean.valueOf(false); 
      String str = bk.v(null);
      if (!TextUtils.isEmpty(str)) {
        bool = dw.h(CrashApplication.zv(), str, this.cuP.cuM);
        this.cuP.cuL.ctH.setUrl(str);
      } 
      return Boolean.valueOf(bool);
    }
  }
  
  private static class e {
    public aw ctH;
    
    public boolean cub;
    
    public an.c cvm;
    
    public e(aw param1aw, an.c param1c, boolean param1Boolean) {
      this.ctH = param1aw;
      this.cvm = param1c;
      this.cub = param1Boolean;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == null)
        return false; 
      if (!(param1Object instanceof e))
        return false; 
      param1Object = (e)param1Object;
      return !this.ctH.equals(param1Object.ctH) ? false : (!this.cvm.equals(param1Object.cvm) ? false : (!(this.cub != param1Object.cub)));
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\WeiOrderSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */