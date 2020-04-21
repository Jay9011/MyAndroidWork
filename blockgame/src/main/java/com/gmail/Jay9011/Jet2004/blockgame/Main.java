package com.gmail.Jay9011.Jet2004.blockgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btnInfo = findViewById(R.id.btnInfo);
        Button btnHowTo = findViewById(R.id.btnHowto);
        Button btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Start.class);
                startActivity(intent);
            }
        }); // end btnStart.setOnClickListener

        btnHowTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HowToPlay.class);
                startActivity(intent);
            }
        }); // end btnHowTo.setOnClickListener

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Info.class);
                startActivity(intent);
            }
        }); // end btnInfo.setOnClickListener

    } // end onCreate()
} // end Main
