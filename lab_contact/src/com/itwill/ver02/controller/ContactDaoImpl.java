package com.itwill.ver02.controller;

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

    public static final int MAX_LENGTH = 2;
    private Contact[] contacts = new Contact[MAX_LENGTH];
    private int count = 0;
    
    /**
     * 아규먼트 index가 유효한 범위의 인덱스인 지를 검사.
     * index >= 0 이고, index가 배열에 저장된 원소 개수(count)보다 작으면 true, 
     * 그렇지 않으면 false.
     * 
     * @param index 유효한 지 검사할 인덱스. 정수(int) 타입.
     * @return true 또는 false.
     */
    public boolean isValidIndex(int index) {
        return index >= 0 && index < MAX_LENGTH;
    }
    
    /**
     * 연락처 정보를 저장할 수 있는 배열에 빈 공간이 있으면 true, 그렇지 않으면 false를 리턴.
     * 배열(contacts)에 현재까지 저장된 원소 개수(count)가 배열의 길이보다 작으면 true.
     * 
     * @return true 또는 false.
     */
    public boolean isMemoryAvail() {
        return count < MAX_LENGTH;
    }
    
    @Override
    public Contact[] read() {
        // null이 아닌 배열 원소들만 복사하자.
        Contact[] array = new Contact[count];
        for (int i = 0; i < count; i++) {
            array[i] = contacts[i];
        }
        
        return array;
    }

    @Override
    public int create(Contact contact) {
        int result = 0;
        
        if (isMemoryAvail()) { // 현재 저장된 원소 개수가 배열 최대 길이보다 작으면
            contacts[count] = contact; // 배열에 저장
            count++; // 저장 원소 개수 증가
            result = 1; // 메서드 반환값을 1(성공)으로 설정.
        }
        
        return result;
    }

    @Override
    public Contact read(int index) {
        Contact contact = null;
        if (isValidIndex(index)) { // index가 유효하면(0 <= index < count)
            contact = contacts[index]; // 배열에서 해당 인덱스의 Contact 객체를 찾아서 리턴.
        }
        
        return contact;
    }

    @Override
    public int update(int index, Contact contact) {
        int result = 0;
        
        if (isValidIndex(index)) { // index가 유효하면(0 <= index < count)
            contacts[index] = contact; // 해당 인덱스의 Contact 객체를 업데이트.
            result = 1; // 반환값을 1(성공)으로 설정.
        }
        
        return result;
    }

}
