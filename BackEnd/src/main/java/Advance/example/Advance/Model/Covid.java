package Advance.example.Advance.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "covid",schema = "public")
@Entity
public class Covid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateReported;

    private Integer newDeaths;

    private Integer newCases;
    private Integer cumulativeCases;
    private Integer cumulativeDeaths;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id",referencedColumnName = "id")
    private Country country;

    public Covid() {
    }

    public Covid(Date dateReported, Integer newDeaths
            , Integer newCases, Integer cumulativeCases, Integer cumulativeDeaths) {
        this.dateReported = dateReported;
        this.newDeaths = newDeaths;
        this.newCases = newCases;
        this.cumulativeCases = cumulativeCases;
        this.cumulativeDeaths = cumulativeDeaths;

    }

    public Integer getId() {
        return id;
    }

    public Integer getCumulativeDeaths() {
        return cumulativeDeaths;
    }

    public void setCumulativeDeaths(Integer cumulativeDeaths) {
        this.cumulativeDeaths = cumulativeDeaths;
    }

    public Date getDateReported() {
        return dateReported;
    }

    public void setDateReported(Date dateReported) {
        this.dateReported = dateReported;
    }

    public Integer getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(Integer newDeaths) {
        this.newDeaths = newDeaths;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getNewCases() {
        return newCases;
    }

    public void setNewCases(Integer newCases) {
        this.newCases = newCases;
    }

    public Integer getCumulativeCases() {
        return cumulativeCases;
    }

    public void setCumulativeCases(Integer cumulativeCases) {
        this.cumulativeCases = cumulativeCases;
    }




    @Override
    public String toString() {
        return "Covid{" +
                "id=" + id +
                ", dateReported=" + dateReported +
                ", newDeaths=" + newDeaths +
                ", newCases=" + newCases +
                ", cumulativeCases=" + cumulativeCases +
                ", cumulativeDeaths=" + cumulativeDeaths +
                '}';
    }
}


