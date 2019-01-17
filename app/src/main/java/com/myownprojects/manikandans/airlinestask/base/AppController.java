package com.myownprojects.manikandans.airlinestask.base;

import android.app.Application;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by manikandans on 12/01/19.
 */

public class AppController extends Application{

    private static AppController mInstance;
    private Retrofit retrofit = null;
//    private SharedPrefs sharedPrefs;

    @Override
    public void onCreate() {
        super.onCreate();
//        sharedPrefs = new SharedPrefs(this);

        mInstance = this;

    }



    public static synchronized AppController getInstance(){
//        Log.e(TAG, "getInstance: "+mInstance, new Exception() );
        if(mInstance == null)
            mInstance = new AppController();
        return mInstance;
    }


    public Retrofit getClient(String url){

        if(retrofit == null)
            creteRetrofit(url);
        else {
            if(!retrofit.baseUrl().equals(url)){
                creteRetrofit(url);
            }
        }
        return retrofit;
    }

    public void creteRetrofit(String url){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(getHeader())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public OkHttpClient getHeader(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(9);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().dispatcher(dispatcher)
                .addInterceptor(interceptor)
                .connectTimeout(90, TimeUnit.SECONDS)
//                .writeTimeout(90, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.MINUTES)
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
//                        Log.d("--APPCONTROLLER", SharedPrefs.getKey(getApplicationContext(), getResources().getString(R.string.accessToken)));
                        Request request = null;
                        Request original = chain.request();
                        // Request customization: add request headers
                        Request.Builder requestBuilder = original.newBuilder()
                                .addHeader("Authorization", "Access Token");
                        request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                }).retryOnConnectionFailure(true)
                .build();

        return okHttpClient;
    }


}
