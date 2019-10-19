package com.example.dao;

import com.example.domin.ChangePsw;
import com.example.domin.User;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author zhu
 * @date 2019/9/8
 **/
@Repository
public interface UserDao {
    List<User> getAllUser();
    User findAllUsers(User user);
    User FindExistUserOrNot(User user);
    void insert(User user);
    void updateUser(ChangePsw changePsw);

}

