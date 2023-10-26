package com.itwill.jdbc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.jdbc.model.Blog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlogMain {
    public static final String[] COLUMN_NAMES = {"번호", "제목", "작성자", "작성시간"};
    
    private JFrame frame;
    private JPanel searchPanel;
    private JScrollPane scrollPane;
    private JPanel buttonPanel;
    private JComboBox<String> comboBox;
    private JTextField textSearchKeyword;
    private JButton btnSearch;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnCreate;
    private JButton btnDetails;
    private JButton btnDelete;
    
    private BlogDao dao = BlogDao.getInstance();

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
        initialize(); // UI 컴포넌트들 초기화
        initTable(); // 테이블 데이터 초기화
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("블로그 메인");
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
        
//        table = new JTable();
        table = new JTable() { // 익명 클래스
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 테이블 셀 편집 불가
            }
        };
        
        table.getTableHeader().setFont(new Font("D2Coding", Font.PLAIN, 28));
        table.setFont(new Font("D2Coding", Font.PLAIN, 28));
        table.setRowHeight(40);
        
        tableModel = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(tableModel);
        scrollPane.setViewportView(table);
        
        buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        btnCreate = new JButton("새 포스트 작성");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BlogCreateFrame.showBlogCreateFrame(frame, BlogMain.this);
            }
        });
        btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnCreate);
        
        btnDetails = new JButton("상세보기");
        btnDetails.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnDetails);
        
        btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBlogPost();
            }
        });
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnDelete);
    }
    
    private void deleteBlogPost() {
        int row = table.getSelectedRow(); // 테이블에서 선택된 행 인덱스.
        if (row == -1) { // 선택된 행이 없는 경우
            JOptionPane.showMessageDialog(frame, 
                    "삭제하려는 행을 테이블에서 선택하세요.");
            
            return; // 메서드 종료
        }
        
        int confirm = JOptionPane.showConfirmDialog(
                frame, "정말 삭제할까요?", "삭제 확인", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // 선택된 행에서 번호(id)를 찾음.
            Integer id = (Integer) tableModel.getValueAt(row, 0);
            // DAO(컨트롤로)의 메서드를 사용해서 DB에서 행을 삭제.
            int result = dao.delete(id);
            if (result == 1) {
                // 삭제 성공하면 테이블 새로고침.
                initTable();
                JOptionPane.showMessageDialog(frame, "블로그 포스트 삭제 성공");
            }
        }
    }

    private void initTable() {
        List<Blog> blogs = dao.read(); // DB에서 BLOGS 테이블 전체 검색
        
        tableModel = new DefaultTableModel(null, COLUMN_NAMES); // 테이블모델 리셋(초기화)
        for (Blog b : blogs) { // DB에서 검색한 내용으로 테이블의 행들을 만듦.
            Object[] row = {
                    b.getId(),
                    b.getTitle(),
                    b.getAuthor(),
                    b.getCreatedTime()
            };
            tableModel.addRow(row);
        }
        table.setModel(tableModel); // 테이블에 모델을 다시 세팅.
        
    }
    
    public void notifyBlogCreated() {
        initTable();
        JOptionPane.showMessageDialog(frame, "새 포스트 등록 성공");
    }

}
