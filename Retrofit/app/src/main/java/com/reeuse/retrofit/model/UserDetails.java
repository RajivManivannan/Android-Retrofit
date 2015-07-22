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
