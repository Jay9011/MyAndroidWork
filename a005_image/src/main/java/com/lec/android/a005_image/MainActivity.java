package com.lec.android.a005_image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/*  안드로이드의 모-든 리소스(Resource)로 사용하는 파일들은
 *  파일명 규칙
 *  - 대문자 불가
 *  - 숫자 시작 불가
 *  - 공백, 특수문자 불가
 *  - 특수문자는 _ 만 가능.
 */
public class MainActivity extends AppCompatActivity {

    int[] imgageId = {R.drawable.ndm_160, R.drawable.ndm_170, R.drawable.ndm_197, R.drawable.ndm_318, R.drawable.ndm_338};
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.iv1);

        // res/drawable 폴더에 있는 이미지로 세팅하기
        iv.setImageResource(R.drawable.ndm_160);

        iv.setOnClickListener(new MyListener());

    } // end onCreate
    class MyListener implements View.OnClickListener{

        int i = 0;
        TextView tvResult = findViewById(R.id.tvResult);

        @Override
        public void onClick(View v) {
            i++;
            if (i == imgageId.length) i = 0;

            iv.setImageResource(imgageId[i]);
            tvResult.setText("이미지뷰 : " + i);
        }
    } // MyListner
} // end Class
