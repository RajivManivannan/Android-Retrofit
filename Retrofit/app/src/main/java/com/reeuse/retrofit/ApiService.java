
package com.reeuse.retrofit;


import com.reeuse.retrofit.model.DeleteCallback;
import com.reeuse.retrofit.model.ProductCollection;
import com.reeuse.retrofit.model.Upload;
import com.reeuse.retrofit.model.UserDetails;


import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;

/**
 * ApiService.java
 * <p/>
 * This interface contains all the API request list.
 */
public interface ApiService {


    @FormUrlEncoded
    @POST("/login")
    void getUserDetails(@FieldMap Map<String, String> loginRequestParam, Callback<UserDetails> callback);

    @GET("/getProduct/{id}")
    void getProductCollection(@Path("id") int id, Callback<ProductCollection> callback);

    @FormUrlEncoded
    @PUT("/updateRecord/{id}")
    void updateRecord(@Path("id") int id, @FieldMap Map<String, String> updateRequestParam, Callback<ProductCollection> callback);

    @GET("/getProduct")
    void getProductCollection(Callback<ProductCollection> callback);

    @GET("/getProduct")
    void getCollection(Callback<String> callback);

    @DELETE("/deleteUser")
    void deleteUser(@Query("userId") String userId, Callback<DeleteCallback> callback);

    @Multipart
    @POST("/upload")
    void uploadImage(@Part("image")TypedFile path,@Part("image_name")TypedString name,Callback<Upload> callback);

}
