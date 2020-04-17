package com.lec.android.a008_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                adapter.addItem(new Person(
                        etName.getText().toString().trim(),
                        etAddress.getText().toString().trim(),
                        Integer.parseInt(etAge.getText().toString().trim())
                        ));

                adapter.notifyDataSetChanged();
            }
        });


    }
}
