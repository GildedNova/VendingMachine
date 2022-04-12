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

public class Change {
    
    private BigDecimal quarter, dime, nickel, penny;

    enum Coins {
        QUARTER(25), DIME(10), NICKEL(5), PENNY(1);
        
        private final double amount;

        private Coins(double amount) {
            this.amount = amount;
        } 
        
        public double getAmount(){
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
    
    public HashMap<String, String> getChange(int pennies){
       
        BigDecimal bigPennies = new BigDecimal(pennies);
        
        
       
        quarter = bigPennies.divide(BigDecimal.valueOf(25.0)).setScale(0, RoundingMode.HALF_EVEN); 
        bigPennies = bigPennies.remainder(BigDecimal.valueOf(25.0)).setScale(0, RoundingMode.HALF_EVEN);
        
        
        dime = bigPennies.divide(BigDecimal.valueOf(10.0)).setScale(0, RoundingMode.HALF_EVEN); 
        bigPennies = bigPennies.remainder(BigDecimal.valueOf(10.0)).setScale(0, RoundingMode.HALF_EVEN);
        
        
        nickel = bigPennies.divide(BigDecimal.valueOf(5.0)).setScale(0, RoundingMode.HALF_EVEN); 
        bigPennies = bigPennies.remainder(BigDecimal.valueOf(5.0)).setScale(0, RoundingMode.HALF_EVEN);
        
        
        penny = bigPennies;
        
        
        HashMap<String, String> changeMap = new HashMap<>();
        changeMap.put("quarter", quarter.toString());
        changeMap.put("dime", dime.toString());
        changeMap.put("nickel", nickel.toString());
        changeMap.put("penny", penny.toString());
       
        return changeMap;
    }
    
    
}
