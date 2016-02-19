package com.me.diankun.navigationtwo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * RadioGroup + RadioButton 方式
 *
 * Blog：http://www.runoob.com/w3cnote/android-tutorial-fragment-demo2.html
 */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {


    private RadioGroup rg_bottom_bar;
    private RadioButton rb_channel,rb_message,rb_my,rb_setting;

    private ContentFragment channelFragment, messageFragment, myFragment, settingFragment;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        rg_bottom_bar = (RadioGroup) findViewById(R.id.rg_bottom_bar);
        rb_channel = (RadioButton) findViewById(R.id.rb_channel);
        rg_bottom_bar.setOnCheckedChangeListener(this);
        //获取第一个单选按钮，并设置其为选中状态
        rb_channel.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        //注意，此处的hide，show 要一起commit
        FragmentTransaction transaction = fm.beginTransaction();
        hideAllFragment(transaction);
        switch (checkedId) {
            case R.id.rb_channel:
                if (channelFragment == null) {
                    channelFragment = ContentFragment.newInstance("Channel");
                    transaction.add(R.id.fl_container, channelFragment);
                }
                transaction.show(channelFragment);
                break;
            case R.id.rb_message:
                if (messageFragment == null) {
                    messageFragment = ContentFragment.newInstance("Message");
                    transaction.add(R.id.fl_container, messageFragment);
                }
                transaction.show(messageFragment);
                break;
            case R.id.rb_my:
                if (myFragment == null) {
                    myFragment = ContentFragment.newInstance("My");
                    transaction.add(R.id.fl_container, myFragment);
                }
                transaction.show(myFragment);
                break;
            case R.id.rb_setting:
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
}
