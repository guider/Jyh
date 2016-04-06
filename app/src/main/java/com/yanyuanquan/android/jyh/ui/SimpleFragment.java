package com.yanyuanquan.android.jyh.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yanyuanquan.android.jyh.ui.trank.TrankFragment;

/**
 * Created by apple on 16/3/22.
 */
public class SimpleFragment extends Fragment {
    public static final String TITLE = "com.yyq.android.title";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle!=null) {
            String title = bundle.getString(TITLE, "");
            TextView textView = new TextView(getActivity());
            textView.setText(title);
            textView.setGravity(Gravity.CENTER);
            return textView;
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public static SimpleFragment newInstance(String title){
        Bundle bundle = new Bundle();
        bundle.putString(TITLE,title);
        SimpleFragment fragment = new SimpleFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
