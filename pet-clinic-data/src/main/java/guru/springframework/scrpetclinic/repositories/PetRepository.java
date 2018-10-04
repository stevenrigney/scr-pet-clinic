package guru.springframework.scrpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.scrpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
