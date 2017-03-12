package com.example.android.studenthack_wanamore.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Naufal Farras on 10/03/2017.
 */

public class ModelPost implements Parcelable{
    private String idpost;
    private String idpengirim;
    private String judul;
    private String post;
    private long tglpost;
    private int like;
    private int jumlahkomen;

    public ModelPost() {}

    public ModelPost(String idpengirim, String judul, String post) {
        this.idpost = "";
        this.idpengirim = idpengirim;
        this.judul = judul;
        this.post = post;
        this.tglpost = System.currentTimeMillis();
        this.like = 0;
        this.jumlahkomen = 0;
    }

    protected ModelPost(Parcel in) {
        idpost = in.readString();
        idpengirim = in.readString();
        judul = in.readString();
        post = in.readString();
        tglpost = Long.parseLong(in.readString());
        like = in.readInt();
        jumlahkomen = in.readInt();
    }

    public static final Creator<ModelPost> CREATOR = new Creator<ModelPost>() {
        @Override
        public ModelPost createFromParcel(Parcel in) {
            return new ModelPost(in);
        }

        @Override
        public ModelPost[] newArray(int size) {
            return new ModelPost[size];
        }
    };

    public ModelPost(String idpengirim) {
        this.idpengirim = idpengirim;
    }

    public String getIdpengirim() {
        return idpengirim;
    }

    public void setIdpengirim(String idpengirim) {
        this.idpengirim = idpengirim;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Long getDate() {
        return tglpost;
    }

    public void setDate(Long date) {
        this.tglpost = date;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getJumlahkomen() {
        return jumlahkomen;
    }

    public void setJumlahkomen(int jumlahkomen) {
        this.jumlahkomen = jumlahkomen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idpost);
        dest.writeString(idpengirim);
        dest.writeString(judul);
        dest.writeString(post);
        dest.writeString(String.valueOf(tglpost));
        dest.writeInt(like);
        dest.writeInt(jumlahkomen);
    }

    public static Creator<ModelPost> getCREATOR() {
        return CREATOR;
    }

    public String getIdpost() {
        return idpost;
    }

    public void setIdpost(String idpost) {
        this.idpost = idpost;
    }
}
