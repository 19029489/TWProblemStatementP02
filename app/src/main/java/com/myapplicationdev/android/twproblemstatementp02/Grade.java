package com.myapplicationdev.android.twproblemstatementp02;

import java.io.Serializable;

public class Grade implements Serializable {
    private String grade;

    public Grade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }
}
