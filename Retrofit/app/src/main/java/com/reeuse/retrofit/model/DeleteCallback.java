
package com.reeuse.retrofit.model;

import com.google.gson.annotations.SerializedName;

/**
 * DeleteCallback.java
 * <p/>
 * Description:
 */
public class DeleteCallback {

    @SerializedName(value = "status")
    private String status;
    @SerializedName(value = "message")
    private String message;

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }



}
