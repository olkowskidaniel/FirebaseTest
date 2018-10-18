package com.example.daniel.firebasetest.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daniel.firebasetest.Presenter.LoginPresenter;
import com.example.daniel.firebasetest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginViewInterface {

    @BindView(R.id.emailLoginEditText)
    EditText emailLoginEditText;
    @BindView(R.id.passwordLoginEditText)
    EditText passwordLoginEditText;
    @BindView(R.id.sendLoginButton)
    Button sendLoginButton;

    private LoginPresenter loginPresenter;
    private Intent loggedIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter();
        loggedIntent = new Intent(LoginActivity.this, LoggedActivity.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginPresenter.attach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        loginPresenter.detach();
    }

    @OnClick(R.id.sendLoginButton)
    public void onViewClicked() {
        loginPresenter.logIn(emailLoginEditText.getText().toString().trim(),
                passwordLoginEditText.getText().toString().trim());
    }

    public void startLoggedActivity() {
        startActivity(loggedIntent);
    }

    public Activity getActivity() {
        return LoginActivity.this;
    }

    public void showLoggedSuccessMessage(String user) {
        Toast.makeText(LoginActivity.this, user + " logged", Toast.LENGTH_LONG).show();
    }

    public void showLoginFailedMessage() {
        Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_LONG).show();
    }

}
