package com.example.admin.utilsapp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioGroup;

import com.example.admin.utilsapp.R;
import com.example.admin.utilsapp.R2;
import com.example.admin.utilsapp.ui.fragment.DiscoverFragment;
import com.example.admin.utilsapp.ui.fragment.HomeFragment;
import com.example.admin.utilsapp.ui.fragment.MessageFragment;
import com.example.admin.utilsapp.ui.fragment.MineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends FragmentActivity {

    @BindView(R2.id.rg_main)
    RadioGroup rgMain;

    private int mIndex = 0;
    private Fragment[] mFragments;
    FragmentManager fragmentManager = getSupportFragmentManager();
    Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife和当前Activity绑定
        bind = ButterKnife.bind(this);
        //初始化Fragment
        initFragments();
        //默认显示Home页
        rgMain.check(R.id.rb_home);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.frameLayout,mFragments[0]).show(mFragments[0]);
        ft.commit();
    }

    /**
     * 添加的时候按照顺序
     */
    private void initFragments() {
        mFragments = new Fragment[]{
                new HomeFragment(),
                new MessageFragment(),
                new DiscoverFragment(),
                new MineFragment()
        };
    }

    private void setIndexSelected(int index) {
        if(mIndex==index){
            return;
        }
        FragmentTransaction ft = fragmentManager.beginTransaction();
        //隐藏
        ft.hide(mFragments[mIndex]);
        //判断是否添加
        if(!mFragments[index].isAdded()){
            ft.add(R.id.frameLayout,mFragments[index]).show(mFragments[index]);
        }else {
            ft.show(mFragments[index]);
        }
        ft.commit();
        //再次赋值
        mIndex=index;

    }

    @OnClick({R.id.rb_home, R.id.rb_message, R.id.rb_discover, R.id.rb_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_home:
                setIndexSelected(0);
                break;
            case R.id.rb_message:
                setIndexSelected(1);
                break;
            case R.id.rb_discover:
                setIndexSelected(2);
                break;
            case R.id.rb_mine:
                setIndexSelected(3);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
