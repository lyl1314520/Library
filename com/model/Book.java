package com.model;

/*
 * ͼ�����
 */
public class Book {
    private int id;// ͼ��id
    private String bookName;// ����
    private String bookAuthor;// ����
    private float bookPrice;//
    private String sex;// �����Ա�
    private Integer bookId;//������id;
    
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