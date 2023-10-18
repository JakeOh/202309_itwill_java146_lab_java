package com.itwill.ver05.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.itwill.ver04.controller.ContactDaoImpl;
import com.itwill.ver04.model.Contact;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactCreateFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JButton btnSave;
    private JButton btnCancel;
    private JLabel lblName;
    private JLabel lblPhone;
    private JLabel lblEmail;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;

    private Component parent; // 부모 컴포넌트(JFrame)을 저장하기 위한 필드
    private ContactMain05 app;
    
    private ContactDaoImpl dao = ContactDaoImpl.getInstance();
    
    /**
     * Launch the application.
     */
    public static void showContactCreateFrame(Component parent, ContactMain05 app) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactCreateFrame frame = new ContactCreateFrame(parent, app);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 생성자
    public ContactCreateFrame(Component parent, ContactMain05 app) {
        this.parent = parent; // 필드 초기화
        this.app = app; // ContactMain05 타입 객체를 필드에 저장.
        
        initialize(); // Swing 컴포넌트 생성 & 초기화
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("새 연락처");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = 100;
        int y = 100;
        if (parent != null) {
            x = parent.getX() + parent.getWidth();
            y = parent.getY();
        }
        setBounds(x, y, 593, 342);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        mainPanel = new JPanel();
        contentPane.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(null);
        
        lblName = new JLabel("이름");
        lblName.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblName.setBounds(12, 10, 120, 64);
        mainPanel.add(lblName);
        
        lblPhone = new JLabel("전화번호");
        lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblPhone.setBounds(12, 84, 120, 64);
        mainPanel.add(lblPhone);
        
        lblEmail = new JLabel("이메일");
        lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblEmail.setBounds(12, 158, 120, 64);
        mainPanel.add(lblEmail);
        
        textName = new JTextField();
        textName.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textName.setBounds(144, 10, 411, 64);
        mainPanel.add(textName);
        textName.setColumns(10);
        
        textPhone = new JTextField();
        textPhone.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textPhone.setColumns(10);
        textPhone.setBounds(144, 84, 411, 64);
        mainPanel.add(textPhone);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textEmail.setColumns(10);
        textEmail.setBounds(144, 158, 411, 64);
        mainPanel.add(textEmail);
        
        buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        btnSave = new JButton("저장");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewContact();
            }
        });
        btnSave.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnSave);
        
        btnCancel = new JButton("취소");
        btnCancel.addActionListener((e) -> dispose());
        btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnCancel);
    }

    private void createNewContact() {
        // 1. JTextField에서 이름, 전화번호, 이메일을 읽음.
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        // 2. Contact 타입 객체 생성.
        Contact contact = new Contact(0, name, phone, email);
        
        // 3. 연락처 데이터 파일에 저장.
        dao.create(contact);
        
        // 4. ContactMain 윈도우에게 연락처 저장이 성공했음을 알려줌.
        app.notifyContactCreated();
        
        // 현재 창 닫기
        dispose();
    }
}
