package com.editreg.service;

import com.editreg.util.JCopyOptions;
import com.editreg.util.JExecResult;
import com.editreg.util.JRegistry;

import java.io.IOException;

public class CopyServiceImp implements CopyService{
    @Override
    public boolean copyReg(String origin, String temp) {
        JExecResult copyRegToTemper = null;
        try {
            copyRegToTemper = JRegistry.copy(origin,temp,new JCopyOptions().useS());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return copyRegToTemper.isSuccess();
    }

    @Override
    public boolean restoreReg(String temp, String origin) {
        JExecResult restoreRegToOrigin = null;
        try {
            restoreRegToOrigin = JRegistry.copy(temp, origin, new JCopyOptions().useS());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return restoreRegToOrigin.isSuccess();
    }
}
