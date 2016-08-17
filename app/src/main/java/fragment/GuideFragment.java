package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.qf.luckey.staryichu.MainActivity;
import com.qf.luckey.staryichu.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Luckey on 2016/8/14.
 */
public class GuideFragment extends Fragment implements View.OnClickListener {

    @Bind(R.id.ivbg_guidefrag)
    ImageView ivbgGuidefrag;
    @Bind(R.id.img_guidefrag)
    ImageView imgGuidefrag;
    @Bind(R.id.btn_guidefrag)
    Button btnGuidefrag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewf = inflater.inflate(R.layout.fragment_guide, container, false);
        ButterKnife.bind(this, viewf);

        int key = getArguments().getInt("luck");
        switch (key){
            case 0:
                ivbgGuidefrag.setImageResource(R.drawable.splash_background_01);
                imgGuidefrag.setImageResource(R.drawable.splash_foreground_01);
                break;
            case 1:
                ivbgGuidefrag.setImageResource(R.drawable.splash_background_02);
                imgGuidefrag.setImageResource(R.drawable.splash_foreground_02);
                break;
            case 2:
                ivbgGuidefrag.setImageResource(R.drawable.splash_background_03);
                imgGuidefrag.setImageResource(R.drawable.splash_foreground_03);
                break;
            case 3:
                ivbgGuidefrag.setImageResource(R.drawable.splash_background_04);
                imgGuidefrag.setImageResource(R.drawable.splash_foreground_04);
                btnGuidefrag.setVisibility(View.VISIBLE);
                btnGuidefrag.setOnClickListener(this);
                break;
        }
        return viewf;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(getActivity(), MainActivity.class));
        getActivity().finish();
    }
}
