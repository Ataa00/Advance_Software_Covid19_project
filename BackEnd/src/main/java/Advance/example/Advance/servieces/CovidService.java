package Advance.example.Advance.servieces;

import Advance.example.Advance.Model.Country;
import Advance.example.Advance.Model.Covid;
import Advance.example.Advance.repositires.CountryRepo;
import Advance.example.Advance.repositires.CovidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
public class CovidService {
    private final CovidRepo covidRepo;
    private final CountryService countryService;
    private final CountryRepo countryRepo;

    @Autowired
    public CovidService(CovidRepo covidRepo, CountryService countryService, CountryRepo countryRepo) {
        this.covidRepo = covidRepo;
        this.countryService = countryService;


        this.countryRepo = countryRepo;
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
    }
}