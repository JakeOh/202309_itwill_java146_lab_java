package com.itwill.jdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BlogMain {

    private JFrame frame;
    private JPanel searchPanel;
    private JScrollPane scrollPane;
    private JPanel buttonPanel;
    private JComboBox<String> comboBox;
    private JTextField textSearchKeyword;
    private JButton btnSearch;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogMain window = new BlogMain();
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
    public BlogMain() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 807, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        searchPanel = new JPanel();
        frame.getContentPane().add(searchPanel, BorderLayout.NORTH);
        
        comboBox = new JComboBox<>();
        comboBox.setFont(new Font("D2Coding", Font.PLAIN, 28));
        final String[] searchTypes = {"제목", "내용", "제목 + 내용", "작성자"};
        final DefaultComboBoxModel<String> comboBoxModel = 
                new DefaultComboBoxModel<>(searchTypes);
        comboBox.setModel(comboBoxModel);
        searchPanel.add(comboBox);
        
        textSearchKeyword = new JTextField();
        textSearchKeyword.setFont(new Font("D2Coding", Font.PLAIN, 28));
        searchPanel.add(textSearchKeyword);
        textSearchKeyword.setColumns(20);
        
        btnSearch = new JButton("검색");
        btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 28));
        searchPanel.add(btnSearch);
        
        scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

}
