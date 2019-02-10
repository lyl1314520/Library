package com.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class JAVA1234 extends JInternalFrame {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JAVA1234 frame = new JAVA1234();
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
    public JAVA1234() {
        setFrameIcon(new ImageIcon(JAVA1234.class.getResource("/com/images/java1234.png")));
        setBackground(Color.RED);
        setTitle("\u5173\u4E8EJAVA1234");
        setClosable(true);
        setIconifiable(true);
        setBounds(100, 100, 600, 495);
        
        JLabel label = new JLabel("");
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(JAVA1234.class.getResource("/com/images/java1234.png")));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(117)
                    .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(label)
                    .addContainerGap(84, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(167)
                            .addComponent(label))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(72)
                            .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(169, Short.MAX_VALUE))
        );
        getContentPane().setLayout(groupLayout);

    }

}
