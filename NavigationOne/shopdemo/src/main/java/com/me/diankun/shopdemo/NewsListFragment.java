package com.me.diankun.shopdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by diankun on 2016/2/19.
 */
public class NewsListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private FragmentManager fm;
    private ListView mListView;
    private NewsAdapter mAdapter;
    private ArrayList<Data> mDatas;

    private static final String TAG = NewsListFragment.class.getSimpleName();

    public static NewsListFragment newInstance(ArrayList<Data> datas) {
        NewsListFragment listFragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("datas", datas);
        listFragment.setArguments(bundle);
        return listFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (Constants.ISDEBUG) Log.i(TAG, "onAttach");
        fm = ((MainActivity) context).getSupportFragmentManager();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Constants.ISDEBUG) Log.i(TAG, "onCreate");
        Bundle bundle = getArguments();
        mDatas = (ArrayList<Data>) bundle.getSerializable("datas");
        if (mDatas == null) mDatas = new ArrayList<Data>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (Constants.ISDEBUG) Log.i(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_newslist, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (Constants.ISDEBUG) Log.i(TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        mListView = (ListView) view.findViewById(R.id.lv_news);
        mAdapter = new NewsAdapter(mDatas, getContext());
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        FragmentTransaction transaction = fm.beginTransaction();
        String new_content = mDatas.get(i).getNew_content();
        String new_title = mDatas.get(i).getNew_title();
        NewsContentFragment contentFragment = NewsContentFragment.newInstance(new_content);
        //设置标题
        TextView title = (TextView) getActivity().findViewById(R.id.txt_title);
        title.setText(new_title);
        //加上Fragment替换动画
        transaction.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit, R.anim.fragment_slide_left_pop_enter, R.anim.fragment_slide_left_pop_exit);
        //显示详细
        transaction.replace(R.id.fl_container, contentFragment);
        //调用addToBackStack将Fragment添加到栈中
        transaction.addToBackStack(null);
        transaction.commit();
    }


    ////////////////
    ////   TAG  ////
    ////////////////
    @Override
    public void onStart() {
        super.onStart();
        if (Constants.ISDEBUG) Log.i(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        if (Constants.ISDEBUG) Log.i(TAG, "onResume");
        ((TextView) getActivity().findViewById(R.id.txt_title)).setText("新闻列表");
    }


    @Override
    public void onPause() {
        super.onPause();
        if (Constants.ISDEBUG) Log.i(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Constants.ISDEBUG) Log.i(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (Constants.ISDEBUG) Log.i(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (Constants.ISDEBUG) Log.i(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (Constants.ISDEBUG) Log.i(TAG, "onDetach");
    }
}

