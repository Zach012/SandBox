package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JPAMappingTest {
	
	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	private WeaponRepository weaponRepo;
	
	@Resource
	private ItemRepository itemRepo;
	
	@Resource
	private MateriaRepository materiaRepo;
	
	@Test
	public void shouldSaveAndLoadItems() {
		Item item = itemRepo.save(new Item("item"));
		Long itemId = item.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Item> result = itemRepo.findById(itemId);
		item = result.get();
		assertThat(item.getName(), is("item"));
	}
	
	@Test
	public void shouldGenerateItemId() {
		Item item = itemRepo.save(new Item("item"));
		Long itemId = item.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		assertThat(itemId, is(greaterThan(0L)));
	}
	
	@Test
	public void shouldSaveAndLoadMateria() {
		Materia materia = materiaRepo.save(new Materia("materia"));
		Long materiaId = materia.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Materia> result = materiaRepo.findById(materiaId);
		materia = result.get();
		assertThat(materia.getName(), is("materia"));
	}
	
	@Test
	public void shouldSaveAndLoadWeapons() {
		Weapon weapon = new Weapon("weapon");
		weapon = weaponRepo.save(weapon);
		Long weaponId = weapon.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Weapon> result = weaponRepo.findById(weaponId);
		weapon = result.get();
		assertThat(weapon.getName(), is("weapon"));
	}
	
	@Test
	public void shouldEstablisWeaponToMateriaRelationship() {
		Materia materia = materiaRepo.save(new Materia("materia"));
		Materia anotherMateria = materiaRepo.save(new Materia("anotherMateria"));
		
		Weapon weapon = new Weapon("weapon");
		weapon = weaponRepo.save(weapon);
		Long weaponId = weapon.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Weapon> result = weaponRepo.findById(weaponId);
		weapon = result.get();
		
		assertThat(weapon.getMateria(), containsInAnyOrder(materia, anotherMateria));
	}

}
