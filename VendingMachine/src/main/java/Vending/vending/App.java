package Vending.vending;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Vending.controller.VendingController;
import Vending.dao.VendingAuditDao;
import Vending.dao.VendingAuditDaoFileImpl;
import Vending.dao.VendingDao;
import Vending.dao.VendingDaoFileImpl;
import Vending.dao.VendingPersistenceException;
import Vending.service.VendingInsufficientFundsException;
import Vending.service.VendingNoItemInventoryException;
import Vending.service.VendingServiceLayer;
import Vending.service.VendingServiceLayerImpl;
import Vending.ui.UserIO;
import Vending.ui.UserIOConsoleImpl;
import Vending.ui.VendingView;

/**
 *
 * @author Austin
 */
public class App {

    public static void main(String[] args) throws VendingInsufficientFundsException, VendingNoItemInventoryException, VendingPersistenceException {
        UserIO myIo = new UserIOConsoleImpl();
        VendingView myView = new VendingView(myIo);
        VendingDao myDao = new VendingDaoFileImpl();
        VendingAuditDao myAuditDao = new VendingAuditDaoFileImpl();
        VendingServiceLayer myService = new VendingServiceLayerImpl(myDao, myAuditDao);
        VendingController controller = new VendingController(myService, myView);
        controller.run();
    }

}
