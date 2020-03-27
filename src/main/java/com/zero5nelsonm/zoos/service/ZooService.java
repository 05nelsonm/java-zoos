package com.zero5nelsonm.zoos.service;

import com.zero5nelsonm.zoos.model.Zoo;
import com.zero5nelsonm.zoos.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ZooService {

    List<Zoo> findAll();

    Zoo findZooById(long zooid);

    List<Zoo> findByZoonameLike(String namelike);

    Zoo save(Zoo zoo);

    Zoo update(Zoo zoo, long zooid);

    void delete(long zooid);

    void delete(long zooid, long animalid);

    void addZooAnimal(long zooid, long animalid);
}
