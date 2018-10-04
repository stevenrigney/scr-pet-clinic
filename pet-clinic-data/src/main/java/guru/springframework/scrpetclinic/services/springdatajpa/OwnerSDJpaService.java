package guru.springframework.scrpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.scrpetclinic.model.Owner;
import guru.springframework.scrpetclinic.repositories.OwnerRepsitory;
import guru.springframework.scrpetclinic.repositories.PetRepository;
import guru.springframework.scrpetclinic.repositories.PetTypeRepository;
import guru.springframework.scrpetclinic.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {
	
	private final OwnerRepsitory ownerRepository;
	private final PetRepository petRepsitory;
	private final PetTypeRepository petTypeRepsitory;

	public OwnerSDJpaService(OwnerRepsitory ownerRepository, PetRepository petRepsitory,
			PetTypeRepository petTypeRepsitory) {
		super();
		this.ownerRepository = ownerRepository;
		this.petRepsitory = petRepsitory;
		this.petTypeRepsitory = petTypeRepsitory;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

}
