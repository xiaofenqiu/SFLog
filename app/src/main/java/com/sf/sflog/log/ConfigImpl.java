package com.sf.sflog.log;

public interface ConfigImpl {
    //默认tag
    ConfigImpl defaultTag(String str);

    //是否打开日志
    ConfigImpl openLog(boolean openLog);

    //是否打开排版线
    ConfigImpl openLine(boolean isShowLine);

    //设置上排线样式
    ConfigImpl upString(String upString);

    //设置下排线样式
    ConfigImpl downString(String downString);

    //设置内容前排线
    ConfigImpl normalString(String normalString);

    //设置class信息和内容中间间隔排线
    ConfigImpl centerString(String centerString);

    //设置上排线样式
    ConfigImpl upChar(char upChar);

    //设置下排线样式
    ConfigImpl downChar(char downChar);

    //设置内容前排线
    ConfigImpl normalChar(char normalChar);

    //设置class信息和内容中间间隔排线
    ConfigImpl centerChar(char centerChar);

    //选择分割线格式
    ConfigImpl dividingLineFormat(int format);

    //风格线长度
    ConfigImpl dividingLineLength(int length);
}
