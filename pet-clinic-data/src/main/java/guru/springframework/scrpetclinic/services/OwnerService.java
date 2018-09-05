package guru.springframework.scrpetclinic.services;

import guru.springframework.scrpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);
}
