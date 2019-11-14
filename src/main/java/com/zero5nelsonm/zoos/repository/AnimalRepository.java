package com.zero5nelsonm.zoos.repository;

import com.zero5nelsonm.zoos.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
}
