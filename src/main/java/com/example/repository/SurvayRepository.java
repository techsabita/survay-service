package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Survay;

@Repository
public interface SurvayRepository  extends JpaRepository<Survay, Integer>{

	@Query("select s from Survay s where s.name= :name")
	Optional<Survay> findByName(@Param("name") String name);

}
