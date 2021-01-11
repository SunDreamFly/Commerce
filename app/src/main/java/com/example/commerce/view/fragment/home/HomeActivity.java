package com.example.commerce.view.fragment.home;

import android.os.Bundle;
import android.util.Log;

import androidx.viewpager.widget.ViewPager;

import com.example.commerce.R;
import com.example.commerce.adapter.home.details.HomeDetailVpTabAdapter;
import com.example.commerce.base.BaseActivity;
import com.example.commerce.bean.homebean.HomeparentBean;
import com.example.commerce.contract.MyContract;
import com.example.commerce.presenter.home.HomePresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity<HomePresenter> implements MyContract.HomeIView {

    private TabLayout detailsTab;
    private ViewPager detailsVp;
    private ArrayList<HomeparentBean.DataBean.FilterCategoryBean> homepreentbean;
    private ArrayList<HomeDetailsFragment> frag;
    private HomeDetailVpTabAdapter detailVpTabAdapter;

    @Override
    protected void initData() {
        presenter.onHomeStart();
    }

    @Override
    protected void initView() {
        detailsTab = (TabLayout) findViewById(R.id.details_tab);
        detailsVp = (ViewPager) findViewById(R.id.details_vp);


    }

    @Override
    protected int getLayouID() {
        return R.layout.activity_home;
    }

    @Override
    public HomePresenter getPresenter() {
        return new HomePresenter();
    }

    @Override
    public void onHomeShow(Object object) {
//        if(object instanceof HomeparentBean){
            homepreentbean = new ArrayList<>();
            HomeparentBean detailsBean= (HomeparentBean) object;
            List<HomeparentBean.DataBean.FilterCategoryBean> filterCategory = detailsBean.getData().getFilterCategory();
            homepreentbean.addAll(filterCategory);
            frag = new ArrayList<>();
            for (int i = 0; i <homepreentbean.size() ; i++) {
                int id = homepreentbean.get(i).getId();
                Log.e("TAG", "onDeShow: "+id);
                HomeDetailsFragment detailsFragment = new HomeDetailsFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("id",id);
                detailsFragment.setArguments(bundle);
                frag.add(detailsFragment);
            }
            detailVpTabAdapter = new HomeDetailVpTabAdapter(getSupportFragmentManager(), homepreentbean, frag);
            detailsVp.setAdapter(detailVpTabAdapter);
            detailsTab.setupWithViewPager(detailsVp);
            int id = getIntent().getIntExtra("id", 0);
            detailsVp.setCurrentItem(id);
//        }
    }

    @Override
    public void onHomeHide(String str) {

    }
}