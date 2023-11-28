package com.example.asm21_nhom4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView btnLoginAc = findViewById(R.id.btnLoginAc);
        Button btnRegister = findViewById(R.id.btnRegister);
        EditText txtUsername, txtEmail, txtPassword, txtComfirmPassword;
        txtUsername = findViewById(R.id.txtUsername);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        txtComfirmPassword = findViewById(R.id.txtConfirmPassword);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (txtUsername.getText().toString().length() == 0 || txtEmail.getText().toString().length() == 0) {
                        Toast.makeText(Activity_Register.this, "Username hoặc password không được để trống", Toast.LENGTH_LONG).show();
                    } else if (!txtPassword.getText().toString().equals(txtComfirmPassword.getText().toString())) {
                        throw new Exception("Xác nhận Password không giống nhau");
                    }
                    Users newUser = new Users(txtUsername.getText().toString(), txtEmail.getText().toString(), txtPassword.getText().toString());
                    for (Users u : Users.listUser) {
                        if (u.Username.toString().equals(newUser.Username.toString()) || u.Email.toString().equals(newUser.Email.toString())) {
                          //  throw new Exception("User hoặc Email đăng ký đã tồn tại");
                            Toast.makeText(Activity_Register.this, "User hoặc Email đăng ký đã tồn tại", Toast.LENGTH_LONG).show();
                        }
                        Users.listUser.add(newUser);
                        Toast.makeText(Activity_Register.this, "Đăng kí thành công", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception ex) {
                    new AlertDialog.Builder(Activity_Register.this).setMessage(ex.getMessage()).setPositiveButton("OK", null).show();
                }
            }
        });
        btnLoginAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}