package com.tech.migoo.thhtzjjs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tech.migoo.thhtzjjs.R;

/**
 * Created by migoo_houhh on 16/6/13.
 */
public class HeadView extends RelativeLayout {

    private Context mContext;
    private TextView titleTxt; //标题
    private TextView backtxt;  //返回大厅
    private Button drawer_btn; //菜单按钮

    public HeadView(Context context) {
        this(context,null);
    }

    public HeadView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public HeadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    public HeadView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(){
        if (!isInEditMode()){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.common_head, this);

            titleTxt = (TextView) findViewById(R.id.tv_main_title);
            backtxt = (TextView) findViewById(R.id.tv_main_back);
            drawer_btn = (Button) findViewById(R.id.btn_drawer);
        }
    }

    public void setOnClickListener(OnClickListener listener){
        drawer_btn.setOnClickListener(listener);
        backtxt.setOnClickListener(listener);
    }

    public void setTitleTxt(String title){
        titleTxt.setText(title);
    }


}
