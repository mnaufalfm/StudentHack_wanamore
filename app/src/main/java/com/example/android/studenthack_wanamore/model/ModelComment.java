package com.example.android.studenthack_wanamore.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;

/**
 * Created by Naufal Farras on 10/03/2017.
 */

public class ModelComment implements Parcelable {
    private String idkomen;
    private String idpengirim;
    private String idpost;
    private long tglkomen;
    private String komen;

    public ModelComment() {}

    public ModelComment(String idpengirim, String idpost, String komen) {
        this.idkomen = "";
        this.idpengirim = idpengirim;
        this.idpost = idpost;
        this.tglkomen = System.currentTimeMillis();
        this.komen = komen;
    }

    protected ModelComment(Parcel in) {
        idkomen = in.readString();
        idpengirim = in.readString();
        idpost = in.readString();
        tglkomen = Long.parseLong(in.readString());
        komen = in.readString();
    }

    public static final Creator<ModelComment> CREATOR = new Creator<ModelComment>() {
        @Override
        public ModelComment createFromParcel(Parcel in) {
            return new ModelComment(in);
        }

        @Override
        public ModelComment[] newArray(int size) {
            return new ModelComment[size];
        }
    };

    public String getIdpengirim() {
        return idpengirim;
    }

    public void setIdpengirim(String idpengirim) {
        this.idpengirim = idpengirim;
    }

    public String getIdpost() {
        return idpost;
    }

    public void setIdpost(String idpost) {
        this.idpost = idpost;
    }

    public long getTglkomen() {
        return tglkomen;
    }

    public void setTglkomen(long tglkomen) {
        this.tglkomen = tglkomen;
    }

    public String getKomen() {
        return komen;
    }

    public void setKomen(String komen) {
        this.komen = komen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idkomen);
        dest.writeString(idpengirim);
        dest.writeString(idpost);
        dest.writeString(String.valueOf(tglkomen));
        dest.writeString(komen);
    }

    public String getIdkomen() {
        return idkomen;
    }

    public void setIdkomen(String idkomen) {
        this.idkomen = idkomen;
    }
}
