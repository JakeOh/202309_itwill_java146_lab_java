package com.itwill.swing04;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain04 {
    // 이미지 파일의 경로를 저장하는 배열.
    private static final String[] IMAGES = {
            "images/flower1.jpg",
            "images/flower2.jpg",
            "images/flower3.jpg",
            "images/flower4.jpg",
            "images/flower5.jpg",
    };

    private int curIndex; // 현재 보여지는 이미지 파일의 인덱스.
    private JFrame frame;
    private JLabel lblImage;
    private JButton btnPrev;
    private JButton btnNext;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain04 window = new AppMain04();
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
    public AppMain04() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        lblImage = new JLabel(new ImageIcon(IMAGES[curIndex])); // "images/flower1.jpg"
        lblImage.setBounds(12, 10, 640, 640);
        frame.getContentPane().add(lblImage);
        
        btnPrev = new JButton("<");
        btnPrev.addActionListener((e) -> showPrevImage()); // 람다
        btnPrev.setFont(new Font("D2Coding", Font.BOLD, 24));
        btnPrev.setBounds(12, 660, 120, 64);
        frame.getContentPane().add(btnPrev);
        
        btnNext = new JButton(">");
        btnNext.addActionListener(new ActionListener() { // 익명 클래스
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });
        btnNext.setFont(new Font("D2Coding", Font.BOLD, 24));
        btnNext.setBounds(532, 660, 120, 64);
        frame.getContentPane().add(btnNext);
    }

    private void showPrevImage() {
        if (curIndex > 0) {
            curIndex--;
        } else {
            curIndex = IMAGES.length - 1;
        }
        
        lblImage.setIcon(new ImageIcon(IMAGES[curIndex])); // 레이블 이미지 아이콘 변경
    }

    private void showNextImage() {
        if (curIndex < IMAGES.length - 1) {
            curIndex++;
        } else {
            curIndex = 0;
        }
        
        // JLabel의 이미지 아이콘을 변경.
        lblImage.setIcon(new ImageIcon(IMAGES[curIndex]));
    }
}
