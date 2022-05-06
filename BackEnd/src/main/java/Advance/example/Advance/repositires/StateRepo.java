package Advance.example.Advance.repositires;

import Advance.example.Advance.Model.Country;
import Advance.example.Advance.Model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface StateRepo extends JpaRepository<State,Integer> {
    List<State> findAllByCountry(Country country);
}
