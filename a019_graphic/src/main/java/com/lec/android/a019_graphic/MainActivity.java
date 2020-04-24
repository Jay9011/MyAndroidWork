package com.lec.android.a019_graphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);   // XML 레이아웃을 사용하지 않고

        /** 내가 임의로 만든 View 를 Activity 에 장착한다. */
        MyView3 v = new MyView3(MainActivity.this);
        setContentView(v);  // 사용자가 작성한 v(View) 로 액티비티 레이아웃을 세팅

    } // end onCreate()
} // end MainActivity

class MyView extends View {
    public MyView(Context context) {
        super(context);

    } // Class(context)

    /** 화면이 업데이트 될 때, '그려주기' */
    @Override
    protected void onDraw(Canvas canvas) {  /** Canvas : 그림을 그릴 대상 객체 */
        Paint paint = new Paint();  // 화면에 그려줄 도구 세팅
        paint.setColor(Color.RED);  // 색상 지정

        setBackgroundColor(Color.parseColor("#393e46"));    // 배경색 지정

        // 사각형의 좌상, 우하의 좌표
        canvas.drawRect(100, 100, 400, 1200, paint);

        paint.setColor(Color.parseColor("#f9ed69"));
        paint.setStrokeWidth(10f);
        canvas.drawLine(100, 100, 700, 700, paint);
        canvas.drawLine(700, 700, 100, 1200, paint);

        paint.setStrokeWidth(30f);
        canvas.drawLine(100, 1000, 100, 300, paint);

        // Path 자취(?) 만들기
        Path path = new Path();
        path.moveTo(20, 100);   // 자취 이동
        path.lineTo(100, 200);  // 직선
        path.cubicTo(150, 40, 200, 300, 300, 200);  // 베지어 곡선

        paint.setColor(Color.parseColor("#08d9d6"));
        canvas.drawPath(path, paint);   /** 만들어준 path 에 paint 하기 */


    }
} // end MyView
