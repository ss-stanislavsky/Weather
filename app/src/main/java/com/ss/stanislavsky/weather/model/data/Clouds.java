package com.ss.stanislavsky.weather.model.data;

import androidx.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clouds {

    @SerializedName("all")
    @Expose
    private int all;

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    @NonNull
    @Override
    public String toString() {
        return "Clouds{" + "all=" + all + '}';
    }
}
