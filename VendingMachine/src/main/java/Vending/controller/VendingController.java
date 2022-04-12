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

    public VendingController(VendingServiceLayer dao, VendingView view) {
        this.service = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        io.print("DROP DORITO'S NACHOS CHIPS");
                        break;
                    case 2:
                        io.print("DROP CHEETOS CHIPS");
                        break;
                    case 3:
                        io.print("DROP RUFFLES SOURCREAM N ONION CHIPS");
                        break;
                    case 4:
                        io.print("DROP PROTEIN BAR");
                        break;
                    case 5:
                        io.print("DROP KITKAT BAR");
                        break;
                    case 6:
                        io.print("DROP TWIX BAR");
                        break;
                    case 7:
                        io.print("DROP SPARKLING WATER");
                        break;
                    case 8:
                        keepGoing = false;
                        break;
                    default:
                        io.print("UNKNOWN");
                        break;
                }
            }
        } catch (Exception e) {
        }

    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

}
