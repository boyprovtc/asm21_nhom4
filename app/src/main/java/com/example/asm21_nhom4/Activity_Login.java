package com.example.asm21_nhom4;

import static com.example.asm21_nhom4.Activity_Register.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText txtUsername, txtPassword;
        txtUsername = findViewById(R.id.txtLoginUsername);
        txtPassword = findViewById(R.id.txtLoginPassword);
        Button btnRegisterAc = findViewById(R.id.btnRegisterActivity);
        Button btnLogin = findViewById(R.id.btnLogin);
        btnRegisterAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Login.this, Activity_Register.class));
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (txtUsername.getText().toString().length() == 0 || txtPassword.getText().toString().length() == 0) {
                        Toast.makeText(Activity_Login.this, "Username hoặc password không được để trống", Toast.LENGTH_LONG).show();
                    }

                    LoginUsers currentuser = new LoginUsers(txtUsername.getText().toString(), txtPassword.getText().toString());

                    for (Users u : Users.listUser ) {
                        if (!u.Username.equals(currentuser.Username) || !u.Password.equals(currentuser.Password)) {
                            //throw new Exception("Đăng nhập thành công");
                            Toast.makeText(Activity_Login.this, "Username hoặc password không đúng", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Activity_Login.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();

                        }
                    }


                } catch (Exception ex) {
                    new AlertDialog.Builder(Activity_Login.this).setMessage(ex.getMessage()).setPositiveButton("OK", null).show();
                }
            }
        });
    }

}