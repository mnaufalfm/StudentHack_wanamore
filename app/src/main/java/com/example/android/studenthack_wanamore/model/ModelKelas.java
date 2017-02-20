package com.example.android.studenthack_wanamore.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kirra on 18/02/17.
 */

public class ModelKelas implements Parcelable {
    private String idwalas;
    private String idsekolah;
    private String nama;
    private int jumlahsiswa;


    public ModelKelas(String idwalas, String idsekolah, String nama, int jumlahsiswa) {
        this.idwalas = idwalas;
        this.idsekolah = idsekolah;
        this.nama = nama;
        this.jumlahsiswa = jumlahsiswa;
    }

    protected ModelKelas(Parcel in) {
        idwalas = in.readString();
        idsekolah = in.readString();
        nama = in.readString();
        jumlahsiswa = in.readInt();
    }

    public static final Creator<ModelKelas> CREATOR = new Creator<ModelKelas>() {
        @Override
        public ModelKelas createFromParcel(Parcel in) {
            return new ModelKelas(in);
        }

        @Override
        public ModelKelas[] newArray(int size) {
            return new ModelKelas[size];
        }
    };

    public String getIdwalas() {
        return idwalas;
    }

    public void setIdwalas(String idwalas) {
        this.idwalas = idwalas;
    }

    public String getIdsekolah() {
        return idsekolah;
    }

    public void setIdsekolah(String idsekolah) {
        this.idsekolah = idsekolah;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlahsiswa() {
        return jumlahsiswa;
    }

    public void setJumlahsiswa(int jumlahsiswa) {
        this.jumlahsiswa = jumlahsiswa;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(idwalas);
        parcel.writeString(idsekolah);
        parcel.writeString(nama);
        parcel.writeInt(jumlahsiswa);
    }
}
