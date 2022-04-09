package com.editreg.util;

import org.jetbrains.annotations.NotNull;

public class ErrorUtil {
    private static String ERROR_MESSAGE = "";
//    public static String getErrorMessage() {return ERROR_MESSAGE;}
    public static String setSuccessMessage() {return ERROR_MESSAGE = "success";}
    public static void setErrorMessage(String errorMessage) {ERROR_MESSAGE = errorMessage;}
    public static String getMessage() {return new changeEnumValue(ERROR_MESSAGE).message;}
    static class changeEnumValue {
        String message = "";
        changeEnumValue(@NotNull String ERROR_MESSAGE){
            switch (ERROR_MESSAGE){
                case "SELECT_ERROR":message="执行select任务错误，目录冗余或已存在相同配置！";break;
                case "COPY_ERROR":message="执行copy任务错误，目录冗余或已存在相同配置！";break;
                case "DELETE_TEMP_ERROR":message="执行delete_temp任务错误，目录冗余或已存在相同配置！";break;
                case "DELETE_ORIGIN_ERROR":message="执行delete_origin任务错误，目录冗余或已存在相同配置！";break;
                case "ADD_JAVA_HOME_ERROR":message="执行add_home任务错误，目录冗余或已存在相同配置！";break;
                case "ADD_PATH_ERROR":message="执行add_path任务错误，目录冗余或已存在相同配置！";break;
                case "RESTORE_ERROR":message="执行restore任务错误，目录冗余或已存在相同配置！";break;
                case "PATH_ERROR":message="获取路径错误！";break;
            }
        }
    }
}