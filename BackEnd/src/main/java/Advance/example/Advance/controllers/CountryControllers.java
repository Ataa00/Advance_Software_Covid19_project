package Advance.example.Advance.controllers;

import Advance.example.Advance.Model.Country;
import Advance.example.Advance.Model.Covid;
import Advance.example.Advance.Model.User;
import Advance.example.Advance.servieces.CountryService;
import Advance.example.Advance.servieces.CovidServesis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Country")
public class CountryControllers {
    private final CountryService countryService;

    @Autowired
    public CountryControllers(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping
    public List<Country> getCountry(){
        return countryService.getCountry();
    }
    @GetMapping("byId/{id}")
    public Country getById(@PathVariable Integer id){
        return countryService.getById(id);
    }
    @GetMapping("byName/{name}")
    public Country getByLastUpdate(@PathVariable String name){
        return countryService.getByName(name);
    }
    @PostMapping("/addCountry")
    public void addCountry(@RequestBody Country country){
        countryService.addCountry(country);

    }
    @DeleteMapping("deleteCountry/{id}")
    public void deleteById(@PathVariable Integer id){
        countryService.deleteById(id);
    }
    @PutMapping("updateByID/{ID}")
    public void updateCovid(
            @PathVariable  Integer ID ,
            @RequestParam (required = false) String name,
            @RequestParam (required = false) String postalCode)
           {
               countryService.updateCountry(ID,name,postalCode);
    }

    }

