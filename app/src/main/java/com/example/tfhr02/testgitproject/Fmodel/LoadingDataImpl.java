package com.example.tfhr02.testgitproject.Fmodel;

import android.support.annotation.Nullable;

import com.example.tfhr02.testgitproject.Bean.attention;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.lzy.okhttputils.model.HttpParams;
import com.lzy.okhttputils.request.BaseRequest;

import java.util.List;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by TFHR02 on 2017/3/13.
 */
public class LoadingDataImpl extends BaseImpl implements IloadData {
    private static final String URL_STR = "/api/api_open.php";
    @Override
    public void GetData(String type, final OnIloadDataListener listener) {
        HttpParams requestParam = new HttpParams();
        requestParam.put("a","tag_recommend");
        requestParam.put("action","sub");
        requestParam.put("c","topic");
        requestParam.put("type",type);

        OkHttpUtils.post(getCommonUrl().concat(URL_STR)).params(requestParam).execute(new StringCallback() {
            @Override
            public void onBefore(BaseRequest request) {
                listener.LoadingBefore();
            }

            @Override
            public void onResponse(boolean b, String s, Request request, @Nullable Response response) {
                List<attention> lists=new Gson().fromJson(s,new TypeToken<List<attention>>(){}.getType());
                listener.onSuccess(lists);
            }

            @Override
            public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {
                listener.onFailed(e);
            }

            @Override
            public void onAfter(boolean isFromCache, @Nullable String s, Call call, @Nullable Response response, @Nullable Exception e) {
                listener.LoadingAfter();
            }
        });

    }
}
