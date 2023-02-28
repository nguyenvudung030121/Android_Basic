package com.example.test_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class adapter_student extends BaseAdapter {
    private Context context;
    private int layout;
    private List<student> studentList;

    public adapter_student(Context context, int layout, List<student> studentList) {
        this.context = context;
        this.layout = layout;
        this.studentList = studentList;
    }

    public int getCount() {
        return studentList.size();
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
        TextView textTen = view.findViewById(R.id.text_name);
        TextView textId = view.findViewById(R.id.text_id);
        TextView textLop = view.findViewById(R.id.text_class);
        ImageView textHinh = view.findViewById(R.id.img_student);

        student student = studentList.get(i);
        textTen.setText(student.getTen());
        textId.setText(student.getMasv());
        textLop.setText(student.getLop());
        textHinh.setImageResource(student.getHinh());

        return view;
    }
}
