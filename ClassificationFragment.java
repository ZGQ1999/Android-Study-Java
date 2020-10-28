package com.example.miapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClassificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClassificationFragment extends Fragment {

    private String[] TextStrings= {"有品推荐","家用电器","居家餐厨","电视影音","家居家装","智能家庭","手机电脑","数码周边","日用文创","服装配饰",
            "美妆个护","运动户外","鞋靴箱包","健康保健","美食酒饮","母婴亲子","出行车品","宠物生活","有品海购","DLAB","品牌墙"};
    private int[] icons = {R.mipmap.c01,R.mipmap.c02,R.mipmap.c03,R.mipmap.c04,R.mipmap.c05,R.mipmap.c06,R.mipmap.c07,
            R.mipmap.c08,R.mipmap.c09,R.mipmap.c10,R.mipmap.c11,R.mipmap.c12,R.mipmap.c13,R.mipmap.c14,R.mipmap.c15,R.mipmap.c16,R.mipmap.c17,
            R.mipmap.c18,R.mipmap.c19,R.mipmap.c20,R.mipmap.c21};
    private List<HomeTopItem> HomeTopItem;
    private GridView homeViewList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    public ClassificationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment ExerciseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClassificationFragment newInstance(String param1) {
        ClassificationFragment fragment = new ClassificationFragment();
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
        }
        onTitleListener = (OnTitleListener) getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exercise, container, false);

        HomeTopItem = new ArrayList<>();
        for (int i = 0 ; i < TextStrings.length; i++) {
            HomeTopItem.add(new HomeTopItem(icons[i],TextStrings[i]));
        }
        homeViewList = view.findViewById(R.id.center_bottom);

        BaseAdapter adapter = new HomeTopAdapter1(getContext(),HomeTopItem);
        homeViewList.setAdapter(adapter);

        //初始化各个控件
        //TextView tvData = view.findViewById(R.id.tv_data);
        //tvData.setText(mParam1);

//        onTitleListener.setTitle(mParam1);
        return view;
    }

    OnTitleListener onTitleListener;

    public interface OnTitleListener{
        void setTitle(String title);
    }
}