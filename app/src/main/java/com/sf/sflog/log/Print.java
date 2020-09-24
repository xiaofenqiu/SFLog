package com.sf.sflog.log;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public abstract class Print implements LogImpl {
    abstract void log(int type, String tag, String s);

    @Override
    public void v(String str) {
        print(Log.VERBOSE, SFLog.logConfig.defaultTag, str);
    }

    @Override
    public void d(String str) {
        print(Log.DEBUG, SFLog.logConfig.defaultTag, str);
    }

    @Override
    public void i(String str) {
        print(Log.INFO, SFLog.logConfig.defaultTag, str);
    }

    @Override
    public void w(String str) {
        print(Log.WARN, SFLog.logConfig.defaultTag, str);
    }

    @Override
    public void e(String str) {
        print(Log.ERROR, SFLog.logConfig.defaultTag, str);
    }

    @Override
    public void v(String tag, String str) {
        print(Log.VERBOSE, tag, str);
    }

    @Override
    public void d(String tag, String str) {
        print(Log.DEBUG, tag, str);
    }

    @Override
    public void i(String tag, String str) {
        print(Log.INFO, tag, str);
    }

    @Override
    public void w(String tag, String str) {
        print(Log.WARN, tag, str);
    }

    @Override
    public void e(String tag, String str) {
        print(Log.ERROR, tag, str);
    }

    public void print(int type, String tag, String str) {
        if (!SFLog.logConfig.openLog)
            return;
        handlerStr();
        log(type, tag, str);
    }

    private void handlerStr() {

    }

    String getTag() {
        try {
            StackTraceElement[] trace = Thread.currentThread().getStackTrace();
            int i = getStackOffset(trace);
            if (i >= 0 && i < trace.length) {
                String tag = "%s.%s%s";
                StackTraceElement element = trace[i];
                String clazzName = element.getClassName();
                String stackTrace = element.toString();
                stackTrace = stackTrace.substring(stackTrace.lastIndexOf('('));
                clazzName = clazzName.substring(clazzName.lastIndexOf(".") + 1);
                tag = String.format(tag, clazzName, element.getMethodName(), stackTrace);
                return tag;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "TAG";
    }

    private int getStackOffset(StackTraceElement[] trace) {
        for (int i = LogConfig.MIN_STACK_OFFSET; i < trace.length; i++) {
            StackTraceElement e = trace[i];
            String name = e.getClassName();
            if (i < trace.length - 1 && trace[i + 1].getClassName()
                    .equals(SFLog.class.getName())) {
                continue;
            }
            if (name.equals(SFLog.class.getName())) {
                return ++i;
            }
        }
        return -1;
    }

    String getUpString() {
        return "╔*******************************************************************************************************************";
    }

    String getDownString() {
        return "╚*******************************************************************************************************************";
    }

    String getNormalString() {
        return "║ ";
    }

    String getCenterString() {
        return "╟*******************************************************************************************************************";
    }

    /**
     * 长字符串转化为List
     *
     * @param msg
     * @return
     */
    public static List<String> stringToList(String msg) {
        List<String> stringList = new ArrayList<>();
        int index = 0;
        int maxLength = LogConfig.LINE_MAX;
        int countOfSub = msg.length() / maxLength;
        if (countOfSub > 0) {
            for (int i = 0; i < countOfSub; i++) {
                String sub = msg.substring(index, index + maxLength);
                stringList.add(sub);
                index += maxLength;
            }
            stringList.add(msg.substring(index));
        } else {
            stringList.add(msg);
        }
        return stringList;
    }
}
