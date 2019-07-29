package com.example.myapplicationtest.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplicationtest.R;

/**
 * Created by 洋 on 2019/2/25.
 */

public class BFragment extends Fragment {
    private TextView mtvtitle;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_bfragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mtvtitle = view.findViewById(R.id.tv_title);
        super.onViewCreated(view, savedInstanceState);
    }
}
