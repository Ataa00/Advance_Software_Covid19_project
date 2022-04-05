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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String postalCode;
    @OneToOne
    private Covid covid;
    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private Set<User>userSet=new HashSet<>();
    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private Set<State>stateSet=new HashSet<>();


    public Country() {
    }

    public Country(String name, String postalCode) {
        this.name = name;
        this.postalCode = postalCode;
    }

    public Country(String name, String postalCode, Covid covid) {
        this.name = name;
        this.postalCode = postalCode;
        this.covid = covid;
    }

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Covid getCovid() {
        return covid;
    }

    public void setCovid(Covid covid) {
        this.covid = covid;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public Set<State> getStateSet() {
        return stateSet;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", covid=" + covid +
                '}';
    }
}
