package com.github.example.core.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * 类描述:    列表
 * 创建人:    wzg
 * 创建时间:  16/9/20
 * 创建人:    wzg
 * 修改时间:  16/9/20 17:00
 * 修改备注:  说明本次修改内容
 */
public class BaseListModel<T> {
    @SerializedName("items")
    private ArrayList<T> items;
    @SerializedName("total_count")
    private int total_count;
    @SerializedName("incomplete_results")
    private boolean incomplete_results;

    public ArrayList<T> getItems() {
        return items;
    }

    public void setItems(ArrayList<T> items) {
        this.items = items;
    }

    public boolean isIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }
}