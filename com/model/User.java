package com.model;
/**
 *<p>Title:
 *<p>Description:
 * @author lyl
 * @date 2019��1��26��
 */
public class User {
    
    public User() {
        super();
        // TODO Auto-generated constructor stub
    } 

    public User(String userName, String passWord) {
        super();
        this.userName = userName;
        this.passWord = passWord;
    }

    private int id;//���
    
    private String userName;//�û���
    
    private String passWord;//����

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    

}
