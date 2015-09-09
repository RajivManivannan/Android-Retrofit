
package com.reeuse.retrofit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Upload.java
 *
 */
public class Upload {

    @SerializedName(value = "image_url")
    private String imageURL;
    @SerializedName(value = "response")
    private String response;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }



}
