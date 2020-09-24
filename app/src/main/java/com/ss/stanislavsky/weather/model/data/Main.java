package com.ss.stanislavsky.weather.model.data;

import androidx.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    @Expose
    private double temp;
    @SerializedName("feels_like")
    @Expose
    private double feelsLike;
    @SerializedName("temp_min")
    @Expose
    private double tempMin;
    @SerializedName("temp_max")
    @Expose
    private double tempMax;
    @SerializedName("pressure")
    @Expose
    private int pressure;
    @SerializedName("humidity")
    @Expose
    private int humidity;

    public double getTemp() {
        return temp;
    }

    public String getTempInCelsius() {
        return String.valueOf(Math.round(temp - 273.15) + "\u00b0");
    }

    public String getFeelsLikeTempInCelsius() {
        return String.valueOf(Math.round(feelsLike - 273.15) + "\u00b0");
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @NonNull
    @Override
    public String toString() {
        return "Main{" + "temp=" + temp + ", feelsLike=" + feelsLike +
                ", tempMin=" + tempMin + ", tempMax=" + tempMax +
                ", pressure=" + pressure + ", humidity=" + humidity + '}';
    }
}
