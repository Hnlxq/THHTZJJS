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
public class ChaxunFragment extends Fragment {

    private Context context;
    private View view;
    private GridView gridView;
    private ShenpiAdapter adapter;
    private String[] chaxun = {"结算单汇总统计","机票销售汇总统计","合同信息","作业通知单",
            "工作量签证单","暂估单","结算单","合同执行分析","单位合同综合","分类合同综合",
            "单位预算综合","公司预算综合"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chaxun, container, false);
        context = getActivity();
        init();
        return view;
    }

    private void init(){
        gridView = (GridView) view.findViewById(R.id.gridView_chaxun);
        adapter = new ShenpiAdapter(context,chaxun);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, chaxun[position], Toast.LENGTH_LONG).show();

            }
        });
    }
}
