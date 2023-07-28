package com.work.firstapi.person;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthdate;
    private boolean active;
    @Transient
    private Integer age;

    public Person() {
    }

    public Person(long id, String name, String surname, String email, LocalDate birthdate, boolean active) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthdate = birthdate;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getAge() {
        return Period.between(birthdate,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
