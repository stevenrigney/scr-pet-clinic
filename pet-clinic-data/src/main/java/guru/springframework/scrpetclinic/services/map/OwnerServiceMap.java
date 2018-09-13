package guru.springframework.scrpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.scrpetclinic.model.Owner;
import guru.springframework.scrpetclinic.services.CrudService;
import guru.springframework.scrpetclinic.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long>  implements OwnerService{

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner save(Owner object) {
		return super.save(object.getId(), object);
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
