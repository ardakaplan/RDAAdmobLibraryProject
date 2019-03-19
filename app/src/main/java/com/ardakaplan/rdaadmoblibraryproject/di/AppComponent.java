package com.ardakaplan.rdaadmoblibraryproject.di;

import android.app.Application;

import com.ardakaplan.rdaadmoblibraryproject.TestApplication;
import com.ardakaplan.rdalibrary.di.RDABaseModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AndroidInjectionModule.class,
        AppModule.class,
        RDABaseModule.class,
        ActivityBuilder.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(TestApplication app);
}

