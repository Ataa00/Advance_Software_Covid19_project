package Advance.example.Advance.controllers;

import Advance.example.Advance.Model.State;
import Advance.example.Advance.servieces.StateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/state")
public class StateController {
    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }
    @GetMapping
    public List<State> getAllStates(){
        return stateService.getAll();
    }
    @GetMapping("getById/{id}")
    public State getById(@PathVariable Integer id){
        return stateService.getById(id);
    }
    @GetMapping("getCountryStates/{countryId}")
    public List<State>getByCountryId(@PathVariable Integer countryId){
        return stateService.getByCountry(countryId);
    }
    @PostMapping("addState/{countryId}")
    public void addState(@PathVariable Integer countryId,
                         @RequestBody State state){
        stateService.addState(countryId,state);
    }
    @PutMapping("updateState/{id}")
    public void updateState(@PathVariable Integer id,
                            @RequestParam (required = false)  String postalCode,
                            @RequestParam (required = false) String name){
        stateService.update(id,postalCode, name);
    }

}
