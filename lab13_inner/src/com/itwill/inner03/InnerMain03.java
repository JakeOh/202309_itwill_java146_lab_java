package com.itwill.inner03;

import com.itwill.inner03.Button.OnClickListener;

public class InnerMain03 {

    public static void main(String[] args) {
        // Button 타입 객체를 생성
        Button btnOpen = new Button("열기");
        
        // 버튼이 할 일(메서드)을 가지고 있는 객체(listener)를 생성
        OnClickListener listener = new OpenButtonListener();
        
        // 리스너 객체를 버튼에 등록
        btnOpen.setOnClickListener(listener);
        
        btnOpen.click(); // 버튼을 클릭

    }

}
