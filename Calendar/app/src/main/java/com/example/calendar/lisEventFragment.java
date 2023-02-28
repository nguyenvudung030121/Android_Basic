package com.example.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class lisEventFragment extends Fragment {
    ListView lvContent; // khai báo listview
    EventAdapter adapter; // khai báo adapter
    static   ArrayList<EventContent> arrContent; // static để tránh reset lại arrList khi gọi lại Fragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lis_event, null);
        FloatingActionButton addBtn = view.findViewById(R.id.addBtn); // Ánh Xạ button
        //Sự kiện OnClick
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Gọi AddEventFragment , giống như đã giải thích ở MainActivity
                AddEventFragment addEventFragment = new AddEventFragment();
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, addEventFragment, "tag");
                fragmentTransaction.commit();
            }
        });
            Bundle bundle = getArguments();// tạo bundle gán dữ liệu nhận từ AddEventFragment
            //Nếu bundle null thì ta sẽ khởi tạo một ArrayList Content mới còn nếu không thì ta sẽ đưa dữ liệu vào listView
            if (bundle != null){
                //Get Giá trị từ bundle thông qua Name của gói.
                String nameEvent = bundle.getString("nameEvent");
                String eventDes = bundle.getString("eventDescripton");
                String time = bundle.getString("time");

                //Thêm dữ liệu vào arrList
                arrContent.add(new EventContent(nameEvent,eventDes,time+" Days Remaining"));
                //Ta sẽ đưa dữ liệu vào adapter
                //getActivity() - là context của Fragment hiện tại
                //R.layout.linecontent - layout custom  của Item
                //arrContent - danh sách Event
                adapter = new EventAdapter(getActivity(),R.layout.linecontent,arrContent);
                lvContent = view.findViewById(R.id.lv); //Ánh xá Listview
                lvContent.setAdapter(adapter); // Truyền từ dữ adapter vào listview
            }else {
                arrContent = new ArrayList<>();
            }
            //kiểm tra xem Danh sách Event có rỗng hay ko , nếu khác rỗng thì cho phép xóa item
            if (arrContent.size() != 0){
                lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        arrContent.remove(i); //dùng remove để xóa phần tử khỏi danh sách tại vị trí i
                        adapter.notifyDataSetChanged(); //Load lại adapter
                    }
                });
            }




        return view;
    }

}