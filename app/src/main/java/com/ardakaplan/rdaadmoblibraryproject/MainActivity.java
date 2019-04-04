package com.ardakaplan.rdaadmoblibraryproject;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.ardakaplan.rdaadmoblibrary.AdmobHelper;
import com.ardakaplan.rdaadmoblibrary.FullScreenAdvert;
import com.ardakaplan.rdaadmoblibrary.TestDeviceIDs;
import com.ardakaplan.rdalibrary.base.ui.screen.RDAActivity;
import com.ardakaplan.rdalogger.RDALogger;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends RDAActivity {

    @BindView(R.id.adView)
    AdView mAdView;

    @Inject
    AdmobHelper admobHelper;

    @Inject
    FullScreenAdvert fullScreenAdvert;

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);

        admobHelper.init(TestDeviceIDs.getTestDeviceIds(), "ca-app-pub-5797080226538350~6368377047");

        admobHelper.startBannerAd(mAdView);

        fullScreenAdvert.setup(TestDeviceIDs.getTestDeviceIds(), "ca-app-pub-3940256099942544/1033173712", new AdListener() {

            @Override
            public void onAdLoaded() {

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                RDALogger.info("ERROR CODE " + errorCode);

                fullScreenAdvert.load();
            }

            @Override
            public void onAdOpened() {

                RDALogger.info("onAdOpened");
            }

            @Override
            public void onAdLeftApplication() {
                RDALogger.info("onAdLeftApplication");
            }

            @Override
            public void onAdClosed() {

                RDALogger.info("onAdClosed");

                fullScreenAdvert.load();
            }
        });

        fullScreenAdvert.load();
    }

    @OnClick(R.id.button)
    void clicked() {

        fullScreenAdvert.show();
    }
}
