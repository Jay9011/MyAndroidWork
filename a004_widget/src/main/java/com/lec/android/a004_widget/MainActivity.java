package com.lec.android.a004_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName, etPassword, etEmail, etNumber;
    TextView tvName, tvPassword, tvEmail, tvNumber, tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        etNumber = findViewById(R.id.etNumber);

        tvName = findViewById(R.id.tvName);
        tvPassword = findViewById(R.id.tvPassword);
        tvEmail = findViewById(R.id.tvEmail);
        tvNumber = findViewById(R.id.tvNumber);
        tvResult = findViewById(R.id.tvResult);

        // 포커스 변화
        etName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            // hasFocus : 포커스 받은 경우 - true / 포커스를 잃으면 - false
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    ((EditText)v).setBackgroundColor(Color.YELLOW);
                    tvResult.setText("너의 이름은?");
                } else {
                    // 투명색
                    ((EditText)v).setBackgroundColor(Color.parseColor("#00000000"));
                    tvResult.setText("");
                }
            }
        });

        // 키보드가 눌릴때
        etPassword.setOnKeyListener(new View.OnKeyListener() {
            // keyCode : 눌린 키의 코드값
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                tvResult.setText(((EditText)v).getText().toString());
                return false;
            }
        });

        // 값의 변화 (입력 완료)
        etEmail.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                tvResult.setText("입력완료 : " + actionId);
                return false;
            }
        });
    }
}
