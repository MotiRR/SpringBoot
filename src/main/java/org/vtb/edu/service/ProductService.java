package org.vtb.edu.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.vtb.edu.database.dto.Product;
import org.vtb.edu.database.repository.ProductDAO;
import org.vtb.edu.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductDAO productDAO;

    public void saveOrUpdateProduct(Product product) {
        productDAO.save(product);
    }

    public Product getProductById(Long id) {
        return productDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    public void removeProductById(Long id) {
        productDAO.deleteById(id);
    }
}
