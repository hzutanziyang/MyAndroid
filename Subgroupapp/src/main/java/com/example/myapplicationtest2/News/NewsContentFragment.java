package com.example.myapplicationtest2.News;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplicationtest2.R;

/**
 * Created by 洋 on 2019/7/10.
 */

public class NewsContentFragment extends Fragment {

    private View view;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag,container,false);
        return view;
    }

    //更新布局控件的内容
    public void refresh(String newsTitle,String newsContent){
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView newsTitleText = view.findViewById(R.id.tv_title);
        TextView newsContentText = view.findViewById(R.id.tv_content);
        newsContentText.setText(newsContent);
        newsTitleText.setText(newsTitle);
    }
}
