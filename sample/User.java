package sample;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String surname;
    private String phonenumber;
    private String username;
    private String paswword;


    public User(String name, String surname, String phonenumber, String username, String paswword) {
        this.name = name;
        this.surname = surname;
        this.phonenumber = phonenumber;
        this.username = username;
        this.paswword = paswword;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPaswword() {
        return paswword;
    }

    public void setPaswword(String paswword) {
        this.paswword = paswword;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", username='" + username + '\'' +
                ", paswword='" + paswword + '\'' +
                '}';
    }
}

