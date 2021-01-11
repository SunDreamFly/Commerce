package com.example.commerce.view.fragment;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;


import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.commerce.R;
import com.example.commerce.adapter.home.BannerAdapter;
import com.example.commerce.adapter.home.BeddingAdapter;
import com.example.commerce.adapter.home.BrandAdapter;
import com.example.commerce.adapter.home.LivingAdapter;
import com.example.commerce.adapter.home.ProductAdapter;
import com.example.commerce.adapter.home.SpecialAdapter;
import com.example.commerce.adapter.home.TextFourAdapter;
import com.example.commerce.adapter.home.TextThreeAdapter;
import com.example.commerce.adapter.home.TextoneAdapter;
import com.example.commerce.adapter.home.TexttwoAdapter;
import com.example.commerce.adapter.home.VarietyAdapter;
import com.example.commerce.base.BaseFragment;
import com.example.commerce.bean.HomeBean;
import com.example.commerce.contract.MyContract;
import com.example.commerce.presenter.MainPresenter;
import com.example.commerce.view.fragment.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseFragment<MainPresenter> implements MyContract.InView {


    private RecyclerView rcy;
    private DelegateAdapter adapter;
    private ArrayList<HomeBean.DataDTO.BannerDTO> banner;
    private BannerAdapter bannerAdapter;
    private ArrayList<HomeBean.DataDTO.ChannelDTO> variety;
    private VarietyAdapter varietyAdapter;
    private TextoneAdapter textoneAdapter;
    private ArrayList<HomeBean.DataDTO.BrandListDTO> brand;
    private BrandAdapter brandAdapter;
    private TexttwoAdapter textTwoAdapter;
    private ArrayList<HomeBean.DataDTO.NewGoodsListDTO> product;
    private ProductAdapter productAdapter;
    private TextThreeAdapter textThreeAdapter;
    private ArrayList<HomeBean.DataDTO.CategoryListDTO> living;
    private LivingAdapter livingAdapter;
    private ArrayList<HomeBean.DataDTO.HotGoodsListDTO> bedding;
    private BeddingAdapter beddingAdapter;
    private TextFourAdapter textFourAdapter;
    private ArrayList<HomeBean.DataDTO.TopicListDTO> special;
    private SpecialAdapter SpecialAdapter;


    @Override
    protected void initView(View view) {
        rcy = view.findViewById(R.id.rcy_home);
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());
        // 创建VirtualLayoutManager对象
        // 同时内部会创建一个LayoutHelperFinder对象，用来后续的LayoutHelper查找
        rcy.setLayoutManager(virtualLayoutManager);
        // 将VirtualLayoutManager绑定到recyclerView
        //设置回收复用池大小
        // 设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rcy.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        rcy.setLayoutManager(virtualLayoutManager);
        getBannerHelper();//banner的方法
        getVarietyHelper(); //种类 居家 餐厨  配件  服装 志趣
        getTextone();//品牌制造商直供文字
        getBrandHelper();//品牌
        getTexttwo();//周一周四·新品首发文字
        getProduct();//产品
        getTextThree();//人气推荐文字
        getPopularity();//流行
        getTextFour();//人气推荐文字
        getLoSpecial();//专题
        getLiving();//生活

        //添加适配器
        adapter = new DelegateAdapter(virtualLayoutManager, false);
        adapter.addAdapter(bannerAdapter);
        adapter.addAdapter(varietyAdapter);
        adapter.addAdapter(textoneAdapter);
        adapter.addAdapter(brandAdapter);
        adapter.addAdapter(textTwoAdapter);
        adapter.addAdapter(productAdapter);
        adapter.addAdapter(textThreeAdapter);
        adapter.addAdapter(beddingAdapter);
        adapter.addAdapter(textFourAdapter);
        adapter.addAdapter(SpecialAdapter);
        adapter.addAdapter(livingAdapter);
        rcy.setAdapter(adapter);
    }

    //生活
    private void getLiving() {
        //设置Grid布局
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
//        singleLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        // 同上面Weigths属性讲解
        living = new ArrayList<>();
        livingAdapter = new LivingAdapter(living, getContext(), singleLayoutHelper);
    }

    private void getLoSpecial() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
