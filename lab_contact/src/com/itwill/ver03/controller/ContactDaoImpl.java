package com.itwill.ver03.controller;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver02.model.Contact;

public class ContactDaoImpl implements ContactDao {
    
    private static ContactDaoImpl instance = null;
    
    private ContactDaoImpl() {}
    
    public static ContactDaoImpl getInstance() {
        if (instance == null) {
            instance = new ContactDaoImpl();
        }
        
        return instance;
    }

    private List<Contact> contacts = new ArrayList<>();
    
    public boolean isValidIndex(int index) {
        return index >= 0 && index < contacts.size();
    }
    
    @Override
    public List<Contact> read() {
        return contacts;
    }

    @Override
    public Contact read(int index) {
//        if (isValidIndex(index)) {
//            return contacts.get(index);
//        } else {
//            return null;
//        }
        try {
            return contacts.get(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public int create(Contact contact) {
        contacts.add(contact);
        
        return 1;
    }

    @Override
    public int update(int index, Contact contact) {
        if (!isValidIndex(index)) {
            return 0;
        }
        
        contacts.set(index, contact);
        
        return 1;
    }

    @Override
    public int delete(int index) {
        if (!isValidIndex(index)) {
            return 0;
        }
        
        contacts.remove(index);
        
        return 1;
    }

}
