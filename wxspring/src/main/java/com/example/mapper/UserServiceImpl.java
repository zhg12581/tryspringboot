package com.example.mapper;

import com.example.dao.UserDao;
import com.example.domin.ChangePsw;
import com.example.domin.User;
import com.example.service.UserService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhu
 * @date 2019/9/8
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

    @Override
    public boolean login(String username,String password){
        User user = new User();
        user.setUserName(username);
        user.setPassWord(password);
        User allUsers = userDao.findAllUsers(user);
        if (allUsers != null){
            return true;
        }
        return false;
    }
    @Override
    public String FindExistOrNot(String username){
        User user = new User();
        user.setUserName(username);
        User allUsers = userDao.FindExistUserOrNot(user);
        System.out.println(allUsers);
        if (allUsers != null){
            return "该账号已经存在";
        }
        else{
            return "该账号不存在";
        }
    }

    @Override
    @CachePut(value="user",key ="'hello2'")
    public void insert(User user){
        userDao.insert(user);
    }

    @Override
    public User FindUser(String username){
        User user = new User();
        user.setUserName(username);
        User user2 = userDao.FindExistUserOrNot(user);
        return user2;
    }

    @Override

    public void updateUser(ChangePsw changePsw){
        userDao.updateUser(changePsw);
    }

    @Cacheable(value = "user",key = "#root.targetClass")
    @Override
    public List<User> getAllUser() {
        System.out.println("=====================缓存中查找失败，从数据库中获取");
        return userDao.getAllUser();
    }


}
