package com.aiss.f1api;

import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.aiss.f1api.models.ConstructorModel;
import com.aiss.f1api.models.DriverModel;
import com.aiss.f1api.repositories.ConstructorRepository;
import com.aiss.f1api.repositories.DriverRepository;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class DriverRepositoryTest {
    @Autowired
    private DriverRepository repo;
    @Test
	@Order(1)
	void testSaveDriver() {
		DriverModel Bustamante = new DriverModel(2L,"Bustamante", "Rumano", "Porsche", 40L, 2002);
		repo.save(Bustamante);
		assertEquals("Bustamante", Bustamante.getName());
	}
	@Test
	@Order(2)
	void testSaveDriver2() {
		DriverModel Jagger = new DriverModel(3L,"Jagger", "Español", "Xsara Picasso", 50L, 2002);
		repo.save(Jagger);
		assertEquals(2002, Jagger.getYear());
	}
	@Test
	@Order(3)
	void testUpdateDriver(){
		DriverModel Bustamante = repo.findById(1L).get();
		Bustamante.setCar("Ford Mondeo");	
		repo.save(Bustamante);
		DriverModel MiniUpdated= repo.findById(1L).get();
		assertEquals("Ford Mondeo", MiniUpdated.getCar());
	}
	@Test
	@Order(4)
	void testGetByYear(){
		Integer year=2002;
		ArrayList<DriverModel> Mini4 = repo.findByYear(year);
		assertEquals(1, Mini4.size());
	}
	@Test
	@Order(5)
	void testDeleteDriver(){
		DriverModel Mini3= repo.findById(1L).get();
		repo.deleteById(Mini3.getId());
		assertEquals(Optional.empty(), repo.findById(1L));
	}}
	
