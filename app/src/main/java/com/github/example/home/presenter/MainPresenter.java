package com.github.example.home.presenter;


import com.github.example.core.http.ApiCallBack;
import com.github.example.core.model.BaseListModel;
import com.github.example.core.mvp.BasePresenter;
import com.github.example.home.entity.MainModel;
import com.github.example.home.entity.UserListBean;
import com.github.example.home.view.MainView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 类描述:    描述该类的功能
 * 创建人:    wzg
 * 创建时间:  16/9/28
 * 创建人:    wzg
 * 修改时间:  16/9/28 14:51
 * 修改备注:  说明本次修改内容
 */
public class MainPresenter extends BasePresenter<MainView> {
    public MainPresenter(MainView view) {
        attachView(view);
    }

    public void loadData(String userName) {
        mvpView.showLoading();
        addSubscription(apiStores.getUserList(userName),
                new ApiCallBack<BaseListModel<UserListBean>>() {
                    @Override
                    public void onSuccess(BaseListModel<UserListBean> model) {
                        mvpView.getDataSuccess(model);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        mvpView.getDataFail(msg);
                    }

                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }

                });
    }
}