package com.flyco.tablayoutsamples.ui;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.flyco.tablayoutsamples.R;
public class ScrollFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public ScrollFragment() {

    }
    public static ScrollFragment newInstance(String param1) {
        ScrollFragment fragment = new ScrollFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_scroll, container, false);
        TextView tvTitle=view.findViewById(R.id.tvTitle);
        tvTitle.setText(mParam1);
        return view;
    }
}
