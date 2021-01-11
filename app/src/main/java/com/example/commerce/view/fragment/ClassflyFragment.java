package com.example.commerce.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.commerce.R;
import com.example.commerce.adapter.bytes.ByteTextAdapter;
import com.example.commerce.adapter.bytes.DataLinAdapter;
import com.example.commerce.base.BaseFragment;
import com.example.commerce.bean.ByteBean;
import com.example.commerce.bean.ClassifyBean;
import com.example.commerce.contract.MyContract;
import com.example.commerce.presenter.BytePresenter;
import com.example.commerce.presenter.ClassflyPresenter;

import java.util.ArrayList;
import java.util.List;

import q.rorbin.verticaltablayout.VerticalTabLayout;


public class ClassflyFragment extends BaseFragment<ClassflyPresenter> implements MyContract.ClassflyView {
    private VerticalTabLayout vtabClass;
    private ViewPager viewpager;
    private ArrayList<ClassifyBean.DataBean.CategoryListBean> mTitlt;
    private ArrayList<ClassflyChildFragment> fragments;

    @Override
    protected void initView(View view) {
        vtabClass = (VerticalTabLayout) view.findViewById(R.id.vtab_class);
        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_classify;
    }

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected ClassflyPresenter getPresenter() {
        return new ClassflyPresenter();
    }

    @Override
    public void getData(ClassifyBean classifyBean) {
        if (classifyBean instanceof ClassifyBean) {
            ClassifyBean classificationBean = (ClassifyBean) classifyBean;
            List<ClassifyBean.DataBean.CategoryListBean> categoryList = classificationBean.getData().getCategoryList();
            mTitlt = new ArrayList<>();
            mTitlt.addAll(categoryList);
            fragments = new ArrayList<>();
            Log.e("TAG", "onShow: " + mTitlt.size());
            for (int i = 0; i < mTitlt.size(); i++) {
                int id = mTitlt.get(i).getId();
                ClassflyChildFragment oneFragment = new ClassflyChildFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("id", id);
                oneFragment.setArguments(bundle);
                fragments.add(oneFragment);
            }
            VpAdapter vpAdapter = new VpAdapter(getChildFragmentManager());
            viewpager.setAdapter(vpAdapter);
            vpAdapter.notifyDataSetChanged();
            vtabClass.setupWithViewPager(viewpager);

        }

    }
    private class VpAdapter extends FragmentPagerAdapter {
        public VpAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitlt.get(position).getName();
        }
    }
}