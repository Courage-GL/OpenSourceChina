package com.example.abner.opensourcechina.model.http;

import com.example.abner.opensourcechina.app.App;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Abner on 2017/4/11.
 */

public class OkHttpUtils {
    private OkHttpClient client;
    private static OkHttpUtils okHttpUtils;
    private OkHttpUtils(){
        client = new OkHttpClient();

    }

    public static OkHttpUtils getInstance(){

        if(okHttpUtils==null){
            return okHttpUtils=new OkHttpUtils();

        }else {

            return okHttpUtils;
        }
    }

    public void get(String url, Map<String,String> map, final MyCallBack callBack){
        if(map!=null && map.size()>0){
            StringBuffer sb=new StringBuffer();
            sb.append("?");
            for(String key:map.keySet()){
                String value = map.get(key);
                sb.append(key).append("=").append(value).append("&");
            }
            url=url+sb.toString().substring(0,sb.length()-1);
        }
        Request request=new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {

                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e.getMessage());
                    }
                });


            }

            @Override
            public void onResponse(Call call, final Response response)  {
                String s=null;
                try {
                    s = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                final String finalS = s;
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(finalS);
                    }
                });


            }
        });

    }

    public void post(String url, Map<String,String> map, final MyCallBack callBack) {

        FormBody.Builder builder=new FormBody.Builder();
        if (map != null && map.size() > 0) {
            for (String key : map.keySet()) {
                String value = map.get(key);
                builder.add(key,value);
            }
        }

        Request request = new Request.Builder().url(url).post(builder.build()).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {

                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e.getMessage());
                    }
                });


            }

            @Override
            public void onResponse(Call call, final Response response) {

                String datas=null;
                try {
                    datas= response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                final String finalDatas = datas;
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(finalDatas);
                    }
                });


            }
        });


    }

}