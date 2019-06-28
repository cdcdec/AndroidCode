package com.laiqian.main.module.hardware.weight;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;
import com.assistne.icondottextview.IconDotTextView;
import com.laiqian.d.a;
import com.laiqian.main.dl;
import com.laiqian.scales.a;
import com.laiqian.scales.a.c;
import com.laiqian.scales.b.c;

public class PosActivityScaleFragment extends Fragment {
  private dl bfr;
  
  private final int bgm = 1;
  
  a bgn;
  
  BroadcastReceiver receiver = new b(this);
  
  public PosActivityScaleFragment(dl paramdl) { this.bfr = paramdl; }
  
  private Pair<c, UsbManager> MA() { // Byte code:
    //   0: aload_0
    //   1: invokevirtual getActivity : ()Landroid/support/v4/app/FragmentActivity;
    //   4: ldc 'usb'
    //   6: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   9: checkcast android/hardware/usb/UsbManager
    //   12: astore_2
    //   13: aload_2
    //   14: invokevirtual getDeviceList : ()Ljava/util/HashMap;
    //   17: invokevirtual values : ()Ljava/util/Collection;
    //   20: invokeinterface iterator : ()Ljava/util/Iterator;
    //   25: astore_1
    //   26: aload_1
    //   27: invokeinterface hasNext : ()Z
    //   32: ifeq -> 73
    //   35: aload_1
    //   36: invokeinterface next : ()Ljava/lang/Object;
    //   41: checkcast android/hardware/usb/UsbDevice
    //   44: astore_3
    //   45: aload_3
    //   46: invokestatic b : (Landroid/hardware/usb/UsbDevice;)Z
    //   49: ifeq -> 26
    //   52: aload_0
    //   53: aload_3
    //   54: invokespecial d : (Landroid/hardware/usb/UsbDevice;)Z
    //   57: ifeq -> 26
    //   60: new com/laiqian/scales/b/c
    //   63: dup
    //   64: aload_2
    //   65: aload_3
    //   66: invokespecial <init> : (Landroid/hardware/usb/UsbManager;Landroid/hardware/usb/UsbDevice;)V
    //   69: astore_1
    //   70: goto -> 75
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull -> 139
    //   79: new com/laiqian/scales/a
    //   82: dup
    //   83: aload_1
    //   84: invokestatic aoO : ()Lcom/laiqian/scales/a/d;
    //   87: invokespecial <init> : (Lcom/laiqian/scales/b/a;Lcom/laiqian/scales/a/b;)V
    //   90: astore_3
    //   91: invokestatic MD : ()Lcom/laiqian/main/module/hardware/weight/c;
    //   94: aload_3
    //   95: invokevirtual a : (Lcom/laiqian/scales/a;)V
    //   98: aload_1
    //   99: invokevirtual Dd : ()Landroid/hardware/usb/UsbDevice;
    //   102: astore_3
    //   103: aload_2
    //   104: aload_3
    //   105: invokevirtual hasPermission : (Landroid/hardware/usb/UsbDevice;)Z
    //   108: ifne -> 139
    //   111: new android/content/Intent
    //   114: dup
    //   115: ldc 'com.laiqian.scales.ACTION_PERMISSION'
    //   117: invokespecial <init> : (Ljava/lang/String;)V
    //   120: astore #4
    //   122: aload_2
    //   123: aload_3
    //   124: aload_0
    //   125: invokevirtual getActivity : ()Landroid/support/v4/app/FragmentActivity;
    //   128: iconst_1
    //   129: aload #4
    //   131: ldc 134217728
    //   133: invokestatic getBroadcast : (Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   136: invokevirtual requestPermission : (Landroid/hardware/usb/UsbDevice;Landroid/app/PendingIntent;)V
    //   139: new android/util/Pair
    //   142: dup
    //   143: aload_1
    //   144: aload_2
    //   145: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   148: areturn }
  
  private void MB() { c.MD().MH(); }
  
  private void MC() { c.MD().MI(); }
  
  private void a(c paramc, UsbManager paramUsbManager) {
    if (paramc != null && paramUsbManager != null) {
      a a1 = new a(paramc, c.aoO());
      c.MD().a(a1);
      if (paramUsbManager.hasPermission(paramc.Dd()))
        Toast.makeText(getActivity(), 2131630088, 0).show(); 
    } 
  }
  
  private boolean d(UsbDevice paramUsbDevice) { return !(("S16".equalsIgnoreCase(Build.MODEL) || "A7".equalsIgnoreCase(Build.MODEL) || "S15".equalsIgnoreCase(Build.MODEL) || "LQK-A7".equalsIgnoreCase(Build.MODEL)) && paramUsbDevice.getVendorId() == 6790 && paramUsbDevice.getProductId() == 29987); }
  
  private void es() { this.bgn.bgq.setOnClickListener(new a(this)); }
  
  public void onAttach(Activity paramActivity) {
    super.onAttach(paramActivity);
    this.bgn = new a(paramActivity);
    es();
  }
  
  public void onStart() {
    super.onStart();
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
    intentFilter.addAction("com.laiqian.print.ACTION_USB_DEVICE_ATTACHED");
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
    intentFilter.addAction("com.laiqian.USB_PERMISSION");
    intentFilter.addAction("com.laiqian.scales.ACTION_PERMISSION");
    getActivity().registerReceiver(this.receiver, intentFilter);
    if (a.AZ().BE() || a.AZ().BF()) {
      if (this.bgn.bgq.getVisibility() != 0)
        this.bgn.bgq.setVisibility(0); 
      MA();
      MB();
      return;
    } 
    if (this.bgn.bgq.getVisibility() == 0) {
      this.bgn.bgq.setVisibility(8);
      return;
    } 
  }
  
  public void onStop() {
    getActivity().unregisterReceiver(this.receiver);
    MC();
    super.onStop();
  }
  
  static class a {
    IconDotTextView bgq;
    
    public a(Activity param1Activity) { this.bgq = (IconDotTextView)param1Activity.findViewById(2131300030); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\hardware\weight\PosActivityScaleFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */