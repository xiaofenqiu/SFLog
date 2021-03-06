package com.sf.sflog.log;

import android.util.Log;

import java.util.List;

class SourcePrint extends Print {
    @Override
    void log(int type, String tag, String s) {
        if (SFLog.logConfig.isShowLine) {
            print(type, tag, SFLog.logConfig.getUpString());
            print(type, tag, SFLog.logConfig.getNormalString() + getClassTag());
            print(type, tag, SFLog.logConfig.getCenterString());

            String[] stringsBR = s.split(LogConfig.BR == null ? "" : LogConfig.BR);
            for (String sBR : stringsBR) {
                List<String> strings = stringToList(sBR);
                for (String str : strings) {
                    print(type, tag, SFLog.logConfig.getNormalString() + str);
                }
            }
            print(type, tag, SFLog.logConfig.getDownString());
        } else {
            print(type, tag, getClassTag());
            String[] stringsBR = s.split(LogConfig.BR == null ? "" : LogConfig.BR);
            for (String sBR : stringsBR) {
                List<String> strings = stringToList(sBR);
                for (String str : strings) {
                    print(type, tag, str);
                }
            }
        }

    }


    private void print(int type, String tag, String s) {
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
