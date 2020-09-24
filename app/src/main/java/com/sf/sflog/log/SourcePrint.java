package com.sf.sflog.log;

import android.util.Log;

import java.util.List;

class SourcePrint extends Print {
    @Override
    void log(int type, String s) {
        print(type, getUpString());
        print(type, getNormalString() + getTag());
        print(type, getCenterString());
        List<String> strings = stringToList(s);
        for (String str : strings) {
            print(type, getNormalString() + str);
        }
        print(type, getDownString());
    }

    private void print(int type, String s) {
        switch (type) {
            case Log.VERBOSE:
                Log.v(SFLog.logConfig.getTag(), s);
                break;
            case Log.DEBUG:
                Log.d(SFLog.logConfig.getTag(), s);
                break;
            case Log.INFO:
                Log.i(SFLog.logConfig.getTag(), s);
                break;
            case Log.WARN:
                Log.w(SFLog.logConfig.getTag(), s);
                break;
            case Log.ERROR:
                Log.e(SFLog.logConfig.getTag(), s);
                break;
        }
    }
}
