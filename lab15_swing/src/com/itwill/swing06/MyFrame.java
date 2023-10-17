package com.itwill.swing06;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private Component parenetComponent; // 부모 컴포넌트를 저장할 필드
    private AppMain06 app; // 메인 객체를 저장할 필드
    
    private JTextField textField;
    
    /**
     * Launch the application.
     */
    public static void showMyFrame(Component parentComponent, AppMain06 app) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MyFrame frame = new MyFrame(parentComponent, app);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MyFrame(Component parentComponent, AppMain06 app) {
        // 필드 초기화
        this.parenetComponent = parentComponent;
        this.app = app;
        
        initialize();
    }
    
    public void initialize() {
        setTitle("MyFrame");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //-> 기본 닫기(x버튼) 동작을 설정: 현재 창만 닫고, 프로그램은 계속 실행.
        
        int x = 100; // parentComponet가 null일 때 사용할 x 좌표
        int y = 100; // parentComponet가 null일 때 사용할 y 좌표
        if (parenetComponent != null) {
            x = parenetComponent.getX(); // 부모 컴포넌트의 x 좌표
            y = parenetComponent.getY(); // 부모 컴포넌트의 y 좌표
        }
        setBounds(x, y, 450, 300);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        textField = new JTextField();
        textField.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textField.setBounds(12, 33, 410, 73);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btn = new JButton("메시지 보내기");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // AppMain06에게 메시지를 보냄.
                app.notify(textField.getText());
                // 현재 창을 닫음.
                dispose();
            }
        });
        btn.setFont(new Font("D2Coding", Font.PLAIN, 24));
        btn.setBounds(12, 142, 410, 62);
        contentPane.add(btn);
    }
}
