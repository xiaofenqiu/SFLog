package com.sf.sflog.log;

public class LogConfig implements ConfigImpl {
    // 每行最大日志长度
    static final int LINE_MAX = 1024 * 3;
    static final int MIN_STACK_OFFSET = 5;
    private String upString = "╔*******************************************************************************************************************";
    private String downString = "╚*******************************************************************************************************************";
    private String normalString = "║ ";
    private String centerString = "╟*******************************************************************************************************************";
    // 换行符
    static final String BR = System.getProperty("line.separator");

    String defaultTag = "tag";
    boolean openLog = true;
    boolean isShowLine = true;

    @Override
    public LogConfig defaultTag(String tag) {
        this.defaultTag = tag;
        return this;
    }

    @Override
    public LogConfig openLog(boolean openLog) {
        this.openLog = openLog;
        return this;
    }

    @Override
    public LogConfig openLine(boolean isShowLine) {
        this.isShowLine = isShowLine;
        return this;
    }

    @Override
    public LogConfig upString(String upString) {
        this.upString = upString;
        return this;
    }

    @Override
    public LogConfig downString(String downString) {
        this.downString = downString;
        return this;
    }

    @Override
    public LogConfig normalString(String normalString) {
        this.normalString = normalString;
        return this;
    }

    @Override
    public LogConfig centerString(String centerString) {
        this.centerString = centerString;
        return this;
    }

    String getUpString() {
        return upString;
    }

    String getDownString() {
        return downString;
    }

    String getNormalString() {
        return normalString;
    }

    String getCenterString() {
        return centerString;
    }
}
