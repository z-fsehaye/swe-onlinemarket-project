package edu.miu.cs.cs425.sweonlinemarketproject.repository;

import edu.miu.cs.cs425.sweonlinemarketproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //Optional<User> findByUsername(String username);
}
