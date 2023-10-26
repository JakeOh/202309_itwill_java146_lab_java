package com.itwill.jdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.jdbc.model.Blog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlogCreateFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblTitle;
    private JTextField textTitle;
    private JLabel lblContent;
    private JScrollPane scrollPane;
    private JTextArea textContent;
    private JLabel lblAuthor;
    private JTextField textAuthor;
    private JButton btnSave;

    private BlogDao dao;
    private Component parent;
    private BlogMain app;
    
    /**
     * Launch the application.
     */
    public static void showBlogCreateFrame(Component parent, BlogMain app) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogCreateFrame frame = new BlogCreateFrame(parent, app);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 생성자
    public BlogCreateFrame(Component parent, BlogMain app) {
        // 필드 초기화.
        this.dao = BlogDao.getInstance();
        this.parent = parent;
        this.app = app;
        
        // UI 컴포넌트들 초기화.
        initialize();
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("새 포스트 작성");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 현재 창만 닫기
        
        int x = 100;
        int y = 100;
        if (parent != null) {
            x = parent.getX() + parent.getWidth();
            y = parent.getY();
        }
        setBounds(x, y, 480, 800);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblTitle = new JLabel("제목");
        lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblTitle.setBounds(12, 10, 417, 64);
        contentPane.add(lblTitle);
        
        textTitle = new JTextField();
        textTitle.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textTitle.setBounds(12, 84, 417, 64);
        contentPane.add(textTitle);
        textTitle.setColumns(10);
        
        lblContent = new JLabel("내용");
        lblContent.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblContent.setBounds(12, 158, 417, 64);
        contentPane.add(lblContent);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 232, 417, 200);
        contentPane.add(scrollPane);
        
        textContent = new JTextArea();
        textContent.setFont(new Font("D2Coding", Font.PLAIN, 28));
        scrollPane.setViewportView(textContent);
        
        lblAuthor = new JLabel("작성자");
        lblAuthor.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblAuthor.setBounds(12, 442, 417, 64);
        contentPane.add(lblAuthor);
        
        textAuthor = new JTextField();
        textAuthor.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textAuthor.setColumns(10);
        textAuthor.setBounds(12, 514, 417, 64);
        contentPane.add(textAuthor);
        
        btnSave = new JButton("저장");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewBlogPost();
            }
        });
        btnSave.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnSave.setBounds(12, 588, 178, 64);
        contentPane.add(btnSave);
        
        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener((e) -> dispose());
        btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnCancel.setBounds(251, 588, 178, 64);
        contentPane.add(btnCancel);
    }

    private void createNewBlogPost() {
        // 제목, 내용, 작성자에 입력된 내용을 읽고, Blog 객체를 생성해서, 
        // DAO 메서드(create)를 사용해서 DB에 삽입(insert).
        
        String title = textTitle.getText();
        String content = textContent.getText();
        String author = textAuthor.getText();
        if (title.equals("") || content.equals("") || author.equals("")) {
            JOptionPane.showMessageDialog(BlogCreateFrame.this, 
                    "제목, 내용, 작성자는 반드시 입력되어야 합니다.");
            
            return;
        }
        
        Blog blog = new Blog(null, title, content, author, null, null);
        int result = dao.create(blog);
        // DB insert 성공하면 메인 프레임에게 알려줌 -> 메인 프레임에서 테이블을 새로고침.
        if (result == 1) {
            dispose(); // 현재 창 닫기
            app.notifyBlogCreated(); // 메인 프레임에게 알려줌.
        }
    }
    
}
