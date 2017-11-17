package com.example.admin.utilsapp.http;

import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 2017/11/14.
 */

public class BaseEntity<E> {

    @SerializedName("error")
    private int error;
    @SerializedName("results")
    private E results;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public E getResults() {
        return results;
    }

    public void setResults(E results) {
        this.results = results;
    }
}