package com.example.android.studenthack_wanamore.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kirra on 18/02/17.
 */

public class ModelSiswa implements Parcelable {
    private String nama;
    private String noinduk;
    private String jenis_kelamin;
    private String password;
    private String email_ortu;
    private String email;
    private String notelp;
    private String kelas;

    public ModelSiswa() {}

    public ModelSiswa(String nama, String noinduk, String jenis_kelamin, String password, String email_ortu, String email, String notelp) {
        this.nama = nama;
        this.noinduk = noinduk;
        this.kelas = "";
        this.jenis_kelamin = jenis_kelamin;
        this.password = password;
        this.email_ortu = email_ortu;
        this.email = email;
        this.notelp = notelp;
    }

    public ModelSiswa(String nama, String noinduk, String jenis_kelamin, String kelas, String password, String email_ortu, String email, String notelp) {
        this.nama = nama;
        this.noinduk = noinduk;
        this.kelas = kelas;
        this.jenis_kelamin = jenis_kelamin;
        this.password = password;
        this.email_ortu = email_ortu;
        this.email = email;
        this.notelp = notelp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.noinduk);
        dest.writeString(this.kelas);
        dest.writeString(this.jenis_kelamin);
        dest.writeString(this.password);
        dest.writeString(this.email_ortu);
        dest.writeString(this.email);
        dest.writeString(this.notelp);
    }

    protected ModelSiswa(Parcel in) {
        this.nama = in.readString();
        this.noinduk = in.readString();
        this.kelas = in.readString();
        this.jenis_kelamin = in.readString();
        this.password = in.readString();
        this.email_ortu = in.readString();
        this.email = in.readString();
        this.notelp = in.readString();
    }

    public static final Parcelable.Creator<ModelSiswa> CREATOR = new Parcelable.Creator<ModelSiswa>() {
        @Override
        public ModelSiswa createFromParcel(Parcel source) {
            return new ModelSiswa(source);
        }

        @Override
        public ModelSiswa[] newArray(int size) {
            return new ModelSiswa[size];
        }
    };

    public String getNoinduk() {
        return noinduk;
    }

    public void setNoinduk(String noinduk) {
        this.noinduk = noinduk;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getEmail_ortu() {
        return email_ortu;
    }

    public void setEmail_ortu(String email_ortu) {
        this.email_ortu = email_ortu;
    }

    public static Creator<ModelSiswa> getCREATOR() {
        return CREATOR;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
}
