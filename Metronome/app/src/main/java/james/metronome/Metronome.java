package james.metronome;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Metronome extends Application {

    private static final int VERSION_BILLING_API = 3;
    public static final int REQUEST_PURCHASE = 614;
    private ServiceConnection serviceConnection;

    private boolean isPremium=true;
    private boolean isNetworkError = true;
    private String price;

    @Override
    public void onCreate() {
        super.onCreate();


    }

    public void onCreateActivity() {

    }

    public void onDestroyActivity() {

    }

    public String getPrice() {
        return price != null ? price : getString(R.string.title_no_connection);
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void onPremium(final Activity activity) {
        if (!isPremium()) {
            View view = LayoutInflater.from(activity).inflate(R.layout.dialog_premium, null);
            Glide.with(this).load("https://theandroidmaster.github.io/images/headers/metronomePremium.png").into((ImageView) view.findViewById(R.id.image));

            new MaterialDialog.Builder(activity)
                    .customView(view, false)
                    .backgroundColor(Color.WHITE)
                    .cancelable(false)
                    .positiveText(getString(R.string.title_get_premium, getPrice()))
                    .positiveColor(ContextCompat.getColor(this, R.color.colorAccent))
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            buyPremium(activity);
                            dialog.dismiss();
                        }
                    })
                    .negativeText(R.string.title_use_anyway)
                    .negativeColor(ContextCompat.getColor(this, R.color.textColorSecondaryInverse))
                    .onNegative(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
        }
    }

    public void buyPremium(Activity activity) {


    }

    public void onPremiumBought(int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && data.hasExtra("INAPP_PURCHASE_DATA")) {
            try {
                    isPremium = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class GetPurchaseThread extends Thread {

        private WeakReference<Metronome> metronomeReference;
        private String packageName;
        private String sku;

        private String price;

        public GetPurchaseThread(Metronome metronome) {
            metronomeReference = new WeakReference<>(metronome);
            packageName = metronome.getPackageName();
        }

        @Override
        public void run() {

                }
    }
}
