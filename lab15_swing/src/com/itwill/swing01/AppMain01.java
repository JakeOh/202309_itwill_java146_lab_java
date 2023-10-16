package com.itwill.swing01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AppMain01 {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    AppMain01 window = new AppMain01();
                    window.frame.setVisible(true); // JFrame을 화면에 보여줌.
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AppMain01() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame(); // JFrame 객체 생성, 필드 초기화.
        frame.setBounds(100, 100, 600, 400); // JFrame의 시작 좌표(x, y)와 크기(가로, 세로) 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //-> JFrame 우상단에 있는 닫기 버튼(x)의 기능(동작)을 설정 - 프로그램 종료
        
        JLabel lblMessage = new JLabel("Hello, Swing!");
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lblMessage.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 24));
        frame.getContentPane().add(lblMessage, BorderLayout.CENTER);
    }

}
