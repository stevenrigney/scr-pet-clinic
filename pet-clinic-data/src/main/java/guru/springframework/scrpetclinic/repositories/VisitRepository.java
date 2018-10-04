package guru.springframework.scrpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.scrpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
