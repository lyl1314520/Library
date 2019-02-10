package com.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.dao.daoBook;
import com.dao.daoType;
import com.model.Book;
import com.model.BookType;
import com.mysql.jdbc.Util;
import com.util.DBConnection;
import com.util.StringUtil;

public class AddBookFrame extends JInternalFrame {
    private JTextField bookNameTxt;
    private JTextField bookAuthorTxt;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTable table;
    private JTextField bookPriceTxt;
    private JComboBox bookTypeJcb;
    private JRadioButton MaleJrb;
    private JRadioButton FemaleJrb;
    private JTextArea bookDescTa;

    private DBConnection dbUtil = new DBConnection();
    private daoBook daobook = new daoBook();
    private daoType daotype = new daoType();
    private BookType booktype = new BookType();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddBookFrame frame = new AddBookFrame();
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
    public AddBookFrame() {
        setTitle("\u56FE\u4E66\u6DFB\u52A0");
        setIconifiable(true);
        setClosable(true);
        setBounds(100, 100, 683, 600);

        JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0:");
        lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        bookNameTxt = new JTextField();
        bookNameTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
        bookNameTxt.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005:");
        lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        bookAuthorTxt = new JTextField();
        bookAuthorTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 17));
        bookAuthorTxt.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
        lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        MaleJrb = new JRadioButton("\u7537");
        buttonGroup.add(MaleJrb);
        MaleJrb.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
        MaleJrb.setSelected(true);

        FemaleJrb = new JRadioButton("\u5973");
        buttonGroup.add(FemaleJrb);
        FemaleJrb.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        table = new JTable();

        JLabel lblNewLabel_3 = new JLabel("\u56FE\u4E66\u4EF7\u683C:");
        lblNewLabel_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        bookPriceTxt = new JTextField();
        bookPriceTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
        bookPriceTxt.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u7C7B\u522B:");
        lblNewLabel_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        bookTypeJcb = new JComboBox();
        bookTypeJcb.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        JLabel lblNewLabel_5 = new JLabel("\u56FE\u4E66\u63CF\u8FF0:");
        lblNewLabel_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        bookDescTa = new JTextArea();
        bookDescTa.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        JButton addButton = new JButton("\u6DFB\u52A0");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addActionPerformed(e);
            }
        });
        addButton.setIcon(new ImageIcon(AddBookFrame.class.getResource("/com/images/add.png")));
        addButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        JButton resetButton = new JButton("\u91CD\u7F6E");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetActionPerformed(e);
            }
        });
        resetButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
        resetButton.setIcon(new ImageIcon(AddBookFrame.class.getResource("/com/images/reset.png")));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout
                .setHorizontalGroup(
                        groupLayout.createParallelGroup(Alignment.LEADING)
                                .addGroup(groupLayout.createSequentialGroup().addGap(80).addGroup(groupLayout
                                        .createParallelGroup(
                                                Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
                                                .createParallelGroup(Alignment.LEADING)
                                                .addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel)
                                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(
                                                                bookNameTxt, GroupLayout.PREFERRED_SIZE, 124,
                                                                GroupLayout.PREFERRED_SIZE))
                                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                                                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                                                                .addComponent(lblNewLabel_4)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(bookTypeJcb, 0, GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))
                                                        .addGroup(Alignment.LEADING,
                                                                groupLayout.createSequentialGroup()
                                                                        .addComponent(lblNewLabel_2)
                                                                        .addPreferredGap(ComponentPlacement.RELATED)
                                                                        .addComponent(MaleJrb).addGap(18)
                                                                        .addComponent(FemaleJrb))))
                                                .addGap(33)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel_1)
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(table, GroupLayout.PREFERRED_SIZE, 1,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED,
                                                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(lblNewLabel_3)))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(bookPriceTxt, Alignment.TRAILING, 0, 0,
                                                                Short.MAX_VALUE)
                                                        .addComponent(bookAuthorTxt, Alignment.TRAILING,
                                                                GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
                                        .addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel_5)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(addButton, GroupLayout.PREFERRED_SIZE,
                                                                        102, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(66).addComponent(resetButton)
                                                                .addPreferredGap(ComponentPlacement.RELATED, 125,
                                                                        Short.MAX_VALUE))
                                                        .addComponent(bookDescTa, GroupLayout.DEFAULT_SIZE, 382,
                                                                Short.MAX_VALUE))))
                                        .addGap(122)));
        groupLayout
                .setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
                        .createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
                                groupLayout.createSequentialGroup().addGap(25).addComponent(lblNewLabel)).addGroup(
                                        groupLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 26,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bookAuthorTxt,
                                                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE))))
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
                                .createSequentialGroup().addGap(26)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2).addComponent(MaleJrb).addComponent(FemaleJrb)
                                        .addComponent(bookPriceTxt, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_3)))
                                .addGroup(groupLayout.createSequentialGroup().addGap(50).addComponent(table,
                                        GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
                        .addGap(34)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_4)
                                .addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(33)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_5)
                                .addComponent(bookDescTa, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
                        .addGap(47).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(addButton)
                                .addComponent(resetButton))
                        .addContainerGap(118, Short.MAX_VALUE)));
        getContentPane().setLayout(groupLayout);
        fillTable();

    }

    private void addActionPerformed(ActionEvent evt) {
        // TODO Auto-generated method stub
        String bookName = this.bookNameTxt.getText();
        String author = this.bookAuthorTxt.getText();
        String price = this.bookPriceTxt.getText();
        if (StringUtil.isEmpty(bookName)) {
            JOptionPane.showMessageDialog(null, "Í¼ÊéÃû³ÆÌí¼Ó²»ÄÜÎª¿Õ!");
            return;
        }
        if (StringUtil.isEmpty(author)) {
            JOptionPane.showMessageDialog(null, "Í¼Êé×÷ÕßÌí¼Ó²»ÄÜÎª¿Õ!");
            return;
        }
        if (StringUtil.isEmpty(price)) {
            JOptionPane.showMessageDialog(null, "Í¼Êé¼Û¸ñÌí¼Ó²»ÄÜÎª¿Õ!");
            return;
        }
        String sex = "";
        if (MaleJrb.isSelected()) {
            sex = "ÄÐ";
        } else if (FemaleJrb.isSelected()) {
            sex = "Å®";
        }
        BookType booktype = (BookType) bookTypeJcb.getSelectedItem();
        int bookid = booktype.getId();
        Book book = new Book(bookName, author, Float.parseFloat(price), sex,bookid);
        Connection con = null;
        try {
            con = dbUtil.getCon();
            int addNum = daobook.add(con, book);
            if (addNum == 1) {
                JOptionPane.showMessageDialog(null, "Í¼ÊéÌí¼Ó³É¹¦");
                resetValue();
            } else {
                JOptionPane.showMessageDialog(null, "Í¼ÊéÌí¼ÓÊ§°Ü");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                try {
                    dbUtil.closeCon(con);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
    }
  /*/
   * ÖØÖÃ±íµ¥
   */
    private void resetValue() {
        // TODO Auto-generated method stub
        this.bookNameTxt.setText("");
        this.bookAuthorTxt.setText("");
        this.bookPriceTxt.setText("");
        this.MaleJrb.setSelected(true);
        this.bookDescTa.setText("");
        if (this.bookTypeJcb.getItemCount() > 0) {
            this.bookTypeJcb.setSelectedIndex(0);
        }
    }

    private void resetActionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        this.resetValue();
    }

    /*
     * ³õÊ¼»¯ÏÂÀ­¿ò
     */
    private void fillTable() {
        Connection con = null;
        BookType booktype = null;
        try {
            con = dbUtil.getCon();
            ResultSet rs = daotype.list(con, new BookType());
            while (rs.next()) {
                booktype = new BookType();
                booktype.setId(rs.getInt("id"));
                booktype.setBookTypeName(rs.getString("BookTypeName"));
                this.bookTypeJcb.addItem(booktype);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
