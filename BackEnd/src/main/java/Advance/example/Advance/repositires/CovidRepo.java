package Advance.example.Advance.repositires;

import Advance.example.Advance.Model.Country;
import Advance.example.Advance.Model.Covid;
<<<<<<< HEAD
=======
import Advance.example.Advance.Model.State;
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CovidRepo extends JpaRepository<Covid,Integer> {
<<<<<<< HEAD
    //List<Covid> findAllByLastUpdate(Date lastUpdate);

    Optional<Covid> findByCountry(Country country);

    List<Covid> findAllByDateReported(Date dateReported);

    List<Covid> findAllByCountry(Country country);

    List<Covid> findAllByCountryAndDateReported(Country country, Date dateReported);

    //Optional<Covid> findByState(State state);
=======
    List<Covid> findAllByLastUpdate(Date lastUpdate);

    Optional<Covid> findByCountry(Country country);

    Optional<Covid> findByState(State state);
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
}
