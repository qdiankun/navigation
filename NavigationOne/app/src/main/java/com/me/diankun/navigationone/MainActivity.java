package com.me.diankun.navigationone;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * LinearLayout + TextView实现了底部导航栏的效果
 *
 * Blog：http://www.runoob.com/w3cnote/android-tutorial-fragment-demo1.html
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txt_channel, txt_message, txt_my, txt_setting;
    private ContentFragment channelFragment, messageFragment, myFragment, settingFragment;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        fm = getSupportFragmentManager();
        //模拟一次点击,点击提醒
        txt_channel.performClick();
        //onClick(txt_channel);
    }

    private void initView() {
        txt_channel = (TextView) findViewById(R.id.txt_channel);
        txt_message = (TextView) findViewById(R.id.txt_message);
        txt_my = (TextView) findViewById(R.id.txt_my);
        txt_setting = (TextView) findViewById(R.id.txt_setting);

        txt_channel.setOnClickListener(this);
        txt_message.setOnClickListener(this);
        txt_my.setOnClickListener(this);
        txt_setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //注意，此处的hide，show 要一起commit
        FragmentTransaction transaction = fm.beginTransaction();
        resetTextSelected();
        hideAllFragment(transaction);
        switch (view.getId()) {
            case R.id.txt_channel:
                txt_channel.setSelected(true);
                if (channelFragment == null) {
                    channelFragment = ContentFragment.newInstance("Channel");
                    transaction.add(R.id.fl_container, channelFragment);
                }
                transaction.show(channelFragment);
                break;
            case R.id.txt_message:
                txt_message.setSelected(true);
                if (messageFragment == null) {
                    messageFragment = ContentFragment.newInstance("Message");
                    transaction.add(R.id.fl_container, messageFragment);
                }
                transaction.show(messageFragment);
                break;
            case R.id.txt_my:
                txt_my.setSelected(true);
                if (myFragment == null) {
                    myFragment = ContentFragment.newInstance("My");
                    transaction.add(R.id.fl_container, myFragment);
                }
                transaction.show(myFragment);
                break;
            case R.id.txt_setting:
                txt_setting.setSelected(true);
                if (settingFragment == null) {
                    settingFragment = ContentFragment.newInstance("Setting");
                    transaction.add(R.id.fl_container, settingFragment);
                }
                transaction.show(settingFragment);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (channelFragment != null) fragmentTransaction.hide(channelFragment);
        if (messageFragment != null) fragmentTransaction.hide(messageFragment);
        if (myFragment != null) fragmentTransaction.hide(myFragment);
        if (settingFragment != null) fragmentTransaction.hide(settingFragment);
    }

    private void resetTextSelected() {
        txt_channel.setSelected(false);
        txt_message.setSelected(false);
        txt_my.setSelected(false);
        txt_setting.setSelected(false);
    }
}
