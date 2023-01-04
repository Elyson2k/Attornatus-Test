package com.project.apiperson.service;

import com.project.apiperson.domain.entities.City;
import com.project.apiperson.domain.dto.CityDto;
import com.project.apiperson.repository.CityRepository;
import com.project.apiperson.service.exceptions.CustomExceptions;
import com.project.apiperson.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City findCityByID(Integer id){
        return cityRepository.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException("Error: Entity not found.") );
    }

    public List<CityDto> findAllCity(){
        List<CityDto> listCity = cityRepository.findAll().stream().map( obj -> new CityDto(obj)).collect(Collectors.toList());
        if(listCity.isEmpty()){
            throw new CustomExceptions("Error: no city found");
        } else return listCity;
    }

    public City insertCity(CityDto city){
        City newCity = new City();
        newCity.setName(city.getName());
        cityRepository.save(newCity);
        return newCity;
    }

}

