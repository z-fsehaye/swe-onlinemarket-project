package edu.miu.cs.cs425.sweonlinemarketproject.repository;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
