package Advance.example.Advance.Model;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "covid",schema = "public")
@Entity
public class Covid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date lastUpdate;
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;
    @OneToOne(mappedBy = "covid", cascade = CascadeType.ALL)
    private State state;
    @OneToOne(mappedBy = "covid", cascade = CascadeType.ALL)
    private Country country;

    public Covid() {
    }

    public Covid(Date lastUpdate, Integer confirmed,
                 Integer deaths, Integer recovered,
                 State state, Country country) {
        this.lastUpdate = lastUpdate;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
        this.state = state;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Covid{" +
                "id=" + id +
                ", lastUpdate=" + lastUpdate +
                ", confirmed=" + confirmed +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                ", state=" + state +
                ", country=" + country +
                '}';
    }
}
