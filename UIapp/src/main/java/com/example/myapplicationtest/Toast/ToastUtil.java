package com.example.myapplicationtest.Toast;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 洋 on 2018/11/12.
 */

public class ToastUtil {
    public static Toast mtoast;
    public static void showMsg(Context context,String msg){
        if(mtoast == null){
            mtoast = Toast.makeText(context,msg,Toast.LENGTH_LONG);
        }else{
            mtoast.setText(msg);
        }
        mtoast.show();
    }
}
