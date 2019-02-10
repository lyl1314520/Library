package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.model.Book;
import com.model.BookType;
import com.util.StringUtil;
import java.sql.Connection;

public class daoBook {
    /*
     * 添加书籍
     */
    public int add(Connection con, Book book) throws Exception {
        String sql = "insert into t_add values(null,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, book.getBookName());
        pst.setString(2, book.getBookAuthor());
        pst.setFloat(3, book.getBookPrice());
        pst.setString(4, book.getSex());
        pst.setInt(5, book.getBookId());
        return pst.executeUpdate();
    }

    /*
     * 图书查询
     */
    public ResultSet list(Connection con, Book book) throws Exception {
        StringBuffer sb = new StringBuffer("select * from t_add b,t_book bt where b.bookId=bt.id");
        if (StringUtil.isNotEmpty(book.getBookName())) {
            sb.append(" and b.bookName like '%" + book.getBookName() + "%'");
        }
        if (StringUtil.isNotEmpty(book.getBookAuthor())) {
            sb.append(" and b.bookAuthor like '%" + book.getBookAuthor() + "%'");
        }
        if (book.getBookId() != null && book.getBookId() != -1) {
            sb.append(" and b.bookId=" + book.getBookId());
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        return pstmt.executeQuery();
    }

    /*
     * 删除操作
     * 
     */
    public int delete(Connection con, String id) throws Exception {
        String sql = "delete from t_add where id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, id);
        return pst.executeUpdate();
    }

    /*
     * 修改图书
     */
    public int update(Connection con, Book book) throws Exception {
        String sql="update t_add set bookName=?,bookAuthor=?,bookPrice=?,sex=?,bookId=? where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, book.getBookName());
        pstmt.setString(2, book.getBookAuthor());
        pstmt.setFloat(3, book.getBookPrice());
        pstmt.setString(4, book.getSex());
        pstmt.setInt(5, book.getBookId());
        pstmt.setInt(6, book.getId());
        return pstmt.executeUpdate();
    }

}
