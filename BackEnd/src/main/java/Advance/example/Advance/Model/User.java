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
<<<<<<< HEAD
<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role role;



=======
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role role;
=======
    private Integer role;
>>>>>>> parent of eaf0b97 (Backend Final push V1)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id",referencedColumnName = "id")
    private Country country;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "state_id",referencedColumnName = "id")
    private State state;
    @OneToMany(mappedBy = "state")
    @JsonIgnore
    private Set<User> userSet=new HashSet<>();
<<<<<<< HEAD
>>>>>>> c3aee38102f7028c3d7becacae81d7630f45ca98
=======
>>>>>>> parent of eaf0b97 (Backend Final push V1)

    public User() {
    }

    public User(String userName, String firstName, String lastName, String password, String email, Integer role) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.role = role;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
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
