/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vending.controller;

import Vending.service.VendingServiceLayer;
import Vending.ui.UserIO;
import Vending.ui.UserIOConsoleImpl;
import Vending.ui.VendingView;

/**
 *
 * @author Austin
 */
public class VendingController {
    
    private VendingServiceLayer service;
    private VendingView view;
    private final UserIO io = new UserIOConsoleImpl();
    
    public VendingController(VendingServiceLayer dao, VendingView view){
        this.service = dao;
        this.view = view;
    }
    
    public void run() {
         
    }
    
}
