package com.example.registeration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button gradeButton = (Button) findViewById(R.id.gradeButton);
        final Button scheduleButton = (Button) findViewById(R.id.scheduleButton);
        final Button employmentButton = (Button) findViewById(R.id.employmentButton);
        final Button noticeButton = (Button) findViewById(R.id.noticeButton);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, new NoticeFragment());
        fragmentTransaction.commit();
        noticeButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));

        gradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gradeButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                noticeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                employmentButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new GradeFragment());
                fragmentTransaction.commit();
            }
        });

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gradeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                noticeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                employmentButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new ScheduleFragment());
                fragmentTransaction.commit();
            }
        });

        employmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gradeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                noticeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                employmentButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new EmploymentFragment());
                fragmentTransaction.commit();
            }
        });

        noticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gradeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                noticeButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                employmentButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new NoticeFragment());
                fragmentTransaction.commit();

            }
        });
    }
}