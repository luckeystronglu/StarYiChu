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
import com.qf.luckey.entity.FitEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/8/11.
 */
public class DaPeiAdapter extends RecyclerView.Adapter {
    public static final String items[] = {"timedrop;;2016","star;;2016"};
    private Context context;
    private List<FitEntity.DataEntity.ItemsEntity> data;

    public DaPeiAdapter(Context context, List<FitEntity.DataEntity.ItemsEntity> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == 0){
            view = LayoutInflater.from(context).inflate(R.layout.ir_item_dapei01,null);
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.ir_item_dapei02,null);
        }

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String txt = "";
        if (getItemViewType(position) == 0){
            txt = data.get(position).getComponent().getXingQi();
        }else {
            txt = data.get(position).getComponent().getDescription();
        }
        ((MyHolder)holder).tv.setText(txt);
        
        if (((MyHolder)holder).iv != null){
            Glide.with(context).load(data.get(position).getComponent().getPicUrl()).into(((MyHolder)holder).iv);

        }

    }

    @Override
    public int getItemViewType(int position) {
        String type = data.get(position).getComponent().getShowType();
        if (items[0].equals(type)){
            return 0;
        }
        return 1;
    }

    /**
     * 建造一个viewholder
     */
    static class MyHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        public MyHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.rc_img);
            tv = (TextView) itemView.findViewById(R.id.rc_tv);

        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
