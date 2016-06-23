package com.tech.migoo.thhtzjjs;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.tech.migoo.thhtzjjs.fragment.ChaxunFragment;
import com.tech.migoo.thhtzjjs.fragment.MeFragment;
import com.tech.migoo.thhtzjjs.fragment.NavigationDrawerFragment;
import com.tech.migoo.thhtzjjs.fragment.ShenpiFragment;
import com.tech.migoo.thhtzjjs.fragment.ShenqingFragment;
import com.tech.migoo.thhtzjjs.view.HeadView;

public class MainActivity extends FragmentActivity {

    private DrawerLayout drawerLayout; //抽屉视图
    private FrameLayout loadViewFlayout; //启动页面
    private FrameLayout containerFlayout; //主视图容器
    private Animation loadAnimation; //启动页面动画
    private FrameLayout navigationLayout; //侧滑视图
    private static final int SET_VIEW=1004; //进入主页面


    private LinearLayout containerLayout; //主视图
    private RadioGroup bottomRgroup;
    private RadioButton shenqingRbtn, shenpiRbtn, chaxunRbtn, meRbtn;
    private HeadView headView; //顶部视图

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private ShenqingFragment shenqingFragment;
    private ShenpiFragment shenpiFragment;
    private ChaxunFragment chaxunFragment;
    private MeFragment meFragment;
    private NavigationDrawerFragment navigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        //默认进来加载的是CommentFragment
        if (savedInstanceState == null){
            transaction.add(R.id.flayout_main, new ShenpiFragment()).commit();
        }
        initUI();
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        loadView();
        onCheckedChangeListener();
    }

    @Override
    protected void onStop() {
        super.onStop();
        drawerLayout.closeDrawer(navigationLayout);
    }

    /**
     * 初始化控件
     */
    private void initUI (){
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //侧滑视图
        navigationLayout = (FrameLayout) findViewById(R.id.navigation_layout);
        if (navigationDrawerFragment == null){
            navigationDrawerFragment = new NavigationDrawerFragment();
        }
        transaction.add(R.id.navigation_layout, navigationDrawerFragment);

        //头部视图
        headView = (HeadView) findViewById(R.id.common_head);
        headView.setOnClickListener(new ClickListener());

        containerLayout = (LinearLayout) findViewById(R.id.main_container);
        containerLayout.setVisibility(View.GONE); //刚进来让主视图隐藏

        loadViewFlayout = (FrameLayout) findViewById(R.id.flayout_welcome);
        containerFlayout = (FrameLayout) findViewById(R.id.flayout_main);
        loadAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha_in);

        bottomRgroup = (RadioGroup) findViewById(R.id.rgroup_bottom_bar);
        shenqingRbtn = (RadioButton) findViewById(R.id.rBtn_shenqing);
        shenpiRbtn = (RadioButton) findViewById(R.id.rBtn_shenpi);
        chaxunRbtn = (RadioButton) findViewById(R.id.rBtn_chaxun);
        meRbtn = (RadioButton) findViewById(R.id.rBtn_me);
    }

    /**
     * 切换监听
     */
    private void onCheckedChangeListener(){
        bottomRgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                transaction = fragmentManager.beginTransaction();
                switch (checkedId) {
                    case R.id.rBtn_shenqing:
                        headView.setTitleTxt("申请");
                        if (shenqingFragment == null) {
                            shenqingFragment = new ShenqingFragment();
                        }
                        transaction.replace(R.id.flayout_main, shenqingFragment).commit();
                        break;
                    case R.id.rBtn_shenpi:
                        headView.setTitleTxt("审批");
                        if (shenpiFragment == null) {
                            shenpiFragment = new ShenpiFragment();
                        }
                        transaction.replace(R.id.flayout_main, shenpiFragment).commit();
                        break;
                    case R.id.rBtn_chaxun:
                        headView.setTitleTxt("查询");
                        if (chaxunFragment == null) {
                            chaxunFragment = new ChaxunFragment();
                        }
                        transaction.replace(R.id.flayout_main, chaxunFragment).commit();
                        break;
                    case R.id.rBtn_me:
                        headView.setTitleTxt("我");
                        if (meFragment == null) {
                            meFragment = new MeFragment();
                        }
                        transaction.replace(R.id.flayout_main, meFragment).commit();
                        break;
                }
            }
        });
    }

    /**
     * 加载启动页
     */
    private void loadView() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                loadViewFlayout.startAnimation(loadAnimation);
                try {
                    Thread.sleep(2000);
                    mHandler.sendEmptyMessage(SET_VIEW);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    /**
     * 发送消息
     */
    android.os.Handler mHandler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case SET_VIEW:
                    loadViewFlayout.setVisibility(View.GONE);
                    containerLayout.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    /**
     * 头部按钮的监听
     */
    private class ClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_drawer:
                    drawerLayout.openDrawer(navigationLayout);
                    break;
                case R.id.tv_main_back:
                    Toast.makeText(MainActivity.this,"返回应用大厅",Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}
