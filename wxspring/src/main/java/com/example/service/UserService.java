package com.example.service;
import com.example.domin.ChangePsw;
import com.example.domin.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author zhu
 * @date 2019/9/8
 **/

public interface UserService {
    boolean login(@Param("username") String username, @Param("password") String password);
    String FindExistOrNot(String username);
    void insert(User user);
    User FindUser(String username);
    void updateUser(ChangePsw changePsw);
    List<User> getAllUser();
}

