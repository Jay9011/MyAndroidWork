package com.lec.android.a003_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvResult;
    EditText et;

    // onCreate()
    // 액티비티가 생성될때 호출되는 메소드
    // 액티비티 초기화 하는 코드 작성.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);

        tvResult = findViewById(R.id.tvResult);
        et = findViewById(R.id.et);
        LinearLayout ll = findViewById(R.id.ll);

        // 방법2 : 익명 클래스(Anonymous class) 사용.
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // 클릭되었을때 호출되는 메소드 (콜백 메소드 callback method)
                Log.d("myapp", "버튼2가 클릭되었습니다.");
                tvResult.setText("버튼2가 클릭됨.");
                tvResult.setBackgroundColor(Color.YELLOW);
            }
        });

        // 다양한 이벤트, 다양한 리스너 등록 가능
        btn2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {    // 롱클릭 발생시 수행하는 콜백 메소드
                Log.d("myapp", "버튼2가 롱클릭 되었습니다.");
                tvResult.setText("버튼2가 롱클릭 되었습니다.");
                tvResult.setBackgroundColor(Color.CYAN);
//                return false;   // false : 버튼을 떼었을 때의 동작인 Click 동작까지 수행하게 된다.
                return true;    // true : 버튼을 떼도 LongClickListener 까지만 수행한다. ( Click 동작을 수행하지 않는다. )
            }
        });


        // 방법3 : Lambda - expression 사용하기
        // AndroidStudio 의 세팅 필요! ProjectStructure (Ctrl+Alt+Shift+S) 에서 JAVA를 1.8 이상으로 사용.
        btn3.setOnClickListener((v) -> {
            Log.d("myapp", "버튼3가 클릭 되었다.");
            tvResult.setText("버튼3 클릭되버림.");
            ll.setBackgroundColor(Color.rgb(130,123,88));
        });

        // 방법4 : implement 한 클래스 사용
        Button btnA = findViewById(R.id.btnA);
        Button btnB = findViewById(R.id.btnB);
        Button btnC = findViewById(R.id.btnC);
        Button btnD = findViewById(R.id.btnD);
        Button btnE = findViewById(R.id.btnE);
        Button btnF = findViewById(R.id.btnF);

        class  MyListener implements View.OnClickListener{

            String name;

            public MyListener(String name) {
                this.name = name;
            }

            @Override
            public void onClick(View v) {
                String tag = (String) v.getTag();
                String text = (String)((Button)v).getText(); // CharSequence 객체 리턴
                String msg = String.format("%s 버튼 %s 이 클릭[%s]", name, text, tag);
                Log.d("myapp", msg);
                tvResult.setText(msg);
                et.setText(et.getText().append(name));
            }
        }

        btnA.setOnClickListener(new MyListener("안녕1"));
        btnB.setOnClickListener(new MyListener("안녕2"));
        btnC.setOnClickListener(new MyListener("안녕3"));
        btnD.setOnClickListener(new MyListener("안녕4"));
        btnE.setOnClickListener(new MyListener("안녕5"));
        btnF.setOnClickListener(new MyListener("안녕6"));


        // 방법5 : 액티비티가 implement 한 것을 사용 (밑에 것에서 이어서)
        Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        // 연습
        // +, - 버튼 누르면 tvResult 의 글씨가 점점 커지고/작아지게 하기
        // getTextSize() : return float
        Button btnInc = findViewById(R.id.btnInc);
        Button btnDec = findViewById(R.id.btnDec);

        btnInc.setOnClickListener((v -> {
            float size = tvResult.getTextSize();
            Log.d("myapp", "size : " + tvResult.getTextSize());
            tvResult.setTextSize(0, size + 5);
        }));

        btnDec.setOnClickListener((v -> {
            float size = tvResult.getTextSize();
            Log.d("myapp", "size : " + tvResult.getTextSize());
            tvResult.setTextSize(0, size - 5);
        }));

    } // end onCreate()

    // 방법1 : 레이아웃 xml 의 conXXX 속성으로 지정
    public void changeText(View v) {
        // Log.d(tag, message)
        // Log 창의 Debug 메세지로 출력
        Log.d("myapp", "버튼1이 클릭되었습니다.");
        tvResult.setText("버튼1이 클릭되었습니다.");

    }

    // 방법5 : 액티비티가 implement 한 것을 사용
    @Override
    public void onClick(View v) {
        Log.d("myapp", "Clear 버튼이 클릭되었습니다");
        tvResult.setText("Clear 버튼이 클릭되었습니다.");
        et.setText("");
    }
}
