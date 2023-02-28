package com.example.qlsinhvien;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.LinkedList;

public class Listview_Adapter extends ArrayAdapter {
    private LinkedList<SinhVien> mSinhviens;
    private int resource;
    private HandlerButton handlerButton;

    public Listview_Adapter(@NonNull Context context, int resource, LinkedList<SinhVien> mSinhviens) {
        super(context, resource, mSinhviens);
        this.mSinhviens = mSinhviens;
        this.resource = resource;
    }
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(resource, viewGroup, false);
        }
        TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
        ImageButton btn_edt = (ImageButton) view.findViewById(R.id.btn_edit);
        ImageButton btn_delete = (ImageButton) view.findViewById(R.id.btn_delete);
        btn_edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handlerButton.setOnclickEdit(i);
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handlerButton.setOnclickDelete(i);
            }
        });
        mSinhviens.get(i);
        Log.e("object", mSinhviens.get(i).toString());
        tv_name.setText(mSinhviens.get(i).getId() + ", " + mSinhviens.get(i).getHovaten());
        return view;
    }

    @Override
    public int getCount() {
        return mSinhviens.size();
    }

    public void setHandlerButton(HandlerButton handlerButton) {
        this.handlerButton = handlerButton;
    }


    public interface HandlerButton {
        void setOnclickEdit(int positon);
        void setOnclickDelete(int positon);
    }


}
