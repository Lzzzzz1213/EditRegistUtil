package com.editreg.service;

public interface CopyService {
    boolean copyReg(String origin,String temp);
    boolean restoreReg(String temp,String origin);
}
