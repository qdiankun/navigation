package com.me.diankun.shopdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Data> mDatas;
    private FragmentManager fm;
    private long exitTime = 0;
    private TextView txt_title;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Constants.ISDEBUG)Log.d("TAG", "onCreate()");
        setContentView(R.layout.activity_main);
        txt_title = (TextView) findViewById(R.id.txt_title);

        initDatas();

        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.fl_container, NewsListFragment.newInstance(mDatas)).commit();
    }

    private void initDatas() {
        mDatas = new ArrayList<Data>();
        Data data = null;
        for (int i = 0; i < 20; i++) {
            data = new Data("News Title " + i, "News Content " + i);
            mDatas.add(data);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Constants.ISDEBUG)Log.d("TAG", "onCreate()");
        txt_title.setText("新闻列表");
    }

    //点击回退键的处理：判断Fragment栈中是否有Fragment
    //没，双击退出程序，否则像是Toast提示
    //有，popbackstack弹出栈

    @Override
    public void onBackPressed() {
        if (fm.getBackStackEntryCount() == 0) {
            if (System.currentTimeMillis() - exitTime > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }
        } else {
            //fm.popBackStack();
            super.onBackPressed();
        }
    }



    ////////////////
    ////   TAG  ////
    ////////////////

    @Override
    protected void onStart() {
        super.onStart();
        if(Constants.ISDEBUG)Log.d(TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(Constants.ISDEBUG)Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(Constants.ISDEBUG)Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(Constants.ISDEBUG)Log.d(TAG, "onDestroy");
    }
}
