package Advance.example.Advance.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "country",schema = "public")
@Entity
public class Country {
    @Id
    private String id;
    private String name;
    @OneToMany(mappedBy ="country")
    @JsonIgnore
    private Set<Covid> covidSet = new HashSet<>();





    public Country() {
    }

    public Country(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Set<Covid> getCovidSet() {
        return covidSet;
    }



}
