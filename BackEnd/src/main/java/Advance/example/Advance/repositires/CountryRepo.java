package Advance.example.Advance.repositires;

import Advance.example.Advance.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
<<<<<<< HEAD
public interface CountryRepo extends JpaRepository<Country,String> {
    Optional<Country> getByName(String name);


=======
public interface CountryRepo extends JpaRepository<Country,Integer> {
    Optional<Country> getByName(String name);

>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
}