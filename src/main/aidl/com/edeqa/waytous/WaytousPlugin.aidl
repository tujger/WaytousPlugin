// WaytousPlugin.aidl
package com.edeqa.waytous;

// Declare any non-default types here with import statements

interface WaytousPlugin {

    String getType();

    void start();

    void finish();

    List<String> events();

    void setContext(in Bundle bundle);

    boolean onEvent(in String eventName, in Bundle bundle);

    void setLoggingLevel(in Bundle bundle);

    int getViewResId();

    void viewClicked(in int resId);

}
