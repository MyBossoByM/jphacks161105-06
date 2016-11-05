package com.example.my_boss.questrip;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by takayayuuki on 2016/10/26.
 */

public class questrip_root_Activity extends Activity implements LocationListener{
    private Button start_from_here;
    private Button start_from_there;
    private Button search_around;
    private Button char_collection;

    private LocationManager locationManager;
    public double latitude = 34.802991;             //処理に使う緯度
    public double longitude = 135.771159;           //処理に使う経度

    private String font="Pixel10.ttf";  //8ビットフォント

    private Timer mTimer = null;
    private Handler mHandler = null;

    private int button_flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questrip_root);

        start_from_here = (Button)findViewById(R.id.button_fromhere);
        start_from_here.setTypeface(Typeface.createFromAsset(getAssets(), font));
        start_from_there = (Button)findViewById(R.id.button_fromthere);
        start_from_there.setTypeface(Typeface.createFromAsset(getAssets(), font));
        search_around = (Button)findViewById(R.id.button_search_around);
        search_around.setTypeface(Typeface.createFromAsset(getAssets(), font));
        char_collection = (Button)findViewById(R.id.button_char_collection);
        char_collection.setTypeface(Typeface.createFromAsset(getAssets(), font));

        setClickListener();

        locationStart();
    }

    void select_mode(final Button button){
        final String str = (String) button.getText();
        mHandler = new Handler();
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(button_flag==0) {
                            button.setText("");
                            button_flag = 1;
                        } else {
                            button.setText(str);
                            button_flag = 0;
                        }
                    }
                });
            }
        }, 0, 200); // 実行したい間隔(ミリ秒)

    }

    void setClickListener(){
        start_from_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_from_here.setText("＞ここから冒険をはじめる　　");
                select_mode(start_from_here);
                HandlerThread handlerThread = new HandlerThread("dispmessage");
                handlerThread.start();
                new Handler(handlerThread.getLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //インテントの作成
                        Intent intent=new Intent();
                        intent.setClassName("com.example.my_boss.questrip","com.example.my_boss.questrip.questrip_setting_Activity_2");
                        startActivity(intent);
                        finish();

                    }
                }, 1000);
            }
        });

        start_from_there.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_from_there.setText("＞違う場所から冒険をはじめる");
                select_mode(start_from_there);
                HandlerThread handlerThread = new HandlerThread("dispmessage");
                handlerThread.start();
                new Handler(handlerThread.getLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent();
                        intent.setClassName("com.example.my_boss.questrip","com.example.my_boss.questrip.questrip_setting_there_Activity");
                        startActivity(intent);
                        finish();

                    }
                }, 1000);
            }
        });

        search_around.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_around.setText("＞周辺のスポットまで冒険する");
                select_mode(search_around);
                HandlerThread handlerThread = new HandlerThread("dispmessage");
                handlerThread.start();
                new Handler(handlerThread.getLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent();
                        intent.setClassName("com.example.my_boss.questrip","com.example.my_boss.questrip.Instagram_connect_Activity");
                        startActivity(intent);
                        finish();

                    }
                }, 1000);
            }
        });

        char_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                char_collection.setText("＞ご当地キャラ図鑑をみる　　");
//                select_mode(char_collection);

//                Intent intent=new Intent();
//                intent.setClassName("com.example.my_boss.questrip","com.example.my_boss.questrip.questrip_setting_Activity");
//                startActivity(intent);
            }
        });
    }

    private void locationStart() {
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        Location nowLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1000, this);

        latitude=nowLocation.getLatitude();       //最新GPS値の緯度を格納
        longitude=nowLocation.getLongitude();     //最新GPS値の経度を格納

        final boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!gpsEnabled) {
            Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(settingsIntent);
            Log.d("debug", "gpsEnable, startActivity");
        } else {
            Log.d("debug", "gpsEnabled");
        }
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
            Log.d("debug", "checkSelfPermission false");
            return;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    @Override
    public void onLocationChanged(Location location) {}

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {}

    @Override
    public void onProviderEnabled(String s) {}

    @Override
    public void onProviderDisabled(String s) {}
}
