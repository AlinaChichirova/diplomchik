package com.example.diplomchik.repos;

import com.example.diplomchik.model.Person;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}

