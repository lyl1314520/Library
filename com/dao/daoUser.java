package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.model.User;

/**
 * Title:�û�dao��
 * Description:ʵ�ֵ�¼����
 * @author lyl
 * @date 2019��1��26��
 */
public class daoUser {

    // �����û���������Ϣ���û����Լ�����
    public User login(Connection con,User user)throws Exception{
        User resultUser=null;
        String sql="select * from t_user where userName=? and password=?";
        PreparedStatement pstmt=con.prepareStatement(sql);//����һ�� PreparedStatement ���������������� SQL ��䷢�͵����ݿ�
        pstmt.setString(1, user.getUserName());
        //System.out.println(pstmt.getMetaData());
        pstmt.setString(2, user.getPassWord());
        ResultSet rs=pstmt.executeQuery();//ִ��SQL��ѯ���������ɵ� ResultSet����
        int count = 0;
        //rs.next()������⣬����һ���Ա�Ϊfalse,ֱ�ӷ���false,��������Աȣ�ֱ������false��������ȫ���Ա��궼һ�·���true
        while(rs.next()){//�����ӵ�ǰλ����ǰ��һ�С���Frame����������������ݿ��е����ݽ��жԱȣ���ͬ����true,��ͬ����false
            System.out.println("ִ����"+(++count)+"��");
            resultUser = new User();
            /*resultUser.setId(rs.getInt("id"));
            resultUser.setUserName(rs.getString("userName"));
            resultUser.setPassWord(rs.getString("password"));*/
        }
        return resultUser;
    }
}
