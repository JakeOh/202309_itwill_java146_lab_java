package com.itwill.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertScoreToTable();
            }
        });
        btnSave.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnSave.setBounds(12, 232, 160, 64);
        frame.getContentPane().add(btnSave);
        
        btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteScoreFromTable();
            }
        });
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

    private void deleteScoreFromTable() {
        // 1. 테이블에서 삭제하기 위해 선택된 행의 인덱스를 찾음.
        int index = table.getSelectedRow();
        if (index == -1) { // 테이블에서 어떤 행도 선택되지 않은 경우.
            JOptionPane.showMessageDialog(
                    frame, // 부모 컴포넌트
                    "테이블에서 삭제할 행을 먼저 선택하세요...", // 메시지
                    "경고", // 타이틀
                    JOptionPane.WARNING_MESSAGE); // 메시지 타입
            
            return; // 메서드 종료.
        }
        
        // 2. 테이블 모델에서 행을 삭제.
        int confirm = JOptionPane.showConfirmDialog(
                frame, // 부모 컴포넌트
                "정말 삭제할까요?", // 메시지
                "삭제 확인", // 타이틀
                JOptionPane.YES_NO_OPTION); // 옵션 타입(확인 버튼 개수)
        if (confirm == JOptionPane.YES_OPTION) {
            model.removeRow(index); // 테이블 모델에서 해당 인덱스의 행을 삭제.
        }
        
    }

    private void insertScoreToTable() {
        // 1. JTextField에서 3과목의 점수를 읽음.
        int korean = 0;
        int english = 0;
        int math = 0;
        try {
            korean = Integer.parseInt(textKorean.getText());
            english = Integer.parseInt(textEnglish.getText());
            math = Integer.parseInt(textMath.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    frame, // 부모 컴포넌트
                    "국어, 영어, 수학 점수는 반드시 정수로 입력하세요...", // 메시지
                    "입력 오류", // 타이틀
                    JOptionPane.ERROR_MESSAGE); // 메시지 타입
            
            return; // 메서드 종료.
        }
        
        // 2. Score 객체를 만듦.
        Score score = new Score(korean, english, math);
        
        // 3. JTable에 행(row)을 추가.
        // 테이블 행에 추가할 데이터
        Object[] row = {
                score.getKorean(),
                score.getEnglish(),
                score.getMath(),
                score.getTotal(),
                score.getMean(),
        };
        // 데이터를 테이블 행에 추가
        model.addRow(row);
        
        // 4. JTextField의 입력 내용을 모두 지움.
        clearAllTextField();
    }
    
    private void clearAllTextField() {
        textKorean.setText("");
        textEnglish.setText("");
        textMath.setText("");
    }
}
