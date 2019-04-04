package com.ardakaplan.rdaadmoblibrary;

import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Arda Kaplan on 10.07.2018 - 16:27
 */
@Singleton
public class FullScreenAdvert {

    private Context context;
    private InterstitialAd interstitialAd;
    private AdRequest.Builder adRequestBuilder;

    @Inject
    FullScreenAdvert(Context context) {
        this.context = context;
    }

    public void setup(String[] testDeviceIds, String adID, AdListener adListener) {

        interstitialAd = new InterstitialAd(context);

        interstitialAd.setAdUnitId(adID);

        adRequestBuilder = new AdRequest.Builder();

        for (String TEST_DEVICE_ID : testDeviceIds) {

            adRequestBuilder.addTestDevice(TEST_DEVICE_ID);
        }

        interstitialAd.setAdListener(adListener);
    }

    public void load() {

        interstitialAd.loadAd(adRequestBuilder.build());
    }

    public boolean show() {

        if (interstitialAd.isLoaded()) {

            interstitialAd.show();
        }

        return interstitialAd.isLoaded();
    }
}
