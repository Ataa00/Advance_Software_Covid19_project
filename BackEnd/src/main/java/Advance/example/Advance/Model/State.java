package Advance.example.Advance.Model;

import javax.persistence.*;

@Table(name="state",schema = "public")
@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String postalCode;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id",referencedColumnName = "id")
    private Country country;
    @OneToOne
    private Covid covid;


    public State() {
    }

    public State(String postalCode, String name) {
        this.postalCode = postalCode;
        this.name = name;
    }

    public State(String postalCode, String name, Country country, Covid covid) {
        this.postalCode = postalCode;
        this.name = name;
        this.country = country;
        this.covid = covid;
    }

    public Integer getId() {
        return id;
    }



    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Covid getCovid() {
        return covid;
    }

    public void setCovid(Covid covid) {
        this.covid = covid;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", postalCode='" + postalCode + '\'' +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", covid=" + covid +
                '}';
    }
}
