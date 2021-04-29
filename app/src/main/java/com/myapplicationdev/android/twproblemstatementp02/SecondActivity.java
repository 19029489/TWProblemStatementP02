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

public class SecondActivity extends AppCompatActivity {

    Button btnEmail, btnRP, btnAdd;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Grade> alGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnRP = (Button) findViewById(R.id.buttonInfo);
        btnEmail = (Button) findViewById(R.id.buttonEmail);
        btnAdd = (Button) findViewById(R.id.buttonAdd);

        lv = (ListView)findViewById(R.id.listView);

        alGrade = new ArrayList<Grade>();
        alGrade.add(new Grade("B"));
        alGrade.add(new Grade("C"));
        alGrade.add(new Grade("A"));

        aa = new GradeAdapter(this, R.layout.row, alGrade);
        lv.setAdapter(aa);


        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason.lim.rp.sg@gmail.com"});
                email.putExtra(Intent.EXTRA_TEXT,
                        "Hi faci,\n\nI am ...\nPlease see my remarks so far, thank you!\n\n");
                for(int i = 0; i < alGrade.size(); i++){
                    int week = i+1;
                    String grade = alGrade.get(i).getGrade();
                    email.putExtra(Intent.EXTRA_TEXT,
                            "Week " + week + ": DG:" + grade);
                }
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client: "));
            }
        });
        btnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(addIntent);
            }
        });
    }
}