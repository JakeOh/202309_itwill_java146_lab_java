package com.itwill.inner03;

import com.itwill.inner03.Button.OnClickListener;

public class InnerMain03 {

    public static void main(String[] args) {
        // 1. Button 타입 객체를 생성
        Button btnOpen = new Button("열기");
        
        // 2. 버튼이 할 일(메서드)을 가지고 있는 객체(listener)를 생성
        OnClickListener listener = new OpenButtonListener();
        
        // 3. 리스너 객체를 버튼에 등록 - 버튼에 버튼이 할 일을 설정.
        btnOpen.setOnClickListener(listener);
        
        btnOpen.click(); // 4. 버튼을 클릭
        
        // 1. Button 타입 객체 생성
        Button btnClose = new Button("닫기");
        
        // 2. OnClickListener를 구현하는 클래스를 선언 -> 지역 클래스(local class)
        class CloseButtonListener implements OnClickListener {
            @Override
            public void onClick() {
                System.out.println("파일 닫기 실행...");
            }
        }
        
        // 3. 리스너 객체 생성
        OnClickListener closeListener = new CloseButtonListener();
        
        // 4. 버튼에 리스너를 설정
        btnClose.setOnClickListener(closeListener);
        
        // 5. 버튼 클릭
        btnClose.click();

        // 1. 버튼 타입 객체 생성
        Button saveButton = new Button("저장");
        
        // 2. 리스너 객체 생성 - 익명 클래스
        OnClickListener saveListener = new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("파일 저장...");
            }
        };
        
        // 3. 버튼 할 일 등록 - 버튼 리스너 등록
        saveButton.setOnClickListener(saveListener);
        
        // 4. 버튼 클릭
        saveButton.click();
        
        // 1. 버튼 객체 생성
        Button btnCancel = new Button("취소");
        // 2. 버튼 할 일 등록 - 버튼 리스너 등록
        btnCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("취소...");
            }
        });
        // 3. 버튼 클릭
        btnCancel.click();
        
    } // end main

}
