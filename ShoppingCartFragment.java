package com.example.miapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShoppingCartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShoppingCartFragment extends Fragment {

    private Handler handler = new Handler();
    private ImageView imageView;
    private Button button;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private String[] TextString = {"可折U型枕羽绒服","智能追踪式无线充","700蓬含绒量90%","支架式Hub扩展坞","工程抓放套装","激光电视伸缩云台",
            "九阳方煲电压力锅","无线充电床头灯","华硕RTX电竞显卡","ZMI无线充电器"};
    private String[] TextStrings1 = {"￥139起","￥499","￥699","￥239","￥409","￥1899起","￥329","￥159","10999起","￥59"};
    private int[] icons1 = {R.mipmap.icon11,R.mipmap.icon12,R.mipmap.icon13,R.mipmap.icon14,R.mipmap.icon15,R.mipmap.icon16,R.mipmap.icon17,
            R.mipmap.icon18,R.mipmap.icon19,R.mipmap.icon20};
    private List<HomeBottomItem> HomeBottomItem;
    private GridView homeViewList1;

    public ShoppingCartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment ShoppingCartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShoppingCartFragment newInstance(String param1) {
        ShoppingCartFragment fragment = new ShoppingCartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);

        button = view.findViewById(R.id.btn_goto_main);

        goMain();


        HomeBottomItem = new ArrayList<>();
        for (int i =0 ; i < TextStrings1.length; i++) {
            HomeBottomItem.add(new HomeBottomItem(icons1[i],TextString[i],TextStrings1[i]));
        }
        homeViewList1 = view.findViewById(R.id.center_bottom);

        BaseAdapter adapter1 = new HomeBottomAdapter(getContext(),HomeBottomItem);
        homeViewList1.setAdapter(adapter1);

        //View view1 = inflater.inflate(R.layout.fragment_shopping_cart, container, false);

        //初始化各个控件
        //TextView tvData = view.findViewById(R.id.tv_data);
        //tvData.setText(mParam1);

//        onTitleListener.setTitle(mParam1);
        return view;
    }

    private void goMain() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LikeActivity.class);
                startActivity(intent);
            }
        });
    }

    ClassificationFragment.OnTitleListener onTitleListener;

    public interface OnTitleListener{
        void setTitle(String title);
    }
}