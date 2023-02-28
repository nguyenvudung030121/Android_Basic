package com.example.calendar;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.FloatingActionButton;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AddEventFragment extends Fragment {
    private TextView dateTime;
    private Button setDate,btn_add;
    private EditText title;
    private EditText event_des;
    Date getDate; //biến này dùng để nhận giá trị ngày được chọn

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_event, container,false);
        dateTime = view.findViewById(R.id.date_time);
        title = view.findViewById(R.id.title);
        event_des = view.findViewById(R.id.event_des);
        setDate = view.findViewById(R.id.btn_set_date);
        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PickDate();
            }
        });

        btn_add = (Button) view.findViewById(R.id.btn_add_event);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameEvent = title.getText().toString(); //Gán tên sự kiện
                String eventDescripton = event_des.getText().toString();// Gán Chi tiết
                String time = dateTime.getText().toString();// Gán thời gian
                Long diff; // biến này để tính toán thời gian còn lại
                Calendar calendar2 = Calendar.getInstance();
                Date currentTime = Calendar.getInstance().getTime(); //currentime nhận giá trị thời gian hiện tại
                //Nếu ta không chọn ngày thì diff sẽ nhận ngày hiện tại của hệ thống
                //Nếu ta chọn ngày thì diff = ngày được chọn - ngày hiện tại.
                if (getDate == null){
                    diff = currentTime.getTime();
                }else{
                     diff = getDate.getTime() - currentTime.getTime();
                }
                //gán biến datetime = thời gian con lại
                //TimeUnit để đổi về giá trị ngày
                String datetime = String.valueOf(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)) ;

                // Ta dùng bundle để truyền dữ liệu giữa các Fragment
                Bundle bundle = new Bundle();

                //đóng gói giữ liệu để gửi đi, ta sẽ gửi đi Với 1 giá trị name, cùng với giá trị cần gửi
                bundle.putString("nameEvent",nameEvent); //đóng gói tên Event
                bundle.putString("time", datetime); // đóng gói thời gian còn lại
                bundle.putString("eventDescripton",eventDescripton); // đóng gói chi tiết Event

                //Gọi lại lisEventFragment
                lisEventFragment lisEventFragment = new lisEventFragment();
                lisEventFragment.setArguments(bundle); // Cần set cái này để gửi bundle sang lisEventFragment
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, lisEventFragment, "tag");
                fragmentTransaction.commit();
            }
        });

        return view;

    }

    private void  PickDate(){
        //tạo đối tượng Calendar để lấy thời gian hiện tại của hệ thống
        Calendar calendar = Calendar.getInstance();
        int date = calendar.get(Calendar.DATE); // Gán ngày hiện tại của hệ thống
        int month = calendar.get(calendar.MONTH); // Gán tháng hiện tại của hệ thống
        int year = calendar.get(calendar.YEAR); // Gán năm hiện tại của hệ thống
        //Ta dùng Thư viện DatePickerDialog để có thể chọn ngày tháng
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            //onDataSet là phương thức sau khi Ta nhận chọn ngày trên lịch
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                //i là năm, i1 là tháng, i2 là ngày
                // ta thiết lập cho đối tượng calendar
                calendar.set(i,i1,i2);
                //format ngày tháng theo dạng ngày/tháng/nam
                DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                //Biến getDate lúc nãy khai báo ở trên ta sẽ gán cho thời gian được chọn để dùng sau này.
                getDate = calendar.getTime();
                //set cho edit text để hiển thị thời gian được chọn format theo dạng FULL - thứ ,ngày ,tháng, năm
                dateTime.setText(simpleDateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime()));
            }
        },year,month,date); // cài đặt cho lịch ngày tháng của hiện tại
        datePickerDialog.show();
    }



}