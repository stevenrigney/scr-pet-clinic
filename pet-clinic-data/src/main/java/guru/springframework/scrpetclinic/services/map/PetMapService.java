package guru.springframework.scrpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.scrpetclinic.model.Pet;
import guru.springframework.scrpetclinic.services.CrudService;
import guru.springframework.scrpetclinic.services.PetService;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

	@Override
	public Pet save(Pet object) {
		return super.save(object);
	}

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);
	}

}
