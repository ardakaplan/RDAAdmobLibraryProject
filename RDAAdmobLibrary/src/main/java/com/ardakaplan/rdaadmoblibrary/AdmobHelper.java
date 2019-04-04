package com.ardakaplan.rdaadmoblibrary;

import android.content.Context;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import javax.inject.Inject;
import javax.inject.Singleton;

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
    private String[] testDeviceIds;

    @Inject
    AdmobHelper(Context context) {

        this.context = context;
    }

    public void init(String[] testDeviceIds, String adMobId) {

        this.testDeviceIds = testDeviceIds;

        MobileAds.initialize(context, adMobId);
    }

    public void startBannerAd(AdView adViewBanner) {

        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();

        for (String TEST_DEVICE_ID : testDeviceIds) {

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