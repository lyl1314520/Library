package com.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.dao.daoType;
import com.model.BookType;
import com.util.DBConnection;
import com.util.StringUtil;

public class AddBookType extends JFrame {

    private JPanel contentPane;
    private JTextField bookTypeNametxt;
    private JTextArea bookTypeDesctxt;
    private daoType daotype = new daoType();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddBookType frame = new AddBookType();
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
    public AddBookType() {
        setAlwaysOnTop(true);
        setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 775, 509);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("");

        JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0:");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 18));

        JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0:");
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 18));

        bookTypeNametxt = new JTextField();
        bookTypeNametxt.setFont(new Font("微软雅黑", Font.BOLD, 18));
        bookTypeNametxt.setColumns(10);

        bookTypeDesctxt = new JTextArea();
        bookTypeDesctxt.setFont(new Font("微软雅黑", Font.BOLD, 18));

        JButton btnNewButton = new JButton("\u6DFB\u52A0");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addActionPerformed(e);
            }
        });
        btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        btnNewButton.setIcon(new ImageIcon(AddBookType.class.getResource("/com/images/add.png")));

        JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetActionPerformed(e);
            }
        });
        btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        btnNewButton_1.setIcon(new ImageIcon(AddBookType.class.getResource("/com/images/reset.png")));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
                .createSequentialGroup()
                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup().addGap(75).addComponent(lblNewLabel))
                        .addGroup(gl_contentPane.createSequentialGroup().addGap(135).addGroup(gl_contentPane
                                .createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(btnNewButton))
                                .addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 94,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE))
                                        .addComponent(bookTypeNametxt).addComponent(bookTypeDesctxt, Alignment.LEADING,
                                                GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))))
                .addGap(238)));
        gl_contentPane
                .setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup().addGap(52).addComponent(lblNewLabel).addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE,
                                                70, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bookTypeNametxt, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2).addComponent(bookTypeDesctxt,
                                                GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton).addComponent(btnNewButton_1,
                                                GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                                .addGap(96)));
        contentPane.setLayout(gl_contentPane);
    }

    private void addActionPerformed(ActionEvent evt) {
        // TODO Auto-generated method stub
        String bookTypeName = this.bookTypeNametxt.getText();
        String bookTypeDesc = this.bookTypeDesctxt.getText();
        if (StringUtil.isEmpty(bookTypeName)) {
            JOptionPane.showMessageDialog(null, "图书类别添加不能为空!");
            return;
        }
        BookType booktype = new BookType(bookTypeName, bookTypeDesc);
        Connection con = null;
        // int result = daotype.add(con, booktype);
        try {
            con = new DBConnection().getCon();
            int result = daotype.add(con, booktype);
            if (result == 1) {
                JOptionPane.showMessageDialog(null, "图书类别添加成功!");
                resetActionPerformed(evt);
            } else {
                JOptionPane.showMessageDialog(null, "图书类别添加失败!");
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "图书类别添加失败!");

        } finally {
            try {
                new DBConnection().closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    // 重置表单
    private void resetActionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        this.bookTypeNametxt.setText("");
        this.bookTypeDesctxt.setText("");
    }
}
