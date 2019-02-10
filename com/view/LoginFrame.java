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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.dao.daoUser;
import com.model.User;
import com.util.DBConnection;
import com.util.StringUtil;

/**
 * <p>
 * Title:登录界面 Description:
 * 
 * @author lyl
 * @date 2019年1月26日
 */
public class LoginFrame extends JFrame {

    private JPanel contentPane;
    private JTextField userName;
    private JTextField passWord;
    private DBConnection dbu = new DBConnection();
    private daoUser dao = new daoUser();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginFrame frame = new LoginFrame();
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
    public LoginFrame() {
        Font font = new Font("Dialog", Font.PLAIN, 12);
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource) {
                UIManager.put(key, font);
            }
        }
        setResizable(false);
        setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 653, 409);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
        lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 25));
        lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/images/logo.png")));

        JLabel lblNewLabel_1 = new JLabel("\u7528\u6237:");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 17));
        lblNewLabel_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/images/userName.png")));

        userName = new JTextField();
        userName.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801:");
        lblNewLabel_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/images/password.png")));
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 17));

        passWord = new JTextField();
        passWord.setColumns(10);

        JButton btnNewButton = new JButton("\u767B\u5F55");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginActionPerformed(e);
            }
        });
        // 添加登录事件处理

        btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 17));
        btnNewButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/images/login.png")));

        JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
        btnNewButton_1.addActionListener(new ActionListener() {
            // 重置用户名和密码
            public void actionPerformed(ActionEvent e) {
                resetActionPerformed(e);

            }
        });
        btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 17));
        btnNewButton_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/images/reset.png")));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
                Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
                        .createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
                                .createSequentialGroup().addGap(
                                        120)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel_1).addComponent(lblNewLabel_2))
                                .addGap(52)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 98,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                                .addComponent(btnNewButton_1))
                                        .addComponent(passWord)
                                        .addComponent(userName, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)))
                        .addGroup(gl_contentPane.createSequentialGroup().addGap(187).addComponent(lblNewLabel,
                                GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(195, Short.MAX_VALUE)));
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup().addGap(24)
                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                        .addGap(18)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                .addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE))
                        .addGap(34)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
                                .addComponent(passWord, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                        .addGap(55)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton_1)
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(72, Short.MAX_VALUE)));
        contentPane.setLayout(gl_contentPane);
        //使JFrame居中
        this.setLocationRelativeTo(null);
    }

    // 登录图书管理系统的界面设置
    protected void loginActionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String username = this.userName.getText();
        String password = new String((this.passWord.getText()));
        // System.out.println(username+"\n"+password);
        if (StringUtil.isEmpty(username)) {
            JOptionPane.showMessageDialog(null, "用户名不能为空");
            return;
        }

        if (StringUtil.isEmpty(password)) {
            JOptionPane.showMessageDialog(null, "密码不能为空");
            return;
        }
        User user = new User(username, password);
        Connection con = null;
        try {
            con = dbu.getCon();// 连接数据库
            User currerntUser = dao.login(con, user);
            //System.out.println(currerntUser.getUserName() + "\n\n" + currerntUser.getPassWord());
            if (currerntUser != null) {
                JOptionPane.showMessageDialog(null, "登录成功!");
                dispose();//释放本机屏幕资源
                new MainFrame().setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "用户名或密码错误!");
            }
        } catch (Exception e2) {
            // TODO: handle exception
            e2.printStackTrace();
        }
    }

    // 重置事件处理，判断用户名或者密码是否为空
    protected void resetActionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        this.userName.setText("");
        this.passWord.setText("");
    }
}
