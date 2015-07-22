/**
 * @category Contus
 * @package com.waydone.assignment.model
 * @version 1.0
 * @author Contus Team <developers@contus.in>
 * @copyright Copyright (C) 2015 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0 
 */
package com.reeuse.retrofit.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * ProductItem.java
 * <p/>
 *  This class is to hold the product item values.
 */
public class ProductItem implements Parcelable {

    //Local variables.
    @SerializedName("id")
    private int productId;
    @SerializedName("name")
    private String productName;
    @SerializedName("product_image")
    private String productImageUrl;


    /**
     * Gets product image url.
     *
     * @return the product image url
     */
    public String getProductImageUrl() {
        return productImageUrl;
    }

    /**
     * Gets category name.
     *
     * @return the category name
     */
    public String getProductName() {
        return productName;
    }


    /**
     * Gets product id.
     *
     * @return the product id
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Retrieving product data from Parcel object
     * This constructor is invoked by the method createFromParcel(Parcel source) of
     * the object CREATOR
     */
    public ProductItem(Parcel in) {
        this.productName = in.readString();
        this.productId = in.readInt();
    }

    public static final Creator<ProductItem> CREATOR = new Creator<ProductItem>() {

        @Override
        public ProductItem createFromParcel(Parcel source) {
            return new ProductItem(source);
        }

        @Override
        public ProductItem[] newArray(int size) {
            return new ProductItem[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(productId);
        dest.writeString(productName);
    }

}