package com.samansepahvand.test1;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Model implements Serializable {

    private String name;
    private String family;


    public Model(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }


}
