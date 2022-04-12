/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vending.dto;
import java.util.Objects;
/**
 *
 * @author Austin
 */

//Item object for vending machine. Machine will be a list of these objects.
//Item must have a Name, Cost, and Inventory of item.
//These items will be stored in a text file using DAO
public class Item {
    
    private final String itemId;
    private String name;
    private String cost;
    private String inventory;

    public Item(String itemId){
        this.itemId = itemId;
    }
    
    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public String getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.cost);
        hash = 89 * hash + Objects.hashCode(this.inventory);
        hash = 89 * hash + Objects.hashCode(this.itemId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.cost, other.cost)) {
            return false;
        }
        if (!Objects.equals(this.inventory, other.inventory)) {
            return false;
        }
        if (!Objects.equals(this.itemId, other.itemId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "ItemId= " + itemId + "Name=" + name + ", Cost=" + cost + ", Inventory=" + inventory + '}';
    }
    
}
