package com.myapplicationdev.android.twproblemstatementp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


import android.os.Bundle;
import android.widget.RadioGroup;

public class ThirdActivity extends AppCompatActivity {

    Button btnSubmit;
    RadioGroup rgGrade;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Grade> alGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btnSubmit = (Button) findViewById(R.id.buttonSubmit);

        lv = (ListView)findViewById(R.id.listView);

        alGrade = new ArrayList<Grade>();
        alGrade.add(new Grade("B"));
        alGrade.add(new Grade("C"));
        alGrade.add(new Grade("A"));

        aa = new GradeAdapter(this, R.layout.row, alGrade);
        lv.setAdapter(aa);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("Grade", rgGrade.isSelected());
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}