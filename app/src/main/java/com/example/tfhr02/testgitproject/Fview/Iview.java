package com.example.tfhr02.testgitproject.Fview;

import com.example.tfhr02.testgitproject.Bean.attention;

import java.util.List;

/**
 * Created by TFHR02 on 2017/3/13.
 *
 * 与view层相关的回调
 *
 */
public interface Iview {
    void showLoading();

    void hideLoading();

    void RefreshData(List<attention> list);

    void showErrorInfo(String e);
}
