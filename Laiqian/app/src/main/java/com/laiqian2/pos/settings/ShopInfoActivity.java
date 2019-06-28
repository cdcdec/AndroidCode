package com.laiqian.pos.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.DocumentsContract;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.a.a.b;
import com.d.a.b.f.a;
import com.google.a.a.a.a.a.a;
import com.laiqian.c.a;
import com.laiqian.entity.av;
import com.laiqian.models.an;
import com.laiqian.models.h;
import com.laiqian.opentable.common.ag;
import com.laiqian.pos.industry.weiorder.fp;
import com.laiqian.print.dualscreen.o;
import com.laiqian.setting.by;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.LayoutLeftTextRightTextWithArrow;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.h;
import com.laiqian.util.ae;
import com.laiqian.util.am;
import com.laiqian.util.aq;
import com.laiqian.util.az;
import com.laiqian.util.bb;
import com.laiqian.util.bd;
import com.laiqian.util.by;
import io.reactivex.g.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShopInfoActivity extends ActivityRoot implements df {
  r aCz;
  
  Button aFw;
  
  public r aXH;
  
  cs cAo;
  
  a cBh = new a(16908290);
  
  b cBi;
  
  LayoutLeftTextRightTextWithArrow cBj;
  
  private final int cgS = 11;
  
  private final int cgT = 12;
  
  boolean chY;
  
  String chZ;
  
  private HashMap<String, File> chk;
  
  boolean chl;
  
  w chs;
  
  String chv = "";
  
  Handler chw;
  
  String cwb = "0";
  
  a cwc;
  
  HashMap<String, Integer> czo = new HashMap();
  
  StringBuffer czp;
  
  boolean czq;
  
  ViewGroup czt;
  
  TextView tvTitle;
  
  public ShopInfoActivity() {
    if (Build.VERSION.SDK_INT >= 19) {
      bool = true;
    } else {
      bool = false;
    } 
    this.chl = bool;
    this.aXH = null;
    this.chw = new cd(this);
  }
  
  private void ZU() {
    Intent intent = new Intent();
    intent.setClass(getActivity(), com.laiqian.ui.cropper.CropImageActivity.class);
    intent.putExtra("PHOTO_CROP_SAVEPATH", ((File)this.chk.get(this.cwb)).getAbsolutePath());
    intent.putExtra("ASPECT_RATIO_X", 12);
    intent.putExtra("ASPECT_RATIO_Y", 5);
    startActivityForResult(intent, 13);
  }
  
  private void abQ() {
    if (a.zR().Ad()) {
      ((LinearLayout)this.cBh.cBn.cAl.getView()).setVisibility(8);
      ((TextView)this.cBh.cBn.cAm.cAO.getView()).setText(2131624170);
      ((ViewGroup)this.cBh.cBn.cAm.getView()).setBackgroundResource(2130772057);
      ((ViewGroup)this.cBh.cBo.getView()).setBackgroundResource(2130772055);
      ((ViewGroup)this.cBh.cBp.getView()).setBackgroundResource(2130772051);
      ((ViewGroup)this.cBh.cBq.getView()).setBackgroundResource(2130772057);
      ((ViewGroup)this.cBh.cBr.getView()).setBackgroundResource(2130772051);
    } else {
      ((ViewGroup)this.cBh.cBp.getView()).setVisibility(8);
      ((ViewGroup)this.cBh.cBo.getView()).setVisibility(8);
      ((ViewGroup)this.cBh.cBr.getView()).setVisibility(8);
      ((ViewGroup)this.cBh.cBq.getView()).setVisibility(8);
    } 
    ((ViewGroup)this.cBh.cwi.getView()).setBackgroundResource(2130772035);
    ((TextView)this.cBh.cBo.cAO.getView()).setText("Tel");
    ((EditText)this.cBh.cBo.dwQ.getView()).setInputType(3);
    ((TextView)this.cBh.cBp.cAO.getView()).setText("Email");
    ((TextView)this.cBh.cBq.cAO.getView()).setText("ROC No.");
    ((TextView)this.cBh.cBr.cAO.getView()).setText("GST Reg No.");
  }
  
  private void abR() {
    if (!this.cAo.jV(((EditText)this.cBh.cBm.cAJ.dwQ.getView()).getText().toString())) {
      Toast.makeText(this, 2131629656, 0).show();
      return;
    } 
    if (!this.cAo.jW(((EditText)this.cBh.cBn.cAm.dwQ.getView()).getText().toString())) {
      Toast.makeText(this, 2131629647, 0).show();
      return;
    } 
    if (a.zR().Ad()) {
      this.cAo.kN(((EditText)this.cBh.cBo.dwQ.getView()).getText().toString());
      this.cAo.kO(((EditText)this.cBh.cBp.dwQ.getView()).getText().toString());
      this.cAo.kP(((EditText)this.cBh.cBq.dwQ.getView()).getText().toString());
      this.cAo.kQ(((EditText)this.cBh.cBr.dwQ.getView()).getText().toString());
    } 
    this.cAo.jY(this.cBh.cwi.Cc());
    if (!this.cAo.abU())
      return; 
    if (!bd.bH(this) && !getResources().getBoolean(2131034123)) {
      Toast.makeText(this, 2131626280, 0).show();
      return;
    } 
    if (!this.cAo.save()) {
      o o1 = o.afM();
      if (o1 != null)
        o1.afN(); 
      Toast.makeText(this, 2131628396, 0).show();
      return;
    } 
    o o = o.afM();
    if (o != null)
      o.afN(); 
    (new cn(this)).adD();
    (new ag()).execute(new Void[0]);
    Toast.makeText(this, 2131628397, 0).show();
    finish();
  }
  
  private void abi() {
    r r1 = new r(this, new cc(this));
    r1.setTitle(getString(2131627735));
    r1.s(getString(2131627733));
    r1.t(getString(2131627734));
    r1.oZ(getString(2131627732));
    r1.show();
  }
  
  private void acV() {
    h.a a1 = this.cAo.adj();
    if (a1 == null)
      return; 
    String[] arrayOfString = g(a1.UK());
    (new w(this, arrayOfString, new bx(this, arrayOfString, a1))).show();
  }
  
  private void acW() {
    h.e e = this.cAo.adi();
    if (e == null)
      return; 
    String[] arrayOfString = f(e.UO());
    (new w(this, arrayOfString, new by(this, arrayOfString, e))).show();
  }
  
  private void acX() {
    h.b b1 = h.aM(this).UJ();
    String[] arrayOfString = e(b1.UM());
    (new w(this, arrayOfString, new bz(this, arrayOfString, b1))).show();
  }
  
  private void acY() {
    String[] arrayOfString;
    this.czq = true;
    if (!getActivity().getResources().getBoolean(2131034123)) {
      arrayOfString = new String[26];
      arrayOfString[0] = an.q(this, 160007);
      arrayOfString[1] = an.q(this, 160008);
      arrayOfString[2] = an.q(this, 160009);
      arrayOfString[3] = an.q(this, 160010);
      arrayOfString[4] = an.q(this, 1600011);
      arrayOfString[5] = an.q(this, 1600012);
      arrayOfString[6] = an.q(this, 1600013);
      arrayOfString[7] = an.q(this, 1600014);
      arrayOfString[8] = an.q(this, 1600015);
      arrayOfString[9] = an.q(this, 1600016);
      arrayOfString[10] = an.q(this, 1600017);
      arrayOfString[11] = an.q(this, 1600018);
      arrayOfString[12] = an.q(this, 1600019);
      arrayOfString[13] = an.q(this, 1600020);
      arrayOfString[14] = an.q(this, 1600021);
      arrayOfString[15] = an.q(this, 1600022);
      arrayOfString[16] = an.q(this, 1600023);
      arrayOfString[17] = an.q(this, 1600024);
      arrayOfString[18] = an.q(this, 1600025);
      arrayOfString[19] = an.q(this, 1600026);
      arrayOfString[20] = an.q(this, 1600027);
      arrayOfString[21] = an.q(this, 1600028);
      arrayOfString[22] = an.q(this, 1600029);
      arrayOfString[23] = an.q(this, 1600030);
      arrayOfString[24] = an.q(this, 1600031);
      arrayOfString[25] = an.q(this, 1600032);
    } else {
      arrayOfString = new String[5];
      arrayOfString[0] = an.q(this, 160001);
      arrayOfString[1] = an.q(this, 160003);
      arrayOfString[2] = an.q(this, 160002);
      arrayOfString[3] = an.q(this, 160004);
      arrayOfString[4] = an.q(this, 160006);
    } 
    (new w(this, arrayOfString, new bv(this), true, getActivity().getResources().getBoolean(2131034123) ^ true, this.czo)).show();
  }
  
  private void acZ() {
    String str1 = an.p(this, 1);
    String str2 = an.p(this, 2);
    bw bw = new bw(this);
    (new w(this, new String[] { str1, str2 }, bw)).show();
  }
  
  @NonNull
  private StringBuffer add() {
    ArrayList arrayList = new ArrayList(this.czo.entrySet());
    Collections.sort(arrayList, new cb(this));
    StringBuffer stringBuffer = new StringBuffer();
    this.czp = new StringBuffer();
    for (byte b1 = 0; b1 < arrayList.size(); b1++) {
      Map.Entry entry = (Map.Entry)arrayList.get(b1);
      if (b1 != 0) {
        stringBuffer.append(",");
        this.czp.append(",");
      } 
      stringBuffer.append((String)entry.getKey());
      this.czp.append(entry.getValue());
    } 
    return stringBuffer;
  }
  
  private boolean c(Uri paramUri) {
    String str;
    if (this.chl && DocumentsContract.isDocumentUri(getActivity(), paramUri)) {
      str = am.b(getActivity(), paramUri);
    } else {
      str = am.c(getActivity(), paramUri);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("filename_uri->");
    stringBuilder.append(str);
    bb.e("filename", stringBuilder.toString());
    if (str != null && (new File(str)).exists())
      return am.B(str, ((File)this.chk.get(this.cwb)).getAbsolutePath()); 
    if (str == null)
      try {
        return am.a(getActivity().getContentResolver().openInputStream(paramUri), ((File)this.chk.get(this.cwb)).getAbsolutePath());
      } catch (FileNotFoundException paramUri) {
        a.e(paramUri);
      }  
    return false;
  }
  
  private String[] e(LinkedHashMap<String, h.e> paramLinkedHashMap) {
    ArrayList arrayList = new ArrayList();
    Iterator iterator = paramLinkedHashMap.values().iterator();
    while (iterator.hasNext())
      arrayList.add(((h.e)iterator.next()).getName()); 
    return (String[])arrayList.toArray(new String[0]);
  }
  
  private String[] f(LinkedHashMap<String, h.a> paramLinkedHashMap) {
    ArrayList arrayList = new ArrayList();
    Iterator iterator = paramLinkedHashMap.values().iterator();
    while (iterator.hasNext())
      arrayList.add(((h.a)iterator.next()).getName()); 
    return (String[])arrayList.toArray(new String[0]);
  }
  
  private String[] g(LinkedHashMap<String, h.c> paramLinkedHashMap) {
    ArrayList arrayList = new ArrayList();
    Iterator iterator = paramLinkedHashMap.values().iterator();
    while (iterator.hasNext())
      arrayList.add(((h.c)iterator.next()).getName()); 
    return (String[])arrayList.toArray(new String[0]);
  }
  
  private void n(Intent paramIntent) {
    az.info("setPicToView");
    if (paramIntent.getAction() != null || paramIntent.getExtras() != null) {
      if (!paramIntent.getBooleanExtra("PHOTO_CROP_RESULT", false)) {
        Toast.makeText(getActivity(), getString(2131626616), 0).show();
        return;
      } 
      ((ProgressBarCircularIndeterminate)this.cBh.cAC.getView()).setVisibility(0);
      ((ImageView)this.cBh.cAB.getView()).setVisibility(8);
      ((ImageView)this.cBh.cAD.getView()).setVisibility(8);
      a.aKh().r(new bo(this));
    } 
  }
  
  private void s(String paramString, boolean paramBoolean) {
    this.cBi.fr(paramBoolean);
    this.cBi.jU(paramString);
    fp fp = fp.aX(getActivity());
    av av = fp.abW();
    av.dO(paramString);
    fp.b(av);
    if (paramString == null || "".equals(paramString)) {
      ((ProgressBarCircularIndeterminate)this.cBh.cAC.getView()).setVisibility(8);
      ((ImageView)this.cBh.cAB.getView()).setVisibility(8);
      ((ImageView)this.cBh.cAD.getView()).setVisibility(0);
      return;
    } 
    if (getActivity() != null)
      aq.a(paramString, (ImageView)this.cBh.cAB.getView(), this.cwc, ae.b(getActivity(), 4.0F)); 
  }
  
  private void save() {
    if (!this.cAo.jV(((EditText)this.cBh.cBm.cAJ.dwQ.getView()).getText().toString())) {
      Toast.makeText(this, 2131629656, 0).show();
      return;
    } 
    if (!this.cAo.jW(((EditText)this.cBh.cBn.cAm.dwQ.getView()).getText().toString())) {
      Toast.makeText(this, 2131629647, 0).show();
      return;
    } 
    if (a.zR().Ad()) {
      this.cAo.kN(((EditText)this.cBh.cBo.dwQ.getView()).getText().toString());
      this.cAo.kO(((EditText)this.cBh.cBp.dwQ.getView()).getText().toString());
      this.cAo.kP(((EditText)this.cBh.cBq.dwQ.getView()).getText().toString());
      this.cAo.kQ(((EditText)this.cBh.cBr.dwQ.getView()).getText().toString());
    } 
    if (!this.cAo.abU())
      return; 
    if (!this.cAo.save()) {
      Toast.makeText(this, 2131628396, 0).show();
      return;
    } 
    Toast.makeText(this, 2131628397, 0).show();
    finish();
  }
  
  private void setListeners() {
    this.cwc = new bp(this);
    this.cBi = new b(this, this.chY, this.chZ);
    ((ViewGroup)this.cBh.cAA.getView()).setOnClickListener(this.cBi);
    this.aFw.setOnClickListener(new ca(this));
    this.czt.setOnClickListener(new cf(this));
    ((EditText)this.cBh.cBm.cAJ.dwQ.getView()).addTextChangedListener(new cg(this));
    ((ViewGroup)this.cBh.cBm.cAL.getView()).setOnClickListener(new ch(this));
    ((ViewGroup)this.cBh.cBm.cAK.getView()).setOnClickListener(new ci(this));
    ((TextView)this.cBh.cBn.cAl.dwH.getView()).setOnClickListener(new cj(this));
    ((TextView)this.cBh.cBn.cAl.dwI.getView()).setOnClickListener(new ck(this));
    ((TextView)this.cBh.cBn.cAl.dwJ.getView()).setOnClickListener(new cl(this));
    ((EditText)this.cBh.cBn.cAm.dwQ.getView()).addTextChangedListener(new bq(this));
    ((EditText)this.cBh.cBo.dwQ.getView()).addTextChangedListener(new br(this));
    ((EditText)this.cBh.cBp.dwQ.getView()).addTextChangedListener(new bs(this));
    ((EditText)this.cBh.cBq.dwQ.getView()).addTextChangedListener(new bt(this));
    ((EditText)this.cBh.cBr.dwQ.getView()).addTextChangedListener(new bu(this));
  }
  
  public void abS() {
    ce ce = new ce(this);
    if (this.aCz == null) {
      this.aCz = new r(getActivity(), true, ce);
      this.aCz.setTitle(getString(2131625963));
      this.aCz.s(getString(2131627033));
      this.aCz.t(getString(2131625538));
      this.aCz.oZ(getString(2131628275));
    } 
    this.aCz.show();
  }
  
  public void b(h.c paramc) { this.cBh.cBn.b(paramc); }
  
  public void d(h.a parama) { this.cBh.cBn.d(parama); }
  
  public void d(h.e parame) { this.cBh.cBn.d(parame); }
  
  public void dK(String paramString) { ((EditText)this.cBh.cBm.cAJ.dwQ.getView()).setText(paramString); }
  
  public String ho(int paramInt) {
    if (getResources().getBoolean(2131034123))
      this.czo = new HashMap(); 
    if (by.isNull(this.czp.toString())) {
      this.czo.put(an.q(this, paramInt), Integer.valueOf(paramInt));
      return an.q(this, paramInt);
    } 
    if (this.czo.containsKey(an.q(this, paramInt))) {
      this.czo.remove(an.q(this, paramInt));
    } else {
      this.czo.put(an.q(this, paramInt), Integer.valueOf(paramInt));
    } 
    add();
    return this.czp.toString();
  }
  
  public void hr(int paramInt) { ((TextView)this.cBh.cBm.cAK.cAP.getView()).setText(an.p(this, paramInt)); }
  
  public void jR(String paramString) { this.cBh.cBn.jR(paramString); }
  
  public void jT(String paramString) {
    this.chZ = paramString;
    if (this.chZ == null || "".equals(this.chZ)) {
      this.chY = false;
    } else {
      this.chY = true;
    } 
    s(this.chZ, this.chY);
  }
  
  public void kH(String paramString) {
    String[] arrayOfString = paramString.split(",");
    if (!this.czq)
      for (byte b1 = 0; b1 < arrayOfString.length; b1++) {
        int i = Integer.parseInt(arrayOfString[b1]);
        if (this.czo.containsKey(an.q(this, i))) {
          this.czo.remove(an.q(this, i));
        } else {
          this.czo.put(an.q(this, i), Integer.valueOf(i));
        } 
      }  
    StringBuffer stringBuffer = add();
    ((TextView)this.cBh.cBm.cAL.cAP.getView()).setText(stringBuffer.toString());
  }
  
  public void kI(String paramString) { ((EditText)this.cBh.cBo.dwQ.getView()).setText(paramString); }
  
  public void kJ(String paramString) { ((EditText)this.cBh.cBp.dwQ.getView()).setText(paramString); }
  
  public void kK(String paramString) { ((EditText)this.cBh.cBq.dwQ.getView()).setText(paramString); }
  
  public void kL(String paramString) { ((EditText)this.cBh.cBr.dwQ.getView()).setText(paramString); }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1 && (paramIntent == null || paramInt2 == 0))
      return; 
    switch (paramInt1) {
      default:
        return;
      case 13:
        n(paramIntent);
        return;
      case 12:
        ZU();
        return;
      case 11:
        break;
    } 
    if (c(paramIntent.getData()))
      ZU(); 
  }
  
  public void onBackPressed() {
    if (this.cAo.Az()) {
      abi();
      return;
    } 
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427422);
    getWindow().setFeatureInt(7, 2131428168);
    this.cBh.S(findViewById(this.cBh.getId()));
    this.cBj = (LayoutLeftTextRightTextWithArrow)findViewById(2131297935);
    this.cBj.setOnClickListener(new by(getActivity(), com.laiqian.member.setting.VipModeSettingActivity.class, null));
    this.tvTitle = (TextView)findViewById(2131299889);
    this.czt = (ViewGroup)findViewById(2131299878);
    this.aFw = (Button)findViewById(2131299879);
    this.tvTitle.setText(getString(2131629652));
    this.aFw.setText(getString(2131629495));
    abQ();
    setListeners();
    this.cAo = new cs(this);
    this.cAo.b(this);
  }
  
  public static class a extends ab<ViewGroup> {
    public ab<ViewGroup> cAA = new ab(2131297539);
    
    public ab<ImageView> cAB = new ab(2131297367);
    
    public ab<ProgressBarCircularIndeterminate> cAC = new ab(2131297382);
    
    public ab<ImageView> cAD = new ab(2131297360);
    
    public bd cBm = new bd(2131297515);
    
    public an cBn = new an(2131297669);
    
    public h cBo = new h(2131297706);
    
    public h cBp = new h(2131297560);
    
    public h cBq = new h(2131297659);
    
    public h cBr = new h(2131297572);
    
    public be cwi = new be(2131297526);
    
    public a(int param1Int) { super(param1Int); }
  }
  
  class b implements View.OnClickListener {
    boolean chY;
    
    String chZ;
    
    public b(ShopInfoActivity this$0, boolean param1Boolean, String param1String) {
      this.chY = param1Boolean;
      this.chZ = param1String;
    }
    
    public void fr(boolean param1Boolean) { this.chY = param1Boolean; }
    
    public void jU(String param1String) { this.chZ = param1String; }
    
    public void onClick(View param1View) {
      if (this.cBl.chs == null) {
        this.cBl.chs = new w(this.cBl.getActivity());
        this.cBl.chs.setTitle(this.cBl.getString(2131630489));
      } 
      if (this.chY) {
        this.cBl.chs.C(new String[] { this.cBl.getString(2131630488), this.cBl.getString(2131630487), this.cBl.getString(2131630486), this.cBl.getString(2131630483) });
      } else {
        this.cBl.chs.C(new String[] { this.cBl.getString(2131630488), this.cBl.getString(2131630487) });
      } 
      this.cBl.chs.a(new cm(this));
      this.cBl.chs.show();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\ShopInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */