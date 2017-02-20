package com.example.android.studenthack_wanamore.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kambing on 20/02/2017.
 */

public class ModelSekolah implements Parcelable {
    private String nama;
    private String email;
    private String notelp;
    private String alamat;
    private String situs;
    private String pass;

    public ModelSekolah(String nama, String email, String notelp, String alamat, String situs, String pass) {
        this.nama = nama;
        this.email = email;
        this.notelp = notelp;
        this.alamat = alamat;
        this.situs = situs;
        this.pass = pass;
    }

    protected ModelSekolah(Parcel in) {
        nama = in.readString();
        email = in.readString();
        notelp = in.readString();
        alamat = in.readString();
        situs = in.readString();
        pass = in.readString();
    }

    public static final Creator<ModelSekolah> CREATOR = new Creator<ModelSekolah>() {
        @Override
        public ModelSekolah createFromParcel(Parcel in) {
            return new ModelSekolah(in);
        }

        @Override
        public ModelSekolah[] newArray(int size) {
            return new ModelSekolah[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getSitus() {
        return situs;
    }

    public void setSitus(String situs) {
        this.situs = situs;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(email);
        parcel.writeString(notelp);
        parcel.writeString(alamat);
        parcel.writeString(situs);
        parcel.writeString(pass);
    }
}
