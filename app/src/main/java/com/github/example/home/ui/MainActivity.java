package com.github.example.home.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

import com.github.example.R;
import com.github.example.core.model.BaseListModel;
import com.github.example.core.mvp.MvpActivity;
import com.github.example.home.adapter.HomeAdapter;
import com.github.example.home.entity.UserListBean;
import com.github.example.home.presenter.MainPresenter;
import com.github.example.home.view.MainView;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends MvpActivity<MainPresenter> implements MainView {
    @BindView(R.id.et_search)
    EditText et_search;
    @BindView(R.id.rl_data)
    RecyclerView rl_data;
    private HomeAdapter mHomeAdapter;
    private ArrayList<UserListBean> mUserListBeanArrayList;
    private String preSearch = "";//上一次搜索

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mUserListBeanArrayList = new ArrayList<>();
        mHomeAdapter = new HomeAdapter(this, mUserListBeanArrayList);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rl_data.setLayoutManager(manager);
        rl_data.setAdapter(mHomeAdapter);
    }

    @Override
    protected void initToolbar(Bundle savedInstanceState) {

    }

    @Override
    protected void initListeners() {
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence sequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence sequence, int i, int i1, int i2) {
                onTextChange(sequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    protected void initData() {
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void getDataSuccess(BaseListModel<UserListBean> model) {
        mUserListBeanArrayList = model.getItems();
        mHomeAdapter.setList(mUserListBeanArrayList);
    }

    @Override
    public void getDataFail(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    private void onTextChange(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!preSearch.equals(str)) {
                mvpPresenter.loadData(str);
                preSearch = str;
            }
        }
    }
}
