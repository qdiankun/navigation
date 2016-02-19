package com.me.diankun.shopdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by diankun on 2016/2/19.
 */
public class NewsContentFragment extends Fragment {


    private String content;
    private static final String TAG = NewsContentFragment.class.getSimpleName();

    public static NewsContentFragment newInstance(String content) {
        NewsContentFragment contentFragment = new NewsContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("content", content);
        contentFragment.setArguments(bundle);
        return contentFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if(Constants.ISDEBUG) Log.e(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) content = bundle.getString("content");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(Constants.ISDEBUG)Log.e(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_newscontent, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if(Constants.ISDEBUG)Log.e(TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
        if (!TextUtils.isEmpty(content)) txt_content.setText(content);
    }

    ////////////////
    ////   TAG  ////
    ////////////////
    @Override
    public void onStart() {
        super.onStart();
        if(Constants.ISDEBUG)Log.e(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        if(Constants.ISDEBUG)Log.e(TAG, "onResume");
    }


    @Override
    public void onPause() {
        super.onPause();
        if(Constants.ISDEBUG)Log.e(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        if(Constants.ISDEBUG)Log.e(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(Constants.ISDEBUG)Log.e(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(Constants.ISDEBUG)Log.e(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(Constants.ISDEBUG)Log.e(TAG, "onDetach");
    }

}
