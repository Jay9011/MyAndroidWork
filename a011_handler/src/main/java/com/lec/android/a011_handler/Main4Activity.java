package com.lec.android.a011_handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

// value1
// 1 ~ 10 까지 1초 단위로 증가시키기
// 10초에 도달하면 멈추어서 Toast 띄우기
// Message 사용

// value2
// 1 ~ 20 까지 1초 단위로 증가시키기
// 20초에 도달하면 멈추어서 Toast 띄우기
// Handler 사용
public class Main4Activity extends AppCompatActivity {

    TextView tvResult1, tvResult2, tvResult3, tvResult4, tvResult5;
    int result1, result2, result3, result4;
    Handler handler2, handler3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tvResult1 = findViewById(R.id.tvResult1);
        tvResult2 = findViewById(R.id.tvResult2);
        tvResult3 = findViewById(R.id.tvResult3);
        tvResult4 = findViewById(R.id.tvResult4);
        tvResult5 = findViewById(R.id.tvResult5);

        MyThread1 thread1 = new MyThread1();
        thread1.setDaemon(true);
        thread1.start();

        handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                result2++;
                tvResult2.setText("결과창2 : " + result2);
                if (result2 < 20) {
                    handler2.postDelayed(this, 1000);
                } else {
                    Toast.makeText(getApplicationContext(), "결과 2 가 20초가 되었습니다.", Toast.LENGTH_LONG).show();
                }
            }
        }, 0);

        handler3 = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                result3++;
                tvResult3.setText("결과창3 : " + result3);
                if (result3 < 5) {
                    handler3.sendEmptyMessageDelayed(0, 1000);
                } else {
                    Toast.makeText(getApplicationContext(), "결과3이 종료되었습니다.", Toast.LENGTH_LONG).show();
                }
            }
        };
        handler3.sendEmptyMessage(0);

        /**
         *  방법 #3
         *  핸들러를 사용하지 않고도 일정시간마다 (혹은 후에) 코스를 수행할수 있도록
         *  CountDownTimer 클래스가 제공된다.
         *  '총시간'  과 '인터벌(간격)' 을 주면 매 간격마다 onTick 메소드를 수행한다.
         */
        new CountDownTimer(15 * 1000, 1000){

            // 매 간격마다 수행하는 코드
            @Override
            public void onTick(long millisUntilFinished) {
                result4++;
                tvResult4.setText("결과창4 : " + result4);
            }

            // 종료시 수행하는 코드
            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "결과4가 종료되었습니다.", Toast.LENGTH_LONG).show();
            }
        }.start();  // 타이머 시작


    } // end onCreate

    class MyThread1 extends Thread {
        @Override
        public void run() {
            while (true) {
                result1++;
                handler1.sendEmptyMessage(1);

                if (result1 == 10) {
                    break;
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            handler1.sendEmptyMessage(2);
        }
    } // end MyThread1

    Handler handler1 = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == 1) {
                tvResult1.setText("결과창1 : " + result1);
            } else if (msg.what == 2) {
                Toast.makeText(getApplicationContext(), "결과 1 이 10초가 되었습니다.", Toast.LENGTH_LONG).show();
            }// end if
        } // end handleMessage
    }; // end new Handler

} // end Main4Activity
