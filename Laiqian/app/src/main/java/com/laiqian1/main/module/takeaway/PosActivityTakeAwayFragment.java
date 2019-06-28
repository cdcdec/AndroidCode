package com.laiqian.main.module.takeaway;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.assistne.icondottextview.IconDotTextView;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.entity.aw;
import com.laiqian.main.dl;
import com.laiqian.main.fh;
import com.laiqian.pos.hardware.a.b;
import com.laiqian.pos.industry.weiorder.TakeOutGuideActivity;
import com.laiqian.pos.industry.weiorder.fp;
import com.laiqian.takeaway.aq;
import com.laiqian.util.av;
import com.laiqian.util.bq;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PosActivityTakeAwayFragment extends Fragment {
  public static String TAG = "PosActivityTakeAwayFragment";
  
  private dl bfr;
  
  private a boZ;
  
  private BroadcastReceiver bpa;
  
  private final long bpb = 60000L;
  
  private bq bpc;
  
  @Nullable
  String bpd = null;
  
  Runnable bpe = new c(this);
  
  static  {
  
  }
  
  public PosActivityTakeAwayFragment(dl paramdl) { this.bfr = paramdl; }
  
  private void KZ() {
    this.bpa = new b(this);
    getActivity().registerReceiver(this.bpa, new IntentFilter("MainTakeOutBroadReceiver"));
  }
  
  private void MS() { Pf(); }
  
  private void MT() { this.boZ.biy.setOnClickListener(new a(this)); }
  
  private void Pe() {
    if (this.bpa != null) {
      getActivity().unregisterReceiver(this.bpa);
      this.bpa = null;
    } 
  }
  
  private void Pf() {
    boolean bool1 = fp.aX(getActivity()).abV().Jq();
    if (aq.bz(getActivity()) != null) {
      i = 1;
    } else {
      i = 0;
    } 
    null = RootApplication.getLaiqianPreferenceManager();
    boolean bool2 = null.auW();
    if (i) {
      j = null.aut() + null.aqA() + 0;
    } else {
      j = 0;
    } 
    int i = j;
    if (bool1)
      i = j + null.aun(); 
    int j = i;
    if (bool2)
      j = i + null.aus(); 
    i = j + null.auu() + null.auo() + null.aup() + null.auq() + null.aur() + null.auv();
    b b = ((CrashApplication)getActivity().getApplication()).zC();
    if (i < 0)
      return; 
    if (i != 0) {
      this.boZ.biy.aZ(true);
      if (b != null)
        b.d(300L, TimeUnit.MILLISECONDS); 
    } else {
      if (b != null)
        b.aat(); 
      this.boZ.biy.aZ(false);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(i);
    stringBuilder.append("");
    String str = stringBuilder.toString();
    if (i > 99)
      str = "99+"; 
    this.boZ.biy.m(str);
  }
  
  private Set<Long> a(@Nullable JSONObject paramJSONObject1, @Nullable JSONObject paramJSONObject2, boolean paramBoolean) throws JSONException {
    JSONArray jSONArray;
    LinkedHashSet linkedHashSet1 = new LinkedHashSet();
    boolean bool2 = false;
    boolean bool1 = false;
    if (!paramBoolean) {
      LinkedHashSet linkedHashSet4 = new LinkedHashSet();
      LinkedHashSet linkedHashSet5 = new LinkedHashSet();
      if (paramJSONObject1 != null && paramJSONObject1.has("pending")) {
        jSONArray = paramJSONObject1.getJSONArray("pending");
        byte b;
        for (b = 0; b < jSONArray.length(); b++)
          linkedHashSet4.add(Long.valueOf(jSONArray.getLong(b))); 
      } 
      if (paramJSONObject2 != null && paramJSONObject2.has("pending")) {
        jSONArray = paramJSONObject2.getJSONArray("pending");
        byte b;
        for (b = bool1; b < jSONArray.length(); b++)
          linkedHashSet5.add(Long.valueOf(jSONArray.getLong(b))); 
      } 
      linkedHashSet4.retainAll(linkedHashSet5);
      linkedHashSet1.addAll(linkedHashSet4);
      return linkedHashSet1;
    } 
    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
    LinkedHashSet linkedHashSet3 = new LinkedHashSet();
    if (jSONArray != null && jSONArray.has("refund")) {
      jSONArray = jSONArray.getJSONArray("refund");
      byte b;
      for (b = 0; b < jSONArray.length(); b++)
        linkedHashSet2.add(Long.valueOf(jSONArray.getLong(b))); 
    } 
    if (paramJSONObject2 != null && paramJSONObject2.has("refund")) {
      jSONArray = paramJSONObject2.getJSONArray("refund");
      byte b;
      for (b = bool2; b < jSONArray.length(); b++)
        linkedHashSet3.add(Long.valueOf(jSONArray.getLong(b))); 
    } 
    linkedHashSet2.retainAll(linkedHashSet3);
    linkedHashSet1.addAll(linkedHashSet2);
    return linkedHashSet1;
  }
  
  private boolean a(JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString) throws JSONException { // Byte code:
    //   0: aload_1
    //   1: aload_3
    //   2: invokevirtual has : (Ljava/lang/String;)Z
    //   5: ifeq -> 22
    //   8: aload_1
    //   9: aload_3
    //   10: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   13: astore_1
    //   14: goto -> 24
    //   17: astore_1
    //   18: aload_1
    //   19: invokestatic e : (Ljava/lang/Throwable;)V
    //   22: aconst_null
    //   23: astore_1
    //   24: aload_2
    //   25: aload_3
    //   26: invokevirtual has : (Ljava/lang/String;)Z
    //   29: ifeq -> 46
    //   32: aload_2
    //   33: aload_3
    //   34: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   37: astore_2
    //   38: goto -> 48
    //   41: astore_2
    //   42: aload_2
    //   43: invokestatic e : (Ljava/lang/Throwable;)V
    //   46: aconst_null
    //   47: astore_2
    //   48: iconst_0
    //   49: istore #4
    //   51: aload_0
    //   52: aload_1
    //   53: aload_2
    //   54: iconst_0
    //   55: invokespecial a : (Lorg/json/JSONObject;Lorg/json/JSONObject;Z)Ljava/util/Set;
    //   58: astore_3
    //   59: aload_0
    //   60: aload_1
    //   61: aload_2
    //   62: iconst_1
    //   63: invokespecial a : (Lorg/json/JSONObject;Lorg/json/JSONObject;Z)Ljava/util/Set;
    //   66: astore_1
    //   67: aload_3
    //   68: invokeinterface isEmpty : ()Z
    //   73: ifeq -> 85
    //   76: aload_1
    //   77: invokeinterface isEmpty : ()Z
    //   82: ifne -> 88
    //   85: iconst_1
    //   86: istore #4
    //   88: iload #4
    //   90: ireturn
    // Exception table:
    //   from	to	target	type
    //   8	14	17	org/json/JSONException
    //   32	38	41	org/json/JSONException }
  
  public void onAttach(Context paramContext) {
    super.onAttach(paramContext);
    if (paramContext instanceof AppCompatActivity) {
      this.boZ = new a((AppCompatActivity)paramContext);
      MS();
      MT();
      return;
    } 
    throw new RuntimeException("no idea how to continue");
  }
  
  public void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    KZ();
  }
  
  public void onDetach() {
    super.onDetach();
    Pe();
  }
  
  public void onResume() {
    super.onResume();
    Pf();
  }
  
  public void onStart() {
    super.onStart();
    this.boZ.biy.post(this.bpe);
  }
  
  public void onStop() {
    super.onStop();
    this.boZ.biy.removeCallbacks(this.bpe);
  }
  
  static class a {
    IconDotTextView biy;
    
    a(Activity param1Activity) { this.biy = (IconDotTextView)param1Activity.findViewById(2131296290); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\takeaway\PosActivityTakeAwayFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */