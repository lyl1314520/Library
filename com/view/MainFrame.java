package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

    private JPanel table_1;
    private JDesktopPane table = new JDesktopPane();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainFrame() {
        Font font = new Font("Dialog", Font.PLAIN, 12);
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource) {
                UIManager.put(key, font);
            }
        }
        setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 633, 419);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
        mnNewMenu.setFont(new Font("华文宋体", Font.BOLD, 18));
        mnNewMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/com/images/base.png")));
        menuBar.add(mnNewMenu);

        JMenu mnNewMenu_2 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
        mnNewMenu_2.setFont(new Font("华文宋体", Font.BOLD, 18));
        mnNewMenu_2.setIcon(new ImageIcon(MainFrame.class.getResource("/com/images/bookTypeManager.png")));
        mnNewMenu.add(mnNewMenu_2);

        JMenuItem mntmNewMenuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                AddBookType addBook = new AddBookType();
                addBook.setVisible(true);
                // table.add(addBook);
            }
        });
        mntmNewMenuItem.setFont(new Font("华文宋体", Font.BOLD, 18));
        mntmNewMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/com/images/add.png")));
        mnNewMenu_2.add(mntmNewMenuItem);

        JMenuItem menuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                InquireFrame infm = new InquireFrame();
                infm.setVisible(true);
                table.add(infm);
            }
        });
        menuItem.setFont(new Font("华文宋体", Font.BOLD, 18));
        menuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/com/images/bookManager.png")));
        mnNewMenu_2.add(menuItem);

        JMenu mnNewMenu_3 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
        mnNewMenu_3.setFont(new Font("华文宋体", Font.BOLD, 18));
        mnNewMenu_3.setIcon(new ImageIcon(MainFrame.class.getResource("/com/images/bookManager.png")));
        mnNewMenu.add(mnNewMenu_3);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                   AddBookFrame addBF = new AddBookFrame();
                   addBF.setVisible(true);
                   table.add(addBF);
            }
        });
        mntmNewMenuItem_1.setFont(new Font("华文宋体", Font.BOLD, 18));
        mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/com/images/add.png")));
        mnNewMenu_3.add(mntmNewMenuItem_1);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 InquireFrm inquire = new InquireFrm();
                 inquire.setVisible(true);
                 table.add(inquire);
                 
            }
        });
        mntmNewMenuItem_2.setFont(new Font("华文宋体", Font.BOLD, 18));
        mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrame.class.getResource("/com/images/bookManager.png")));
        mnNewMenu_3.add(mntmNewMenuItem_2);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
                // System.out.println(result);
                if (result == 0) {
                    dispose();
                }
            }
        });
        mntmNewMenuItem_3.setFont(new Font("华文宋体", Font.BOLD, 18));
        mntmNewMenuItem_3.setIcon(new ImageIcon(MainFrame.class.getResource("/com/images/edit.png")));
        mnNewMenu.add(mntmNewMenuItem_3);

        JMenu mnNewMenu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
        mnNewMenu_1.setFont(new Font("华文宋体", Font.BOLD, 18));
        mnNewMenu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/com/images/about.png")));
        menuBar.add(mnNewMenu_1);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u5173\u4E8Ejava1234");
        mntmNewMenuItem_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JAVA1234 java1234 = new JAVA1234();
                java1234.setVisible(true);
                table.add(java1234);
            }
        });
        mntmNewMenuItem_4.setIcon(new ImageIcon(MainFrame.class.getResource("/com/images/about.png")));
        mntmNewMenuItem_4.setFont(new Font("华文宋体", Font.BOLD, 20));
        mnNewMenu_1.add(mntmNewMenuItem_4);
        table_1 = new JPanel();
        table_1.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(table_1);
        table_1.setLayout(new BorderLayout(0, 0));
        table.setBackground(Color.WHITE);

        table = new JDesktopPane();
        table_1.add(table, BorderLayout.CENTER);     
        this.setLocationRelativeTo(null);
        // 窗口最大化
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
