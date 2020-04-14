package com.lec.android.a002_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton Button1;
    TextView TargetText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear1);

        Button1 = (ToggleButton) findViewById(R.id.visibleButton);
        TargetText = (TextView) findViewById(R.id.textView3);


        Button1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    TargetText.setVisibility(View.VISIBLE);
                }else{
                    TargetText.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
