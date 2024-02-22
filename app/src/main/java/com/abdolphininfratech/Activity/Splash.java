package com.abdolphininfratech.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;

import com.abdolphininfratech.Model.responseLogin.ResponseLogin;
import com.abdolphininfratech.R;
import com.abdolphininfratech.app.PreferencesManager;
import com.abdolphininfratech.common.NetworkUtils;
import com.abdolphininfratech.constants.BaseActivity;
import com.abdolphininfratech.retrofit.ApiServices;
import com.abdolphininfratech.retrofit.ServiceGenerator;
import com.bumptech.glide.Glide;
import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.AppUpdaterUtils;
import com.github.javiersantos.appupdater.enums.AppUpdaterError;
import com.github.javiersantos.appupdater.enums.Display;
import com.github.javiersantos.appupdater.enums.UpdateFrom;
import com.github.javiersantos.appupdater.objects.Update;
import com.scottyab.rootbeer.RootBeer;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splash extends BaseActivity {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.tv_version)
    TextView tvVersion;
    @BindView(R.id.card_next)
    Button card_next;

    public ApiServices apiServices, createServiceUtilityV2;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        ButterKnife.bind(this);
        apiServices = ServiceGenerator.createService(ApiServices.class);
        card_next.setVisibility(View.GONE);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Welcome");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);

        Animation aniSlide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        imageView.startAnimation(aniSlide);
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String version = pInfo.versionName;
//            tvVersion.setText(getString(R.string.version) + version);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Call<ResponseLogin> call = apiServices.GettownshipbookingDetails();
        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if(response.isSuccessful()&&response.body().getTotalBookingId()!=null){
                    tvVersion.setText(response.body().getTotalBookingId());
                }else{
                    tvVersion.setText("");
                }

            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {

            }
        });

        new Handler().postDelayed(() -> {
            card_next.setVisibility(View.VISIBLE);

        }, 5000);
            /*if (!PreferencesManager.getInstance(context).getUserId().equalsIgnoreCase("")) {
                goToActivityWithFinish(context, ContainerActivity.class, null);
            } else {
                goToActivityWithFinish(context, Login.class, null);
            }*/
        card_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkForSuBinary() || checkForBusyBoxBinary() || checkSuExists()) {

                    createExitDialog(context, "Rooted Device", "This device is rooted. You can't use this app.", true);
                } else {
                    if (NetworkUtils.getConnectivityStatus(context) != 0) {
                        Log.e("CURSOR","GJFGHF");
                        checkUpdate();
                    } else {

                        showMessage(getString(R.string.alert_internet));
                    }
                }
            }
        });


    }

    public void createExitDialog(Context context, String title,
                                 String msg, boolean isBack) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setTitle(title);
        builder1.setMessage(msg);
        builder1.setCancelable(true);

        builder1.setPositiveButton("OK", (dialog, which) -> {
            if (isBack)
                finishAffinity();
            dialog.cancel();
        });

//        builder1.setNegativeButton(
//                "Cancel",
//                (dialog, id) -> dialog.cancel());

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }


    private AppUpdater updater;

    private void checkUpdate() {
        AppUpdaterUtils appUpdaterUtils = new AppUpdaterUtils(this)
                .setUpdateFrom(UpdateFrom.GOOGLE_PLAY)
                .withListener(new AppUpdaterUtils.UpdateListener() {
                    @Override
                    public void onSuccess(Update update, Boolean isUpdateAvailable) {
                        Log.d("Latest Version", update.getLatestVersion());
                        Log.d("Latest Version Code", "=" + update.getLatestVersionCode());
                        Log.d("Release notes", update.getReleaseNotes());
                        Log.d("URL", "=" + update.getUrlToDownload());
                        Log.d("Is update available?", Boolean.toString(isUpdateAvailable));
                        if (isUpdateAvailable) {
                            if (updater == null) {
                                updater = new AppUpdater(context).setDisplay(Display.DIALOG);
                                updater.setContentOnUpdateAvailable("Update " + update.getLatestVersion() + " is available to download. Update the latest version of Abdolphin to get latest " +
                                        "features, improvements and bug fixes.");
                                updater.setButtonDoNotShowAgain("");
                                updater.setButtonDismiss("");
                                updater.setCancelable(false);
                            }
                            updater.start();
                        } else {
                            try {
                                PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                                String version = pInfo.versionName;
                                // tvVersion.setText(getString(R.string.version) + version);
                            } catch (PackageManager.NameNotFoundException e) {
                                e.printStackTrace();
                            }
                            if (PreferencesManager.getInstance(context).getUserId().equalsIgnoreCase("")) {
                                goToActivityWithFinish(context, Login.class, null);

                            } else
                                goToActivityWithFinish(context, ContainerActivity.class, null);


                        }
                    }

                    @Override
                    public void onFailed(AppUpdaterError error) {
                        Log.d("AppUpdater Error", "Something went wrong");
                    }
                });
        appUpdaterUtils.start();
    }

    private boolean isRooted() {
        boolean isRooted = false;
        RootBeer rootBeer = new RootBeer(context);
        if (rootBeer.isRooted()) {
            //we found indication of root
            isRooted = true;
        } else {
            isRooted = false;
            //we didn't find indication of root
        }
        return isRooted;
    }

    private boolean checkForSuBinary() {
        return checkForBinary("su"); // function is available below
    }

    private boolean checkForBusyBoxBinary() {
        return checkForBinary("busybox");//function is available below
    }

    private String[] binaryPaths = {
            "/data/local/",
            "/data/local/bin/",
            "/data/local/xbin/",
            "/sbin/",
            "/su/bin/",
            "/system/bin/",
            "/system/bin/.ext/",
            "/system/bin/failsafe/",
            "/system/sd/xbin/",
            "/system/usr/we-need-root/",
            "/system/xbin/",
            "/system/app/Superuser.apk",
            "/cache",
            "/data",
            "/dev"
    };

    private boolean checkForBinary(String filename) {
        for (String path : binaryPaths) {
            File f = new File(path, filename);
            boolean fileExists = f.exists();
            if (fileExists) {
                return true;
            }
        }
        return false;
    }

    private boolean checkSuExists() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[]
                    {"/system/xbin/which", "su"});
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line = in.readLine();
            process.destroy();
            return line != null;
        } catch (Exception e) {
            if (process != null) {
                process.destroy();
            }
            return false;
        }
    }
}
