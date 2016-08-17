package com.qf.luckey.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qf.luckey.staryichu.R;
import com.qf.luckey.entity.Project2Entity;

import java.util.List;

/**
 * Created by Administrator on 2016/8/11.
 */
public class DaPei2Adapter extends RecyclerView.Adapter {
    private Context context;
    private List<Project2Entity.DataBean.ItemsBean> data;

    public DaPei2Adapter(Context context, List<Project2Entity.DataBean.ItemsBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ir_item2,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyHolder)holder).title.setText(data.get(position).getComponent().getTitle());
        ((MyHolder)holder).trend.setText("#"+data.get(position).getComponent().getTagAction().getTag()+"#");
        ((MyHolder)holder).year.setText(data.get(position).getComponent().getYear()+"."+data.get(position).getComponent().getMonth()+"."
        +data.get(position).getComponent().getDay());
        Glide.with(context).load(data.get(position).getComponent().getPicUrl()).into(((MyHolder)holder).iv);

    }

    /**
     * 建造一个viewholder
     */
    static class MyHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView trend;
        TextView year;
        ImageView iv;
        public MyHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.sub_title);
            trend = (TextView) itemView.findViewById(R.id.sub_trend);
            year = (TextView) itemView.findViewById(R.id.sub_year);
            iv = (ImageView) itemView.findViewById(R.id.sub_iv2);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
