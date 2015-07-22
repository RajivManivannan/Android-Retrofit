/**
 * @category Contus
 * @package com.reeuse.retrofit.model
 * @version 1.0
 * @author Contus Team <developers@contus.in>
 * @copyright Copyright (C) 2015 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
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
