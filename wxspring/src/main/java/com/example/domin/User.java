package com.example.domin;

/**
 * @author zhu
 * @date 2019/9/8
 **/

public class User {

    public int id;
    public String username;
    public String password;


    public User(int id, String username, String password){ //需要写上这个构造函数，否则会报NoSuchMethodException
       this.id = id;
        this.username = username;
        this.password = password;
    }

    public User() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getpassword() {
        return password;
    }

    public void setPassWord(String password) {
        this.password = password;
    }


}
