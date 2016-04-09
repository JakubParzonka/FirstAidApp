package com.example.android.firstaidapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*
    TODO
     - Pełny ekran przy pierwszej aktywności

     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToast();
    }

    /**
     * Powołuję aktywność menu
     *
     * @param view
     */
    public void clickOnRedCross(View view) {
        Intent goToMainMenu = new Intent(this, MainMenu.class);
        startActivity(goToMainMenu);
    }

    private void showToast() {
        Context context = getApplicationContext();
        CharSequence text = "Dotknij znaku";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
