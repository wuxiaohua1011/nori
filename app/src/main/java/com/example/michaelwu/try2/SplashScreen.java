package com.example.michaelwu.try2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    private Button retryButton;
    private TextView textView, textView2, textView3, textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        wireWidgets();
        setWidgetListner();
        hideMessage();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                //TODO: add function such that it actually checks the data base and errors if user not found else start activity automatically
                showErrorMessage();
            }
        }, 5000);   //5 seconds
    }
    private void startMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void setWidgetListner() {
        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: add function such that it actually re-checks the data base
                startMainActivity();
            }
        });
    }

    private void showErrorMessage() {
        retryButton.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.VISIBLE);
        textView3.setVisibility(View.VISIBLE);
        textView4.setVisibility(View.VISIBLE);
    }

    private void hideMessage() {
        retryButton.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        textView4.setVisibility(View.INVISIBLE);
    }

    private void wireWidgets() {
        retryButton = findViewById(R.id.retry);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
    }
}
