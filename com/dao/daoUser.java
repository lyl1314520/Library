package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.model.User;

/**
 * Title:用户dao类
 * Description:实现登录功能
 * @author lyl
 * @date 2019年1月26日
 */
public class daoUser {

    // 返回用户的所有信息，用户名以及密码
    public User login(Connection con,User user)throws Exception{
        User resultUser=null;
        String sql="select * from t_user where userName=? and password=?";
        PreparedStatement pstmt=con.prepareStatement(sql);//创建一个 PreparedStatement 对象来将参数化的 SQL 语句发送到数据库
        pstmt.setString(1, user.getUserName());
        //System.out.println(pstmt.getMetaData());
        pstmt.setString(2, user.getPassWord());
        ResultSet rs=pstmt.executeQuery();//执行SQL查询。返回生成的 ResultSet对象
        int count = 0;
        //rs.next()方法理解，若第一个对比为false,直接返回false,否则继续对比，直到返回false结束或者全部对比完都一致返回true
        while(rs.next()){//将光标从当前位置向前移一行。从Frame里输入的数据与数据库中的数据进行对比，相同返回true,不同返回false
            System.out.println("执行了"+(++count)+"次");
            resultUser = new User();
            /*resultUser.setId(rs.getInt("id"));
            resultUser.setUserName(rs.getString("userName"));
            resultUser.setPassWord(rs.getString("password"));*/
        }
        return resultUser;
    }
}
