package com.example.daniel.firebasetest.Presenter;

import com.example.daniel.firebasetest.View.MainViewInterface;

public class MainActivityPresenter {
    MainViewInterface mainView;

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
}
