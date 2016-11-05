package com.example.my_boss.questrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by takayayuuki on 2016/10/26.
 */

public class questrip_root_Activity extends Activity {
    private Button start_from_here;
    private Button start_from_there;
    private Button search_around;
    private Button char_collection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questrip_root);

        start_from_here = (Button)findViewById(R.id.button_fromhere);
        start_from_there = (Button)findViewById(R.id.button_fromthere);
        search_around = (Button)findViewById(R.id.button_search_around);
        char_collection = (Button)findViewById(R.id.button_char_collection);

        setClickListener();



    }

    void setClickListener(){
        start_from_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ボタンがクリックされた時に呼び出されます
                //インテントの作成
                Intent intent=new Intent();
                intent.setClassName("com.example.my_boss.questrip","com.example.my_boss.questrip.questrip_setting_Activity_2");
                startActivity(intent);

            }
        });


        start_from_there.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                // ボタンがクリックされた時に呼び出されます
//                Intent intent=new Intent();
//                intent.setClassName("com.example.my_boss.questrip","com.example.my_boss.questrip.questrip_setting_there_Activity");
//                startActivity(intent);
            }
        });


        search_around.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ボタンがクリックされた時に呼び出されます
                Intent intent=new Intent();
                intent.setClassName("com.example.my_boss.questrip","com.example.my_boss.questrip.Instagram_connect_Activity");
                startActivity(intent);
            }
        });


        char_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ボタンがクリックされた時に呼び出されます
//                Intent intent=new Intent();
//                intent.setClassName("com.example.my_boss.questrip","com.example.my_boss.questrip.questrip_setting_Activity");
//                startActivity(intent);
            }
        });
    }
}
