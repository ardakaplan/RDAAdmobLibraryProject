package com.ardakaplan.rdaadmoblibrary;

import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import javax.inject.Inject;
import javax.inject.Singleton;

import static com.ardakaplan.rdaadmoblibrary.TestDeviceIDs.TEST_DEVICE_IDS;

/**
 * Created by Arda Kaplan on 31.03.2018 - 19:49
 * <p>
 * arda.kaplan09@gmail.com
 * <p>
 * www.ardakaplan.com
 */
@Singleton
public class AdmobHelper {

    private Context context;

    @Inject
    AdmobHelper(Context context) {

        this.context = context;
    }

    public void init(String adMobId) {

        MobileAds.initialize(context, adMobId);
    }

    public void startBannerAd(AdView adViewBanner) {

        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();

        for (String TEST_DEVICE_ID : TEST_DEVICE_IDS) {

            adRequestBuilder.addTestDevice(TEST_DEVICE_ID);
        }

        adViewBanner.loadAd(adRequestBuilder.build());
    }

//    public static FullScreenAdvert createFullScreenAdvert(Context context, String adID, AdListener adListener) {
//
//        if (isInitialized) {
//
//            return new FullScreenAdvert(context, adID, adListener);
//
//        } else {
//
////            RDALogger.warn("********First set adMobId***********");
//
//            return null;
//        }
//    }

//    public static RewardedVideoAdvert createRewardedVideoAdvert(Context context, String adID, RewardedVideoAdListener rewardedVideoAdListener) {
//
//        if (isInitialized) {
//
//            return new RewardedVideoAdvert(context, adID, rewardedVideoAdListener);
//
//        } else {
//
////            RDALogger.warn("********First set adMobId***********");
//
//            return null;
//        }
//    }
}