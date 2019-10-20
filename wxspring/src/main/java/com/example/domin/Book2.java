package com.example.domin;

/**
 * @author zhu
 * @date 2019/10/19
 **/
public class Book2 {
    private String name;
    private Float price;

    public Book2(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
