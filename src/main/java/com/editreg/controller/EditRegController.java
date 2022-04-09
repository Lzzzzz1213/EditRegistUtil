package com.editreg.controller;

import com.editreg.service.EditServiceImp;

public class EditRegController {
    public boolean editReg(String origin,String temp,String path){
        return new EditServiceImp().editRegex(origin, temp, path);
    }
}
