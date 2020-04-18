package com.lec.android.a008_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge, etAddress;
    Button btnAdd;
    PersonAdapter adapter;
    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etAge = findViewById(R.id.etAge);
        btnAdd = findViewById(R.id.btnAdd);

        list = findViewById(R.id.list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        list.setLayoutManager(layoutManager);

        adapter = new PersonAdapter();

//        adapter.addItem(new Person("처음", "처럼", 10));

        list.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "";
                String address = "";
                int age = 0;
                try {
                    name = etName.getText().toString().trim();
                    address = etAddress.getText().toString().trim();
                    age = Integer.parseInt(etAge.getText().toString().trim());

                    if (name.equals("")) {
                        Toast.makeText(v.getContext(), "이름을 다시 확인해 주세요.", Toast.LENGTH_LONG).show();
                        return;
                    } else if (age < 1) {
                        Toast.makeText(v.getContext(), "나이를 다시 확인해 주세요.", Toast.LENGTH_LONG).show();
                        return;
                    } else if (address.equals("")) {
                        Toast.makeText(v.getContext(), "주소를 다시 확인해 주세요.", Toast.LENGTH_LONG).show();
                        return;
                    }

                    adapter.addItem(new Person(name, address, age));
                    adapter.notifyDataSetChanged();

                } catch (NumberFormatException e) {
                    Toast.makeText(v.getContext(), "나이를 입력해 주세요.", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
