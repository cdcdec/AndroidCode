package com.laiqian.f;

import com.google.a.a.a.a.a.a;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class e {
  private static int aPn = 33;
  
  static  {
  
  }
  
  private static int[] Eq() { return new int[] { 
        147, 135, 152, 96, 18, 26, 50, 29, 107, 118, 
        21, 239, 4, 102, 164, 150, 200, 91, 221, 190, 
        128, 181, 184, 64, 34, 6, 141, 59, 66, 161, 
        31, 229, 94, 17, 93, 49, 83, 244, 211, 97, 
        14, 90, 84, 24, 73, 35, 143, 198, 75, 7, 
        248, 206, 139, 77, 251, 130, 112, 213, 233, 48, 
        177, 168, 252, 119, 43, 65, 95, 69, 246, 87, 
        178, 88, 204, 117, 215, 120, 22, 223, 191, 38, 
        242, 124, 195, 225, 226, 192, 160, 108, 203, 197, 
        32, 170, 173, 138, 230, 241, 72, 23, 114, 205, 
        235, 243, 30, 33, 210, 228, 5, 46, 224, 85, 
        100, 54, 154, 60, 57, 188, 219, 134, 15, 153, 
        146, 148, 149, 136, 131, 68, 122, 81, 62, 82, 
        28, 212, 245, 183, 163, 56, 182, 254, 187, 167, 
        123, 137, 217, 162, 51, 106, 19, 110, 231, 103, 
        165, 214, 89, 115, 201, 71, 12, 169, 180, 236, 
        250, 172, 208, 105, 79, 249, 209, 253, 176, 121, 
        227, 36, 158, 216, 80, 142, 179, 189, 58, 222, 
        175, 25, 8, 47, 86, 109, 10, 126, 63, 0, 
        74, 11, 76, 238, 67, 55, 193, 186, 13, 111, 
        99, 232, 185, 133, 247, 1, 42, 145, 116, 113, 
        234, 202, 151, 53, 218, 45, 155, 255, 127, 207, 
        98, 157, 78, 132, 196, 37, 2, 166, 92, 144, 
        156, 101, 159, 104, 70, 240, 129, 220, 27, 52, 
        16, 3, 44, 237, 199, 194, 125, 171, 41, 140, 
        20, 174, 9, 40, 61, 39 }; }
  
  public static boolean a(FileInputStream paramFileInputStream, DataOutputStream paramDataOutputStream, String paramString) {
    try {
      paramDataOutputStream.write(paramString.getBytes("ASCII"));
      int i = aPn;
      byte[] arrayOfByte = new byte[i];
      paramFileInputStream.read(arrayOfByte);
      paramDataOutputStream.write(d(arrayOfByte, 0, i - 1), 0, i);
      return true;
    } catch (UnsupportedEncodingException paramFileInputStream) {
      a.e(paramFileInputStream);
      return false;
    } catch (IOException paramFileInputStream) {
      a.e(paramFileInputStream);
      return false;
    } 
  }
  
  private static byte[] d(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
    int[] arrayOfInt = Eq();
    while (paramInt1 <= paramInt2) {
      paramArrayOfByte[paramInt1] = (byte)arrayOfInt[paramArrayOfByte[paramInt1] & 0xFF];
      paramInt1++;
    } 
    return paramArrayOfByte;
  }
  
  public static boolean n(String paramString1, String paramString2, String paramString3) {
    try {
      (new File(paramString2)).createNewFile();
      FileInputStream fileInputStream = new FileInputStream(paramString1);
      FileOutputStream fileOutputStream = new FileOutputStream(paramString2);
      fileOutputStream.write(paramString3.getBytes("ASCII"));
      int i = aPn;
      byte[] arrayOfByte = new byte[i];
      fileInputStream.read(arrayOfByte);
      fileOutputStream.write(d(arrayOfByte, 0, i - 1), 0, i);
      arrayOfByte = new byte[8192];
      while (true) {
        i = fileInputStream.read(arrayOfByte);
        if (i > 0) {
          fileOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        break;
      } 
      fileOutputStream.flush();
      fileOutputStream.getFD().sync();
      fileOutputStream.close();
      fileInputStream.close();
      return true;
    } catch (UnsupportedEncodingException paramString1) {
      a.e(paramString1);
      return false;
    } catch (IOException paramString1) {
      a.e(paramString1);
      return false;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\f\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */