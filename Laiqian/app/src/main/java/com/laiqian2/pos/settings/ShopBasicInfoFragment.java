package com.laiqian.pos.settings;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.laiqian.c.a;
import com.laiqian.models.an;
import com.laiqian.models.h;
import com.laiqian.opentable.common.ag;
import com.laiqian.pos.settings.view.ShopAddressView;
import com.laiqian.pos.settings.view.ShopBusinessHoursView;
import com.laiqian.print.dualscreen.o;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.LayoutLeftTextRightEditText;
import com.laiqian.ui.container.LayoutLeftTextRightTextWithDialog;
import com.laiqian.ui.container.ab;
import com.laiqian.util.bd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.b.d;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
public final class ShopBasicInfoFragment extends Fragment implements df {
  public static final a cAp = new a(null);
  
  private b cAn;
  
  private cs cAo;
  
  private HashMap cAq;
  
  private final HashMap<String, Integer> czo = new HashMap();
  
  private StringBuffer czp = new StringBuffer();
  
  private boolean czq;
  
  private final void abQ() {
    if (a.zR().Ad()) {
      b b3 = this.cAn;
      if (b3 == null)
        f.ut("container"); 
      View view = (b3.adu()).cBX;
      f.l(view, "container.layoutAddress.layoutAddressSelector");
      view.setVisibility(8);
      b b2 = this.cAn;
      if (b2 == null)
        f.ut("container"); 
      (b2.adu()).cCc.setText(2131624170);
      b2 = this.cAn;
      if (b2 == null)
        f.ut("container"); 
      (b2.adu()).cBY.setBackgroundResource(2131231855);
      b2 = this.cAn;
      if (b2 == null)
        f.ut("container"); 
      b2.adv().setBackgroundResource(2131231853);
      b2 = this.cAn;
      if (b2 == null)
        f.ut("container"); 
      b2.adw().setBackgroundResource(2131231847);
      b2 = this.cAn;
      if (b2 == null)
        f.ut("container"); 
      b2.adx().setBackgroundResource(2131231855);
      b2 = this.cAn;
      if (b2 == null)
        f.ut("container"); 
      b2.ady().setBackgroundResource(2131231847);
      return;
    } 
    b b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    b1.adw().setVisibility(8);
    b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    b1.adv().setVisibility(8);
    b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    b1.ady().setVisibility(8);
    b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    b1.adx().setVisibility(8);
  }
  
  private final void acV() {
    null = this.cAo;
    if (null == null)
      f.ut("presenter"); 
    h.a a1 = null.adj();
    if (a1 != null) {
      LinkedHashMap linkedHashMap = a1.UK();
      f.l(linkedHashMap, "currentCity.getDistricts()");
      String[] arrayOfString = g(linkedHashMap);
      (new w((Context)getActivity(), arrayOfString, (w.a)new ap(this, arrayOfString, a1))).show();
      return;
    } 
  }
  
  private final void acW() {
    null = this.cAo;
    if (null == null)
      f.ut("presenter"); 
    h.e e = null.adi();
    if (e != null) {
      LinkedHashMap linkedHashMap = e.UO();
      f.l(linkedHashMap, "currentProvince.getCities()");
      String[] arrayOfString = f(linkedHashMap);
      (new w((Context)getActivity(), arrayOfString, (w.a)new ao(this, arrayOfString, e))).show();
      return;
    } 
  }
  
  private final void acX() {
    h h = h.aM((Context)getActivity());
    f.l(h, "AddressProvider.getInstance(activity)");
    h.b b1 = h.UJ();
    f.l(b1, "china");
    LinkedHashMap linkedHashMap = b1.UM();
    f.l(linkedHashMap, "china.provinces");
    String[] arrayOfString = e(linkedHashMap);
    (new w((Context)getActivity(), arrayOfString, (w.a)new aq(this, arrayOfString, b1))).show();
  }
  
  private final String[] e(LinkedHashMap<String, h.e> paramLinkedHashMap) {
    ArrayList arrayList = new ArrayList();
    for (h.e e : paramLinkedHashMap.values()) {
      f.l(e, "p");
      arrayList.add(e.getName());
    } 
    Object[] arrayOfObject = ((Collection)arrayList).toArray(new String[0]);
    if (arrayOfObject == null)
      throw new h("null cannot be cast to non-null type kotlin.Array<T>"); 
    return (String[])arrayOfObject;
  }
  
  private final String[] f(LinkedHashMap<String, h.a> paramLinkedHashMap) {
    ArrayList arrayList = new ArrayList();
    for (h.a a1 : paramLinkedHashMap.values()) {
      f.l(a1, "c");
      arrayList.add(a1.getName());
    } 
    Object[] arrayOfObject = ((Collection)arrayList).toArray(new String[0]);
    if (arrayOfObject == null)
      throw new h("null cannot be cast to non-null type kotlin.Array<T>"); 
    return (String[])arrayOfObject;
  }
  
  private final String[] g(LinkedHashMap<String, h.c> paramLinkedHashMap) {
    ArrayList arrayList = new ArrayList();
    for (h.c c : paramLinkedHashMap.values()) {
      f.l(c, "d");
      arrayList.add(c.getName());
    } 
    Object[] arrayOfObject = ((Collection)arrayList).toArray(new String[0]);
    if (arrayOfObject == null)
      throw new h("null cannot be cast to non-null type kotlin.Array<T>"); 
    return (String[])arrayOfObject;
  }
  
  private final void setListeners() {
    b b3 = this.cAn;
    if (b3 == null)
      f.ut("container"); 
    b3.adr().aqU().addTextChangedListener((TextWatcher)new as(this));
    b3 = this.cAn;
    if (b3 == null)
      f.ut("container"); 
    LayoutLeftTextRightTextWithDialog layoutLeftTextRightTextWithDialog2 = b3.adt();
    String[] arrayOfString = getActivity();
    f.l(arrayOfString, "activity");
    if (!arrayOfString.getResources().getBoolean(2131034123)) {
      String[] arrayOfString1 = new String[26];
      arrayOfString1[0] = an.q((Context)getActivity(), 160007);
      arrayOfString1[1] = an.q((Context)getActivity(), 160008);
      arrayOfString1[2] = an.q((Context)getActivity(), 160009);
      arrayOfString1[3] = an.q((Context)getActivity(), 160010);
      arrayOfString1[4] = an.q((Context)getActivity(), 1600011);
      arrayOfString1[5] = an.q((Context)getActivity(), 1600012);
      arrayOfString1[6] = an.q((Context)getActivity(), 1600013);
      arrayOfString1[7] = an.q((Context)getActivity(), 1600014);
      arrayOfString1[8] = an.q((Context)getActivity(), 1600015);
      arrayOfString1[9] = an.q((Context)getActivity(), 1600016);
      arrayOfString1[10] = an.q((Context)getActivity(), 1600017);
      arrayOfString1[11] = an.q((Context)getActivity(), 1600018);
      arrayOfString1[12] = an.q((Context)getActivity(), 1600019);
      arrayOfString1[13] = an.q((Context)getActivity(), 1600020);
      arrayOfString1[14] = an.q((Context)getActivity(), 1600021);
      arrayOfString1[15] = an.q((Context)getActivity(), 1600022);
      arrayOfString1[16] = an.q((Context)getActivity(), 1600023);
      arrayOfString1[17] = an.q((Context)getActivity(), 1600024);
      arrayOfString1[18] = an.q((Context)getActivity(), 1600025);
      arrayOfString1[19] = an.q((Context)getActivity(), 1600026);
      arrayOfString1[20] = an.q((Context)getActivity(), 1600027);
      arrayOfString1[21] = an.q((Context)getActivity(), 1600028);
      arrayOfString1[22] = an.q((Context)getActivity(), 1600029);
      arrayOfString1[23] = an.q((Context)getActivity(), 1600030);
      arrayOfString1[24] = an.q((Context)getActivity(), 1600031);
      arrayOfString1[25] = an.q((Context)getActivity(), 1600032);
    } else {
      arrayOfString = new String[5];
      arrayOfString[0] = an.q((Context)getActivity(), 160001);
      arrayOfString[1] = an.q((Context)getActivity(), 160003);
      arrayOfString[2] = an.q((Context)getActivity(), 160002);
      arrayOfString[3] = an.q((Context)getActivity(), 160004);
      arrayOfString[4] = an.q((Context)getActivity(), 160006);
    } 
    layoutLeftTextRightTextWithDialog2.a(arrayOfString, (LayoutLeftTextRightTextWithDialog.b)new av(this));
    b b2 = this.cAn;
    if (b2 == null)
      f.ut("container"); 
    LayoutLeftTextRightTextWithDialog layoutLeftTextRightTextWithDialog1 = b2.ads();
    String str1 = an.p((Context)getActivity(), 1);
    String str2 = an.p((Context)getActivity(), 2);
    LayoutLeftTextRightTextWithDialog.b b4 = (LayoutLeftTextRightTextWithDialog.b)new aw(this);
    layoutLeftTextRightTextWithDialog1.a(new String[] { str1, str2 }, b4);
    b b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    (b1.adu()).cBZ.setOnClickListener((View.OnClickListener)new ax(this));
    b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    (b1.adu()).cCa.setOnClickListener((View.OnClickListener)new ay(this));
    b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    (b1.adu()).cCb.setOnClickListener((View.OnClickListener)new az(this));
    b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    (b1.adu()).cCc.addTextChangedListener((TextWatcher)new ba(this));
    b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    b1.adv().aqU().addTextChangedListener((TextWatcher)new bb(this));
    b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    b1.adw().aqU().addTextChangedListener((TextWatcher)new bc(this));
    b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    b1.adx().aqU().addTextChangedListener((TextWatcher)new at(this));
    b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    b1.ady().aqU().addTextChangedListener((TextWatcher)new au(this));
  }
  
