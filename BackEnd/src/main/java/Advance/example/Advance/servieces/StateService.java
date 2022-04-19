package Advance.example.Advance.servieces;

import Advance.example.Advance.Model.Country;
import Advance.example.Advance.Model.State;
import Advance.example.Advance.repositires.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    private final StateRepo stateRepo;
    private final CountryService countryService;
    private final CovidService covidService;
    @Autowired
    public StateService(StateRepo stateRepo, CountryService countryService, CovidService covidService) {
        this.stateRepo = stateRepo;
        this.countryService = countryService;
        this.covidService = covidService;
    }

    public List<State> getAll() {
        return stateRepo.findAll();
    }

    public State getById(Integer id) {
        Optional<State>state=stateRepo.findById(id);
        if(!state.isPresent()){
            throw new IllegalStateException("state not found");
        }
        return state.get();
    }

    public List<State> getByCountry(Integer countryId) {
        Country country=countryService.getById(countryId);
        return stateRepo.findAllByCountry(country);
    }

    public void addState(Integer countryId, State state) {
        Country country=countryService.getById(countryId);
        covidService.addCovid(state.getCovid());
        state.setCountry(country);
        stateRepo.save(state);

    }
    @Transactional
    public void update(Integer id,String postalCode, String name) {
        State state=getById(id);
        if(postalCode!=null&& postalCode.length()>0){
            state.setPostalCode(postalCode);
        }
        if(name!=null&& name.length()>0){
            state.setName(name);
        }

    }
}
