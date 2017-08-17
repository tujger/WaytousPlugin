package com.edeqa.waytous;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import com.edeqa.eventbus.EntityHolder;
import com.edeqa.eventbus.EventBus;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract public class PluginService extends Service implements EntityHolder {

    public static final String ACTION_POST_EVENT = "com.edeqa.waytous.intent.action.EVENT";
    public static final String ACTION_POST_EVENT_NAME = "eventName";
    public static final String ACTION_POST_EVENT_OBJECT = "eventObject";

    static final String LOG_TAG = "PluginService";

    public void onStart(Intent intent, int startId) {
        super.onStart( intent, startId );
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final WaytousPlugin.Stub binder = new WaytousPlugin.Stub() {

        public int getViewResId() {
            return PluginService.this.getViewResId();
        }

        @Override
        public String getType() throws RemoteException {
            return PluginService.this.getType();
        }

        @Override
        public void start() throws RemoteException {
            PluginService.this.start();
        }

        @Override
        public void finish() throws RemoteException {
            PluginService.this.finish();

        }

        @Override
        public List<String> events() throws RemoteException {
            return PluginService.this.events();
        }

        @Override
        public void setContext(Bundle var1) throws RemoteException {
            Object context = var1.getSerializable("context");
            PluginService.this.setContext(context);

        }

        @Override
        public boolean onEvent(String var1, Bundle var2) throws RemoteException {
            Object o = var2.getSerializable("object");
            return PluginService.this.onEvent(var1, o);
        }

        @Override
        public void setLoggingLevel(Bundle var1) throws RemoteException {
            Level level = (Level) var1.getSerializable("level");
            PluginService.this.setLoggingLevel(level);
        }
    };

/*
    private Object context;


    @Override
    public void setContext(Object o) {
        this.context = o;
    }
*/
    protected static Logger LOGGER = Logger.getLogger(EventBus.class.getName());

    protected Object context;

    private Level loggingLevel = Level.WARNING;

    protected PluginService() {
        LOGGER.setLevel(loggingLevel);
        LOGGER.info("PluginService:init"); //NON-NLS
    }

    @Override
    public void setContext(Object context) {
        this.context = context;
    }

    @Override
    @SuppressWarnings("WeakerAccess")
    public String getType() {
        return this.getClass().getSimpleName();
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

/*
    @Override
    public boolean onEvent(String s, Object o) {
        return true;
    }
*/

    @Override
    public void setLoggingLevel(Level level) {
        loggingLevel = level;
        LOGGER.setLevel(loggingLevel);
    }

    public int getViewResId() {
        return 0;
    }

}


