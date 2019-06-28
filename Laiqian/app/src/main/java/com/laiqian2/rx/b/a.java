package com.laiqian.rx.b;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.support.annotation.LayoutRes;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.laiqian.rx.util.a;
import io.reactivex.a.a;
import io.reactivex.a.b;
import io.reactivex.annotations.NonNull;
import io.reactivex.c.g;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a<E> extends BaseAdapter implements g<List<E>> {
  private static final String TAG = "a";
  
  private static final d dhI = new b();
  
  private final a<E> dhJ = a.R(Collections.emptyList());
  
  private final b<Long> dhK = new b();
  
  @SuppressLint({"UseSparseArrays"})
  private final HashMap<Integer, Integer> dhL = new HashMap();
  
  private c<E> dhM;
  
  private final d dhN;
  
  private final a<E> dhO;
  
  public a(@LayoutRes int paramInt, a<E> parama, c<E> paramc) { this(Collections.singletonMap(Integer.valueOf(0), Integer.valueOf(paramInt)), dhI, parama, paramc); }
  
  public a(Map<Integer, Integer> paramMap, d paramd, a<E> parama, c<E> paramc) {
    this.dhM = paramc;
    this.dhN = paramd;
    this.dhL.putAll(paramMap);
    this.dhO = parama;
    this.dhJ.aoK().b(new d(this, parama));
  }
  
  public a(Map<Integer, Integer> paramMap, d paramd, c<E> paramc) { this(paramMap, paramd, new c(), paramc); }
  
  public long aP(E paramE) { return this.dhO.aP(paramE); }
  
  public c<E> aoH() { return this.dhM; }
  
  public int getCount() { return this.dhJ.aoL().size(); }
  
  public E getItem(int paramInt) { return (E)this.dhJ.aoL().get(paramInt); }
  
  public long getItemId(int paramInt) { return aP(getItem(paramInt)); }
  
  public int getItemViewType(int paramInt) { return this.dhN.a(this, paramInt); }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    View view;
    Object object = getItem(paramInt);
    int i = getItemViewType(paramInt);
    if (paramView == null) {
      i = ((Integer)this.dhL.get(Integer.valueOf(i))).intValue();
      view = View.inflate(paramViewGroup.getContext(), i, null);
    } else {
      Long long = (Long)this.dhK.cY(paramView);
      view = paramView;
      if (long != null) {
        view = paramView;
        if (this.dhO.aP(object) == long.longValue()) {
          a a3 = this.dhK.a(long, paramView);
          view = paramView;
          if (a3 != null) {
            view = paramView;
            if (a3.size() != 0)
              return paramView; 
          } 
        } 
      } 
    } 
    a a1 = this.dhK.cX(view);
    if (a1 != null)
      a1.clear(); 
    long l = this.dhO.aP(object);
    a a2 = this.dhK.a(Long.valueOf(l), view);
    a1 = a2;
    if (a2 == null)
      a1 = new a(); 
    a1.clear();
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getView: binding rx for new item: ");
    stringBuilder.append(object);
    Log.d(str, stringBuilder.toString());
    b b1 = this.dhM.a(this, paramInt, view, paramViewGroup);
    if (b1 != null)
      a1.b(b1); 
    this.dhK.a(Long.valueOf(l), view, a1);
    return view;
  }
  
  public int getViewTypeCount() { return this.dhL.size(); }
  
  @MainThread
  public void r(@NonNull List<E> paramList) throws Exception {
    if (!Thread.currentThread().equals(Looper.getMainLooper().getThread()))
      throw new IllegalStateException("must be called in main thread"); 
    this.dhJ.r(paramList);
    notifyDataSetChanged();
  }
  
  public static interface a<E> {
    long aP(E param1E);
  }
  
  private static class b<E> extends Object {
    private final Map<E, Map<View, a>> dhR = new ConcurrentHashMap();
    
    private final Map<View, E> dhS = new ConcurrentHashMap();
    
    @Nullable
    a a(@NonNull E param1E, @NonNull View param1View) {
      param1E = (E)(Map)this.dhR.get(param1E);
      return (param1E != null) ? (a)param1E.get(param1View) : null;
    }
    
    void a(@NonNull E param1E, @NonNull View param1View, @NonNull a param1a) {
      this.dhS.put(param1View, param1E);
      if (this.dhR.containsKey(param1E)) {
        ((Map)this.dhR.get(param1E)).put(param1View, param1a);
        return;
      } 
      ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
      concurrentHashMap.put(param1View, param1a);
      this.dhR.put(param1E, concurrentHashMap);
    }
    
    Collection<a> aR(@NonNull E param1E) {
      param1E = (E)(Map)this.dhR.get(param1E);
      return (param1E != null) ? Collections.unmodifiableCollection(param1E.values()) : Collections.emptyList();
    }
    
    @Nullable
    a cX(@NonNull View param1View) {
      Object object = this.dhS.get(param1View);
      return (object != null) ? a(object, param1View) : null;
    }
    
    @Nullable
    E cY(@NonNull View param1View) { return (E)this.dhS.get(param1View); }
    
    void remove(@NonNull E param1E) {
      Iterator iterator = this.dhS.entrySet().iterator();
      while (iterator.hasNext()) {
        if (((Map.Entry)iterator.next()).getValue().equals(param1E))
          iterator.remove(); 
      } 
      this.dhR.remove(param1E);
    }
  }
  
  public static interface c<E> {
    @Nullable
    b a(a<E> param1a, int param1Int, @NonNull View param1View1, View param1View2);
  }
  
  public static interface d<E> {
    int a(a<E> param1a, int param1Int);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\rx\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */