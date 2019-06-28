package com.laiqian.print.dualscreen;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaRouter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.google.a.a.a.a.a.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.l;
import com.laiqian.ui.container.w;
import com.laiqian.ui.s;
import com.laiqian.util.am;
import com.laiqian.util.av;
import com.laiqian.util.r;
import com.squareup.a.ab;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public final class DualScreenSettingsActivity extends ActivityRoot {
  private b cFl;
  
  private int cFm = -1;
  
  private a cFn;
  
  av cFo;
  
  private boolean cFp;
  
  File cFq;
  
  String cFr = null;
  
  private aa titleBar;
  
  private void afF() {
    String[] arrayOfString = new String[5];
    arrayOfString[0] = "2s";
    arrayOfString[1] = "5s";
    arrayOfString[2] = "8s";
    arrayOfString[3] = "15s";
    arrayOfString[4] = "30s";
    (new w(this, arrayOfString, new i(this, arrayOfString))).show();
  }
  
  private void afG() {
    List list = Arrays.asList(this.cFn.afA());
    this.cFl.cFC.setAdapter(new a(this, this, list));
  }
  
  private void afH() {
    this.cFm = 100;
    String str1 = getString(2131625111);
    String str2 = getString(2131625106);
    j j = new j(this);
    (new w(this, new String[] { str1, str2 }, j)).show();
  }
  
  private void afI() {
    this.cFm = -1;
    String str1 = getString(2131625111);
    String str2 = getString(2131625106);
    k k = new k(this);
    (new w(this, new String[] { str1, str2 }, k)).show();
  }
  
  private File afJ() {
    String str = (new SimpleDateFormat("yyyyMMdd_HHmmss")).format(new Date());
    File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(".jpg");
    return new File(file, stringBuilder.toString());
  }
  
  private void afK() {
    if (Build.VERSION.SDK_INT >= 19) {
      Intent intent1 = new Intent("android.intent.action.GET_CONTENT");
      intent1.addCategory("android.intent.category.OPENABLE");
      intent1.setType("image/*");
      if (intent1.resolveActivity(getPackageManager()) != null) {
        startActivityForResult(intent1, 2);
        return;
      } 
      Toast.makeText(this, "没有找到图库app", 0).show();
      return;
    } 
    Intent intent = new Intent("android.intent.action.PICK");
    intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
    if (intent.resolveActivity(getPackageManager()) != null) {
      startActivityForResult(intent, 2);
      return;
    } 
    Toast.makeText(this, "没有找到图库app", 0).show();
  }
  
  @TargetApi(17)
  private Display getPresentationDisplay() {
    if (Build.VERSION.SDK_INT >= 17) {
      MediaRouter.RouteInfo routeInfo = ((MediaRouter)r.E(this, "media_router")).getSelectedRoute(2);
      if (routeInfo != null) {
        Display display = routeInfo.getPresentationDisplay();
        if (display != null)
          return display; 
      } 
    } 
    return null;
  }
  
  private void hX(int paramInt) {
    this.cFm = paramInt;
    String str1 = getString(2131625111);
    String str2 = getString(2131625106);
    String str3 = getString(2131625107);
    String str4 = getString(2131625103);
    d d = new d(this);
    (new w(this, new String[] { str1, str2, str3, str4 }, d)).show();
  }
  
  private void init() {
    this.cFn = a.lb(this.cFo.Tx());
    afG();
    if (getPresentationDisplay() != null)
      startService(new Intent(this, DualScreenService.class)); 
    String str = this.cFn.afB();
    if (!TextUtils.isEmpty(str)) {
      this.cFl.cFD.setImageURI(Uri.parse(str));
      this.cFp = true;
    } 
  }
  
  private void ld(String paramString) {
    this.cFr = paramString;
    Intent intent = new Intent();
    intent.setClass(getActivity(), com.laiqian.ui.cropper.CropImageActivity.class);
    intent.putExtra("PHOTO_CROP_SAVEPATH", paramString);
    int i = this.cFm;
    int j = 600;
    if (i == 100) {
      i = 600;
    } else {
      i = 1024;
    } 
    intent.putExtra("ASPECT_RATIO_X", i);
    if (getResources().getBoolean(2131034123)) {
      i = j;
    } else {
      i = 576;
    } 
    intent.putExtra("ASPECT_RATIO_Y", i);
    startActivityForResult(intent, 3);
  }
  
  @Nullable
  private File n(@NonNull InputStream paramInputStream) {
    File file = getExternalCacheDir();
    try {
      file = File.createTempFile("lqk", "pic", file);
      if (am.a(paramInputStream, file.getAbsolutePath())) {
        file.deleteOnExit();
        return file;
      } 
      return null;
    } catch (IOException paramInputStream) {
      a.e(paramInputStream);
      return null;
    } 
  }
  
  private void setupViews() {
    this.titleBar.tvTitle.setText(getString(2131625109));
    this.titleBar.brj.setVisibility(8);
    this.titleBar.brk.setVisibility(8);
    this.cFl.cFx.setText(2131625108);
    ((ViewGroup)this.cFl.cFy.getView()).setBackgroundResource(2131231855);
    ((ViewGroup)this.cFl.cFz.getView()).setBackgroundResource(2131231847);
    ((ViewGroup)this.cFl.cFA.getView()).setBackgroundResource(2131231855);
    ((TextView)this.cFl.cFy.cAO.getView()).setText(2131625110);
    ((TextView)this.cFl.cFz.cAO.getView()).setText(2131625113);
    ((TextView)this.cFl.cFA.cAO.getView()).setText(2131629559);
    ((CheckBox)this.cFl.cFy.dwV.getView()).setChecked(CrashApplication.getLaiqianPreferenceManager().avz());
    ((CheckBox)this.cFl.cFz.dwV.getView()).setChecked(CrashApplication.getLaiqianPreferenceManager().avG());
    TextView textView = (TextView)this.cFl.cFA.cAP.getView();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.cFo.avH());
    stringBuilder.append("s");
    textView.setText(stringBuilder.toString());
    this.cFl.cFB.setText(getString(2131625104));
    ((CheckBox)this.cFl.cFy.dwV.getView()).setOnCheckedChangeListener(new e(this));
    ((CheckBox)this.cFl.cFz.dwV.getView()).setOnCheckedChangeListener(new f(this));
    ((ViewGroup)this.cFl.cFA.getView()).setOnClickListener(new g(this));
    this.cFl.cFD.setOnClickListener(new h(this));
  }
  
  private void w(File paramFile) { (new n(this, paramFile)).show(); }
  
  private void x(File paramFile) {
    this.cFq = paramFile;
    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
    intent.putExtra("output", Uri.fromFile(paramFile));
    if (intent.resolveActivity(getPackageManager()) != null) {
      startActivityForResult(intent, 1);
      return;
    } 
    Toast.makeText(this, getString(2131627147), 0).show();
  }
  
  @Nullable
  private File y(@NonNull File paramFile) {
    File file = getExternalCacheDir();
    try {
      file = File.createTempFile("lqk", "pic", file);
      if (am.B(paramFile.getAbsolutePath(), file.getAbsolutePath())) {
        file.deleteOnExit();
        return file;
      } 
      return null;
    } catch (IOException paramFile) {
      a.e(paramFile);
      return null;
    } 
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    o o;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1) {
      default:
        return;
      case 3:
        if (paramIntent.getBooleanExtra("PHOTO_CROP_RESULT", false) && this.cFr != null) {
          o = new File(this.cFr);
          if (this.cFm == -1) {
            this.cFn.t(o);
          } else if (this.cFm == 100) {
            this.cFn.u(o);
            ab.cx(this).K(o).c(this.cFl.cFD);
            o = o.afM();
            if (o != null) {
              o.afP().lf(this.cFr);
              this.cFp = true;
            } 
          } else {
            this.cFn.b(o, this.cFm);
          } 
          afG();
          return;
        } 
        return;
      case 2:
        if (paramInt2 == -1) {
          uri1 = o.getData();
          Uri uri2 = null;
          try {
            InputStream inputStream = getContentResolver().openInputStream(uri1);
            uri1 = uri2;
            if (inputStream != null)
              File file = n(inputStream); 
          } catch (FileNotFoundException uri1) {
            a.e(uri1);
            Toast.makeText(this, "Prepare image failed", 0).show();
            uri1 = uri2;
          } 
          if (uri1 != null) {
            ld(uri1.getAbsolutePath());
            return;
          } 
          Toast.makeText(this, "Prepare image failed", 0).show();
          return;
        } 
        return;
      case 1:
        break;
    } 
    if (paramInt2 == -1) {
      File file = y(this.cFq);
      if (file != null) {
        ld(file.getAbsolutePath());
        return;
      } 
      Toast.makeText(this, "Prepare image failed", 0).show();
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.cFl = b.E(this);
    this.cFl.cFC.getParent().requestDisallowInterceptTouchEvent(true);
    this.titleBar = aa.M(this);
    this.cFo = new av(this);
    setupViews();
    init();
  }
  
  public class a extends BaseAdapter {
    List<File> cFv;
    
    Context context;
    
    public a(DualScreenSettingsActivity this$0, Context param1Context, List<File> param1List) {
      this.context = param1Context;
      this.cFv = param1List;
      if (param1List == null)
        throw new InvalidParameterException(); 
    }
    
    public int getCount() { return this.cFv.size() + 1; }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      DualScreenSettingsActivity.b.a a2;
      DualScreenSettingsActivity.b.a a1;
      if (param1View == null) {
        a1 = DualScreenSettingsActivity.b.a.bd(this.context);
        a2 = a1.aQG;
        a2.setTag(a1);
      } else {
        DualScreenSettingsActivity.b.a a3 = (DualScreenSettingsActivity.b.a)a1.getTag();
        a2 = a1;
        a1 = a3;
      } 
      if (param1Int == this.cFv.size()) {
        a1.abP();
        a1.aQG.setOnClickListener(new l(this));
        return a2;
      } 
      File file = hZ(param1Int);
      a1.afL();
      ab.cx(this.cFt.getActivity()).K(file).c(a1.cFG);
      a1.aQG.setOnClickListener(new m(this, param1Int));
      return a2;
    }
    
    public File hZ(int param1Int) { return (param1Int == this.cFv.size()) ? null : (File)this.cFv.get(param1Int); }
    
    public void notifyDataSetChanged() { super.notifyDataSetChanged(); }
  }
  
  public static class b {
    View aQG;
    
    w cFA = new w(2131297661);
    
    TextView cFB;
    
    GridView cFC;
    
    ImageButton cFD;
    
    TextView cFx;
    
    l cFy = new l(2131297682);
    
    l cFz = new l(2131297681);
    
    public b(View param1View) {
      this.aQG = param1View;
      this.cFx = (TextView)s.z(param1View, 2131299692);
      this.cFy.S(s.z(param1View, this.cFy.getId()));
      this.cFz.S(s.z(param1View, this.cFz.getId()));
      this.cFA.S(s.z(param1View, this.cFA.getId()));
      this.cFB = (TextView)s.z(param1View, 2131299563);
      this.cFC = (GridView)s.z(param1View, 2131297266);
      this.cFD = (ImageButton)s.z(param1View, 2131299467);
    }
    
    public static b E(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(2131427371, null);
      param1Activity.setContentView(view);
      return new b(view);
    }
    
    public static class a {
      public View aQG;
      
      public ProgressBarCircularIndeterminate bAA;
      
      public ViewFlipper cFE;
      
      public ImageView cFF;
      
      public ImageView cFG;
      
      public a(View param2View) {
        this.aQG = param2View;
        this.cFE = (ViewFlipper)s.z(param2View, 2131297058);
        this.cFF = (ImageView)s.z(param2View, 2131297359);
        this.cFG = (ImageView)s.z(param2View, 2131297376);
        this.bAA = (ProgressBarCircularIndeterminate)s.z(param2View, 2131298615);
      }
      
      public static a bd(Context param2Context) { return new a(LayoutInflater.from(param2Context).inflate(2131427648, null)); }
      
      public void abP() { this.cFE.setDisplayedChild(0); }
      
      public void afL() { this.cFE.setDisplayedChild(1); }
    }
  }
  
  public static class a {
    public View aQG;
    
    public ProgressBarCircularIndeterminate bAA;
    
    public ViewFlipper cFE;
    
    public ImageView cFF;
    
    public ImageView cFG;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cFE = (ViewFlipper)s.z(param1View, 2131297058);
      this.cFF = (ImageView)s.z(param1View, 2131297359);
      this.cFG = (ImageView)s.z(param1View, 2131297376);
      this.bAA = (ProgressBarCircularIndeterminate)s.z(param1View, 2131298615);
    }
    
    public static a bd(Context param1Context) { return new a(LayoutInflater.from(param1Context).inflate(2131427648, null)); }
    
    public void abP() { this.cFE.setDisplayedChild(0); }
    
    public void afL() { this.cFE.setDisplayedChild(1); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\dualscreen\DualScreenSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */