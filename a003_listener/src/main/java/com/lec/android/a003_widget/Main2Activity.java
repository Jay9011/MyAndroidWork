package com.lec.android.a003_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    // 과제 : 계산기 앱 만들기

    EditText calcText, saveNum;
    int value1, value2, value3;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.num_0).setOnClickListener(this);
        findViewById(R.id.num_1).setOnClickListener(this);
        findViewById(R.id.num_2).setOnClickListener(this);
        findViewById(R.id.num_3).setOnClickListener(this);
        findViewById(R.id.num_4).setOnClickListener(this);
        findViewById(R.id.num_5).setOnClickListener(this);
        findViewById(R.id.num_6).setOnClickListener(this);
        findViewById(R.id.num_7).setOnClickListener(this);
        findViewById(R.id.num_8).setOnClickListener(this);
        findViewById(R.id.num_9).setOnClickListener(this);

        calcText = findViewById(R.id.calc_text);
        saveNum = findViewById(R.id.save_num);

        Button plus = findViewById(R.id.btn_plus);
        Button minus = findViewById(R.id.btn_minus);
        Button divide = findViewById(R.id.btn_divide);
        Button multiply = findViewById(R.id.btn_multiply);
        Button btnClear = findViewById(R.id.btn_Clear);
        Button btnResult = findViewById(R.id.btn_Result);

        class calculation implements View.OnClickListener {
            String temp;
            String oper;

            public calculation(String oper) {
                this.oper = oper;
            }

            @Override
            public void onClick(View v) {
                Log.d("test", "" + operator);
                if (oper == "btnResult") {
                    if ((temp = saveNum.getText().toString().trim()).equals("")) {
                        if (operator == "divide" || operator == "multiply") {
                            value2 = 1;
                        } else {
                            value2 = 0;
                        }
                    } else {
                        value2 = Integer.parseInt(temp);
                    }
                    switch (operator) {
                        case "plus":
                            value3 = value1 + value2;
                            break;
                        case "minus":
                            value3 = value1 - value2;
                            break;
                        case "divide":
                            try {
                                value3 = value1 / value2;
                            } catch (ArithmeticException e) {
                                value3 = 0;
                            }
                            break;
                        case "multiply":
                            value3 = value1 * value2;
                            break;
                    }
                    calcText.setText("" + value3);
                } else if (oper == "btnClear") {
                    calcText.setText("");
                    saveNum.setText("");
                    value1 = value2 = value3 = 0;
                } else {
                    operator = this.oper;
                    if ((temp = calcText.getText().toString().trim()).equals("")) {
                        value1 = 0;
                    } else {
                        try {
                            value1 = Integer.parseInt(temp);
                        } catch (NumberFormatException e) {
                            calcText.setText(temp.substring(0, temp.length() - 1));
                        }
                    }
                    switch (operator) {
                        case "plus":
                            calcText.setText(calcText.getText().append("+"));
                            break;
                        case "minus":
                            calcText.setText(calcText.getText().append("-"));
                            break;
                        case "divide":
                            calcText.setText(calcText.getText().append("÷"));
                            break;
                        case "multiply":
                            calcText.setText(calcText.getText().append("×"));
                            break;
                    }
                    saveNum.setText("");
                }
            }
        }

        plus.setOnClickListener(new calculation("plus"));
        minus.setOnClickListener(new calculation("minus"));
        divide.setOnClickListener(new calculation("divide"));
        multiply.setOnClickListener(new calculation("multiply"));
        btnClear.setOnClickListener(new calculation("btnClear"));
        btnResult.setOnClickListener(new calculation("btnResult"));
    }

    @Override
    public void onClick(View v) {
        Log.d("test", calcText.getText().toString().trim());
        if (calcText.getText().toString().trim().equals("0")) {
            calcText.setText(((Button) v).getText());
            saveNum.setText(((Button) v).getText());
        } else {
            calcText.setText(calcText.getText().append(((Button) v).getText()));
            saveNum.setText(saveNum.getText().append(((Button) v).getText()));
        }
    }
}
