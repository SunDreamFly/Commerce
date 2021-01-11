package com.example.commerce.adapter.home.details;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


import com.example.commerce.bean.homebean.HomeparentBean;
import com.example.commerce.view.fragment.home.HomeDetailsFragment;

import java.util.ArrayList;

public class HomeDetailVpTabAdapter extends FragmentStatePagerAdapter {
    private ArrayList<HomeparentBean.DataBean.FilterCategoryBean> filterCategoryBeans;
    private ArrayList<HomeDetailsFragment> frag;

    public HomeDetailVpTabAdapter(@NonNull FragmentManager fm, ArrayList<HomeparentBean.DataBean.FilterCategoryBean> filterCategoryBeans, ArrayList<HomeDetailsFragment> frag) {
        super(fm);
        this.filterCategoryBeans = filterCategoryBeans;
        this.frag = frag;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return frag.get(position);
    }

    @Override
    public int getCount() {
        return frag.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
            return filterCategoryBeans.get(position).getName();
    }
}
