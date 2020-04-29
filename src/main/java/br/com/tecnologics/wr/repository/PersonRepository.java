package br.com.tecnologics.wr.repository;

import br.com.tecnologics.wr.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonRepository extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person>{
    
}
