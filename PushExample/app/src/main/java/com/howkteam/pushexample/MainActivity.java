package com.howkteam.pushexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.howkteam.pushexample.util.Config;
import com.howkteam.pushexample.util.NotificationUtils;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();
  private BroadcastReceiver mRegistrationBroadcastReceiver;
  private TextView txtRegId, txtMessage;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    txtRegId = (TextView) findViewById(R.id.txt_reg_id);
    txtMessage = (TextView) findViewById(R.id.txt_push_message);

    mRegistrationBroadcastReceiver = new BroadcastReceiver() {
      @Override
      public void onReceive(Context context, Intent intent) {

        // Kiểm tra Intent Filter có khớp cái nào không.
        if (intent.getAction().equals(Config.REGISTRATION_COMPLETE)) {
          // GCM đã được đăng ký thành công.
          // Đăng ký vào topic có tên "Global".
          FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);
          displayFirebaseRegId();

        } else if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
          // Khi có tin nhắn mới về.
          String message = intent.getStringExtra("message");
          Toast.makeText(getApplicationContext(), "Push notification: " + message, Toast.LENGTH_LONG).show();
          txtMessage.setText(message);
        }
      }
    };

    displayFirebaseRegId();
  }

  // Hiển thị Registration ID.
  private void displayFirebaseRegId() {
    SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF, 0);
    String regId = pref.getString("regId", null);

    Log.e(TAG, "Firebase reg id: " + regId);

    if (!TextUtils.isEmpty(regId))
      txtRegId.setText("Firebase Reg Id: " + regId);
    else
      txtRegId.setText("Firebase Reg Id is not received yet!");
  }

  @Override
  protected void onResume() {
    super.onResume();

    // Đăng ký receiver vào LocalBroadcastManager.
    LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
            new IntentFilter(Config.REGISTRATION_COMPLETE));

    // Đăng ký bộ nhận tin nhắn.
    LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
            new IntentFilter(Config.PUSH_NOTIFICATION));

    // Xóa các notification khi app được bật.
    NotificationUtils.clearNotifications(getApplicationContext());
  }

  @Override
  protected void onPause() {
    LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
    super.onPause();
  }
}
