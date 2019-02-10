package com.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.daoType;
import com.model.BookType;
import com.util.DBConnection;
import com.util.StringUtil;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InquireFrame extends JInternalFrame {
    private JTextField textField;
    private JTable BookTypeTable;
    private JTextField idTxt;
    private JTextField bookTypeNameTxt;
    private JTextArea bookTypeDescTxt;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InquireFrame frame = new InquireFrame();
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
    public InquireFrame() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u56FE\u4E66\u7BA1\u7406");
        setBounds(100, 100, 759, 676);

        JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0:");
        lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));

        textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.BOLD, 18));
        textField.setColumns(10);

        JButton btnNewButton = new JButton("\u67E5\u8BE2");
        btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inquireActionPerformed(e);
            }
        });
        btnNewButton.setIcon(new ImageIcon(InquireFrame.class.getResource("/com/images/search.png")));

        JScrollPane scrollPane = new JScrollPane();

        JPanel panel = new JPanel();
        panel.setBorder(
                new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
                Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(107).addGroup(groupLayout
                        .createParallelGroup(Alignment.LEADING)
                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
                        .addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 143, Short.MAX_VALUE).addComponent(
                                        btnNewButton, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 523, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addGap(45)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addGap(58)
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                        .addGap(43).addComponent(panel, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(34, Short.MAX_VALUE)));

        JLabel label = new JLabel("\u7F16\u53F7:");
        label.setFont(new Font("微软雅黑", Font.BOLD, 18));

        idTxt = new JTextField();
        idTxt.setFont(new Font("微软雅黑", Font.BOLD, 18));
        idTxt.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0:");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 18));

        bookTypeNameTxt = new JTextField();
        bookTypeNameTxt.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("\u63CF\u8FF0:");
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 18));

        bookTypeDescTxt = new JTextArea();

        JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modifyActionPerformed(e);
            }
        });
        btnNewButton_1.setIcon(new ImageIcon(InquireFrame.class.getResource("/com/images/modify.png")));
        btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 17));

        JButton btnNewButton_2 = new JButton("\u5220\u9664");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteActionPerformed(e);
            }
        });
        btnNewButton_2.setIcon(new ImageIcon(InquireFrame.class.getResource("/com/images/delete.png")));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup().addContainerGap()
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
                                        .addGroup(gl_panel.createSequentialGroup().addComponent(label)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 56,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(74)
                                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 124,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 102,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
                                                .addComponent(lblNewLabel_2).addPreferredGap(ComponentPlacement.RELATED,
                                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_panel.createSequentialGroup().addGap(59)
                                                                .addComponent(btnNewButton_1).addGap(40)
                                                                .addComponent(btnNewButton_2))
                                                        .addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 368,
                                                                GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(96, Short.MAX_VALUE)));
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                                gl_panel.createSequentialGroup().addContainerGap()
                                        .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label)
                                                .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 30,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblNewLabel_1).addComponent(bookTypeNameTxt,
                                                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGap(18)
                                        .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(lblNewLabel_2).addComponent(bookTypeDescTxt,
                                                        GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18)
                                        .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(btnNewButton_2).addComponent(btnNewButton_1))
                                        .addContainerGap(49, Short.MAX_VALUE)));
        panel.setLayout(gl_panel);

        BookTypeTable = new JTable();
        BookTypeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                addMousePressed(e);
            }
        });
        BookTypeTable.setFont(new Font("微软雅黑", Font.BOLD, 18));
        BookTypeTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u7F16\u53F7",
                "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0" }));
        BookTypeTable.getColumnModel().getColumn(0).setPreferredWidth(96);
        BookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(121);
        BookTypeTable.getColumnModel().getColumn(2).setPreferredWidth(195);
        scrollPane.setViewportView(BookTypeTable);
        getContentPane().setLayout(groupLayout);
        this.fillTable(new BookType());
        bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 1, false));
    }

    /*
     * 删除表单
     */
    private void deleteActionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String id = this.idTxt.getText();
        if (new StringUtil().isEmpty(id)) {
            JOptionPane.showMessageDialog(null, "选择要删除的记录");
            return;
        }
        int n = JOptionPane.showConfirmDialog(null, "确定删除该记录吗?");
        if (n == 0) {
            Connection con = null;
            try {
                con = new DBConnection().getCon();
                int deleteNum = new daoType().delete(con, id);
                if (deleteNum == 1) {
                    JOptionPane.showMessageDialog(null, "删除成功!");
                    this.resetValue();
                    this.fillTable(new BookType());
                } else {
                    JOptionPane.showMessageDialog(null, "删除失败!");

                }

            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
                JOptionPane.showMessageDialog(null, "删除失败!");
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
     * 修改表单
     */
    private void modifyActionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String id = this.idTxt.getText();
        String bookTypeName = this.bookTypeNameTxt.getText();
        String bookTypeDesc = this.bookTypeDescTxt.getText();
        if (new StringUtil().isEmpty(id)) {
            JOptionPane.showMessageDialog(null, "选择要修改的记录");
            return;
        }
        if (new StringUtil().isEmpty(bookTypeName)) {
            JOptionPane.showMessageDialog(null, "图书类别不能为空!");
            return;
        }
        BookType booktype = new BookType(Integer.parseInt(id), bookTypeName, bookTypeDesc);
        Connection con = null;
        try {
            con = new DBConnection().getCon();
            int modifyNum = new daoType().update(con, booktype);
            if (modifyNum == 1) {
                JOptionPane.showMessageDialog(null, "修改成功!");
                this.resetValue();
                this.fillTable(new BookType());
            } else {
                JOptionPane.showMessageDialog(null, "修改失败");
            }
        } catch (Exception e2) {
            // TODO: handle exception
            e2.printStackTrace();
            JOptionPane.showMessageDialog(null, "修改失败!");
        } finally {
            try {
                new DBConnection().closeCon(con);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    private void addMousePressed(MouseEvent evt) {
        // TODO Auto-generated method stub
        int row = BookTypeTable.getSelectedRow();
        idTxt.setText((String) BookTypeTable.getValueAt(row, 0));
        bookTypeNameTxt.setText((String) BookTypeTable.getValueAt(row, 1));
        bookTypeDescTxt.setText((String) BookTypeTable.getValueAt(row, 2));

    }

    private void inquireActionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String s_textfield = this.textField.getText();
        BookType booktype = new BookType();
        booktype.setBookTypeName(s_textfield);
        this.fillTable(booktype);

    }
    /*
     * 将数据库中t_book中的内容填充到列表框中。
     */
    private void fillTable(BookType booktype) {
        DefaultTableModel dtm = (DefaultTableModel) BookTypeTable.getModel();
        dtm.setRowCount(0);// 将行设置成0
        Connection con = null;
        try {
            con = new DBConnection().getCon();
            ResultSet rs = new daoType().list(con, booktype);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("bookTypeName"));
                v.add(rs.getString("bookTypeDesc"));
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

    /*
     * 重置表单
     */
    private void resetValue() {
        this.idTxt.setText("");
        this.bookTypeNameTxt.setText("");
        this.bookTypeDescTxt.setText("");

    }
}
