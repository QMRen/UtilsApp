package com.example.admin.utilsapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.utilsapp.R;
import com.example.admin.utilsapp.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/10/30.
 */

public class DiscoverFragment extends BaseFragment {

    @BindView(R.id.recycler_discover)
    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover,null);
        ButterKnife.bind(this,view);
        return view;
    }
}
