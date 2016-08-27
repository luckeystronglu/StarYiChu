package com.qf.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;
    private List<String> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        initData();
        mMyAdapter = new MyAdapter(mList);
        mRecyclerView.setAdapter(mMyAdapter);

        //为RecyclerView添加HeaderView和FooterView
        setHeaderView(mRecyclerView);
        setFooterView(mRecyclerView);
    }

    private void initData() {
        mList = new ArrayList<String>();
        for (int i = 0; i < 30; i++){
            mList.add("item" + i);
        }
    }

    private void setHeaderView(RecyclerView view){
        View header = LayoutInflater.from(this).inflate(R.layout.header, view, false);
        mMyAdapter.setHeaderView(header);
    }

    private void setFooterView(RecyclerView view){
        View footer = LayoutInflater.from(this).inflate(R.layout.footer, view, false);
        mMyAdapter.setFooterView(footer);
    }
}
