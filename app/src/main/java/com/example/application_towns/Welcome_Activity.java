package com.example.application_towns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class Welcome_Activity extends AppCompatActivity {

    private String userEmail;
    private String userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_welcome);

        final String[] BaseEmails = getResources().getStringArray(R.array.emails);
        final String[] BasePasswords = getResources().getStringArray(R.array.passwords);
        final Intent intent = new Intent(this, NavigationDrawerActivity.class);

        EditText userEmailField = findViewById(R.id.email);
        EditText userPasswordField = findViewById(R.id.password);

        Button enterButton = findViewById(R.id.enter_button);
        enterButton.setOnClickListener(v -> {
            userEmail = userEmailField.getText().toString();
            userPassword = userPasswordField.getText().toString();

            boolean flag = false;

            for (int i = 0; i < 5; i++) {
                if (userEmail.equals(BaseEmails[i]) && userPassword.equals(BasePasswords[i]))
                    flag = true;
            }


            //====================
            flag = true;
            //====================



            if (!flag) {
                userEmailField.setTextColor(getResources().getColor(R.color.red));
                userPasswordField.setTextColor(getResources().getColor(R.color.red));
            }
            else {
                userEmailField.setTextColor(getResources().getColor(R.color.black));
                userPasswordField.setTextColor(getResources().getColor(R.color.black));
                userEmailField.setText("");
                userPasswordField.setText("");
                startActivity(intent);
            }
        });

    }
}