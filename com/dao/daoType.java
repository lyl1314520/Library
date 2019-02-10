package com.dao;

import com.model.BookType;
import com.util.StringUtil;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class daoType {

    /*
     * 往数据库中t_book表添加数据
     */
    public int add(Connection con, BookType bookType) throws Exception {
        String sql = "insert into t_book values(null,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, bookType.getBookTypeName());
        pst.setString(2, bookType.getBookTypeDesc());

        return pst.executeUpdate();
    }

    /*
     * 查询图书类别
     */
    public ResultSet list(Connection con, BookType booktype) throws Exception {
        StringBuffer sb = new StringBuffer("select * from t_book");
        if (StringUtil.isNotEmpty(booktype.getBookTypeName())) {
            sb.append(" and bookTypeName like '%" + booktype.getBookTypeName() + "%'");
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
        return pstmt.executeQuery();
    }

    /*
     * 根据图书id删除进行删除操作
     */
    public int delete(Connection con, String id) throws Exception {
        String sql = "delete from t_book where id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, id);
        return pst.executeUpdate();
    }

    /*
     * 更新图书类别
     */
    public int update(Connection con, BookType booktype) throws Exception {
        String sql = "update t_book set bookTypeName=?,bookTypeDesc=? where id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, booktype.getBookTypeName());
        pst.setString(2, booktype.getBookTypeDesc());
        pst.setInt(3, booktype.getId());
        return pst.executeUpdate();
    }
}
