package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mylhyl.crlayout.SwipeRefreshAdapterView;
import com.mylhyl.crlayout.SwipeRefreshRecyclerView;
import com.qf.luckey.staryichu.MyApplication;
import com.qf.luckey.staryichu.R;
import com.qf.luckey.adapter.DaPeiAdapter;
import com.qf.luckey.entity.FitEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/8/11.
 */
public class DaiPei01Frag extends Fragment implements SwipeRefreshLayout.OnRefreshListener,
        SwipeRefreshAdapterView.OnListLoadListener {
//    private SwipeRefreshRecyclerView swipeRefreshRecyclerView;
    private DaPeiAdapter adapter;
    String flag = "";

    @Bind(R.id.swipeRefresh)
    SwipeRefreshRecyclerView dapei01Recycleview;

    List<FitEntity.DataEntity.ItemsEntity> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_recycler_view_xml, container, false);
        ButterKnife.bind(this, view1);
        dapei01Recycleview.setOnListLoadListener(this);
        dapei01Recycleview.setOnRefreshListener(this);

        getPicNews();

//        List<String> data = new ArrayList<>();
//        for (int i = 0; i < 20 ; i++) {
//            data.add("深圳"+ i);
//        }

        /**设置列表的布局方式*/
        GridLayoutManager manager = new GridLayoutManager(getContext(),2);
        dapei01Recycleview.setLayoutManager(manager);

        adapter = new DaPeiAdapter(getContext(),data);
        dapei01Recycleview.setAdapter(adapter);

        return view1;
    }

    //上拉加载更多并联网获取数据
    private void getPicNews() {
        Call<FitEntity> call = MyApplication.utils.getNewData("");
        call.enqueue(new Callback<FitEntity>() {
            @Override
            public void onResponse(Call<FitEntity> call, Response<FitEntity> response) {

                List<FitEntity.DataEntity.ItemsEntity> lists = response.body().getData().getItems();
                //获取保存flag值
                flag = response.body().getData().getFlag();
                /***把联网取到的数据，添加进数据源*/
                data.addAll(lists);
                /**通知adapter更新*/
                adapter.notifyDataSetChanged();
                dapei01Recycleview.setLoading(false);
            }

            @Override
            public void onFailure(Call<FitEntity> call, Throwable t) {

            }
        });

    }


    //下拉刷新并联网获取数据
    public void getRefreshData(){
        MyApplication.utils.getNewData("").enqueue(new Callback<FitEntity>() {
            @Override
            public void onResponse(Call<FitEntity> call, Response<FitEntity> response) {
                List<FitEntity.DataEntity.ItemsEntity> li = response.body().getData().getItems();
                //不能 data = li;

                data.clear();
                data.addAll(li);

                adapter.notifyDataSetChanged();
                dapei01Recycleview.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<FitEntity> call, Throwable t) {

            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onListLoad() {
        getPicNews();
//        dapei01Recycleview.setLoading(false);
    }

    @Override
    public void onRefresh() {
        Toast.makeText(getActivity(), "下拉刷新完毕", Toast.LENGTH_SHORT).show();
        dapei01Recycleview.setRefreshing(false);
    }
}
