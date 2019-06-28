package com.laiqian.member.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.entity.g;
import com.laiqian.member.b.b;
import com.laiqian.pos.settings.aa;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.container.LayoutLeftTextRightCheckbox;
import com.laiqian.ui.container.LayoutLeftTextRightTextWithDialog;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.recycleview.LineGridViewPadding;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import io.reactivex.android.b.a;
import io.reactivex.g.a;
import io.reactivex.h;
import io.reactivex.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class VipLevelSettingFragment extends Fragment implements as, aa {
  private a bCj;
  
  aj bCk;
  
  private List<g> bCl;
  
  private void Ek() { a.a(this.bCj).setOnCheckedChangeListener(new ag(this)); }
  
  public static VipLevelSettingFragment RB() {
    VipLevelSettingFragment vipLevelSettingFragment = new VipLevelSettingFragment();
    vipLevelSettingFragment.setArguments(new Bundle());
    return vipLevelSettingFragment;
  }
  
  private void initData() {
    if (TextUtils.isEmpty(a.AZ().Bt()))
      a.AZ().bS(n.a((String[])n.a(getActivity(), b.bwW).toArray(new String[0]), 0)); 
    h.a(ad.bet).d(a.aKh()).c(a.aJo()).b(new ae(this));
  }
  
  public boolean Az() { return false; }
  
  public void Em() {
    a.b(this.bCj).setVisibility(0);
    a.c(this.bCj).setVisibility(8);
  }
  
  public void RA() {
    a.b(this.bCj).setVisibility(8);
    a.c(this.bCj).setVisibility(0);
  }
  
  public void Rz() {
    a.b(this.bCj).setVisibility(0);
    a.c(this.bCj).setVisibility(8);
  }
  
  public void a(aa paramaa) {}
  
  public void hideProgress() {
    a.b(this.bCj).setVisibility(8);
    a.c(this.bCj).setVisibility(0);
  }
  
  public void onCreate(Bundle paramBundle) { super.onCreate(paramBundle); }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) { return paramLayoutInflater.inflate(R.layout.fragment_vip_level_setting, paramViewGroup, false); }
  
  public void onResume() {
    super.onResume();
    initData();
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    this.bCj = new a(getView(), getActivity());
    Em();
    this.bCk = new aj(getActivity(), this);
  }
  
  public void save() {}
  
  public void showError(@NotNull String paramString) {
    if (paramString != null)
      Toast.makeText(getActivity(), paramString, 0).show(); 
  }
  
  public ArrayList<Integer> v(List<g> paramList) {
    ArrayList arrayList = new ArrayList();
    if (paramList != null) {
      Iterator iterator = paramList.iterator();
      while (iterator.hasNext())
        arrayList.add(Integer.valueOf(((g)iterator.next()).getNumber())); 
    } 
    return arrayList;
  }
  
  public boolean zP() { return false; }
  
  static class a {
    private View aQG;
    
    private ProgressBarCircularIndeterminate bAA;
    
    private LayoutLeftTextRightTextWithDialog bBt;
    
    private LayoutLeftTextRightCheckbox bCp;
    
    private LineGridViewPadding bCq;
    
    private View bCr;
    
    private Context mContext;
    
    public a(View param1View, Context param1Context) {
      this.aQG = param1View;
      this.mContext = param1Context;
      initView();
    }
    
    private void initView() {
      this.bCp = (LayoutLeftTextRightCheckbox)this.aQG.findViewById(R.id.member_auto_upgrade);
      this.bCp.setChecked(a.AZ().Bs());
      this.bBt = (LayoutLeftTextRightTextWithDialog)this.aQG.findViewById(R.id.member_level_upgrade_rule);
      this.bCq = (LineGridViewPadding)this.aQG.findViewById(R.id.member_grade_list);
      this.bCq.ll(0);
      this.bCr = this.aQG.findViewById(R.id.ll_content);
      this.bAA = (ProgressBarCircularIndeterminate)this.aQG.findViewById(R.id.ivProgress);
      RC();
    }
    
    public void RC() {
      if (a.AZ().Bs()) {
        this.bBt.setVisibility(0);
        this.bCp.setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
        String str2 = a.AZ().Bt();
        LayoutLeftTextRightTextWithDialog layoutLeftTextRightTextWithDialog = this.bBt;
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
          str1 = this.mContext.getString(R.string.pos_add_member_level_upgrade_rule_first); 
        layoutLeftTextRightTextWithDialog.oX(str1);
        return;
      } 
      this.bBt.setVisibility(8);
      this.bCp.setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
    }
  }
  
  static class b {
    private TextView bCs;
    
    private TextView bCt;
    
    private TextView bCu;
    
    private TextView bCv;
    
    private TextView bCw;
    
    private View mView;
  }
  
  static class c {
    View mView;
  }
  
  static class d {
    View mView;
  }
  
  private class e extends BaseAdapter {
    private List<g> bCx;
    
    private Context mContext;
    
    public e(VipLevelSettingFragment this$0, Context param1Context, List<g> param1List) {
      this.bCx = param1List;
      this.mContext = param1Context;
    }
    
    public g fM(int param1Int) {
      int i = getItemViewType(param1Int);
      return (i == 1 || i == 2) ? null : (g)this.bCx.get(param1Int - 1);
    }
    
    public int getCount() { return (this.bCx == null) ? 0 : (this.bCx.size() + 2); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public int getItemViewType(int param1Int) { return (param1Int == 0) ? 1 : ((param1Int == this.bCx.size() + 1) ? 2 : super.getItemViewType(param1Int)); }
    
    @SuppressLint({"StringFormatInvalid"})
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) { // Byte code:
      //   0: aload_0
      //   1: iload_1
      //   2: invokevirtual getItemViewType : (I)I
      //   5: istore #4
      //   7: aconst_null
      //   8: astore #6
      //   10: aload_2
      //   11: ifnonnull -> 245
      //   14: iload #4
      //   16: tableswitch default -> 40, 1 -> 204, 2 -> 165
      //   40: new com/laiqian/member/setting/VipLevelSettingFragment$b
      //   43: dup
      //   44: invokespecial <init> : ()V
      //   47: astore #6
      //   49: aload_0
      //   50: getfield mContext : Landroid/content/Context;
      //   53: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
      //   56: getstatic com/laiqian/vip/R$layout.item_member_grade_list_content : I
      //   59: aconst_null
      //   60: invokevirtual inflate : (ILandroid/view/ViewGroup;)Landroid/view/View;
      //   63: astore_2
      //   64: aload #6
      //   66: aload_2
      //   67: invokestatic a : (Lcom/laiqian/member/setting/VipLevelSettingFragment$b;Landroid/view/View;)Landroid/view/View;
      //   70: pop
      //   71: aload #6
      //   73: aload_2
      //   74: getstatic com/laiqian/vip/R$id.tv_level_base_class : I
      //   77: invokevirtual findViewById : (I)Landroid/view/View;
      //   80: checkcast android/widget/TextView
      //   83: invokestatic a : (Lcom/laiqian/member/setting/VipLevelSettingFragment$b;Landroid/widget/TextView;)Landroid/widget/TextView;
      //   86: pop
      //   87: aload #6
      //   89: aload_2
      //   90: getstatic com/laiqian/vip/R$id.tv_level_name : I
      //   93: invokevirtual findViewById : (I)Landroid/view/View;
      //   96: checkcast android/widget/TextView
      //   99: invokestatic b : (Lcom/laiqian/member/setting/VipLevelSettingFragment$b;Landroid/widget/TextView;)Landroid/widget/TextView;
      //   102: pop
      //   103: aload #6
      //   105: aload_2
      //   106: getstatic com/laiqian/vip/R$id.tv_level_base_discount : I
      //   109: invokevirtual findViewById : (I)Landroid/view/View;
      //   112: checkcast android/widget/TextView
      //   115: invokestatic c : (Lcom/laiqian/member/setting/VipLevelSettingFragment$b;Landroid/widget/TextView;)Landroid/widget/TextView;
      //   118: pop
      //   119: aload #6
      //   121: aload_2
      //   122: getstatic com/laiqian/vip/R$id.tv_level_base_point : I
      //   125: invokevirtual findViewById : (I)Landroid/view/View;
      //   128: checkcast android/widget/TextView
      //   131: invokestatic d : (Lcom/laiqian/member/setting/VipLevelSettingFragment$b;Landroid/widget/TextView;)Landroid/widget/TextView;
      //   134: pop
      //   135: aload #6
      //   137: aload_2
      //   138: getstatic com/laiqian/vip/R$id.tv_level_auto_upgrade : I
      //   141: invokevirtual findViewById : (I)Landroid/view/View;
      //   144: checkcast android/widget/TextView
      //   147: invokestatic e : (Lcom/laiqian/member/setting/VipLevelSettingFragment$b;Landroid/widget/TextView;)Landroid/widget/TextView;
      //   150: pop
      //   151: aload_2
      //   152: aload #6
      //   154: invokevirtual setTag : (Ljava/lang/Object;)V
      //   157: aconst_null
      //   158: astore_3
      //   159: aload_3
      //   160: astore #5
      //   162: goto -> 309
      //   165: new com/laiqian/member/setting/VipLevelSettingFragment$c
      //   168: dup
      //   169: invokespecial <init> : ()V
      //   172: astore_3
      //   173: aload_0
      //   174: getfield mContext : Landroid/content/Context;
      //   177: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
      //   180: getstatic com/laiqian/vip/R$layout.item_member_grade_list_footer : I
      //   183: aconst_null
      //   184: invokevirtual inflate : (ILandroid/view/ViewGroup;)Landroid/view/View;
      //   187: astore_2
      //   188: aload_3
      //   189: aload_2
      //   190: putfield mView : Landroid/view/View;
      //   193: aload_2
      //   194: aload_3
      //   195: invokevirtual setTag : (Ljava/lang/Object;)V
      //   198: aconst_null
      //   199: astore #5
      //   201: goto -> 309
      //   204: new com/laiqian/member/setting/VipLevelSettingFragment$d
      //   207: dup
      //   208: invokespecial <init> : ()V
      //   211: astore #5
      //   213: aload_0
      //   214: getfield mContext : Landroid/content/Context;
      //   217: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
      //   220: getstatic com/laiqian/vip/R$layout.item_member_grade_list_header : I
      //   223: aconst_null
      //   224: invokevirtual inflate : (ILandroid/view/ViewGroup;)Landroid/view/View;
      //   227: astore_2
      //   228: aload #5
      //   230: aload_2
      //   231: putfield mView : Landroid/view/View;
      //   234: aload_2
      //   235: aload #5
      //   237: invokevirtual setTag : (Ljava/lang/Object;)V
      //   240: aconst_null
      //   241: astore_3
      //   242: goto -> 309
      //   245: iload #4
      //   247: tableswitch default -> 268, 1 -> 297, 2 -> 286
      //   268: aload_2
      //   269: invokevirtual getTag : ()Ljava/lang/Object;
      //   272: checkcast com/laiqian/member/setting/VipLevelSettingFragment$b
      //   275: astore #6
      //   277: aconst_null
      //   278: astore #5
      //   280: aload #5
      //   282: astore_3
      //   283: goto -> 309
      //   286: aload_2
      //   287: invokevirtual getTag : ()Ljava/lang/Object;
      //   290: checkcast com/laiqian/member/setting/VipLevelSettingFragment$c
      //   293: astore_3
      //   294: goto -> 198
      //   297: aload_2
      //   298: invokevirtual getTag : ()Ljava/lang/Object;
      //   301: checkcast com/laiqian/member/setting/VipLevelSettingFragment$d
      //   304: astore #5
      //   306: goto -> 240
      //   309: iload #4
      //   311: tableswitch default -> 332, 1 -> 498, 2 -> 460
      //   332: aload_0
      //   333: iload_1
      //   334: invokevirtual fM : (I)Lcom/laiqian/entity/g;
      //   337: astore #5
      //   339: aload #6
      //   341: invokestatic a : (Lcom/laiqian/member/setting/VipLevelSettingFragment$b;)Landroid/widget/TextView;
      //   344: astore_3
      //   345: new java/lang/StringBuilder
      //   348: dup
      //   349: invokespecial <init> : ()V
      //   352: astore #7
      //   354: aload #7
      //   356: iload_1
      //   357: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   360: pop
      //   361: aload #7
      //   363: ldc ''
      //   365: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   368: pop
      //   369: aload_3
      //   370: aload #7
      //   372: invokevirtual toString : ()Ljava/lang/String;
      //   375: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   378: aload #6
      //   380: invokestatic b : (Lcom/laiqian/member/setting/VipLevelSettingFragment$b;)Landroid/widget/TextView;
      //   383: aload #5
      //   385: invokevirtual EV : ()Ljava/lang/String;
      //   388: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   391: aload #6
      //   393: invokestatic c : (Lcom/laiqian/member/setting/VipLevelSettingFragment$b;)Landroid/widget/TextView;
      //   396: astore #7
      //   398: invokestatic AZ : ()Lcom/laiqian/d/a;
      //   401: invokevirtual Bx : ()Z
      //   404: ifeq -> 518
      //   407: new java/lang/StringBuilder
      //   410: dup
      //   411: invokespecial <init> : ()V
      //   414: astore_3
      //   415: aload_3
      //   416: aload_0
      //   417: getfield bCo : Lcom/laiqian/member/setting/VipLevelSettingFragment;
      //   420: getstatic com/laiqian/vip/R$string.pos_add_member_level_discount_template : I
      //   423: iconst_1
      //   424: anewarray java/lang/Object
      //   427: dup
      //   428: iconst_0
      //   429: aload #5
      //   431: invokevirtual EU : ()D
      //   434: invokestatic ba : (D)Ljava/lang/String;
      //   437: aastore
      //   438: invokevirtual getString : (I[Ljava/lang/Object;)Ljava/lang/String;
      //   441: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   444: pop
      //   445: aload_3
      //   446: ldc '%'
      //   448: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   451: pop
      //   452: aload_3
      //   453: invokevirtual toString : ()Ljava/lang/String;
      //   456: astore_3
      //   457: goto -> 529
      //   460: aload_3
      //   461: getfield mView : Landroid/view/View;
      //   464: aload_0
      //   465: getfield bCo : Lcom/laiqian/member/setting/VipLevelSettingFragment;
      //   468: invokevirtual getResources : ()Landroid/content/res/Resources;
      //   471: getstatic com/laiqian/vip/R$drawable.shape_color_bg_white_only_click : I
      //   474: invokevirtual getDrawable : (I)Landroid/graphics/drawable/Drawable;
      //   477: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
      //   480: aload_3
      //   481: getfield mView : Landroid/view/View;
      //   484: new com/laiqian/member/setting/ah
      //   487: dup
      //   488: aload_0
      //   489: iload_1
      //   490: invokespecial <init> : (Lcom/laiqian/member/setting/VipLevelSettingFragment$e;I)V
      //   493: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   496: aload_2
      //   497: areturn
      //   498: aload #5
      //   500: getfield mView : Landroid/view/View;
      //   503: iconst_0
      //   504: invokevirtual setEnabled : (Z)V
      //   507: aload #5
      //   509: getfield mView : Landroid/view/View;
      //   512: iconst_m1
      //   513: invokevirtual setBackgroundColor : (I)V
      //   516: aload_2
      //   517: areturn
      //   518: aload_0
      //   519: getfield bCo : Lcom/laiqian/member/setting/VipLevelSettingFragment;
      //   522: getstatic com/laiqian/vip/R$string.pos_vip_price : I
      //   525: invokevirtual getString : (I)Ljava/lang/String;
      //   528: astore_3
      //   529: aload #7
      //   531: aload_3
      //   532: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   535: aload #6
      //   537: invokestatic d : (Lcom/laiqian/member/setting/VipLevelSettingFragment$b;)Landroid/widget/TextView;
      //   540: astore_3
      //   541: aload_0
      //   542: getfield bCo : Lcom/laiqian/member/setting/VipLevelSettingFragment;
      //   545: astore #7
      //   547: getstatic com/laiqian/vip/R$string.pos_add_member_level_point_template : I
      //   550: istore #4
      //   552: aload #5
      //   554: invokevirtual ER : ()Landroid/util/Pair;
      //   557: getfield second : Ljava/lang/Object;
      //   560: checkcast java/lang/Number
      //   563: invokestatic e : (Ljava/lang/Number;)Ljava/lang/String;
      //   566: astore #8
      //   568: new java/lang/StringBuilder
      //   571: dup
      //   572: invokespecial <init> : ()V
      //   575: astore #9
      //   577: aload #9
      //   579: aload #5
      //   581: invokevirtual ER : ()Landroid/util/Pair;
      //   584: getfield first : Ljava/lang/Object;
      //   587: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   590: pop
      //   591: aload #9
      //   593: ldc ''
      //   595: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   598: pop
      //   599: aload_3
      //   600: aload #7
      //   602: iload #4
      //   604: iconst_2
      //   605: anewarray java/lang/Object
      //   608: dup
      //   609: iconst_0
      //   610: aload #8
      //   612: aastore
      //   613: dup
      //   614: iconst_1
      //   615: aload #9
      //   617: invokevirtual toString : ()Ljava/lang/String;
      //   620: aastore
      //   621: invokevirtual getString : (I[Ljava/lang/Object;)Ljava/lang/String;
      //   624: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   627: aload #6
      //   629: invokestatic e : (Lcom/laiqian/member/setting/VipLevelSettingFragment$b;)Landroid/widget/TextView;
      //   632: astore #7
      //   634: aload #5
      //   636: invokevirtual EQ : ()Z
      //   639: ifeq -> 694
      //   642: aload_0
      //   643: getfield mContext : Landroid/content/Context;
      //   646: getstatic com/laiqian/member/b/b.bwX : [I
      //   649: invokestatic a : (Landroid/content/Context;[I)Ljava/util/List;
      //   652: iconst_0
      //   653: anewarray java/lang/String
      //   656: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
      //   661: checkcast [Ljava/lang/String;
      //   664: aload #5
      //   666: invokevirtual ES : ()I
      //   669: invokestatic a : ([Ljava/lang/String;I)Ljava/lang/String;
      //   672: iconst_1
      //   673: anewarray java/lang/Object
      //   676: dup
      //   677: iconst_0
      //   678: aload #5
      //   680: invokevirtual ET : ()D
      //   683: invokestatic ba : (D)Ljava/lang/String;
      //   686: aastore
      //   687: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   690: astore_3
      //   691: goto -> 698
      //   694: ldc_w '--'
      //   697: astore_3
      //   698: aload #7
      //   700: aload_3
      //   701: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   704: iload_1
      //   705: iconst_2
      //   706: irem
      //   707: ifne -> 734
      //   710: aload #6
      //   712: invokestatic f : (Lcom/laiqian/member/setting/VipLevelSettingFragment$b;)Landroid/view/View;
      //   715: aload_0
      //   716: getfield bCo : Lcom/laiqian/member/setting/VipLevelSettingFragment;
      //   719: invokevirtual getResources : ()Landroid/content/res/Resources;
      //   722: getstatic com/laiqian/vip/R$drawable.shape_color_bg_white_only_click : I
      //   725: invokevirtual getDrawable : (I)Landroid/graphics/drawable/Drawable;
      //   728: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
      //   731: goto -> 755
      //   734: aload #6
      //   736: invokestatic f : (Lcom/laiqian/member/setting/VipLevelSettingFragment$b;)Landroid/view/View;
      //   739: aload_0
      //   740: getfield bCo : Lcom/laiqian/member/setting/VipLevelSettingFragment;
      //   743: invokevirtual getResources : ()Landroid/content/res/Resources;
      //   746: getstatic com/laiqian/vip/R$drawable.shape_color_bg_gray_only_click : I
      //   749: invokevirtual getDrawable : (I)Landroid/graphics/drawable/Drawable;
      //   752: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
      //   755: aload #6
      //   757: invokestatic f : (Lcom/laiqian/member/setting/VipLevelSettingFragment$b;)Landroid/view/View;
      //   760: new com/laiqian/member/setting/ai
      //   763: dup
      //   764: aload_0
      //   765: aload #5
      //   767: iload_1
      //   768: invokespecial <init> : (Lcom/laiqian/member/setting/VipLevelSettingFragment$e;Lcom/laiqian/entity/g;I)V
      //   771: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   774: aload_2
      //   775: areturn }
    
    public int getViewTypeCount() { return 3; }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\VipLevelSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */