package com.editreg.service;

import com.editreg.util.JExecResult;
import com.editreg.util.JQueryOptions;
import com.editreg.util.JRegistry;

import java.io.IOException;

public class SelectServiceImp implements SelectService{
    @Override
    public boolean isDataSelected(String filename) {
        JExecResult result = null;
        try {
            result = JRegistry.query(filename, new JQueryOptions().useF("JAVA_HOME"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result.isSuccess();
    }

    @Override
    public String getPathMessage(String filename) {
        JExecResult getMessage =null;
        try {
            getMessage = JRegistry.query(filename,new JQueryOptions().useF("\"Path\"").useE());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String[] myMessage = getMessage.getLines()[1].split("    ");
        String path = myMessage[3];
        StringBuilder sb = new StringBuilder();
        sb.append('"').append(path).append(";").append("%JAVA_HOME%\\bin");
        return sb.toString();
    }
}
