package com.example.daniel.firebasetest.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.daniel.firebasetest.Presenter.LoggedPresenter;
import com.example.daniel.firebasetest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoggedActivity extends AppCompatActivity implements LoggedViewInterface {


    @BindView(R.id.usernameLoggedTextView)
    TextView usernameLoggedTextView;
    @BindView(R.id.logoutLoggedButton)
    Button logoutLoggedButton;

    private LoggedPresenter loggedPresenter;
    private Intent mainIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);
        ButterKnife.bind(this);
        loggedPresenter = new LoggedPresenter();
        mainIntent = new Intent(LoggedActivity.this, MainActivity.class);
        usernameLoggedTextView.setText("Currently logged: " + loggedPresenter.getCurrentUser().getEmail());
    }

    @Override
    protected void onStart() {
        super.onStart();
        loggedPresenter.attach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        loggedPresenter.detach();
    }

    @OnClick(R.id.logoutLoggedButton)
    public void onViewClicked() {
        loggedPresenter.logout();
    }

    public void startMainActivity(){
        startActivity(mainIntent);
    }
}
