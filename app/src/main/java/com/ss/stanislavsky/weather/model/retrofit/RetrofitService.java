package com.ss.stanislavsky.weather.model.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    public static String API_KEY = "a57825a03761e68d8f1647e9324449c1";

    // Kharkov coordinates
    public static final double BASE_LATITUDE = 49.988358;
    public static final double BASE_LONGITUDE = 36.232845;

    private static RetrofitService retrofitService;
    private static Retrofit retrofit;

    private RetrofitService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitService getInstance() {
        if (retrofitService == null) {
            retrofitService = new RetrofitService();
        }
        return retrofitService;
    }

    public OpenWeatherMapApi getApiInterface() {
        return retrofit.create(OpenWeatherMapApi.class);
    }
}
