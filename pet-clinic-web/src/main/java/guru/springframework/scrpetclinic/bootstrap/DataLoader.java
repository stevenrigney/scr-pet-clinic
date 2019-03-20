package guru.springframework.scrpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.scrpetclinic.model.Owner;
import guru.springframework.scrpetclinic.model.Pet;
import guru.springframework.scrpetclinic.model.PetType;
import guru.springframework.scrpetclinic.model.Specialty;
import guru.springframework.scrpetclinic.model.Vet;
import guru.springframework.scrpetclinic.model.Visit;
import guru.springframework.scrpetclinic.services.OwnerService;
import guru.springframework.scrpetclinic.services.PetTypeService;
import guru.springframework.scrpetclinic.services.SpecialtyService;
import guru.springframework.scrpetclinic.services.VetService;
import guru.springframework.scrpetclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	private final VisitService visitService;
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService,
			VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}
	
	@Override
	public void run(String... args) throws Exception {

		int numberOfPetTypes = petTypeService.findAll().size();
		if( numberOfPetTypes == 0 ) {
			loadData();
		}
	}

	private void loadData() {
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
		
		Pet fionasCat = new Pet();
		fionasCat.setName("Just Cat");
		fionasCat.setOwner(owner2);
		fionasCat.setBirthDate(LocalDate.now());
		fionasCat.setPetType(savedCatPetType);
		owner2.getPets().add(fionasCat);
		
		ownerService.save(owner2);
		
		System.out.println("Loaded Owners....");

		Visit catVisit = new Visit();
		catVisit.setPet(fionasCat);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Sneezy Kitty");

		visitService.save(catVisit);
		
		Specialty radiology = new Specialty();
		radiology.setDescription("Radiology");
		Specialty surgery = new Specialty();
		surgery.setDescription("Surgery");
		Specialty dentistry = new Specialty();
		dentistry.setDescription("Dentistry");
		
		Specialty savedRadiology = specialtyService.save(radiology);
		Specialty savedSurgery = specialtyService.save(surgery);
		Specialty savedDentistry = specialtyService.save(dentistry);
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		
		vet1.getSpecialties().add(savedRadiology);
		vetService.save(vet1);
		
		Vet vet2= new Vet();
		vet2.setFirstName("Jesie");
		vet2.setLastName("Porter");
		
		vet2.getSpecialties().add(savedSurgery);
		vet2.getSpecialties().add(savedDentistry);
		vetService.save(vet2);
		
		
		System.out.println("Loaded Vets....");
	}
	

}
