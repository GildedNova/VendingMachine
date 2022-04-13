/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vending.service;

import Vending.dao.VendingAuditDao;
import Vending.dao.VendingPersistenceException;

/**
 *
 * @author khani
 */
public class VendingAuditDaoStubImpl implements VendingAuditDao{

    @Override
    public void writeAuditEntry(String entry) throws VendingPersistenceException {
        // do nothing . . .
    }
    
}
