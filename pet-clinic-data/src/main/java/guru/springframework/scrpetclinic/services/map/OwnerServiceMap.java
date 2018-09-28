package guru.springframework.scrpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.scrpetclinic.model.Owner;
import guru.springframework.scrpetclinic.model.Pet;
import guru.springframework.scrpetclinic.services.OwnerService;
import guru.springframework.scrpetclinic.services.PetService;
import guru.springframework.scrpetclinic.services.PetTypeService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long>  implements OwnerService{

	private final PetTypeService petTypeService;
	private final PetService petService;
	
	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner save(Owner owner) {

		if( owner != null ) {
			if( owner.getPets() != null ) {
				owner.getPets().forEach(pet -> {
					if( pet.getPetType() != null ) {
						// save PetType if this is a new PetType and did not already exist.
						if( pet.getPetType().getId() == null ) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					} else {
						throw new RuntimeException("Pet Type is required.");
					}
					
					// if this pet does not exist then it needs to be saved.
					if( pet.getId() == null ) {
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
			
			return super.save(owner);
		} else {
			return null;
		}
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}


}
