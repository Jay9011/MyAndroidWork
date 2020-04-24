package com.lec.android.a018_touch;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    ImageView ivRobot;
    TextView tvPos;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ivRobot = findViewById(R.id.ivRobot);
        ll = findViewById(R.id.linearLayout1);
        tvPos = findViewById(R.id.tvPos);

        ll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                    case MotionEvent.ACTION_UP:
                        // 이미지 뷰의 위치 옮기기
                        ivRobot.setX(event.getX()-150);
                        ivRobot.setY(event.getY()-150);
                        tvPos.setText("X : " + event.getX() + "\tY : " + event.getY());
                } // end switch
                return true;
            } // end onTouch()
        }); // end ll.setOnTouchListener()

    } // end onCreate()
} // end Main2Activity
