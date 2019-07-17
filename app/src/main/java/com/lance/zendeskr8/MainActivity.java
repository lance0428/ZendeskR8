package com.lance.zendeskr8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import zendesk.core.AnonymousIdentity;
import zendesk.core.JwtIdentity;
import zendesk.core.Zendesk;
import zendesk.support.guide.HelpCenterActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Zendesk.INSTANCE.setIdentity(new JwtIdentity(ZendeskConfig.jwtUserIdentifier));
            }
        });
        findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Zendesk.INSTANCE.setIdentity(new AnonymousIdentity.Builder().build());
            }
        });
        findViewById(R.id.launchZendesk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelpCenterActivity.builder().show(MainActivity.this);
            }
        });
    }
}
