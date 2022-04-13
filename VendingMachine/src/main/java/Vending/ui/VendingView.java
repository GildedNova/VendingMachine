/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vending.ui;

import java.util.List;
import javax.swing.text.View;
import Vending.dao.VendingDaoFileImpl;
import Vending.dto.Change;
import Vending.dto.Item;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 *
 * @author Austin
 */
public class VendingView {

    enum currency {
        QUARTER, DIME, NICKEL, PENNY
    }
    
    UserIO io = new UserIOConsoleImpl();

    public VendingView(UserIO io) {
        this.io = io;
    }
    
    //Prints menu to user and asks for a users choice of which to chose.
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Choose Item");
        io.print("2. Exit");

        return io.readInt("Please select from the above choices.", 1, 3);
    }
    
    //Asks user to how much money to place into the vending machine. Takes in a $$.CC format
    public String askUserForAmount(){
        return io.readString("How much money would you like to put into the machine? $.CC format: ");
        
    }
    
    //List all items in the .txt file to display to user
    public void displayItemList(List<Item> itemList) {
        for (Item currentItem : itemList) {
            String itemInfo = String.format("#%s : %s : Cost: %s : Amount left: %s",
                    currentItem.getItemId(),
                    currentItem.getName(),
                    currentItem.getCost(),
                    currentItem.getInventory());
            io.print(itemInfo);
        }
    }
    
    //Gets an item id from user
    public String getItemId(){
        return io.readString("Choose an item ID you would like to purchase.");
    }
    
    
    //Displays the change to user. Uses Change Class to calculate change and returns a hashmap with Coins as keys, and
    //amount of coins as the values. BigDecimal calculations for processing the change.
    public void displayMoney(BigDecimal money, Change change){
        HashMap<String, String> changeMap = change.getChange(money.intValue());
        io.print("======Here is your change======");
        io.print("Quarters = " + changeMap.get(currency.QUARTER.toString().toLowerCase()));
        io.print("Dimes = " + changeMap.get(currency.DIME.toString().toLowerCase()));
        io.print("Nickels = " + changeMap.get(currency.NICKEL.toString().toLowerCase()));
        io.print("Pennies = " + changeMap.get(currency.PENNY.toString().toLowerCase()));
        
    }


}
    


