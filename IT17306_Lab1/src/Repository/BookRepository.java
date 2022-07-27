/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThuyVT
 */
public class BookRepository {
    DBConnection dbConnection;
    ResultSet rs = null;
    Statement st = null;
    List<Book> listBook = new ArrayList<>();
    
    public BookRepository() {
    }
    
    public List<Book> getListBook() {
        String select = "SELECT B.ID, B.NAME, B.AUTHOR, BC.NAME FROM BOOK B " +
        "INNER JOIN BOOK_CATEGORY BC ON B.CATEGORY = BC.CODE";
        
        try {
            st = dbConnection.openDbConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                listBook.add(new Book(rs.getInt(1), rs.getNString(2),
                        rs.getNString(3), rs.getNString(4)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBook;
        
    }
    
    public String insertToDB(Book book) {
        try {
            st = dbConnection.openDbConnection().createStatement();
            String insert = "INSERT INTO BOOK (NAME, AUTHOR,CATEGORY)"
                    + " VALUES (N'"+book.getName()+"', N'"+book.getAuthor()+"', "
                    + "'"+book.getCategory()+"')";
            st.executeUpdate(insert);
            return "Thêm du lieu thanh công";
        } catch (SQLException ex) {
            Logger.getLogger(BookRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Thêm du lieu that bai";
        }
    }
    
    public String updateToDB(Book book) {
        try {
            st = dbConnection.openDbConnection().createStatement();
            String update = "UPDATE BOOK SET NAME = N'"+ book.getName()+"', AUTHOR = N'"+book.getAuthor()+"' WHERE ID =" + book.getId();
            st.executeUpdate(update);
            return "Sua du lieu thanh công";
        } catch (SQLException ex) {
            Logger.getLogger(BookRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Sua du lieu that bai";
        }        
    }
    
    public String deleteToDb(Book book) {
      try {
            st = dbConnection.openDbConnection().createStatement();
            String update = "DELETE FROM BOOK WHERE ID =" + book.getId();
            st.executeUpdate(update);
            return "Xoa du lieu thanh công";
        } catch (SQLException ex) {
            Logger.getLogger(BookRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Xoa du lieu that bai";
        }      
    
    }
    
    // KIEM TRA ID SACH DA TON TAI HAY CHUA
    public int getIndexBook(int Id) {
        for (int i = 0; i < listBook.size(); i++) {
            if (listBook.get(i).getId() == Id) {
                return i;
            }
        }
        
        return -3;
    }    
}
