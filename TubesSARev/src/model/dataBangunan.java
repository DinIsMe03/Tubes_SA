/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author David
 */
public class dataBangunan {
    String namaBarang;
    String kategoriBarang;
    int hargaBarang;
    int kualitasBarang;
    
    public String getBarang(){
        return namaBarang;
    }
    
    public String getKategori(){
        return kategoriBarang;
    }
    
    public int getHarga(){
        return hargaBarang;
    }
    
    public int getKualitas(){
        return kualitasBarang;
    }
    
    public dataBangunan setDataBarang(String nama, String kategori, int harga, int kualitas){
        dataBangunan data = new dataBangunan();
        
        data.namaBarang = nama;
        data.kategoriBarang = kategori;
        data.hargaBarang = harga;
        data.kualitasBarang = kualitas;
        
        return data;
    }
}
