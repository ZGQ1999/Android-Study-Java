package com.example.miapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HomeBottomAdapter extends BaseAdapter {

    private Context context;
    private List<HomeBottomItem> datas;

    public HomeBottomAdapter(Context context, List<HomeBottomItem> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        holder = null;
        if (view == null) {
            view = View.inflate(context,R.layout.home_activity_list1,null);
            holder = new ViewHolder();
            holder.homeIcon = view.findViewById(R.id.home_top_pic);
            holder.textView = view.findViewById(R.id.home_top_text);
            holder.textView1 = view.findViewById(R.id.home_bottom_text);
            view.setTag(holder);
        } else {
            holder = (HomeBottomAdapter.ViewHolder) view.getTag();
        }
        HomeBottomItem homeBottomItem = datas.get(i);
        holder.homeIcon.setBackgroundResource(homeBottomItem.getImage());
        holder.textView.setText(homeBottomItem.getContent());
        holder.textView1.setText(homeBottomItem.getPrice());
        return view;
    }

    static class ViewHolder {
        ImageView homeIcon;
        TextView textView;
        TextView textView1;
    }
}
