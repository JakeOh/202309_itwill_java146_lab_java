package com.itwill.ver02.controller;

import com.itwill.ver02.model.Contact;

public class ContactDaoImpl implements ContactDao {
    
    private static ContactDaoImpl instance = null;
    
    private ContactDaoImpl() {}
    
    public static ContactDaoImpl getInstance() {
        if (instance == null) {
            instance = new ContactDaoImpl();
        }
        
        return null;
    }

    public static final int MAX_LENGTH = 2;
    private Contact[] contacts = new Contact[MAX_LENGTH];
    private int count = 0;
    
    @Override
    public Contact[] read() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int create(Contact contact) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Contact read(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int update(int index, Contact contact) {
        // TODO Auto-generated method stub
        return 0;
    }

}
