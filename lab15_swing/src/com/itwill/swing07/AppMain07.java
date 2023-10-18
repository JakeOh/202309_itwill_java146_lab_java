package com.itwill.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AppMain07 {
    // 테이블 컬럼 이름 배열 상수
    public static final String[] COLUMN_NAMES = {"국어", "영어", "수학", "총점", "평균"};

    private JFrame frame;
    private JLabel lblKorean;
    private JLabel lblEnglish;
    private JLabel lblMath;
    private JTextField textKorean;
    private JTextField textEnglish;
    private JTextField textMath;
    private JButton btnSave;
    private JButton btnDelete;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel model; // 테이블 모델(컬럼이름, 데이터 관리)

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain07 window = new AppMain07();
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
    public AppMain07() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 530, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        lblKorean = new JLabel("국어");
        lblKorean.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblKorean.setBounds(12, 10, 120, 64);
        frame.getContentPane().add(lblKorean);
        
        lblEnglish = new JLabel("영어");
        lblEnglish.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblEnglish.setBounds(12, 84, 120, 64);
        frame.getContentPane().add(lblEnglish);
        
        lblMath = new JLabel("수학");
        lblMath.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblMath.setBounds(12, 158, 120, 64);
        frame.getContentPane().add(lblMath);
        
        textKorean = new JTextField();
        textKorean.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textKorean.setBounds(144, 10, 358, 64);
        frame.getContentPane().add(textKorean);
        textKorean.setColumns(10);
        
        textEnglish = new JTextField();
        textEnglish.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textEnglish.setColumns(10);
        textEnglish.setBounds(144, 84, 358, 64);
        frame.getContentPane().add(textEnglish);
        
        textMath = new JTextField();
        textMath.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textMath.setColumns(10);
        textMath.setBounds(144, 158, 358, 64);
        frame.getContentPane().add(textMath);
        
        btnSave = new JButton("입력");
        btnSave.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnSave.setBounds(12, 232, 160, 64);
        frame.getContentPane().add(btnSave);
        
        btnDelete = new JButton("삭제");
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnDelete.setBounds(184, 232, 160, 64);
        frame.getContentPane().add(btnDelete);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 306, 490, 185);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable(); // 테이블(JTable) 객체를 생성
        model = new DefaultTableModel(null, COLUMN_NAMES); // 테이블 모델 객체 생성
        table.setModel(model); // 테이블에 모델을 세팅.
        scrollPane.setViewportView(table);
    }
}
