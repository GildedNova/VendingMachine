/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vending.vending;

import Vending.controller.VendingController;
import Vending.dao.VendingAuditDao;
import Vending.dao.VendingDao;
import Vending.service.VendingServiceLayer;
import Vending.ui.UserIO;
import Vending.ui.UserIOConsoleImpl;
import Vending.ui.VendingView;

/**
 *
 * @author Austin
 */
public class App {

    UserIO myIo = new UserIOConsoleImpl();
    VendingView myView = new Vending.ui.VendingView();
    VendingDao myDao = new Vending.dao.VendingDao();
    VendingAuditDao myAuditDao = new Vending.dao.VendingAuditDaoFileImpl();
    VendingServiceLayer myService = new Vending.service.VendingServiceLayerImpl(myDao, myAuditDao);
    VendingController controller = new Vending.controller.VendingController(myService, myView);
    controller.run()

}
