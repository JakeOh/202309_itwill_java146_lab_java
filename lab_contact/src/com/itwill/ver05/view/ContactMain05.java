package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
        initialize();
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
        btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnCreate);
        
        btnUpdate = new JButton("업데이트");
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
        // TODO: 테이블 컬럼 이름 폰트 변경
        // TODO: 테이블 데이터 행의 폰트 변경
        scrollPane.setViewportView(table);
    }

}
