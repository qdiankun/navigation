package com.me.diankun.navigationthree;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by diankun on 2016/2/19.
 */
public class ContentFragment extends Fragment implements View.OnClickListener {

    private Button btn_one, btn_two, btn_three, btn_four;


    private String content;

    public static ContentFragment newInstance(String content) {
        ContentFragment contentFragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("content", content);
        contentFragment.setArguments(bundle);
        return contentFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) content = bundle.getString("content");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
        if (!TextUtils.isEmpty(content)) txt_content.setText(content);

        btn_one = (Button) view.findViewById(R.id.btn_one);
        btn_two = (Button) view.findViewById(R.id.btn_two);
        btn_three = (Button) view.findViewById(R.id.btn_three);
        btn_four = (Button) view.findViewById(R.id.btn_four);
        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                TextView tab_menu_channel_num = (TextView) getActivity().findViewById(R.id.tab_menu_channel_num);
                tab_menu_channel_num.setVisibility(View.VISIBLE);
                tab_menu_channel_num.setText("99+");
                break;
            case R.id.btn_two:
                TextView tab_menu_message_num = (TextView) getActivity().findViewById(R.id.tab_menu_message_num);
                tab_menu_message_num.setVisibility(View.VISIBLE);
                tab_menu_message_num.setText("30");
                break;
            case R.id.btn_three:
                TextView tab_menu_my_num = (TextView) getActivity().findViewById(R.id.tab_menu_my_num);
                tab_menu_my_num.setVisibility(View.VISIBLE);
                tab_menu_my_num.setText("15");
                break;
            case R.id.btn_four:
                TextView tab_menu_setting_num = (TextView) getActivity().findViewById(R.id.tab_menu_setting_num);
                tab_menu_setting_num.setVisibility(View.VISIBLE);
                tab_menu_setting_num.setText("2");
                break;
            default:
                break;
        }
    }
}
