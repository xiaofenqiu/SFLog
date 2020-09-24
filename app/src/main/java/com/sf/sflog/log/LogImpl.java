package com.sf.sflog.log;

public interface LogImpl {
    //Log.v 的输出颜色为黑色的，输出大于或等于VERBOSE日志级别的信息
    public void v(String str);

    //Log.d的输出颜色是蓝色的，输出大于或等于DEBUG日志级别的信息
    public void d(String str);

    //Log.i的输出为绿色，输出大于或等于INFO日志级别的信息
    public void i(String str);

    //Log.w的输出为橙色, 输出大于或等于WARN日志级别的信息
    public void w(String str);

    //Log.e的输出为红色，仅输出ERROR日志级别的信息
    public void e(String str);


    //Log.v 的输出颜色为黑色的，输出大于或等于VERBOSE日志级别的信息
    public void v(String tag, String str);

    //Log.d的输出颜色是蓝色的，输出大于或等于DEBUG日志级别的信息
    public void d(String tag, String str);

    //Log.i的输出为绿色，输出大于或等于INFO日志级别的信息
    public void i(String tag, String str);

    //Log.w的输出为橙色, 输出大于或等于WARN日志级别的信息
    public void w(String tag, String str);

    //Log.e的输出为红色，仅输出ERROR日志级别的信息
    public void e(String tag, String str);
}
