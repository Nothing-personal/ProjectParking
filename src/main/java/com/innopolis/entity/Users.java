package com.innopolis.entity;

/**
 * Created by Kevin Khanda on 21.09.2016.
 */
public class Users implements DomainObject {

    private int id;
    private String email;
    private String phone;
    private String password;

    public Users(int id, String email, String phone, String password) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
