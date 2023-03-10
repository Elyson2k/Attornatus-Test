package com.project.apiperson.domain.dto;

import com.project.apiperson.domain.entities.City;

public class CityDto {

    private Integer id;
    private String name;

    public CityDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CityDto(City city) {
        this.id = city.getId();
        this.name = city.getName();
    }

    public Integer getId() {
        return id;
    }

    public CityDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CityDto setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
