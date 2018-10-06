package com.example.shoppingcompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LinkToCustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_to_customer);

        Bundle extras = getIntent().getExtras();
        String email = extras.getString("EXTRA_EMAIL");
        String password = extras.getString("EXTRA_PASSWORD");

        // Capture the layout's TextView and set the stringS as their text
        TextView textView11 = findViewById(R.id.textView11);
        textView11.setText(email);
        TextView textView12 = findViewById(R.id.textView12);
        textView12.setText(password);
    }
}
