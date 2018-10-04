package guru.springframework.scrpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.scrpetclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {

}
