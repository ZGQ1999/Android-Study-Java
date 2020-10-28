package com.example.miapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EnjoyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EnjoyFragment extends Fragment {

    private int[] icons1 = {R.mipmap.left_top2_e,R.mipmap.eight_top_e,R.mipmap.left_top1_e,R.mipmap.eight_top1_e,R.mipmap.left_center_e,R.mipmap.eight_center_e,R.mipmap.left_center1_e,R.mipmap.eight_center1_e,R.mipmap.left_bottom_e,R.mipmap.eight_bottom_e};
    private String[] TextStrings1 = {"青萍-吉他温度计","带上未来-华米概念手表","续航防水嘿喽智能手表","简约超长待机深度防水","多功能移动电源","米家超级电池","乐歌E5","韶音传导耳机","索尼无线降噪耳机","雷克沙NM610固态硬盘"};
    private int[] icons = {R.mipmap.left1_top_e,R.mipmap.eight1_top_e,R.mipmap.left1_top1_e,R.mipmap.eight1_top1_e,R.mipmap.left1_center_e,R.mipmap.eight1_center_e,R.mipmap.left1_center1_e, R.mipmap.eight1_center1_e,R.mipmap.left1_bottom_e,R.mipmap.eight1_bottom_e};
    private List<EnjoyItem> EnjoyItem;
    private GridView homeViewList1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EnjoyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment EnjoyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EnjoyFragment newInstance(String param1) {
        EnjoyFragment fragment = new EnjoyFragment();
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
        View view = inflater.inflate(R.layout.fragment_enjoy, container, false);

        EnjoyItem = new ArrayList<>();
        for (int i = 0; i < TextStrings1.length; i++) {
            EnjoyItem.add(new EnjoyItem(icons1[i],TextStrings1[i],icons[i]));
        }
        homeViewList1 = view.findViewById(R.id.center_bottom);

        BaseAdapter adapter = new EnjoyItemAdapter(getContext(),EnjoyItem);
        homeViewList1.setAdapter(adapter);


        //初始化各个控件
        //TextView tvData = view.findViewById(R.id.tv_data);
        //tvData.setText(mParam1);

//        onTitleListener.setTitle(mParam1);
        return view;
    }

    ClassificationFragment.OnTitleListener onTitleListener;

    public interface OnTitleListener{
        void setTitle(String title);
    }
}