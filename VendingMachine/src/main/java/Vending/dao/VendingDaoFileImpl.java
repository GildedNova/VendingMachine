/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vending.dao;

import java.util.List;
import Vending.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.math.BigDecimal;

/**
 *
 * @author Austin
 */
public class VendingDaoFileImpl implements VendingDao {

    public static final String ITEMS_FILE = "items.txt";
    public static final String DELIMITER = "::";

    private Map<String, Item> items = new HashMap<>();

    // display all Items in vending machine
    @Override
    public List<Item> displayItems() throws VendingPersistenceException{
        loadItems();
        return new ArrayList<Item>(items.values());
    }

    //add money to vending machine
    @Override
    public void addMoney() throws VendingPersistenceException{
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //choosing items from inventory
    @Override
    public Item chooseItem(String itemId) throws VendingPersistenceException{
        loadItems();
        return items.get(itemId);
    }

    //updates inventory by removing an item from itemlist
    @Override
    public Item updateInventory(String itemId) throws VendingPersistenceException{
        loadItems();
        Item updatedItem = items.get(itemId);
        int inventory = Integer.parseInt(updatedItem.getInventory()) - 1;
        updatedItem.setInventory(String.valueOf(inventory));
        return items.get(itemId);
        
    }
    //get cost of item
    @Override
    public BigDecimal getItemCost(String itemId) throws VendingPersistenceException{
        loadItems();
        Item tempItem = items.get(itemId);
        BigDecimal tempItemCost = new BigDecimal(tempItem.getCost());
        BigDecimal itemCost = tempItemCost.multiply(BigDecimal.valueOf(100));
        return itemCost;
    }

    private Item unmarshallItem(String itemAsText) {
        // ItemAsText is expecting a line read in from our file.
        // For example, it might look like this:
        // ItemId::Name::Cost::Inventory::
        //
        // We then split that line on our DELIMITER - which we are using as ::
        // Leaving us with an array of Strings, stored in Item Tokens.
        // Which should look like this:
        // __________________________________
        // |      |      |      |           |
        // |ItemID| Name | Cost | Inventory |
        // |      |      |      |           |
        // ----------------------------------
        // [0]      [1]     [2]     [3] 
        String[] itemTokens = itemAsText.split(DELIMITER);

        // Given the pattern above, the itemID is in index 0 of the array.
        String itemID = itemTokens[0];

        // Which we can then use to create a new item object to satisfy
        // the requirements of the Student constructor.
        Item itemFromFile = new Item(itemID);

        // However, there are 3 remaining tokens that need to be set into the
        // new item object. Do this manually by using the appropriate setters.
        // Index 1 - Item Name
        if (itemTokens.length > 1) {
            itemFromFile.setName(itemTokens[1]);

            // Index 2 - Item Cost
            itemFromFile.setCost(itemTokens[2]);

            // Index 3 - Item Inventory
            itemFromFile.setInventory(itemTokens[3]);
        }

        // We have now created a item! Return it!
        return itemFromFile;
    }
    

    private void loadItems() throws VendingPersistenceException{
        Scanner scanner = null;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(ITEMS_FILE)));
        } catch (FileNotFoundException e) {

        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentItem holds the most recent item unmarshalled
        Item currentItem;
        // Go through ITEM_FILE line by line, decoding each line into a
        // ITEM object by calling the unmarshallItem method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a item
            currentItem = unmarshallItem(currentLine);

            // We are going to use the ItemID as the map key for our item object.
            // Put currentItem into the map using itemID as the key
            items.put(currentItem.getItemId(), currentItem);
        }
        // close scanner
        scanner.close();
    }

    private String marshallItem(Item item) {
        // We need to turn a item object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // ItemId::Name::Cost::Inventory::

        // Start with the ItemID, since that's supposed to be first.
        String itemAsText = item.getItemId() + DELIMITER;

        // add the rest of the properties in the correct order:
        // get item name
        itemAsText += item.getName() + DELIMITER;

        // get cost
        itemAsText += item.getCost() + DELIMITER;

        // get inventory
        itemAsText += item.getInventory() + DELIMITER;

        // We have now turned a item to text! Return it!
        return itemAsText;
    }

    /**
     * Writes all items in the item out to a item file.
     *
     * @throws ClassRosterDaoException if an error occurs writing to the file
     */
    private void writeLibrary() throws VendingPersistenceException{
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(ITEMS_FILE));
        } catch (IOException e) {

        }

        // Write out the item objects to the item file.
        String DVDAsText;
        List<Item> itemList = this.displayItems();
        for (Item currentItem : itemList) {
            // turn a item into a String
            DVDAsText = marshallItem(currentItem);
            // write the item object to the file
            out.println(DVDAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

}
