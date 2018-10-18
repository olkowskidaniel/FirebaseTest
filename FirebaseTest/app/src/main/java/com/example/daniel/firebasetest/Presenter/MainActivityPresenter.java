package com.example.daniel.firebasetest.Presenter;

import com.example.daniel.firebasetest.View.MainViewInterface;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivityPresenter {
    MainViewInterface mainView;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    public void attach(MainViewInterface mainViewInterface) {
        this.mainView = mainViewInterface;
    }

    public void detach() {
        this.mainView = null;
    }

    public void onLoginButtonClicked() {
        mainView.startLoginActivity();
    }

    public void onRegisterButtonClicked() {
        mainView.startRegisterActivity();
    }

    public void checkIfUserLogged() {
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if(currentUser != null) {
            mainView.startLoggedActivity();
        }
        else {
            return;
        }
    }
}
