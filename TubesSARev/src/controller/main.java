/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.tokoBangunan;
import view.pageMenu;

/**
 *
 * @author David
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        filteringDataBangunan filter = new filteringDataBangunan();
        pageMenu menu;
        
        filter.setDefaultDataBangunan();
        filter.setDataJenis();
        
        menu = new pageMenu();
        menu.setVisible(true);
        menu.pack();
        menu.setDefaultCloseOperation(menu.EXIT_ON_CLOSE);
    }
    
}
