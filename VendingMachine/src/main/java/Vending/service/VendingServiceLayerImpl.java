/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vending.service;

import Vending.dao.VendingAuditDao;
import Vending.dao.VendingDao;

/**
 *
 * @author Austin
 */
public class VendingServiceLayerImpl implements VendingServiceLayer {
    
    private VendingDao dao;
    private VendingAuditDao auditDao;
    
    public VendingServiceLayerImpl(VendingDao dao, VendingAuditDao auditDao){
        this.dao = dao;
        this.auditDao = auditDao;
    }
    
    
    
    
}
