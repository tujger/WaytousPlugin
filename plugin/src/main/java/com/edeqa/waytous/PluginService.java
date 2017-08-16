package com.edeqa.waytous;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import com.edeqa.eventbus.EntityHolder;

import java.util.List;
import java.util.logging.Level;

public class PluginService extends Service implements EntityHolder {
    static final String LOG_TAG = "ResPluginService1";

    public void onStart(Intent intent, int startId) {
        super.onStart( intent, startId );
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final WaytousPlugin.Stub binder =
            new WaytousPlugin.Stub() {

                @Override
                public String getType() throws RemoteException {
                    System.out.println(LOG_TAG + ":getType");
                    return LOG_TAG;
                }

                @Override
                public void start() throws RemoteException {
                    System.out.println(LOG_TAG + ":start");
                }

                @Override
                public void finish() throws RemoteException {
                    System.out.println(LOG_TAG + ":finish");

                }

                @Override
                public List<String> events() throws RemoteException {
                    System.out.println(LOG_TAG + ":events");

                    return null;
                }

                @Override
                public void setContext(Bundle var1) throws RemoteException {
                    System.out.println(LOG_TAG + ":setcontext:"+var1);

                }

                @Override
                public boolean onEvent(String var1, Bundle var2) throws RemoteException {
                    System.out.println(LOG_TAG + ":onevent1111:"+var1+":"+var2.getSerializable("object"));
                    return true;
                }

                @Override
                public void setLoggingLevel(Bundle var1) throws RemoteException {
                    System.out.println(LOG_TAG + ":setlogginglevel:"+var1);

                }
            };


    private Object context;


    @Override
    public void setContext(Object o) {
        this.context = o;
    }

    @Override
    public String getType() {
        return "ResPluginService1";
    }

    @Override
    public void start() {

    }

    @Override
    public void finish() {

    }

    @Override
    public List<String> events() {
        return null;
    }

    @Override
    public boolean onEvent(String s, Object o) {
        return true;
    }

    @Override
    public void setLoggingLevel(Level level) {

    }
}


