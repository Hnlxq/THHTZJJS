package com.tech.migoo.thhtzjjs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.tech.migoo.thhtzjjs.R;

/**
 * Created by migoo_houhh on 16/6/13.
 */
public class ShenpiAdapter extends BaseAdapter{

    private Context context;
    private LayoutInflater inflater;
    private String[] data;

    public ShenpiAdapter(Context context, String[] data){
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.cell_shenpi_grid, null);
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            int width = wm.getDefaultDisplay().getWidth();
            convertView.setLayoutParams(new GridView.LayoutParams(width / 3,width / 3));
            holder = new ViewHolder();

            holder.icon = (ImageView) convertView.findViewById(R.id.img_shenpi_cell);
            holder.name = (TextView) convertView.findViewById(R.id.txt_shenpi_cell);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.icon.setImageResource(R.mipmap.icon_homepage);
        holder.name.setText(data[position]);

        return convertView;
    }

    private class ViewHolder{
        ImageView icon;
        TextView name;
    }
}
