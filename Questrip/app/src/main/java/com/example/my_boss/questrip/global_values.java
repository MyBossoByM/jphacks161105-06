package com.example.my_boss.questrip;

import android.app.Application;
import android.content.Context;

/**
 * Created by takayayuuki on 2016/11/05.
 */

public class global_values extends Application {
    //グローバルに使用する変数たち
    String user;
    String pass;
    double latitude_final;
    double longitude_final;

    public static Context globalContext;

    public global_values(){

    }

    //ぜんぶ初期化するメソッド
    public void GlobalsAllInit() {
        user = "test";
        pass = "testpass";
        latitude_final = 0;
        longitude_final = 0;

    }
}
