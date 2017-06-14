/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.serversismic.model;

import java.sql.Timestamp;

/**
 *
 * @author Arina Listyarini DA
 */
public class Transaksi {
    private String idKartu;
    private Timestamp waktu;
    private int nominal;
    private String jenisTransaksi;
    private String status;
    private String via;

    public String getIdKartu() {
        return idKartu;
    }

    public void setIdKartu(String idKartu) {
        this.idKartu = idKartu;
    }

    public Timestamp getWaktu() {
        return waktu;
    }

    public void setWaktu(Timestamp waktu) {
        this.waktu = waktu;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }
    
    
}
