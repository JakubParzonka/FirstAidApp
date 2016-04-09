package com.example.android.firstaidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    int id;

    Intent goToCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    /**
     * Metody onClick obiektów Button. W zależności od klikniętego Buttona, parametrowi id zostaje
     * przypisany odpowiedni identyfikator, który jest przekazywany w metodzie putExtra()
     * do klasy obsługującej powoływaną aktywność -> FirstAidActivity.java
     *
     * @param view
     */
    public void oneButton(View view) {
        id = 1;
        goToCard = new Intent(MainMenu.this, FirstAidActivity.class);
        goToCard.putExtra("id", "" + id);
        startActivity(goToCard);
    }

    public void twoButton(View view) {
        id = 2;
        goToCard = new Intent(MainMenu.this, FirstAidActivity.class);
        goToCard.putExtra("id", "" + id);
        startActivity(goToCard);
    }

    public void threeButton(View view) {
        id = 3;
        goToCard = new Intent(MainMenu.this, FirstAidActivity.class);
        goToCard.putExtra("id", "" + id);
        startActivity(goToCard);
    }

    public void fourButton(View view) {
        id = 4;
        goToCard = new Intent(MainMenu.this, FirstAidActivity.class);
        goToCard.putExtra("id", "" + id);
        startActivity(goToCard);
    }

    public void fiveButton(View view) {
        id = 5;
        goToCard = new Intent(MainMenu.this, FirstAidActivity.class);
        goToCard.putExtra("id", "" + id);
        startActivity(goToCard);
    }

    public void sixButton(View view) {
        id = 6;
        goToCard = new Intent(MainMenu.this, FirstAidActivity.class);
        goToCard.putExtra("id", "" + id);
        startActivity(goToCard);
    }

    public void sevenButton(View view) {
        id = 7;
        goToCard = new Intent(MainMenu.this, FirstAidActivity.class);
        goToCard.putExtra("id", "" + id);
        startActivity(goToCard);
    }

    public void eightButton(View view) {
        id = 8;
        goToCard = new Intent(MainMenu.this, FirstAidActivity.class);
        goToCard.putExtra("id", "" + id);
        startActivity(goToCard);
    }

    public void nineButton(View view) {
        try {
            Intent goToLocalization = new Intent(this, Localization.class);
            startActivity(goToLocalization);
        } catch (Exception e) {
            Log.e("Wyjebało się na: ", " MainMenu.java   Powoływanie lokalizacji.");

        }
    }

    public void tenButton(View view) {

        try {
            Intent goToCall = new Intent(MainMenu.this, Call.class);
            startActivity(goToCall);
        } catch (Exception e) {
            Log.e("Wyjebało się na: ", " MainMenu.java   Powoływanie lokalizacji.");

        }

    }


    /*      @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            android.os.Process.killProcess(android.os.Process.myPid());
        }
        return super.onKeyDown(keyCode, event);
    }


    Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    */
}
