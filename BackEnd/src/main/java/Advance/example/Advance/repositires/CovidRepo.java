package Advance.example.Advance.repositires;

import Advance.example.Advance.Model.Country;
import Advance.example.Advance.Model.Covid;
import Advance.example.Advance.Model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CovidRepo extends JpaRepository<Covid,Integer> {
    List<Covid> findAllByLastUpdate(Date lastUpdate);

    Optional<Covid> findByCountry(Country country);

    Optional<Covid> findByState(State state);
}
