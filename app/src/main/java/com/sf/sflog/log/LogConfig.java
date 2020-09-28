package com.sf.sflog.log;

public class LogConfig implements ConfigImpl {
    // 每行最大日志长度
    static final int LINE_MAX = 1024 * 3;
    static final int MIN_STACK_OFFSET = 5;
    private static final int NORMAL_LINE_LENGTH = 114;
    public static final int LINE_FORMAT_LINE = 1;
    public static final int LINE_FORMAT_STARS = 2;
    private int lineLength = NORMAL_LINE_LENGTH;
    private String upString;
    private String downString;
    private String normalString;
    private String centerString;
    // 换行符
    static final String BR = System.getProperty("line.separator");

    String defaultTag = "tag";
    boolean openLog = true;
    boolean isShowLine = true;

    LogConfig() {
        dividingLineFormat(LINE_FORMAT_STARS);
    }

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
    public ConfigImpl upString(String upString) {
        this.upString = upString;
        return this;
    }

    @Override
    public ConfigImpl downString(String downString) {
        this.downString = downString;
        return this;
    }

    @Override
    public ConfigImpl normalString(String normalString) {
        this.normalString = normalString;
        return this;
    }

    @Override
    public ConfigImpl centerString(String centerString) {
        this.centerString = centerString;
        return this;
    }

    @Override
    public LogConfig upChar(char upChar) {
        upString = format(upChar, lineLength);
        return this;
    }

    @Override
    public LogConfig downChar(char downChar) {
        downString = format(downChar, lineLength);
        return this;
    }

    @Override
    public LogConfig normalChar(char normalChar) {
        normalString = normalChar + " ";
        return this;
    }

    @Override
    public LogConfig centerChar(char centerChar) {
        this.centerString = format(centerChar, lineLength);
        return this;
    }

    @Override
    public ConfigImpl dividingLineFormat(int format) {
        switch (format) {
            case LINE_FORMAT_LINE:
                upString = "╔" + format('═', lineLength);
                downString = "╚" + format('═', lineLength);
                normalString = "║ ";
                centerString = "╟" + format('═', lineLength);
                break;
            case LINE_FORMAT_STARS:
                upString = format('*', lineLength);
                downString = format('*', lineLength);
                normalString = "* ";
                centerString = format('*', lineLength);
                break;
        }
        return this;
    }

    @Override
    public ConfigImpl dividingLineLength(int length) {
        lineLength = length;
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

    public String format(char c, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
