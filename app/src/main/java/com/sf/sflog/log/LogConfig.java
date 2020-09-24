package com.sf.sflog.log;

public class LogConfig {
    // 每行最大日志长度
    static final int LINE_MAX = 1024 * 3;
    static final int MIN_STACK_OFFSET = 5;
    // 换行符
    public static final String BR = System.getProperty("line.separator");
    String defaultTag = "tag";
    boolean openLog = true;


    public LogConfig setdefaultTag(String tag) {
        this.defaultTag = tag;
        return this;
    }


    public LogConfig setOpenLog(boolean openLog) {
        this.openLog = openLog;
        return this;
    }
}
