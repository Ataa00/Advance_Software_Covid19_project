package Advance.example.Advance.controllers;
import Advance.example.Advance.Model.Covid;
import Advance.example.Advance.servieces.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "api/v1/covid")

public class CovidControllers {
    private final CovidService covidService;

    @Autowired
    public CovidControllers(CovidService covidService) {
        this.covidService = covidService;
    }
    @GetMapping
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
    public void deleteById(@PathVariable Integer id){
        covidService.deleteById(id);
    }
    @PostMapping("/addCovid")
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

}
