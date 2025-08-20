package com.hoenn.pokemoncenter.pokemon_center_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class NurseJoy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Username is required!")
    private String username;

    @NotBlank(message = "Every Nurse needs a password!")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotBlank(message = "Every Nurse needs a name!")
    private String name;

    @NotBlank(message = "Every Nurse needs a city!")
    private String city;

    public NurseJoy() {
    }

    public NurseJoy(String username, String password, String name, String city) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "NurseJoy{" + "id=" + id + ", username='" + username + '\'' + ", name='" + name + '\'' +
                ", city='" + city + '\'' + '}';
    }

}
