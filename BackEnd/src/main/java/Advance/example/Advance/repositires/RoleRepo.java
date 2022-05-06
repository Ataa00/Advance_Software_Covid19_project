package Advance.example.Advance.repositires;

import Advance.example.Advance.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role,String> {


    Role getByRoleName(String customer);

    Optional<Role> findByRoleName(String roleName);
}
