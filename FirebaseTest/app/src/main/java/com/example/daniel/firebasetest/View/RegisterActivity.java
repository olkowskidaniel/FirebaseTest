package com.example.daniel.firebasetest.View;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daniel.firebasetest.Presenter.RegisterPresenter;
import com.example.daniel.firebasetest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements RegisterViewInterface {

    @BindView(R.id.loginRegisterEditText)
    EditText loginRegisterEditText;
    @BindView(R.id.passRegisterEditText)
    EditText passRegisterEditText;
    @BindView(R.id.repassRegisterEditText)
    EditText repassRegisterEditText;
    @BindView(R.id.submitRegisterButton)
    Button submitRegisterButton;

    RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        registerPresenter = new RegisterPresenter();
        registerPresenter.initializeFirebaseAuth();
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerPresenter.attach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        registerPresenter.detach();
    }

    @OnClick(R.id.submitRegisterButton)
    public void onViewClicked() {
        registerPresenter.registerAccount(loginRegisterEditText.getText().toString().trim(),
                passRegisterEditText.getText().toString().trim(), repassRegisterEditText.getText().toString().trim());
    }

    @Override
    public boolean checkIfRetypedPasswordCorrect(String password, String retypedPassword) {
        if (password.equals(retypedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public void updateUI(String login) {

    }

    @Override
    public Activity getActivity() {
        return RegisterActivity.this;
    }

    public void showRegisterFailedMessage() {
        Toast.makeText(this, "Registration failed", Toast.LENGTH_LONG).show();
    }

    public void showPasswordMatchFailedMessage() {
        Toast.makeText(this, "Passwords doesn't match", Toast.LENGTH_LONG).show();

    }

    public void showRegisterSuccessMessage(){
        Toast.makeText(this, "Registration successful", Toast.LENGTH_LONG).show();
    }
}
