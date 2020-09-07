package com.example.registeration;

import android.widget.Button;

public class Employment {
    String employer;
    String type;
    String date;

    public Employment(String employer, String type, String date ) {
        this.employer = employer;
        this.type = type;
        this.date = date;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
