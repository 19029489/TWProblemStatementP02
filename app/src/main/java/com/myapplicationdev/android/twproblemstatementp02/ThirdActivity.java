package com.myapplicationdev.android.twproblemstatementp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    Button btnSubmit;
    RadioGroup rgGrade;
    RadioButton rgButton;
    TextView tvWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btnSubmit = (Button) findViewById(R.id.buttonSubmit);
        rgGrade = findViewById(R.id.radioGroupGrade);
        tvWeek = (TextView) findViewById(R.id.textViewWeek);

        Intent i = getIntent();
        tvWeek.setText("Week " + i.getStringExtra("week"));

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = rgGrade.getCheckedRadioButtonId();
                rgButton = (RadioButton) findViewById(selectedId);
                Intent o = new Intent();
                o.putExtra("Grade", rgButton.getText().toString());
                setResult(RESULT_OK, o);
                finish();
            }
        });
    }
}