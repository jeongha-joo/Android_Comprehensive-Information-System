package com.example.registeration;  // 공지사항 데이터 불러오기 및 프래그먼트 버튼

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    static private ListView noticeListView;
    private NoticeListAdapter adapter;
    static ArrayList<Notice> noticeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button gradeButton = findViewById(R.id.gradeButton);
        final Button scheduleButton = findViewById(R.id.scheduleButton);
        final Button employmentButton = findViewById(R.id.employmentButton);
        final Button noticeButton = findViewById(R.id.noticeButton);

        noticeButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        noticeListView = findViewById(R.id.noticeListView);
        noticeList = new ArrayList<>();
        adapter = new NoticeListAdapter(this, noticeList);

        new BackgroundTask().execute();

        // 첫 화면 프래그먼트 설정
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, new NoticeFragment());
        fragmentTransaction.commit();

        // 성적조회 버튼
        gradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noticeListView.setVisibility(View.GONE);
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

        // 시간표 확인 버튼
        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noticeListView.setVisibility(View.GONE);
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

        // 취업정보 버튼
        employmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noticeListView.setVisibility(View.GONE);
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

        // 공지사항 버튼
        noticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noticeListView.setVisibility(View.VISIBLE);
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
    // 공지사항 데이터 불러오기
     class BackgroundTask extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "http://jha970107.cafe24.com/NoticeList.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while((temp = bufferedReader.readLine()) != null) {
                    stringBuilder.append(temp + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onProgressUpdate(Void... values) {
            super.onProgressUpdate();
        }

        @Override
        public void onPostExecute(String result) {
            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count = 0;
                String noticeContent, noticeName, noticeDate;
                while (count < jsonArray.length()){
                    JSONObject object = jsonArray.getJSONObject(count);
                    noticeContent = object.getString("noticeContent");
                    noticeName = object.getString("noticeName");
                    noticeDate = object.getString("noticeDate");
                    Notice notice = new Notice(noticeContent, noticeName, noticeDate);
                    noticeList.add(notice);
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            noticeListView.setAdapter(adapter);
        }
    }
    private long lastTimeBackPressed;

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() - lastTimeBackPressed < 1500){
            finish();
            return;
        }
        Toast.makeText(this,"'뒤로' 버튼을 한 번 더 눌러 종료합니다.",Toast.LENGTH_SHORT);
        lastTimeBackPressed = System.currentTimeMillis();
    }
}