package com.lec.android.a019_graphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main3);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.addView(new MyView3(this));      // LineaLayout 안에 들어감.
        setContentView(ll);

    } // end onCreate()
} // end Main3Activity

class MyView3 extends View {

    Paint paint = new Paint();
    Path path = new Path();

    public MyView3(Context context) {
        super(context);
        paint.setStyle(Paint.Style.STROKE); // 선 종류
        paint.setStrokeWidth(10f);          // 선 두께
        paint.setColor(Color.parseColor("#f38181"));
    } // end MyView(Context)

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
    } // end onDraw()

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);      /** path 를 그리기 전에 위치만 이동함 */
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);      /** path 에 선(LineTo) 그리기 */
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        invalidate();   // 화면 다시 그리기


        return true;
    } // end onTouchEvent()
} // end MyView
