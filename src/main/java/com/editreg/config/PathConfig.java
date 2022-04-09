package com.editreg.config;


public class PathConfig {
    private static final String environmentPath = "\"HKEY_LOCAL_MACHINE\\SYSTEM\\ControlSet001\\Control\\Session Manager\\Environment\"";
    private static final String tempPath = "HKEY_LOCAL_MACHINE\\SOFTWARE";
    private String JAVA_HOME ="";
    public String getJAVA_HOME() {
        return JAVA_HOME;
    }
    public void setJAVA_HOME(String JAVA_HOME) {
        this.JAVA_HOME = JAVA_HOME;
    }
    public String getEnvironmentPath() {
        return this.environmentPath;
    }
    public String getTempPath() {
        return this.tempPath;
    }
}
