package com.example.shoppingcompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Pattern;

public class ForgotPasswordActivity extends AppCompatActivity {
    public static final String EXTRA_EMAIL = "com.example.myfirstapp.EXTRA_EMAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    /** Called when the user taps log in */
    public void directToLogIn(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // TODO: Method makes the app crash each time it's called and needs to be diagnosed/fixed
    /** Called when the user taps submit */
    public void submitForgotPassword(View view) {
        Intent intent = new Intent(this, AfterForgotPasswordActivity.class);

        /* Extract out user input from email and password fields */
        EditText editTextEmailAddress = (EditText) findViewById(R.id.editText2);
        String email = editTextEmailAddress.getText().toString();

        /* Confirm valid input and process forgotten email */
        email = getValidEmailAddressInput(email);

        intent.putExtra(EXTRA_EMAIL, email);
        startActivity(intent);
    }

    /**
     * Process the input to editTextEmailAddress
     */
    public String getValidEmailAddressInput(String initialPasswordInput) {
        if (isValidEmailAddress(initialPasswordInput)) {
            return initialPasswordInput;
        }
        else {
            // TODO: Prompt the user for valid email input
            return "Wrong@comcast.net";
        }
    }

    /**
     * 1 or more of [a-zA-Z0-9_+&*-]
     * 0 or more from non-capturing group (?:\\.[a-zA-Z0-9_+&*-]+)
     * 1 @
     * 1 or more from non-capturing group (?:[a-zA-Z0-9-]+\\.)
     * 2-7 characters of [a-zA-Z]
     *
     * View this regex here: https://regexr.com/
     *
     * Source: https://www.geeksforgeeks.org/check-email-address-valid-not-java/
     */
    public Boolean isValidEmailAddress(String initialEmailAddressInput) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);

        if (initialEmailAddressInput == null) {
            return false;
        }
        return pat.matcher(initialEmailAddressInput).matches();
    }
}
