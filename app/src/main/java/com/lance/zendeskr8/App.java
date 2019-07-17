package com.lance.zendeskr8;

import android.app.Application;
import android.util.Log;

import com.zendesk.logger.Logger;

import zendesk.core.AnonymousIdentity;
import zendesk.core.Zendesk;
import zendesk.support.Support;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("LDJ", "Initializing Zendesk");
        Logger.setLoggable(true);
        Zendesk.INSTANCE.init(this, ZendeskConfig.zendeskUrl, ZendeskConfig.applicationId, ZendeskConfig.oauthClientId);
        Support.INSTANCE.init(Zendesk.INSTANCE);
        Zendesk.INSTANCE.setIdentity(new AnonymousIdentity.Builder().build());
    }
}
