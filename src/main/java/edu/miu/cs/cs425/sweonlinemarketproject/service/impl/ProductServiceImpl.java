package edu.miu.cs.cs425.sweonlinemarketproject.service.impl;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Product;
import edu.miu.cs.cs425.sweonlinemarketproject.repository.ProductRepository;
import edu.miu.cs.cs425.sweonlinemarketproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductsBySellerId(long id) {
        return productRepository.findBySellerId(id);
    }

    @Override
    public List<Product> getAllProductWhichAreNotOutOfStock() {
        return null;
    }

    @Override
    public void updateProductQuantity(List<Product> productList) {

    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }
}
