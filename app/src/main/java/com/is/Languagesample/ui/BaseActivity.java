package com.is.Languagesample.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.is.Languagesample.util.LocaleHelper;

/**
 * This Base Activity is very useful to avoid repeating code :
 * Many apps has common functionality that is performed at all activities.
 * For example, initializing analytics service or even cross UI elements.
 * Having a base activity reuse the code efficiently and save maintaining time.
 * Its basic OO concept.
 *
 *  * Created by Islam on 10/12/2018.
 */
public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(LocaleHelper.onAttach(context));

    }
}
