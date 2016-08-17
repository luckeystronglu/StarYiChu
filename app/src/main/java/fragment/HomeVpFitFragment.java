package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.qf.luckey.staryichu.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/11.
 */
public class HomeVpFitFragment extends Fragment {

    @Bind(R.id.btn_dapei)
    Button btnDapei;
    @Bind(R.id.btn_zhuanti)
    Button btnZhuanti;
    @Bind(R.id.dapei_vp)
    ViewPager dapeiVp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_fitter, container, false);
        ButterKnife.bind(this, view);

        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0){
                    return new DapeiNewScrollFrag();
                }
                return new ReFlushFragment();
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
        dapeiVp.setAdapter(pagerAdapter);
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
