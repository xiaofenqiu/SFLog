package com.sf.sflog.log;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public abstract class Print implements LogImpl {
    abstract void log(int type, String tag, String s);

    abstract void logForJson(int type, String tag, String s);

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

    @Override
    public void jsonForV(String str) {
        json(Log.VERBOSE, SFLog.logConfig.defaultTag, str);
    }

    @Override
    public void jsonForD(String str) {
        json(Log.DEBUG, SFLog.logConfig.defaultTag, str);
    }

    @Override
    public void jsonForI(String str) {
        json(Log.INFO, SFLog.logConfig.defaultTag, str);
    }

    @Override
    public void jsonForW(String str) {
        json(Log.VERBOSE, SFLog.logConfig.defaultTag, str);
    }

    @Override
    public void jsonForE(String str) {
        json(Log.ERROR, SFLog.logConfig.defaultTag, str);
    }

    @Override
    public void jsonForV(String tag, String str) {
        json(Log.VERBOSE, tag, str);
    }

    @Override
    public void jsonForD(String tag, String str) {
        json(Log.DEBUG, tag, str);
    }

    @Override
    public void jsonForI(String tag, String str) {
        json(Log.INFO, tag, str);
    }

    @Override
    public void jsonForW(String tag, String str) {
        json(Log.VERBOSE, tag, str);
    }

    @Override
    public void jsonForE(String tag, String str) {
        json(Log.ERROR, tag, str);
    }

    public void print(int type, String tag, String str) {
        if (!SFLog.logConfig.openLog)
            return;
        log(type, tag, str);
    }

    private void json(int type, String tag, String json) {
        if (!SFLog.logConfig.openLog)
            return;
        int indent = 4;
        if (TextUtils.isEmpty(json)) {
            logForJson(type, tag, "JSON{json is empty}");
            return;
        }
        try {
            if (json.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(json);
                String msg = jsonObject.toString(indent);
                logForJson(type, tag, msg);
            } else if (json.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(json);
                String msg = jsonArray.toString(indent);
                logForJson(type, tag, msg);
            }
        } catch (JSONException e) {
            logForJson(type, tag, e.toString() + "\n\njson = " + json);
        }
    }

    String getClassTag() {
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



    /**
     * 长字符串转化为List
     *
     * @param msg
     * @return
     */
    static List<String> stringToList(String msg) {
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
