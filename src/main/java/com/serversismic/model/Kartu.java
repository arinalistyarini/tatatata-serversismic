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
public class Kartu {
    private String idKartu;
    private Timestamp kadaluarsa;
    private int saldo;

    public String getIdKartu() {
        return idKartu;
    }

    public void setIdKartu(String idKartu) {
        this.idKartu = idKartu;
    }

    public Timestamp getKadaluarsa() {
        return kadaluarsa;
    }

    public void setKadaluarsa(Timestamp kadaluarsa) {
        this.kadaluarsa = kadaluarsa;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
