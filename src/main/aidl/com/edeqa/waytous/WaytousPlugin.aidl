// WaytousPlugin.aidl
package com.edeqa.waytous;

// Declare any non-default types here with import statements

interface WaytousPlugin {

  String getType();

  void start();

  void finish();

  List<String> events();

  void setContext(in Bundle var1);

  boolean onEvent(in String var1, in Bundle var2);

  void setLoggingLevel(in Bundle var1);

  int getViewResId();

}
