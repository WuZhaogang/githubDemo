package com.github.example.core.http;


import com.github.example.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 类描述:    描述该类的功能
 * 创建人:    wzg
 * 创建时间:  16/9/20
 * 创建人:    wzg
 * 修改时间:  16/9/20 18:02
 * 修改备注:  说明本次修改内容
 */
public class RetrofitClient {

    public static Retrofit mRetrofit;

    public static Retrofit retrofit() {
        if (mRetrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (BuildConfig.DEBUG) {
                // Log信息拦截器
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                //设置 Debug Log 模式
                builder.addInterceptor(loggingInterceptor);
            }
            Interceptor mTokenInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request originalRequest = chain.request();
//                if (Your.sToken == null || alreadyHasAuthorizationHeader(originalRequest)) {
//                    return chain.proceed(originalRequest);
//                }
//                Request authorised = originalRequest.newBuilder()
//                        .header("Authorization", Your.sToken)
//                        .build();
                    //Token拦截器 设置token
                    return chain.proceed(originalRequest);
//                return chain.proceed(authorised);
                }
            };
            builder.connectTimeout(15, TimeUnit.SECONDS);
            builder.addInterceptor(mTokenInterceptor);
            builder.retryOnConnectionFailure(true);
            OkHttpClient client = builder.build();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(GitHubApi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
                    .build();
        }
        return mRetrofit;
    }
}