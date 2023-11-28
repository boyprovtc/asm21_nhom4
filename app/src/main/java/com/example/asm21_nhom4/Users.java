package com.example.asm21_nhom4;

import java.util.ArrayList;
import java.util.List;

public class Users {
    public  static List<Users> listUser = new ArrayList<Users>();
    public String Username;
    public String Email;
    public String Password;

    public Users(String username, String email, String password){
        Username=username;
        Email=email;
        Password=password;
    }
}
