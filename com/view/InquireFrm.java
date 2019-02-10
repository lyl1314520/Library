package com.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.dao.daoBook;
import com.dao.daoType;
import com.model.Book;
import com.model.BookType;
import com.util.DBConnection;
import com.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InquireFrm extends JInternalFrame {
    private JTextField bookNameTxt;
    private JTextField bookAuthorTxt;
    private JTextField idText;
    private JTextField bookTypeNameText;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField bookPriceText;
    private JTextField bookAuthorText;
    private JTable bookTable;
    private JComboBox bookTypeNameJcb;
    private JComboBox bookTypeNameJcb2;
    private JScrollPane bookTable1;
    private JRadioButton maleJrb;
    private JRadioButton femaleJrb;
    private JTextArea bookTypeDesc;

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
                    InquireFrm frame = new InquireFrm();
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
    public InquireFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u56FE\u4E66\u67E5\u8BE2");
        setBounds(100, 100, 896, 768);

        JPanel panel = new JPanel();

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(
                new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        bookTable1 = new JScrollPane();
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                .addGroup(groupLayout.createSequentialGroup().addGap(29).addComponent(panel_1, 0, 0,
                                        Short.MAX_VALUE))
                                .addGroup(groupLayout.createSequentialGroup().addGap(37).addComponent(panel,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(35, Short.MAX_VALUE))
                .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(48)
                        .addComponent(bookTable1, GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE).addGap(24)));
        groupLayout
                .setVerticalGroup(
                        groupLayout.createParallelGroup(Alignment.LEADING)
                                .addGroup(
                                        groupLayout.createSequentialGroup().addGap(35)
                                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 73,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(40)
                                                .addComponent(bookTable1, GroupLayout.PREFERRED_SIZE, 165,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(73)
                                                .addComponent(panel_1, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(53, Short.MAX_VALUE)));

        bookTable = new JTable();
        bookTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tableMousePressed(e);
            }
        });
        bookTable1.setViewportView(bookTable);
        bookTable.setModel(new DefaultTableModel(new Object[][] {},
                new String[] { "\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005",
                        "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0",
                        "\u56FE\u4E66\u7C7B\u522B" }) {
            boolean[] columnEditables = new boolean[] { false, false, true, false, false, false, false };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        bookTable.getColumnModel().getColumn(1).setPreferredWidth(95);
        bookTable.getColumnModel().getColumn(2).setPreferredWidth(86);
        bookTable.getColumnModel().getColumn(6).setPreferredWidth(91);

        JLabel lblNewLabel_3 = new JLabel("\u7F16\u53F7:");
        lblNewLabel_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        idText = new JTextField();
        idText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
        idText.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u540D\u79F0:");
        lblNewLabel_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        bookTypeNameText = new JTextField();
        bookTypeNameText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
        bookTypeNameText.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("\u4F5C\u8005\u6027\u522B");
        lblNewLabel_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        maleJrb = new JRadioButton("\u7537");
        buttonGroup.add(maleJrb);
        maleJrb.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        femaleJrb = new JRadioButton("\u5973");
        buttonGroup.add(femaleJrb);
        femaleJrb.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        JLabel lblNewLabel_6 = new JLabel("\u4EF7\u683C:");
        lblNewLabel_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        bookPriceText = new JTextField();
        bookPriceText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
        bookPriceText.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("\u56FE\u4E66\u4F5C\u8005:");
        lblNewLabel_7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        bookAuthorText = new JTextField();
        bookAuthorText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
        bookAuthorText.setColumns(10);

        JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0");
        label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        JLabel lblNewLabel_8 = new JLabel("\u56FE\u4E66\u63CF\u8FF0:");
        lblNewLabel_8.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        bookTypeDesc = new JTextArea();
        bookTypeDesc.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modifyActionPerformed(e);
            }
        });
        btnNewButton_1.setIcon(new ImageIcon(InquireFrm.class.getResource("/com/images/modify.png")));
        btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        JButton btnNewButton_2 = new JButton("\u5220\u9664");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteActionPerformed(e);
            }
        });
        btnNewButton_2.setIcon(new ImageIcon(InquireFrm.class.getResource("/com/images/delete.png")));
        btnNewButton_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        bookTypeNameJcb2 = new JComboBox();
        bookTypeNameJcb2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
                .createSequentialGroup().addContainerGap()
                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1.createSequentialGroup()
                        .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_3)
                                .addComponent(lblNewLabel_6))
                        .addGap(34)
                        .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
                                .addComponent(bookPriceText, 0, 0, Short.MAX_VALUE).addComponent(idText,
                                        GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
                                .addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNewLabel_4)
                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(bookTypeNameText,
                                                GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNewLabel_7)
                                        .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(bookAuthorText)))
                        .addGap(56)
                        .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNewLabel_5)
                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(maleJrb)
                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(femaleJrb))
                                .addGroup(gl_panel_1.createSequentialGroup()
                                        .addComponent(label, GroupLayout.PREFERRED_SIZE, 108,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.UNRELATED)
                                        .addComponent(bookTypeNameJcb2, GroupLayout.PREFERRED_SIZE, 97,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGap(211).addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 94,
                                                GroupLayout.PREFERRED_SIZE))))
                        .addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNewLabel_8)
                                .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(bookTypeDesc,
                                        GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel_1.createSequentialGroup().addComponent(btnNewButton_1).addGap(113)
                                .addComponent(btnNewButton_2)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
                .createSequentialGroup().addContainerGap()
                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                .addComponent(bookTypeNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(maleJrb).addComponent(femaleJrb).addComponent(lblNewLabel_5))
                        .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3)
                                .addComponent(lblNewLabel_4)
                                .addComponent(idText, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
                .addGap(25)
                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_6)
                        .addComponent(bookPriceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel_7)
                        .addComponent(bookAuthorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(label, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookTypeNameJcb2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                .addGap(18)
                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_8)
                        .addComponent(bookTypeDesc, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                .addGap(18).addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton_1)
                        .addComponent(btnNewButton_2))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        panel_1.setLayout(gl_panel_1);

        JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0:");
        lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        bookNameTxt = new JTextField();
        bookNameTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
        bookNameTxt.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005:");
        lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        bookAuthorTxt = new JTextField();
        bookAuthorTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
        bookAuthorTxt.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0:");
        lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        bookTypeNameJcb = new JComboBox();
        bookTypeNameJcb.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));

        JButton btnNewButton_3 = new JButton("\u67E5\u8BE2");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inquireActionPerformed(e);
            }
        });
        btnNewButton_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 19));
        btnNewButton_3.setIcon(new ImageIcon(InquireFrm.class.getResource("/com/images/search.png")));
        btnNewButton_3.setVerticalAlignment(SwingConstants.BOTTOM);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                                gl_panel.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 89,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGap(18).addComponent(lblNewLabel_1)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(bookAuthorTxt, GroupLayout.PREFERRED_SIZE, 95,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_2)
                                        .addPreferredGap(ComponentPlacement.UNRELATED)
                                        .addComponent(bookTypeNameJcb, GroupLayout.PREFERRED_SIZE, 108,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGap(32).addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 131,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(22, Short.MAX_VALUE)));
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup().addGap(28)
                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
                                        .addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 27,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(bookAuthorTxt, GroupLayout.PREFERRED_SIZE, 23,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(bookTypeNameJcb, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNewButton_3))
                                .addContainerGap(29, Short.MAX_VALUE)));
        panel.setLayout(gl_panel);
        getContentPane().setLayout(groupLayout);
        this.fillBookNameTable("search");
        this.fillBookNameTable2("modify");
        this.fillTable(new Book());
        bookTypeNameJcb.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 1, false));
    }

    private void modifyActionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String id = this.idText.getText();
        String bookName = this.bookTypeNameText.getText();
        String bookAuthor = this.bookAuthorText.getText();
        String bookPrice = this.bookPriceText.getText();
        String bookDesc = this.bookTypeDesc.getText();
        if (new StringUtil().isEmpty(id)) {
            JOptionPane.showMessageDialog(null, "Ñ¡ÔñÒªÐÞ¸ÄµÄ¼ÇÂ¼");
            return;
        }
        if (new StringUtil().isEmpty(bookName)) {
            JOptionPane.showMessageDialog(null, "Í¼ÊéÃû³Æ²»ÄÜÎª¿Õ!");
            return;
        }
        if (new StringUtil().isEmpty(bookAuthor)) {
            JOptionPane.showMessageDialog(null, "Í¼Êé×÷Õß²»ÄÜÎª¿Õ!");
            return;
        }
        if (new StringUtil().isEmpty(bookPrice)) {
            JOptionPane.showMessageDialog(null, "Í¼Êé¼Û¸ñ²»ÄÜÎª¿Õ!");
            return;
        }
        String sex = "";
        if (maleJrb.isSelected()) {
            sex = "ÄÐ";
        } else if (femaleJrb.isSelected()) {
            sex = "Å®";
        }
        BookType booktype = (BookType) this.bookTypeNameJcb2.getSelectedItem();
        int bookId = booktype.getId();
        Book book = new Book(Integer.parseInt(id),bookName, bookAuthor, Float.parseFloat(bookPrice), sex, bookId);
        Connection con = null;
        try {
            con = new DBConnection().getCon();
            int modifyNum = new daoBook().update(con, book);
            if (modifyNum == 1) {
                JOptionPane.showMessageDialog(null, "ÐÞ¸Ä³É¹¦!");
                this.resetValue();
                this.fillTable(new Book());
            } else {
                JOptionPane.showMessageDialog(null, "ÐÞ¸ÄÊ§°Ü");
            }
        } catch (Exception e2) {
            // TODO: handle exception
            e2.printStackTrace();
            JOptionPane.showMessageDialog(null, "ÐÞ¸ÄÊ§°Ü!");
        } finally {
            try {
                new DBConnection().closeCon(con);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    private void tableMousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        int row = this.bookTable.getSelectedRow();
        this.idText.setText((String) bookTable.getValueAt(row, 0));
        this.bookTypeNameText.setText((String) bookTable.getValueAt(row, 1));
        this.bookAuthorText.setText((String) bookTable.getValueAt(row, 2));
        String sex = (String) bookTable.getValueAt(row, 3);
        if ("ÄÐ".equals(sex)) {
            this.maleJrb.setSelected(true);
        } else if ("Å®".equals(sex)) {
            this.femaleJrb.setSelected(true);
        }

        this.bookPriceText.setText((Float) bookTable.getValueAt(row, 4) + "");
        this.bookTypeDesc.setText((String) bookTable.getValueAt(row, 5));
        String bookTypeName = (String) this.bookTable.getValueAt(row, 6);
        int n = this.bookTypeNameJcb2.getItemCount();

        for (int i = 0; i < n; i++) {
            BookType item = (BookType) this.bookTypeNameJcb2.getItemAt(i);
            if (item.getBookTypeName().equals(bookTypeName)) {
                this.bookTypeNameJcb2.setSelectedIndex(i);

            }
        }
    }

    private void deleteActionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String id = this.idText.getText();
        if (StringUtil.isEmpty(id)) {
            JOptionPane.showMessageDialog(null, "Ñ¡ÔñÒªÉ¾³ýµÄ¼ÇÂ¼");
            return;
        }
        int n = JOptionPane.showConfirmDialog(null, "È·¶¨É¾³ý¸Ã¼ÇÂ¼Âð?");
        if (n == 0) {
            Connection con = null;
            try {
                con = new DBConnection().getCon();
                int deleteNum = new daoBook().delete(con, id);
                if (deleteNum == 1) {
                    JOptionPane.showMessageDialog(null, "É¾³ý³É¹¦!");
                    this.fillTable(new Book());
                } else {
                    JOptionPane.showMessageDialog(null, "É¾³ýÊ§°Ü!");

                }

            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
                JOptionPane.showMessageDialog(null, "É¾³ýÊ§°Ü!");
            } finally {
                try {
                    new DBConnection().closeCon(con);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
    }

    /*
     * Í¼Êé²éÑ¯ÊÂ¼þ
     */
    private void inquireActionPerformed(ActionEvent e) {
        String bookName = this.bookNameTxt.getText();
        String bookAuthor = this.bookAuthorTxt.getText();
        BookType booktype = (BookType) this.bookTypeNameJcb.getSelectedItem();
        int bookId = booktype.getId();
        Book book = new Book(bookName, bookAuthor, bookId);
        this.fillTable(book);
    }

    /*
     * ³õÊ¼»¯ÏÂÃæµÄÏÂÀ­¿òÀàÐÍ
     */
    private void fillBookNameTable2(String type) {
        Connection con = null;
        BookType booktype = null;
        try {
            con = dbUtil.getCon();
            ResultSet rs = daotype.list(con, new BookType());
            if ("modify".equals(type)) {
                booktype = new BookType();
                booktype.setBookTypeName("ÇëÑ¡Ôñ...");
                booktype.setId(-1);
                this.bookTypeNameJcb2.addItem(booktype);
            }
            while (rs.next()) {
                booktype = new BookType();
                booktype.setBookTypeName(rs.getString("bookTypeName"));
                booktype.setId(rs.getInt("id"));
                if ("modify".equals(type)) {
                    this.bookTypeNameJcb2.addItem(booktype);
                } else if ("modify".equals(type)) {

                }
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

    /*
     * ³õÊ¼»¯ÏÂÀ­¿ò typeÎªÏÂÀ­¿òÀàÐÍ
     */
    private void fillBookNameTable(String type) {
        Connection con = null;
        BookType booktype = null;
        try {
            con = dbUtil.getCon();
            ResultSet rs = daotype.list(con, new BookType());
            if ("search".equals(type)) {
                booktype = new BookType();
                booktype.setBookTypeName("ÇëÑ¡Ôñ...");
                booktype.setId(-1);
                this.bookTypeNameJcb.addItem(booktype);
            }
            while (rs.next()) {
                booktype = new BookType();
                booktype.setBookTypeName(rs.getString("bookTypeName"));
                booktype.setId(rs.getInt("id"));
                if ("search".equals(type)) {
                    this.bookTypeNameJcb.addItem(booktype);
                } else if ("modify".equals(type)) {

                }
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

    private void fillTable(Book book) {
        DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
        dtm.setRowCount(0);// ½«ÐÐÉèÖÃ³É0
        Connection con = null;
        try {
            con = new DBConnection().getCon();
            ResultSet rs = daobook.list(con, book);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("bookName"));
                v.add(rs.getString("bookAuthor"));
                v.add(rs.getString("sex"));
                v.add(rs.getFloat("bookPrice"));
                v.add(rs.getString("bookTypeDesc"));
                v.add(rs.getString("bookTypeName"));
                dtm.addRow(v);

            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                new DBConnection().closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void resetValue() {

        this.bookTypeNameText.setText("");
        this.bookAuthorText.setText("");
        this.bookPriceText.setText("");
        this.maleJrb.setSelected(true);
        this.bookTypeDesc.setText("");
        if (this.bookTypeNameJcb2.getItemCount() > 0) {
            this.bookTypeNameJcb2.setSelectedIndex(0);
        }
    
    }
    
    
}