  public void ado() {
    if (this.cAq != null)
      this.cAq.clear(); 
  }
  
  public void b(@NotNull h.c paramc) {
    f.m(paramc, "district");
    b b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    b1.adu().b(paramc);
  }
  
  public void d(@NotNull h.a parama) {
    f.m(parama, "city");
    b b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    b1.adu().d(parama);
  }
  
  public void d(@NotNull h.e parame) {
    f.m(parame, "province");
    b b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    b1.adu().d(parame);
  }
  
  public void dK(@NotNull String paramString) {
    f.m(paramString, "name");
    b b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    b1.adr().oX(paramString);
  }
  
  public void hr(int paramInt) {
    b b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    b1.ads().oX(an.p((Context)getActivity(), paramInt));
  }
  
  public void jR(@NotNull String paramString) {
    f.m(paramString, "detailedAddress");
    b b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    b1.adu().jR(paramString);
  }
  
  public void jT(@Nullable String paramString) {}
  
  public void kH(@NotNull String paramString) {
    b b1;
    f.m(paramString, "industrys");
    if (de.kR(paramString)) {
      int i = Integer.parseInt(paramString);
      b1 = this.cAn;
      if (b1 == null)
        f.ut("container"); 
      b1.adt().oX(an.q((Context)getActivity(), i));
      return;
    } 
    b b2 = this.cAn;
    if (b2 == null)
      f.ut("container"); 
    b2.adt().oX(b1);
  }
  
  public void kI(@NotNull String paramString) {
    f.m(paramString, "tel");
    b b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    b1.adv().oX(paramString);
  }
  
  public void kJ(@NotNull String paramString) {
    f.m(paramString, "email");
    b b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    b1.adw().oX(paramString);
  }
  
  public void kK(@NotNull String paramString) {
    f.m(paramString, "rocNo");
    b b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    b1.adx().oX(paramString);
  }
  
