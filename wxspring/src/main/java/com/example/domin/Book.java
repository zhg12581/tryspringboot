package com.example.domin;

/**
 * @author zhu
 * @date 2019/10/16
 **/
public class Book {
    public Integer id;
    public String bookname;
    public String author;

    public Book() {
        super();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookname;
    }

    public void setBookName(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String address) {
        this.author = address;
    }
}
