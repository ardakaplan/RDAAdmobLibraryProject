package com.ardakaplan.rdaadmoblibraryproject.di;

import com.ardakaplan.rdaadmoblibraryproject.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

}
