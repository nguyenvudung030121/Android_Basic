package com.example.calendar;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Tạo đối tượng listEventFragment
        lisEventFragment lisEventFragment = new lisEventFragment();
        //Ta dùng FragmentManager để quản lý Fragment qua phương thức getSupportFragmentManager();
        FragmentManager fragmentManager= getSupportFragmentManager();
        // Dùng FragmentTransaction để điều hướng nếu ta muốn mở hay thao tác bất kỳ một Fragment nào đó
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        //Dùng replace để thay thế Fragment;
        // "R.id.fragment" - là Framelayout để chứa Fragment
        // "lisEventFragment" là đối tượng của fragment cần replace
        // "tag" có hay không cũng được
        fragmentTransaction.replace(R.id.fragment, lisEventFragment, "tag");
        //Commit để áp dụng giao thức
        fragmentTransaction.commit();


    }

}