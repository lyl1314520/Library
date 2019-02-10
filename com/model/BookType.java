package com.model;

public class BookType {

    private int id;// ��ı��

    private String bookTypeName;// �����������

    private String bookTypeDesc;// ��ı�ע

    public int getId() {
        return id;
    }

    public BookType(String bookTypeName, String bookTypeDesc) {
        super();
        this.bookTypeName = bookTypeName;
        this.bookTypeDesc = bookTypeDesc;
    }

    public BookType(int id, String bookTypeName, String bookTypeDesc) {
        super();
        this.id = id;
        this.bookTypeName = bookTypeName;
        this.bookTypeDesc = bookTypeDesc;
    }

    public BookType() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    public String getBookTypeDesc() {
        return bookTypeDesc;
    }

    public void setBookTypeDesc(String bookTypeDesc) {
        this.bookTypeDesc = bookTypeDesc;
    }

    @Override
    public String toString() {
        return bookTypeName;
    }

}
