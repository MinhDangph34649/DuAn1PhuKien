package com.example.duan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button registerButton = findViewById(R.id.btnRegister);
        Button btnBack = findViewById(R.id.btnGoBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRegisterClick(view);
            }
        });
    }

    public void onRegisterClick(View view) {
        EditText usernameEt = findViewById(R.id.etRegisterUsername);
        EditText passwordEt = findViewById(R.id.etRegisterPassword);
        EditText emailEt = findViewById(R.id.etRegisterEmail);
        EditText phoneEt = findViewById(R.id.etRegisterPhone);

        String username = usernameEt.getText().toString().trim();
        String password = passwordEt.getText().toString().trim();
        String email = emailEt.getText().toString().trim();
        String phone = phoneEt.getText().toString().trim();

        // Validation logic
        if (!username.endsWith(".kh")) {
            Toast.makeText(this, "Tên tài khoản phải kết thúc bằng .kh", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length() < 6) {
            Toast.makeText(this, "Mật khẩu phải có ít nhất 6 ký tự", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            Toast.makeText(this, "Email không hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!phone.matches("\\d{10}")) {
            Toast.makeText(this, "Số điện thoại phải có 10 chữ số", Toast.LENGTH_SHORT).show();
            return;
        }

        // If all validations are passed
        Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
    }
}