package com.myapplicationdev.android.twproblemstatementp02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    Button btnAdd, btnInfo, btnEmail;
    ArrayAdapter aa;
    ArrayList<Grade> alGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView)findViewById(R.id.listView);
        btnAdd = (Button)findViewById(R.id.buttonAdd);
        btnInfo = (Button)findViewById(R.id.buttonInfo);
        btnEmail = (Button)findViewById(R.id.buttonEmail);

        alGrade = new ArrayList<Grade>();
        alGrade.add(new Grade("B"));
        alGrade.add(new Grade("C"));
        alGrade.add(new Grade("A"));

        lv.setAdapter(aa);

    }
}