package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.luckey.staryichu.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/12.
 */
public class DapeiNewScrollFrag extends Fragment {
    @Bind(R.id.dafrag_newscroll)
    ViewPager dafragNewscroll;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragdanewestscroll, container, false);
        ButterKnife.bind(this, view);
        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0){
                    return new DaiPei01Frag();
                }
                return new DaiPei02Frag();
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
        dafragNewscroll.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
