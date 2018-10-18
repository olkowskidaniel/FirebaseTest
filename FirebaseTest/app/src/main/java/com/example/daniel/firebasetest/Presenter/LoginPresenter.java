package com.example.daniel.firebasetest.Presenter;

import android.support.annotation.NonNull;

import com.example.daniel.firebasetest.View.LoginViewInterface;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPresenter {
    LoginViewInterface loginView;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    public void attach(LoginViewInterface loginView) {
        this.loginView = loginView;
    }

    public void detach() {
        this.loginView = null;
    }

    public void logIn(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(loginView.getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            loginView.showLoggedSuccessMessage(user.getEmail());
                            loginView.startLoggedActivity();
                        }else{
                            loginView.showLoginFailedMessage();
                        }
                    }
                });
    }
}
