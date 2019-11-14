package com.zero5nelsonm.zoos.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zoos")
public class ZooController {

    /**
     * @GET http://localhost:2019/zoos/zoos
     *
     * @Return all zoos with their phone numbers and animals.
     * @Return status OK
     * */

    /**
     * @GET http://localhost:2019/zoos/zoo/{zooid}
     * @param zooid : long
     *
     * @Return all information related to a zoo based on its id.
     * @Return status OK
     * */

    /**
     * @GET http://localhost:2019/zoos/zoo/namelike/{namelike}
     * @param namelike : String
     *
     * @Return a list of all zoos and their information who have
     *     the given substring in their name.
     * @Return status OK
     * */

    /**
     * @POST http://localhost:2019/zoos/zoo
     * Adds a zoo and it's associated phone numbers (does NOT add
     *     animals for which the zoo has)
     * @param newZoo : Zoo
     *
     * @Return header containing the id of the newly created zoo
     * @Return status CREATE
     * */

    /**
     * @PUT http://localhost:2019/zoos/zoo/{id}
     * Updates a zoo and it's associated phone numbers (does NOT
     *     update zoo animal combinations)
     * @param zooid : long
     * @param updateZoo : Zoo
     *
     * @Return status OK
     * */

    /**
     * @DELETE http://localhost:2019/zoos/zoo/{zooid}
     * Deletes a zoo, associated phone numbers, and zoo animal combination
     *     associated with the provided zooid
     * @param zooid : long
     *
     * @Return status OK
     * */

    /**
     * @DELETE http://localhost:2019/zoos/zoo/{zooid}/animals/{animalid}
     * Deletes a zoo animal combination based off of zooid & animalid
     * @param zooid : long
     * @param animalid : long
     *
     * @Return status OK
     * */

    /**
     * @POST http://localhost:2019/zoos/zoo/{zooid}/animals/{animalid}
     * Adds a zoo animal combination based off of zooid & animalid
     * @param zooid : long
     * @param animalid : long
     *
     * @Return status CREATED
     * */
}
