/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vending.service;

import Vending.dao.VendingAuditDao;
import Vending.dao.VendingDao;
import Vending.dao.VendingPersistenceException;
import Vending.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Austin
 */
public class VendingServiceLayerImpl implements VendingServiceLayer {

    private VendingDao dao;
    private VendingAuditDao auditDao;

    public VendingServiceLayerImpl(VendingDao dao, VendingAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public List<Item> displayItems() throws VendingPersistenceException {
        return dao.displayItems();
    }

    @Override
    public Item chooseItem(String itemId, BigDecimal money) throws VendingPersistenceException, VendingInsufficientFundsException, VendingNoItemInventoryException {
        if(money.compareTo(dao.getItemCost(itemId)) == -1){
            throw new VendingInsufficientFundsException("Invalid funds");
        }
        if(getItemInventory(itemId) <= 0){
            throw new VendingNoItemInventoryException("No items left");
        }
        
        auditDao.writeAuditEntry("Item: " + itemId + " was bought.");
        return dao.chooseItem(itemId);
    }

    @Override
    public void updateInventory(String itemId) throws VendingPersistenceException {
        auditDao.writeAuditEntry("Item: " + itemId + " inventory was changed.");
        dao.updateInventory(itemId);
    }
    
    @Override
    public BigDecimal getItemCost(String itemId) throws VendingPersistenceException{
       return dao.getItemCost(itemId);
    }
    
    @Override
    public int getItemInventory(String itemId) throws VendingPersistenceException{
        return dao.getItemInventory(itemId);
    }
    
}
