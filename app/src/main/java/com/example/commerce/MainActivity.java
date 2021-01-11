package com.example.commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.commerce.view.fragment.ByteFragment;
import com.example.commerce.view.fragment.ClassflyFragment;
import com.example.commerce.view.fragment.HomeFragment;
import com.example.commerce.view.fragment.MineFragment;
import com.example.commerce.view.fragment.ShopPingsFragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fl;
    private RadioGroup rg;
    private RadioButton bt;
    private RadioButton bt2;
    private RadioButton bt3;
    private RadioButton bt4;
    private RadioButton bt5;
    private FragmentTransaction transaction;
    private HomeFragment homeFragment;
    private ByteFragment byteFragment;
    private ClassflyFragment classifyFragment;
    private MineFragment mineFragment;
    private ShopPingsFragment shopPingsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fl = findViewById(R.id.fl);
        rg = findViewById(R.id.rg);
        bt = findViewById(R.id.bt);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        transaction = getSupportFragmentManager().beginTransaction();
        //首页
        homeFragment = new HomeFragment();
        //专题
        byteFragment = new ByteFragment();
        //分类
        classifyFragment = new ClassflyFragment();
        //购物车
        shopPingsFragment = new ShopPingsFragment();
//        shopPingFragment = new ShopPingFragment();
        //我的
        mineFragment = new MineFragment();

        transaction.add(R.id.fl, homeFragment)
                .add(R.id.fl, byteFragment)
                .add(R.id.fl, classifyFragment)
                .add(R.id.fl, shopPingsFragment)
                .add(R.id.fl, mineFragment)
                .hide(byteFragment)
                .hide(classifyFragment)
                .hide(shopPingsFragment)
                .hide(mineFragment)
                .commit();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bt:
                        getSupportFragmentManager().beginTransaction()
                                .show(homeFragment)
                                .hide(byteFragment)
                                .hide(classifyFragment)
                                .hide(shopPingsFragment)
                                .hide(mineFragment)
                                .commit();
                        break;
                    case R.id.bt2:
                        getSupportFragmentManager().beginTransaction()
                                .hide(homeFragment)
                                .show(byteFragment)
                                .hide(classifyFragment)
                                .hide(shopPingsFragment)
                                .hide(mineFragment)
                                .commit();
                        break;
                    case R.id.bt3:
                        getSupportFragmentManager().beginTransaction()
                                .hide(homeFragment)
                                .hide(byteFragment)
                                .show(classifyFragment)
                                .hide(shopPingsFragment)
                                .hide(mineFragment)
                                .commit();
                        break;
                    case R.id.bt4:
                        getSupportFragmentManager().beginTransaction()
                                .hide(homeFragment)
                                .hide(byteFragment)
                                .hide(classifyFragment)
                                .show(shopPingsFragment)
                                .hide(mineFragment)
                                .commit();
                        break;
                    case R.id.bt5:
                        getSupportFragmentManager().beginTransaction()
                                .hide(homeFragment)
                                .hide(byteFragment)
                                .hide(classifyFragment)
                                .hide(shopPingsFragment)
                                .show(mineFragment)
                                .commit();
                        break;
                }
            }
        });
    }
}
