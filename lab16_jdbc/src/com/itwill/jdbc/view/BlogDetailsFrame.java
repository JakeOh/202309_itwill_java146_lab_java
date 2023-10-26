package com.itwill.jdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BlogDetailsFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblId;
    private JTextField textId;
    private JTextField textTitle;
    private JLabel lblContent;
    private JScrollPane scrollPane;
    private JTextArea textContent;

    /**
     * Launch the application.
     */
    public static void showBlogDetailsFrame() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogDetailsFrame frame = new BlogDetailsFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 생성자
    public BlogDetailsFrame() {
        // TODO:
        
        // UI 컴포넌트들 초기화.
        initialize();
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("포스트 상세보기");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 605, 630);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblId = new JLabel("번호");
        lblId.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblId.setBounds(12, 10, 120, 64);
        contentPane.add(lblId);
        
        textId = new JTextField();
        textId.setEditable(false);
        textId.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textId.setBounds(144, 10, 433, 64);
        contentPane.add(textId);
        textId.setColumns(10);
        
        JLabel lblTitle = new JLabel("제목");
        lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblTitle.setBounds(12, 84, 120, 64);
        contentPane.add(lblTitle);
        
        textTitle = new JTextField();
        textTitle.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textTitle.setColumns(10);
        textTitle.setBounds(144, 84, 433, 64);
        contentPane.add(textTitle);
        
        lblContent = new JLabel("내용");
        lblContent.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblContent.setBounds(12, 158, 120, 64);
        contentPane.add(lblContent);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 232, 565, 167);
        contentPane.add(scrollPane);
        
        textContent = new JTextArea();
        textContent.setFont(new Font("D2Coding", Font.PLAIN, 28));
        scrollPane.setViewportView(textContent);
    }

}
