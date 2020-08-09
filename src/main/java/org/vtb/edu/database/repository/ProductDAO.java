package org.vtb.edu.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vtb.edu.database.dto.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

}
