package com.example.android.firstaidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;

public class FirstAidActivity extends AppCompatActivity {
    int id;

    /*TODO
    1. MA WCZYTYWAĆ OPISY Z STRINGS.XML
    2. SFROMATOWAĆ TO ŁADNIE
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);
        String buttonId;
        /**
         * Sprawdzamy czy nasza aktywność jest "aktywna"
         * Jesli tak, to pobieramy do Stringa zawartość z identyfikatora przekazanego do tej aktywności
         * poprzez metodę putExtra() w klasie MainMenu.java.
         */
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                buttonId = null;
            } else {
                buttonId = extras.getString("id");
            }
        } else {
            buttonId = (String) savedInstanceState.getSerializable("id");
        }
        id = new Integer(buttonId);
        Log.v("LOG", "button id: " + id);
        /**
         * Powołujemy obiekty z pliku xmla
         */
        DocumentView nameTitle = (DocumentView) findViewById(R.id.title_name);
        DocumentView descriptionTitle = (DocumentView) findViewById(R.id.title_description);
        ImageView image = (ImageView) findViewById(R.id.title_image);
        /**
         * Pobieramy identyfikator za pomocą metody klasy Resource, która przyjmuje nazwę z pliku
         * strings.xml, folder zawierający dane pliki, oraz zawartość danego pliku.
         *  W przypadku działania na obiektcie:
         *  1. ImageView - pliki znajdują się w folderze     res/drawable
         *  2. TextView - dane znajdują się w pliku          res/values/strings.xml
         *
         * np.     <string name="title1">Wezwanie pogotowia</string>

         */
        int resImageId = this.getResources().getIdentifier("image" + id, "drawable", getPackageName());
        Log.v("LOG", "    resImageId: " + resImageId);
        try {
            if (image != null) {
                image.setImageResource(resImageId);
            }
        } catch (OutOfMemoryError outOfMemoryError) {
            Log.e("ERROR!!  ", "outOfMemoryError while reading image!");
        }
        int resNameTitleId = this.getResources().getIdentifier("title" + buttonId, "string", getPackageName());


        Log.v("LOG", "    resNameTitleId: " + resNameTitleId);
        if (nameTitle != null) {
            nameTitle.setText(getString(resNameTitleId));
        }

        int resDescriptionId = this.getResources().getIdentifier("des" + buttonId, "string", getPackageName());
        Log.v("LOG", "    resDescriptionId: " + resDescriptionId);
        if (descriptionTitle != null) {
            descriptionTitle.setText(getString(resDescriptionId));
        }


    }
}
