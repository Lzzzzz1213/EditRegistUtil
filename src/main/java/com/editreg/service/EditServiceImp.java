package com.editreg.service;

import com.editreg.util.ErrorUtil;
import com.editreg.util.ErrorValue;

public class EditServiceImp implements EditService {
    private boolean findResult = false;
    private boolean copyOriginResult = false;
    private boolean restoreTempResult = false;
    private boolean deleteTempResult = false;
    private boolean deleteOriginResult = false;
    private boolean addOriginResult = false;
    private boolean editOriginResult = false;
    private boolean addTempJAVA_HOMEResult = false;
    private boolean addTempPathResult = false;
    private boolean endResult = false;
    private String newPath = "";
    @Override
    public boolean editRegex(String origin, String temp, String path) {
        this.findResult = new SelectServiceImp().isDataSelected(origin);
        if (!findResult) {
            this.copyOriginResult = new CopyServiceImp().copyReg(origin, temp);
            if (copyOriginResult) {
                newPath = new SelectServiceImp().getPathMessage(temp);
                if (newPath != null) {
                    this.deleteTempResult = new DeleteServiceImp().deleteTempPath(temp);
                    if (deleteTempResult) {
                        this.addTempJAVA_HOMEResult = new AddServiceImp().addJAVA_HOME(temp, path);
                        if (addTempJAVA_HOMEResult) {
                            this.addTempPathResult = new AddServiceImp().addPath(temp, newPath);
                            if (addTempPathResult) {
                                this.deleteOriginResult = new DeleteServiceImp().deleteOriginPath(origin);
                                if (deleteOriginResult) {
                                    this.restoreTempResult = new CopyServiceImp().restoreReg(temp, origin);
                                    if (restoreTempResult) {
                                        this.addOriginResult = true;
                                        this.editOriginResult = true;
                                        this.deleteTempResult = new DeleteServiceImp().deleteTempPath(temp);
                                        if (deleteTempResult) {
                                            this.endResult = true;
                                        }else {
                                            ErrorUtil.setErrorMessage(ErrorValue.DELETE_TEMP_ERROR.toString());
                                        }
                                    }else {
                                        ErrorUtil.setErrorMessage(ErrorValue.RESTORE_ERROR.toString());
                                    }
                                }else {
                                    ErrorUtil.setErrorMessage(ErrorValue.DELETE_ORIGIN_ERROR.toString());
                                }
                            }else {
                                ErrorUtil.setErrorMessage(ErrorValue.ADD_PATH_ERROR.toString());
                            }
                        }else {
                            ErrorUtil.setErrorMessage(ErrorValue.ADD_JAVA_HOME_ERROR.toString());
                        }
                    }else {
                        ErrorUtil.setErrorMessage(ErrorValue.DELETE_TEMP_ERROR.toString());
                    }
                }else {
                    ErrorUtil.setErrorMessage(ErrorValue.PATH_ERROR.toString());
                }
            }else {
                ErrorUtil.setErrorMessage(ErrorValue.COPY_ERROR.toString());
            }
        }else{
            ErrorUtil.setErrorMessage(ErrorValue.SELECT_ERROR.toString());
        }
        return endResult;
    }
}
