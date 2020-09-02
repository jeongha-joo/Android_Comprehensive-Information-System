package com.example.registeration;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NoticeListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Notice> noticeList;

    public NoticeListAdapter(Context context, ArrayList<Notice> noticeList) {
        this.context = context;
        this.noticeList = noticeList;
    }

    @Override
    public int getCount() {
        return noticeList.size();
    }

    @Override
    public Object getItem(int position) {
        return noticeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.notice, null);
        TextView noticeText = v.findViewById(R.id.noticeText);
        TextView nameText = v.findViewById(R.id.nameText);
        TextView dateText = v.findViewById(R.id.dateText);

        noticeText.setText(this.noticeList.get(position).getNotice());
        nameText.setText(this.noticeList.get(position).getName());
        dateText.setText(this.noticeList.get(position).getDate());

        v.setTag(this.noticeList.get(position).getNotice());
        return v;
    }

}