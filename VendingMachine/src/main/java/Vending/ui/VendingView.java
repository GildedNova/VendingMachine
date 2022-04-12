/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vending.ui;

import javax.swing.text.View;

/**
 *
 * @author Austin
 */
public class VendingView {

    UserIO io = new UserIOConsoleImpl();

    public VendingView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add money");
        io.print("2. Choose Item");
        io.print("3. Exit");

        return io.readInt("Please select from the above choices.", 1, 3);
    }
    
    

}
