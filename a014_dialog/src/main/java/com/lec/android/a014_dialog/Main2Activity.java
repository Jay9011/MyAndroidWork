package com.lec.android.a014_dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    // 다이얼로그의 ID를 보기 좋은 상수로 선언해서 사용한다
    final int DIALOG_TEXT = 1;
    final int DIALOG_LIST = 2; // 리스트 형식의 다이얼로그 ID
    final int DIALOG_RADIO = 3; // 하나만 선택할 수 있는 다이얼로그 ID
    final int DIALOG_MULTICHOICE = 4;

    TextView tvResult;

    int choice = -1; // 라디오 버튼 선택 값

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        /**
         * AlertDialog : Dialog 를 상속받은 자식클래스로
         *           다이얼로그를 쉽게 만들수 있도록 지원해주고,
         *           Activity 라이프 사이클과 다이얼로그의 라이프사이클을
         *           맞춰줌
         */

        tvResult = findViewById(R.id.tvResult);
        Button btnText = findViewById(R.id.btnText);
        Button btnList = findViewById(R.id.btnList);
        Button btnMultiChoice = findViewById(R.id.btnMultiChoice);
        Button btnRadio = findViewById(R.id.btnRadio);

        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(DIALOG_TEXT);
            }
        }); // end btnText.setOnClickListener

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(DIALOG_LIST);
            }
        }); // end btnList.setOnClickListener

        btnRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(DIALOG_RADIO);
            }
        }); // end btnRadio.setOnClickListener

        btnMultiChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(DIALOG_MULTICHOICE);
            }
        }); // end btnMultiChoice.setOnClickListener


    } // end onCreate

    protected AlertDialog.Builder showAlert(int id) {
        switch (id) {
            case DIALOG_TEXT:
                AlertDialog.Builder builder1 =
                        new AlertDialog.Builder(this);

                builder1.setTitle("다이얼로그 제목임")
                        .setMessage("안녕들 하세요~!")
                        .setPositiveButton("긍정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "긍정", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("부정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "부정", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("중립", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "중립", Toast.LENGTH_SHORT).show();
                            }
                        })
                ; // end builder1.set
                builder1.show();    // 다이얼로그 보이기
                return builder1;

            case DIALOG_LIST:
                AlertDialog.Builder builder2 =
                        new AlertDialog.Builder(this);

                final String[] str1 = {"사과", "딸기", "수박", "배"};
                builder2.setTitle("리스트 형식 다이얼로그 제목")
                        .setNegativeButton("취소", null)
                        .setItems(str1, // 리스트 목록에 사용할 배열
                                new DialogInterface.OnClickListener() {
                                    // 리스트 아이템이 선택되었을때 호출되는 콜백
                                    // which : 어디가 선택되었는지에 대한 값
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(getApplicationContext(), "선택은 : " + str1[which], Toast.LENGTH_LONG).show();
                                    }
                                })
                ; // end builder2.set
                builder2.show();
                return builder2;

            case DIALOG_RADIO:
                // 커스텀 스타일 적용
                AlertDialog.Builder builder3 =
                        new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));

                final String[] str2 = {"빨강", "녹색", "파랑"};
                builder3.setTitle("색을 고르세요")
                        .setPositiveButton("선택완료",
                                // OK 버튼을 눌렀을 때
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(getApplicationContext(), str2[choice] + "를 선택", Toast.LENGTH_LONG).show();
                                    }
                                })
                        .setNegativeButton("취소", null)
                        .setSingleChoiceItems(
                                str2,            // 리스트 배열 목록
                                -1, // 기본설정값 (-1 : 아무것도 선택하지 않은 상태에서 시작)
                                // 선택했을때 호출되는 콜백
                                // which : 어떤 것을 선택했는지에 대한 index
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        choice = which;
                                    }
                                }
                        )
                ; // end builder3.set
                builder3.show();
                return builder3;

            case DIALOG_MULTICHOICE:
                AlertDialog.Builder builder4 =
                        new AlertDialog.Builder(this);

                final String[] data = {"한국", "북한", "미국", "영국"};
                final boolean[] checked = {true, false, true, false};

                builder4.setTitle("MultiChoice 다이얼로그 선택")
                        .setPositiveButton("선택완료",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        String str = "선택된 값은 : ";

                                        for (int i = 0; i < checked.length; i++) {
                                            if (checked[i]) {
                                                str = str + data[i] + ", ";
                                            }
                                        }

                                        tvResult.setText(str);
                                    }
                                })
                        .setNegativeButton("취소", null)
                .setMultiChoiceItems(
                        data,       // 체크박스의 리스트 항목
                        checked,    // 체크박스 선택여부 초기값
                        // 체크박스 선택 했을 때 호출되는 콜백
                        // which : 선택된 체크박스의 위치
                        // isChecked : 선택여부
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checked[which] = isChecked;
                            }
                        }
                )
                ; // end builder4.set
                builder4.show();
                return builder4;

        } // end switch
        return null;
    } // end AlertDialog.Builder

} // end Main2Activity
