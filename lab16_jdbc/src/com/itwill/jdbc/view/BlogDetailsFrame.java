package com.itwill.jdbc.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.jdbc.model.Blog;

public class BlogDetailsFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblId;
    private JTextField textId;
    private JTextField textTitle;
    private JLabel lblContent;
    private JScrollPane scrollPane;
    private JTextArea textContent;
    private JTextField textAuthor;
    private JLabel lblAuthor;
    private JTextField textCreated;
    private JLabel lblCreated;
    private JTextField textModified;
    private JLabel lblModified;
    private JButton btnUpdate;
    private JButton btnClose;

    private BlogDao dao;
    private Component parent;
    private Integer id;
    
    /**
     * Launch the application.
     */
    public static void showBlogDetailsFrame(Component parent, Integer id) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogDetailsFrame frame = new BlogDetailsFrame(parent, id);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 생성자
    public BlogDetailsFrame(Component parent, Integer id) {
        // 필드 초기화
        this.dao = BlogDao.getInstance();
        this.parent = parent;
        this.id = id;
        
        // UI 컴포넌트들 초기화.
        initialize();
        
        // UI 컴포넌트의 입력 값들을 초기화.
        initBlogDetails();
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("포스트 상세보기");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = 100;
        int y = 100;
        if (parent != null) {
            x = parent.getX() + parent.getWidth();
            y = parent.getY();
        }
        setBounds(x, y, 605, 780);
        
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
        
        lblAuthor = new JLabel("작성자");
        lblAuthor.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblAuthor.setBounds(12, 409, 120, 64);
        contentPane.add(lblAuthor);
        
        textAuthor = new JTextField();
        textAuthor.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textAuthor.setEditable(false);
        textAuthor.setColumns(10);
        textAuthor.setBounds(144, 409, 433, 64);
        contentPane.add(textAuthor);
        
        lblCreated = new JLabel("작성시간");
        lblCreated.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblCreated.setBounds(12, 483, 120, 64);
        contentPane.add(lblCreated);
        
        textCreated = new JTextField();
        textCreated.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textCreated.setEditable(false);
        textCreated.setColumns(10);
        textCreated.setBounds(144, 483, 433, 64);
        contentPane.add(textCreated);
        
        lblModified = new JLabel("수정시간");
        lblModified.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblModified.setBounds(12, 557, 120, 64);
        contentPane.add(lblModified);
        
        textModified = new JTextField();
        textModified.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textModified.setEditable(false);
        textModified.setColumns(10);
        textModified.setBounds(144, 557, 433, 64);
        contentPane.add(textModified);
        
        btnUpdate = new JButton("업데이트");
        btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnUpdate.setBounds(12, 631, 216, 64);
        contentPane.add(btnUpdate);
        
        btnClose = new JButton("닫기");
        btnClose.addActionListener((e) -> dispose());
        btnClose.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnClose.setBounds(361, 631, 216, 64);
        contentPane.add(btnClose);
    }
    
    private void initBlogDetails() {
        // DAO(컨트롤러) 메서드를 사용해서 DB에서 검색하고, 그 결과를 보여줌.
        Blog blog = dao.read(id);
        if (blog != null) {
            textId.setText(blog.getId().toString());
            textTitle.setText(blog.getTitle());
            textContent.setText(blog.getContent());
            textAuthor.setText(blog.getAuthor());
            textCreated.setText(blog.getCreatedTime().toString());
            textModified.setText(blog.getModifiedTime().toString());
        }
    }

}
