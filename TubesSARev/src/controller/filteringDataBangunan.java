/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;

/**
 *
 * @author David
 */
public class filteringDataBangunan {
    
    public void setDefaultDataBangunan(){
        tokoBangunan toko = new tokoBangunan();
        dataBangunan data = new dataBangunan();
        
        toko.addDataBangunan(data.setDataBarang("Bata Murah", "Bangunan", 1000, 1));
        toko.addDataBangunan(data.setDataBarang("Bata Sedang", "Bangunan", 2000, 2));
        toko.addDataBangunan(data.setDataBarang("Bata Bagus", "Bangunan", 3000, 3));
        
        toko.addDataBangunan(data.setDataBarang("Lantai Murah", "Lantai", 1000, 1));
        toko.addDataBangunan(data.setDataBarang("Lantai Sedang", "Lantai", 2000, 2));
        toko.addDataBangunan(data.setDataBarang("Lantai Bagus", "Lantai", 3000, 3));
        
        toko.addDataBangunan(data.setDataBarang("Semen Murah", "Perekat", 1000, 1));
        toko.addDataBangunan(data.setDataBarang("Semen Sedang", "Perekat", 2000, 2));
        toko.addDataBangunan(data.setDataBarang("Semen Bagus", "Perekat", 3000, 3));
        
        toko.addDataBangunan(data.setDataBarang("Pasir Murah", "Adonan", 1000, 1));
        toko.addDataBangunan(data.setDataBarang("Pasir Sedang", "Adonan", 2000, 2));
        toko.addDataBangunan(data.setDataBarang("Pasir Bagus", "Adonan", 3000, 3));
        
        toko.addDataBangunan(data.setDataBarang("Genteng Murah", "Atap", 1000, 1));
        toko.addDataBangunan(data.setDataBarang("Genteng Sedang", "Atap", 2000, 2));
        toko.addDataBangunan(data.setDataBarang("Genten Bagus", "Atap", 3000, 3));
    }
    
    
    public void setDataJenis(){
        tokoBangunan toko = new tokoBangunan();
        
        for(int i = 0; i < toko.getTokoBangunan().size(); i++){
            switch (toko.getDataBangunan(i).getKategori()) {
                case "Bangunan":
                    toko.addJenisBangunan(toko.getDataBangunan(i));
                    break;
                case "Lantai":
                    toko.addJenisLantai(toko.getDataBangunan(i));
                    break;
                case "Atap":
                    toko.addJenisAtap(toko.getDataBangunan(i));
                    break;
                case "Adonan":
                    toko.addJenisAdonan(toko.getDataBangunan(i));
                    break;
                case "Perekat":
                    toko.addJenisPerekat(toko.getDataBangunan(i));
                    break;
                default:
                    break;
            }
        }
    }
}
