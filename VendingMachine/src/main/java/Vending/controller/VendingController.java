/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vending.controller;

import Vending.service.VendingServiceLayer;
import Vending.ui.UserIO;
import Vending.ui.UserIOConsoleImpl;
import Vending.ui.VendingView;
import Vending.dao.VendingDao;
import Vending.dao.VendingPersistenceException;
import java.math.BigDecimal;
import Vending.dto.Item;
import Vending.dto.Change;
import Vending.service.VendingInsufficientFundsException;
import Vending.service.VendingNoItemInventoryException;
import java.util.List;
/**
 *
 * @author Austin
 */
public class VendingController {

    private VendingServiceLayer service;
    private VendingView view;
    private final UserIO io = new UserIOConsoleImpl();

    //Dependency injection
    public VendingController(VendingServiceLayer dao, VendingView view) {
        this.service = dao;
        this.view = view;
    }
    
    
    
    public void run() throws VendingInsufficientFundsException, VendingNoItemInventoryException, VendingPersistenceException {
        boolean keepGoing = true;
        int menuSelection = 0;
    
        BigDecimal money = getMoney();
        Change change = new Change();
        
        //Main program loop, used to get user selection and process choice
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        buyItem(money, change);
                        keepGoing = false;
                        break;
                    case 2:
                        keepGoing = false;
                        break;
                    default:
                        io.print("UNKNOWN");
                        break;
                }
            }
        } catch (VendingPersistenceException e) {  
        }
        
        

    }

    //Calls view method to get user selection
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    //Asks the user how much money they are placing into the vending machine. returns amount in pennies as BigDecimal
    private BigDecimal getMoney() throws VendingPersistenceException{
       String amount = view.askUserForAmount();
       BigDecimal pennies = new BigDecimal(amount).multiply(BigDecimal.valueOf(100));
       return pennies;
    }
    
    //Buys items from vending machine
    private void buyItem(BigDecimal money, Change change) throws VendingPersistenceException, VendingInsufficientFundsException, VendingNoItemInventoryException{
        //Displays items to user
        List<Item> itemList = service.displayItems();
        view.displayItemList(itemList);
        //Gets item id from user
        String itemId = view.getItemId();
        //Processing the item and throws exceptions. Removes an item from .txt file, also adds an audit
        service.chooseItem(itemId, money);
        service.updateInventory(itemId);
        //Processes amount of change left and shows the user
        money = money.subtract(service.getItemCost(itemId));
        view.displayMoney(money, change);
        
    }

}
