package com.example.miapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miapplication.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class LikeFragment extends Fragment {

    private Handler handler = new Handler();
    private ImageView imageView;
    private ImageView imageView1;
    private int[] images = {
            R.mipmap.top01, R.mipmap.top02,
            R.mipmap.top03, R.mipmap.top04, R.mipmap.top05
    };

    private int index;
    private MyRunnable myRunnable = new MyRunnable();

    private String[] TextStrings= {"每日上新","小米众筹","有品秒杀","热销排行","小米自营","家用电器","有品直播","独家首发","生活超市","天天福利"};
    private int[] icons = {R.mipmap.icon01,R.mipmap.icon02,R.mipmap.icon03,R.mipmap.icon04,R.mipmap.icon05,R.mipmap.icon06,R.mipmap.icon07,
    R.mipmap.icon08,R.mipmap.icon09,R.mipmap.icon10};
    private List<HomeTopItem> HomeTopItem;
    private GridView homeViewList;

    private String[] TextString = {"可折U型枕羽绒服","智能追踪式无线充","700蓬含绒量90%","支架式Hub扩展坞","智能温控棉服","10倍除醛净化器",
            "九阳方煲电压力锅","无线充电床头灯","华硕RTX电竞显卡","ZMI无线充电器"};
    private String[] TextStrings1 = {"￥139起","￥499","￥699","￥239","￥459","￥3599起","￥329","￥159","10999起","￥59"};
    private int[] icons1 = {R.mipmap.icon11,R.mipmap.icon12,R.mipmap.icon13,R.mipmap.icon14,R.mipmap.icon40,R.mipmap.icon41,R.mipmap.icon17,
            R.mipmap.icon18,R.mipmap.icon19,R.mipmap.icon20};
    private List<HomeBottomItem> HomeBottomItem;
    private GridView homeViewList1;



    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public LikeFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static LikeFragment newInstance(int columnCount) {
        LikeFragment fragment = new LikeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_list, container, false);

        imageView1 = view.findViewById(R.id.iv_goto_cd);

        goCd();


        imageView = view.findViewById(R.id.HomeHostFragment_imageView);
        handler.post(myRunnable);

        HomeTopItem = new ArrayList<>();
        for (int i = 0; i < TextStrings.length; i++) {
            HomeTopItem.add(new HomeTopItem(icons[i],TextStrings[i]));
        }
        homeViewList = view.findViewById(R.id.center_content);

        BaseAdapter adapter = new HomeTopAdapter(getContext(),HomeTopItem);
        homeViewList.setAdapter(adapter);

        HomeBottomItem = new ArrayList<>();
        for (int i =0 ; i < TextStrings1.length; i++) {
            HomeBottomItem.add(new HomeBottomItem(icons1[i],TextString[i],TextStrings1[i]));
        }
        homeViewList1 = view.findViewById(R.id.center_bottom);

        BaseAdapter adapter1 = new HomeBottomAdapter(getContext(),HomeBottomItem);
        homeViewList1.setAdapter(adapter1);


        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(DummyContent.ITEMS));
        }
        return view;
    }

    private void goCd() {
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CommodityActivity.class);
                startActivity(intent);
            }
        });
    }


    class MyRunnable implements Runnable {
        @Override
        public void run() {
            index++;
            index = index % 5;
            imageView.setImageResource(images[index]);
            handler.postDelayed(myRunnable, 3000);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(myRunnable);
    }

}