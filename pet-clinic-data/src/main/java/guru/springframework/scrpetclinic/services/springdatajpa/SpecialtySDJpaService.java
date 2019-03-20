package guru.springframework.scrpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.scrpetclinic.model.Specialty;
import guru.springframework.scrpetclinic.repositories.SpecialtyRepository;
import guru.springframework.scrpetclinic.services.SpecialtyService;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {

	private final SpecialtyRepository specialtyRepsitory;
	
	public SpecialtySDJpaService(SpecialtyRepository specialtyRepsitory) {
		super();
		this.specialtyRepsitory = specialtyRepsitory;
	}

	@Override
	public Set<Specialty> findAll() {
		Set<Specialty> specialities = new HashSet<>();
		specialtyRepsitory.findAll().forEach(specialities::add);
		
		return specialities;
	}

	@Override
	public Specialty findById(Long id) {
		return specialtyRepsitory.findById(id).orElse(null);
	}

	@Override
	public Specialty save(Specialty object) {
		return specialtyRepsitory.save(object);
	}

	@Override
	public void delete(Specialty object) {
		specialtyRepsitory.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		specialtyRepsitory.deleteById(id);
	}

}
