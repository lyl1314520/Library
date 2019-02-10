package com.util;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *<p>Title:���ݿ�����
 *<p>Description:
 * @author lyl
 * @date 2019��1��25��
 */
public class DBConnection {
    
    private String dbUtl = "jdbc:mysql://localhost:3306/book";//�������ݿ�Library
    
    private String dbUserName = "root";//���ݿ��û���
    
    private String dbPassWord = "root";//���ݿ�����
    
    private String jdbcName = "com.mysql.jdbc.Driver";//��������
    /**
     *  �����ݿ�����
     * @return
     * @throws Exception
     */
    public Connection getCon()throws Exception {
        
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(dbUtl,dbUserName, dbPassWord);
        return con;      
    }
    
    /**
     * �ر����ݿ�����
     * @param con
     * @throws Exception
     */
    public void closeCon(Connection con)throws Exception{//null��ʾ���ݿ��ǹرյģ�������жϣ����ݿ����ǹرյģ����ǲ�����ָ���쳣
        if(con!=null){
            con.close();
        }
    }
    
    
    public static void main(String[] args) {
        
        DBConnection dbul = new DBConnection();
       
        try {
            dbul.getCon();
            System.out.println("���ݿ����ӳɹ�");
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("���ݿ�����ʧ��");
            
        }
        
    }

}
