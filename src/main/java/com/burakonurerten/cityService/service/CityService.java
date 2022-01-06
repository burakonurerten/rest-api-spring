package com.burakonurerten.cityService.service;

import com.burakonurerten.cityService.model.City;
import com.burakonurerten.cityService.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public List<City> getCities(String name){
        if(name == null){
            return cityRepository.findAll();
        }
        else {
            return cityRepository.findByName(name);
        }

    }

    public City createCity(City newCity) {
        return cityRepository.save(newCity);
    }

    public void deleteCity(String id) {
        cityRepository.deleteById(id);
    }

    public City getCityById(String id) {
        return cityRepository.findById(id)
        .orElseThrow(() ->new RuntimeException("City not found"));
    }

    public void updateCity(String id, City newCity) {
        City oldCity = getCityById(id);
        oldCity.setName(newCity.getName());
        cityRepository.save(oldCity);
    }
}
