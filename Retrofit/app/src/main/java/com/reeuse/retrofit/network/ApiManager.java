
package com.reeuse.retrofit.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.reeuse.retrofit.AppConstants;
import com.reeuse.retrofit.helper.CustomConverter;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * ApiManager.java
 */
public class ApiManager {
    /* Webservice URL */
    private static String API_URL = "http://52.74.116.126/rest/";

    /**
     * ApiService with using GSON Converter
     *
     * @return ApiService
     */
    public ApiService getApiManagerGson() {
        Gson gson = new GsonBuilder().create();
        ApiService apiService = new RestAdapter.Builder()
                .setEndpoint(API_URL) // API Endpoint url
                .setClient(new OkClient(new OkHttpClient())) // Http client -OkHttpClient
                .setConverter(new GsonConverter(gson)) // Gson response converter
                .setLogLevel(RestAdapter.LogLevel.FULL)// To enable log.
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestInterceptor.RequestFacade request) {
                        //Custom Request header
                        request.addHeader(AppConstants.Headers.CONTENT_TYPE_KEY, AppConstants.Headers.CONTENT_TYPE_VALUE);
                        request.addHeader(AppConstants.Headers.ACCEPT_KEY, AppConstants.Headers.ACCEPT_VALUE);
                        request.addHeader(AppConstants.Headers.KEEP_ALIVE_KEY, AppConstants.Headers.KEEP_ALIVE_VALUE);
                    }
                })
                .build()
                .create(ApiService.class);
        return apiService;
    }

    /**
     * ApiService with using Custom Converter
     *
     * @return ApiService
     */
    public ApiService getApiManagerCustom() {
        ApiService apiService = new RestAdapter.Builder()
                .setEndpoint(API_URL) // API Endpoint url
                .setClient(new OkClient(new OkHttpClient())) // Http client -OkHttpClient
                .setConverter(new CustomConverter()) // Custom response converter
                .setLogLevel(RestAdapter.LogLevel.FULL)// To enable log.
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestInterceptor.RequestFacade request) {
                        //Custom Request header
                        request.addHeader(AppConstants.Headers.CONTENT_TYPE_KEY, AppConstants.Headers.CONTENT_TYPE_VALUE);
                        request.addHeader(AppConstants.Headers.ACCEPT_KEY, AppConstants.Headers.ACCEPT_VALUE);
                        request.addHeader(AppConstants.Headers.KEEP_ALIVE_KEY, AppConstants.Headers.KEEP_ALIVE_VALUE);
                    }
                })
                .build()
                .create(ApiService.class);
        return apiService;
    }

}
