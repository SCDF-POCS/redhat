package com.repository;

import java.awt.print.Book;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dto.AreaDTO;

@Service
public class AreaRepositoryImpl implements AreaRepository {

	@Override
	public void persist(final AreaDTO dto) {
	}
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	 @Override
	    public Optional<AreaDTO> findById(Integer id) {
		 System.out.println("id is *******************");
	        return jdbcTemplate.queryForObject(
	                "select * from Area where areaCode = ?",
	                new Object[]{id},
	                (rs, rowNum) ->
	                        Optional.of(new AreaDTO(
	                                rs.getInt("areaCode"),
	                                rs.getString("areaName"),
	                                rs.getInt("density")
	                        ))
	        );
	    }

}
