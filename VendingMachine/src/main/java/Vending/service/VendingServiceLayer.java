/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Vending.service;

import Vending.dao.VendingPersistenceException;
import Vending.dto.Item;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author Austin
 */
public interface VendingServiceLayer {
    
    Item chooseItem(String itemId, BigDecimal money) throws
            VendingPersistenceException,
            VendingInsufficientFundsException,
            VendingNoItemInventoryException;
    
    
    List<Item> displayItems() throws
            VendingPersistenceException;
    
    void updateInventory(String itemId) throws
            VendingPersistenceException;
            
    BigDecimal getItemCost(String itemId) throws 
            VendingPersistenceException;
    
    int getItemInventory(String itemId) throws 
            VendingPersistenceException;
    
}
