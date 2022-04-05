package Advance.example.Advance.servieces;

import Advance.example.Advance.Model.Covid;
import Advance.example.Advance.repositires.CovidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CovidServesis {
    private final CovidRepo covidRepo;

    @Autowired
    public CovidServesis(CovidRepo covidRepo) {
        this.covidRepo = covidRepo;

    }

    public List<Covid> getCovid() {
        return covidRepo.findAll();
    }
    public Covid getById(Integer id) {
        if(!covidRepo.findById(id).isPresent()){
            throw new IllegalStateException("this covid not Found");
        }
        return covidRepo.findById(id).get();
    }
    public void deleteById(Integer id) {
        Optional<Covid> covid=covidRepo.findById(id);
        if(!covid.isPresent()){
            throw new IllegalStateException("employee not found ");
        }
        covidRepo.deleteById(id);

    }
    public void addCovid(Covid covid) {
        covidRepo.save(covid);
    }
    @Transactional
    public void updateCovid(Integer ID,Date lastUpdate,Integer confirmed,Integer deaths,Integer recovered) {
        Covid covid=getById(ID);

        if(lastUpdate!=null &&
                !Objects.equals(covid.getLastUpdate(),lastUpdate)){
            covid.setLastUpdate(lastUpdate);
        }
        if(confirmed!=null &&
                !Objects.equals(covid.getConfirmed(),confirmed)){
            covid.setConfirmed(confirmed);
        }
        if(deaths!=null &&
                !Objects.equals(covid.getDeaths(),deaths)){
            covid.setDeaths(deaths);
        }
        if(deaths!=null &&
                !Objects.equals(covid.getRecovered(),recovered)){
            covid.setRecovered(recovered);
        }
    }
    public List<Covid> getByLastUpdate(Date lastUpdate) {
        return covidRepo.findAllByLastUpdate(lastUpdate);

    }
}