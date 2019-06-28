package com.laiqian.print;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.laiqian.basic.RootApplication;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.print.printtype.f;
import com.laiqian.print.usage.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class j {
  public static final j cCx = new j(RootApplication.zv());
  
  List<h> cCy = new ArrayList();
  
  private final Context context;
  
  public j(Context paramContext) { this.context = paramContext; }
  
  public List<e> a(Object paramObject, String... paramVarArgs) throws Exception {
    ArrayList arrayList1 = new ArrayList();
    ArrayList arrayList2 = c.bi(this.context).afs();
    Class clazz = paramObject.getClass();
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++) {
      String str = paramVarArgs[b];
      Iterator iterator = this.cCy.iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        h h = (h)iterator.next();
        if (h.a(clazz, str)) {
          f f = ((a.b)h.yz().b(new a.a(clazz, str))).cCz;
          k k = h.yB();
          for (ac ac : arrayList2) {
            if (k.a(ac, clazz, str)) {
              i i1 = ((b.b)h.yy().b(new b.a(str, ac))).cCB;
              List list = h.yA().a(paramObject, str, i1, f);
              h.a a = h.b(clazz, str);
              if (a == null) {
                arrayList1.add(g.cGS.f(ac.aew()).D(list));
                continue;
              } 
              arrayList1.addAll(a.a(ac, i1, list));
            } 
          } 
          bool = true;
        } 
      } 
      if (!bool) {
        paramObject = new StringBuilder();
        paramObject.append("not match for ");
        paramObject.append(clazz.getSimpleName());
        paramObject.append(", ");
        paramObject.append(str);
        paramObject.append(", did you register plugin?");
        throw new RuntimeException(paramObject.toString());
      } 
    } 
    return arrayList1;
  }
  
  public void a(@NonNull h paramh) { this.cCy.add(paramh); }
  
  class j {}
  
  class j {}
  
  class j {}
  
  class j {}
  
  public static interface e {
    j.a yz();
  }
  
  class j {}
  
  public static interface g {
    j.f yA();
  }
  
  public static interface h extends e, g, j, l {
    boolean a(Class param1Class, String param1String);
    
    @Nullable
    a b(Class param1Class, String param1String);
    
    class h {}
  }
  
  class j {}
  
  class j {}
  
  public static interface j {
    j.b yy();
  }
  
  class j {}
  
  public static interface l {
    j.k yB();
  }
  
  class j {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\print\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */