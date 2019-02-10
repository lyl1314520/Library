package com.model;

/*
 * 图书添加
 */
public class Book {
    private int id;// 图书id
    private String bookName;// 书名
    private String bookAuthor;// 作者
    private float bookPrice;//
    private String sex;// 作者性别
    private Integer bookId;//书的类别id;
    
    public int getId() {
        return id;
    }

    public Book() {
        super();
        // TODO Auto-generated constructor stub
    }
    
 
    public void setId(int id) {
        this.id = id;
    }

    public Book(String bookName, String bookAuthor, Integer bookId) {
        super();
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Book(int id,String bookName, String bookAuthor, float bookPrice, String sex, Integer bookId) {
        super();
        this.id = id;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.sex = sex;
        this.bookId = bookId;
    }

    public Book(String bookName, String bookAuthor, float bookPrice, String sex, Integer bookId) {
        super();
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.sex = sex;
        this.bookId = bookId;
    }
}