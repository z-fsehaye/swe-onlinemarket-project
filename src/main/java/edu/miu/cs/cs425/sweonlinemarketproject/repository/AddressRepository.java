package edu.miu.cs.cs425.sweonlinemarketproject.repository;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Address;
import edu.miu.cs.cs425.sweonlinemarketproject.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

//    List<Address> findAllByBuyer(RoleType buyer);
}
