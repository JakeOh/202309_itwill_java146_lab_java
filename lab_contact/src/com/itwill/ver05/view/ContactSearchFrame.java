package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itwill.ver04.model.Contact;
import com.itwill.ver05.controller.ContactDaoImpl;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JTextField;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;

public class ContactSearchFrame extends JFrame {
    public static final String[] COLUMN_NAMES = {"이름", "전화번호", "이메일"}; 
    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JPanel headerPanel;
    private JTextField textField;
    private JButton btnSearch;
    private JScrollPane resultPanel;
    private JTable table;
    private DefaultTableModel model;
    
    private Component parent;
    private ContactDaoImpl dao = ContactDaoImpl.getInstance();

    /**
     * Launch the application.
     */
    public static void showContactSearchFrame(Component parent) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactSearchFrame frame = new ContactSearchFrame(parent);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ContactSearchFrame(Component parent) {
        this.parent = parent;
        
        initialize();
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("연락처 검색");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = 100;
        int y = 100;
        if (parent != null) {
            x = parent.getX() + parent.getWidth();
            y = parent.getY();
        }
        setBounds(x, y, 720, 480);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        headerPanel = new JPanel();
        contentPane.add(headerPanel, BorderLayout.NORTH);
        
        textField = new JTextField();
        textField.setFont(new Font("D2Coding", Font.PLAIN, 28));
        headerPanel.add(textField);
        textField.setColumns(20);
        
        btnSearch = new JButton("검색");
        btnSearch.addActionListener((e) -> searchContact());
        btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 28));
        headerPanel.add(btnSearch);
        
        resultPanel = new JScrollPane();
        contentPane.add(resultPanel, BorderLayout.CENTER);
        
        table = new JTable();
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        table.getTableHeader().setFont(new Font("D2Coding", Font.BOLD, 28));
        table.setFont(new Font("D2Coding", Font.PLAIN, 28));
        table.setRowHeight(40);
        resultPanel.setViewportView(table);
    }
    
    private void searchContact() {
        String keyword = textField.getText();
        if (keyword == null || keyword.equals("")) {
            JOptionPane.showMessageDialog(
                    this, 
                    "검색어를 입력하세요...", 
                    "경고", 
                    JOptionPane.WARNING_MESSAGE);
            textField.requestFocus();
            
            return;
        }
        
        List<Contact> result = dao.search(keyword);
        resetTableModel(result);
    }
    
    private void resetTableModel(List<Contact> result) {
        model = new DefaultTableModel(null, COLUMN_NAMES);
        for (Contact contact : result) {
            Object[] row = { 
                    contact.getName(),
                    contact.getPhone(),
                    contact.getEmail(),
            };
            model.addRow(row);
        }
        table.setModel(model);
    }

}
