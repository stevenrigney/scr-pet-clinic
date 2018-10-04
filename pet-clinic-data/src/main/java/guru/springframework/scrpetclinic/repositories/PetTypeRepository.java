package guru.springframework.scrpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.scrpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
