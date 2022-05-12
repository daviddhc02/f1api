package com.aiss.f1api.repositories;

import java.util.ArrayList;

import com.aiss.f1api.models.ConstructorModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructorRepository extends CrudRepository<ConstructorModel, Long>{

    public abstract ArrayList<ConstructorModel> findByYear(Integer year);
}