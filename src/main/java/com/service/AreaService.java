package com.service;

import java.util.Optional;

import com.dto.AreaDTO;

public interface AreaService {


	Optional<AreaDTO> findById(Integer id);

}
