package com.example.android.studenthack_wanamore.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

/**
 * Created by kambing on 20/02/2017.
 */

public class ModelOrtu implements Parcelable {
    private String nama;
    private String email;
    private String pass;
    private String nohp;
    private String alamat;
    private String idsiswa;


    public ModelOrtu(String nama, String email, String pass, String nohp, String alamat, String[] emailsiswa) {
        this.nama = nama;
        this.email = email;
        this.pass = pass;
        this.nohp = nohp;
        this.alamat = alamat;
        this.idsiswa = Arrays.toString(emailsiswa).replaceAll("\\[|\\]|\\s", "");
    }

    protected ModelOrtu(Parcel in) {
        nama = in.readString();
        email = in.readString();
        pass = in.readString();
        nohp = in.readString();
        alamat = in.readString();
        idsiswa = in.readString();
    }

    public static final Creator<ModelOrtu> CREATOR = new Creator<ModelOrtu>() {
        @Override
        public ModelOrtu createFromParcel(Parcel in) {
            return new ModelOrtu(in);
        }

        @Override
        public ModelOrtu[] newArray(int size) {
            return new ModelOrtu[size];
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getIdsiswa() {
        return idsiswa;
    }

    public void setIdsiswa(String idsiswa) {
        this.idsiswa = idsiswa;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(email);
        parcel.writeString(pass);
        parcel.writeString(nohp);
        parcel.writeString(alamat);
        parcel.writeString(idsiswa);
    }
}
