package Advance.example.Advance.repositires;

import Advance.example.Advance.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> getByUserName(String userName);

    Optional<User> getByEmail(String email);
}