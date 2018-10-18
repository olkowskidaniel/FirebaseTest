package com.example.daniel.firebasetest.View;

import android.app.Activity;

public interface LoginViewInterface {
    Activity getActivity();
    void showLoggedSuccessMessage(String user);
    void showLoginFailedMessage();
    void startLoggedActivity();
}
