package com.example.android.studenthack_wanamore.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kirra on 18/02/17.
 */

public class ModelGuru implements Parcelable {
    private String nama;
    private String nip;
    private String jk;
    private String[] matpel;
    private String nohp;
    private String alamat;
    private String email;

    public ModelGuru(String nama, String nip, String jk, String[] matpel, String nohp, String alamat, String email) {
        this.nama = nama;
        this.nip = nip;
        this.jk = jk;
        this.matpel = matpel;
        this.nohp = nohp;
        this.alamat = alamat;
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String[] getMatpel() {
        return matpel;
    }

    public void setMatpel(String[] matpel) {
        this.matpel = matpel;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.nip);
        dest.writeString(this.jk);
        dest.writeStringArray(this.matpel);
        dest.writeString(this.nohp);
        dest.writeString(this.alamat);
        dest.writeString(this.email);
    }

    protected ModelGuru(Parcel in) {
        this.nama = in.readString();
        this.nip = in.readString();
        this.jk = in.readString();
        this.matpel = in.createStringArray();
        this.nohp = in.readString();
        this.alamat = in.readString();
        this.email = in.readString();
    }

    public static final Creator<ModelGuru> CREATOR = new Creator<ModelGuru>() {
        @Override
        public ModelGuru createFromParcel(Parcel source) {
            return new ModelGuru(source);
        }

        @Override
        public ModelGuru[] newArray(int size) {
            return new ModelGuru[size];
        }
    };
}
