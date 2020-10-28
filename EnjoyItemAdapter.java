package com.example.miapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EnjoyItemAdapter extends BaseAdapter {

    private Context context;
    private List<EnjoyItem> datas;

    public EnjoyItemAdapter(Context context, List<EnjoyItem> datas) {
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
            view = View.inflate(context,R.layout.home_activity_list2,null);
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.home_top_pic);
            holder.textView = view.findViewById(R.id.home_top_text);
            holder.imageView1 = view.findViewById(R.id.enjoy_top_text);
            view.setTag(holder);
        } else {
            holder = (EnjoyItemAdapter.ViewHolder) view.getTag();
        }
        EnjoyItem enjoyItem = datas.get(i);
        holder.imageView.setBackgroundResource(enjoyItem.getImage());
        holder.textView.setText(enjoyItem.getContent());
        holder.imageView1.setBackgroundResource(enjoyItem.getImage1());

        return view;
    }
    static class ViewHolder {
        ImageView imageView;
        TextView textView;
        ImageView imageView1;
    }
}
