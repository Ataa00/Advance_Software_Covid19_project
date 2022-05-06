package Advance.example.Advance.servieces;

import Advance.example.Advance.Model.Country;
import Advance.example.Advance.Model.Covid;
<<<<<<< HEAD
import Advance.example.Advance.repositires.CountryRepo;
=======
import Advance.example.Advance.Model.State;
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
import Advance.example.Advance.repositires.CovidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
<<<<<<< HEAD
import java.util.Set;
=======
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98

@Service
public class CovidService {
    private final CovidRepo covidRepo;
    private final CountryService countryService;
<<<<<<< HEAD
    private final CountryRepo countryRepo;

    @Autowired
    public CovidService(CovidRepo covidRepo, CountryService countryService, CountryRepo countryRepo) {
        this.covidRepo = covidRepo;
        this.countryService = countryService;


        this.countryRepo = countryRepo;
=======
    private final StateService stateService;
    @Autowired
    public CovidService(CovidRepo covidRepo, CountryService countryService, StateService stateService) {
        this.covidRepo = covidRepo;
        this.countryService = countryService;

        this.stateService = stateService;
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
    }

    public List<Covid> getCovid() {
        return covidRepo.findAll();
    }
    public Covid getById(Integer id) {
        if(!covidRepo.findById(id).isPresent()){
            throw new IllegalStateException("this covid not Found");
        }
        return covidRepo.findById(id).get();
    }
    public void deleteById(Integer id) {
        Optional<Covid> covid=covidRepo.findById(id);
        if(!covid.isPresent()){
            throw new IllegalStateException("covid not found ");
        }
        covidRepo.deleteById(id);

    }
<<<<<<< HEAD
    /*public void addAllCovidRecords(Set<Covid> covidSet){
        for(Covid covid:covidSet){
            Optional<Country>country=countryRepo.findByPostalCode(covid.getCountry().getPostalCode());
            if(!country.isPresent()){
                countryRepo.save(covid.getCountry());

            }
            country=countryRepo.findByPostalCode(covid.getCountry().getPostalCode());
            covid.setCountry(country.get());
            covidRepo.save(covid);

        }



    }*/
    public void addCovid(Covid covid) {
        Country country=countryService.getById(covid.getCountry().getId());

        covidRepo.save(covid);

    }


    public List<Covid> getCovidByCountry(String countryId) {
        Country country= countryService.getById(countryId);

        return covidRepo.findAllByCountry(country);
    }

    /*@Transactional
    public void updateCovidByCountry(String countryId, Date dateReported,
                                    Integer cumulativeDeaths, Integer cumulativeCases,
                                    Integer newDeaths, Integer newCases) {
        Covid covid = getCovidByCountry(countryId);
        if (dateReported != null &&
                !Objects.equals(covid.getDateReported(), dateReported)) {
            covid.setDateReported(dateReported);
        }
        if (cumulativeCases != null &&
                !Objects.equals(covid.getCumulativeCases(), cumulativeCases)) {
            covid.setCumulativeCases(cumulativeCases);
        }
        if (newDeaths != null &&
                !Objects.equals(covid.getNewDeaths(), newDeaths)) {
            covid.setNewDeaths(newDeaths);
        }
        if (cumulativeDeaths != null &&
                !Objects.equals(covid.getCumulativeDeaths(), cumulativeDeaths)) {
            covid.setCumulativeDeaths(cumulativeDeaths);
        }
        if (newCases != null &&
                !Objects.equals(covid.getNewCases(), newCases)) {
            covid.setNewCases(newCases);
        }





    }*/
    @Transactional
    public void updateCovid(Integer id, Date dateReported, Integer cumulativeDeaths, Integer cumulativeCases,
                           Integer newDeaths, Integer newCases) {
        Covid covid=getById(id);

        if (dateReported != null &&
                !Objects.equals(covid.getDateReported(), dateReported)) {
            covid.setDateReported(dateReported);
        }
        if (cumulativeCases != null &&
                !Objects.equals(covid.getCumulativeCases(), cumulativeCases)) {
            covid.setCumulativeCases(cumulativeCases);
        }
        if (newDeaths != null &&
                !Objects.equals(covid.getNewDeaths(), newDeaths)) {
            covid.setNewDeaths(newDeaths);
        }
        if (cumulativeDeaths != null &&
                !Objects.equals(covid.getCumulativeDeaths(), cumulativeDeaths)) {
            covid.setCumulativeDeaths(cumulativeDeaths);
        }
        if (newCases != null &&
                !Objects.equals(covid.getNewCases(), newCases)) {
            covid.setNewCases(newCases);
        }
    }

    public List<Covid> getByDateReported(Date dateReported) {
        return covidRepo.findAllByDateReported(dateReported);
    }

    public List<Covid> getByDateReportedAndCountry(Date dateReported, String countryId) {
        Country country=countryService.getById(countryId);
        return covidRepo.findAllByCountryAndDateReported(country,dateReported);
=======
    public void addCovid(Covid covid) {
        covidRepo.save(covid);
    }
    @Transactional
    public void updateCovid(Integer ID,Date lastUpdate,Integer confirmed,Integer deaths,Integer recovered) {
        Covid covid=getById(ID);

        if(lastUpdate!=null &&
                !Objects.equals(covid.getLastUpdate(),lastUpdate)){
            covid.setLastUpdate(lastUpdate);
        }
        if(confirmed!=null &&
                !Objects.equals(covid.getConfirmed(),confirmed)){
            covid.setConfirmed(confirmed);
        }
        if(deaths!=null &&
                !Objects.equals(covid.getDeaths(),deaths)){
            covid.setDeaths(deaths);
        }
        if(recovered!=null &&
                !Objects.equals(covid.getRecovered(),recovered)){
            covid.setRecovered(recovered);
        }
    }
    public List<Covid> getByLastUpdate(Date lastUpdate) {
        return covidRepo.findAllByLastUpdate(lastUpdate);

    }

    public Covid getCovidByCountry(Integer countryId) {
        Country country= countryService.getById(countryId);
        Optional<Covid> covid=covidRepo.findByCountry(country);
        if(!covid.isPresent()){
            throw new IllegalStateException("no record for this country");
        }
        return covid.get();
    }

    public Covid getCovidByState(Integer stateId) {
        State state= stateService.getById(stateId);
        Optional<Covid> covid=covidRepo.findByState(state);
        if(!covid.isPresent()){
            throw new IllegalStateException("no record for this state");
        }
        return covid.get();
    }

    public void updateCovidByCountry(Integer countryId,
                                     Date lastUpdate,
                                     Integer confirmed,
                                     Integer deaths,
                                     Integer recovered) {
        Covid covid = getCovidByCountry(countryId);

        if (lastUpdate != null &&
                !Objects.equals(covid.getLastUpdate(), lastUpdate)) {
            covid.setLastUpdate(lastUpdate);
        }
        if (confirmed != null &&
                !Objects.equals(covid.getConfirmed(), confirmed)) {
            covid.setConfirmed(confirmed);
        }
        if (deaths != null &&
                !Objects.equals(covid.getDeaths(), deaths)) {
            covid.setDeaths(deaths);
        }
        if (recovered != null &&
                !Objects.equals(covid.getRecovered(), recovered)) {
            covid.setRecovered(recovered);
        }
    }
        public void updateCovidByState(Integer stateId,
                Date lastUpdate,
                Integer confirmed,
                Integer deaths,
                Integer recovered) {
            Covid covid=getCovidByState(stateId);

            if(lastUpdate!=null &&
                    !Objects.equals(covid.getLastUpdate(),lastUpdate)){
                covid.setLastUpdate(lastUpdate);
            }
            if(confirmed!=null &&
                    !Objects.equals(covid.getConfirmed(),confirmed)){
                covid.setConfirmed(confirmed);
            }
            if(deaths!=null &&
                    !Objects.equals(covid.getDeaths(),deaths)){
                covid.setDeaths(deaths);
            }
            if(recovered!=null &&
                    !Objects.equals(covid.getRecovered(),recovered)){
                covid.setRecovered(recovered);
            }
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
    }
}