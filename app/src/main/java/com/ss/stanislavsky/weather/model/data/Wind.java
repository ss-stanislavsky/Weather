package com.ss.stanislavsky.weather.model.data;

import androidx.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    @Expose
    private int speed;
    @SerializedName("deg")
    @Expose
    private int deg;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    @NonNull
    @Override
    public String toString() {
        return "Wind{" + "speed=" + speed + ", deg=" + deg + '}';
    }
}
