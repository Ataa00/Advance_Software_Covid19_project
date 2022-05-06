package Advance.example.Advance.repositires;

import Advance.example.Advance.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.util.Optional;

=======
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
@Repository
public interface RoleRepo extends JpaRepository<Role,String> {


    Role getByRoleName(String customer);
<<<<<<< HEAD

    Optional<Role> findByRoleName(String roleName);
=======
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
}
