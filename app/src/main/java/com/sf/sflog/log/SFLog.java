package com.sf.sflog.log;

public class SFLog {
    private static final Print print = new SourcePrint();
    public static final LogConfig logConfig = new LogConfig();
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


}
