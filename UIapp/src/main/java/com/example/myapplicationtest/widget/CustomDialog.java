package com.example.myapplicationtest.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.myapplicationtest.R;

/**
 * Created by 洋 on 2019/1/12.
 */

public class CustomDialog extends Dialog implements View.OnClickListener{
    private TextView mTvtitle,mTvmassage,mTvcancel,mTvcomfirm;
    private String title,massage,cancel,comfirm;
    private IonCancelListener cancelListener;
    private IonComfirmListener comfirmListener;
    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMassage(String massage) {
        this.massage = massage;
        return this;
    }

    public CustomDialog setCancel(String cancel,IonCancelListener listener) {
        this.cancel = cancel;
        this.cancelListener = listener;
        return this;
    }

    public CustomDialog setComfirm(String comfirm,IonComfirmListener listener) {
        this.comfirm = comfirm;
        this.comfirmListener = listener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        mTvtitle = findViewById(R.id.tv_title);
        mTvmassage = findViewById(R.id.tv_massage);
        mTvcancel = findViewById((R.id.tv_cancel));
        mTvcomfirm = findViewById(R.id.tv_comfirm);
        //设置Dialog的宽度
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int)(size.x*0.8);//设置Dialog的宽度为当前屏幕的80%
        getWindow().setAttributes(p);
        if (!TextUtils.isEmpty(title)){
            mTvtitle.setText(title);
        }
        if(!TextUtils.isEmpty(massage)){
            mTvmassage.setText(massage);
        }
        if (!TextUtils.isEmpty(cancel)){
            mTvcancel.setText(cancel);
        }
        if(!TextUtils.isEmpty(comfirm)){
            mTvcomfirm.setText(comfirm);
        }
        mTvcancel.setOnClickListener(this);
        mTvcomfirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_cancel:
                if(cancelListener != null){
                    cancelListener.onCencel(this);
                }
                dismiss();
            break;
            case R.id.tv_comfirm:
                if (comfirmListener != null){
                    comfirmListener.onComfirm(this);
                }
                dismiss();
            break;

        }
    }

    public interface IonCancelListener{
        void onCencel(CustomDialog dialog);
    }
    public interface IonComfirmListener{
        void onComfirm(CustomDialog dialog);
    }
}
