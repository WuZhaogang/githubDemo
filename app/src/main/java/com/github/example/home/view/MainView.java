package com.github.example.home.view;


import com.github.example.core.model.BaseListModel;
import com.github.example.home.entity.UserListBean;

/**
 * 类描述:    描述该类的功能
 * 创建人:    wzg
 * 创建时间:  16/9/28
 * 创建人:    wzg
 * 修改时间:  16/9/28 14:50
 * 修改备注:  说明本次修改内容
 */
public interface MainView {
    void getDataSuccess(BaseListModel<UserListBean> model);

    void getDataFail(String msg);

    void showLoading();

    void hideLoading();
}
