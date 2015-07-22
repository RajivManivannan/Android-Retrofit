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
