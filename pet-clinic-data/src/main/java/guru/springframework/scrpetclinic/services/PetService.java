package guru.springframework.scrpetclinic.services;

import java.util.Set;

import guru.springframework.scrpetclinic.model.Pet;

public interface PetService {

	Pet findById(Long id);
	Pet save(Pet pet);
	Set<Pet> findAll();
	
}
