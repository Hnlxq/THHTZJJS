package com.tech.migoo.thhtzjjs.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.tech.migoo.thhtzjjs.R;
import com.tech.migoo.thhtzjjs.adapter.ShenpiAdapter;

/**
 * Created by migoo_houhh on 16/6/14.
 */
public class ShenqingFragment extends Fragment {

    private Context context;
    private View view;
    private GridView gridView;
    private ShenpiAdapter adapter;
    private String[] shenpi = {"请假","报销","出差","外出","立项申请","会议审批"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shengqing, container, false);
        context = getActivity();
        init();
        return view;
    }

    private void init() {
        gridView = (GridView) view.findViewById(R.id.gridView_shenqing);
        adapter = new ShenpiAdapter(context,shenpi);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, shenpi[position], Toast.LENGTH_LONG).show();

            }
        });
    }
}
