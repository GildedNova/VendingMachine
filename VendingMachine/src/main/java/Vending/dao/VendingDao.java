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
    List<Item> displayItems();
    
    void addMoney();
    
    void chooseItem();
    
    void updateInventory();
}
