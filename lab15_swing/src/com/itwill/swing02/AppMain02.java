package com.itwill.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain02 {

    // field
    private JFrame frame;
    private JTextField textInput;
    private JLabel lblMessage;
    private JButton btnInput;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain02 window = new AppMain02();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AppMain02() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null); // absolute layout(절대 레이아웃)
        
        lblMessage = new JLabel("메시지 입력하세요...");
        lblMessage.setFont(new Font("D2Coding", Font.BOLD, 24));
        lblMessage.setBounds(12, 10, 410, 60);
        frame.getContentPane().add(lblMessage);
        
        textInput = new JTextField();
        textInput.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textInput.setBounds(12, 80, 410, 60);
        frame.getContentPane().add(textInput);
        textInput.setColumns(10);
        
        btnInput = new JButton("입력"); // 버튼 객체 생성
        // 버튼에 ActionLister 객체를 설정(등록)
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼을 클릭했을 때 수행할 기능 작성.
                handleButtonClick();
            }
        });
        btnInput.setFont(new Font("D2Coding", Font.BOLD, 24));
        btnInput.setBounds(120, 150, 200, 60);
        frame.getContentPane().add(btnInput);
    }
    
    private void handleButtonClick() {
        // 1. JTextField에 입력된 문자열을 읽음.
        String msg = textInput.getText();
        // 2. 1에서 읽은 문자열을 JLabel에 씀.
        lblMessage.setText(msg);
        // 3. JTextField에 입력된 내용을 지움.
        textInput.setText("");
    }
    
}
