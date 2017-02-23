package com.example.android.studenthack_wanamore.model;

/**
 * Created by Muhammad Mukhibillah on 23/02/2017.
 */

public class ModelBerandaGuru {
    private String nama;
    private String foto_profil;
    private String waktu;
    private String caption;
    private String hastag;
    private String foto_isi;

    public ModelBerandaGuru(String nama, String foto_profil, String waktu, String caption, String hastag, String foto_isi) {
        this.nama = nama;
        this.foto_profil = foto_profil;
        this.waktu = waktu;
        this.caption = caption;
        this.hastag = hastag;
        this.foto_isi = foto_isi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getFoto_profil() {
        return foto_profil;
    }

    public void setFoto_profil(String foto_profil) {
        this.foto_profil = foto_profil;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getHastag() {
        return hastag;
    }

    public void setHastag(String hastag) {
        this.hastag = hastag;
    }

    public String getFoto_isi() {
        return foto_isi;
    }

    public void setFoto_isi(String foto_isi) {
        this.foto_isi = foto_isi;
    }

}
