package com.example.daniel.firebasetest.Presenter;

import com.example.daniel.firebasetest.View.LoggedViewInterface;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoggedPresenter {
    LoggedViewInterface loggedView;
    FirebaseUser currentUser;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    public void attach(LoggedViewInterface loggedView) {
        this.loggedView = loggedView;
    }

    public void detach() {
        this.loggedView = null;
    }

    public FirebaseUser getCurrentUser() {
        return firebaseAuth.getCurrentUser();
    }

    public void logout() {
        FirebaseAuth.getInstance().signOut();
        if(currentUser == null){
            loggedView.startMainActivity();
        } else {
            return;
        }
    }
}
