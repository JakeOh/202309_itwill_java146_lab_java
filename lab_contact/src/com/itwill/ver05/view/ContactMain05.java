package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.ver05.controller.ContactDaoImpl;
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
        frame.setBounds(100, 100, 640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        
        btnCreate = new JButton("새 연락처");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactCreateFrame.showContactCreateFrame(frame, ContactMain05.this);
            }
        });
        btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnCreate);
        
        btnUpdate = new JButton("업데이트");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateContact();
            }
        });
        btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnUpdate);
        
        btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnDelete);
        
        btnSearch = new JButton("검색");
        btnSearch.addActionListener((e) ->
                    ContactSearchFrame.showContactSearchFrame(frame));
        btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnSearch);
        
        scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        // 테이블 컬럼 이름 폰트 설정
        table.getTableHeader().setFont(new Font("D2Coding", Font.BOLD, 28));
        // 데이터 행 폰트 설정
        table.setFont(new Font("D2Coding", Font.PLAIN, 28));
        // 테이블 행 높이(세로) 크기 설정
        table.setRowHeight(40);
        scrollPane.setViewportView(table);
    }
    
    private void updateContact() {
        // 테이블에서 선택된 행의 인덱스 찾음.
        int index = table.getSelectedRow();
        if (index == -1) { // 선택된 행이 없는 경우
            JOptionPane.showMessageDialog(
                    frame, 
                    "업데이트하려는 행을 먼저 선택하세요...", 
                    "경고", 
                    JOptionPane.WARNING_MESSAGE);
            
            return;
        }
        
        ContactUpdateFrame.showContactUpdateFrame(frame, index, ContactMain05.this);
    }
    
    public void notifyContactUpdated() {
        resetTableModel();
        JOptionPane.showMessageDialog(frame, "연락처 업데이트 성공!");
    }

    private void deleteContact() {
        // 테이블에서 선택된 행의 인덱스를 찾음.
        int index = table.getSelectedRow();
        if (index == -1) { // 선택된 행이 없는 경우
            JOptionPane.showMessageDialog(
                    frame, 
                    "삭제하려는 행을 먼저 선택하세요...", 
                    "경고", 
                    JOptionPane.WARNING_MESSAGE);
            
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(
                frame, 
                "정말 삭제할까요?", 
                "삭제 확인", 
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dao.delete(index); // 연락처 1개를 삭제하고, 파일에 저장.
//            resetTableModel();
            model.removeRow(index); // 선택된 행을 테이블 모델에서 삭제.
            
            JOptionPane.showMessageDialog(frame, "삭제 성공!");
        }
        
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
    
    /**
     * 새로운 연락처 저장이 성공했음을 알려주기 위한 메서드.
     * 메서드가 호출되면 JTable 내용을 갱신.
     */
    public void notifyContactCreated() {
        resetTableModel();
        JOptionPane.showMessageDialog(frame, "새 연락처 저장 성공!");
    }
    
    private void resetTableModel() {
        // 데이터가 없는 새로운 테이블 모델 객체를 생성
        model = new DefaultTableModel(null, COLUMN_NAMES);
        // 파일에 저장된 데이터를 다시 읽고 테이블 모델에 행들을 추가.
        loadContactData();
        // 새롭게 만들어진 테이블 모델을 테이블에 세팅
        table.setModel(model);
    }

}
