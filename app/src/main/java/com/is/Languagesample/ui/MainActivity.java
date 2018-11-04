package com.is.Languagesample.ui;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.is.Languagesample.R;
import com.is.Languagesample.data.PreferencesHelper;
import com.is.Languagesample.util.LocaleHelper;

/**
 * @author Islam Elshnawey
 */
public class MainActivity extends BaseActivity{

    private Spinner spinner;

    private String currentlanguage;

    private int check = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinnerLanguage);
        currentlanguage = PreferencesHelper.getLanguage(this);
        setTitle(getString(R.string.app_name));
        setupAppLanguageSpinner();

    }



    // app language
    private void setupAppLanguageSpinner() {

        // check current language and then make it selected
        Toast.makeText(this, currentlanguage, Toast.LENGTH_SHORT).show();
        if (currentlanguage.equals("ar")) {

            spinner.setSelection(0);
        } else {
            spinner.setSelection(1);
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // changing color of selected
                ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#36abe5"));

                if (++check > 1) {

                    if (position == 0) {
                        PreferencesHelper.setLanguage(MainActivity.this, "ar");
                        LocaleHelper.setLocale(MainActivity.this, "ar");
                        // after changing language we should refresh activity
                        finish();
                        startActivity(getIntent());

                    } else if (position == 1) {
                        PreferencesHelper.setLanguage(MainActivity.this, "en");
                        LocaleHelper.setLocale(MainActivity.this, "en");

                        finish();
                        startActivity(getIntent());

                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

    }
}
