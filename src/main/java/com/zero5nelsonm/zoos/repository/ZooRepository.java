package com.zero5nelsonm.zoos.repository;

import com.zero5nelsonm.zoos.model.Zoo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ZooRepository extends CrudRepository<Zoo, Long> {

    List<Zoo> findByZoonameContainingIgnoringCase(String namelike);

    Zoo findByZooname(String zooname);
}
