/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.User;
import Repository.UserRepository;

/**
 *
 * @author THUYVU
 */
public class UserService {
    UserRepository userRepository = new UserRepository();

    public UserService() {
    }
    
    // Kiem tra user co ton tai hay khong
    public User checkUserExited(String userName, String password) {
        return userRepository.getUserByName(userName, password);
    }
}
