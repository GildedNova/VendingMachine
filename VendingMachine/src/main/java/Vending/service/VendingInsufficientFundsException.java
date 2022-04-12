/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vending.service;

/**
 *
 * @author Austin
 */
public class VendingInsufficientFundsException extends Exception{
    public VendingInsufficientFundsException(String message){
        super(message);
    }
    
    public VendingInsufficientFundsException(String message, Throwable cause){
        super(message, cause);
    }
}
