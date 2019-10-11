package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.AreaDTO;
import com.repository.AreaRepository;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	AreaRepository areaRepo;
	  
  @Override
   public Optional<AreaDTO> findById(Integer id){
	   return areaRepo.findById(id);
   }
}
