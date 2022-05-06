package Advance.example.Advance.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "user",schema = "public")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    @Column(unique = true)
    private String email;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role role;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id",referencedColumnName = "id")
    private Country country;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "state_id",referencedColumnName = "id")
    private State state;
    @OneToMany(mappedBy = "state")
    @JsonIgnore
    private Set<User> userSet=new HashSet<>();

    public User() {
    }

    public User(String userName, String firstName, String lastName, String password, String email) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;

    }

    public Integer getId() {
        return id;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", country=" + country +
                ", state=" + state +
                '}';
    }
}
