package com.example.registeration;  //취업 정보 프래그먼트

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EmploymentFragment extends Fragment {

    private ListView employmentListView;
    private EmploymentListAdapter adapter;
    private List<Employment> employmentList;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public EmploymentFragment() {

    }

    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);

        employmentListView = (ListView) getView().findViewById(R.id.EmploymentList);
        employmentList = new ArrayList<Employment>();
        employmentList.add(new Employment("삼성", "소프트웨어 개발", "2020-09-05"));
        employmentList.add(new Employment("LG", "소프트웨어 개발", "2020-09-02"));
        employmentList.add(new Employment("SK", "네트워크 관리자", "2020-09-01"));
        employmentList.add(new Employment("롯데", "소프트웨어 엔지니어", "2020-09-04"));
        employmentList.add(new Employment("CJ", "게임 개발", "2020-09-08"));
        employmentList.add(new Employment("한아전", "청소부", "2020-09-07"));

        adapter = new EmploymentListAdapter(getContext().getApplicationContext(), employmentList);
        employmentListView.setAdapter(adapter);
    }

    public static EmploymentFragment newInstance(String param1, String param2) {
        EmploymentFragment fragment = new EmploymentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*View view = inflater.inflate(R.layout.fragment_employment, container, false);

        employmentListView = view.findViewById(R.id.EmploymentList);
        employmentList = new ArrayList<Employment>();
        employmentList.add(new Employment("삼성", "소프트웨어 개발", "2020-09-05"));
        adapter = new EmploymentListAdapter(getContext(), employmentList);
        employmentListView.setAdapter(adapter);*/
        return inflater.inflate(R.layout.fragment_employment, container, false);
    }

    /*@Override
    public void onPostExecute(String result) {
        try {
            employmentList.clear();
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("response");

        } catch (Exception e){
            e.printStackTrace();
        }
    }*/
}