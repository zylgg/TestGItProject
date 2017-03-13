package com.example.tfhr02.testgitproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tfhr02.testgitproject.Bean.attention;
import com.example.tfhr02.testgitproject.Fpresenter.Ipresenter;
import com.example.tfhr02.testgitproject.Fview.Iview;
import com.example.tfhr02.testgitproject.pro.page1.SubscribeAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Iview {

    private RecyclerView rv_subscribe_lists;
    private Ipresenter ipresenter=new Ipresenter(this);
    private List<attention> lists=new ArrayList<>();
    private  SubscribeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        
        String[] stringArray = this.getResources().getStringArray(R.array.attention_video_tab);
        String array1= Arrays.asList(stringArray).get(0);
        String type=array1.split("zylgg")[1];
        ipresenter.loadData(type);
    }

    /**
     * 初始化数据
     */
    private void initview() {
        rv_subscribe_lists= (RecyclerView) findViewById(R.id.rv_subscribe_lists);
        rv_subscribe_lists.setHasFixedSize(true);
        rv_subscribe_lists.setLayoutManager(new LinearLayoutManager(this));
        adapter=new SubscribeAdapter(this,lists);
        rv_subscribe_lists.setAdapter(adapter);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void RefreshData(List<attention> lists) {
//        lists.clear();
        lists.addAll(lists);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorInfo(String e) {

    }
}
