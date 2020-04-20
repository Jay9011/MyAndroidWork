package com.lec.android.a014_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 대화상자 객체
    Dialog dig1;
    ImageView ivDigBanner;
    Button btnDigEvent;

    Dialog dig2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);

        // Dialog 클래스로 다이얼로그 객체 생성 및 세팅
        dig1 = new Dialog(this);    // 다이얼로그 객체 생성
        dig1.setContentView(R.layout.dialog_layout11);  // 다이얼로그 화면 생성

        // Dialog 안의 View 객체들 얻어오기
        ivDigBanner = dig1.findViewById(R.id.ivDlgBanner);
        btnDigEvent = dig1.findViewById(R.id.btnDlgEvent);

        btnDigEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivDigBanner.setImageResource(R.drawable.face17);
                Toast.makeText(getApplicationContext(), "다이얼로그 버튼을 눌렀어요.", Toast.LENGTH_SHORT).show();
            }
        });

        // Activity 에 Dialog 등록하기
        dig1.setOwnerActivity(MainActivity.this);
        dig1.setCanceledOnTouchOutside(true);   // 다이얼로그 바깥 영역 클릭시 (혹은 back 버튼 클릭시) hide() 상태가 됨.
                                // (종료 할 것인지 여부) true : 종료 됨, false : 종료 안됨.

        // # 2
        dig2 = new Dialog(this);
        dig2.setContentView(R.layout.dialog_layout12);
        dig2.setOwnerActivity(MainActivity.this);
        dig1.setCanceledOnTouchOutside(false);

        final EditText etName = dig2.findViewById(R.id.etName);
        Button btnOk = dig2.findViewById(R.id.btnOk);
        Button btnCancel = dig2.findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = etName.getText().toString();
                tvResult.setText(str);
                dig2.dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dig2.dismiss();
            }
        });

        // 다이얼로그가 등장할때 호출되는 메소드
        dig2.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                etName.setText("");
            }
        });

    } // end onCreate

    public void showDialog1(View view) {
        dig1.show();    // 다이얼로그 띄우기
    } // end showDialog1

    public void showDialog2(View view) {
        dig2.show();
    } // end showDialog2
} // end MainActivity
