package com.example.shoppingcompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AfterForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_forgot_password);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(ForgotPasswordActivity.EXTRA_EMAIL);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }

    /**
     * Called when the user taps log in
     */
    public void directToLogIn(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Called when the user taps sign up
     */
    public void directToSignUp(View view) {
        // TODO: Create ShoppingListActivity.java
        /**
         * Intent intent = new Intent(this, ShoppingListActivity.class);
         * startActivity(intent);
         */
        return;
    }
}
