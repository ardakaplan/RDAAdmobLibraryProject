package com.ardakaplan.rdaadmoblibrary;

import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import static com.ardakaplan.rdaadmoblibrary.TestDeviceIDs.TEST_DEVICE_IDS;

/**
 * Created by Arda Kaplan on 10.07.2018 - 16:27
 */
public class FullScreenAdvert {

    private InterstitialAd interstitialAd;

    private AdRequest.Builder adRequestBuilder;

    FullScreenAdvert(Context context, String adID, AdListener adListener) {

        interstitialAd = new InterstitialAd(context);

        interstitialAd.setAdUnitId(adID);

        adRequestBuilder = new AdRequest.Builder();

        for (String TEST_DEVICE_ID : TEST_DEVICE_IDS) {

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
