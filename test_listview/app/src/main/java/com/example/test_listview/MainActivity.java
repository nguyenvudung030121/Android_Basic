package com.example.test_listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvStudent;
    ArrayList<student> arrStudent;
    adapter_student adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvStudent = findViewById(R.id.listviewStudent);
        arrStudent = new ArrayList<>();
        arrStudent.add(new student("Nguyễn Vũ Dũng","19T1","1911505310109",R.drawable.user));
        arrStudent.add(new student("Nguyễn Đức An","19T2","1911505310111",R.drawable.user));
        arrStudent.add(new student("Nguyễn Văn Trung","19T3","1911505310125",R.drawable.user));
        arrStudent.add(new student("Nguyễn Vũ Dũng","19T1","1911505310109",R.drawable.user));
        arrStudent.add(new student("Nguyễn Đức An","19T2","1911505310111",R.drawable.user));
        arrStudent.add(new student("Nguyễn Văn Trung","19T3","1911505310125",R.drawable.user));
        arrStudent.add(new student("Nguyễn Vũ Dũng","19T1","1911505310109",R.drawable.user));
        arrStudent.add(new student("Nguyễn Đức An","19T2","1911505310111",R.drawable.user));
        arrStudent.add(new student("Nguyễn Văn Trung","19T3","1911505310125",R.drawable.user));
        arrStudent.add(new student("Nguyễn Vũ Dũng","19T1","1911505310109",R.drawable.user));
        arrStudent.add(new student("Nguyễn Đức An","19T2","1911505310111",R.drawable.user));
        arrStudent.add(new student("Nguyễn Văn Trung","19T3","1911505310125",R.drawable.user));
        arrStudent.add(new student("Nguyễn Vũ Dũng","19T1","1911505310109",R.drawable.user));
        arrStudent.add(new student("Nguyễn Đức An","19T2","1911505310111",R.drawable.user));
        arrStudent.add(new student("Nguyễn Văn Trung","19T3","1911505310125",R.drawable.user));
        arrStudent.add(new student("Nguyễn Vũ Dũng","19T1","1911505310109",R.drawable.user));
        arrStudent.add(new student("Nguyễn Đức An","19T2","1911505310111",R.drawable.user));
        arrStudent.add(new student("Nguyễn Văn Trung","19T3","1911505310125",R.drawable.user));

        adapter = new adapter_student(this,R.layout.line_student,arrStudent);
        lvStudent.setAdapter(adapter);
    }

}