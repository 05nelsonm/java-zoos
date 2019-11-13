package com.zero5nelsonm.repository;

import com.zero5nelsonm.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
}
