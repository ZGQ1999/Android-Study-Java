package com.example.miapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {

    private String[] TextString = {"可折U型枕羽绒服","智能追踪式无线充","700蓬含绒量90%","支架式Hub扩展坞"};
    private String[] TextStrings1 = {"￥139起","￥499","￥699","￥239"};
    private int[] icons1 = {R.mipmap.icon11,R.mipmap.icon12,R.mipmap.icon13,R.mipmap.icon14};
    private List<HomeBottomItem> HomeBottomItem;
    private GridView homeViewList1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        HomeBottomItem = new ArrayList<>();
        for (int i = 0; i< TextStrings1.length; i++) {
            HomeBottomItem.add(new HomeBottomItem(icons1[i],TextString[i],TextStrings1[i]));
        }
        homeViewList1 = findViewById(R.id.center_bottom) ;

        BaseAdapter adapter = new HomeBottomAdapter(this,HomeBottomItem);
        homeViewList1.setAdapter(adapter);
    }
}