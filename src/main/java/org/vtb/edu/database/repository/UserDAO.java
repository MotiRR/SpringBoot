package org.vtb.edu.database.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vtb.edu.database.dto.Product;
import org.vtb.edu.database.dto.User;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
}
