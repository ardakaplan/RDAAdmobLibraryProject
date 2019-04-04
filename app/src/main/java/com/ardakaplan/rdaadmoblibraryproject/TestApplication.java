package com.ardakaplan.rdaadmoblibraryproject;

import com.ardakaplan.rdaadmoblibraryproject.di.AppComponent;
import com.ardakaplan.rdaadmoblibraryproject.di.DaggerAppComponent;
import com.ardakaplan.rdalibrary.base.objects.RDAApplication;
import com.ardakaplan.rdalibrary.di.HasCustomActivityInjector;
import com.ardakaplan.rdalogger.RDALogger;

/**
 * Created by Arda Kaplan at 3/19/2019
 * <p>
 * arda.kaplan09@gmail.com
 */
public class TestApplication extends RDAApplication implements HasCustomActivityInjector {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        RDALogger.start(getString(R.string.app_name)).enableLogging(true);
    }

    @Override
    protected void initDagger() {

        appComponent = DaggerAppComponent.builder().application(this).build();

        appComponent.inject(this);
    }
}