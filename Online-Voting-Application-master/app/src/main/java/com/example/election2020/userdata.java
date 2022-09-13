package com.example.election2020;

public class userdata {
    private String email, full, user, age, phn;

    public userdata() {
    }

    public userdata(String email, String full, String user, String age, String phn) {
        this.email = email;
        this.full = full;
        this.user = user;
        this.age = age;
        this.phn = phn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }
}
