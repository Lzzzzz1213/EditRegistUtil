package com.editreg.service;

import com.editreg.util.JAddOptions;
import com.editreg.util.JExecResult;
import com.editreg.util.JRegistry;
import java.io.IOException;

public class AddServiceImp implements AddService {
    @Override
    public boolean addJAVA_HOME(String origin,String date) {
        JExecResult addJAVA_HOMEResult = null;
        try {
            addJAVA_HOMEResult = JRegistry.add(origin,new JAddOptions().useV("JAVA_HOME").useD(date));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert addJAVA_HOMEResult != null;
        return addJAVA_HOMEResult.isSuccess();
    }
    @Override
    public boolean addPath(String origin,String newPath){
        JExecResult addPathResult =null;
        try {
            addPathResult = JRegistry.add(origin,new JAddOptions().useV("Path").useD(newPath));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return addPathResult.isSuccess();
    }
}
