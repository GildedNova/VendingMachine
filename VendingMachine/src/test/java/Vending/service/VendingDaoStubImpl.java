/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vending.service;

import Vending.dao.VendingDao;
import Vending.dao.VendingPersistenceException;
import Vending.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khani
 */
public class VendingDaoStubImpl implements VendingDao {

    private Item item;

    public VendingDaoStubImpl() {
        this.item = new Item("0001");
        item.setName("HoneyBun");
        item.setCost("0.50");
        item.setInventory("10");
    }

    public VendingDaoStubImpl(Item item) {
        this.item = item;
    }

    @Override
    public List<Item> displayItems() throws VendingPersistenceException {
        List<Item> itemList = new ArrayList<>();
        itemList.add(item);
        return itemList;
    }

    @Override
    public Item chooseItem(String itemId) throws VendingPersistenceException {
        if (itemId.equals(item.getItemId())) {
            return item;
        }
        return null;
    }

    @Override
    public Item updateInventory(String itemId) throws VendingPersistenceException {
        if (itemId.equals(item.getItemId())) {
            int inventory = Integer.parseInt(item.getInventory()) - 1;
            item.setInventory(String.valueOf(inventory));
            return item;
        }
        return null;
    }

    @Override
    public BigDecimal getItemCost(String itemId) throws VendingPersistenceException {
        if (itemId.equals(item.getItemId())) {
            BigDecimal tempItemCost = new BigDecimal(item.getCost());
            BigDecimal itemCost = tempItemCost.multiply(BigDecimal.valueOf(100));
            return itemCost;
        }

        return null;

    }

    @Override
    public int getItemInventory(String itemId) throws VendingPersistenceException {
        if (itemId.equals(item.getItemId())) {
            int itemInventory = Integer.parseInt(item.getInventory());
            return itemInventory;
        }

        return 0;
    }

}
