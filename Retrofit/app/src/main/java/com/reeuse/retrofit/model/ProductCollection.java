<<<<<<< HEAD

=======
>>>>>>> origin/master
package com.reeuse.retrofit.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductCollection.java
 * <p/>
 * Description:
 */

public class ProductCollection implements Parcelable {

    @SerializedName(value = "products")
    private List<ProductItem> productItemList = new ArrayList<>();

    @SerializedName(value = "count")
    private int count;
    @SerializedName(value = "total_count")
    private int totalCount;

    /**
     * Gets product list.
     *
     * @return the product list
     */
    public List<ProductItem> getProductItemList() {
        return productItemList;
    }

    /**
     * Gets total count.
     *
     * @return the total count
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * Retrieving product item data from Parcel object
     * This constructor is invoked by the method createFromParcel(Parcel source) of
     * the object CREATOR
     */
    public ProductCollection(Parcel in) {
        this.productItemList = in.createTypedArrayList(ProductItem.CREATOR);
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
        dest.writeTypedList(this.productItemList);
    }
}
