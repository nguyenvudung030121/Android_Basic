package com.example.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EventAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<EventContent> contentsList;

    public EventAdapter(Context context, int layout, List<EventContent> contentsList) {
        this.context = context;
        this.layout = layout;
        this.contentsList = contentsList;
    }

    @Override
    public int getCount() {
        return contentsList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        TextView textContentName = view.findViewById(R.id.txt_ContentName);
        TextView textContentDescription = view.findViewById(R.id.txt_ContentDescription);
        TextView textTime = view.findViewById(R.id.txt_time);

        //lấy giá trị của phần tử trong list
        EventContent eventContent = contentsList.get(i);
        textContentName.setText(eventContent.getNameEvent());
        textContentDescription.setText(eventContent.getEventDescription());
        textTime.setText(eventContent.getTime());
        return view;
    }
}
