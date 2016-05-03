package com.kdanmobile.animationpractice.screen.viewanimator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kdanmobile.animationpractice.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewAnimatorFragment extends Fragment {
    @Bind(R.id.button_test)
    Button testButton;
    private String TAG = getClass().getSimpleName();

    public ViewAnimatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_animator, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.button_test)
    public void onClick() {
        Log.d("ViewAnimatorFragment", String.format("rotation: %s, scaleY: %s, alpha: %s", testButton.getRotation(), testButton.getScaleY(), testButton.getAlpha()));
        testButton.animate()
                .alphaBy(-0.1f)
                .rotation(testButton.getRotation() + 90f)
                .setDuration(1 * 1000)
                .start();
    }
}
