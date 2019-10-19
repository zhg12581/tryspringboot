package com.example.domin;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhu
 * @date 2019/10/16
 **/
@Component
@ConfigurationProperties(prefix = "user")
public class MyUser {
    public String name;
    public String address;

    public MyUser() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddRess() {
        return address;
    }

    public void setAddRess(String address) {
        this.address = address;
    }
}
