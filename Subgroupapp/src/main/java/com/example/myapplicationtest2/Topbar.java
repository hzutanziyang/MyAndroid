package com.example.myapplicationtest2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.sip.SipSession;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by 洋 on 2019/3/21.
 */

public class Topbar extends RelativeLayout {
    private Button leftbutton,rightbutton;
    private TextView textView;
    private String mtitle,lefttext,righttext;
    private Drawable titlebackground,leftbackground,rightbackground;
    private int titletextcolor,lefttextcolor,righttextcolor;
    private float titletextsize,lefttextsize,righttextsize;
    private LayoutParams leftParams,rightParams,tittleParams;
    private onTopbaronClickListener listener;


    public interface onTopbaronClickListener{
        public void leftonClick();
        public void rightonClick();
    }

    public void setOnTopbaronClickListener(onTopbaronClickListener listener){
        this.listener = listener;
    }

    public Topbar(Context context, AttributeSet attrs) {
        super(context, attrs);

        //获取xml种的属性
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.Topbar);

        mtitle = array.getString(R.styleable.Topbar_title);
        //titlebackground = array.getDrawable(R.styleable.Topbar_titlebackground);
       // titletextcolor = array.getColor(R.styleable.Topbar_titletextcolor,0);
        titletextsize = array.getDimension(R.styleable.Topbar_titletextsize,10);

        lefttext = array.getString(R.styleable.Topbar_lefttext);
        //leftbackground = array.getDrawable(R.styleable.Topbar_leftbackground);
        //lefttextcolor = array.getColor(R.styleable.Topbar_lefttextcolor,0);
        lefttextsize = array.getDimension(R.styleable.Topbar_lefttextsize,10);

        righttext = array.getString(R.styleable.Topbar_righttext);
        //rightbackground = array.getDrawable(R.styleable.Topbar_rightbackground);
        //righttextcolor = array.getColor(R.styleable.Topbar_righttextcolor,0);
        righttextsize = array.getDimension(R.styleable.Topbar_righttextsize,10);
        array.recycle();

        //设置控件属性
        leftbutton = new Button(context);
        rightbutton = new Button(context);
        textView = new TextView(context);

        textView.setText(mtitle);
        //textView.setTextColor(titletextcolor);
        textView.setTextSize(titletextsize);
        textView.setGravity(Gravity.CENTER);
        //textView.setBackground(titlebackground);

        //leftbutton.setBackground(leftbackground);
        leftbutton.setText(lefttext);
        //leftbutton.setTextColor(lefttextcolor);
        leftbutton.setTextSize(lefttextsize);

        //rightbutton.setBackground(rightbackground);
        rightbutton.setText(righttext);
        //rightbutton.setTextColor(righttextcolor);
        rightbutton.setTextSize(righttextsize);

        //把控件添加到Topbar
        leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        addView(leftbutton, leftParams);

        rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(rightbutton,rightParams);

        tittleParams = new LayoutParams(LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT);
        tittleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(textView,tittleParams);



        rightbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightonClick();
            }
        });
        leftbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.leftonClick();
            }
        });
    }


}
