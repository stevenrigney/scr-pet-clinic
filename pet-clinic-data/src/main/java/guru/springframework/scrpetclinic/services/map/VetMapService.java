package guru.springframework.scrpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.scrpetclinic.model.Specialty;
import guru.springframework.scrpetclinic.model.Vet;
import guru.springframework.scrpetclinic.services.SpecialtyService;
import guru.springframework.scrpetclinic.services.VetService;


@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

	private SpecialtyService specialtyService;
	
	
	public VetMapService(SpecialtyService specialtyService) {
		super();
		this.specialtyService = specialtyService;
	}

	@Override
	public Vet save(Vet object) {
		if( object.getSpecialties().size() > 0 ) {
			object.getSpecialties().forEach(specialty -> {
				if( specialty.getId() == null ) {
					Specialty savedSpecialty = specialtyService.save(specialty);
					specialty.setId(savedSpecialty.getId());
				}
			});
		}
		return super.save(object);
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

}
