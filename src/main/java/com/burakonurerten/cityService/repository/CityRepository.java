package com.burakonurerten.cityService.repository;

import com.burakonurerten.cityService.model.City;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CityRepository extends MongoRepository<City,String> {

    List<City> findByName(String name);

}
