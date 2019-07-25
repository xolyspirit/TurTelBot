package com.example.demo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    @Column(unique = true)
    private String name;
    private String message;

    public City() {
        super();
    }

    public City(String name, String message) {
        this.name = name;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return name.equals(city.name) &&
                message.equals(city.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, message);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
