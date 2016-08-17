package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.luckey.staryichu.MyApplication;
import com.qf.luckey.staryichu.R;
import com.qf.luckey.adapter.DaPei2Adapter;
import com.qf.luckey.entity.Project2Entity;

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
public class DaiPei02Frag extends Fragment {

    @Bind(R.id.dapei02_recycleview)
    RecyclerView dapei02Recycleview;

    List<Project2Entity.DataBean.ItemsBean> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_daipei_da02, container, false);
        ButterKnife.bind(this, view);
        
        getProjectData();

        LinearLayoutManager manager2 = new LinearLayoutManager(getActivity());
        manager2.setOrientation(LinearLayoutManager.VERTICAL);
        dapei02Recycleview.setLayoutManager(manager2);

        DaPei2Adapter adapter = new DaPei2Adapter(getActivity(),list);

        dapei02Recycleview.setAdapter(adapter);

        return view;
    }

    private void getProjectData() {
        Call<Project2Entity> call = MyApplication.utils.getProjectData();
        call.enqueue(new Callback<Project2Entity>() {
            @Override
            public void onResponse(Call<Project2Entity> call, Response<Project2Entity> response) {
                List<Project2Entity.DataBean.ItemsBean> datas = response.body().getData().getItems();
                list.addAll(datas);
                dapei02Recycleview.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Project2Entity> call, Throwable t) {

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
