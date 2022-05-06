package Advance.example.Advance.servieces;

import Advance.example.Advance.Model.Country;
import Advance.example.Advance.Model.Covid;
<<<<<<< HEAD
import Advance.example.Advance.Model.User;
import Advance.example.Advance.repositires.CountryRepo;
import Advance.example.Advance.repositires.CovidRepo;
import Advance.example.Advance.repositires.UserRepo;
=======
import Advance.example.Advance.repositires.CountryRepo;
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
<<<<<<< HEAD
import java.util.Set;
=======
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98

@Service
public class CountryService{
        private final CountryRepo countryRepo;
<<<<<<< HEAD
        private final CovidRepo covidRepo;

        private final UserRepo userRepo;

        @Autowired
        public CountryService(CountryRepo countryRepo, CovidRepo covidRepo, UserRepo userRepo) {
            this.countryRepo = countryRepo;


            this.covidRepo = covidRepo;

            this.userRepo = userRepo;
=======
        private final CovidService covidService;

        @Autowired
        public CountryService(CountryRepo countryRepo, CovidService covidService) {
            this.countryRepo = countryRepo;

            this.covidService = covidService;
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
        }

        public List<Country> getCountry() {
            return countryRepo.findAll();
        }
<<<<<<< HEAD
        public Country getById(String id) {
=======
        public Country getById(Integer id) {
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
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
<<<<<<< HEAD
        countryRepo.save(country);
    }
    public void deleteById(String id) {
=======
        Covid covid = country.getCovid();
        covid.setCountry(country);
        covidService.addCovid(covid);
        countryRepo.save(country);
    }
    public void deleteById(Integer id) {
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
        Optional<Country> country=countryRepo.findById(id);
        if(!country.isPresent()){
            throw new IllegalStateException("country not found ");
        }
<<<<<<< HEAD
        Optional<Covid> covid=covidRepo.findByCountry(country.get());
        if(covid.isPresent()){
            covidRepo.delete(covid.get());
        }

        countryRepo.deleteById(id);

    }
    public void updateCountry(String ID,String name) {
=======
        countryRepo.deleteById(id);
    }
    public void updateCountry(Integer ID,String name,String postalCode) {
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
        Country country=getById(ID);

        if(name!=null &&
                !Objects.equals(country.getName(),name)){
            country.setName(name);
        }
<<<<<<< HEAD

=======
        if(postalCode!=null &&
                !Objects.equals(country.getPostalCode(),postalCode)){
            country.setPostalCode(postalCode);
        }
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98

    }
}
