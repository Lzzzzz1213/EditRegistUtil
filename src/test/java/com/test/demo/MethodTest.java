package com.test.demo;

import com.editreg.util.*;
import com.editreg.config.PathConfig;
import com.editreg.jframe.SystemOS;
import com.editreg.service.SelectServiceImp;
import org.junit.Test;

import javax.swing.*;

public class MethodTest {


    PathConfig pathConfig = new PathConfig();
    @Test
    public void addTest() throws Exception{
        JExecResult deleteDemo1 = JRegistry.delete("HKEY_CURRENT_USER\\Test_2",new JDeleteOptions().useV("Path").useF());
        JRegistry.dump(deleteDemo1);
    }
    @Test
    public void selectTest() throws Exception {
        if (new SelectServiceImp().isDataSelected(pathConfig.getEnvironmentPath())) {
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
    @Test
    public void getPathMessageTest() throws Exception {
        System.out.println(new SelectServiceImp().getPathMessage(pathConfig.getEnvironmentPath()));
    }

    @Test
    public void SystemOsTest() throws Exception {
        JFrame f = new SystemOS();
        f.setSize(682, 293);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setTitle("作者：Lzzzzz1213 邮箱：498684205@qq.com");
        f.setVisible(true);
    }

    @Test
    public void ErrorValueTest(){
        ErrorUtil.setErrorMessage(ErrorValue.COPY_ERROR.toString());
        System.out.println(ErrorUtil.getMessage());
        ErrorUtil.setErrorMessage(ErrorValue.DELETE_ORIGIN_ERROR.toString());
        System.out.println(ErrorUtil.getMessage());
    }
}