//        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
//        singleLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        // 同上面Weigths属性讲解
        special = new ArrayList<>();
        SpecialAdapter = new SpecialAdapter(getContext(),singleLayoutHelper,special);

    }


    private void getTextFour(){
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        // 同上面Weigths属性讲解
        textFourAdapter = new TextFourAdapter(getContext(), singleLayoutHelper);
    }

    private void getPopularity() {
        //设置Grid布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(3);// 设置布局里Item个数
//        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
//        gridLayoutHelper.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{100});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(1);// 设置每行多少个网格
        bedding = new ArrayList<>();
        beddingAdapter = new BeddingAdapter(bedding, getContext(), gridLayoutHelper);
    }

    private void getTextThree() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        // 同上面Weigths属性讲解
        textThreeAdapter = new TextThreeAdapter(getContext(), singleLayoutHelper);
    }

    private void getProduct() {
        //设置Grid布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(2);// 设置布局里Item个数
//        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
//        gridLayoutHelper.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比

        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
        product = new ArrayList<>();
        productAdapter = new ProductAdapter(product, gridLayoutHelper, getContext());
    }

    private void getTexttwo() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        // 同上面Weigths属性讲解
        textTwoAdapter = new TexttwoAdapter(getContext(), singleLayoutHelper);
    }

    private void getBrandHelper() {
        //设置Grid布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(2);// 设置布局里Item个数
        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比

        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(0);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(0);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
        brand = new ArrayList<>();
        brandAdapter = new BrandAdapter(brand, gridLayoutHelper, getContext());
    }

    private void getTextone() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        // 同上面Weigths属性讲解
        textoneAdapter = new TextoneAdapter(getContext(), singleLayoutHelper);
    }

    private void getVarietyHelper() {
        //设置Grid布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(5);// 设置布局里Item个数
        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(5);// 设置每行多少个网格
        variety = new ArrayList<>();
        varietyAdapter = new VarietyAdapter(variety, gridLayoutHelper, getContext());
        varietyAdapter.setOnClick(new VarietyAdapter.OnClickListener() {
            @Override
            public void onItemClick(int position) {
                HomeBean.DataDTO.ChannelDTO channelBean = variety.get(position);
                Integer id = channelBean.getId();
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

    }

    private SingleLayoutHelper getBannerHelper() {
        /**
         设置通栏布局
         banner
         */
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(1);// 设置设置布局内每行布局的宽与高的比
        banner = new ArrayList<>();
        bannerAdapter = new BannerAdapter(banner, singleLayoutHelper);
        return singleLayoutHelper;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    public void getData(HomeBean bean) {
        //banner
        List<HomeBean.DataDTO.BannerDTO> bannerlist = bean.getData().getBanner();
        banner.addAll(bannerlist);
        bannerAdapter.notifyDataSetChanged();
        //variety种类
        List<HomeBean.DataDTO.ChannelDTO> varietylist = bean.getData().getChannel();
        variety.addAll(varietylist);
        varietyAdapter.notifyDataSetChanged();
        //品牌
        List<HomeBean.DataDTO.BrandListDTO> brandList = bean.getData().getBrandList();
        brand.addAll(brandList);
        brandAdapter.notifyDataSetChanged();
        //产品
        List<HomeBean.DataDTO.NewGoodsListDTO> newGoodsList = bean.getData().getNewGoodsList();
        product.addAll(newGoodsList);
        productAdapter.notifyDataSetChanged();
        //人气推荐
        List<HomeBean.DataDTO.HotGoodsListDTO> hotGoodsList = bean.getData().getHotGoodsList();
        bedding.addAll(hotGoodsList);
        beddingAdapter.notifyDataSetChanged();
        //专题精选
        List<HomeBean.DataDTO.TopicListDTO> topicList = bean.getData().getTopicList();
        special.addAll(topicList);
        SpecialAdapter.notifyDataSetChanged();
        //居家
        List<HomeBean.DataDTO.CategoryListDTO> categoryList = bean.getData().getCategoryList();
        living.addAll(categoryList);
        livingAdapter.notifyDataSetChanged();


    }
}