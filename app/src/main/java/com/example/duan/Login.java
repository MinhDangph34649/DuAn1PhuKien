package com.example.duan;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.duan.DbHelper.DbHelper;
import com.example.duan.Screen.constumer;
import com.example.duan.Screen.manage;

public class Login extends AppCompatActivity {

    EditText etLoginUsername, etLoginPassword;
    TextView tvSignUp;
    Button btnLogin;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginUsername = findViewById(R.id.etLoginUsername);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignUp = findViewById(R.id.tvSignUp);
        dbHelper = new DbHelper(this);

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etLoginUsername.getText().toString();
                String password = etLoginPassword.getText().toString();
                String userType = dbHelper.getUserType(username, password);

                if (userType != null) {
                    if (userType.equals("admin")) { // Chú ý đây, dùng equals() thay vì endsWith()
                        Intent intent = new Intent(Login.this, manage.class);
                        startActivity(intent);
                    } else if (userType.equals("kh")) { // Tương tự như trên
                        Intent intent = new Intent(Login.this, constumer.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(Login.this, "Tên đăng nhập hoặc mật khẩu không đúng", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}