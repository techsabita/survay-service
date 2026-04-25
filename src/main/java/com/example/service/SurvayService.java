package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.SurvayDTO;
import com.example.entity.Survay;
import com.example.repository.SurvayRepository;

@Service
public class SurvayService {
	
	@Autowired
	private SurvayRepository survayRepository;

	public SurvayDTO create(SurvayDTO survayDTO) {
	Survay survay=new Survay();
	
	survay.setId(survayDTO.getId());
	survay.setName(survayDTO.getName());
	survay.setAge(survayDTO.getAge());
	survay.setAddress(survayDTO.getAddress());
	survayRepository.saveAndFlush(survay);
		
		return survayDTO;
	}

	public List<SurvayDTO> getAll() {
		
		List<SurvayDTO> survayDTOList=new ArrayList<SurvayDTO>();
		List<Survay> survayList=survayRepository.findAll();
		
		for(Survay survay:survayList) {
			
			SurvayDTO survayDTO=new SurvayDTO();
		
			survayDTO.setId(survay.getId());
			survayDTO.setName(survay.getName());
			survayDTO.setAge(survay.getAge());
			survayDTO.setAddress(survay.getAddress());
			 survayDTOList.add(survayDTO);
		}
		return survayDTOList;
	}

	public SurvayDTO getById(int id) {
		
		Optional<Survay> survay=survayRepository.findById(id);
		SurvayDTO survayDTO= new SurvayDTO();
		survayDTO.setId(survay.get().getId());
		survayDTO.setName(survay.get().getName());
		survayDTO.setAge(survay.get().getAge());
		survayDTO.setAddress(survay.get().getAddress());
		
		
		return survayDTO;
	}

	public SurvayDTO getByName(String name) {
		Optional<Survay> survay=survayRepository.findByName(name);
		SurvayDTO survayDTO=new SurvayDTO();
		survayDTO.setId(survay.get().getId());
		survayDTO.setName(survay.get().getName());
		survayDTO.setAge(survay.get().getAge());
		survayDTO.setAddress(survay.get().getAddress());
		return survayDTO;
	}

	public SurvayDTO deleteById(int id) {
		
		Optional<Survay> survay=survayRepository.findById(id);
		SurvayDTO survayDTO=new SurvayDTO();
		survayRepository.deleteById(survay.get().getId());
		return survayDTO;
	}

	public SurvayDTO update(SurvayDTO survayDTO) {
		Survay survay=new Survay();
		survay.setId(survayDTO.getId());
		survay.setName(survayDTO.getName());
		survay.setAge(survayDTO.getAge());
		survay.setAddress(survayDTO.getAddress());
		survayRepository.saveAndFlush(survay);
		return survayDTO;
	}
	

}
