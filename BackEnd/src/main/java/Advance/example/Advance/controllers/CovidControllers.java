package Advance.example.Advance.controllers;

import Advance.example.Advance.Model.Covid;
import Advance.example.Advance.servieces.CovidServesis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/covid")

public class CovidControllers {
    private final CovidServesis covidServesis;

    @Autowired
    public CovidControllers(CovidServesis covidServesis) {
        this.covidServesis = covidServesis;
    }
    @GetMapping
    public List<Covid> getEmployees(){
        return covidServesis.getCovid();
    }
    @GetMapping("byId/{id}")
    public Covid getById(@PathVariable Integer id){
        return covidServesis.getById(id);
    }
    @GetMapping("byLastUpdate/{lastUpdate}")
    public List<Covid> getByLastUpdate(@PathVariable Date lastUpdate){
        return covidServesis.getByLastUpdate(lastUpdate);
    }
    @DeleteMapping("deleteCovid/{id}")
    public void deleteById(@PathVariable Integer id){
        covidServesis.deleteById(id);
    }
    @PostMapping("/addCovid")
    public void addCovid(@RequestBody Covid covid){
        covidServesis.addCovid(covid);
    }
    @PutMapping("updateByID/{ID}")
    public void updateCovid(
            @PathVariable  Integer ID ,
            @RequestParam (required = false) Date lastUpdate,
            @RequestParam (required = false) Integer confirmed,
            @RequestParam (required = false) Integer deaths,
            @RequestParam (required = false) Integer recovered){
        covidServesis.updateCovid(ID,lastUpdate,confirmed,deaths,recovered);
    }

}
