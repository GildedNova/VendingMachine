/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vending.service;

import Vending.dao.VendingAuditDao;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Vending.dao.VendingDao;
import Vending.dto.Item;
import Vending.service.VendingServiceLayer;
import java.math.BigDecimal;

/**
 *
 * @author Ishraq
 */
// I HAVE ALL THE NECESSARY TEST METHODS BUT THE
// VALUES ARE CALLED ARE WRONGLY CAUSING FAILURE AND I DONT HAVE AnY TIME LEFT
public class VendingServiceLayerImplTest {

    VendingDao dao = new VendingDaoStubImpl();
    VendingAuditDao auditDao = new VendingAuditDaoStubImpl();
    VendingServiceLayer service = new VendingServiceLayerImpl(dao, auditDao);

    public VendingServiceLayerImplTest() {
    }

    // Test displayItem Method
    @Test
    public void testDisplayItems() throws Exception {
        // ARRANGE
        Item testClone = new Item("0001");
        testClone.setName("HoneyBun");
        testClone.setCost("0.50");
        testClone.setInventory("10");

        // ACT & ASSERT
        assertEquals(1, service.displayItems().size(),
                "Should only have one item.");
        assertTrue(service.displayItems().contains(testClone),
                "The one item should be HoneyBun.");
    }

    // Tests chooseItem Method
    @Test
    public void testChooseItem() throws Exception {
        // ARRANGE
        Item testClone = new Item("0001");
        testClone.setName("HoneyBun");
        testClone.setCost("0.50");
        testClone.setInventory("10");
        // ACT & ASSERT
        Item returnedItem = service.chooseItem(testClone.getItemId(), BigDecimal.valueOf(3.00));
        assertEquals(testClone, returnedItem, "Getting 0001 should be not null.");

        Item shouldBeNull = service.chooseItem("0009", BigDecimal.valueOf(3.00));
        assertNull(shouldBeNull, "Getting 0009 should be null.");
    }

    // test insufficientFunds Exception
    @Test
    public void testInsufficientFunds() throws Exception {
        // ARRANGE
        Item testClone = new Item("0001");
        testClone.setName("HoneyBun");
        testClone.setCost("0.50");
        testClone.setInventory("10");

        // Above values already in default constructor
        Item returnedItem = service.chooseItem("0001", BigDecimal.valueOf(3.00));

        // ACT 
        try {
            service.chooseItem(testClone.getItemId(), BigDecimal.valueOf(0.25));
        } catch (VendingInsufficientFundsException e) {
            // ASSERT
            fail("Item was valid but funds was not enough. VendingInsufficientFundsException was thrown.");
        }
    }

    // test noItemInventory Exception
    @Test
    public void testNoItemInventoryTest() throws Exception {
        // ARRANGE
        Item testClone = new Item("0001");
        testClone.setName("HoneyBun");
        testClone.setCost("0.50");
        testClone.setInventory("10");
        // Above values already in default constructor
        Item returnedItem = service.chooseItem("0001", BigDecimal.valueOf(3.00));
        returnedItem.setInventory("0");

        try {
            service.chooseItem(testClone.getItemId(), BigDecimal.valueOf(3.00));
        } catch (VendingNoItemInventoryException e) {
            // ASSERT
            fail("Item was valid but no more of it left in inventory. VendingNoItemInventoryException was thrown");
        }
    }

    // test updating the inventory
    @Test
    public void testUpdateInventory() throws Exception {
        // ARRANGE
        Item testClone = new Item("0001");
        testClone.setName("HoneyBun");
        testClone.setCost("0.50");
        testClone.setInventory("10");
        // Above values already in default constructor
        Item returnedItem = service.chooseItem("0001", BigDecimal.valueOf(3.00));
        // ACT & ASSERT
        service.updateInventory("0001");
        assertEquals(9, returnedItem.getInventory(), " The item should have one less in inventory, should have 9 left");
    }

    // test getting cost of them chosen item
    @Test
    public void testGetItemCost() throws Exception {
        // ARRANGE
        Item testClone = new Item("0001");
        testClone.setName("HoneyBun");
        testClone.setCost("0.50");
        testClone.setInventory("10");

        // ACT & ASSERT
        BigDecimal itemCost = service.getItemCost("0001");
        assertEquals(BigDecimal.valueOf(50.00), itemCost, "Should have recieved the item cost of 0.50 or 50 pennies");
    }

    // test getting current inventory of chosen item
    @Test
    public void testGetInventory() throws Exception {
        // ARRANGE
        Item testClone = new Item("0001");
        testClone.setName("HoneyBun");
        testClone.setCost("0.50");
        testClone.setInventory("10");

        // ACT & ASSERT
        int inventory = service.getItemInventory("0001");
        assertEquals(9, inventory, "Should return 9 because the returnedItem has 7 left in stock");
    }

}
