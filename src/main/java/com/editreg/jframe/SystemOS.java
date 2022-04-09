package com.editreg.jframe;

import com.editreg.config.PathConfig;
import com.editreg.controller.EditRegController;
import com.editreg.util.ErrorUtil;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SystemOS extends JFrame implements ActionListener {
    EditRegController editRegController = new EditRegController();
    PathConfig pathConfig = new PathConfig();
    JPanel pnlMain;
    JTextField textField;
    JButton btnChoice;
    JButton btnRun;
    JButton btnCancel;
    JFileChooser jFileChooser = new JFileChooser();
    public SystemOS() {
        pnlMain = new JPanel();
        textField = new JTextField(50);
        btnChoice = new JButton("选择");
        btnChoice.addActionListener(this);
        btnRun = new JButton("运行");
        btnCancel = new JButton("取消");
        this.getContentPane().add(pnlMain);
        btnRun.addActionListener(e -> {
            //System.out.printf(textField.getText());
            String date = textField.getText();
           // System.out.println(date);
            pathConfig.setJAVA_HOME(date);
            boolean result = editRegController.editReg(pathConfig.getEnvironmentPath(),pathConfig.getTempPath(),pathConfig.getJAVA_HOME());
            //放置Control入口函数
            if (result) {
                JOptionPane.showMessageDialog(null, "配置环境变量成功，请使用cmd输入javac进行测试","成功",JOptionPane.INFORMATION_MESSAGE);
                btnRun.setEnabled(false);
            }else {
                JOptionPane.showMessageDialog(null, ErrorUtil.getMessage(),"失败",JOptionPane.ERROR_MESSAGE);
                btnRun.setEnabled(false);
            }

        });
        pnlMain.add(textField);
        pnlMain.add(btnChoice);
        pnlMain.add(btnRun);
        pnlMain.add(btnCancel);
        this.setSize(682, 293);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("作者：Lzzzzz1213 邮箱：498684205@qq.com");
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnChoice) {
            jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            jFileChooser.setDialogTitle("选择JDK目录");
            int intRetVal = jFileChooser.showOpenDialog(this);
            if(intRetVal == JFileChooser.APPROVE_OPTION){
                textField.setText(jFileChooser.getSelectedFile().getPath());
                btnRun.setEnabled(true);
            }
        }
    }
}
