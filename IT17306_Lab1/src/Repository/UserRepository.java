/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.User;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUYVU
 */
public class UserRepository {
    DBConnection dbConnection;
    ResultSet rs = null; // Hung nhung ket qua do sql server tra ve
    Statement st = null; // Tao ra cac cau lenh tuong tac voi sql server
    User user = null;
    
    public UserRepository() {
        dbConnection = new DBConnection();
    }
    
    public User getUserByName(String userName, String password) {
        String select = "SELECT * FROM MANAGE_USER WHERE USERNAME = '"+userName+"' "
                + "AND PASSWORD = '"+password+"'";
        try {
            st = dbConnection.openDbConnection().createStatement(); // tao cau lenh
            rs = st.executeQuery(select); // Thuc thi cau lenh
            while (rs.next()) {
                user = new User(rs.getString(2), rs.getString(3),rs.getString(4));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
