package com.example.shoppingcompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_EMAIL = "com.example.myfirstapp.EXTRA_EMAIL";
    public static final String EXTRA_PASSWORD = "com.example.myfirstapp.EXTRA_PASSWORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps forgot password */
    public void directToForgotPassword(View view) {
        Intent intent = new Intent(this, ForgotPasswordActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps sign up */
    public void directToSignUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps submit */
    public void submitLogIn(View view) {
        Intent intent = new Intent(this, LinkToCustomerActivity.class);
        Bundle extras = new Bundle();

        /* Extract out user input from email and password fields */
        EditText editTextEmail = (EditText) findViewById(R.id.editText2);
        String email = editTextEmail.getText().toString();
        EditText editTextPassword = (EditText) findViewById(R.id.editText);
        String password = editTextPassword.getText().toString();

        /* Confirm valid input and process email and password */
        email = getValidEmailInput(email);
        password = getValidPasswordInput(password);

        extras.putString("EXTRA_EMAIL", email);
        extras.putString("EXTRA_PASSWORD", password);
        intent.putExtras(extras);
        startActivity(intent);
    }

    /**
     * Process the input to editTextEmailAddress
     */
    public String getValidEmailInput(String initialEmailInput) {
        if (isValidEmail(initialEmailInput)) {
            return initialEmailInput;
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
    public Boolean isValidEmail(String initialEmailInput) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);

        if (initialEmailInput == null) {
            return false;
        }
        return pat.matcher(initialEmailInput).matches();
    }

    /**
     * Process the input to editTextPassword:
     *   Must be 8 characters or more and contain 3 of the following:
     *      - Uppercase letter(s)
     *      - Lowercase letter(s)
     *      - Digit(s)
     *      - Special character(s): (~!@#$%^&*_-+=`|\(){}[]:;"'<>,.?/)
     * Hash and then salt the input before sending it to DB.
     */
    public String getValidPasswordInput(String initialPasswordInput) {
        // TODO: Check the password meets minimum security standards
        // TODO: Hash the password
        // TODO: Salt the password
        return initialPasswordInput;
    }
}
