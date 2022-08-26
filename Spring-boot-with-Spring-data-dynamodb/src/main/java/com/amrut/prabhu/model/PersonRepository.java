package com.amrut.prabhu.model;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface PersonRepository extends CrudRepository<Person, PrimaryKey> {

    List<Person> findById(String id);
}