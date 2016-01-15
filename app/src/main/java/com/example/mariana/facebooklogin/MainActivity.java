package com.example.mariana.facebooklogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends Activity {

    private CallbackManager callbackManager;
    private TextView info;
    private LoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_main);
        info = (TextView) findViewById(R.id.tatianeNaUem);
        loginButton = (LoginButton) findViewById(R.id.botaoLoginFacebook);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                info.setText("Você acessou com sucesso fera.");
            }

            @Override
            public void onCancel() {
                info.setText("Você cancelou.");
            }

            @Override
            public void onError(FacebookException e) {
                info.setText("Você é burro");
            }
        });

    }

    protected void onActivityResult(int atividadeUm, int atividadeDois, Intent atividadeTres) {
        callbackManager.onActivityResult(atividadeUm, atividadeDois, atividadeTres);
    }


}
