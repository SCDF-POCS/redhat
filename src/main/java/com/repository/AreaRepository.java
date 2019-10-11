package com.repository;

import java.util.Optional;

import com.dto.AreaDTO;

public interface AreaRepository {

	void persist(AreaDTO dto);

	Optional<AreaDTO> findById(Integer id);

}
