package com.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AreaDTO;
import com.model.Area;
import com.service.AreaService;

/**
 * Handles requests for the Employee service.
 */
@RestController
//@RequestMapping("/api")
public class AreaController {
	
	private static final Logger logger = LoggerFactory.getLogger(AreaController.class);

	  @Autowired private AreaService areaService;

	
	 @RequestMapping(value = "/area/{id}", method = RequestMethod.POST)
	    public Area getArea(@PathVariable("id") String id) {

	        return new Area(11, "Sector 1");
	    }
	 
	
	  @RequestMapping(value = "/areaDetail/{id}", method = RequestMethod.GET)
	  public AreaDTO getArea(@PathVariable("id") Integer id) {
		  
		//   Optional<AreaDTO> a=areaService.findById( id) ;
		 
		//   System.out.println(a.get().getAreaName());

	      //  return new AreaDTO(id,a.get().getAreaName(), a.get().getDensity());
	        
	        return new AreaDTO(11, "Sector 1",111);
	  }
	  
	}
	 


