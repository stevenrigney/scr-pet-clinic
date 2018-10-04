package guru.springframework.scrpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.scrpetclinic.model.Owner;

public interface OwnerRepsitory extends CrudRepository<Owner, Long>{

	Owner findByLastName(String lastName);

}
