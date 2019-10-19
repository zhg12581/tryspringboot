package com.example.controller;

import com.example.domin.Book;
import com.example.domin.ChangePsw;
import com.example.domin.MyUser;
import com.example.domin.User;
import com.example.exception.BusinessException;
import com.example.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * @author zhu
 * @date 2019/9/8
 **/
@RestController
@RequestMapping(value = "/CRUD", method = { RequestMethod.GET, RequestMethod.POST })
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    MyUser myuser;

    @PostMapping(value = "/login")
    public boolean login(@Param("username") String username,
                         @Param("password") String password) {
        System.out.println("微信小程序调用接口！！！用户名:" + username + "密码:" + password);
        boolean login = userService.login(username, password);
        System.out.println(login);
        if (login) {
            return true;
        }
        return false;
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody User user) {
        System.out.println("微信小程序注册！！！用户名:" + user.username);
        String find = userService.FindExistOrNot(user.username);
        System.out.println(find);
        if (find == "该账号已经存在") {
           return "该账号已经存在";
        } else {
            userService.insert(user);
            return "注册成功";

        }

    }



    @PostMapping(value = "/changepsw")
    public String changepsw(@RequestBody ChangePsw changePsw) {
        String find = userService.FindExistOrNot(changePsw.username);
        System.out.println(find);
        if (find == "该账号已经存在") {
            System.out.println(userService.FindUser(changePsw.username).password);
            if(changePsw.oldpassword.equals(userService.FindUser(changePsw.username).password))
            {
                userService.updateUser(changePsw);
                return "修改成功";
            }
            else{
                return "原密码不正确";
            }
        } else {
            return find;
        }

    }

    @GetMapping(value = "/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

//@Param("username")String username,@Param("password")String password
    @PostMapping(value = "/user")
    public boolean user(@RequestBody User user) {

        String username2=user.username;
        String password2=user.password;
        System.out.println("微信小程序调用接口！！！用户名:" + username2 + "密码:" + password2);
        return true;

    }

    @GetMapping(value = "/getmyuser")
    public String getmyuser(){
        return myuser.name;
    }

    @GetMapping(value = "/books")
    public ModelAndView getbooks(){
        List<Book>books=new ArrayList<>();
        Book b1=new Book();
        b1.setId(1);
        b1.setAuthor("罗");
        b1.setBookName("三国");
        books.add(b1);
        ModelAndView mv=new ModelAndView();
        mv.addObject("books",books);
        mv.setViewName("books");
        return mv;
    }

    @PostMapping("/upload")
    public String upload(MultipartFile[] uploadFile)throws Exception{
       // String realPath="E:/ccc/";
        String realPath= ResourceUtils.getURL("classpath:").getPath()+"/static/";
        //如果目录不存在，自动创建文件夹
        File folder=new File(realPath);
        if(!folder.isDirectory()){
            folder.mkdirs();
        }
        for(int i=0;i<uploadFile.length;i++) {
            if(uploadFile[i]!=null)
            {
                String oldName=uploadFile[i].getOriginalFilename();
                File serverFile=new File(realPath+oldName);
                uploadFile[i].transferTo(serverFile);
            }
        }
        return  "上传成功";
    }

    private String msg;
    @RequestMapping("/Exception1")
    public String Exception1() {
        int num = 1/0;
        return msg;
    }

    @GetMapping("/CustomException")
    public String CustomException() {
        List<String> list = new ArrayList<>();
        return list.get(2);
    }


    @RequestMapping("/CustomException2")
    public String CustomException2() {
        //int num = 1/0;
        throw new BusinessException("100","密码错误");
        //return this.msg;
    }


}
