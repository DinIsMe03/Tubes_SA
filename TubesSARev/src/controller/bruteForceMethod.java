/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import model.dataBangunan;
import model.tokoBangunan;
import view.pageBruteforce;

/**
 *
 * @author David
 */
public class bruteForceMethod {
    int[] solusiK = new int[3];
    int solusiTotalHarga = 0;
    
    public int prioritas(int k[]){
        if(k[2] > k[1] && k[2] > k[0]){
            return 5;
        }else if(k[2] >= k[1] && k[2] > k[0]){
            return 4;
        }else if(k[1] > k[2] && k[1] > k[0]){
            return 3;
        }else if(k[1] > k[2] && k[1] >= k[0]){
            return 2;
        }else if(k[0] > k[2] && k[0] > k[1]){
            return 1;
        }else{
            return 0;
        }
    }
    
    public void tambahDataSolusi(String[] namaBarang, int[] k, int totalHarga){
        tokoBangunan toko = new tokoBangunan();
        
        toko.setSolusi(namaBarang, totalHarga);
        solusiK[2] = k[2];
        solusiK[1] = k[1];
        solusiK[0] = k[0];
    }
    
    public void solusiBF(String[] kualitas, String[] namaBarang, 
            int totalHarga, int budget, Boolean cekSolusi){
        int[] k = new int[3];
        
        for(int i = 0; i < kualitas.length; i++){
            if(kualitas[i].equals("3")){
                k[2] += 1;
            }else if(kualitas[i].equals("2")){
                k[1] += 1;
            }else{
                k[0] += 1;
            }
        }
        
        if(cekSolusi == true){
            if(budget >= totalHarga){
                tambahDataSolusi(namaBarang, k, totalHarga);
            }
        }else{
            if((prioritas(solusiK) < prioritas(k)) && budget >= totalHarga){
                tambahDataSolusi(namaBarang, k, totalHarga);
            }
        }
    }
    
    public void bruteForce(int banyakBangunan, int banyakAtap, int banyakLantai,
            int banyakAdonan, int banyakPerekat, int budget){
        DefaultTableModel tableModel = (DefaultTableModel) pageBruteforce.tblHasilBF.getModel();
        pageBruteforce.tblHasilBF.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        tokoBangunan toko = new tokoBangunan();
        
        for(int a = 0; a < toko.getJenisBangunan().size(); a++){
            String bangunan = toko.getIdxJenisBangunan(a).getBarang();
            String kualitasBA = String.valueOf(toko.getIdxJenisBangunan(a).getKualitas());
            bangunan += "/ " + kualitasBA;
            int totalHarga = banyakBangunan * toko.getIdxJenisBangunan(a).getHarga();
            
            for(int b = 0; b < toko.getJenisAdonan().size(); b++){
                String adonan = toko.getIdxJenisAdonan(b).getBarang();
                String kualitasAD = String.valueOf(toko.getIdxJenisAdonan(b).getKualitas());
                adonan += "/ " + kualitasAD;
                totalHarga += banyakAdonan * toko.getIdxJenisAdonan(b).getHarga();
                
                for(int c = 0; c < toko.getJenisPerekat().size(); c++){
                    String perekat = toko.getIdxJenisPerekat(c).getBarang();
                    String kualitasPE = String.valueOf(toko.getIdxJenisPerekat(c).getKualitas());
                    perekat += "/ " + kualitasPE;
                    totalHarga += banyakPerekat * toko.getIdxJenisPerekat(c).getHarga();
                    
                    for(int d = 0; d < toko.getJenisLantai().size(); d++){
                        String lantai = toko.getIdxJenisLantai(d).getBarang();
                        String kualitasLA = String.valueOf(toko.getIdxJenisLantai(d).getKualitas());
                        lantai += "/ " + kualitasLA;
                        totalHarga += banyakLantai * toko.getIdxJenisLantai(d).getHarga();
                    
                        for(int e = 0; e < toko.getJenisAtap().size(); e++){
                            String atap = toko.getIdxJenisAtap(e).getBarang();
                            String kualitasAT = String.valueOf(toko.getIdxJenisAtap(e).getKualitas());
                            atap += "/ " + kualitasAT;
                            totalHarga += banyakAtap * toko.getIdxJenisAtap(e).getHarga();
                            
                            String[] kualitas = {
                                kualitasBA, 
                                kualitasAD, 
                                kualitasPE, 
                                kualitasLA, 
                                kualitasAT
                            };
                            String[] namaBarang = {
                                toko.getIdxJenisBangunan(a).getBarang(),
                                toko.getIdxJenisAdonan(b).getBarang(),
                                toko.getIdxJenisPerekat(c).getBarang(),
                                toko.getIdxJenisLantai(d).getBarang(),
                                toko.getIdxJenisAtap(e).getBarang()
                            };
                            
                            solusiBF(kualitas, namaBarang, totalHarga, budget, toko.getSolusiData()[0] == null);
                            
                            Object[] data = {bangunan, adonan, perekat, lantai, atap, totalHarga};
                            tableModel.addRow(data);
                            
                            totalHarga -= banyakAtap * toko.getIdxJenisAtap(e).getHarga();
                        }
                        totalHarga -= banyakLantai * toko.getIdxJenisLantai(d).getHarga();
                    }
                    totalHarga -= banyakPerekat * toko.getIdxJenisPerekat(c).getHarga();
                }
                totalHarga -= banyakAdonan * toko.getIdxJenisAdonan(b).getHarga();
            }
            totalHarga -= banyakAdonan * toko.getIdxJenisBangunan(a).getHarga();
        }
    }
}
