package com.myapplicationdev.android.twproblemstatementp02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

class AddAdapter extends ArrayAdapter<Grade> {
    private ArrayList<Grade> grade;
    private Context context;
    private TextView tvGrade, tvWeek;
    private RadioGroup rgGrade;

    public AddAdapter(Context context, int resource, ArrayList<Grade> objects){
        super(context, resource, objects);
        grade = objects;
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvGrade = (TextView) rowView.findViewById(R.id.textViewGrade);
        tvWeek = (TextView) rowView.findViewById(R.id.textViewWeek);
        rgGrade = (RadioGroup)rowView.findViewById(R.id.radioGroupGrade);

        Grade currentGrade = grade.get(position);

        tvGrade.setText(currentGrade.getGrade());
        tvWeek.setText("Week " + position+1);

        // Return the nicely done up View to the ListView
        return rowView;
    }
}
