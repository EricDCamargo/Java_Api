package br.com.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.project.api.model.Person;

public interface Repository extends CrudRepository<Person, Integer> {

  List<Person> findAll();

  Person findById(int id);

  List<Person> findByOrderByName();

  List<Person> findByNameOrderByAge(String name);

  List<Person> findByNameContaining(String term);

  List<Person> findByNameStartsWith(String term);

  List<Person> findByNameEndsWith(String term);
}
