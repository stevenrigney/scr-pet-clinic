package guru.springframework.scrpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.scrpetclinic.model.Owner;
import guru.springframework.scrpetclinic.model.Pet;
import guru.springframework.scrpetclinic.model.PetType;
import guru.springframework.scrpetclinic.model.Vet;
import guru.springframework.scrpetclinic.services.OwnerService;
import guru.springframework.scrpetclinic.services.PetTypeService;
import guru.springframework.scrpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}
	
	@Override
	public void run(String... args) throws Exception {

		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		dog.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("1231231234");
		
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Roscoe");

		owner1.getPets().add(mikesPet);
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("123 Brickerel");
		owner2.setCity("Miami");
		owner2.setTelephone("1231231234");
		
		Pet fisPet = new Pet();
		fisPet.setName("Just Cat");
		fisPet.setOwner(owner2);
		fisPet.setPetType(savedCatPetType);
		
		owner2.getPets().add(fisPet);
		
		ownerService.save(owner2);
		
		System.out.println("Loaded Owners....");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vetService.save(vet1);
		
		Vet vet2= new Vet();
		vet2.setFirstName("Jesie");
		vet2.setLastName("Porter");
		vetService.save(vet2);
		
		
		System.out.println("Loaded Vets....");
	}
	

}
