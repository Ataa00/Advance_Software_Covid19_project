package Advance.example.Advance.servieces;

import Advance.example.Advance.Model.Country;
import Advance.example.Advance.Model.Covid;
import Advance.example.Advance.Model.User;
import Advance.example.Advance.repositires.CountryRepo;
import Advance.example.Advance.repositires.CovidRepo;
import Advance.example.Advance.repositires.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
public class CountryService{
        private final CountryRepo countryRepo;
        private final CovidRepo covidRepo;

        private final UserRepo userRepo;

        @Autowired
        public CountryService(CountryRepo countryRepo, CovidRepo covidRepo, UserRepo userRepo) {
            this.countryRepo = countryRepo;


            this.covidRepo = covidRepo;

            this.userRepo = userRepo;
        }

        public List<Country> getCountry() {
            return countryRepo.findAll();
        }
        public Country getById(String id) {
            if(!countryRepo.findById(id).isPresent()){
                throw new IllegalStateException("this Country not Found");
            }
            return countryRepo.findById(id).get();
        }
    public Country getByName(String name) {
        if(countryRepo.getByName(name).isEmpty()){
            throw new IllegalStateException("user not found");

        }
        return countryRepo.getByName(name).get();
    }
    public void addCountry(Country country) {
        countryRepo.save(country);
    }
    public void deleteById(String id) {
        Optional<Country> country=countryRepo.findById(id);
        if(!country.isPresent()){
            throw new IllegalStateException("country not found ");
        }
        Optional<Covid> covid=covidRepo.findByCountry(country.get());
        if(covid.isPresent()){
            covidRepo.delete(covid.get());
        }

        countryRepo.deleteById(id);

    }
    public void updateCountry(String ID,String name) {
        Country country=getById(ID);

        if(name!=null &&
                !Objects.equals(country.getName(),name)){
            country.setName(name);
        }


    }
}
