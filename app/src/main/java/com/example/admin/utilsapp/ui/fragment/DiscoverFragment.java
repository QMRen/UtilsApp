package com.example.admin.utilsapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.admin.utilsapp.R;
import com.example.admin.utilsapp.base.BaseFragment;
import com.example.admin.utilsapp.bean.Girls;
import com.example.admin.utilsapp.http.BaseEntity;
import com.example.admin.utilsapp.http.Callback;
import com.example.admin.utilsapp.service.GirlService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;

/**
 * Created by admin on 2017/10/30.
 */

public class DiscoverFragment extends BaseFragment {

    @BindView(R.id.recycler_discover)
    RecyclerView mRecyclerView;
    LinearLayoutManager mLinearLayoutManager;
    List<Girls> mResults1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, null);
        ButterKnife.bind(this, view);
        GirlService girlService = new GirlService(DiscoverFragment.this.getContext());
        girlService.getVideoUrl(new Callback<Response<BaseEntity<List<Girls>>>>() {
            @Override
            public void requestError(String msg) {
                Toast.makeText(DiscoverFragment.this.getContext(), "----------" + msg, Toast.LENGTH_LONG).show();
            }

            @Override
            public void requestSuccess(Response<BaseEntity<List<Girls>>> data) {
                mResults1 = data.body().getResults();
            }

        });
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(new MyAdapter(mResults1));
        return view;
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        List<Girls> data;

        public MyAdapter(List<Girls> list) {
            data = list;
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_recycler, null);
            ViewHolder mHolder = new ViewHolder(view);
            return mHolder;
        }

        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
            Glide.with(DiscoverFragment.this.getContext()).load(data.get(position).getUrl()).into(holder.mImageView);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.recycler_img)
            ImageView mImageView;

            public ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }

    }
}
