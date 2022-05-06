package Advance.example.Advance.servieces;

import Advance.example.Advance.Model.Country;
import Advance.example.Advance.Model.Covid;
import Advance.example.Advance.Model.User;
import Advance.example.Advance.repositires.CountryRepo;
import Advance.example.Advance.repositires.CovidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CountryService{
        private final CountryRepo countryRepo;

        @Autowired
        public CountryService(CountryRepo countryRepo) {
            this.countryRepo = countryRepo;

        }

        public List<Country> getCountry() {
            return countryRepo.findAll();
        }
        public Country getById(Integer id) {
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
    public void deleteById(Integer id) {
        Optional<Country> country=countryRepo.findById(id);
        if(!country.isPresent()){
            throw new IllegalStateException("country not found ");
        }
        countryRepo.deleteById(id);
    }
    public void updateCountry(Integer ID,String name,String postalCode) {
        Country country=getById(ID);

        if(name!=null &&
                !Objects.equals(country.getName(),name)){
            country.setName(name);
        }
        if(postalCode!=null &&
                !Objects.equals(country.getPostalCode(),postalCode)){
            country.setPostalCode(postalCode);
        }

    }
}
