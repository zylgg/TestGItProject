package com.example.tfhr02.testgitproject.Fmodel;

import com.example.tfhr02.testgitproject.Bean.attention;

import java.util.List;

/**
 * Created by TFHR02 on 2017/3/13.
 */
public interface OnIloadDataListener {
    void LoadingBefore();

    void onSuccess(List<attention> lists);

    void onFailed(Exception e);

    void LoadingAfter();
}
