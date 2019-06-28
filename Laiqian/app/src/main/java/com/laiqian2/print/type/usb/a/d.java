package com.laiqian.print.type.usb.a;

import android.content.Context;
import com.laiqian.infrastructure.R;
import com.laiqian.print.a.a;

public class d extends a {
  private int arQ;
  
  private int arR;
  
  private Context context;
  
  public d(Context paramContext, int paramInt1, int paramInt2) {
    super(paramContext.getString(R.string.diagnose_usb_printer_permission_title));
    this.context = paramContext;
    this.arQ = paramInt1;
    this.arR = paramInt2;
  }
  
  public void run() { // Byte code:
    //   0: aload_0
    //   1: getfield context : Landroid/content/Context;
    //   4: ldc 'usb'
    //   6: invokestatic E : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;
    //   9: checkcast android/hardware/usb/UsbManager
    //   12: astore_2
    //   13: aload_2
    //   14: invokevirtual getDeviceList : ()Ljava/util/HashMap;
    //   17: invokevirtual values : ()Ljava/util/Collection;
    //   20: invokeinterface iterator : ()Ljava/util/Iterator;
    //   25: astore_3
    //   26: aload_3
    //   27: invokeinterface hasNext : ()Z
    //   32: ifeq -> 70
    //   35: aload_3
    //   36: invokeinterface next : ()Ljava/lang/Object;
    //   41: checkcast android/hardware/usb/UsbDevice
    //   44: astore_1
    //   45: aload_1
    //   46: invokevirtual getVendorId : ()I
    //   49: aload_0
    //   50: getfield arQ : I
    //   53: if_icmpne -> 26
    //   56: aload_1
    //   57: invokevirtual getProductId : ()I
    //   60: aload_0
    //   61: getfield arR : I
    //   64: if_icmpne -> 26
    //   67: goto -> 72
    //   70: aconst_null
    //   71: astore_1
    //   72: aload_1
    //   73: ifnonnull -> 95
    //   76: aload_0
    //   77: aload_0
    //   78: getfield context : Landroid/content/Context;
    //   81: getstatic com/laiqian/infrastructure/R$string.diagnose_usb_printer_device_not_found : I
    //   84: invokevirtual getString : (I)Ljava/lang/String;
    //   87: invokevirtual la : (Ljava/lang/String;)V
    //   90: aload_0
    //   91: invokevirtual afv : ()V
    //   94: return
    //   95: aload_2
    //   96: aload_1
    //   97: invokevirtual hasPermission : (Landroid/hardware/usb/UsbDevice;)Z
    //   100: ifne -> 122
    //   103: aload_0
    //   104: aload_0
    //   105: getfield context : Landroid/content/Context;
    //   108: getstatic com/laiqian/infrastructure/R$string.diagnose_usb_printer_permission_failed : I
    //   111: invokevirtual getString : (I)Ljava/lang/String;
    //   114: invokevirtual la : (Ljava/lang/String;)V
    //   117: aload_0
    //   118: invokevirtual afv : ()V
    //   121: return
    //   122: aload_0
    //   123: aload_0
    //   124: getfield context : Landroid/content/Context;
    //   127: getstatic com/laiqian/infrastructure/R$string.diagnose_state_pass : I
    //   130: invokevirtual getString : (I)Ljava/lang/String;
    //   133: invokevirtual la : (Ljava/lang/String;)V
    //   136: aload_0
    //   137: invokevirtual afu : ()V
    //   140: return }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\typ\\usb\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */