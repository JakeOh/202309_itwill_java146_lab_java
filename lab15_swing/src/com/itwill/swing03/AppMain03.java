package com.itwill.swing03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain03 {

    private JFrame frame;
    private JTextField textNumber1;
    private JTextField textNumber2;
    private JTextArea textResult;
    private JButton btnPlus;
    private JButton btnMinus;
    private JButton btnMultiply;
    private JButton btnDivide;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain03 window = new AppMain03();
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
    public AppMain03() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 520, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNumber1 = new JLabel("Number1");
        lblNumber1.setFont(new Font("D2Coding", Font.BOLD, 24));
        lblNumber1.setBounds(12, 10, 120, 60);
        frame.getContentPane().add(lblNumber1);
        
        JLabel lblNumber2 = new JLabel("Number2");
        lblNumber2.setFont(new Font("D2Coding", Font.BOLD, 24));
        lblNumber2.setBounds(12, 80, 120, 60);
        frame.getContentPane().add(lblNumber2);
        
        textNumber1 = new JTextField();
        textNumber1.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textNumber1.setBounds(144, 10, 320, 60);
        frame.getContentPane().add(textNumber1);
        textNumber1.setColumns(10);
        
        textNumber2 = new JTextField();
        textNumber2.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textNumber2.setColumns(10);
        textNumber2.setBounds(144, 80, 320, 60);
        frame.getContentPane().add(textNumber2);
        
        btnPlus = new JButton("+");
        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(e);
            }
        });
        btnPlus.setFont(new Font("D2Coding", Font.BOLD, 24));
        btnPlus.setBounds(12, 150, 60, 60);
        frame.getContentPane().add(btnPlus);
        
        btnMinus = new JButton("-");
        btnMinus.addActionListener(new ActionListener() { // 익명 클래스
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(e);
            }
        });
        btnMinus.setFont(new Font("D2Coding", Font.BOLD, 24));
        btnMinus.setBounds(84, 150, 60, 60);
        frame.getContentPane().add(btnMinus);
        
        btnMultiply = new JButton("x");
        btnMultiply.addActionListener((e) -> handleButtonClick(e)); // 람다 표현식
        btnMultiply.setFont(new Font("D2Coding", Font.BOLD, 24));
        btnMultiply.setBounds(154, 150, 60, 60);
        frame.getContentPane().add(btnMultiply);
        
        btnDivide = new JButton("/");
        btnDivide.addActionListener(this::handleButtonClick); // 람다 - 메서드 참조
        btnDivide.setFont(new Font("D2Coding", Font.BOLD, 24));
        btnDivide.setBounds(226, 150, 60, 60);
        frame.getContentPane().add(btnDivide);
        
        textResult = new JTextArea();
        textResult.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textResult.setBounds(12, 220, 452, 131);
        frame.getContentPane().add(textResult);
    }
    
    private void handleButtonClick(ActionEvent event) {
//        System.out.println(event.getSource());
        //-> 아규먼트 ActionEvent 객체에서 이벤트가 발생된 GUI 컴포넌트 정보를 알 수 있음.
        
        // JTextField에 입력된 문자열 -> 숫자 변환 -> 버튼 종류 - 사칙연산  -> JTextArea 출력
        double number1 = 0;
        double number2 = 0;
        try {
            number1 = Double.parseDouble(textNumber1.getText());
            number2 = Double.parseDouble(textNumber2.getText());
        } catch (NumberFormatException ex) {
            textResult.setText("number1 또는 number2는 숫자여야 합니다!");
            return; // 메서드 종료
        }
        
        double result = 0; // 사칙연산의 결과를 저장할 변수.
        String op = ""; // 사칙연산 연산자 문자열(+, -, x, /)을 저장할 변수.
        Object source = event.getSource(); // 이벤트가 발생한 객체(컴포넌트)
        if (source == btnPlus) {
            result = number1 + number2;
            op = "+";
        } else if (source == btnMinus) {
            result = number1 - number2;
            op = "-";
        } else if (source == btnMultiply) {
            result = number1 * number2;
            op = "x";
        } else if (source == btnDivide) {
            result = number1 / number2;
            op = "/";
        }
        
        String msg = String.format("%f %s %f = %f", 
                number1, op, number2, result);
        textResult.setText(msg);
    
        textNumber1.setText("");
        textNumber2.setText("");
    }
    
}
