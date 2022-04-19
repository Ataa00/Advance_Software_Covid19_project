package Advance.example.Advance.controllers;

import Advance.example.Advance.Model.Covid;
import Advance.example.Advance.servieces.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/covid")

public class CovidControllers {
    private final CovidService covidService;

    @Autowired
    public CovidControllers(CovidService covidService) {
        this.covidService = covidService;
    }
    @GetMapping
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
    public void deleteById(@PathVariable Integer id){
        covidService.deleteById(id);
    }
    @PostMapping("/addCovid")
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

}
