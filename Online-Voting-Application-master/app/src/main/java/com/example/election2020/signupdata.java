package com.example.election2020;

public class signupdata
{
    String fullname;
    String username;
    String emailid;
    String password;
    String phoneno;

    public signupdata(String fullname, String username, String emailid, String password, String phoneno) {
        this.fullname = fullname;
        this.username = username;
        this.emailid = emailid;
        this.password = password;
        this.phoneno = phoneno;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
}