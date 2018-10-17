package com.example.daniel.firebasetest.Presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.daniel.firebasetest.View.RegisterActivity;
import com.example.daniel.firebasetest.View.RegisterViewInterface;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterPresenter {
    RegisterViewInterface registerView;
    private FirebaseAuth firebaseAuth;

    public void attach(RegisterViewInterface registerView) {
        this.registerView = registerView;
    }

    public void detach() {
        this.registerView = null;
    }

    public void initializeFirebaseAuth() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void registerAccount(String login, String password, String retypedPassword) {
        if (registerView.checkIfRetypedPasswordCorrect(password, retypedPassword)) {
            firebaseAuth.createUserWithEmailAndPassword(login, password)
                    .addOnCompleteListener(registerView.getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d("CREATE_USER", "createUserWithEmail: success");
                                registerView.showRegisterSuccessMessage();

                            } else {
                                registerView.showRegisterFailedMessage();
                            }
                        }
                    });
        } else {
            registerView.showPasswordMatchFailedMessage();
        }

    }

}
