package com.example.myapplicationtest.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplicationtest.R;

/**
 * Created by 洋 on 2019/2/25.
 */

public class AFragment extends Fragment {
    private TextView mtvtitle;
    private BFragment bFragment;
    private Button mbtchange,mbtreset,mbtchangetext;
    private IOnMessageClick listent;
    public static Fragment newfragment(String title){
        AFragment fragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listent = (IOnMessageClick) context;
        }catch (ClassCastException e){
            throw new ClassCastException("Activity 必须实现IOnMessageClick接口");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_afragment,container,false);
        Log.d("AFagment","---onCreateView---");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mtvtitle = view.findViewById(R.id.tv_title);
        mbtchange = view.findViewById(R.id.bt_change);
        mbtreset = view.findViewById(R.id.bt_reset);
        mbtchangetext = view.findViewById(R.id.bt_changetext);
        mbtchangetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((ConstainerActivity)getActivity()).setData("你好");
                listent.onClick("你好");
            }
        });
        if(getArguments()!=null){
            mtvtitle.setText(getArguments().getString("title"));
        }
        mbtchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFragment == null){
                    bFragment = new BFragment();
                }
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if(fragment != null){
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.m_fl,bFragment).addToBackStack(null).commitAllowingStateLoss();
                }else {
                    getFragmentManager().beginTransaction().replace(R.id.m_fl,bFragment).addToBackStack(null).commitAllowingStateLoss();
                }
            }
        });
        mbtreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtvtitle.setText("我是新文字");
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
    public interface IOnMessageClick{
        void onClick(String text);
    }


}
