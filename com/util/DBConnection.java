package com.util;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *<p>Title:数据库连接
 *<p>Description:
 * @author lyl
 * @date 2019年1月25日
 */
public class DBConnection {
    
    private String dbUtl = "jdbc:mysql://localhost:3306/book";//连接数据库Library
    
    private String dbUserName = "root";//数据库用户名
    
    private String dbPassWord = "root";//数据库密码
    
    private String jdbcName = "com.mysql.jdbc.Driver";//驱动名称
    /**
     *  打开数据库连接
     * @return
     * @throws Exception
     */
    public Connection getCon()throws Exception {
        
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(dbUtl,dbUserName, dbPassWord);
        return con;      
    }
    
    /**
     * 关闭数据库连接
     * @param con
     * @throws Exception
     */
    public void closeCon(Connection con)throws Exception{//null表示数据库是关闭的，如果不判断，数据库又是关闭的，则是产生空指针异常
        if(con!=null){
            con.close();
        }
    }
    
    
    public static void main(String[] args) {
        
        DBConnection dbul = new DBConnection();
       
        try {
            dbul.getCon();
            System.out.println("数据库连接成功");
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("数据库连接失败");
            
        }
        
    }

}
