package Advance.example.Advance.controllers;

import Advance.example.Advance.Model.Country;
import Advance.example.Advance.servieces.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    @PreAuthorize("hasAnyRole('Admin','User')")
    public List<Country> getCountry(){
        return countryService.getCountry();
    }
    @GetMapping("byId/{id}")
    @PreAuthorize("hasAnyRole('Admin','User')")
    public Country getById(@PathVariable String id){
        return countryService.getById(id);
    }
    @GetMapping("byName/{name}")
    @PreAuthorize("hasRole('Admin')")
    public Country getByLastUpdate(@PathVariable String name){
        return countryService.getByName(name);
    }
    @PostMapping("/addCountry")
    @PreAuthorize("hasRole('Admin')")
    public void addCountry(@RequestBody Country country){
        countryService.addCountry(country);

    }
    @DeleteMapping("deleteCountry/{id}")
    @PreAuthorize("hasRole('Admin')")
    public void deleteById(@PathVariable String id){
        countryService.deleteById(id);
    }
    @PutMapping("updateByID/{id}")
    @PreAuthorize("hasRole('Admin')")
    public void updateCovid(
            @PathVariable  String id ,
            @RequestParam (required = false) String name)
           {
               countryService.updateCountry(id,name);
    }

    }

