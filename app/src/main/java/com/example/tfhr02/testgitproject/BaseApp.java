package com.example.tfhr02.testgitproject;

import android.app.Application;

import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.model.HttpHeaders;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by TFHR02 on 2017/3/13.
 */
public class BaseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // 在使用 SDK 各组间之前初始化 context 信息，传入 ApplicationContext
        // 设置全局的网络通信参数
        HttpHeaders headers = new HttpHeaders();
        headers.setUserAgent("YDTYPT (Android)");
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate");
        // 必须调用初始化
        OkHttpUtils.init(this);
        OkHttpUtils.getInstance()//
                .debug("TestGitProject")
                .setConnectTimeout(10000) // 全局的连接超时时间
                .setReadTimeOut(10000) // 全局的读取超时时间
                .setWriteTimeOut(10000); // 全局的写入超时时间
//                .addCommonHeaders(headers);// 设置全局公共头
        //imageloader配置
        ImageLoaderConfiguration config=new ImageLoaderConfiguration.Builder(this)
                .writeDebugLogs()
                .build();

        ImageLoader.getInstance().init(config);
    }
}
