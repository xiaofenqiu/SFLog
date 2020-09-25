package com.sf.sflog.log;

import android.util.Log;

import java.util.List;

class SourcePrint extends Print {
    @Override
    void log(int type, String tag, String s) {
        print(type, tag, getUpString());
        print(type, tag, getNormalString() + getTag());
        print(type, tag, getCenterString());
        List<String> strings = stringToList(s);
        for (String str : strings) {
            print(type, tag, getNormalString() + str);
        }
        print(type, tag, getDownString());
    }

    @Override
    void logForJson(int type, String tag, String s) {
        print(type, tag, getUpString());
        print(type, tag, getNormalString() + getTag());
        print(type, tag, getCenterString());
        String[] strings = s.split(LogConfig.BR == null ? "" : LogConfig.BR);
        for (String str : strings) {
            print(type, tag, getNormalString() + str);
        }
        print(type, tag, getDownString());
    }

    @Override
    public void print(int type, String tag, String s) {
        switch (type) {
            case Log.VERBOSE:
                Log.v(tag, s);
                break;
            case Log.DEBUG:
                Log.d(tag, s);
                break;
            case Log.INFO:
                Log.i(tag, s);
                break;
            case Log.WARN:
                Log.w(tag, s);
                break;
            case Log.ERROR:
                Log.e(tag, s);
                break;
        }
    }
}
