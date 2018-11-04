package com.is.Languagesample;

import android.app.Application;
import android.content.Context;

import com.is.Languagesample.data.PreferencesHelper;
import com.is.Languagesample.util.LocaleHelper;

public class App extends Application {

    public static Context mcontext;


    public App(Context context) {
        mcontext = context.getApplicationContext();
    }

    public App() {

    }
    @Override
    public void onCreate() {
        super.onCreate();


        if (PreferencesHelper.getLanguage(this).equals("ar"))

        {
            LocaleHelper.setLocale(this, "ar");

        } else

        {
            LocaleHelper.setLocale(this, "en");


        }

    }

    /**
     * we need to override attachBaseContext and call LocaleHelper.onAttach()
     * to initialize the locale settings in application.
     * @param context
     */
    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(LocaleHelper.onAttach(context, "ar"));
    }


}
