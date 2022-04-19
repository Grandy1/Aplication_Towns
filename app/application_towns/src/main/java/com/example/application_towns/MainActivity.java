package com.example.application_towns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.application_towns.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private String userEmail;
    private String userPassword;

    private TextView mTextView;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.welcomeText;

        final String[] BaseEmails = getResources().getStringArray(R.array.emails);
        final String[] BasePasswords = getResources().getStringArray(R.array.passwords);
        final Intent intent = new Intent(this, ListActivity.class);

        EditText userEmailField = findViewById(R.id.edit_text_email);
        EditText userPasswordField = findViewById(R.id.edit_text_password);

        Button enterButton = findViewById(R.id.button);
        enterButton.setOnClickListener(v -> {
            userEmail = userEmailField.getText().toString();
            userPassword = userPasswordField.getText().toString();

            boolean flag = false;

            for (int i = 0; i < 5; i++) {
                if (userEmail.equals(BaseEmails[i]) && userPassword.equals(BasePasswords[i]))
                    flag = true;
            }


            //====================
            //flag = true;
            //====================



            if (flag) {
                userEmailField.setText("");
                userPasswordField.setText("");
                startActivity(intent);
            }
        });
    }
}