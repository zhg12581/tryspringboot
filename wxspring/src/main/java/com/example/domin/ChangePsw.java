package com.example.domin;

/**
 * @author zhu
 * @date 2019/9/13
 **/
public class ChangePsw {
    public String username;
    public String oldpassword;
    public String newpassword;

    public ChangePsw(String username,String oldpassword, String newpassword){ //需要写上这个构造函数，否则会报NoSuchMethodException
        this.username = username;
        this.oldpassword = oldpassword;
        this.newpassword = newpassword;
    }

    public ChangePsw() {
        super();
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getoldpassword() {
        return oldpassword;
    }

    public void setoldPassWord(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getnewpassword() {
        return newpassword;
    }

    public void setnewPassWord(String newpassword) {
        this.newpassword = newpassword;
    }
}
