package com.itwill.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AppMain05 {

    private JFrame frame;
    private JRadioButton rbPrivate;
    private JRadioButton rbPackage;
    private JRadioButton rbProtected;
    private JRadioButton rbPublic;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JCheckBox cbAbstract;
    private JCheckBox cbFinal;
    private JCheckBox cbStatic;
    private JComboBox<String> comboBox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain05 window = new AppMain05();
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
    public AppMain05() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 744, 390);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        rbPrivate = new JRadioButton("private");
        rbPrivate.setSelected(true);
        buttonGroup.add(rbPrivate);
        rbPrivate.setFont(new Font("D2Coding", Font.PLAIN, 24));
        rbPrivate.setBounds(8, 6, 160, 60);
        frame.getContentPane().add(rbPrivate);
        
        rbPackage = new JRadioButton("package");
        buttonGroup.add(rbPackage);
        rbPackage.setFont(new Font("D2Coding", Font.PLAIN, 24));
        rbPackage.setBounds(172, 6, 160, 60);
        frame.getContentPane().add(rbPackage);
        
        rbProtected = new JRadioButton("protected");
        buttonGroup.add(rbProtected);
        rbProtected.setFont(new Font("D2Coding", Font.PLAIN, 24));
        rbProtected.setBounds(336, 6, 160, 60);
        frame.getContentPane().add(rbProtected);
        
        rbPublic = new JRadioButton("public");
        buttonGroup.add(rbPublic);
        rbPublic.setFont(new Font("D2Coding", Font.PLAIN, 24));
        rbPublic.setBounds(500, 6, 160, 60);
        frame.getContentPane().add(rbPublic);
        
        cbAbstract = new JCheckBox("abstract");
        cbAbstract.setFont(new Font("D2Coding", Font.PLAIN, 24));
        cbAbstract.setBounds(8, 68, 160, 60);
        frame.getContentPane().add(cbAbstract);
        
        cbFinal = new JCheckBox("final");
        cbFinal.setFont(new Font("D2Coding", Font.PLAIN, 24));
        cbFinal.setBounds(172, 68, 160, 60);
        frame.getContentPane().add(cbFinal);
        
        cbStatic = new JCheckBox("static");
        cbStatic.setFont(new Font("D2Coding", Font.PLAIN, 24));
        cbStatic.setBounds(336, 68, 160, 60);
        frame.getContentPane().add(cbStatic);
        
        comboBox = new JComboBox<>();
        comboBox.setFont(new Font("D2Coding", Font.PLAIN, 24));
        
        // 콤보박스에서 사용할 문자열(아이템)들의 배열:
        final String[] emails = {"naver.com", "gmail.com", "outlook.com", "kakao.com"};
        // 콤보박스모델 객체 생성:
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(emails);
        // 콤보박스에 모델을 설정 -> 콤보박스 아이템 설정:
        comboBox.setModel(model);
        
        comboBox.setBounds(8, 134, 324, 60);
        frame.getContentPane().add(comboBox);
    }
}
