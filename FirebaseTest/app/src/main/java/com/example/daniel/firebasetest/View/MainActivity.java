package com.example.daniel.firebasetest.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.daniel.firebasetest.Presenter.MainActivityPresenter;
import com.example.daniel.firebasetest.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    @BindView(R.id.loggedUserMainTextView)
    TextView loggedUserMainTextView;
    @BindView(R.id.signMainButton)
    Button signMainButton;
    @BindView(R.id.logMainButton)
    Button logMainButton;

    private MainActivityPresenter mainActivityPresenter;
    private Intent loginIntent;
    private Intent registerIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainActivityPresenter = new MainActivityPresenter();
        loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainActivityPresenter.attach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainActivityPresenter.detach();
    }

    @OnClick({R.id.signMainButton, R.id.logMainButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.signMainButton:
                mainActivityPresenter.onRegisterButtonClicked();
                break;
            case R.id.logMainButton:
                mainActivityPresenter.onLoginButtonClicked();
                break;
        }
    }

    public void startLoginActivity() {
        startActivity(loginIntent);
    }

    public void startRegisterActivity() {
        startActivity(registerIntent);
    }

    public void updateUI(String login) {

    }
}
