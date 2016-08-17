package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mylhyl.crlayout.SwipeRefreshAdapterView;
import com.mylhyl.crlayout.SwipeRefreshRecyclerView;
import com.qf.luckey.staryichu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
public class ReFlushFragment extends Fragment implements SwipeRefreshAdapterView.OnListLoadListener, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshRecyclerView swipeRefreshRecyclerView;
    private RecyclerViewAdapter adapter;
    private List<String> objects = new ArrayList<>();
    private int index;
    private int footerIndex = 20;
    public static final String TAG = "print";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_view_xml, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipeRefreshRecyclerView = (SwipeRefreshRecyclerView) view.findViewById(R.id.swipeRefresh);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
        swipeRefreshRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        swipeRefreshRecyclerView.setOnListLoadListener(this);
        swipeRefreshRecyclerView.setOnRefreshListener(this);

        for (int i = 0; i < footerIndex; i++) {
            objects.add("数据 = " + i);
        }
        adapter = new RecyclerViewAdapter();
        swipeRefreshRecyclerView.setAdapter(adapter);
        swipeRefreshRecyclerView.setEmptyText("数据又没有了!");
    }

    @Override
    public void onListLoad() {
        ++index;
        swipeRefreshRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                int count = footerIndex + 5;
                for (int i = footerIndex; i < count; i++) {
                    objects.add("上拉 = " + i);
                }
                footerIndex = count;
                adapter.notifyDataSetChanged();
                swipeRefreshRecyclerView.setLoading(false);
                Toast.makeText(getActivity(), "上拉加载更多 完毕", Toast.LENGTH_SHORT).show();
                if (index == 1) {
                    swipeRefreshRecyclerView.setLoadCompleted(true);

                }
            }
        }, 2000);
    }

    //下拉刷新并联网取数据
    @Override
    public void onRefresh() {
        index = 0;
//        MyApplication.utils.getNewData().enqueue(new Callback<FitEntity>() {
//            @Override
//            public void onResponse(Call<FitEntity> call, Response<FitEntity> response) {
//               String str =  response.body().getData().getItems().get(0).getComponent().getDescription();
//                Log.e(TAG, "onResponse: " + str);
//                swipeRefreshRecyclerView.setRefreshing(false);
//            }
//
//            @Override
//            public void onFailure(Call<FitEntity> call, Throwable t) {
//
//            }
//        });
//        swipeRefreshRecyclerView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                objects.add(0, "下拉 = " + (--index));
//                adapter.notifyDataSetChanged();
//                swipeRefreshRecyclerView.setRefreshing(false);
//                Toast.makeText(getActivity(), "下拉刷新", Toast.LENGTH_SHORT).show();
//            }
//        }, 1000);
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        @Override
        public int getItemCount() {
            return objects.size();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    getContext()).inflate(android.R.layout.simple_list_item_1, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((MyViewHolder) holder).tv.setText(objects.get(position));
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(android.R.id.text1);
            }
        }
    }
}
