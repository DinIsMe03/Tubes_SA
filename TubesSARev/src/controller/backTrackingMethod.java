/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mxgraph.swing.*;
import com.mxgraph.view.*;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import model.tokoBangunan;

/**
 *
 * @author David
 */
public class backTrackingMethod extends JInternalFrame{
    
    public backTrackingMethod(){
        BasicInternalFrameUI title = (BasicInternalFrameUI) this.getUI();
        tokoBangunan toko = new tokoBangunan();
        
        title.setNorthPane(null);
        title.setEastPane(null);
        title.setSouthPane(null);
        title.setWestPane(null);
        
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();
        
        graph.getModel().beginUpdate();
        
        Object awal;
        Object nodeBangunan;
        Object nodeAdonan;
        Object nodePerekat;
        Object nodeLantai;
        Object nodeAtap;
        
        int wBA = 400;
        int wAD = 300;
        int wPE = 200;
        int wLA = 100;
        int wAT = 0;
        int totalHarga = 0;
        Boolean cek = false;
        
        awal = graph.insertVertex(
                parent, 
                null, 
                "Awal\nHarga", 
                1000, 10, 60, 30
        );
        
        try{
            int a = toko.getJenisBangunan().size() - 1;
            while(a >= 0 && !cek){
                toko.getIdxJenisBangunan(a).getHarga();
                totalHarga += toko.getIdxJenisBangunan(a).getHarga();
                int b = toko.getJenisAdonan().size() - 1;
                nodeBangunan = graph.insertVertex(
                        parent, null, 
                        toko.getIdxJenisBangunan(a).getBarang(), 
                        wBA, 120, 80, 20
                );
                graph.insertEdge(parent, null, null, awal, nodeBangunan);
                wBA += 400;
                
                if(toko.getBudget() > totalHarga){
                    while(b >= 0 && !cek){
                        totalHarga += toko.getIdxJenisAdonan(b).getHarga();
                        int c = toko.getJenisPerekat().size() - 1;
                        nodeAdonan = graph.insertVertex(
                                parent, null, 
                                toko.getIdxJenisAdonan(b).getBarang(), 
                                wAD, 220, 100, 20
                        );
                        graph.insertEdge(parent, null, null, nodeBangunan, nodeAdonan);
                        wAD += 300;
                        
                        if(toko.getBudget() > totalHarga){
                            while(c >= 0 && !cek){
                                totalHarga += toko.getIdxJenisPerekat(c).getHarga();
                                int d = toko.getJenisLantai().size() - 1;
                                nodePerekat = graph.insertVertex(
                                        parent, null, 
                                        toko.getIdxJenisPerekat(c).getBarang(), 
                                        wPE, 320, 100, 20
                                );
                                graph.insertEdge(parent, null, null, nodeAdonan, nodePerekat);
                                wPE+= 200;
                                
                                if(toko.getBudget() > totalHarga){
                                    while(d >= 0 && !cek){
                                        totalHarga += toko.getIdxJenisLantai(d).getHarga();
                                        int e = toko.getJenisAtap().size() - 1;
                                        nodeLantai = graph.insertVertex(
                                                parent, null, 
                                                toko.getIdxJenisLantai(d).getBarang(), 
                                                wLA, 420, 100, 20
                                        );
                                        graph.insertEdge(parent, null, null, nodePerekat, nodeLantai);
                                        wLA+= 150;
                                        
                                        if(toko.getBudget() > totalHarga){
                                            while(e >= 0 && !cek){
                                                totalHarga += toko.getIdxJenisAtap(e).getHarga();
                                                nodeAtap = graph.insertVertex(
                                                        parent, null,
                                                        toko.getIdxJenisAtap(e).getBarang(),
                                                        wAT, 520, 100, 20
                                                );
                                                graph.insertEdge(parent, null, null, nodeLantai, nodeAtap);
                                                wAT += 120;
                                                
                                                if(toko.getBudget() >= totalHarga){
                                                    String[] solusi = {
                                                        toko.getIdxJenisAdonan(b).getBarang(),
                                                        toko.getIdxJenisAtap(e).getBarang(),
                                                        toko.getIdxJenisBangunan(a).getBarang(),
                                                        toko.getIdxJenisLantai(d).getBarang(),
                                                        toko.getIdxJenisPerekat(c).getBarang()
                                                    };
                                                    
                                                    toko.setSolusi(solusi, totalHarga);
                                                    
                                                    cek = true;
                                                }
                                                totalHarga -= toko.getIdxJenisAtap(e).getHarga();
                                                e--;
                                            }
                                        }
                                        totalHarga -= toko.getIdxJenisLantai(d).getHarga();
                                        d--;
                                    } 
                                }
                                totalHarga -= toko.getIdxJenisPerekat(c).getHarga();
                                c--;
                            }
                        }
                        totalHarga -= toko.getIdxJenisAdonan(b).getHarga();
                        b--;
                    }
                }
                totalHarga -= toko.getIdxJenisBangunan(a).getHarga();
                a--;
            }
        }
        finally{
            graph.getModel().endUpdate();
        }
        
        mxGraphComponent graphComp = new mxGraphComponent(graph);
        getContentPane().add(graphComp);
        
    }
}