  public void kL(@NotNull String paramString) {
    f.m(paramString, "gstRegNo");
    b b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    b1.ady().oX(paramString);
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    f.m(paramLayoutInflater, "inflater");
    return paramLayoutInflater.inflate(2131427607, paramViewGroup, false);
  }
  
  public void onViewCreated(@Nullable View paramView, @Nullable Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    if (paramView == null)
      f.aQI(); 
    this.cAn = new b(paramView);
    abQ();
    setListeners();
    this.cAo = new cs((Context)getActivity());
    cs cs1 = this.cAo;
    if (cs1 == null)
      f.ut("presenter"); 
    cs1.b((df)this);
  }
  
  public final void save() {
    null = this.cAo;
    if (null == null)
      f.ut("presenter"); 
    b b3 = this.cAn;
    if (b3 == null)
      f.ut("container"); 
    EditText editText2 = b3.adr().aqU();
    f.l(editText2, "container.shopName.rightEditText");
    if (!null.jV(editText2.getText().toString())) {
      Toast.makeText((Context)getActivity(), 2131629656, 0).show();
      return;
    } 
    null = this.cAo;
    if (null == null)
      f.ut("presenter"); 
    b b2 = this.cAn;
    if (b2 == null)
      f.ut("container"); 
    EditText editText1 = (b2.adu()).cCc;
    f.l(editText1, "container.layoutAddress.etDetailAddress");
    if (!null.jW(editText1.getText().toString())) {
      Toast.makeText((Context)getActivity(), 2131629647, 0).show();
      return;
    } 
    if (a.zR().Ad()) {
      null = this.cAo;
      if (null == null)
        f.ut("presenter"); 
      b b7 = this.cAn;
      if (b7 == null)
        f.ut("container"); 
      EditText editText6 = b7.adv().aqU();
      f.l(editText6, "container.layoutTel.rightEditText");
      null.kN(editText6.getText().toString());
      null = this.cAo;
      if (null == null)
        f.ut("presenter"); 
      b b6 = this.cAn;
      if (b6 == null)
        f.ut("container"); 
      EditText editText5 = b6.adw().aqU();
      f.l(editText5, "container.layoutEmail.rightEditText");
      null.kO(editText5.getText().toString());
      null = this.cAo;
      if (null == null)
        f.ut("presenter"); 
      b b5 = this.cAn;
      if (b5 == null)
        f.ut("container"); 
      EditText editText4 = b5.adx().aqU();
      f.l(editText4, "container.layoutRocNo.rightEditText");
      null.kP(editText4.getText().toString());
      null = this.cAo;
      if (null == null)
        f.ut("presenter"); 
      b b4 = this.cAn;
      if (b4 == null)
        f.ut("container"); 
      EditText editText3 = b4.ady().aqU();
      f.l(editText3, "container.layoutGstRegNo.rightEditText");
      null.kQ(editText3.getText().toString());
    } 
    null = this.cAo;
    if (null == null)
      f.ut("presenter"); 
    b b1 = this.cAn;
    if (b1 == null)
      f.ut("container"); 
    null.jY(b1.adq().Cc());
    null = this.cAo;
    if (null == null)
      f.ut("presenter"); 
    if (!null.abU())
      return; 
    if (!bd.bH((Context)getActivity()) && !getResources().getBoolean(2131034123)) {
      Toast.makeText((Context)getActivity(), 2131626280, 0).show();
      return;
    } 
    null = this.cAo;
    if (null == null)
      f.ut("presenter"); 
    if (!null.save()) {
      o o1 = o.afM();
      if (o1 != null)
        o1.afN(); 
      Toast.makeText((Context)getActivity(), 2131628396, 0).show();
      return;
    } 
    o o = o.afM();
    if (o != null)
      o.afN(); 
    (new cn((Context)getActivity())).adD();
    ag ag = new ag();
    ag.a((ag.a)new ar(this));
    ag.execute(new Void[0]);
  }
  
  @Metadata
  public static final class a {
    private a() {}
    
