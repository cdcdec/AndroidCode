package com.laiqian.debug;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.laiqian.basic.RootApplication;
import com.laiqian.f.c;
import com.laiqian.f.d;
import com.laiqian.sync.c.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class BackupFileDebugFragment extends ListFragment {
  private File aQr;
  
  private final ArrayList<File> aQs;
  
  private final String aQt;
  
  private final String aQu;
  
  public BackupFileDebugFragment() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Environment.getExternalStorageDirectory());
    stringBuilder.append("/来钱快备份文件夹");
    this.aQr = new File(stringBuilder.toString());
    this.aQs = new ArrayList();
    this.aQt = ".decrypted";
    this.aQu = ".unzipped";
  }
  
  private void Eh() { // Byte code:
    //   0: aload_0
    //   1: getfield aQr : Ljava/io/File;
    //   4: new com/laiqian/debug/c
    //   7: dup
    //   8: aload_0
    //   9: invokespecial <init> : (Lcom/laiqian/debug/BackupFileDebugFragment;)V
    //   12: invokevirtual listFiles : (Ljava/io/FileFilter;)[Ljava/io/File;
    //   15: astore_3
    //   16: aload_0
    //   17: getfield aQs : Ljava/util/ArrayList;
    //   20: invokevirtual clear : ()V
    //   23: aload_3
    //   24: arraylength
    //   25: istore_2
    //   26: iconst_0
    //   27: istore_1
    //   28: iload_1
    //   29: iload_2
    //   30: if_icmpge -> 55
    //   33: aload_3
    //   34: iload_1
    //   35: aaload
    //   36: astore #4
    //   38: aload_0
    //   39: getfield aQs : Ljava/util/ArrayList;
    //   42: aload #4
    //   44: invokevirtual add : (Ljava/lang/Object;)Z
    //   47: pop
    //   48: iload_1
    //   49: iconst_1
    //   50: iadd
    //   51: istore_1
    //   52: goto -> 28
    //   55: return }
  
  private void p(File paramFile) {
    String str2 = RootApplication.getLaiqianPreferenceManager().Tx();
    String str3 = RootApplication.getLaiqianPreferenceManager().atm();
    File file2 = new File(paramFile.getParent(), "backup.decrypted");
    if (d.m(paramFile.getAbsolutePath(), file2.getAbsolutePath(), c.F(str2, str3)) != 1)
      Toast.makeText(getActivity(), "error decrypt file", 0).show(); 
    String str1 = file2.getParent();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(file2.getName());
    stringBuilder.append(".unzipped");
    stringBuilder.append(".db");
    File file1 = new File(str1, stringBuilder.toString());
    b b = new b(getActivity(), file2.getAbsolutePath(), file1.getAbsolutePath(), b.aQf);
    file2.delete();
    if (!b.aQh)
      Toast.makeText(getActivity(), "failed to uncompress file", 0).show(); 
    Toast.makeText(getActivity(), "success", 0).show();
    q(file1);
  }
  
  private void q(File paramFile) {}
  
  public void onActivityCreated(@Nullable Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), 17367043);
    Eh();
    Iterator iterator = this.aQs.iterator();
    while (iterator.hasNext())
      arrayAdapter.add(((File)iterator.next()).getPath()); 
    setListAdapter(arrayAdapter);
    getListView().setOnItemClickListener(new b(this));
    setListShown(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\debug\BackupFileDebugFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */