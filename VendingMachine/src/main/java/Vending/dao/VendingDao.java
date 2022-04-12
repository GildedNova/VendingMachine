/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Vending.dao;

import java.util.List;
import Vending.dto.Item;


/**
 *
 * @author Austin
 */


public interface VendingDao {
    
    // display all Items in vending machine
    List<Item> displayItems();
    
    //add money to vending machine
    void addMoney();
    
    //choosing items from inventory
    void chooseItem();
    
    //updates inventory by removing an item from itemlist
    void updateInventory();
}
