package com.qf.luckey.staryichu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import fragment.HomeVpFitFragment;
import fragment.HomeVpFragment;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.home_vp)
    ViewPager homeVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 1){
                    //搭配页面
                    return new HomeVpFitFragment();
                }
                return new HomeVpFragment();
            }

            @Override
            public int getCount() {
                return 3;
            }
        };
        homeVp.setAdapter(adapter);



    }
}
