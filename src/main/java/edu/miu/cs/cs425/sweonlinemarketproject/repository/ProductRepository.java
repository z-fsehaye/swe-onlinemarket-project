package edu.miu.cs.cs425.sweonlinemarketproject.repository;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p from Product p where p.seller.userId = :id")
    List<Product> findBySellerId(long id);

    @Query(value = "select p from Product p where p.quantity > 0")
    List<Product> findNotOutOfStockProducts();
}
