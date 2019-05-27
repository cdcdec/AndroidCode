package com.cdc.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFragment extends Fragment {

    private TextView textView = null;

    public void changeTextSize(float textSize) {
        if (textView != null) {
            textView.setTextSize(textSize);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_text, container, false);
        // Get the textview object.
        textView = fragmentView.findViewById(R.id.text_view);
        return fragmentView;
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }
}
