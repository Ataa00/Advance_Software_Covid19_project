package Advance.example.Advance.controllers;

import Advance.example.Advance.Model.Country;
import Advance.example.Advance.servieces.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.security.access.prepost.PreAuthorize;
=======
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
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
<<<<<<< HEAD
    @PreAuthorize("hasAnyRole('Admin','User')")
=======
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
    public List<Country> getCountry(){
        return countryService.getCountry();
    }
    @GetMapping("byId/{id}")
<<<<<<< HEAD
    @PreAuthorize("hasAnyRole('Admin','User')")
    public Country getById(@PathVariable String id){
        return countryService.getById(id);
    }
    @GetMapping("byName/{name}")
    @PreAuthorize("hasRole('Admin')")
=======
    public Country getById(@PathVariable Integer id){
        return countryService.getById(id);
    }
    @GetMapping("byName/{name}")
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
    public Country getByLastUpdate(@PathVariable String name){
        return countryService.getByName(name);
    }
    @PostMapping("/addCountry")
<<<<<<< HEAD
    @PreAuthorize("hasRole('Admin')")
=======
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
    public void addCountry(@RequestBody Country country){
        countryService.addCountry(country);

    }
    @DeleteMapping("deleteCountry/{id}")
<<<<<<< HEAD
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
=======
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
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
    }

    }

