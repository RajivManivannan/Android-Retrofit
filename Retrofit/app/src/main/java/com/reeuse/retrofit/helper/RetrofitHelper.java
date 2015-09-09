
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
    /**
     * Google's JSON Parser GSON Instance
     **/
    private final Gson mGson;

    public RetrofitHelper() {
        mGson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        mApiService = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setClient(new OkClient(new OkHttpClient()))
                .setConverter(new GsonConverter(mGson))
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
