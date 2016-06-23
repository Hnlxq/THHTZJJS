package com.tech.migoo.thhtzjjs.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tech.migoo.thhtzjjs.R;
import com.tech.migoo.thhtzjjs.UserCenterBean;
import com.tech.migoo.thhtzjjs.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by migoo_houhh on 16/6/14.
 */
public class MeFragment extends Fragment {

    private Context context;
    private View view;
    private ListView userList;
    private int[] userCentreIcon = {R.mipmap.user_sign_in,R.mipmap.user_msg,R.mipmap.user_centre,R.mipmap.user_daibanshiyi,R.mipmap.user_more};
    private String[] userCentreName = {"签到","系统消息","通讯录","待办事宜","更多"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_me, container, false);
        init();
        return view;
    }

    private void init() {
        userList = (ListView) view.findViewById(R.id.list_me);
        List<UserCenterBean> data = new ArrayList<>();
        for (int i = 0; i < userCentreName.length; i++){
            data.add(new UserCenterBean(userCentreIcon[i],userCentreName[i]));
        }
        MyAdapter<UserCenterBean> adapter = new MyAdapter<UserCenterBean>
                ((ArrayList)data, R.layout.cell_user_centre) {
            @Override
            public void bindView(ViewHolder holder, UserCenterBean obj) {
                holder.setImageResource(R.id.img_cell_user_centre, obj.getCentreIcon());
                holder.setText(R.id.txt_cell_user_centre, obj.getCentreName());
            }
        };
        userList.setAdapter(adapter);
    }
}
