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

public class SecondActivity extends AppCompatActivity {

    Button btnEmail, btnRP, btnAdd;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Grade> alGrade;
    String message = "";
    int requestCodeForAdd = 1;

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

                for(int i = 0; i < alGrade.size(); i++){
                    message += "Week " + (i+1) + ": DG:" + alGrade.get(i).getGrade() + "\n";
                }
                email.putExtra(Intent.EXTRA_TEXT,
                        "Hi faci,\n\nI am ...\nPlease see my remarks so far, thank you!\n\n" + message);
                message = "";
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
                String week = String.valueOf(alGrade.size()+1);
                Intent addIntent = new Intent(SecondActivity.this, ThirdActivity.class);
                addIntent.putExtra("week", week);
                startActivityForResult(addIntent, requestCodeForAdd);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if (data != null) {
                // Get data passed back from 3rd activity
                String grade = data.getStringExtra("Grade");
                Log.d("grade", grade);
                String statement = "";

                if(requestCode == requestCodeForAdd){
                    alGrade.add(new Grade(grade));
                }

                aa.notifyDataSetChanged();

            }
        }
    }

}