package guru.springframework.scrpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.scrpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
