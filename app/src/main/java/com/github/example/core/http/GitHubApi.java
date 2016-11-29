package com.github.example.core.http;


import com.github.example.core.model.BaseListModel;
import com.github.example.home.entity.UserListBean;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 类描述:    描述该类的功能
 * 创建人:    wzg
 * 创建时间:  16/9/20
 * 创建人:    wzg
 * 修改时间:  16/9/20 17:53
 * 修改备注:  说明本次修改内容
 */
public interface GitHubApi {
    String BASE_URL = "https://api.github.com/";

    @Headers("User-Agent: Awesome-Octocat-App")
    @GET("search/users")
    Observable<BaseListModel<UserListBean>> getUserList(
            @Query("q") String username);

}