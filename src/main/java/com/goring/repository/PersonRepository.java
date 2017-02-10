package com.goring.repository;

import com.goring.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ekansh on 14/7/15.
 */
@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {

}
