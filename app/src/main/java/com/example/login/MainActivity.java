package com.example.login;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.textfield.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Apply window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find views by ID
        TextInputLayout usernameLayout = findViewById(R.id.til_username);
        TextInputLayout passwordLayout = findViewById(R.id.til_password);
        Button loginButton = findViewById(R.id.btn_login);
        TextView forgotPassword = findViewById(R.id.tv_forgot_password);
        TextView register = findViewById(R.id.tv_register);
        ImageView imageView = findViewById(R.id.imageView2);

        // Set click listener for login button
        loginButton.setOnClickListener(v -> {
            String username = Objects.requireNonNull(usernameLayout.getEditText()).getText().toString().trim();
            String password = Objects.requireNonNull(passwordLayout.getEditText()).getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
            } else {
                // Handle login logic here
                Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
            }
        });

// Inside MainActivity
        forgotPassword.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });

        register.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });


        imageView.setImageResource(R.drawable.ic_launcher_foreground);
    }
}
