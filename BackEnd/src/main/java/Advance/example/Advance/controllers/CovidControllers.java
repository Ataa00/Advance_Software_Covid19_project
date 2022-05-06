package Advance.example.Advance.controllers;
<<<<<<< HEAD
import Advance.example.Advance.Model.Covid;
import Advance.example.Advance.servieces.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
=======

import Advance.example.Advance.Model.Covid;
import Advance.example.Advance.servieces.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
<<<<<<< HEAD
import java.util.Set;
=======
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98

@RestController
@RequestMapping(path = "api/v1/covid")

public class CovidControllers {
    private final CovidService covidService;

    @Autowired
    public CovidControllers(CovidService covidService) {
        this.covidService = covidService;
    }
    @GetMapping
<<<<<<< HEAD
    @PreAuthorize("hasAnyRole('Admin','User')")
    public List<Covid> getCovid(){
        return covidService.getCovid();
    }



    @GetMapping("byId/{id}")
    @PreAuthorize("hasAnyRole('Admin','User')")
    public Covid getById(@PathVariable Integer id){
        return covidService.getById(id);
    }
    @GetMapping("byDateReported/{dateReported}")
    @PreAuthorize("hasAnyRole('Admin','User')")
    public List<Covid>getAllByDateReported(@PathVariable Date dateReported){
        return covidService.getByDateReported(dateReported);
    }

    @GetMapping("byDateAndCountry/{dateReported}/{countryId}")
    @PreAuthorize("hasAnyRole('Admin','User')")
    public List<Covid>getAllByDateReportedAndCountry(@PathVariable Date dateReported,
                                                     @PathVariable String countryId){
        return covidService.getByDateReportedAndCountry(dateReported,countryId);
    }

    @GetMapping("byCountry/{countryId}")
    @PreAuthorize("hasAnyRole('Admin','User')")
    public List<Covid> getByCountry(@PathVariable String countryId){
       return covidService.getCovidByCountry(countryId);
    }

    @DeleteMapping("deleteCovid/{id}")
    @PreAuthorize("hasRole('Admin')")
=======
    public List<Covid> getCovid(){
        return covidService.getCovid();
    }
    @GetMapping("byId/{id}")
    public Covid getById(@PathVariable Integer id){
        return covidService.getById(id);
    }
    @GetMapping("byLastUpdate/{lastUpdate}")
    public List<Covid> getByLastUpdate(@PathVariable Date lastUpdate){
        return covidService.getByLastUpdate(lastUpdate);
    }
    @GetMapping("byCountry/{countryId}")
    public Covid getByCountry(@PathVariable Integer countryId){
       return covidService.getCovidByCountry(countryId);
    }
    @GetMapping("byState/{StateId}")
    public Covid getByState(@PathVariable Integer stateId){
        return covidService.getCovidByState(stateId);
    }
    @DeleteMapping("deleteCovid/{id}")
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
    public void deleteById(@PathVariable Integer id){
        covidService.deleteById(id);
    }
    @PostMapping("/addCovid")
<<<<<<< HEAD
    @PreAuthorize("hasAnyRole('Admin')")
    public void addCovid(@RequestBody Covid covid){
        covidService.addCovid(covid);
    }
    /*@PreAuthorize("hasRole('Admin')")
    @PostMapping("addAll")
    public void addAll(@RequestBody Set<Covid> covidSet){
        covidService.addAllCovidRecords(covidSet);

    }*/
    @PutMapping("updateByID/{id}")
    @PreAuthorize("hasRole('Admin')")
    public void updateCovid(
            @PathVariable  Integer id ,
            @RequestParam (required = false) Date dateReported,
            @RequestParam (required = false) Integer cumulativeCases,
            @RequestParam (required = false) Integer newCases,
            @RequestParam (required = false) Integer cumulativeDeaths,
            @RequestParam (required = false)Integer newDeaths){
        covidService.updateCovid(id,dateReported,cumulativeDeaths,cumulativeCases,newDeaths,newCases);
    }
    /*@PutMapping("updateByCountry/{countryId}")
    public void updateCovidByCountry(
            @PathVariable  String countryId ,
            @RequestParam (required = false) Date dateReported,
            @RequestParam (required = false) Integer cumulativeCases,
            @RequestParam (required = false) Integer newCases,
            @RequestParam (required = false) Integer cumulativeDeaths,
            @RequestParam (required = false)Integer newDeaths){
        covidService.updateCovidByCountry(countryId,dateReported,cumulativeDeaths,cumulativeCases,newDeaths,newCases);
    }*/
=======
    public void addCovid(@RequestBody Covid covid){
        covidService.addCovid(covid);
    }
    @PutMapping("updateByID/{ID}")
    public void updateCovid(
            @PathVariable  Integer ID ,
            @RequestParam (required = false) Date lastUpdate,
            @RequestParam (required = false) Integer confirmed,
            @RequestParam (required = false) Integer deaths,
            @RequestParam (required = false) Integer recovered){
        covidService.updateCovid(ID,lastUpdate,confirmed,deaths,recovered);
    }
    @PutMapping("updateByCountry/{countryId}")
    public void updateCovidByCountry(
            @PathVariable  Integer countryId ,
            @RequestParam (required = false) Date lastUpdate,
            @RequestParam (required = false) Integer confirmed,
            @RequestParam (required = false) Integer deaths,
            @RequestParam (required = false) Integer recovered){
        covidService.updateCovidByCountry(countryId,lastUpdate,confirmed,deaths,recovered);
    }
    @PutMapping("updateByState/{stateId}")
    public void updateCovidByState(
            @PathVariable  Integer stateId ,
            @RequestParam (required = false) Date lastUpdate,
            @RequestParam (required = false) Integer confirmed,
            @RequestParam (required = false) Integer deaths,
            @RequestParam (required = false) Integer recovered){
        covidService.updateCovidByState(stateId,lastUpdate,confirmed,deaths,recovered);
    }
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98

}
