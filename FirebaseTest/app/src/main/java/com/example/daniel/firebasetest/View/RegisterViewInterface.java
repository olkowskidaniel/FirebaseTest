package com.example.daniel.firebasetest.View;

import android.app.Activity;

public interface RegisterViewInterface {
    boolean checkIfRetypedPasswordCorrect(String password, String retypedPassword);
    void updateUI(String login);
    Activity getActivity();
    void showRegisterFailedMessage();
    void showPasswordMatchFailedMessage();
    void showRegisterSuccessMessage();
}
