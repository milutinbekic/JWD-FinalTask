package ftn.jwd.repository;

import ftn.jwd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByUserName(String UserName);

    Optional<User> findFirstByUserNameAndPassword(String UserName,String password);
}
