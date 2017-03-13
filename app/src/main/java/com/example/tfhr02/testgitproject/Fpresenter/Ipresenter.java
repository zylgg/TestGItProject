package com.example.tfhr02.testgitproject.Fpresenter;

import android.content.Context;

import com.example.tfhr02.testgitproject.Bean.attention;
import com.example.tfhr02.testgitproject.Fmodel.LoadingDataImpl;
import com.example.tfhr02.testgitproject.Fmodel.OnIloadDataListener;
import com.example.tfhr02.testgitproject.Fview.Iview;

import java.util.List;

/**
 * Created by TFHR02 on 2017/3/13.
 */
public class Ipresenter {

    private Iview iview;
    private Context context;
    private LoadingDataImpl lodingimpl;

    public Ipresenter(Iview iview) {
        this.iview = iview;
        this.context = (Context) iview;
        this.lodingimpl = new LoadingDataImpl();
    }

    public void loadData(String type) {
        lodingimpl.GetData(type, new OnIloadDataListener() {
            @Override
            public void LoadingBefore() {
               iview.showLoading();
            }

            @Override
            public void onSuccess(List<attention> lists) {
                iview.RefreshData(lists);
            }

            @Override
            public void onFailed(Exception e) {
                iview.showErrorInfo(e.getMessage());
            }

            @Override
            public void LoadingAfter() {
                iview.hideLoading();
            }
        });
    }
}
