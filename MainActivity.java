package com.example.miapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ClassificationFragment.OnTitleListener {
    private SparseArray<Fragment> fragments;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initFragments();

        RadioGroup rgConvert = findViewById(R.id.btn_group);
        rgConvert.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                replaceFragment(fragments.get(i));
            }
        });
//        tvTitle = findViewById(R.id.tv_title);
    }
    private void initFragments() {
        fragments = new SparseArray<>();
        fragments.put(R.id.btn_course, LikeFragment.newInstance(1));
        fragments.put(R.id.btn_execise, ClassificationFragment.newInstance("分类"));
        fragments.put(R.id.btn_message, EnjoyFragment.newInstance("品味"));
        fragments.put(R.id.btn_car, ShoppingCartFragment.newInstance("购物车"));
        fragments.put(R.id.btn_my, MyFragment.newInstance("我的"));

        replaceFragment(fragments.get(R.id.btn_course));
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.ll_content,fragment);
        transaction.commit();
    }

    @Override
    public void setTitle(String title) {
//        tvTitle.setText(title);
    }
}