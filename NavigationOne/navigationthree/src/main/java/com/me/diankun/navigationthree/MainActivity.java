package com.me.diankun.navigationthree;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 导航上显示气泡
 *
 * Blog：http://www.runoob.com/w3cnote/android-tutorial-fragment-demo3.html
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout ly_tab_menu_channel, ly_tab_menu_message, ly_tab_menu_my, ly_tab_menu_setting;
    //文字
    private TextView tab_menu_channel, tab_menu_message, tab_menu_my, tab_menu_setting;
    //气泡
    private TextView tab_menu_channel_num, tab_menu_message_num, tab_menu_my_num, tab_menu_setting_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();

        //添加提醒Fragment
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.fl_container, ContentFragment.newInstance("Chanell")).commit();
    }

    private void bindView() {
        ly_tab_menu_channel = (LinearLayout) findViewById(R.id.ly_tab_menu_channel);
        ly_tab_menu_message = (LinearLayout) findViewById(R.id.ly_tab_menu_message);
        ly_tab_menu_my = (LinearLayout) findViewById(R.id.ly_tab_menu_my);
        ly_tab_menu_setting = (LinearLayout) findViewById(R.id.ly_tab_menu_setting);
        //注册监听
        ly_tab_menu_channel.setOnClickListener(this);
        ly_tab_menu_message.setOnClickListener(this);
        ly_tab_menu_my.setOnClickListener(this);
        ly_tab_menu_setting.setOnClickListener(this);
        //文字
        tab_menu_channel = (TextView) findViewById(R.id.tab_menu_channel);
        tab_menu_message = (TextView) findViewById(R.id.tab_menu_message);
        tab_menu_my = (TextView) findViewById(R.id.tab_menu_my);
        tab_menu_setting = (TextView) findViewById(R.id.tab_menu_setting);
        //气泡
        tab_menu_channel_num = (TextView) findViewById(R.id.tab_menu_channel_num);
        tab_menu_message_num = (TextView) findViewById(R.id.tab_menu_message_num);
        tab_menu_my_num = (TextView) findViewById(R.id.tab_menu_my_num);
        tab_menu_setting_num = (TextView) findViewById(R.id.tab_menu_setting_num);
    }

    @Override
    public void onClick(View view) {
        resetTextSelected();
        switch (view.getId()) {
            case R.id.ly_tab_menu_channel:
                tab_menu_channel.setSelected(true);
                tab_menu_channel_num.setVisibility(View.INVISIBLE);
                break;
            case R.id.ly_tab_menu_message:
                tab_menu_message.setSelected(true);
                tab_menu_message_num.setVisibility(View.INVISIBLE);
                break;
            case R.id.ly_tab_menu_my:
                tab_menu_my.setSelected(true);
                tab_menu_my_num.setVisibility(View.INVISIBLE);
                break;
            case R.id.ly_tab_menu_setting:
                tab_menu_setting.setSelected(true);
                tab_menu_setting_num.setVisibility(View.INVISIBLE);
                break;
            default:
                break;
        }
    }

    private void resetTextSelected() {
        tab_menu_channel.setSelected(false);
        tab_menu_message.setSelected(false);
        tab_menu_my.setSelected(false);
        tab_menu_setting.setSelected(false);
    }
}