    @JvmStatic
    @NotNull
    public final ShopBasicInfoFragment adp() { return new ShopBasicInfoFragment(); }
  }
  
  @Metadata
  public static final class b {
    @NotNull
    private ab<ViewGroup> cAA;
    
    @NotNull
    private ab<ImageView> cAB;
    
    @NotNull
    private ab<ProgressBarCircularIndeterminate> cAC;
    
    @NotNull
    private ab<ImageView> cAD;
    
    @NotNull
    private ShopBusinessHoursView cAr;
    
    @NotNull
    private LayoutLeftTextRightEditText cAs;
    
    @NotNull
    private LayoutLeftTextRightTextWithDialog cAt;
    
    @NotNull
    private LayoutLeftTextRightTextWithDialog cAu;
    
    @NotNull
    private ShopAddressView cAv;
    
    @NotNull
    private LayoutLeftTextRightEditText cAw;
    
    @NotNull
    private LayoutLeftTextRightEditText cAx;
    
    @NotNull
    private LayoutLeftTextRightEditText cAy;
    
    @NotNull
    private LayoutLeftTextRightEditText cAz;
    
    public b(@NotNull View param1View) {
      View view = param1View.findViewById(2131296442);
      f.l(view, "view.findViewById(R.id.b…shop_info_business_hours)");
      this.cAr = (ShopBusinessHoursView)view;
      view = param1View.findViewById(2131296447);
      f.l(view, "view.findViewById(R.id.basic_shop_info_shop_name)");
      this.cAs = (LayoutLeftTextRightEditText)view;
      view = param1View.findViewById(2131296448);
      f.l(view, "view.findViewById(R.id.basic_shop_info_shop_type)");
      this.cAt = (LayoutLeftTextRightTextWithDialog)view;
      view = param1View.findViewById(2131296445);
      f.l(view, "view.findViewById(R.id.basic_shop_info_industry)");
      this.cAu = (LayoutLeftTextRightTextWithDialog)view;
      view = param1View.findViewById(2131296441);
      f.l(view, "view.findViewById(R.id.basic_shop_info_address)");
      this.cAv = (ShopAddressView)view;
      view = param1View.findViewById(2131296449);
      f.l(view, "view.findViewById(R.id.basic_shop_info_telephone)");
      this.cAw = (LayoutLeftTextRightEditText)view;
      view = param1View.findViewById(2131296443);
      f.l(view, "view.findViewById(R.id.basic_shop_info_email)");
      this.cAx = (LayoutLeftTextRightEditText)view;
      view = param1View.findViewById(2131296446);
      f.l(view, "view.findViewById(R.id.basic_shop_info_roc_no)");
      this.cAy = (LayoutLeftTextRightEditText)view;
      param1View = param1View.findViewById(2131296444);
      f.l(param1View, "view.findViewById(R.id.basic_shop_info_gst_reg_no)");
      this.cAz = (LayoutLeftTextRightEditText)param1View;
      this.cAA = new ab(2131297539);
      this.cAB = new ab(2131297367);
      this.cAC = new ab(2131297382);
      this.cAD = new ab(2131297360);
    }
    
    @NotNull
    public final ShopBusinessHoursView adq() { return this.cAr; }
    
    @NotNull
    public final LayoutLeftTextRightEditText adr() { return this.cAs; }
    
    @NotNull
    public final LayoutLeftTextRightTextWithDialog ads() { return this.cAt; }
    
    @NotNull
    public final LayoutLeftTextRightTextWithDialog adt() { return this.cAu; }
    
    @NotNull
    public final ShopAddressView adu() { return this.cAv; }
    
    @NotNull
    public final LayoutLeftTextRightEditText adv() { return this.cAw; }
    
    @NotNull
    public final LayoutLeftTextRightEditText adw() { return this.cAx; }
    
    @NotNull
    public final LayoutLeftTextRightEditText adx() { return this.cAy; }
    
    @NotNull
    public final LayoutLeftTextRightEditText ady() { return this.cAz; }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\ShopBasicInfoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */