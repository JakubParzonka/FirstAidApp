package com.example.android.firstaidapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Call extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        toastShow();
    }

    private void toastShow() {
        Context context = getApplicationContext();
        CharSequence text = "Wykonajmy połączenie!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void pogotowieRatunkoweCallButton(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Dzwonimy na pogotowie!!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        dialPhoneNumber("999");
    }

    public void strazPozarnaCallButton(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Dzwonimy na Straż Pożarną!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        dialPhoneNumber("998");
    }

    public void policjaCallButton(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Dzwonimy na Policję!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        dialPhoneNumber("997");
    }

    public void polaczenieRatunkoweCallButton(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Dzwonimy na połączenie alarmowe!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        dialPhoneNumber("112");
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
