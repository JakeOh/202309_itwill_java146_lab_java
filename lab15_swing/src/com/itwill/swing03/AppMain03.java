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
        
        JButton btnPlus = new JButton("+");
        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(e);
            }
        });
        btnPlus.setFont(new Font("D2Coding", Font.BOLD, 24));
        btnPlus.setBounds(12, 150, 60, 60);
        frame.getContentPane().add(btnPlus);
        
        JButton btnMinus = new JButton("-");
        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(e);
            }
        });
        btnMinus.setFont(new Font("D2Coding", Font.BOLD, 24));
        btnMinus.setBounds(84, 150, 60, 60);
        frame.getContentPane().add(btnMinus);
        
        JButton btnMultiply = new JButton("x");
        btnMultiply.addActionListener((e) -> handleButtonClick(e));
        btnMultiply.setFont(new Font("D2Coding", Font.BOLD, 24));
        btnMultiply.setBounds(154, 150, 60, 60);
        frame.getContentPane().add(btnMultiply);
        
        JButton btnDivide = new JButton("/");
        btnDivide.addActionListener(this::handleButtonClick);
        btnDivide.setFont(new Font("D2Coding", Font.BOLD, 24));
        btnDivide.setBounds(226, 150, 60, 60);
        frame.getContentPane().add(btnDivide);
        
        textResult = new JTextArea();
        textResult.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textResult.setBounds(12, 220, 452, 131);
        frame.getContentPane().add(textResult);
    }
    
    private void handleButtonClick(ActionEvent e) {
        System.out.println(e.getSource());
    }
    
}
