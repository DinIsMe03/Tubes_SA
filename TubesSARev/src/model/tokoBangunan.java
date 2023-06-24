/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import data.*;

import java.util.ArrayList;

/**
 *
 * @author David
 */
public class tokoBangunan {
    
    public ArrayList<dataBangunan> getTokoBangunan(){
        return dataTokoA.tokoBangunanA;
    }
    
    public ArrayList<dataBangunan> getJenisLantai(){
        return dataTokoA.jenisLantai;
    }
    
    public ArrayList<dataBangunan> getJenisAdonan(){
        return dataTokoA.jenisAdonan;
    }
    
    public ArrayList<dataBangunan> getJenisPerekat(){
        return dataTokoA.jenisPerekat;
    }
    
    public ArrayList<dataBangunan> getJenisBangunan(){
        return dataTokoA.jenisBangunan;
    }
    
    public String[] getSolusiData(){
        return dataTokoA.solusi;
    }
    
    public int getSolusiHarga(){
        return dataTokoA.solusiTotalBeli;
    }
    
    public int getBudget(){
        return dataTokoA.budget;
    }
    
    public dataBangunan getIdxJenisAtap(int i){
        return dataTokoA.jenisAtap.get(i);
    }
    
    public dataBangunan getIdxJenisLantai(int i){
        return dataTokoA.jenisLantai.get(i);
    }
    
    public dataBangunan getIdxJenisAdonan(int i){
        return dataTokoA.jenisAdonan.get(i);
    }
    
    public dataBangunan getIdxJenisPerekat(int i){
        return dataTokoA.jenisPerekat.get(i);
    }
    
    public dataBangunan getIdxJenisBangunan(int i){
        return dataTokoA.jenisBangunan.get(i);
    }
    
    public ArrayList<dataBangunan> getJenisAtap(){
        return dataTokoA.jenisAtap;
    }
    
    public dataBangunan getDataBangunan(int i){
        return dataTokoA.tokoBangunanA.get(i);
    }
    
    public void addDataBangunan(dataBangunan data){
        dataTokoA.tokoBangunanA.add(data);
    }
    
    public void addJenisLantai(dataBangunan data){
        dataTokoA.jenisLantai.add(data);
    }
    
    public void addJenisAdonan(dataBangunan data){
        dataTokoA.jenisAdonan.add(data);
    }
    
    public void addJenisBangunan(dataBangunan data){
        dataTokoA.jenisBangunan.add(data);
    }
    
    public void addJenisAtap(dataBangunan data){
        dataTokoA.jenisAtap.add(data);
    }
    
    public void addJenisPerekat(dataBangunan data){
        dataTokoA.jenisPerekat.add(data);
    }
    
    public void setSolusi(String[] data, int harga){
        dataTokoA.solusi = data;
        dataTokoA.solusiTotalBeli = harga;
    }
    
    public void setBudget(int harga){
        dataTokoA.budget = harga;
    }
}
