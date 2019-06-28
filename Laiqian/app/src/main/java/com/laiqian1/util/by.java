package com.laiqian.util;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.KeyEvent;
import com.google.a.a.a.a.a.a;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;

public class by {
  public static String G(String paramString, int paramInt) {
    if (paramString != null) {
      if ("".equals(paramString))
        return paramString; 
      if (paramString.length() == 11) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(paramString.substring(0, 3));
        stringBuffer.append("-");
        stringBuffer.append(paramString.substring(3, 7));
        stringBuffer.append("-");
        stringBuffer.append(paramString.substring(7, 11));
        return stringBuffer.toString();
      } 
      if (paramString.length() > paramInt) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(paramString.substring(0, paramInt));
        stringBuffer.append("...");
        return stringBuffer.toString();
      } 
      return paramString;
    } 
    return paramString;
  }
  
  public static String H(String paramString, int paramInt) {
    if (paramString.length() > paramInt) {
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append(paramString.substring(0, paramInt));
      stringBuffer.append("...");
      return stringBuffer.toString();
    } 
    if (paramString.length() >= 7) {
      StringBuffer stringBuffer = new StringBuffer();
      while (paramString.length() - 4 > 0) {
        stringBuffer.append(paramString.substring(0, 4));
        stringBuffer.append("-");
        String str = paramString.substring(4, paramString.length());
        paramString = str;
        if (str.length() <= 4) {
          stringBuffer.append(str);
          paramString = str;
        } 
      } 
      return stringBuffer.toString();
    } 
    return paramString;
  }
  
  public static String I(String paramString, int paramInt) {
    if (paramString.length() > paramInt) {
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append(paramString.substring(0, 4));
      stringBuffer.append("****");
      stringBuffer.append(paramString.substring(paramString.length() - 4, paramString.length()));
      return stringBuffer.toString();
    } 
    if (paramString.length() >= 7) {
      StringBuffer stringBuffer = new StringBuffer();
      while (paramString.length() - 4 > 0) {
        stringBuffer.append(paramString.substring(0, 4));
        stringBuffer.append("-");
        String str = paramString.substring(4, paramString.length());
        paramString = str;
        if (str.length() <= 4) {
          stringBuffer.append(str);
          paramString = str;
        } 
      } 
      return stringBuffer.toString();
    } 
    return paramString;
  }
  
  public static String J(String paramString, int paramInt) {
    if (paramString == null)
      return ""; 
    try {
      byte[] arrayOfByte = paramString.getBytes("gb2312");
      if (arrayOfByte.length > paramInt) {
        byte[] arrayOfByte1 = new byte[paramInt];
        for (paramInt = 0; paramInt < arrayOfByte1.length; paramInt++)
          arrayOfByte1[paramInt] = arrayOfByte[paramInt]; 
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new String(arrayOfByte1, "gb2312"));
        stringBuffer.append("...");
        return stringBuffer.toString();
      } 
      return paramString;
    } catch (Exception exception) {
      return paramString;
    } 
  }
  
  public static int a(JSONArray paramJSONArray1, JSONArray paramJSONArray2) {
    if (paramJSONArray1 == null) {
      Log.e("waimai", "arrNew:isNull");
      return (paramJSONArray2 != null && paramJSONArray2.length() != 0) ? paramJSONArray2.length() : 0;
    } 
    if (paramJSONArray2 == null || paramJSONArray2.length() == 0)
      return paramJSONArray1.length(); 
    boolean bool2 = false;
    byte b = 0;
    boolean bool1 = false;
    while (true) {
      if (bool2 < paramJSONArray1.length()) {
        boolean bool = false;
        while (true);
        break;
      } 
      return b;
    } 
  }
  
  public static String a(CharSequence paramCharSequence, Collection paramCollection) {
    bg.requireNonNull(paramCharSequence);
    bg.requireNonNull(paramCollection);
    bx bx = new bx(paramCharSequence);
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext())
      bx.v(iterator.next().toString()); 
    return bx.toString();
  }
  
  public static String a(String paramString, int paramInt, Context paramContext) {
    int j = paramString.indexOf(".");
    int i = j;
    if (j == -1)
      i = paramString.length(); 
    if (i > paramInt) {
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append(paramString.substring(0, paramInt));
      stringBuffer.append("...");
      return stringBuffer.toString();
    } 
    return paramString.contains(",") ? paramString : n.d(Double.valueOf(Double.parseDouble(paramString)));
  }
  
  public static String a(String paramString1, int paramInt, Context paramContext, String paramString2) {
    int j = paramString1.indexOf(".");
    int i = j;
    if (j == -1)
      i = paramString1.length(); 
    if (i > paramInt) {
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append(paramString1.substring(0, paramInt));
      stringBuffer.append("...");
      return stringBuffer.toString();
    } 
    return n.d(Double.valueOf(Double.parseDouble(paramString1)));
  }
  
  public static boolean a(KeyEvent paramKeyEvent, boolean paramBoolean) { // Byte code:
    //   0: aload_0
    //   1: invokevirtual getKeyCode : ()I
    //   4: istore_2
    //   5: iload_2
    //   6: bipush #60
    //   8: if_icmpeq -> 19
    //   11: iload_1
    //   12: istore_3
    //   13: iload_2
    //   14: bipush #59
    //   16: if_icmpne -> 30
    //   19: iload_1
    //   20: istore_3
    //   21: aload_0
    //   22: invokevirtual getAction : ()I
    //   25: ifne -> 30
    //   28: iconst_1
    //   29: istore_3
    //   30: iload_3
    //   31: ireturn }
  
  public static char b(KeyEvent paramKeyEvent, boolean paramBoolean) {
    int i = paramKeyEvent.getKeyCode();
    byte b = 45;
    if (i >= 29 && i <= 54) {
      int j;
      if (paramBoolean) {
        j = 65;
      } else {
        j = 97;
      } 
      return (char)(j + i - 29);
    } 
    if (i >= 144 && i <= 153)
      return (char)(i + 48 - 144); 
    if (i >= 7 && i <= 16) {
      if (!paramBoolean)
        return (char)(i + 48 - 7); 
      switch (i) {
        default:
          return Character.MIN_VALUE;
        case 15:
          return '*';
        case 14:
          return '&';
        case 13:
          return '^';
        case 12:
          return '%';
        case 11:
          return '$';
        case 10:
          return '#';
        case 8:
          return '!';
        case 7:
        case 16:
          return ')';
        case 9:
          break;
      } 
    } 
    char c = b;
    switch (i) {
      default:
      
      case 163:
      
      case 162:
        return '(';
      case 157:
        return '+';
      case 77:
        return '@';
      case 76:
        return paramBoolean ? '/' : '?';
      case 74:
        return paramBoolean ? ';' : ':';
      case 73:
        return paramBoolean ? '|' : '\\';
      case 69:
        c = b;
        if (paramBoolean)
          return '_'; 
        break;
      case 56:
        return paramBoolean ? '.' : '>';
      case 55:
        if (paramBoolean)
          return ','; 
        c = '<';
        break;
      case 156:
        break;
    } 
    return c;
  }
  
  public static SpannableString b(String paramString1, String paramString2, int paramInt1, int paramInt2) {
    int i = paramString1.indexOf(paramString2);
    SpannableString spannableString = new SpannableString(paramString1);
    if (i < 0)
      return spannableString; 
    spannableString.setSpan(new ForegroundColorSpan(paramInt2), i, paramString2.length() + i, 34);
    spannableString.setSpan(new AbsoluteSizeSpan(paramInt1, true), i, paramString2.length() + i, 33);
    return spannableString;
  }
  
  public static String bu(String paramString1, String paramString2) {
    if (paramString1.length() < 5)
      return paramString1; 
    if (paramString1.length() < 9) {
      StringBuffer stringBuffer1 = new StringBuffer();
      stringBuffer1.append(paramString2.substring(0, paramString1.length() - 4));
      stringBuffer1.append(paramString1.substring(paramString1.length() - 4));
      return stringBuffer1.toString();
    } 
    StringBuffer stringBuffer = new StringBuffer(paramString1);
    stringBuffer.replace(paramString1.length() / 2 - 2, paramString1.length() / 2 + 2, paramString2);
    return stringBuffer.toString();
  }
  
  public static String bv(String paramString1, String paramString2) {
    StringBuffer stringBuffer;
    if (paramString1 != null) {
      if ("".equals(paramString1))
        return paramString1; 
      if (paramString1.length() == 1)
        return paramString1; 
      stringBuffer = new StringBuffer(paramString1);
      stringBuffer.replace(0, 1, paramString2);
      return stringBuffer.toString();
    } 
    return stringBuffer;
  }
  
  public static boolean bw(String paramString1, String paramString2) {
    if (paramString1 != null && paramString2 != null) {
      if (!paramString1.equals(paramString2))
        return false; 
    } else {
      return (paramString1 == null) ? (!(paramString2 != null)) : false;
    } 
    return true;
  }
  
  public static double d(String paramString, double paramDouble) {
    if (paramString != null)
      try {
        if (paramString.length() > 0)
          return Double.parseDouble(paramString); 
      } catch (NumberFormatException paramString) {
        a.e(paramString);
      }  
    return paramDouble;
  }
  
  public static long[] f(StringBuilder paramStringBuilder) {
    boolean bool = isNull(paramStringBuilder.toString());
    byte b = 0;
    if (!bool) {
      String[] arrayOfString = paramStringBuilder.toString().split(",");
      long[] arrayOfLong = new long[arrayOfString.length];
      while (b < arrayOfString.length) {
        arrayOfLong[b] = Long.parseLong(arrayOfString[b]);
        b++;
      } 
      return arrayOfLong;
    } 
    return new long[0];
  }
  
  public static boolean isNull(String paramString) { return (paramString == null || "null".equals(paramString.trim()) || "".equals(paramString)); }
  
  public static String join(CharSequence paramCharSequence, CharSequence... paramVarArgs) {
    bg.requireNonNull(paramCharSequence);
    bg.requireNonNull(paramVarArgs);
    bx bx = new bx(paramCharSequence);
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++)
      bx.v(paramVarArgs[b]); 
    return bx.toString();
  }
  
  public static String k(Double paramDouble) { return (new BigDecimal(paramDouble.doubleValue())).toPlainString(); }
  
  public static double parseDouble(String paramString) { return d(paramString, 0.0D); }
  
  public static int parseInt(String paramString) {
    if (paramString != null && !"".equals(paramString))
      try {
        return Integer.parseInt(paramString);
      } catch (NumberFormatException paramString) {
        a.e(paramString);
        return 0;
      }  
    return 0;
  }
  
  public static long parseLong(String paramString) {
    if (paramString != null && !"".equals(paramString))
      try {
        return Long.parseLong(paramString);
      } catch (NumberFormatException paramString) {
        a.e(paramString);
        return 0L;
      }  
    return 0L;
  }
  
  public static String sb(String paramString) { return paramString.replace("--", ""); }
  
  public static String sc(String paramString) {
    String str = paramString;
    if (paramString.indexOf(".") > 0)
      str = paramString.replaceAll("0+?$", "").replaceAll("[.]$", ""); 
    return str;
  }
  
  public static String sd(String paramString) { return (new BigDecimal(paramString)).toPlainString(); }
  
  public static boolean se(String paramString) {
    if (paramString != null)
      try {
        if (paramString.length() > 0)
          return Boolean.parseBoolean(paramString); 
      } catch (NumberFormatException paramString) {
        a.e(paramString);
      }  
    return false;
  }
  
  public static String sf(String paramString) {
    int i = paramString.length();
    if (i > 1 && paramString.charAt(0) == '"')
      if (paramString.charAt(--i) == '"')
        return paramString.substring(1, i);  
    return paramString;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqia\\util\by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */