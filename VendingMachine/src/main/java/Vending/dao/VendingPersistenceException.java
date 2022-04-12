/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vending.dao;

/**
 *
 * @author Austin
 */
public class VendingPersistenceException extends Exception{
    public VendingPersistenceException(String message){
        super(message);
    }
    
    public VendingPersistenceException(String message, Throwable cause){
        super(message, cause);
    }
}
