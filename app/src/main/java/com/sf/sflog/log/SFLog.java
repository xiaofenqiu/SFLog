package com.sf.sflog.log;

import android.util.Log;

public class SFLog {
    private static final LogImpl print = new SourcePrint();
    static final LogConfig logConfig = new LogConfig();

    public LogConfig getLogConfig() {
        return logConfig;
    }

    public static void v(String str) {
        print.v(str);
    }

    public static void d(String str) {
        print.d(str);
    }

    public static void i(String str) {
        print.i(str);
    }

    public static void w(String str) {
        print.w(str);
    }

    public static void e(String str) {
        print.e(str);
    }

    public static void v(String tag, String str) {
        print.v(tag, str);
    }

    public static void d(String tag, String str) {
        print.d(tag, str);
    }

    public static void i(String tag, String str) {
        print.i(tag, str);
    }

    public static void w(String tag, String str) {
        print.w(tag, str);
    }

    public static void e(String tag, String str) {
        print.e(tag, str);
    }

    public void jsonForV(String tag, String str) {
        print.jsonForV(tag, str);
    }

    public void jsonForD(String tag, String str) {
        print.jsonForD(tag, str);
    }

    public void jsonForI(String tag, String str) {
        print.jsonForI(tag, str);
    }

    public void jsonForW(String tag, String str) {
        print.jsonForW(tag, str);
    }

    public void jsonForE(String tag, String str) {
        print.jsonForE(tag, str);
    }
}
