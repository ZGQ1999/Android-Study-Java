package com.example.miapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HomeTopAdapter extends BaseAdapter {

    private Context context;
    private List<HomeTopItem> datas;

    public HomeTopAdapter(Context context, List<HomeTopItem> datas) {
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
            view = View.inflate(context,R.layout.home_activity_list,null);
            holder = new ViewHolder();
            holder.homeIcon = view.findViewById(R.id.home_top_pic);
            holder.textView = view.findViewById(R.id.home_top_text);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        HomeTopItem homeTopItem = datas.get(i);
        holder.homeIcon.setBackgroundResource(homeTopItem.getImage());
        holder.textView.setText(homeTopItem.getName());
        return view;
    }

    static class ViewHolder {
        ImageView homeIcon;
        TextView textView;
    }
}
