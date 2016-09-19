package com.example.android.firstaidapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Jakub on 2016-03-16.
 */
public class Localization extends Activity {
    int id = 0;
    RadioGroup radioGroup;
    RadioButton przychodniaBox, szpitalBox, lekarzBox, aptekaBox;

    /**
     * TODO
     * 1. Jeśli wciśniemy jeden CheckBox, żaden inny nie może zostać wciśnięty!
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localization);
        toastShow();
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        przychodniaBox = (RadioButton) findViewById(R.id.przychodnia_check);
        szpitalBox = (RadioButton) findViewById(R.id.szpital_check);
        lekarzBox = (RadioButton) findViewById(R.id.lekarz_check);
        aptekaBox = (RadioButton) findViewById(R.id.apteka_check);


        radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        // find which radio button is selected
                        if (checkedId == R.id.przychodnia_check) {
                            id = 1;
                            Toast.makeText(getApplicationContext(), "choice: Przychodnia",
                                    Toast.LENGTH_SHORT).show();
                        } else if (checkedId == R.id.szpital_check) {
                            id = 2;
                            Toast.makeText(getApplicationContext(), "choice: Szpital",
                                    Toast.LENGTH_SHORT).show();
                        } else if (checkedId == R.id.lekarz_check) {
                            id = 3;
                            Toast.makeText(getApplicationContext(), "choice: Lekarz",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            id = 4;
                            Toast.makeText(getApplicationContext(), "choice: Apteka",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }

        );
    }


    private void toastShow() {
        Context context = getApplicationContext();
        CharSequence text = "Zlokalizujmy!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


    public void onLocalizationButtonClick(View view) {
        String option = "";
        switch (id) {
            case 1:
                option = "Przychodnia ";
                Log.i("ID in switch: ", option);
                break;
            case 2:
                option = "Szpital ";
                Log.i("ID in switch: ", option);
                break;
            case 3:
                option = "Lekarz ";
                Log.i("ID in switch: ", option);
                break;
            case 4:
                option = "Apteka ";
                Log.i("ID in switch: ", option);
                break;
            default:
                Log.e("Wrong ID in: ", " << getIdOfRadioButton >> ");
                break;
        }

        String city = "";
        EditText cityEdit = (EditText) findViewById(R.id.city_edit);
        city = "geo:0,0?q=";
        city = city + option + cityEdit.getText().toString();
        Uri gmmIntentUri = Uri.parse(city);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

}

