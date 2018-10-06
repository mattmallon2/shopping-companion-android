package com.example.shoppingcompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    /** Called when the user taps forgot password */
    public void directToForgotPassword(View view) {
        Intent intent = new Intent(this, ForgotPasswordActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps log in */
    public void directToLogIn(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps submit */
    public void submitSignUp(View view) {
        Intent intent = new Intent(this, LinkToCustomerActivity.class);
        Bundle extras = new Bundle();

        /* Extract out user input from email and password fields */
        EditText editTextEmail = (EditText) findViewById(R.id.editText2);
        String email = editTextEmail.getText().toString();

        EditText editTextPassword = (EditText) findViewById(R.id.editText);
        String password = editTextPassword.getText().toString();

        EditText editTextConfirmPassword = (EditText) findViewById(R.id.editText3);
        String confirmPassword = editTextPassword.getText().toString();

        /* Confirm valid input and process email and password */
        email = getValidEmailInput(email);
        password = getValidPasswordInput(password, confirmPassword);

        extras.putString("EXTRA_EMAIL", email);
        extras.putString("EXTRA_PASSWORD", password);
        extras.putString("EXTRA_CONFIRM_PASSWORD", confirmPassword);
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
     * Hash and then salt the input before sending it to DB.
     */
    public String getValidPasswordInput(String initialPasswordInput, String confirmPasswordInput) {
        // TODO: Check the password meets minimum security standards
        if (isValidPassword(initialPasswordInput)) {

        }
        else {
            // TODO: Prompt users to reenter passwords if they don't match
            return confirmPasswordInput;
        }

        // TODO: Hash the password
        // TODO: Salt the password
        String hashedPassword = getHash(initialPasswordInput);
        String hashedConfirmPassword = getHash(confirmPasswordInput);

        if (hashedPassword.equals(hashedConfirmPassword)) {
            return hashedPassword;
        }
        else {
            // TODO: Prompt users to reenter passwords if they don't match
            return hashedConfirmPassword;
        }
    }

    /**
     * Process the input to editTextPassword:
     *   Must be 8 characters or more and contain 3 of the following:
     *      - Uppercase letter(s)
     *      - Lowercase letter(s)
     *      - Digit(s)
     *      - Special character(s): (~!@#$%^&*_-+=`|\(){}[]:;"'<>,.?/)
     */
    public Boolean isValidPassword(String initialPasswordInput) {
        // TODO: Add in checks to see if input meets password criteria
        return true;
    }

    /**
     * Hash the user's password input
     *
     * WARNING: This could be completely the wrong spot for this. We
     * may need to do it earlier on for security reasons
     */
    public String getHash(String passwordInput) {
        // TODO: Hash the password
        return passwordInput;
    }
}
