package com.github.example.core.mvp;

import android.os.Bundle;

import com.github.example.core.BaseActivity;


/**
 * 类描述:    描述该类的功能
 * 创建人:    wzg
 * 创建时间:  16/9/28
 * 创建人:    wzg
 * 修改时间:  16/9/28 16:02
 * 修改备注:  说明本次修改内容
 */
public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {
    protected P mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }
}