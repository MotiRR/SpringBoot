package org.vtb.edu.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vtb.edu.database.dto.Product;
import org.vtb.edu.database.dto.User;
import org.vtb.edu.database.repository.ProductDAO;
import org.vtb.edu.database.repository.UserDAO;
import org.vtb.edu.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserDAO userDAO;

    public void saveOrUpdateUser(User user) {
        userDAO.save(user);
    }

    public User getUserById(Long id) {

        return userDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public void removeUserById(Long id) {
        userDAO.deleteById(id);
    }
}
