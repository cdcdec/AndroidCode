package com.cdc.fragmentdemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

public class UpFragment extends Fragment implements SeekBar.OnSeekBarChangeListener{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    // The text seekbar.
    private SeekBar textSeekBar = null;

    // The image seekbar.
    private SeekBar imageSeekBar = null;

    public UpFragment() {

    }
    public static UpFragment newInstance(String param1, String param2) {
        UpFragment fragment = new UpFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_up, container, false);

        if(textSeekBar == null)
        {
            textSeekBar = (SeekBar)fragmentView.findViewById(R.id.text_seek_bar);
            textSeekBar.setOnSeekBarChangeListener(this);
        }

        if(imageSeekBar == null)
        {
            imageSeekBar = (SeekBar)fragmentView.findViewById(R.id.image_seek_bar);
            imageSeekBar.setOnSeekBarChangeListener(this);
        }
        return fragmentView;
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

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int seekBarId = seekBar.getId();
        if(seekBarId == R.id.text_seek_bar)
        {
            // If slide the text seekbar then invoke activity's onTextSeekBar method.
            mListener.onTextSeekBarChange(progress);
        }else if(seekBarId == R.id.image_seek_bar)
        {
            // If slide the image seekbar then invoke activity's onImageSeekBar mtehod.
            mListener.onImageSeekBarChange(progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public interface OnFragmentInteractionListener {
        void onTextSeekBarChange(float seekbarValue);
        void onImageSeekBarChange(float seekbarValue);
    }
}
