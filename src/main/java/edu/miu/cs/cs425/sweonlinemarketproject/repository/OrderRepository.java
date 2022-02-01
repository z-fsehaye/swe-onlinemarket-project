package edu.miu.cs.cs425.sweonlinemarketproject.repository;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
