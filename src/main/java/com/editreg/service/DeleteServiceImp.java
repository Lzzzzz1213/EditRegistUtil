package com.editreg.service;

import com.editreg.util.JDeleteOptions;
import com.editreg.util.JExecResult;
import com.editreg.util.JRegistry;

import java.io.IOException;

public class DeleteServiceImp implements DeleteService{
    @Override
    public boolean deleteTempPath(String temp) {
        JExecResult deleteTempReg =null;
        try {
            deleteTempReg = JRegistry.delete(temp,new JDeleteOptions().useVA().useF());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return deleteTempReg.isSuccess();
    }
    @Override
    public boolean deleteOriginPath(String origin) {
        JExecResult deleteOriginReg =null;
        try {
            deleteOriginReg = JRegistry.delete(origin,new JDeleteOptions().useV("Path").useF());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return deleteOriginReg.isSuccess();
    }
}
