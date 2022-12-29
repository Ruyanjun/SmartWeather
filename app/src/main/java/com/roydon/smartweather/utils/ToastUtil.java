package com.roydon.smartweather.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {


    public static void showLongToast(Context context,CharSequence cs){
        Toast.makeText(context.getApplicationContext(), cs, Toast.LENGTH_LONG).show();
    }


    public static void showShotToast(Context context,CharSequence cs){
        Toast.makeText(context.getApplicationContext(), cs, Toast.LENGTH_LONG).show();
    }


}
