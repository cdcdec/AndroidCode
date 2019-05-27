# Fragment


## FrameLayout与fragment标签

都是用来放Fragment的。区别是，fragment标签只能设置固定的Fragment，一定要设置某fragment名字;
而FrameLayout中可以通过FragmentManager更换Fragment

## 在xml布局中使用
```
<fragment
android:id="@+id/up_fragment"
android:layout_width="match_parent"
android:layout_height="0dp"
android:layout_weight="2"
android:name="com.cdc.fragmentdemo.UpFragment"
tools:layout="@layout/fragment_up" />

Fragment类

android:name="com.cdc.fragmentdemo.UpFragment"

tools:layout="@layout/fragment_up" 可以在ide中预览到界面

```


## FrameLayout

```
<FrameLayout
android:id="@+id/down_fragment"
android:layout_width="match_parent"
android:layout_height="0dp"
android:layout_weight="6"/>

 public void replaceFragment(Fragment destFragment, int fragment_layout_holder_id) {
        // Get FragmentManager object.
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        // Begin transaction.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Replace the layout holder with the required Fragment object.
        fragmentTransaction.replace(fragment_layout_holder_id, destFragment);
        // Commit transaction.
        fragmentTransaction.commit();
}

```


## 信息传递

1.Activity传递信息到Fragment
```
private static final String ARG_PARAM1 = "param1";
private static final String ARG_PARAM2 = "param2";
private String mParam1;
private String mParam2;

public BlankFragment() {
    // Required empty public constructor
}

public static BlankFragment newInstance(String param1, String param2) {
    BlankFragment fragment = new BlankFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    args.putString(ARG_PARAM2, param2);
    fragment.setArguments(args);
    return fragment;
}

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
        mParam1 = getArguments().getString(ARG_PARAM1);
        mParam2 = getArguments().getString(ARG_PARAM2);
    }
}

```

2.Fragment传递信息到Activity中
```
/**
 * 在Fragment中需要的地方调用 接口中的参数根据需要传递
 * @param uri
 */
public void onButtonPressed(Uri uri) {
    if (mListener != null) {
        mListener.onFragmentInteraction(uri);
    }
}

@Override
public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnFragmentInteractionListener) {
        mListener = (OnFragmentInteractionListener) context;
    } else {
        throw new RuntimeException(context.toString()
                + " must implement OnFragmentInteractionListener");
    }
}
@Override
public void onDetach() {
    super.onDetach();
    mListener = null;
}
private OnFragmentInteractionListener mListener;
/**
 * 在Fragment所在的Activity中实现此接口  用于将Fragment中的数据传递到Activity中
 */
public interface OnFragmentInteractionListener {
    // TODO: Update argument type and name
    void onFragmentInteraction(Uri uri);
}


```

