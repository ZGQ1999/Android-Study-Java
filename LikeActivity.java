package com.example.miapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class LikeActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private ImageView imageView;

    private String[] TextStrings= {"每日上新","小米众筹","有品秒杀","热销排行","小米自营","家用电器","有品直播","独家首发","生活超市","天天福利"};
    private int[] icons = {R.mipmap.icon01,R.mipmap.icon02,R.mipmap.icon03,R.mipmap.icon04,R.mipmap.icon05,R.mipmap.icon06,R.mipmap.icon07,
            R.mipmap.icon08,R.mipmap.icon09,R.mipmap.icon10};
    private List<HomeTopItem> HomeTopItem;
    private GridView homeViewList;

    private String[] TextString = {"可折U型枕羽绒服","智能追踪式无线充","700蓬含绒量90%","支架式Hub扩展坞","工程抓放套装","激光电视伸缩云台",
            "九阳方煲电压力锅","无线充电床头灯","华硕RTX电竞显卡","ZMI无线充电器"};
    private String[] TextStrings1 = {"￥139起","￥499","￥699","￥239","￥409","￥1899起","￥329","￥159","10999起","￥59"};
    private int[] icons1 = {R.mipmap.icon11,R.mipmap.icon12,R.mipmap.icon13,R.mipmap.icon14,R.mipmap.icon15,R.mipmap.icon16,R.mipmap.icon17,
            R.mipmap.icon18,R.mipmap.icon19,R.mipmap.icon20};
    private List<HomeBottomItem> HomeBottomItem;
    private GridView homeViewList1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);

        HomeTopItem = new ArrayList<>();
        for (int i = 0; i < TextStrings.length; i++) {
            HomeTopItem.add(new HomeTopItem(icons[i],TextStrings[i]));
        }
        homeViewList = findViewById(R.id.center_content);

        BaseAdapter adapter = new HomeTopAdapter(this,HomeTopItem);
        homeViewList.setAdapter(adapter);

        HomeBottomItem = new ArrayList<>();
        for (int i =0 ; i < TextStrings1.length; i++) {
            HomeBottomItem.add(new HomeBottomItem(icons1[i],TextString[i],TextStrings1[i]));
        }
        homeViewList1 = findViewById(R.id.center_bottom);

        BaseAdapter adapter1 = new HomeBottomAdapter(this,HomeBottomItem);
        homeViewList1.setAdapter(adapter1);
    }
}