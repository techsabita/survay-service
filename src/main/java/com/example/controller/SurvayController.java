package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.SurvayDTO;
import com.example.service.SurvayService;

@RestController
@RequestMapping(value ="/survay" )
public class SurvayController {
	
	@Autowired
	private SurvayService survayService;
	
	@PostMapping
	public SurvayDTO create(@RequestBody SurvayDTO survayDTO) {
		return survayService.create(survayDTO);
		
	}
	@PutMapping
	public SurvayDTO update(@RequestBody SurvayDTO survayDTO) {
		return survayService.update(survayDTO);
	}
	@GetMapping
	public List<SurvayDTO> getAll(){
		return survayService.getAll();
		
	}
	@GetMapping("/{id}")
	public SurvayDTO getById(@PathVariable("id") int id ) {
		return survayService.getById(id);
	}
	@GetMapping("/get/{name}")
	public SurvayDTO getByName(@PathVariable("name") String name) {
		return survayService.getByName(name);
	}
	@DeleteMapping("/{id}")
	public SurvayDTO deleteById(@PathVariable("id") int id) {
		return survayService.deleteById(id);
	}

}
