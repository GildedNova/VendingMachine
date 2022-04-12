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
        io.print("Item Menu");
        io.print("1. Dorito's Nachos Chips");
        io.print("2. Cheetos Chips");
        io.print("3. Ruffles Sour Cream n Onion Chips");
        io.print("4. Protein Bar");
        io.print("5. KitKat Bar");
        io.print("6. Twix Bar");
        io.print("7. Sparkling Water");
        io.print("8. Exit");

        return io.readInt("Please select from the above choices.", 1, 8);
    }
    
    

}
