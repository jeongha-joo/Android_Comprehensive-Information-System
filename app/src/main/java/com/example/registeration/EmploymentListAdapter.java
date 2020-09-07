package com.example.registeration;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class EmploymentListAdapter extends BaseAdapter {

    private Context context;
    private List<Employment> employmentList;

    public EmploymentListAdapter(Context context, List<Employment> employmentList) {
        this.context = context;
        this.employmentList = employmentList;
    }

    @Override
    public int getCount() {
        return employmentList.size();
    }

    @Override
    public Object getItem(int position) {
        return employmentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.employment, null);
        TextView employer = (TextView) v.findViewById(R.id.employer);
        TextView type = (TextView) v.findViewById(R.id.employmentType);
        TextView date = (TextView) v.findViewById(R.id.employmentDate);

        employer.setText(employmentList.get(position).getEmployer());
        type.setText(employmentList.get(position).getType());
        date.setText(employmentList.get(position).getDate());

        v.setTag(employmentList.get(position).getEmployer());
        return v;
    }
}
