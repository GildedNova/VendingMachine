/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vending.dto;

import java.util.HashMap;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Austin
 */

enum Coins {
        QUARTER, DIME, NICKEL, PENNY
    }

//Change object. Created using a penny count passed through constructor. Penny count
//is then calculated into QUARTER, DIME, NICKEL, PENNY (enums) and sets private variables.
//Setters and Getters to continue forward.

//This class is static maybe? Because we'll only be using one change object
public class Change {
    
    private BigDecimal quarter, dime, nickel, penny;

    enum Coins {
        QUARTER(25), DIME(10), NICKEL(5), PENNY(1);
        
        private final int amount;

        private Coins(int amount) {
            this.amount = amount;
        } 
        
        public int getAmount(){
            return amount;
        }
    }

    public BigDecimal getDime() {
        return dime;
    }

    public BigDecimal getNickel() {
        return nickel;
    }

    public BigDecimal getPenny() {
        return penny;
    }

    public BigDecimal getQuarter() {
        return quarter;
    }
    
    private HashMap<String, BigDecimal> getChange(int pennies){
       
        BigDecimal bigPennies = new BigDecimal(pennies);
        if(pennies >= Coins.QUARTER.getAmount()){
            quarter = quarter.divide(bigPennies).setScale(0, RoundingMode.HALF_UP);
            bigPennies = quarter.remainder(bigPennies).setScale(0,RoundingMode.HALF_UP);
        }
        if(pennies >= Coins.DIME.getAmount()){
            dime = dime.divide(bigPennies).setScale(0, RoundingMode.HALF_UP);
            bigPennies = dime.remainder(bigPennies).setScale(0,RoundingMode.HALF_UP);
        }
        if(pennies >= Coins.NICKEL.getAmount()){
            nickel = nickel.divide(bigPennies).setScale(0, RoundingMode.HALF_UP);
            bigPennies = nickel.remainder(bigPennies).setScale(0,RoundingMode.HALF_UP);
        }
        penny = bigPennies;
        
        HashMap<String, BigDecimal> changeMap = new HashMap<>();
        changeMap.put("quarter", quarter);
        changeMap.put("dime", dime);
        changeMap.put("nickel", nickel);
        changeMap.put("penny", penny);
     
        return changeMap;
    }
    
    
}
