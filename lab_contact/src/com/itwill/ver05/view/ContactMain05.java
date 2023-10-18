package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.ver04.controller.ContactDaoImpl;
import com.itwill.ver04.model.Contact;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactMain05 {
    public static final String[] COLUMN_NAMES = {"이름", "전화번호"};

    private JFrame frame;
    private JPanel buttonPanel;
    private JButton btnCreate;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnSearch;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel model;
    
    // Controller
    private ContactDaoImpl dao = ContactDaoImpl.getInstance();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactMain05 window = new ContactMain05();
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
    public ContactMain05() {
        initialize(); // Swing 컴포넌트들을 생성, 초기화
        loadContactData(); // 파일에 저장된 연락처 데이터 로딩(JTable 초기화)
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("연락처 프로그램 v0.5");
        frame.setBounds(100, 100, 683, 451);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        
        btnCreate = new JButton("새 연락처");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactCreateFrame.showContactCreateFrame(frame);
            }
        });
        btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnCreate);
        
        btnUpdate = new JButton("업데이트");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactUpdateFrame.showContactUpdateFrame(frame);
            }
        });
        btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnUpdate);
        
        btnDelete = new JButton("삭제");
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnDelete);
        
        btnSearch = new JButton("검색");
        btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnSearch);
        
        scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        // 테이블 컬럼 이름 폰트 변경
        table.getTableHeader().setFont(new Font("D2Coding", Font.BOLD, 28));
        // 데이터 행 폰트 변경
        table.setFont(new Font("D2Coding", Font.PLAIN, 28));
        scrollPane.setViewportView(table);
    }
    
    /*
     * 연락처 데이터 로딩, 테이블 초기화
     */
    private void loadContactData() {
        List<Contact> list = dao.read(); // 파일에서 데이터 읽어옴.
        for (Contact c : list) {
            Object[] row = { c.getName(), c.getPhone() };
            model.addRow(row);
        }
    }

}
