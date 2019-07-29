package com.example.myapplicationtest2.News;

/**
 * Created by 洋 on 2019/7/10.
 */

public class News {

    String mtitle,mcontent;

    public void setText(String title){
        this.mtitle = title;
    }
    public String getText(){
        return mtitle;
    }
    public void setContent(String content){
        this.mcontent = content;
    }
    public String getContent(){
        return mcontent;
    }

}
