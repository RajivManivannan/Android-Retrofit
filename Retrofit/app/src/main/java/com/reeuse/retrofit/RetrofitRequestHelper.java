
package com.reeuse.retrofit;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;


import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * RetrofitRequestHelper.java
 */
public class RetrofitRequestHelper {

    private static ApiRequestInterface mApiRequestInterface;
    /** Webservice URL **/
    private static String API_URL = "http://52.74.116.126/rest/";
    /** Google's JSON Parser GSON Instance**/
    private final Gson mGson;

    public RetrofitRequestHelper() {
        mGson = new GsonBuilder()
                .setFieldNamingPolicy(
                        FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        mApiRequestInterface = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setClient(new OkClient(new OkHttpClient()))
                .setConverter(new GsonConverter(mGson))
                .build()
                .create(ApiRequestInterface.class);
    }

    /**
     * Gets instance.
     *
     * @return the instance of the ApiRequestInterface.
     */
    public  ApiRequestInterface getInstance() {
        return mApiRequestInterface;
    }
}
