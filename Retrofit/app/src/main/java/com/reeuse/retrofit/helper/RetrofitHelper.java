
package com.reeuse.retrofit.helper;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.reeuse.retrofit.ApiService;
import com.squareup.okhttp.OkHttpClient;


import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * RetrofitHelper.java
 */
public class RetrofitHelper {

    private static ApiService mApiService;
    /**
     * Webservice URL
     **/
    private static String API_URL = "http://52.74.116.126/rest/";


    public RetrofitHelper() {
        /** Google's JSON Parser GSON Instance */
        Gson mGson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        mApiService = new RestAdapter.Builder()
                .setEndpoint(API_URL) // API Endpoint url
                .setClient(new OkClient(new OkHttpClient())) // Http client -OkHttpClient
                .setConverter(new GsonConverter(mGson)) // Gson response converter
                //.setConverter(new CustomConverter()) // custom response converter
                .setLogLevel(RestAdapter.LogLevel.FULL)// To enable log.
                .build()
                .create(ApiService.class);
    }

    /**
     * Gets instance.
     *
     * @return the instance of the ApiService.
     */
    public ApiService getInstance() {
        return mApiService;
    }
}
