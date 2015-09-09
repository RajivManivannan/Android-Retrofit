
package com.reeuse.retrofit.model;

import com.google.gson.annotations.SerializedName;

/**
 * UserDetails.java
 *
 */
public class UserDetails {

    @SerializedName(value = "id")
    private int userId;
    @SerializedName(value = "name")
    private String userName;


    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }
}
