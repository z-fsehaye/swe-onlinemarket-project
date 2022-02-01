package edu.miu.cs.cs425.sweonlinemarketproject.repository;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Product;
import edu.miu.cs.cs425.sweonlinemarketproject.model.ShoppingCart;
import edu.miu.cs.cs425.sweonlinemarketproject.service.ShoppingCartService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {


//   Product addProductToShoppingCart(Product product);
//
//    ShoppingCartService addShoppingCart(ShoppingCartService shoppingCart);
}
