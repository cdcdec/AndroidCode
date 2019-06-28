package com.laiqian.f;

import com.google.a.a.a.a.a.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class d {
  private static int aPn = 33;
  
  static  {
  
  }
  
  private static int[] DM() { return new int[] { 
        189, 205, 226, 241, 12, 106, 25, 49, 182, 252, 
        186, 191, 156, 198, 40, 118, 240, 33, 4, 146, 
        250, 10, 76, 97, 43, 181, 5, 238, 130, 7, 
        102, 30, 90, 103, 24, 45, 171, 225, 79, 255, 
        253, 248, 206, 64, 242, 215, 107, 183, 59, 35, 
        6, 144, 239, 213, 111, 195, 135, 114, 178, 27, 
        113, 254, 128, 188, 23, 65, 28, 194, 125, 67, 
        234, 155, 96, 44, 190, 48, 192, 53, 222, 164, 
        174, 127, 129, 36, 42, 109, 184, 69, 71, 152, 
        41, 17, 228, 34, 32, 66, 3, 39, 220, 200, 
        110, 231, 13, 149, 233, 163, 145, 8, 87, 185, 
        147, 199, 56, 209, 98, 153, 208, 73, 9, 63, 
        75, 169, 126, 140, 81, 246, 187, 218, 20, 236, 
        55, 124, 223, 203, 117, 1, 123, 141, 93, 52, 
        249, 26, 175, 46, 229, 207, 120, 0, 121, 122, 
        15, 212, 2, 119, 112, 216, 230, 221, 172, 232, 
        86, 29, 143, 134, 14, 150, 227, 139, 61, 157, 
        91, 247, 161, 92, 251, 180, 168, 60, 70, 176, 
        158, 21, 136, 133, 22, 202, 197, 138, 115, 177, 
        19, 78, 85, 196, 245, 82, 224, 89, 47, 244, 
        16, 154, 211, 88, 72, 99, 51, 219, 162, 166, 
        104, 38, 131, 57, 151, 74, 173, 142, 214, 116, 
        237, 18, 179, 77, 108, 83, 84, 170, 105, 31, 
        94, 148, 201, 58, 210, 100, 159, 243, 193, 11, 
        235, 95, 80, 101, 37, 132, 68, 204, 50, 165, 
        160, 54, 62, 167, 137, 217 }; }
  
  public static boolean a(InputStream paramInputStream, FileOutputStream paramFileOutputStream, String paramString) {
    try {
      null = new byte[paramString.getBytes("ASCII").length];
      paramInputStream.read(null);
      String str = new String(null, "ASCII");
      if (str != null) {
        if (!str.equals(paramString))
          return false; 
        int i = aPn;
        byte[] arrayOfByte = new byte[i];
        paramInputStream.read(arrayOfByte);
        paramFileOutputStream.write(c(arrayOfByte, 0, i - 1), 0, i);
        return true;
      } 
      return false;
    } catch (UnsupportedEncodingException paramInputStream) {
      a.e(paramInputStream);
      return false;
    } catch (IOException paramInputStream) {
      a.e(paramInputStream);
      return false;
    } 
  }
  
  private static byte[] c(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
    int[] arrayOfInt = DM();
    while (paramInt1 <= paramInt2) {
      paramArrayOfByte[paramInt1] = (byte)arrayOfInt[paramArrayOfByte[paramInt1] & 0xFF];
      paramInt1++;
    } 
    return paramArrayOfByte;
  }
  
  public static int m(String paramString1, String paramString2, String paramString3) {
    try {
      (new File(paramString2)).createNewFile();
      FileInputStream fileInputStream = new FileInputStream(paramString1);
      FileOutputStream fileOutputStream = new FileOutputStream(paramString2);
      byte[] arrayOfByte2 = new byte[paramString3.getBytes("ASCII").length];
      fileInputStream.read(arrayOfByte2);
      String str = new String(arrayOfByte2, "ASCII");
      if (str == null || !str.equals(paramString3))
        return 2; 
      int i = aPn;
      byte[] arrayOfByte1 = new byte[i];
      fileInputStream.read(arrayOfByte1);
      fileOutputStream.write(c(arrayOfByte1, 0, i - 1), 0, i);
      arrayOfByte1 = new byte[8192];
      while (true) {
        i = fileInputStream.read(arrayOfByte1);
        if (i > 0) {
          fileOutputStream.write(arrayOfByte1, 0, i);
          continue;
        } 
        break;
      } 
      fileOutputStream.close();
      fileInputStream.close();
      return 1;
    } catch (UnsupportedEncodingException paramString1) {
      a.e(paramString1);
      return 0;
    } catch (IOException paramString1) {
      a.e(paramString1);
      return 0;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */