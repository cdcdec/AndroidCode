package com.cdc.fragmentdemo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.graphics.Matrix;
import android.graphics.Bitmap.Config;
public class ImageFragment extends Fragment {
    private ImageView imageView = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_image, container, false);
        // Get the imageview object.
        imageView = (ImageView) ret.findViewById(R.id.image_view);
        return ret;
    }

    /* Used to rotate the image. */
    public void rotateImage(float rotateAngel) {
        BitmapDrawable originalBitmapDrawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap originalBitmap = originalBitmapDrawable.getBitmap();
        int originalImageWith = originalBitmap.getWidth();
        int originalImageHeight = originalBitmap.getHeight();
        Config originalImageConfig = originalBitmap.getConfig();
        // Create a bitmap which has same width and height value of original bitmap.
        Bitmap rotateBitmap = Bitmap.createBitmap(originalImageWith, originalImageHeight, originalImageConfig);
        Canvas rotateCanvas = new Canvas(rotateBitmap);
        Matrix rotateMatrix = new Matrix();
        // Rotate around the center point of the original image.
        rotateMatrix.setRotate(rotateAngel, originalBitmap.getWidth() / 2, originalBitmap.getHeight() / 2);
        Paint paint = new Paint();
        rotateCanvas.drawBitmap(originalBitmap, rotateMatrix, paint);
        imageView.setImageBitmap(rotateBitmap);
    }


}
