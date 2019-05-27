package com.cdc.fragmentdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements UpFragment.OnFragmentInteractionListener {
    // This is the down fragment place holder id.
    private final static int DOWN_FRAGMENT_ID = R.id.down_fragment;
    // This is the text fragment object.
    private TextFragment textFragment = null;
    // This is the image fragment object.
    private ImageFragment imageFragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Android Fragment交互");
        initControls();
    }
    /* Override method in UpFragment.OnFragmentInteractionListener interface. */
    @Override
    public void onTextSeekBarChange(float seekbarValue) {

        // Replace the down fragment with textFragment.
        replaceFragment(textFragment, DOWN_FRAGMENT_ID);

        // Invoke text fragment method to zoom in / out text size.
        textFragment.changeTextSize(seekbarValue);
    }
    @Override
    public void onImageSeekBarChange(float seekbarValue) {
        // Replace the down fragment with imageFragment.
        replaceFragment(imageFragment, DOWN_FRAGMENT_ID);
        // Invoke image fragment method to rotate the image.
        imageFragment.rotateImage(seekbarValue);
    }


    private void initControls() {
        if (textFragment == null) {
            textFragment = new TextFragment();
        }
        if (imageFragment == null) {
            imageFragment = new ImageFragment();
        }
        // Display text fragment at down_fragment.
        replaceFragment(imageFragment, DOWN_FRAGMENT_ID);
    }

    // Use destination fragment to replace the fragment displayed in fragment_layout_holder_id.
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


}
