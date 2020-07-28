package com.example.mowch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SignupActivity extends AppCompatActivity {

    Button signup;
    EditText name;

    Boolean enabled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signup = (Button) findViewById(R.id.signup_button2);
        name = (EditText) findViewById(R.id.name_signup);
        EditText email = (EditText) findViewById(R.id.email_signup);
        EditText pass = (EditText) findViewById(R.id.password_signup);
        EditText repass = (EditText) findViewById(R.id.retype_password_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().length() < 3) {
                    name.setError("Please put a valid name");
                } else if (!isEmailValid(email.getText())){
                    email.setError("Please put a valid email");
                } else if (pass.getText().length() < 6){
                    pass.setError("Password must be atleast 6 characters");
                } else if (!(repass.getText().toString().equals(pass.getText().toString()))){
                    repass.setError("Must match password");
                } else {
                    openSignUpActivity();
                }
            }
        });

       /*name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(s.toString().trim().length()==3){
                    signup.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            new Error("Name length too short");
                        }
                    });
                } else {
                    enabled = true;
                }
            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
*/   // might use for checking if the signup matches someone else's account

    }


    /*private void openLoggingInActivity() {
        Intent intent = new Intent(this, LogginginActivity.class);
        startActivity(intent);
    }*/
    private void openSignUpActivity() {
            String fullName = name.getText().toString();
            Intent intent = new Intent(this, AgreementsActivity.class);
            intent.putExtra("full_name", fullName);
            startActivity(intent);
    }
    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}