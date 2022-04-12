/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vending.dao;

import java.util.List;
import Vending.dto.Item;

/**
 *
 * @author Austin
 */
public class VendingDaoFileImpl implements VendingDao {
    
        // display all Items in vending machine
        @Override
	public List<Item> displayItems(){
            
            throw new UnsupportedOperationException("Not supported yet.");
	}
        //add money to vending machine
	@Override
	public void addMoney() {
            throw new UnsupportedOperationException("Not supported yet.");
	}
        //choosing items from inventory
	@Override
	public void chooseItem() {
            throw new UnsupportedOperationException("Not supported yet.");
	}
        //updates inventory by removing an item from itemlist
	@Override
	public void updateInventory() {
            throw new UnsupportedOperationException("Not supported");
	}
    
}
