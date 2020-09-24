package com.sf.sflog.log;

public class LogConfig {
    // 每行最大日志长度
    public static final int LINE_MAX = 1024 * 3;
    public static final int MIN_STACK_OFFSET=5;
    // 换行符
    public static final String BR = System.getProperty("line.separator");
    private String tag = "tag";
    private boolean openLog = true;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isOpenLog() {
        return openLog;
    }

    public void setOpenLog(boolean openLog) {
        this.openLog = openLog;
    }
}
