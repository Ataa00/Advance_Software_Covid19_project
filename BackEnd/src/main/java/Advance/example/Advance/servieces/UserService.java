package Advance.example.Advance.servieces;

<<<<<<< HEAD
import Advance.example.Advance.Model.Role;
import Advance.example.Advance.Model.User;
import Advance.example.Advance.repositires.RoleRepo;
import Advance.example.Advance.repositires.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

=======
import Advance.example.Advance.Model.User;
import Advance.example.Advance.repositires.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;
<<<<<<< HEAD
    private final RoleRepo roleRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
=======
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUserByUserName(String userName) {
        if(userRepo.getByUserName(userName).isEmpty()){
            throw new IllegalStateException("user not found");

        }
        return userRepo.getByUserName(userName).get();
    }

    public void addUser(User user) {
        Optional<User> userByUserName = userRepo.getByUserName(user.getUserName());
        Optional<User> userByEmail = userRepo.getByEmail(user.getEmail());
        if(userByEmail.isPresent() ){
            throw new IllegalStateException("this email has been used before");
        }

        if( userByUserName.isPresent()){
            throw new IllegalStateException("this username has been used before");
        }
<<<<<<< HEAD
        Optional<Role> role = roleRepo.findByRoleName(user.getRole().getRoleName());
        if(!role.isPresent()){
            throw new IllegalStateException("there is no role with this name");
        }
        user.setRole(role.get());
        user.setPassword(getEncodedPassword(user.getPassword()));
=======
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
        userRepo.save(user);
    }

    public void deleteByUserName(String userName) {
        Optional<User> user=userRepo.getByUserName(userName);
        if(user.isPresent()){
            userRepo.delete(user.get());

        }else{
            throw new IllegalStateException("User not found");

        }
    }
    @Transactional
    public void updateUser(String userName, String firstName, String lastName,
                           String email, String password, String userName1, Integer role) {
        Optional<User>user=userRepo.getByUserName(userName);
        if(user.isPresent()){
            if(userRepo.getByUserName(userName1).isPresent() ){
                throw new IllegalStateException("User name have been used before");
            }
            if(userRepo.getByEmail(email).isPresent()){
                throw new IllegalStateException("Email have been used before");
            }

            User user1=user.get();

            if(userName1!=null &&
                    userName1.length()>0&&
                    !Objects.equals(user1.getUserName(),userName1)){
                user1.setUserName(userName1);
            }
            if(email!=null &&
                    email.length()>0&&
                    !Objects.equals(user1.getEmail(),email)){
                user1.setEmail(email);
            }
            if(firstName!=null &&
                    firstName.length()>0&&
                    !Objects.equals(user1.getFirstName(),firstName)){
                user1.setFirstName(firstName);
            }
            if(lastName!=null &&
                    lastName.length()>0&&
                    !Objects.equals(user1.getLastName(),lastName)){
                user1.setLastName(lastName);
            }
            if(password!=null &&
                    password.length()>0&&
                    !Objects.equals(user1.getPassword(),password)){
                user1.setPassword(password);
            }


        }
    }
}
