package com.zero5nelsonm.zoos.service;

import com.zero5nelsonm.zoos.model.Telephone;
import com.zero5nelsonm.zoos.model.Zoo;
import com.zero5nelsonm.zoos.repository.AnimalRepository;
import com.zero5nelsonm.zoos.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service(value = "zooService")
public class ZooServiceImplementation implements ZooService{

    @Autowired
    private ZooRepository zooRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public List<Zoo> findAll() {

        List<Zoo> zooList = new ArrayList<>();
        zooRepository.findAll().iterator().forEachRemaining(zooList::add);
        return zooList;
    }

    @Override
    public Zoo findZooById(long zooid) {

        return zooRepository.findById(zooid).orElseThrow(() ->
                new EntityNotFoundException("Zoo id " + zooid + " not found"));
    }

    @Override
    public List<Zoo> findByZoonameLike(String namelike) {

        return zooRepository.findByZoonameContainingIgnoringCase(namelike);
    }

    @Override
    public Zoo save(Zoo zoo) {

        if (zooRepository.findByZooname(zoo.getZooname()) != null) {
            throw new EntityNotFoundException(zoo.getZooname() + " is already taken!");
        }

        Zoo newZoo = new Zoo();
        newZoo.setZooname(zoo.getZooname());

        for (Telephone t : zoo.getTelephones()) {
            newZoo.getTelephones()
                    .add(new Telephone(t.getPhonetype(),
                            t.getPhonenumber(), newZoo));
        }

        return zooRepository.save(newZoo);
    }

    @Transactional
    @Override
    public Zoo update(Zoo zoo, long zooid) {

        Zoo existingZoo = findZooById(zooid);
        if (zoo.getZooname() != null) {
            existingZoo.setZooname(zoo.getZooname());
        }

        if (zoo.getTelephones() != null) {
            for (Telephone t : zoo.getTelephones()) {
                existingZoo.getTelephones()
                        .add(new Telephone(t.getPhonetype(),
                                t.getPhonenumber(), existingZoo));
            }
        }

        return zooRepository.save(existingZoo);
    }

    @Override
    public void delete(long zooid) {

        zooRepository.findById(zooid).orElseThrow(() ->
                new EntityNotFoundException("Zoo id " + zooid + "not found!"));
       zooRepository.deleteById(zooid);
    }

    @Override
    public void delete(long zooid, long animalid) {

        zooRepository.findById(zooid).orElseThrow(() ->
                new EntityNotFoundException("Zoo id " + zooid + "not found!"));
        animalRepository.findById(animalid).orElseThrow(() ->
                new EntityNotFoundException("Zoo id " + animalid + "not found!"));

        if (animalRepository.checkZooAnimalCombination(zooid, animalid).getCount() >  0) {
            animalRepository.deleteZooAnimal(zooid, animalid);
        } else {
            throw new EntityNotFoundException("The zoo has no animals of that type!");
        }
    }

    @Override
    public void addZooAnimal(long zooid, long animalid) {
        zooRepository.findById(zooid).orElseThrow(() ->
                new EntityNotFoundException("Zoo id " + zooid + " not found!"));
        animalRepository.findById(animalid).orElseThrow(() ->
                new EntityNotFoundException("Animal id " + animalid + " not found!"));
        if (animalRepository.checkZooAnimalCombination(zooid, animalid).getCount() <= 0) {
            animalRepository.createZooAnimal(zooid, animalid);
        } else throw new EntityNotFoundException("Zoo and Animal Combination Already Exists");
    }
}
