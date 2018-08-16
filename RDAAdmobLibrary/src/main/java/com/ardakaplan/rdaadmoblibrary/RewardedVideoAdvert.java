package com.ardakaplan.rdaadmoblibrary;

import android.content.Context;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import static com.ardakaplan.rdaadmoblibrary.TestDeviceIDs.TEST_DEVICE_IDS;

/**
 * Created by Arda Kaplan on 2.07.2018 - 16:23
 */
public class RewardedVideoAdvert {

    private RewardedVideoAd rewardedVideoAd;

    private AdRequest.Builder adRequestBuilder;

    private String adID;

    RewardedVideoAdvert(Context context, String adID, RewardedVideoAdListener rewardedVideoAdListener) {

        this.adID = adID;

        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(context);

        rewardedVideoAd.setRewardedVideoAdListener(rewardedVideoAdListener);

        adRequestBuilder = new AdRequest.Builder();

        for (String TEST_DEVICE_ID : TEST_DEVICE_IDS) {

            adRequestBuilder.addTestDevice(TEST_DEVICE_ID);
        }
    }

    public void load() {

        rewardedVideoAd.loadAd(adID, adRequestBuilder.build());
    }

    public boolean show() {

        if (rewardedVideoAd.isLoaded()) {

            rewardedVideoAd.show();
        }

        return rewardedVideoAd.isLoaded();
    }
}
